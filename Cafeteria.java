/**
 * En cafeteria se va encontrar una lista de los productos con 
 * sus respectivos precios de venta.
 * 
 * @author (Chia Andres, Gonzalez Karen) 
 * @version (AINCEIS.v1)
 */
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;
public class Cafeteria implements Serializable
{
    // instance variables - replace the example below with your own
    public static ArrayList<Producto> productos = new ArrayList<Producto>();  ;
    
    /**
     * Constructor for objects of class 
     */
    public Cafeteria()
    {
       productos.add(new Producto("Glletas", "Glletas", 10, 10, 10));
       productos.add(new Producto("Glletas1", "Glletas", 10, 10, 10));
       productos.add(new Producto("Glletas2", "Glletas", 10, 10, 10));
       productos.add(new Producto("Glletas3", "Glletas", 10, 10, 10));
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
            String aux2 = productos.get(i).getNombre();
            int cant = productos.get(i).getCantidad();
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
    
    public Producto buscarProducto(String nombre){
        for(Producto p : productos){
            String aux = p.getNombre();
            if(aux.equals(nombre))
            {
                return p;
            }
        }
        return null;
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
        Producto prod = buscarProducto(nombre);
        prod.setCantidad(-cantidad);
        Ganancias.SumarGanancia(prod.getpventa());
    }
    /**
     * Elimina un producto de la coleccion de acuerdo a la clave que ingrese el usuario.
     * @param  Clave del producto que va a ser eliminado. 
     */
    public void eliminarProducto(String nombre){
        Producto p = buscarProducto(nombre);
        if(p != null){
            int index = productos.indexOf(p);
            productos.remove(index);
            System.out.println("el producto fue eliminado correctamente");
        }
       else{
           System.out.println("el producto no existe");
        }
    }
    
    public void listarProductos(){
        for(Producto pd : productos){
           imprimirProducto(pd);
        }
   
    }
    
    public void imprimirProducto(Producto pd){
        System.out.println("Nombre: "+pd.getNombre());
        System.out.println("Codigo: "+pd.getCodigo());
        System.out.println("Precio compra: "+pd.getpcompra());
        System.out.println("Precio venta: "+pd.getpventa());
        System.out.println("Cantidad: "+pd.getCantidad());
        System.out.println("\n");
    }
    
    /**
     * Busca el producto en la coleccion de acuerdo a la clave que ingrese el usuario
     * y modifica sus atributos.
     * @param  Clave del producto que va a ser eliminado. 
     */
    /*public void EditarProducto(String nomb){
        Producto prod = buscarProducto(nomb);
        int index = productos.indexOf(prod);
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Codigo: ");
        String codigo = sc.next();
        System.out.print("Nombre: ");
        String nombre = sc.next();
        System.out.print("Precio compra: ");
        int pcompra = sc.nextInt();
        System.out.print("Precio venta: ");
        int pventa = sc.nextInt();
        System.out.print("Cantidad: ");
        int cant = sc.nextInt();
        
        productos.get(index).setcodigo(codigo);
        productos.get(index).setnombre(nombre);
        productos.get(index).setpcompra(pcompra);
        productos.get(index).setpventa(pventa);
        productos.get(index).editcantidad(cant);
        System.out.println("El producto fue editado correctamente");
    }*/
}
