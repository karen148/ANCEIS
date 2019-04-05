
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
   public static Cafeteria cafeteria = new Cafeteria();
   public static Afiliaciones afiliaciones = new Afiliaciones();
   public static Libreria libreria = new Libreria();
   
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
        ObservableList<Producto> productos = FXCollections.observableArrayList(cafeteria.getProductos());
        return productos;
   }
   
   //Parar registrar el producto
   public static void registrarPro(String nombre,int preciocompra,int precioventa,int cantidad){
       cafeteria.registrarProducto(nombre,preciocompra,precioventa,cantidad);
       guardarBase();
   }
    
   //Para modificar la información del producto
   public static void modificarProducto(String nombre, int preciocompra, int precioventa, int cantidad){
       if(cafeteria.buscarProducto(nombre).equals(nombre)){
           cafeteria.buscarProducto(nombre).setNombre(nombre);
           cafeteria.buscarProducto(nombre).setCantidad(cantidad);
           cafeteria.buscarProducto(nombre).setpventa(precioventa);
           cafeteria.buscarProducto(nombre).setpcompra(preciocompra);
        }else{
            System.out.println("El producto no existe");
        }   
        guardarBase();
   }
   
   //Para eliminar producto
   public static void eliminarPro(String nombre){
       cafeteria.eliminarProducto(nombre);
       guardarBase();
    }
   
   //Registrar venta
   public static void registrarVen(String nombre, int cantidad){
       cafeteria.registrarVenta(nombre,cantidad);
       guardarBase();
    }
    
   //Registro de libreria
   public static void registrarLib(String titulo, String autor, String edicion, String editorial){
       libreria.registrarLibro(titulo,autor,edicion,editorial);
       guardarBase();
   }
    
   //Listar libros
   public static ObservableList<Libro> getLibreria(){
    ObservableList<Libro> libros = FXCollections.observableArrayList(libreria.getLibros());
    return libros;
   }

   //Eliminar libros
   public static void eliminarLib(String titulo){
       libreria.eliminarLibro(titulo);
       guardarBase();
    }
    
   // Solicitar prestamos
   public static void solicitarPres(String cod, String titulo){
       libreria.solicitarPrestamo(cod,titulo);
       guardarBase();
    }
    
   //Pagar multa
   public static void pagarMul(String cod, String titulo){
       libreria.pagarMulta(cod,titulo);
       guardarBase();
    }
    
   //Consultar prestamo
   public static void consultarPres(String cod, String titulo){
       libreria.consultarPrestamo(cod,titulo);
       guardarBase();
    }
    
   //Listar Prestamos
   public static ObservableList<Prestamo> getPrestamos(){
    ObservableList<Prestamo> prestamos = FXCollections.observableArrayList(libreria.getPrestamo());
    return prestamos;
   }
   
   //Registra afiliacion
   public static void registrarAfi(String nombre, String codigo, String correo, String telefono){
       afiliaciones.registrarAfiliado(nombre,codigo,correo,telefono);
       guardarBase();
    }
   
   // Listar Afiliados
   public static ObservableList<Afiliado> getAfiliados(){
    ObservableList<Afiliado> afiliados = FXCollections.observableArrayList(afiliaciones.getAfiliados());
    return afiliados;
   }
   
   //Eliminar afiliado
   public static void eliminarAfi(String cod){
       afiliaciones.eliminarAfiliado(cod);
       guardarBase();
    }
    
   //Consultar casillero
   public static void consultarAfi(){
       for (int i=0;i< Afiliaciones.casilleros.length;i++){
           if(Afiliaciones.casilleros[i] == null){
                System.out.println(i);
            }
        }
    }
    
}
