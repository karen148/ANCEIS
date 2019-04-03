
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
    
   public static ObservableList<Producto> getProductos(){
        ObservableList<Producto> productos = FXCollections.observableArrayList(Cafeteria.productos);
        return productos;
   }
}
