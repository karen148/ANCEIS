import java.util.ArrayList;
/**
 * Guarda una coleccion de los afiliados al CEIS.
 * Permite registrar un nuevo afiliado y agregarlo a la coleccion.
 * Permitir eliminar un afiliado.
 * @author (Chia Andres, Gonzalez Karen) 
 * @version (AINCeis.v1)
 */
public class Afiliaciones
{
    // instance variables - replace the example below with your own
    private ArrayList<Afiliado> afiliados;
    /**
     * Constructor for objects of class Afiliaciones
     */
    public Afiliaciones()
    {
        // initialise instance variables
        afiliados = new ArrayList<Afiliado>();
    }
    /**
     * Registra un afiliado con los atributos que ingrese el usuario y lo guarda en la coleccion 'afiliados'.
     * @param  atributos del afiliado. 
     */
    public void registrarAfiliado(String nombre, String codigo, String correo, String telefono){
        Afiliado nuevoafiliado = new Afiliado(nombre,codigo,correo,telefono);
        afiliados.add(nuevoafiliado);
  
    }
    /**
     * Encuentra y elimina el afiliado de acuerdo al codigo ingresada por el usuario.
     * @param  codigo del afiliado.
     */
    public void eliminarAfiliado(String codigo){
    }
    /**
     * Encuentra el afiliado de acuerdo al codigo ingresada por el usuario.
     * @param  Codigo del afiliado.
     * @return El afiliado que es encontrado en la colección. 
     */
    public Afiliado consultarAfiliado(String codigo){
        return null;
    }
}
