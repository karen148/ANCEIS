
import java.util.Calendar;


/**
 * La clase prestamo relaciona al afiliado que solicita
 * el prestamo y el libro que fue prestado de manera que 
 * guarda un objeto de tipo libro y un objeto de tipo afiliado
 * 
 * 
 * @author (Chia Andres, Gonzalez Karen) 
 * @version (AINCeis.v1)
 */
public class Prestamo
{
    // instance variables - replace the example below with your own
    private Libro libro;
    private Afiliado afiliado;
    private String dia;
    private String mes;
    private String año;

    /**
     * Constructor para la clase Prestamo
     * 
     */
    public Prestamo(Afiliado afiliado, Libro libro)
    {
        // initialise instance variables
        this.afiliado = afiliado;
        this.libro = libro;
        Calendar c1 = Calendar.getInstance();
        dia = Integer.toString(c1.get(Calendar.DATE));
        mes = Integer.toString(c1.get(Calendar.MONTH));
        año = Integer.toString(c1.get(Calendar.YEAR));
    }
    /**
     * Modifica las fechas del prestamo de modo que aumente su plazo de entrega. 
     */
    public void renovar(){
    }
    
    public Afiliado getAfiliado(){
        return afiliado;
    }
    
    public Libro getLibro(){
        return libro;
    }
}
