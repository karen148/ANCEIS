
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
   public static ObservableList<Producto> getProductos(){
        ObservableList<Producto> productos = FXCollections.observableArrayList(Cafeteria.productos);
        System.out.println();
        productos.add(new Producto("Hola","Hola",500,500,500));
        return productos;
   }
}
