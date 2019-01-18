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
    public void consultarProducto(String nombre)//String codigo, 
   {
       if(productos.size()!=0){
        for(int i=0; i<productos.size(); i++)
        {
            //String aux1 = productos.get(i).getcodigo();
            String aux2 = productos.get(i).getnombre();
            int cant = productos.get(i).getcantidad();
            int pcompra = productos.get(i).getpcompra();
            int pventa = productos.get(i).getpventa();
            if(aux2.equals(nombre))
            {
                System.out.println(aux2);
                System.out.println("Cantidad: "+ cant);
                System.out.println("Precio compra: "+ pcompra);
                System.out.println("Precio venta: "+ pventa);
            }
            else
            {
                System.out.println("El producto no existe");
            }
        }
     }
     else{
         System.out.println("No hay productos en cafeteria");
     }
     
    }
   public int buscarProducto(String nombre){
        for(int i=0; i<productos.size(); i++)
        {
            //String aux1 = productos.get(i).getcodigo();
            String aux2 = productos.get(i).getnombre();
            int cant = productos.get(i).getcantidad();
            int pcompra = productos.get(i).getpcompra();
            int pventa = productos.get(i).getpventa();
            if(aux2.equals(nombre))
            {
                return i;
            }
        }
        return 9999;
   }
    
    
   /**
     * Registra un producto de acuerdo a los parametros que ingrese el usuario y lo guarda en la coleccion de productos.
     * @param  atributos del producto. 
     */
   public void registrarProducto(String nombre, String codigo, int preciocompra , int precioventa , int cantidad){
        Producto nuevoproducto = new Producto(nombre, codigo, preciocompra, precioventa, cantidad);
        productos.add(nuevoproducto);
   }
   
    /**
     * Registra la venta de un producto y suma la ganancia de la venta al atributo 'ganancia' de la clase 'Ganancias'.
     * @param  Producto que va a ser vendido. 
     */
    public void registrarVenta(String nombre, int cantidad){
        Producto prod = productos.get(buscarProducto(nombre));
        prod.setcantidad(-cantidad);
    }
    /**
     * Elimina un producto de la coleccion de acuerdo a la clave que ingrese el usuario.
     * @param  Clave del producto que va a ser eliminado. 
     */
    public void eliminarProducto(String nombre){
        int index = buscarProducto(nombre);
        if(index != 9999){
        productos.remove(index);
        System.out.println("el producto fue eliminado correctamente");
        }
       else{
           System.out.println("el producto no existe");
        }
    }
    /**
     * Busca el producto en la coleccion de acuerdo a la clave que ingrese el usuario
     * y modifica sus atributos.
     * @param  Clave del producto que va a ser eliminado. 
     */
    public void EditarProducto(String clave){
    }
}
