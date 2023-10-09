package GestorCorreo;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class BandejaTest {
     @Test
     public void creation_of_box(){
          Bandeja bandeja = new Bandeja();
          ArrayList<String> para = new ArrayList<>();
          Mail mail1 = new Mail("Hola", "Felix", "Como", para);
          Mail mail2 = new Mail("Hola2", "Felix2", "Como2", para);

          bandeja.anadir(mail1);
          bandeja.anadir(mail2);

          for(int i = 0; i < 50; i++) {
               Mail mail = new Mail("Mail" + i, "Sender" + i, "remitente" + i, para);
               bandeja.anadir(mail);
          }

          Mail deberiaSer2 = bandeja.traer(1);

          assertEquals(mail2, deberiaSer2);
          assertEquals(52, bandeja.tamano());
     }
}
