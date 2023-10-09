package GestorCorreo.Filters;
import java.util.ArrayList;
import GestorCorreo.*;
import java.util.stream.Collectors;


public class FiltroRemitente extends Filtro {

        public FiltroRemitente(){
                super.setNombre("Filtro de Remitente");
        }
     @Override
     protected ArrayList<Mail> buscarString(String aBuscar, Bandeja bandeja) {
          ArrayList<Mail> mails = bandeja.traerTodo().stream()
                  .filter(mail -> mail.getRemitente().contains(aBuscar))
                  .collect(Collectors.toCollection(ArrayList::new)); 
          return mails; 
      }

}
