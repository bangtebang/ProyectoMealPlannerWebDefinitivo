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

import static model.data.DBGenerator.iniciarBD;
import static model.data.dao.UsuarioDAO.agregarUsuario;

@WebServlet(name = "registroUsuarioServlet", value = "/registroUsuario")
public class RegistroUsuarioServlet extends HttpServlet {
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("UsuariosBD");
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
        if (req.getParameter("edad").length() != 0 && req.getParameter("nombre").length() != 0 &&
                req.getParameter("rut").length() != 0 && req.getParameter("sexo").length() != 0 && req.getParameter("peso").length() != 0 && req.getParameter("estatura").length() != 0 && req.getParameter("email").length() != 0 && req.getParameter("telefono").length() != 0 && req.getParameter("direccion").length() != 0) {
            String nombre = req.getParameter("nombre");
            int edad = Integer.parseInt(req.getParameter("edad"));
            String rut = req.getParameter("rut");
            String sexo = req.getParameter("sexo");
            double peso = Double.parseDouble(req.getParameter("peso"));
            double estatura = Double.parseDouble(req.getParameter("estatura"));
            String email = req.getParameter("email");
            String telefono = req.getParameter("telefono");
            String direccion = req.getParameter("direccion");
            Usuario usuario = new Usuario(nombre, edad, rut, sexo, peso, estatura, email, telefono, direccion);
            try {
                if (agregarUsuario(usuario)) {
                    req.setAttribute("usuario", usuario);
                    respuesta = req.getRequestDispatcher("registroValido.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req, resp);
    }

    private boolean agregarUsuario(Usuario usuario) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("UsuariosBD");
        List<Usuario> usuarios = UsuarioDAO.obtenerUsuario(query, "rut", usuario.getRut());
        if (usuarios.size() != 0) {
            return false;
        } else {
            UsuarioDAO.agregarUsuario(query, usuario);
            return true;
        }
    }
}