
/**
 * Ganancias guarda las ganancias de los productos vendidos, las multas de los 
 * libros prestados, afiliaciones y casilleros.
 * 
 * @author (Chia Andres,Gonzalez Karen) 
 * @version (AINCeis.v1)
 */
public class Ganancias
{
    // instance variables - replace the example below with your own
    public static int TotalGanancia;
    public int buenas;

    /**
     * Constructor for objects of class TotalGanancias
     */
    public Ganancias(){
        // initialise instance variables
        TotalGanancia = 0;
    }

    /**
     * Suma las ganancias obtenidas por ventas, afiliaciones, casilleros y multas.
     */
    public static void SumarGanancia(int ganancia)
    {
        TotalGanancia += ganancia;
    }
}
