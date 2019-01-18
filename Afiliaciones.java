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
    private static ArrayList<Afiliado> afiliados;
    private static Afiliado[] casilleros = new Afiliado[20];
    public Afiliaciones(){
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
    public void eliminarAfiliado(String cod){
        for(int i=0;i<afiliados.size();i++){
            String aux = afiliados.get(i).getCodigo();
            if(aux.equals(cod)){
                System.out.println("el usuario "+aux+" ha sido eliminado");
                afiliados.remove(i);
            }
            else{
                System.out.println("el usuario "+aux+" no se encuentra");
            }
        }
        
        
    }
    /**
     * Encuentra el afiliado de acuerdo al codigo ingresada por el usuario.
     * @param  Codigo del afiliado.
     * @return El afiliado que es encontrado en la colección. 
     */
    public static Afiliado consultarAfiliado(String cod){
        for(int i=0;i<afiliados.size();i++){
            String aux = afiliados.get(i).getCodigo();
            if(aux.equals(cod)){
                System.out.println("el usuario "+aux+ " esta activo");
                return afiliados.get(i);
            }
            else{
                System.out.println("el usuario "+aux+" no se encuentra");
            }
        }
        return null;
    }
      
    public boolean registrarCasillero(String cod, int numero){
        Afiliado afiliado = consultarAfiliado(cod);
        if(casilleros[numero] == null){
            casilleros[numero] = afiliado;
            return true;
        }
        else{
            System.out.println("El casillero se encuentra ocupado");
            return false;
        }
    }
    
    public void consultarCasilleros(){
        System.out.println("Los casilleros libres son los siguientes");
        for(int i=0;i<casilleros.length;i++){
            if(casilleros[i] == null){
                System.out.println(i);
            }
        }
    }
}
