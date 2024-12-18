package servicios;

public interface OperativaInterfaz {
	//CARGA DATOS
	public void cargaDatos();
	//CONSULTAS
	public void mostrarConsultasPsicologia() throws Exception;
	public void mostrarConsultasTraumatologia() throws Exception;
	public void mostrarConsultasFisioterapia() throws Exception;
	//IMPRIMIR CONSULTAS
	public void imprimirConsultasPsicologia() throws Exception;
	public void imprimirConsultasTraumatologia() throws Exception;
	public void imprimirConsultasFisioterapia() throws Exception;
	//REGISTRO DE LLEGADA
	public void ValidacionDNI() throws Exception;
}
