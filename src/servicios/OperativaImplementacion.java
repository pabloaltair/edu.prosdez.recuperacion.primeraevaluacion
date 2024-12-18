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
	    String ruta = "C:\\Users\\prosdez\\eclipse-workspace\\edu.recuperacion.prosdez\\src\\citas.txt"; 
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
	
	 // Tabla de letras según el resto
    private static final String[] LETRAS = {
        "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"
    };

    @Override
    public void ValidacionDNI() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String dni;
        boolean dniValido = false; // Controla si el DNI es válido
        LocalDate hoy = LocalDate.now(); // Fecha actual

        do {
            try {
                // Solicitar el DNI al usuario
                System.out.print("Por favor, introduce tu DNI (8 números y 1 letra): ");
                dni = scanner.nextLine();

                // Verificar que el DNI tiene exactamente 9 caracteres
                if (dni == null || dni.length() != 9) {
                    throw new IllegalArgumentException("El DNI debe tener 9 caracteres: 8 números y 1 letra.");
                }

                // Separar el número del DNI y la letra
                String numeroDni = dni.substring(0, 8);
                char letraDni = dni.charAt(8);

                // Validar que los primeros 8 caracteres sean números
                try {
                    Long.parseLong(numeroDni); // Si no son números, lanza una excepción
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Los primeros 8 caracteres del DNI deben ser números.");
                }

                // Calcular el resto de la división del número del DNI entre 23
                int numero = Integer.parseInt(numeroDni);
                int resto = numero % 23;

                // Obtener la letra esperada
                String letraEsperada = LETRAS[resto];

                // Comparar la letra calculada con la letra introducida
                if (!letraEsperada.equalsIgnoreCase(String.valueOf(letraDni))) {
                    throw new IllegalArgumentException("El DNI introducido no es válido. La letra esperada es: " + letraEsperada);
                }

                // DNI válido hasta este punto
                boolean citaEncontrada = false;

                for (CitaDto consulta : Main.listaConsultaDtos) {
                    if (consulta.getDni().equalsIgnoreCase(dni)) {
                        citaEncontrada = true;

                        // Convertir LocalDateTime a LocalDate para comparación
                        LocalDate fechaCita = consulta.getFechaCita().toLocalDate();

                        // Comprobar si la cita es para hoy
                        if (fechaCita.equals(hoy)) {
                            System.out.println("Espere su turno para la consulta de " + consulta.getEspecialidad()+ " en la sala de espera. Su especialista le avisará.");
                        } else {
                            System.out.println("Tiene una cita, pero no es para hoy. Su cita es el: " + fechaCita);
                        }
                        break;
                    }
                }

                if (!citaEncontrada) {
                    System.out.println("No dispone de cita previa para hoy.");
                }

                dniValido = true; // Salimos del bucle si todo es correcto

            } catch (IllegalArgumentException e) {
                // Manejo de errores personalizados
                System.out.println("Error: " + e.getMessage());
                System.out.println("Por favor, vuelva a introducir un DNI correcto.\n");
            } catch (Exception e) {
                // Cualquier otra excepción
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
                break;
            }

        } while (!dniValido);
    }

    


}
