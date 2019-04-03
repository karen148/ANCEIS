
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
   public static ObservableList<Producto> getProduct(){
        ObservableList<Producto> productos = FXCollections.observableArrayList();
        for(Producto p : Cafeteria.productos){
            System.out.println("Hola");
            productos.add(p);
        }
        return productos;
   }
}
