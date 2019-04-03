import java.util.ArrayList;
import java.io.Serializable;
/**
 * Guarda una coleccion de los afiliados al CEIS.
 * Permite registrar un nuevo afiliado y agregarlo a la coleccion.
 * Permitir eliminar un afiliado.
 * @author (Chia Andres, Gonzalez Karen) 
 * @version (AINCeis.v1)
 */
public class Afiliaciones implements Serializable
{
    // instance variables - replace the example below with your own
    public static ArrayList<Afiliado> afiliados = new ArrayList<Afiliado>();
    public static ArrayList<Afiliado> afiliadosantiguos = new ArrayList<Afiliado>();
    private static Afiliado[] casilleros = new Afiliado[20];
    private static final long serialVersionUID = -5715181748092453099L;
    
    public Afiliaciones(){
        
    }
     
    /**
     * Registra un afiliado con los atributos que ingrese el usuario y lo guarda en la coleccion 'afiliados'.
     * @param  atributos del afiliado. 
     */
    public static void registrarAfiliado(String nombre, String codigo, String correo, String telefono){
         int valorantiguos = 8000;
         int valornuevos = 10000;
        Afiliado nuevoafiliado = new Afiliado(nombre,codigo,correo,telefono);
        afiliados.add(nuevoafiliado);
        if(afiliadosantiguos.contains(nuevoafiliado)){
            Ganancias.SumarGanancia(valorantiguos);
        }
        else{
            Ganancias.SumarGanancia(valornuevos);
        }
      }
    /**
     * Encuentra y elimina el afiliado de acuerdo al codigo ingresada por el usuario.
     * @param  codigo del afiliado.
     */
    public void eliminarAfiliado(String cod){
        Afiliado afiliado = buscarAfiliado(cod);
        if(afiliado!=null){
            int index = afiliados.indexOf(afiliado);
            System.out.println("El usuario fue removido con exito");
            afiliados.remove(index);
        }     
    }
    
    /**
     * Encuentra el afiliado de acuerdo al codigo ingresada por el usuario.
     * @param  Codigo del afiliado.
     * @return El afiliado que es encontrado en la colección. 
     */
    public static Afiliado buscarAfiliado(String cod){
        if(afiliados.size()==0){
            System.out.println("No hay afiliados registrados");
        }
        else{
            for(Afiliado af : afiliados){
                String aux = af.getCodigo();
                if(aux.equals(cod)){
                    //System.out.println("el usuario "+aux+ " esta activo");
                    return af;
                }
            }
        }
        System.out.println("el usuario "+cod+" no se encuentra");
        return null;
    }
      
    public boolean registrarCasillero(String cod, int numero){
        Afiliado afiliado = buscarAfiliado(cod);
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
    
    public void listarAfiliados(){
        for(Afiliado af : afiliados){
            imprimirAfiliado(af);
        }
    }
    
    public void imprimirAfiliado(Afiliado af){
        System.out.println("Nombre: "+af.getNombre());
        System.out.println("Codigo: "+af.getCodigo());
        System.out.println("Correo: "+af.getCorreo());
        System.out.println("Telefono: "+af.getTelefono());
        System.out.println("\n");
    }
}
