/*
 * Asignatura: Patrones de Diseño de Software 
 * Patròn Creacional - > Factory Method
 * DAO-> Data Access Object
 * Còdigo para configurar el acceso a las tablas de la Base de datos (Mysql/Postgresql)
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidades.articulos;
import patronfactorymethod.IntAdaptador;
import patronfactorymethod.FactoryBaseDatos;

/**
 *
 * @author Fabrizio Bolaño
 */
public class DAOarticulos {
     private IntAdaptador dbAdapter;
     
       
     public DAOarticulos(){
        dbAdapter = FactoryBaseDatos.getDefaultDBAdapter();
    }
     
    public List<articulos> findAllProducts(){
        Connection connection = dbAdapter.getConnection();
        List<articulos> productList = new ArrayList<>();
        try {
            PreparedStatement statement = connection
                    .prepareStatement("SELECT idarticulo ,nombrearticulo"
                            + ",valor FROM articulos");
            ResultSet results = statement.executeQuery();
            while(results.next()){
                productList.add(new articulos(results.getLong(1), 
                        results.getString(2), results.getDouble(3)));
            }
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            try {
                connection.close();
            } catch (Exception e) {}
        }
    }
    
    public boolean saveProduct(articulos articulo){
        Connection connection = dbAdapter.getConnection();
        try {
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO articulos(idarticulo,"
                            + "nombrearticulo,valor) VALUES (?,?,?)");
            statement.setLong(1, articulo.getIdarticulo());
            statement.setString(2, articulo.getNombrearticulo());
            statement.setDouble(3, articulo.getValor());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            try {
                connection.close();
            } catch (Exception e) {}
        }
    }
     
}