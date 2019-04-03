import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Write a description of class ReadObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ReadObject
{
    // instance variables - replace the example below with your ow
    
  public static Cafeteria leerCafeteria(){
     Cafeteria cafeteria = null;
        try{ 
           FileInputStream fis = new FileInputStream( "cafeteria.obj" );
           ObjectInputStream ois = new ObjectInputStream( fis );
           try{
              cafeteria = (Cafeteria)ois.readObject();
            }
           catch(Exception e)
           {e.printStackTrace();}
          }
       catch(Exception e){
           e.printStackTrace();
        }  
     return cafeteria;
 }

 public static Afiliaciones leerAfiliaciones(){
   Afiliaciones afiliacion = null;
    try{ 
       FileInputStream fis = new FileInputStream( "afiliaciones.obj" );
       ObjectInputStream ois = new ObjectInputStream( fis );
       try{
          afiliacion = (Afiliaciones)ois.readObject();
        }
       catch(Exception e)
       {e.printStackTrace();}
      }
      catch(Exception e){
       e.printStackTrace();
   }  
  return afiliacion;
 }

 public static Libreria leerLibrerias(){
  Libreria libreria = null;
    try{ 
       FileInputStream fis = new FileInputStream( "libreria.obj" );
       ObjectInputStream ois = new ObjectInputStream( fis );
       try{
          libreria = (Libreria)ois.readObject();
        }
       catch(Exception e)
       {e.printStackTrace();}
      }
   catch(Exception e){
       e.printStackTrace();
   }  
  return libreria;
  }
}


