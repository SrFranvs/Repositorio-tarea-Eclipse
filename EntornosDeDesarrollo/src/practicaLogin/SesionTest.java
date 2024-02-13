package practicaLogin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class SesionTest{

    private Sesion sesion1;
    
    // Antes de iniciar con los tests hacemos el método indicado con el before, el cual crea una instancia de la clase
    // sesión para poder utilizar con ella el método que hemos creado (el login)
    @Before
    public void crearSesion() {
        sesion1 = new Sesion();
    }
    // En el primer test el restultado es verdadero, pues el usuario y la contraseña se encuentran en el fichero
    @Test
    public void testLoginCorrecto1() {
        assertTrue(sesion1.login("dmunuera", "123456"));
    }
    // En el segundo test lo mismo
    @Test
    public void testLoginCorrecto2() {
        assertTrue(sesion1.login("pepe", "654321"));
    }
    
    // En el tercer test el resultado esperado es "false", pues el usuario existe en el fichero pero no se corresponde con esa contraseña
    @Test
    public void testLoginIncorrecto1() {
        assertFalse(sesion1.login("pepe", "654322"));
    }
    // Finalmente en el cuarto test el resultado esperado también es falso, ya que la contraseña figura en el archivo pero no figura con 
    // ese nombre se usuario
    @Test
    public void testLoginIncorrecto2() {
        assertFalse(sesion1.login("pepa", "987654321"));
    }


}

