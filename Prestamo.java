import java.io.Serializable;
import java.util.Date;


/**
 * La clase prestamo relaciona al afiliado que solicita
 * el prestamo y el libro que fue prestado de manera que 
 * guarda un objeto de tipo libro y un objeto de tipo afiliado
 * 
 * 
 * @author (Chia Andres, Gonzalez Karen) 
 * @version (AINCeis.v1)
 */
public class Prestamo implements Serializable
{
    // instance variables - replace the example below with your own
    private Libro libro;
    private Afiliado afiliado;
    private Date fechaprestamo;
    private int multa;
    /**
     * Constructor para la clase Prestamo
     * 
     */
    public Prestamo(Afiliado afiliado, Libro libro)
    {
        // initialise instance variables
        this.afiliado = afiliado;
        this.libro = libro;
        fechaprestamo = new Date();
        multa = 0;
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
    
    
    /** 
     * El metodo se ejecuta al iniciar el programa.
    **/
    public void checkmulta(){
        Date fechaactual = new Date();
        int diferencia =(int) ((fechaactual.getTime()-fechaprestamo.getTime())/86400000);
        if(diferencia >= 15){
            sumarmulta(1000);
        }
    }
    
    public Date getFecha(){
        return fechaprestamo;
    }
    
    public void sumarmulta(int multa){
        this.multa += multa;
    }
    public int getMulta(){
        return multa;
    }
    public void setmulta(int multa){
        this.multa=multa;
    }
    public void pagarmulta(){
       setmulta(0);
    }
}
