package controller;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.mysql.cj.exceptions.DataReadException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Alimento;
import model.Usuario;
import model.data.DBGenerator;
import model.data.dao.AlimentoDAO;
import model.data.dao.UsuarioDAO;
import org.jooq.DSLContext;

import static com.mysql.cj.protocol.a.MysqlTextValueDecoder.getDate;

@WebServlet(name = "registroAlimentoServlet", value = "/registroAlimento")
public class RegistroAlimentoServlet extends HttpServlet {
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("MealPlanner");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroAlimento.jsp");
        respuesta.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneo.jsp");
        try {
            if (validarParametros(req) && validarDatos(req)) {
                String nombre = req.getParameter("nombre");
                double calorias = Double.parseDouble(req.getParameter("calorias"));
                double gramos = Double.parseDouble(req.getParameter("gramos"));
                double proteinas = Double.parseDouble(req.getParameter("proteinas"));
                double hidratosDeCarbono = Double.parseDouble(req.getParameter("hidratosDeCarbono"));
                double azucares = Double.parseDouble(req.getParameter("azucares"));
                double sodio = Double.parseDouble(req.getParameter("sodio"));
                double fibra = Double.parseDouble(req.getParameter("fibra"));
                boolean vegetariano = Boolean.parseBoolean(req.getParameter("vegetariano"));
                String fechaString = req.getParameter("fecha");
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date fecha = null;
                try {
                    fecha = formatoFecha.parse(fechaString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Alimento alimento = new Alimento(nombre,calorias, gramos, proteinas, hidratosDeCarbono, azucares, sodio, fibra, vegetariano,fecha);
                if (agregarAlimento(alimento)) {
                    req.setAttribute("alimento",alimento);
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
        return req.getParameter("nombre") != null && req.getParameter("calorias") != null &&
                req.getParameter("gramos") != null && req.getParameter("proteinas") != null &&
                req.getParameter("hidratosDeCarbono") != null && req.getParameter("azucares") != null &&
                req.getParameter("sodio") != null && req.getParameter("fibra") != null;
    }
    private boolean validarDatos(HttpServletRequest req) {
        try {
            double calorias = Double.parseDouble(req.getParameter("calorias"));
            double gramos = Double.parseDouble(req.getParameter("gramos"));
            double proteinas = Double.parseDouble(req.getParameter("proteinas"));
            double hidratosDeCarbono = Double.parseDouble(req.getParameter("hidratosDeCarbono"));
            double azucares = Double.parseDouble(req.getParameter("azucares"));
            double sodio = Double.parseDouble(req.getParameter("sodio"));
            double fibra = Double.parseDouble(req.getParameter("fibra"));
            if (calorias <= 0 || gramos <= 0 || proteinas < 0 || hidratosDeCarbono < 0 || azucares < 0 || sodio < 0 || fibra < 0) {
                return false;
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean agregarAlimento(Alimento alimento) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("MealPlanner");
        List<Alimento> alimentos = AlimentoDAO.obtenerAlimento(query, "nombre", alimento.getNombre());
        if (alimentos.size() != 0) {
            return false;
        } else {
            AlimentoDAO.agregarAlimento(query, alimento);
            return true;
        }
    }
}
