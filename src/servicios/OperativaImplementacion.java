package servicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controladores.Main;
import dtos.CitaDto;

public class OperativaImplementacion implements OperativaInterfaz{
	
	//Inicializamos el FicheroImplementacion
	FicheroInterfaz fi=new FicheroImplementacion();
	//Iniciamos el Scanner
	Scanner fechaScanner=new Scanner(System.in);
	
	//Atributos de clase
	String fechaString;
	boolean fechaValida = false;
	//Iniciamos variable auxiliar existen consultas
	boolean vacio=false;
	
	//Metodo Consulta Psicologia
	@Override
	public void mostrarConsultasPsicologia() {
       
		// Validar formato de fecha
		do {
		    System.out.println("Elige una fecha (dd-MM-yyyy):");
		    fechaString = fechaScanner.next();

		    try {
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		        LocalDate.parse(fechaString, formatter); // Si esto falla, irá al catch
		        fechaValida = true; // Si no hay excepciones, la fecha es válida
		    } catch (Exception e) {
		        System.out.println("Formato de fecha inválido. Por favor, inténtalo de nuevo.");
		        fi.ficheroLog("El error es: " .concat(e.getMessage()));
		    }
		    
		} while (!fechaValida);
		
		
		for (CitaDto pl : Main.listaConsultaDtos) {
			if (pl.getEspecialidad().equals("Psicología")) {
				
		        // Definir el formato deseado para la fecha y hora
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		        // Convertir LocalDateTime a String usando el formato
		        String fechaHoraStr = pl.getFechaCita().format(formatter);
				
				if (fechaString.equals(fechaHoraStr)) {
					vacio=true;
					
					// Obtener la hora de la cita en formato "HH:mm"
					String horaConsulta = pl.getFechaCita().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
					// Mostrar la hora de la cita
					
					System.out.print("Nombre completo: ");
					System.out.print(pl.getNombre());
					System.out.print(" ");
					System.out.print(pl.getApellidos());
					System.out.println(String.format(" ,Hora: %s", horaConsulta));
				}
			}
			
		}
		if (vacio==false) {
			System.out.println("No se ha encontrado ninguna consulta");
		}
	}
	// Método Consulta Traumatología
	@Override
	public void mostrarConsultasTraumatologia() {
	    // Validar formato de fecha
	    do {
	        System.out.println("Elige una fecha (dd-MM-yyyy):");
	        fechaString = fechaScanner.next();

	        try {
	            // Validar formato de fecha
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	            LocalDate.parse(fechaString, formatter); // Si esto falla, irá al catch
	            fechaValida = true; // Si no hay excepciones, la fecha es válida
	        } catch (Exception e) {
	            System.out.println("Formato de fecha inválido. Por favor, inténtalo de nuevo.");
	        }

	    } while (!fechaValida);

	    for (CitaDto pl : Main.listaConsultaDtos) {
	        if (pl.getEspecialidad().equals("Traumatologia")) {

	            // Definir el formato deseado para la fecha y hora
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	            // Convertir LocalDateTime a String usando el formato
	            String fechaHoraStr = pl.getFechaCita().format(formatter);

	            if (fechaString.equals(fechaHoraStr)) {
	                vacio = true;

	                // Obtener la hora de la cita en formato "HH:mm"
	                String horaConsulta = pl.getFechaCita().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
	                // Mostrar los detalles de la consulta
	                System.out.print("Nombre completo: ");
	                System.out.print(pl.getNombre());
	                System.out.print(" ");
	                System.out.print(pl.getApellidos());
	                System.out.println(String.format(" ,Hora: %s", horaConsulta));
	            }
	        }
	    }
	    if (!vacio) {
	        System.out.println("No se ha encontrado ninguna consulta");
	    }
	}

