package model.data;

import org.jooq.DSLContext;
import org.jooq.DataType;
import org.jooq.impl.DSL;

import java.sql.Connection;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

public class DBGenerator {
    public static void iniciarBD(String nombreBD) throws ClassNotFoundException {
        Connection connection = DBConnector.connection("root","");
        DSLContext create = DSL.using(connection);
        crearBaseDato(create,nombreBD);
        create = actualizarConexion(connection,nombreBD);
        crearTablaUsuario(create);
        crearTablaAlimento(create);
        DBConnector.closeConnection();
    }
    public static DSLContext conectarBD(String nombre) throws ClassNotFoundException {
        Connection connection = DBConnector.connection(nombre,"root","");
        DSLContext create = DSL.using(connection);
        return create;
    }
    private static void crearBaseDato(DSLContext create, String nombreBD){
        create.createDatabaseIfNotExists(nombreBD).execute();
    }

    private static DSLContext actualizarConexion(Connection connection,String nombreBD){
        DBConnector.closeConnection();
        connection= DBConnector.connection(nombreBD,"root","");
        DSLContext create=DSL.using(connection);
        return create;
    }

    private static void crearTablaUsuario(DSLContext create){
        create.createTableIfNotExists("Usuario").column("rut",VARCHAR(50))
                .column("nombre",VARCHAR(100))
                .column("edad",INTEGER)
                .column("sexo",VARCHAR(50))
                .column("peso",INTEGER)
                .column("estatura",DOUBLE)
                .column("email",VARCHAR(100))
                .column("telefono",VARCHAR(50))
                .column("direccion",VARCHAR(100))
                .constraint(primaryKey("rut")).execute();
    }
    private static void crearTablaAlimento(DSLContext create){
        create.createTableIfNotExists("Alimento").column("nombre",VARCHAR(100))
                .column("calorias",DOUBLE)
                .column("gramos",DOUBLE)
                .column("proteinas",DOUBLE)
                .column("hidratosDeCarbono",DOUBLE)
                .column("azucares",DOUBLE)
                .column("sodio",DOUBLE)
                .column("fibra",DOUBLE)
                .column("vegetariano",BOOLEAN)
                .constraint(primaryKey("nombre")).execute();
    }
    private static void agregarColumnaTabla(DSLContext create, String nombreTabla, String columna, DataType tipoColumna){
        create.alterTableIfExists(nombreTabla).addColumn(columna,tipoColumna);
    }
}
