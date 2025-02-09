/*
 * Asignatura: Patrones de Diseño de Software 
 * Patròn Creacional - > Factory Method
 * Clase para el Mapeo de la tabla de Articulos de la BD (Mysql / Postgres)
 */
package entidades;

/**
 *
 * @author Fabrizio Bolaño
 */
public class articulos {
    private Long idarticulo;
    private String nombrearticulo;
    private double valor;

     public articulos(Long idarticulo, String nombrearticulo, double valor) {
        this.idarticulo = idarticulo;
        this.nombrearticulo = nombrearticulo;
        this.valor = valor;
    }
     
    public articulos() {
    }

    
    public Long getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(Long idarticulo) {
        this.idarticulo = idarticulo;
    }

    public String getNombrearticulo() {
        return nombrearticulo;
    }

    public void setNombrearticulo(String nombrearticulo) {
        this.nombrearticulo = nombrearticulo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return "Articulo{" + "idarticulo=" + idarticulo + ", nombrearticulo=" + nombrearticulo + ", valor=" + valor + '}';
    }
}
