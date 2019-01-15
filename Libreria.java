import java.util.ArrayList;
/**
 * Guarda una coleccion de los libros.
 * Permite registrar un nuevo libro.
 * Guarda una coleccion de los prestamos.
 * Permite registrar un nuevo prestamo.
 * 
 * @author (Chia Andres,Gonzźlez Karen) 
 * @version (AINCeis.v0.1)
 */
public class Libreria
{
    // ArrayList que guarda todos los objetos de tipo Libro.
    private ArrayList<Libro> libros;
    private ArrayList<Prestamo> prestamos;
    /**
     * Constructor for objects of class Libreria
     */
    public Libreria()
    {
        // initialise instance variables
        libros = new ArrayList<Libro>();
        prestamos = new ArrayList<Prestamo>();
    }
    
    /**
     * Registra un libro con los atributos que ingrese el usuario y lo guarda en la coleccion 'libros'.
     * @param  atributos del libro. 
     */
    public void RegistrarLibro(String titulo, String autor, String edicion, String editorial){
        Libro nuevolibro = new Libro(titulo,autor,edicion,editorial);
        libros.add(nuevolibro);
  
    }
    /**
     * Encuentra el libro de acuerdo a la clave ingresada por el usuario.
     * @param  clave que va a ser buscada
     * @return El libro que es encontrado en la colección. 
     */
    public Libro ConsultarLibro(String clave){
        return null;
    }
    /**
     * Encuentra y elimina el libro de acuerdo a la clave ingresada por el usuario.
     * @param  clave que va a ser buscada 
     */
    public void EliminarLibro(String clave){
    
    }
    /**
     * Crea un prestamo y lo guarda en la coleccion 'prestamos'.
     * @param  afiliado que solicita el prestamo y libro que va a ser prestado. 
     */
    public void SolicitarPrestamo(Afiliado afiliado, Libro libro){
    
    }
    /**
     * Busca el prestamo que refiera a la clave ingresada por el usuario y lo renueva.
     * @param  afiliado que solicita el prestamo y libro que va a ser prestado. 
     */
    public void RenovarPrestamo(String claveprestamo){
    }
    
   
}
