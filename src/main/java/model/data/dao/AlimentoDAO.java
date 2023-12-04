package model.data.dao;
import model.Alimento;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.jooq.impl.DSL.*;

public class AlimentoDAO {
    public static void agregarAlimento(DSLContext query, Alimento alimento){
        Table tablaAlimento= table(name("Alimento"));
        Field[] columnas = tablaAlimento.fields("nombre","calorias","gramos","proteinas","hidratosDeCarbono","azucares","sodio","fibra","vegetariano","fecha");
        query.insertInto(tablaAlimento, columnas[0], columnas[1],columnas[2],columnas[3],columnas[4],columnas[5],columnas[6],columnas[7],columnas[8],columnas[9])
                .values(alimento.getNombre(),alimento.getCalorias(),alimento.getGramos(),alimento.getProteinas(),alimento.getHidratosDeCarbono(),alimento.getAzucares(),alimento.getSodio(),alimento.getFibra(),alimento.isVegetariano(),alimento.getFecha())
                .execute();
    }

    public void modificarAlimento(DSLContext query, String rut, String columnaTabla, Object dato){
        query.update(DSL.table("Alimento")).set(DSL.field(columnaTabla),dato).
                where(DSL.field("nombre").eq(rut)).execute();
    }
    public static List obtenerAlimento(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Alimento")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaAlimentos(resultados);
    }
    public static List obtenerAlimentos(DSLContext query){
        Result resultados = query.select().from(table("Alimento")).fetch();
        return obtenerListaAlimentos(resultados);
    }
    public void eliminarAlimento(DSLContext query, String rut){
        Table tablaAlimento= table(name("Alimento"));
        query.delete(DSL.table("Alimento")).where(DSL.field("nombre").eq(rut)).execute();
    }
    private static List obtenerListaAlimentos(Result resultados){
        List<Alimento> alimentos= new ArrayList<>();
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
            alimentos.add(new Alimento(nombre,calorias,gramos,proteinas,hidratosDeCarbono,azucares,sodio,fibra,vegetariano,fecha));
        }
        return alimentos;
    }
    public static boolean validarExistenciaAlimento(DSLContext query,String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Alimento")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        if(resultados.size()>=1){
            return true;
        }
        else{
            return false;
        }
    }
}
