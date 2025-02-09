/*
 * Asignatura: Patrones de Diseño de Software 
 * Patròn Creacional - > Factory Method
 * Tipo de Archivo: Interface
 */
package patronfactorymethod;

import java.sql.Connection;

/**
 *
 * @author Fabrizio Bolaño
 */
public interface IntAdaptador {
    public Connection getConnection();
}
