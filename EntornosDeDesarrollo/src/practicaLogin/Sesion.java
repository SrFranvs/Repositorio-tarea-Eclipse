package practicaLogin;
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 

public class Sesion{

	// Hacemos el método con las cualidades requeridas en la descripción
    public boolean login(String usuario, String password) {
        try {
            File fichero = new File("./assets/usuarios.txt");
            Scanner sc = new Scanner(fichero);

            while (sc.hasNextLine()) {
                String fila = sc.nextLine();
                String[] campos = fila.split("#");

                // Como vemos en el fichero el usuario se encuentra en la primera posición y la contraseña en la segunda
                // si coinciden significa que el usuario y la contraseña están en el archivo
                if (campos[0].equals(usuario) && campos[1].equals(password)) {
                    sc.close();
                    return true; // Usuario y contraseña coinciden
                }
            }
        } catch (FileNotFoundException e) {
        	System.out.println("Error");
            e.printStackTrace();
        }
        // Si tras recorrer todos los registros en el bucle while no se ha encontrado el usuario y la contraseña deseada
        // devolvemos "false"
        return false; 
    }
}
