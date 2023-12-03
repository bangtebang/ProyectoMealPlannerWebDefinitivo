package controller;
import java.io.*;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Usuario;
import model.data.DBGenerator;
import model.data.dao.UsuarioDAO;
import org.jooq.DSLContext;

@WebServlet(name = "registroUsuarioServlet", value = "/registroUsuario")
public class RegistroUsuarioServlet extends HttpServlet {
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("MealPlannerBD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroUsuario.jsp");
        respuesta.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneo.jsp");

        try {
            if (validarParametros(req) && validarDatos(req)) {
                String nombre = req.getParameter("nombre");
                int edad = Integer.parseInt(req.getParameter("edad"));
                String rut = req.getParameter("rut");
                String sexo = req.getParameter("sexo");
                int peso = Integer.parseInt(req.getParameter("peso"));
                double estatura = Double.parseDouble(req.getParameter("estatura"));
                String email = req.getParameter("email");
                String telefono = req.getParameter("telefono");
                String direccion = req.getParameter("direccion");

                Usuario usuario = new Usuario(nombre, edad, rut, sexo, peso, estatura, email, telefono, direccion);

                if (agregarUsuario(usuario)) {
                    req.setAttribute("usuario", usuario);
                    respuesta = req.getRequestDispatcher("registroValido.jsp");
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
        return req.getParameter("edad") != null && req.getParameter("nombre") != null &&
                req.getParameter("rut") != null && req.getParameter("sexo") != null &&
                req.getParameter("peso") != null && req.getParameter("estatura") != null &&
                req.getParameter("email") != null && req.getParameter("telefono") != null &&
                req.getParameter("direccion") != null;
    }
    private boolean validarDatos(HttpServletRequest req) {
        try {
            int edad = Integer.parseInt(req.getParameter("edad"));
            double peso = Double.parseDouble(req.getParameter("peso"));
            double estatura = Double.parseDouble(req.getParameter("estatura"));
            if (edad <= 0 || peso <= 0 || estatura <= 0) {
                return false;
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private boolean agregarUsuario(Usuario usuario) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("MealPlannerBD");
        List<Usuario> usuarios = UsuarioDAO.obtenerUsuario(query, "rut", usuario.getRut());
        if (usuarios.size() != 0) {
            return false;
        } else {
            UsuarioDAO.agregarUsuario(query, usuario);
            return true;
        }
    }
}