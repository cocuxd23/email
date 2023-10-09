package GestorCorreo;

import org.junit.Test;
import static org.junit.Assert.*;

public class ContactTest {
    @Test
    public void check_creation_of_contact(){
        Contacto contacto = new Contacto("Felix", "Toledo", "felix@gmail.com");
        assertEquals("Felix", contacto.getNombre());
        assertEquals("Toledo", contacto.getApellido());
        assertEquals("felix@gmail.com", contacto.getDireccionCorreo());
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
