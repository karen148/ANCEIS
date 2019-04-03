import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Write a description of class Demo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Demo
{
    public static void main (String[] args){
        System.out.println("Aqui creamos una instancia de Afiliados y agregamos 3 afiliados nuevos \n");
        Afiliaciones afiliaciones = new Afiliaciones();
        afiliaciones.registrarAfiliado("Daniel","220","daniel@correo.com","989998");
        afiliaciones.registrarAfiliado("Luisa","221","luisa@correo.com","110223");
        afiliaciones.registrarAfiliado("Camila","222","camila@correo.com","443755");
        afiliaciones.listarAfiliados();
        System.out.println("---------//------------//--------------//-------");
        System.out.println("Aqui le cambiamos el correo al estudiante Daniel, \n el telefono a Luisa y eliminamos a la estudiante Camila");
        afiliaciones.buscarAfiliado("220").setCorreo("daniel2018@correo.com");
        afiliaciones.buscarAfiliado("221").setTelefono("100423");
        afiliaciones.eliminarAfiliado("222");
        afiliaciones.listarAfiliados();
        System.out.println("---------//------------//--------------//-------");
        
        System.out.println("Aqui creamos una instancia de Cafeteria y agregamos 3 productos \n");
        Cafeteria cafeteria = new Cafeteria();
        cafeteria.registrarProducto("Galletas","123",500,700,20);
        cafeteria.registrarProducto("Mentas","124",70,100,50);
        cafeteria.registrarProducto("Detodito","125",1300,1700,18);
        cafeteria.registrarProducto("Papas Rizadas","126",700,1000,18);
        cafeteria.listarProductos();
        System.out.println("---------//------------//--------------//-------");
        System.out.println("Aqui le cambiamos el precio a las galletas, \n el nombre a las Papas y eliminamos el Mentas");
        cafeteria.buscarProducto("Galletas").setpventa(800);
        cafeteria.buscarProducto("Papas Rizadas").setNombre("Papa pobre");
        cafeteria.eliminarProducto("Mentas");
        cafeteria.listarProductos();
        System.out.println("---------//------------//--------------//-------");
       
        System.out.println("Aqui creamos una instancia de Cafeteria y agregamos 3 productos \n");
        Libreria libreria = new Libreria();
        libreria.registrarLibro("Libro azul","Juan","Cuarta","Planeta");
        libreria.registrarLibro("Libro rojo","Carlos","Quinta","Planeta");
        libreria.registrarLibro("Libro negro","Diego","Segunda","Planeta");
        libreria.listarLibros();
        System.out.println("---------//------------//--------------//-------");
        System.out.println("Aqui le cambiamos el nombre al Libro Azul, elminamos el Libro Rojo \n y solicitamos un prestamo con el Libro negro");
        libreria.consultarLibro("Libro azul").setTitulo("Libro verde");
        libreria.eliminarLibro("Libro rojo");
        libreria.solicitarPrestamo("221","Libro negro");
        libreria.listarLibros();
        libreria.consultarPrestamo("221","Libro negro");
        System.out.println("---------//------------//--------------//-------");
        WriterObject.guardar(cafeteria,afiliaciones,libreria);
        System.out.println("---------//------------//--------------//-------");
        System.out.println("Lista actualizada de cafeteria");
        cafeteria = ReadObject.leerCafeteria();
        cafeteria.listarProductos();
        System.out.println("---------//------------//--------------//-------");
        System.out.println("Lista actualizada de afiliaciones");
        afiliaciones = ReadObject.leerAfiliaciones();
        afiliaciones.listarAfiliados();
        System.out.println("---------//------------//--------------//-------");
        System.out.println("Lista actualizada de libreria");
        libreria = ReadObject.leerLibrerias();
        libreria.listarLibros();
    }
    
}