	// Método Consulta Fisioterapia
	@Override
	public void mostrarConsultasFisioterapia() {
	    // Validar formato de fecha
	    do {
	        System.out.println("Elige una fecha (dd-MM-yyyy):");
	        fechaString = fechaScanner.next();

	        try {
	            // Validar formato de fecha
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	            LocalDate.parse(fechaString, formatter); // Si esto falla, irá al catch
	            fechaValida = true; // Si no hay excepciones, la fecha es válida
	        } catch (Exception e) {
	            System.out.println("Formato de fecha inválido. Por favor, inténtalo de nuevo.");
	        }

	    } while (!fechaValida);

	    for (CitaDto pl : Main.listaConsultaDtos) {
	        if (pl.getEspecialidad().equals("Fisioterapia")) {

	            // Definir el formato deseado para la fecha y hora
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	            // Convertir LocalDateTime a String usando el formato
	            String fechaHoraStr = pl.getFechaCita().format(formatter);

	            if (fechaString.equals(fechaHoraStr)) {
	                vacio = true;

	                // Obtener la hora de la cita en formato "HH:mm"
	                String horaConsulta = pl.getFechaCita().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
	                // Mostrar los detalles de la consulta
	                System.out.print("Nombre completo: ");
	                System.out.print(pl.getNombre());
	                System.out.print(" ");
	                System.out.print(pl.getApellidos());
	                System.out.println(String.format(" ,Hora: %s", horaConsulta));
	            }
	        }
	    }
	    if (!vacio) {
	        System.out.println("No se ha encontrado ninguna consulta");
	    }
	}

	
	

	// Define la ruta del archivo de texto y carga sus datos
	@Override
	public void cargaDatos() {
	    String ruta = "C:\\Users\\usuario\\Documents\\Desarrollo Entorno Servidor\\edu.prosdez.recuperacion.primeraevaluacion\\src\\citas.txt"; 
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
	//Imprime las Consultas de Psicologia y su fecha
	@Override
	public void imprimirConsultasPsicologia() {
	    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	    //Verificar Fecha
	    do {
		    System.out.println("Introduce la Fecha (dd-MM-yyyy):");
		    fechaString = fechaScanner.next();
		    
		    // Validar formato de fecha
		    try {
		        
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		        LocalDate.parse(fechaString, formatter); // Si esto falla, irá al catch
		        fechaValida = true; // Si no hay excepciones, la fecha es válida
		    } catch (Exception e) {
		        System.out.println("Formato de fecha inválido. Por favor, inténtalo de nuevo.");
		    }
		    
	    } while (!fechaValida);

	    
	    // Iterar sobre las consultas
	    for (CitaDto consulta : Main.listaConsultaDtos) {
	        // Formatear la fecha de la consulta
	        String fechaConsulta = consulta.getFechaCita().format(dateFormatter);

	        // Comprobar fecha, especialidad y asistencia
	        if (fechaString.equals(fechaConsulta) &&
	            consulta.getEspecialidad().equalsIgnoreCase("Psicología") &&
	            consulta.isAsistencia()) {
	            Main.consultasValidas.add(consulta);
	        }
	    }
	    //Guardamos datos en fichero
	    fi.ficherocitasConAsistencia();
	    

	    // Imprimir las consultas válidas por consola
	    if (Main.consultasValidas.isEmpty()) {
	        System.out.println("“No hay datos disponibles para la especialidad y fecha indicada.”");
	    } else {
	        System.out.println("Consultas de Psicología válidas:");
	        for (CitaDto consulta : Main.consultasValidas) {
	            System.out.println(consulta.toString());
	        }
	    }
	}
	
	//Imprime las Consultas de Traumatologia y su fecha
	@Override
	public void imprimirConsultasTraumatologia() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	    //Verificar Fecha
	    do {
		    System.out.println("Introduce la Fecha (dd-MM-yyyy):");
		    fechaString = fechaScanner.next();
		    
		    // Validar formato de fecha
		    try {
		        
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		        LocalDate.parse(fechaString, formatter); // Si esto falla, irá al catch
		        fechaValida = true; // Si no hay excepciones, la fecha es válida
		    } catch (Exception e) {
		        System.out.println("Formato de fecha inválido. Por favor, inténtalo de nuevo.");
		    }
		    
	    } while (!fechaValida);

	    
	    // Iterar sobre las consultas
	    for (CitaDto consulta : Main.listaConsultaDtos) {
	        // Formatear la fecha de la consulta
	        String fechaConsulta = consulta.getFechaCita().format(dateFormatter);

	        // Comprobar fecha, especialidad y asistencia
	        if (fechaString.equals(fechaConsulta) &&
	            consulta.getEspecialidad().equalsIgnoreCase("Traumatologia") &&
	            consulta.isAsistencia()) {
	            Main.consultasValidas.add(consulta);
	        }
	    }
	    //Guardamos datos en fichero
	    fi.ficherocitasConAsistencia();
	    

	    // Imprimir las consultas válidas por consola
	    if (Main.consultasValidas.isEmpty()) {
	        System.out.println("“No hay datos disponibles para la especialidad y fecha indicada.”");
	    } else {
	        System.out.println("Consultas de Traumatologia válidas:");
	        for (CitaDto consulta : Main.consultasValidas) {
	            System.out.println(consulta.toString());
	        }
	    }
	}
	//Imprime las Consultas de Fisioterapia y su fecha	
	@Override
	public void imprimirConsultasFisioterapia() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	    //Verificar Fecha
	    do {
		    System.out.println("Introduce la Fecha (dd-MM-yyyy):");
		    fechaString = fechaScanner.next();
		    
		    // Validar formato de fecha
		    try {
		        
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		        LocalDate.parse(fechaString, formatter); // Si esto falla, irá al catch
		        fechaValida = true; // Si no hay excepciones, la fecha es válida
		    } catch (Exception e) {
		        System.out.println("Formato de fecha inválido. Por favor, inténtalo de nuevo.");
		    }
		    
	    } while (!fechaValida);

	    
	    // Iterar sobre las consultas
	    for (CitaDto consulta : Main.listaConsultaDtos) {
	        // Formatear la fecha de la consulta
	        String fechaConsulta = consulta.getFechaCita().format(dateFormatter);

	        // Comprobar fecha, especialidad y asistencia
	        if (fechaString.equals(fechaConsulta) &&
	            consulta.getEspecialidad().equalsIgnoreCase("Fisioterapia") &&
	            consulta.isAsistencia()) {
	            Main.consultasValidas.add(consulta);
	        }
	    }
	    //Guardamos datos en fichero
	    fi.ficherocitasConAsistencia();
	    

