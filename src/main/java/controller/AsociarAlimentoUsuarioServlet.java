package controller;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Alimento;
import model.AlimentoUsuario;
import model.Usuario;
import model.data.DBConnector;
import model.data.DBGenerator;
import model.data.dao.AlimentoDAO;
import model.data.dao.AlimentoUsuarioDAO;
import model.data.dao.UsuarioDAO;
import org.jooq.DSLContext;

@WebServlet(name = "asociarAlimentoUsuarioServlet", value = "/asociarAlimentoUsuario")
public class AsociarAlimentoUsuarioServlet extends HttpServlet {
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("MealPlanner");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/asociarAlimentoUsuario.jsp");
        respuesta.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneo.jsp");
        try {
            String nombre = req.getParameter("nombre");
            String rut = req.getParameter("rut");
            if (validarParametros(req) && validarAlimentoUsuario(req)) {
                String fechaString = req.getParameter("fecha");
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date fecha = null;
                Alimento alimento = (Alimento) AlimentoDAO.obtenerAlimento(DBGenerator.conectarBD("MealPlanner"),"nombre",nombre).get(0);
                Usuario usuario = (Usuario) UsuarioDAO.obtenerUsuario(DBGenerator.conectarBD("MealPlanner"),"rut",rut).get(0);
                try {
                    fecha = formatoFecha.parse(fechaString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                AlimentoUsuario alimentoUsuario = new AlimentoUsuario(nombre,alimento.getCalorias(), alimento.getGramos(), alimento.getProteinas(), alimento.getHidratosDeCarbono(), alimento.getAzucares(), alimento.getSodio(), alimento.getFibra(), alimento.isVegetariano(),fecha,usuario);
                if (agregarAlimentoUsuario(alimentoUsuario)) {
                    req.setAttribute("alimentoUsuario",alimentoUsuario);
                    respuesta = req.getRequestDispatcher("registroValidoAlimento.jsp");
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        respuesta.forward(req, resp);
    }

    private boolean validarParametros(HttpServletRequest req) {
        return req.getParameter("nombre") != null && req.getParameter("rut") != null;
    }
    private boolean validarAlimentoUsuario(HttpServletRequest req) throws ClassNotFoundException {
        for (Object alimento : AlimentoDAO.obtenerAlimentos(DBGenerator.conectarBD("MealPlanner"))) {
            if (((Alimento) alimento).getNombre().equals(req.getParameter("nombre"))) {
                return true;
            }
        }
        for (Object Usuario : UsuarioDAO.obtenerUsuarios(DBGenerator.conectarBD("MealPlanner"))) {
            if (((Usuario) Usuario).getRut().equals(req.getParameter("rut"))) {
                return true;
            }
        }
        return true;
    }

    private boolean agregarAlimentoUsuario(AlimentoUsuario alimentoUsuario) throws ClassNotFoundException {
        try {
            DSLContext query = DBGenerator.conectarBD("MealPlanner");
            AlimentoUsuarioDAO.agregarAlimentoUsuario(query, alimentoUsuario);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    }