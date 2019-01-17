
/**
 * La clase Producto tiene como atributos el nombre del producto, 
 * el precio de compra, el precio de venta y su cantidad los cuales 
 * son necesarios para clasificar el producto en el inventario.
 * Los objetos de esta clase son agregadas a una coleccion en la clase Cafeteria.
 * 
 * @author (Chia Andres,González Karen) 
 * @version (AINCeis.v0.1)
 */
public class Producto
{
    // instance variables - replace the example below with your own
    private String nombre;
    private String codigo;
    private int preciocompra;
    private int precioventa;
    private int cantidad;

    /**
     * Constructor for objects of class Producto
     */
    public Producto(String nombre, String codigo, int preciocompra , int precioventa , int cantidad)
    {
        this.nombre = nombre;
        this.preciocompra = preciocompra;
        this.precioventa = precioventa;
        this.cantidad = cantidad;
        this.codigo = codigo;
    }
   
    public void MandarAlerta(){
        if(cantidad == 0)
        {
            System.out.println("No hay producto");
        }
        else
        {
            System.out.println(nombre+":"+cantidad);
        }
    }
    
    public String getcodigo(){
        return codigo;
    }
    
    public int getcantidad(){
        return cantidad;
    }
    
    public String getnombre(){
        return nombre;
    }
}
