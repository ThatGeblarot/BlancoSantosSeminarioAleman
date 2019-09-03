package controlador;

import modelo.Mundo;
import vista.Interfaz;

public class Controlador 
{
	private Mundo mundo;
	private Interfaz gui;
	private String comando;
	
	public Controlador()
	{
		mundo = new Mundo();
		gui = new Interfaz();
		comando = new String();
		iniciarPrograma();
	}
	
	public void iniciarPrograma()
	{
		boolean activo = true;
		while(activo == true)
		{
			try 
			{
				comando = gui.AppInput(System.in, "Ingresa un comando", "Gabriel Blanco; Julian Santos - Seminario Aleman");
				switch(comando)
				{
				default:
					gui.Error(comando+" no es valido. Escribe \"ayuda\" para mas informacion.");
					break;
				case("ayuda"):
					gui.Information("\"salir\" salir");
					break;
				case("salir"):
					activo = false;
					break;
				case("verificacion"):
					gui.WarningMessage(mundo.getSeminario().verificarCupo());
					break;
				case("seminario"):
					//gui.Information(mundo.getArchivo().escribirArchivo(mundo.getArchivo().lecturaArchivo()+"\n"+mundo.getSeminario().escribirLista()+mundo.getSeminario().capturarSujeto()));
					mundo.getArchivo().escribirArchivo(mundo.getArchivo().lecturaArchivo()+"\n"+mundo.getSeminario().escribirLista());
					break;
				}
			} 
			catch (Exception errorConsola) 
			{
				gui.ExceptionError(errorConsola.getMessage(), "Ha ocurrido un error fatal");
			}
		}
	}
}