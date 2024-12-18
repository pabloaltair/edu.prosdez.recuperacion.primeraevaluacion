package servicios;

import java.util.Scanner;

public class MenuImplementacion implements MenuInterfaz {
	
	Scanner scanner=new Scanner(System.in);
	
	//Implementaciones
	FicheroInterfaz fi = new FicheroImplementacion();
	OperativaInterfaz op= new OperativaImplementacion();
	
	@Override
	public int mostrarMenuInicial() {
		fi.ficheroLog("MenuInicial");
		System.out.println("0-Cerrar Menu");
		System.out.println("1-Registro De Llegada");
		System.out.println("2-Listado De Consulta");
		int opc=scanner.nextInt();
		return opc;
	}

	@Override
	public void mostrarRegistroLlegada() throws Exception {
		// TODO Auto-generated method stub
		fi.ficheroLog("RegistroLLegada");
		op.ValidacionDNI();
		

	}

	@Override
	public void mostrarListadoConsulta() throws Exception {
		// TODO Auto-generated method stub
		fi.ficheroLog("ListadoConsulta");
		System.out.println("0-Volver");
		System.out.println("1-Mostrar Consultas");
		System.out.println("2-Imprimir Consultas");
		int opc=scanner.nextInt();
		switch (opc) {
		case 0:
			System.out.println("VOLVIENDO...");
			break;
		case 1:
			System.out.println("---------------MOSTRAR CONSULTAS----------------");
			elegirTipoConsulta();
			break;
		case 2:
			System.out.println("---------------IMPRIMIR CONSULTAS---------------");
			mostrarImprimirConsulta();
			break;
			
		default:
			break;
		}
		
	}
	public void elegirTipoConsulta() throws Exception {
		// TODO Auto-generated method stub
		fi.ficheroLog("Elegir Tipo de Consulta");
		System.out.println("Selecciona un tipo de consulta");
		System.out.println("0-Volver");
		System.out.println("1-Psicologia");
		System.out.println("2-Traumatologia");
		System.out.println("3-Fisioterapia");
		int opc=scanner.nextInt();
		switch (opc) {
		case 0:
			System.out.println("VOLVIENDO...");
			break;
		case 1:
			System.out.println("Psicologia");
			System.out.println("Solicitar fecha");
			op.mostrarConsultasPsicologia();
			break;
		case 2:
			System.out.println("Traumatologia");
			System.out.println("Solicitar fecha");
			op.mostrarConsultasTraumatologia();
			break;
			
		case 3:
			System.out.println("Fisioterapia");
			System.out.println("Solicitar fecha");
			op.mostrarConsultasFisioterapia();
			break;
		default:
			break;
		}
		
	}

	public void mostrarImprimirConsulta() throws Exception {
		// TODO Auto-generated method stub
				fi.ficheroLog("Menu Imprimir Consulta");
				System.out.println("Selecciona un tipo de consulta");
				System.out.println("0-Volver");
				System.out.println("1-Psicologia");
				System.out.println("2-Traumatologia");
				System.out.println("3-Fisioterapia");
				int opc=scanner.nextInt();
				switch (opc) {
				case 0:
					System.out.println("VOLVIENDO...");
					break;
				case 1:
					System.out.println("Psicologia");
					System.out.println("Solicitar fecha");
					op.imprimirConsultasPsicologia();
					break;
				case 2:
					System.out.println("Traumatologia");
					System.out.println("Solicitar fecha");
					op.imprimirConsultasTraumatologia();
					break;
					
				case 3:
					System.out.println("Fisioterapia");
					System.out.println("Solicitar fecha");
					op.imprimirConsultasFisioterapia();
					break;
				default:
					break;
				}
				
			}


	
	
}
