package GestorCorreo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class EnviarMailsTest {
@Test
    public void create_app_create_user_send_mail(){
    MailManager aplicacion = new MailManager();
    User lau = aplicacion.crearUsuario("Lautaro", "Vegano", "lauvega");
    User felix = aplicacion.crearUsuario("Felix", "Toledo", "felixt");
    User pedro = aplicacion.crearUsuario("Pedro", "Rosales", "pedro@gmail.com");
    ArrayList<String> para = new ArrayList<>();
    para.add("felixt@aquilita.com");
    para.add("pedro@gmail.com");

    lau.crearMensaje(aplicacion, "Que onda mi hermano", "Buennos dias, quiero pregunntarte como estas", para);
    assertEquals(1, lau.getSalida().tamano());
    assertEquals(1, felix.getEntrada().tamano());
    assertEquals(1, pedro.getEntrada().tamano());
}

}
