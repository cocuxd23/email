package GestorCorreo;

import org.junit.Test;
import static org.junit.Assert.*;

public class ContactoTest {
    @Test
    public void check_creation_of_contact(){
        Contacto contacto = new Contacto("Lautaro", "Salina", "Lautaro10@gmail.com");
        assertEquals("Lautaro", contacto.getNombre());
        assertEquals("Salina", contacto.getApellido());
        assertEquals("Lautaro10@gmail.com", contacto.getDireccionCorreo());
    }

    @Test
    public void contact_functions_test(){
        Contacto contacto = new Contacto("Felix", "Toledo", "felix@gmail.com");
        contacto.setNombre("Felixito");
        contacto.setApellido("Perez");
        contacto.setDireccionCorreo("felixperez@gmail.com");

        String hasToBeName = "Felixito";
        String hasToBeSurname = "Perez";
        String hasToBeMailAdress = "felixperez@gmail.com";

        assertEquals(hasToBeName, contacto.getNombre());
        assertEquals(hasToBeSurname, contacto.getApellido());
        assertEquals(hasToBeMailAdress, contacto.getDireccionCorreo());
    }
}
