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
					gui.Information("\"seminario\" para mostrar el seminario\n\"verificacion\" Verifica la cantidad de cupo\n\"salir\" salir");
					break;
				case("salir"):
					activo = false;
					break;
				case("verificacion"):
					gui.WarningMessage(mundo.getSeminario().verificarCupo());
					break;
				case("seminario"):
					gui.Information(mundo.getArchivo().escribirArchivo(mundo.getArchivo().lecturaArchivo()+"\n"+mundo.getSeminario().escribirLista()));
					mundo.getArchivo().escribirArchivo(mundo.getArchivo().lecturaArchivo()+mundo.getSeminario().capturarSujeto());
					mundo.getArchivo().setNumeroSesion(mundo.getArchivo().getNumeroSesion()+1);
					break;
				case("seminario2"):
					gui.Information(mundo.getArchivo().escribirArchivo(mundo.getArchivo().lecturaArchivo()+"\n"+mundo.getSeminario().escribirdesdeNombres(mundo.getArchivo().leerDesdenombresTXT())));
					mundo.getArchivo().escribirArchivo(mundo.getArchivo().lecturaArchivo()+mundo.getSeminario().capturarSujeto());
					mundo.getArchivo().setNumeroSesion(mundo.getArchivo().getNumeroSesion()+1);
					break;
				}
			} 
			catch (Exception errorConsola) 
			{
				gui.ExceptionError(errorConsola.toString(), "Ha ocurrido un error fatal");
			}
		}
	}
}