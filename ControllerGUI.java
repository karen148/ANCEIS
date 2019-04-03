
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
 
   public static void guardarBase(){
       WriterObject.guardar(cafeteria,afiliaciones,libreria);
   }
   
   public static void leerBase(){
      cafeteria = ReadObject.leerCafeteria(); 
      afiliaciones = ReadObject.leerAfiliaciones(); 
      libreria = ReadObject.leerLibrerias();
   }
     
   //Para mostrar los datos de los productos en la tabla 
   public static ObservableList<Producto> getProductos(){
        ObservableList<Producto> productos = FXCollections.observableArrayList(Cafeteria.productos);
        return productos;
   }
   
   //Parar registrar el producto
   public static void registrarPro(String nombre,int preciocompra,int precioventa,int cantidad){
       Cafeteria.registrarProducto(nombre,preciocompra,precioventa,cantidad);
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
   
   //Registrar venta
   public static void registrarVen(String nombre, int cantidad){
       Cafeteria.registrarVenta(nombre,cantidad);
    }
    
   //Registro de libreria
   public static void registrarLib(String titulo, String autor, String edicion, String editorial){
       Libreria.registrarLibro(titulo,autor,edicion,editorial);
    }
    
   //Listar libros
   public static ObservableList<Libro> getLibreria(){
    ObservableList<Libro> libros = FXCollections.observableArrayList(Libreria.libros);
    return libros;
   }

   //Eliminar libros
   public static void eliminarLib(String titulo){
       Libreria.eliminarLibro(titulo);
    }
    
   // Solicitar prestamos
   public static void solicitarPres(String cod, String titulo){
       Libreria.solicitarPrestamo(cod,titulo);
    }
    
   //Pagar multa
   public static void pagarMul(String cod, String titulo){
       Libreria.pagarMulta(cod,titulo);
    }
    
   //Consultar prestamo
   public static void consultarPres(String cod, String titulo){
       Libreria.consultarPrestamo(cod,titulo);
    }
    
   //Listar Prestamos
   public static ObservableList<Prestamo> getPrestamos(){
    ObservableList<Prestamo> prestamos = FXCollections.observableArrayList(Libreria.prestamos);
    return prestamos;
   }
   
   //Registra afiliacion
   public static void registrarAfi(String nombre, String codigo, String correo, String telefono){
       Afiliaciones.registrarAfiliado(nombre,codigo,correo,telefono);
    }
   
   // Listar Afiliados
   public static ObservableList<Afiliado> getAfiliados(){
    ObservableList<Afiliado> afiliados = FXCollections.observableArrayList(Afiliaciones.afiliados);
    return afiliados;
   }
}
