import java.util.ArrayList;
import java.io.Serializable;
/**
 * La clase libro tiene como atributos el titulo, el autor, la edicion
 * y la editorial, los cuales son necesarios para clasificar el libro en el inventario.
 * Los objetos de esta clase son agregadas a una coleccion en la clase Libreria.
 * 
 * @author (Chia Andres,Gonzźlez Karen) 
 * @version (AINCeis.v0.1)
 */
public class Libro implements Serializable
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
    
    public String toString(){
        return "Titulo" + titulo
                + "Autor" + autor
                + "Editorial" + editorial
                + "Edicion" + edicion;
    }
    
    public boolean getEstado(){
        return estado;
    }
    public void setEstado(boolean estado){
        this.estado = estado;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getAutor(){
        return autor;
    }
    public String getEdicion(){
        return edicion;
    }
    public String getEditorial(){
        return editorial;
    }
    
}
