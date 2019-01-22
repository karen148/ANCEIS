import java.util.ArrayList;
/**
 * La clase libro tiene como atributos el titulo, el autor, la edicion
 * y la editorial, los cuales son necesarios para clasificar el libro en el inventario.
 * Los objetos de esta clase son agregadas a una coleccion en la clase Libreria.
 * 
 * @author (Chia Andres,Gonzźlez Karen) 
 * @version (AINCeis.v0.1)
 */
public class Libro
{
    // instance variables - replace the example below with your own
    private String titulo;
    private String autor;
    private String edicion;
    private String editorial;
    private boolean estado;

    /**
     * Constructor for objects of class Libros
     */
    public Libro(String titulo, String autor, String edicion, String editorial)
    {
        // initialise instance variables
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.edicion = edicion;
        this.estado = true;
    }
    
    public boolean getEstado(){
        return estado;
    }
    public void setEstado(boolean estado){
        this.estado = estado;
    }
    
    public String getTitulo(){
        return titulo;
    }
}
