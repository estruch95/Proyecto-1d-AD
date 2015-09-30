package Funciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FuncionesImpl {

	//Atributos de tipo File
	private File f1,f3;
	
	public FuncionesImpl() {
		//Declaración de ficheros
		f1 = new File("fichero1.txt");
		f3 = new File("fichero3.txt");
		
		/*El método ordenarFichero recibe 3 parámetros, un fichero origen, un fichero destino y un tercer parámetro 
		donde indicamos con 0 si el orden es natural o con 1 si es inverso.*/
		this.ordenarFichero(f1,f3,1);
	}
	
	public void ordenarFichero(File origen, File destino, int tipoOrden){
		
		ArrayList<String> ficheroOrigen = new ArrayList<String>();
		String cadenaOrigen;
		
		try{
			
			if(origen.exists()==false){
				System.err.println("El fichero no se encuentra");
			}
			
			//LECTURA DE FICHERO ORIGEN
			FileReader frOrigen = new FileReader(origen);
			BufferedReader bfrOrigen = new BufferedReader(frOrigen);
			
			//ESCRITURA EN FICHERO DESTINO
			FileWriter fwDestino = new FileWriter(destino);
			BufferedWriter bfwDestino = new BufferedWriter(fwDestino);
			
			cadenaOrigen = bfrOrigen.readLine();
			
			//Leemos y almacenamos en un ArrayList
			while (cadenaOrigen != null){
				ficheroOrigen.add(cadenaOrigen);
				cadenaOrigen = bfrOrigen.readLine();
			}
			//Cerramos el buffer de lectura
			bfrOrigen.close();
			
			/*Una vez se ha leido todo el fichero, se almacenan dichas lineas en el ArrayList "ficheroOrigen" y posteriormente lo condicionamos:
			  Si el tipoOrden introducido es 0, se recorrerá el ArrayList de forma normal.
			  Si el tipoOrden introducido es 1, se recorrerá el ArrayList de forma inversa.
 		   */
			
			if(tipoOrden == 0){
				//Escritura en fichero destino con orden natural
				for(int a=0;a<ficheroOrigen.size();a++){
					bfwDestino.write(ficheroOrigen.get(a)+"\n");
				}
				//Info. consola
				System.out.println("Copiado correctamente en orden natural.");
			}
			else if (tipoOrden == 1){
				//Escritura en fichero destino con orden inverso
				for(int a=(ficheroOrigen.size()-1);a>=0;a--){
					bfwDestino.write(ficheroOrigen.get(a)+"\n");
				}
				//Info. consolas
				System.out.println("Copiado correctamente en orden inverso.");
			}
			//Cerramos el buffer de escritura
			bfwDestino.close();
			
		}
		catch(IOException error){
			System.err.println("Error al ordenar el texto al fichero destino.");
		}
	}

}
