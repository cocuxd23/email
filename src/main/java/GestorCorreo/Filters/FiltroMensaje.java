package GestorCorreo.Filters;
import java.util.ArrayList;
import GestorCorreo.*;
import java.util.stream.Collectors;


public class FiltroMensaje extends Filtro {

        public FiltroMensaje(){
                super.setNombre("Filtro de Mensaje");
        }
        
     @Override
     protected ArrayList<Mail> buscarString(String aBuscar, Bandeja bandeja) {
          ArrayList<Mail> mails = bandeja.traerTodo().stream()
                  .filter(mail -> mail.getMensaje().contains(aBuscar))
                  .collect(Collectors.toCollection(ArrayList::new)); // Collect the filtered mails into an ArrayList
          return mails; // Return the ArrayList containing filtered mails
      }

}
