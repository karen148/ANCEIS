
/**
 * Write a description of class ControllerGUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class ControllerGUI
{
   public static Cafeteria cafeteria = ReadObject.leerCafeteria();
   public static Afiliaciones afiliaciones = ReadObject.leerAfiliaciones();
   public static Libreria libreria = ReadObject.leerLibrerias();
   
   
   public static void leerBase(){
      cafeteria = ReadObject.leerCafeteria(); 
      afiliaciones = ReadObject.leerAfiliaciones(); 
      libreria = ReadObject.leerLibrerias();
   }
    
   public static void guardarBase(){
       WriterObject.guardar(cafeteria,afiliaciones,libreria);
   }
    
   //Para mostrar los datos de los productos en la tabla 
   public static ObservableList<Producto> getProductos(){
        ObservableList<Producto> productos = FXCollections.observableArrayList(Cafeteria.productos);
        return productos;
   }
   
   //Parar registrar el producto
   public static void registrarPro(String nombre,int preciocompra,int precioventa,int cantidad){
       Cafeteria.registrarProducto(nombre,cantidad,preciocompra,precioventa);
   }
    
   //Para modificar la información del producto
   public static void modificarProducto(String nombre, int preciocompra, int precioventa, int cantidad){
       if(Cafeteria.buscarProducto(nombre).equals(nombre)){
           Cafeteria.buscarProducto(nombre).setNombre(nombre);
           Cafeteria.buscarProducto(nombre).setCantidad(cantidad);
           Cafeteria.buscarProducto(nombre).setpventa(precioventa);
           Cafeteria.buscarProducto(nombre).setpcompra(preciocompra);
        }else{
            System.out.println("El producto no existe");
        }   
   }
   
   //Para eliminar producto
   public static void eliminarPro(String nombre){
       Cafeteria.eliminarProducto(nombre);
    }
   
   public static 
    
   //Registro de libreria
   public static void registrarLib(String titulo, String autor, String edicion, String editorial){
       Libreria.registrarLibro(titulo,autor,edicion,editorial);
    }
}
