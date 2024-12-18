package servicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import controladores.Main;
import dtos.CitaDto;

/*
 * Clase encargada de contener la lógica de los métodos de ficheros de la app
 */
public class FicheroImplementacion implements FicheroInterfaz {

    @Override
    public void ficheroLog(String dato) {
        // Formatear la fecha actual para incluirla en el nombre del archivo
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        String fechaActual = dateFormat.format(new Date());
        String ruta = "C:\\Users\\prosdez\\eclipse-workspace\\edu.recuperacion.prosdez" + fechaActual + ".txt";

        try (BufferedWriter escribe = new BufferedWriter(new FileWriter(ruta, true))) {
            escribe.write(dato.concat("\n"));
            escribe.close();
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el fichero Log.");
            
        }
    }
    @Override
    public void ficherocitasConAsistencia() {
    	// Formatear la fecha actual para incluirla en el nombre del archivo
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String fechaActual = dateFormat.format(new Date());
        String ruta = "C:\\Users\\prosdez\\eclipse-workspace\\edu.recuperacion.prosdez\\citasConAsistencia-" + fechaActual + ".txt";
        
     // Escribir las consultas válidas en un fichero
	    try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta))) {
	        for (CitaDto consulta : Main.consultasValidas) {
	            escritor.write(consulta.toString());
	            escritor.newLine();

	        }
	        System.out.println("Consultas guardadas en: " + ruta);
	        escritor.close();
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	        ficheroLog("El error es: " .concat(e.getMessage()));
	    }
    }
    
}
