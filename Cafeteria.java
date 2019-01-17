import java.util.ArrayList;
/**
 * En cafeteria se va encontrar una lista de los productos con 
 * sus respectivos precios de venta.
 * 
 * @author (Chia Andres, Gonzalez Karen) 
 * @version (AINCEIS.v1)
 */
public class Cafeteria
{
    // instance variables - replace the example below with your own
    private ArrayList<Producto> productos;
    
    /**
     * Constructor for objects of class 
     */
    public Cafeteria()
    {
        productos = new ArrayList<Producto>();
    }

    /**
     * Encuentra y muestra el producto de acuerdo a la clave ingresada por el usuario.
     * @param  clave que va a ser buscada
     * @return El producto que es encontrado en la colección. 
     */
    public Producto BuscarProducto(String nombre)//String codigo, 
   {
        for(int i=0; i<productos.size(); i++)
        {
            //String aux1 = productos.get(i).getcodigo();
            String aux2 = productos.get(i).getnombre();
            int aux3 = productos.get(i).getcantidad();
            if(aux2.equals(nombre))
            {
                System.out.println(aux2+"-> cantidad: "+aux3+" precio de compra: ");
                return productos.get(i);
            }
            else
            {
                System.out.println("El producto no existe");
            }
        }
        return null;
    }
    
    /**
     * Registra un producto de acuerdo a los parametros que ingrese el usuario y lo guarda en la coleccion de productos.
     * @param  atributos del producto. 
     */
    public void RegistrarProducto(String nombre, String codigo, int preciocompra , int precioventa , int cantidad)
    {
        Producto nuevoproducto = new Producto(nombre, codigo, preciocompra, precioventa, cantidad);
        productos.add(nuevoproducto);
    }
    
    /**
     * Registra la venta de un producto y suma la ganancia de la venta al atributo 'ganancia' de la clase 'Ganancias'.
     * @param  Producto que va a ser vendido. 
     */
    public void RegistrarVenta(Producto producto){
    }
    /**
     * Elimina un producto de la coleccion de acuerdo a la clave que ingrese el usuario.
     * @param  Clave del producto que va a ser eliminado. 
     */
    public void EliminarProducto(String clave){
    }
    /**
     * Busca el producto en la coleccion de acuerdo a la clave que ingrese el usuario
     * y modifica sus atributos.
     * @param  Clave del producto que va a ser eliminado. 
     */
    public void EditarProducto(String clave){
    }
}
