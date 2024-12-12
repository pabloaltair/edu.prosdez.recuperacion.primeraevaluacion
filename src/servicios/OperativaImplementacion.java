package servicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import controladores.Main;
import dtos.CitaDto;

public class OperativaImplementacion implements OperativaInterfaz{
	
	FicheroInterfaz fi=new FicheroImplementacion();
	Scanner fechaScanner=new Scanner(System.in);
	@Override
	public void mostrarConsultas() {
		System.out.println("Introduce la Fecha(dd-MM-yyyy)");
		String fechaString=fechaScanner.next();
		
		for (CitaDto pl : Main.listaConsultaDtos) {
			if (pl.getEspecialidad().equals("Psicología")) {
				
		        // Definir el formato deseado para la fecha y hora
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		        // Convertir LocalDateTime a String usando el formato
		        String fechaHoraStr = pl.getFechaCita().format(formatter);
				
				if (fechaString==fechaHoraStr) {
					System.out.println(pl.getNombre());
				}
			}
		}
	}

	@Override
	public void imprimirConsultas() {
		
	}

	@Override
	public void cargaDatos() {
	    String ruta = "/C:\\Users\\prosdez\\eclipse-workspace\\edu.recuperacion.prosdez\\src\\citas.txt"; // Define la ruta del archivo de texto
	    try (BufferedReader lector = new BufferedReader(new FileReader(ruta))) {
	        String linea;
	        // Define el formato esperado de la fecha
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	        
	        while ((linea = lector.readLine()) != null) {
	            String[] arrayLineas = linea.split(";");
	            
	            CitaDto consulta = new CitaDto();
	            consulta.setDni(arrayLineas[0]);
	            consulta.setNombre(arrayLineas[1]);
	            consulta.setApellidos(arrayLineas[2]);
	            consulta.setEspecialidad(arrayLineas[3]);
	      
	            // Convierte el string de la fecha a LocalDateTime
	            String fechaCitaStr = arrayLineas[4];
	            LocalDateTime fechaCita = LocalDateTime.parse(fechaCitaStr, formatter);
	            consulta.setFechaCita(fechaCita);
	            
	            // Convierte el string de asistencia a booleano
	            String asistenciaStr = arrayLineas[5]; // Suponiendo que el valor booleano está en el índice 5
	            boolean asistencia = Boolean.parseBoolean(asistenciaStr); // Convierte el string a booleano
	            consulta.setAsistencia(asistencia);
	            
	            // Agrega la consulta a la lista
	            Main.listaConsultaDtos.add(consulta);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	        fi.ficheroLog(e.getMessage());
	    }
	}
	
}
