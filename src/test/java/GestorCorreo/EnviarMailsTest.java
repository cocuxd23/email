package GestorCorreo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class EnviarMailsTest {
@Test
    public void create_app_create_user_send_mail(){
    MailManager aplicacion = new MailManager();
    User ori = aplicacion.crearUsuario("Oriana", "Farela", "orifarela");
    User paulina = aplicacion.crearUsuario("Paulina", "Palmeyro", "pauliyro");
    User gonza = aplicacion.crearUsuario("Gonza", "Cabral", "gonza@gmail.com");
    ArrayList<String> para = new ArrayList<>();
    para.add("pauliyro@aquilita.com");
    para.add("gonza@gmail.com");

    //User lau = aplicacion.crearUsuario("Lautaro", "Vegano", "lauvega");
    //User felix = aplicacion.crearUsuario("Felix", "Toledo", "felixt");
   //User pedro = aplicacion.crearUsuario("Pedro", "Rosales", "pedro@gmail.com");

    ori.crearMensaje(aplicacion, "Juntada", "Buennos dias, estan para juntarse mañana?", para);
    assertEquals(1, ori.getSalida().tamano());
    assertEquals(1, paulina.getEntrada().tamano());
    assertEquals(1, gonza.getEntrada().tamano());
}

}
