package servicios;

public interface MenuInterfaz {
	
	//Metodo encargado de mostrar el menu principal 
	public int mostrarMenuInicial () throws Exception;
	
	//Metodo encargado de mostrar el menu Llegada 
	public void mostrarRegistroLlegada() throws Exception;
	
	//Metodo encargado de mostrar el Listado de la Consulta
	public void mostrarListadoConsulta() throws Exception;

	 //Metodo encargado de mostrar el menu Imprimir Consulta
	public void mostrarImprimirConsulta () throws Exception;
}
