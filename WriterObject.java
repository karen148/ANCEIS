import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Write a description of class WriterObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WriterObject
{
   public static void guardar(Cafeteria cafeteria, Afiliaciones afiliaciones, Libreria libreria){
       guardarCafeteria(cafeteria);
       guardarAfiliado(afiliaciones);
       guardarLireria(libreria);
   }
   
   private static void guardarCafeteria(Cafeteria cafeteria){
     try {
           FileOutputStream fos = new FileOutputStream("cafeteria.obj",false);
           ObjectOutputStream oos = new ObjectOutputStream( fos );
           oos.writeObject(cafeteria); 
           System.out.println("Exito writing");
           oos.close();
       }
       catch(Exception e){
           System.out.println("El registro de cafeteria no se ha completado");
       } 
   }
    
    
   
   private static void guardarAfiliado(Afiliaciones afiliaciones){
      try {
           FileOutputStream fos = new FileOutputStream("afiliaciones.obj",false);
           ObjectOutputStream oos = new ObjectOutputStream( fos );
           oos.writeObject(afiliaciones); 
           System.out.println("Exito writing");
           oos.close();
       }
       catch(Exception e){
           System.out.println("El registro de afiliaciones no se ha completado");
       } 
   }
   
   private static void guardarLireria(Libreria libreria){
      try {
           FileOutputStream fos = new FileOutputStream("libreria.obj",false);
           ObjectOutputStream oos = new ObjectOutputStream( fos );
           oos.writeObject(libreria); 
           System.out.println("Exito writing");
           oos.close();
       }
       catch(Exception e){
           System.out.println("El registro de libreria no se ha completado");
       }
   }
}
