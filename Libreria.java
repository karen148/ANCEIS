
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
    private static ArrayList<Libro> libros = new ArrayList<Libro>();;
    private static ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
    
    /**
     * Constructor for objects of class Libreria
     */
    public Libreria(){
        Libro l1 = new Libro("Libro azul","Juan","Cuarta","Planeta");
        Libro l2 = new Libro("Libro rojo","Carlos","Quinta","Planeta");
        Libro l3 = new Libro("Libro negro","Diego","Segunda","Planeta");
        libros.add(l1);
        libros.add(l2);
        libros.add(l3);
        
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
    public Libro consultarLibro(String titulo){
        for(Libro lb: libros){
            String aux = lb.getTitulo();
            if(aux.equals(titulo)){
                return lb;
            }
            else{
                System.out.println("El libro no existe");
            }
        }
        return null;
    }
    
    public void imprimirLibro(String titulo){
        for(int i=0; i<libros.size(); i++){
            String titl = libros.get(i).getTitulo();
            if(titl.equals(titulo)){
                Libro libro = libros.get(i);
                System.out.println(titl);
                System.out.println(libro.getEstado());

            }
            else{
                System.out.println("El libro no existe");
            }
        }

    }
    
    /**
     * Encuentra y elimina el libro de acuerdo a la clave ingresada por el usuario.
     * @param  clave que va a ser buscada 
     */
    public void eliminarLibro(String titulo){
        Libro libro = consultarLibro(titulo);
        if(libro!=null)
        {
            int index = libros.indexOf(libro);
            libros.remove(index);
            System.out.println("El libro fue eliminado");
        }
        else
        {
            System.out.println("El libro no se encuentra");
        }
    }
    
    /**
     * Crea un prestamo y lo guarda en la coleccion 'prestamos'.
     * @param  afiliado que solicita el prestamo y libro que va a ser prestado. 
     */
    public void solicitarPrestamo(String cod, String titulo){
        Afiliado estudiante = Afiliaciones.buscarAfiliado(cod); 
        if(estudiante!=null){
            Libro libro = consultarLibro(titulo);
            if(libro!=null){
                if(libro.getEstado()){
                    Prestamo prestamo = new Prestamo(estudiante,libro);
                    prestamos.add(prestamo);
                    libros.get(libros.indexOf(libro)).setEstado(false);
                    System.out.println("El prestamo fue un exito");
                }
                else{
                    System.out.println("El libro no se encuentra disponible");
                }
            }
            else{
                System.out.println("No se encuentra el libro");
            }
        }
        else{
            System.out.println("el estudiante no esta afiliado");
        }
    }
    
    public void prueba(Afiliado afiliado){
        System.out.println("Afiliado nombre :"+afiliado.getNombre());
    }
    
    public void consultarPrestamo(String cod, String titulo){
        for(Prestamo p: prestamos){
           if(p.getAfiliado().getCodigo().equals("cod") && p.getLibro().getTitulo().equals("titulo")){
               System.out.println("Titulo: "+p.getLibro().getTitulo());
               System.out.println("Fecha de prestamo: "+p.getFecha());
               System.out.println("Fecha de entrega: "+p.getFecha());
               System.out.println("Multa total: "+p.getMulta());
            }
        }
    }
    /**
     * Busca el prestamo que refiera a la clave ingresada por el usuario y lo renueva.
     * @param  afiliado que solicita el prestamo y libro que va a ser prestado. 
     */
    public void renovarPrestamo(String cod, String titulo){ 
        for(Prestamo p: prestamos){
           if(p.getAfiliado().getCodigo().equals("cod") && p.getLibro().getTitulo().equals("titulo")){
               p.renovar();
            }
        }
    }
    
    public void pagarMulta(String cod, String titulo){
        for(Prestamo p: prestamos){
           if(p.getAfiliado().getCodigo().equals("cod") && p.getLibro().getTitulo().equals("titulo")){
               p.pagarmulta();
               System.out.println("La multa se pago satisfactoriamente");
            }
        }
    }
 
}
