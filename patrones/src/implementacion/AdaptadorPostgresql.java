/*
 * Asignatura: Patrones de Diseño de Software 
 * Patròn Creacional - > Factory Method
 */
package implementacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

import patronfactorymethod.IntAdaptador;
import utilidades.UtilidadesAcceso;
/**
 *
 * @author Fabrizio Bolaño
 */
public class AdaptadorPostgresql implements IntAdaptador {

    private static final String DB_PROPERTIES = "Propiedades/DatosPOstgresql.properties";

    private static final String DB_SERVICE_PROP = "";
    private static final String DB_HOST_PROP = "dpg-cuha7fbqf0us739c3r40-a.oregon-postgres.render.com";
    private static final String DB_PASSWORD_PROP = "QNZkT7dkRVCdyva6hqKaJhkA8qkCCiFl";
    private static final String DB_PORT_PROP = "5432";
    private static final String DB_USER_PROP = "patrones_yb3x_user";
    
    static {
        //Bloque para registrar el Driver de Oracle
        try {
             Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Connection getConnection() {
        try {
            Properties prop = UtilidadesAcceso.loadProperty(DB_PROPERTIES);
            String user = prop.getProperty(DB_USER_PROP);
        String password = prop.getProperty(DB_PASSWORD_PROP);
            String connectionString = createConnectionString();
            Connection connection = DriverManager.getConnection(connectionString,user,password);
            System.out.println("Connection class ==> " + connection.getClass().getName());
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    private String createConnectionString() {
        Properties prop = UtilidadesAcceso.loadProperty(DB_PROPERTIES);
        String host = prop.getProperty(DB_HOST_PROP);
        String port = prop.getProperty(DB_PORT_PROP);
        String service = prop.getProperty(DB_SERVICE_PROP);
        String user = prop.getProperty(DB_USER_PROP);
        String password = prop.getProperty(DB_PASSWORD_PROP);

        String connectionString = "jdbc:postgresql://"+host+":"+port+"/"+service;
        System.out.println("ConnectionString ==> " + connectionString);
        return connectionString;
    }
    
    
}


