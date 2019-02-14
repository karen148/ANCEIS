
/**
 * En la clase Afiliado se registra los datos de la personas que se van afiliar al 
 * CEIS.
 * 
 * @author (Chia Andres,González Karen) 
 * @version (AINCeis.v1)
 */
public class Afiliado
{
    // instance variables - replace the example below with your own
    private String nombre;
    private String codigo;
    private String correo;
    private String telefono;

    /**
     * Constructor for objects of class Afiliado
     */
    public Afiliado(String nombre, String codigo, String correo, String telefono){
        this.nombre = nombre;
        this.codigo = codigo;
        this.correo = correo;
        this.telefono = telefono;
    }
    public String getCodigo(){
        return codigo;
    }
    public String getNombre(){
        return nombre;
    }
    public String getCorreo(){
        return correo;
    }
    public String getTelefono(){
        return telefono;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

 }
