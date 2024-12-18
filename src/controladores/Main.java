package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dtos.CitaDto;
import servicios.FicheroImplementacion;
import servicios.FicheroInterfaz;
import servicios.MenuImplementacion;
import servicios.MenuInterfaz;
import servicios.OperativaImplementacion;
import servicios.OperativaInterfaz;

/**
 * Clase principal de la aplicación.
 * Gestiona el flujo inicial y principal del programa.
 */
public class Main {
	
	//Listas que consultan los objetos del Dto
	public static List<CitaDto> listaConsultaDtos = new ArrayList<CitaDto>();
	public static List<CitaDto> consultasValidas = new ArrayList<CitaDto>();

	public static void main(String[] args) {
		MenuInterfaz mi = new MenuImplementacion();
		FicheroInterfaz fi = new FicheroImplementacion();
		OperativaInterfaz opi = new OperativaImplementacion();

		try {
			opi.cargaDatos();
		} catch (Exception e) {
			fi.ficheroLog("Ocurrio un error en la app Error=".concat(e.getMessage()));
		}
		
		try {
			
			boolean cerrarMenu = false;
			int opc;
			while (!cerrarMenu) {
				opc = mi.mostrarMenuInicial();
				switch (opc) {
				case 0:
					System.out.println("Se cerrara el menu");
					fi.ficheroLog("Aplicacion Cerrada");
					cerrarMenu = true;
					System.out.println("#######################################");
					break;

				case 1:
					System.out.println("---------------REGISTRO DE LLEGADA---------------");
					fi.ficheroLog("");
					mi.mostrarRegistroLlegada();
					System.out.println("-------------------------------------------------");
					break;
					
				case 2:
					System.out.println("---------------LISTADO DE CONSULTA---------------");
					fi.ficheroLog("");
					mi.mostrarListadoConsulta();
					System.out.println("-------------------------------------------------");
					break;
				default:
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("Ocurrio un error en la app");
			fi.ficheroLog("Ocurrio un error en la app Error=".concat(e.getMessage()));

		}

	}

}