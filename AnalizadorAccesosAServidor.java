import java.io.File;
import java.io. FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Analiza los registros de entrada de un archivo de registros,
 * y muestra la hora a la que se producen más accesos al servidor.
 *
 * @author Julio Cachón Villadangos
 * @version 27/02/2018
 */
public class AnalizadorAccesosAServidor
{
    private ArrayList<Acceso> registros;
    
    public AnalizadorAccesosAServidor()
    {
        
        registros = new ArrayList<Acceso>();
    }
    
    /**
     * Analiza el registro de entrada.
     *
     * @param  input Es el registro de entrada que se va a analizar.
     */
    public void analizarArchivoDeLog(String input)
    {
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
            scl.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * Obtiene la hora a la que se han producido más accesos al servidor.
     * 
     * @return  Devuelve -1 si no hay datos que procesar o la hora más repetida.
     */
    public int obtenerHoraMasAccesos(){
        int horaMayorAccesos = -1;
        HashMap<Integer, Integer> registroHoras = new HashMap<>();
        if(registros.size() != 0){
            for(int i=0; i<24; i++){
                registroHoras.put(i, 0);
            }
            
            for(Acceso accesoActual : registros){
                registroHoras.replace(accesoActual.getHora(), registroHoras.get(accesoActual.getHora()) + 1);
            }

            int accesos = 0;
            for(Integer horaActual : registroHoras.keySet()){
                if(registroHoras.get(horaActual) >= accesos){
                    horaMayorAccesos = horaActual;
                    accesos = registroHoras.get(horaActual);
                }
            }
        }
        else{
            System.out.println("No hay datos que procesar, por lo tanto no se ha invocado analizarArchivosDeLog()");
        }
        registros.clear();
        
        return horaMayorAccesos;
    }
}
