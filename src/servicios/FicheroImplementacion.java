package servicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Clase encargada de contener la lógica de los métodos de ficheros de la app
 */
public class FicheroImplementacion implements FicheroInterfaz {

    @Override
    public void ficheroLog(String dato) {
        // Formatear la fecha actual para incluirla en el nombre del archivo
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        String fechaActual = dateFormat.format(new Date());
        String ruta = "C:\\Users\\prosdez\\eclipse-workspace\\edu.recuperacion.prosdez\\Fichero-Log-" + fechaActual + ".txt";

        try (BufferedWriter escribe = new BufferedWriter(new FileWriter(ruta, true))) {
            escribe.write(dato.concat("\n"));
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el fichero Log.");
        }
    }
}
