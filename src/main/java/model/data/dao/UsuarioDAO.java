package model.data.dao;

import model.Usuario;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;

public class UsuarioDAO {
    public static void agregarUsuario(DSLContext query, Usuario usuario){
        Table tablaUsuario= table(name("Usuario"));
        Field[] columnas = tablaUsuario.fields("rut","nombre","edad","sexo","peso","estatura","email","telefono","direccion");
        query.insertInto(tablaUsuario, columnas[0], columnas[1],columnas[2],columnas[3],columnas[4],columnas[5],columnas[6],columnas[7],columnas[8])
                .values(usuario.getRut(),usuario.getNombre(),usuario.getEdad(),usuario.getSexo(),usuario.getPeso(),usuario.getEstatura(),usuario.getEmail(),usuario.getTelefono(),usuario.getDireccion())
                .execute();
    }

    public void modificarUsuario(DSLContext query, String rut, String columnaTabla, Object dato){
        query.update(DSL.table("Usuario")).set(DSL.field(columnaTabla),dato).
                where(DSL.field("rut").eq(rut)).execute();
    }
    public static List obtenerUsuario(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Usuario")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaUsarios(resultados);
    }
    public static List obtenerUsuarios(DSLContext query){
        Result resultados = query.select().from(table("Usuario")).fetch();
        return obtenerListaUsarios(resultados);
    }
    public void eliminarUsuario(DSLContext query, String rut){
        Table tablaUsuario= table(name("Usuario"));
        query.delete(DSL.table("Usuario")).where(DSL.field("rut").eq(rut)).execute();
    }
    public static Usuario buscarUsuario(DSLContext query, Object dato){
        Result resultados= (Result) buscarUsuario(query,"rut");
        String rut = (String) resultados.getValue(0,"rut");
        String nombre = (String) resultados.getValue(0,"nombre");
        int edad = (int) resultados.getValue(0,"edad");
        String sexo = (String) resultados.getValue(0,"sexo");
        int peso = (int) resultados.getValue(0,"peso");
        double estatura = (double) resultados.getValue(0,"estatura");
        String email = (String) resultados.getValue(0,"email");
        String telefono = (String) resultados.getValue(0,"telefono");
        String direccion = (String) resultados.getValue(0,"direccion");
        return new Usuario(nombre,edad,rut,sexo,peso,estatura,email,telefono,direccion);
    }

    private static List obtenerListaUsarios(Result resultados){
        List<Usuario> usuarios= new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            String rut = (String) resultados.getValue(fila,"rut");
            String nombre = (String) resultados.getValue(fila,"nombre");
            int edad = (int) resultados.getValue(fila,"edad");
            String sexo = (String) resultados.getValue(fila,"sexo");
            int peso = (int) resultados.getValue(fila,"peso");
            double estatura = (double) resultados.getValue(fila,"estatura");
            String email = (String) resultados.getValue(fila,"email");
            String telefono = (String) resultados.getValue(fila,"telefono");
            String direccion = (String) resultados.getValue(fila,"direccion");
            usuarios.add(new Usuario(nombre,edad,rut,sexo,peso,estatura,email,telefono,direccion));
        }
        return usuarios;
    }
    private static String[][] exportardatos(Result resultados){
        String[][] datosResultado=new String[resultados.size()][4];
        for(int registro = 0; registro < resultados.size(); registro ++){
            datosResultado[registro][0] = (String) resultados.getValue(registro,"nombre");
            datosResultado[registro][1] = (String) resultados.getValue(registro,"edad");
        }
        return datosResultado;
    }
    public static boolean validarExistenciaUsuario(DSLContext query,String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Usuario")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        if(resultados.size()>=1){
            return true;
        }
        else{
            return false;
        }
    }
}
