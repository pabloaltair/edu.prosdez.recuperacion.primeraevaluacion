package servicios;

public interface MenuInterfaz {
	/*
	 * Metodo encargado de mostrar el menu principal 
	 * ilp-101024
	 */
	public int mostrarMenuInicial () throws Exception;
	/*
	 * Metodo encargado de mostrar el menu Empleado
	 *  ilp-101024
	 */

	public void mostrarRegistroLlegada() throws Exception;

	/*
	 * Metodo encargado de mostrar el menu Gerencia 
	 * ilp-101024
	 */
	public void mostrarListadoConsulta() throws Exception;
	public void mostrarImprimirConsulta () throws Exception;
}
