import java.io.File;
import java.io. FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Analiza los registros de entrada de un archivo de registros,
 * y muestra la hora a la que se producen más accesos al servidor.
 *
 * @author (Julio Cachón Villadangos)
 * @version (27/02/2018)
 */
public class AnalizardorAccesoAServidor
{
    private ArrayList<Acceso> registros;
    /**
     * Analiza el registro de entrada.
     *
     * @param  input es el registro de entrada que se va a analizar.
     */
    public void analizarArchivoDeLog(String input)
    {
        registros = new ArrayList<Acceso>();
        try{
            File logs = new File(input);
            Scanner scl = new Scanner(logs);
            while(scl.hasNextLine()){
                String[] elementos = scl.nextLine().split(" ");
                Acceso acceso = new Acceso(
                Integer.parseInt(elementos[0]), 
                Integer.parseInt(elementos[1]), 
                Integer.parseInt(elementos[2]), 
                Integer.parseInt(elementos[3]), 
                Integer.parseInt(elementos[4]));
                registros.add(acceso);
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
