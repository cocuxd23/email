package GestorCorreo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class EnviarMailsTest { //Creo la clase enviar mails
    MailManager aplicacion = new MailManager();
    User ori = aplicacion.crearUsuario("Oriana", "Farela", "orifarela");
    User paulina = aplicacion.crearUsuario("Paulina", "Palmeyro", "pauliyro");
    User gonza = aplicacion.crearUsuario("Gonza", "Cabral", "gonza@gmail.com");
  
@Test
    public void create_app_create_user_send_mail(){
    
    ArrayList<String> para = new ArrayList<>();
    para.add("pauliyro@hyperex.com");
    para.add("gonza@gmail.com");

    ori.crearMensaje(aplicacion, "Juntada", "Buennos dias, estan para juntarse mañana?", para);
    assertEquals(1, ori.getSalida().tamano());
    assertEquals(1, paulina.getEntrada().tamano());
    assertEquals(1, gonza.getEntrada().tamano());
}
@Test
    public void enviar100mails(){
        User remitente1 = aplicacion.crearUsuario("Oriana", "Farela", "orifarela");

        ArrayList<String> para = new ArrayList<>();
        for (int i = 0; i <= 99; i++) {
            aplicacion.crearUsuario("Nombre" + i, "Apellido"+i, "correo"+i);
            para.add("correo"+i+"@hyperex.com");
        }
        remitente1.crearMensaje(aplicacion, "Buenas", "Como estas", para);
        int bandejaSalidaLautaro = remitente1.getSalida().tamano();

        assertEquals(100, para.size());
        assertEquals(1, bandejaSalidaLautaro);
        assertEquals("Buenas", remitente1.getSalida().traer(0).getAsunto());
        for (int i = 4; i <= 102; i++) {
            assertEquals(1, aplicacion.getListaUsuarios().get(i).getEntrada().tamano());
            assertEquals("Buenas", aplicacion.getListaUsuarios().get(i).getEntrada().traer(0).getAsunto());
        }
    }
}