package model.data.dao;

import model.Alimento;
import model.AlimentoUsuario;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.jooq.impl.DSL.*;

public class AlimentoUsuarioDAO {
    public static void agregarAlimentoUsuario(DSLContext query, AlimentoUsuario alimentoUsuario){
        Table tablaAlimentoUsuario= table(name("AlimentoUsuario"));
        Field[] columnas = tablaAlimentoUsuario.fields("nombre","calorias","gramos","proteinas","hidratosDeCarbono","azucares","sodio","fibra","vegetariano","fecha", "rut");
        query.insertInto(tablaAlimentoUsuario, columnas[0], columnas[1],columnas[2],columnas[3],columnas[4],columnas[5],columnas[6],columnas[7],columnas[8],columnas[9], columnas[10])
                .values(alimentoUsuario.getNombre(),alimentoUsuario.getCalorias(),alimentoUsuario.getGramos(),alimentoUsuario.getProteinas(),alimentoUsuario.getHidratosDeCarbono(),alimentoUsuario.getAzucares(),alimentoUsuario.getSodio(),alimentoUsuario.getFibra(),alimentoUsuario.isVegetariano(),alimentoUsuario.getFecha(), alimentoUsuario.getUsuario().getRut())
                .execute();
    }
    public void modificarAlimento(DSLContext query, String rut, String columnaTabla, Object dato){
        query.update(DSL.table("AlimentoUsuario")).set(DSL.field(columnaTabla),dato).
                where(DSL.field("nombre").eq(rut)).execute();
    }
    public static List obtenerAlimento(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("AlimentoUsuario")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaAlimentosUsuarios(resultados);
    }
    public static List obtenerAlimentosUsuarios(DSLContext query){
        Result resultados = query.select().from(table("AlimentoUsuario")).fetch();
        return obtenerListaAlimentosUsuarios(resultados);
    }
    public void eliminarAlimentoUsuario(DSLContext query, String rut){
        Table tablaAlimento= table(name("AlimentoUsuario"));
        query.delete(DSL.table("AlimentoUsuario")).where(DSL.field("nombre").eq(rut)).execute();
    }
    private static List obtenerListaAlimentosUsuarios(Result resultados){
        List<AlimentoUsuario> alimentosUsuarios= new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            String nombre = (String) resultados.getValue(fila,"nombre");
            double calorias = (double) resultados.getValue(fila,"calorias");
            double gramos = (double) resultados.getValue(fila,"gramos");
            double proteinas = (double) resultados.getValue(fila,"proteinas");
            double hidratosDeCarbono = (double) resultados.getValue(fila,"hidratosDeCarbono");
            double azucares = (double) resultados.getValue(fila,"azucares");
            double sodio = (double) resultados.getValue(fila,"sodio");
            double fibra = (double) resultados.getValue(fila,"fibra");
            boolean vegetariano = (boolean) resultados.getValue(fila,"vegetariano");
            Date fecha = (Date) resultados.getValue(fila,"fecha");
            alimentosUsuarios.add(new AlimentoUsuario(nombre,calorias,gramos,proteinas,hidratosDeCarbono,azucares,sodio,fibra,vegetariano,fecha, null));
        }
        return alimentosUsuarios;
    }
    public static boolean validarExistenciaAlimentoUsuario(DSLContext query,String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("AlimentoUsuario")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        if(resultados.size()>=1){
            return true;
        }
        else{
            return false;
        }
    }
}
