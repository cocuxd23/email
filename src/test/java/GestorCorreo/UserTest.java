package GestorCorreo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class UserTest {
    @Test
    public void create_new_user_with_name_surname_mailAdress(){
        User lautarosalina = new User("Lautaro", "Salina", "lautarosalina15");

        String nameOfFelix = lautarosalina.getNombre();
        String surnameOfFelix = lautarosalina.getApelldio();
        String mailOfFelix = lautarosalina.getDireccionCorreo();

        assertEquals("Felix", nameOfFelix);
        assertEquals("Toledo", surnameOfFelix);
        assertEquals("felixtoledoctes@aquilita.com", mailOfFelix);
    }

    @Test
    public void create_new_user_and_check_entry_to_userlist(){
        MailManager aplicacion = new MailManager();
        User felixtoledo = aplicacion.crearUsuario("Felix", "Toledo", "felixtoledoctes");
        User orifarela = aplicacion.crearUsuario("Oriana", "Farela", "orifarela");
        
        int cantidadDeUsuariosCreados = aplicacion.getListaUsuarios().size();
        User usuarioFelix = aplicacion.getListaUsuarios().get(0);
        
        assertEquals(2, cantidadDeUsuariosCreados);
        assertEquals(felixtoledo, usuarioFelix);
    }
    /* 
    @Test
    public void create_new_user_and_give_it_a_personalized_mail_adress(){
        MailManager femailcom = new MailManager();
        User felixtoledo = femailcom.createNewUser("Felix", "Toledo", "felixtoledoctes@gmail.com");
        String mailOfUserInList = femailcom.getUserList().get(0).getMailAdress();
        String mailOfFelix = felixtoledo.getMailAdress();

        assertEquals(mailOfFelix, mailOfUserInList);
    }*/
    /* 
    @Test 
    public void contact_list_test(){
        MailManager app = new MailManager();
        User felix = app.createNewUser("Felix", "Toledo", "felixtoledoctes");

        felix.addNewContact("rodri", "gonzalez - trabajo", "rodrigo@gmail.com");
        felix.addNewContact("Graciela", "Meza", "gracemeza10@femail.ctes");

        ArrayList<Contact> contactos = felix.getContactList();
        int size = contactos.size();

        assertEquals(2, size);
    }*/

    @Test
    public void user_functions_test(){
        User user = new User("Felix", "Toledo", "felix@gmail.com");
        user.setNombre("Felixito");
        user.setApellido("Perez");
        user.setDireccionCorreo("felixperez@gmail.com");

        String hasToBeName = "Felixito";
        String hasToBeSurname = "Perez";
        String hasToBeMailAdress = "felixperez@gmail.com";

        assertEquals(hasToBeName, user.getNombre());
        assertEquals(hasToBeSurname, user.getApelldio());
        assertEquals(hasToBeMailAdress, user.getDireccionCorreo());
    }

}
