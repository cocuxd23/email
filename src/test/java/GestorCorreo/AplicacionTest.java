package GestorCorreo;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void check_instance_of_app() {
        MailManager aplicaion = new MailManager();
        assertTrue(aplicaion instanceof MailManager);
    }


}
