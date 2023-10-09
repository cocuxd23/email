package GestorCorreo.Filters;
import java.util.ArrayList;
import GestorCorreo.*;

public abstract class Filtro {
     private String nombre = "";

     protected ArrayList<Mail> buscarString(String paraBuscar, Bandeja Bandeja){
          return null; //Retorna null porque solo uso internamente en cada hijo
     }

     public ArrayList<Mail> filtrar(String asuntoBuscar, String buscarOtro, Bandeja Bandeja){ //En caso de tener dos Strings
          buscarString(asuntoBuscar, Bandeja);  //Busca dos veces en cada hijo
          buscarString(buscarOtro, Bandeja);
          return null;
     }

     public ArrayList<Mail> filtrar(String aBuscar, Bandeja bandeja){ //Recibe un String
          ArrayList<Mail> mails = buscarString(aBuscar, bandeja); //Busca el String en la bandeja y lo guarda en mails
          return mails;
     }

     public void setNombre(String nombre){
          this.nombre = nombre;
     }

     public String getNombre(){
          return nombre;
     }
}