	    // Imprimir las consultas válidas por consola
	    if (Main.consultasValidas.isEmpty()) {
	        System.out.println("“No hay datos disponibles para la especialidad y fecha indicada.”");
	    } else {
	        System.out.println("Consultas de Fisioterapia válidas:");
	        for (CitaDto consulta : Main.consultasValidas) {
	            System.out.println(consulta.toString());
	        }
	    }
	}
	public class ValidacionDNI {

	    // Tabla de letras según el resto
	    private static final String[] LETRAS = {
	        "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"
	    };

	    // Método para validar el DNI
	    public static boolean validarDNI(String dni) {
	        // Verificar que el DNI tiene el formato correcto (8 números + 1 letra)
	        if (dni == null || dni.length() != 9) {
	            return false;  // Formato incorrecto
	        }

	        String numeroDni = dni.substring(0, 8);  // Los primeros 8 caracteres son el número
	        char letraDni = dni.charAt(8);           // El noveno carácter es la letra

	        // Validar que el número del DNI es un número válido
	        try {
	            Long.parseLong(numeroDni);  // Intentar convertir a número
	        } catch (NumberFormatException e) {
	            return false;  // Si ocurre un error, no es un número válido
	        }

	        // Calcular el resto de la división
	        int numero = Integer.parseInt(numeroDni);
	        int resto = numero % 23;

	        // Obtener la letra correspondiente
	        String letraEsperada = LETRAS[resto];

	        // Comparar la letra del DNI con la letra calculada
	        return letraEsperada.equalsIgnoreCase(String.valueOf(letraDni));
	    }

	    public static void main(String[] args) {
	        String dni = "12345678T"; // Ejemplo de DNI para probar

	        if (validarDNI(dni)) {
	            System.out.println("El DNI es válido.");
	        } else {
	            System.out.println("El DNI no es válido.");
	        }
	    }
	}
	@Override
	public void ValidacionDNI() throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}
