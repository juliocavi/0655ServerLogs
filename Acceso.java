
/**
 * Nos permite crear objetos Acceso, 
 * mediante los parametros introducimos el año, el mes, el día, 
 * la hora y los minutos.
 *
 * @author (Julio Cachón Villadangos)
 * @version (27/02/2018)
 */
public class Acceso
{
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;

    /**
     * Constructor para objetos de la clase Acceso.
     * 
     * @param ano es el año del registro
     * @param mes es el mes del registro
     * @param dia es el dia del registro
     * @param hora es la hora del registro
     * @param minutos son los minutos del registro
     * 
     */
    public Acceso(int ano, int mes, int dia, int hora, int minutos)
    {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minutos = minutos;
    }

    /**
     * Devuelve la hora del registro.
     *
     * @param  y  a sample parameter for a method
     * @return    la hora del registro
     */
    public int getHora()
    {
        return hora;
    }
}
