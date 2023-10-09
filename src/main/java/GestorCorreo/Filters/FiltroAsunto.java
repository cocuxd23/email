package GestorCorreo.Filters;
import java.util.ArrayList;
import GestorCorreo.*;
import java.util.stream.Collectors;


public class FiltroAsunto extends Filtro {

     
     public FiltroAsunto(){
          super.setNombre("Filtro de Asunto");
     }

     @Override
     protected ArrayList<Mail> buscarString(String aBuscar, Bandeja bandeja) {
          ArrayList<Mail> mails = bandeja.traerTodo().stream()
                  .filter(mail -> mail.getAsunto().contains(aBuscar))
                  .collect(Collectors.toCollection(ArrayList::new)); // Collect the filtered mails into an ArrayList
          return mails; // Return the ArrayList containing filtered mails
      }

}
