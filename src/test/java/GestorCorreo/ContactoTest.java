package GestorCorreo;

import org.junit.Test;
import static org.junit.Assert.*;

public class ContactoTest {
    @Test
    public void creacionContacto(){
        Contacto contacto = new Contacto("Lautaro", "Salina", "Lautaro10@gmail.com");
        assertEquals("Lautaro", contacto.getNombre());
        assertEquals("Salina", contacto.getApellido());
        assertEquals("Lautaro10@gmail.com", contacto.getDireccionCorreo());
    }

    @Test
    public void contactoFuncionTest(){
        Contacto contacto = new Contacto("Lautaro", "Salina", "Lautaro@gmail.com");
        contacto.setNombre("Laucha");
        contacto.setApellido("Mendonza");
        contacto.setDireccionCorreo("LauchaMendoza@gmail.com");

        String hasToBeName = "Laucha";
        String hasToBeSurname = "Mendoza";
        String hasToBeMailAdress = "LauchaMendoza@gmail.com";

        assertEquals(hasToBeName, contacto.getNombre());
        assertEquals(hasToBeSurname, contacto.getApellido());
        assertEquals(hasToBeMailAdress, contacto.getDireccionCorreo());
    }
}
