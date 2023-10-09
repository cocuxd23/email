package GestorCorreo.Filters;
import java.util.ArrayList;
import GestorCorreo.*;

public class Filtro {
     private String nombre = "";

     protected ArrayList<Mail> buscarString(String paraBuscar, Bandeja Bandeja){
          return null;
     }

     public ArrayList<Mail> filtrar(String asuntoBuscar, String buscarOtro, Bandeja Bandeja){
          buscarString(asuntoBuscar, Bandeja);
          buscarString(buscarOtro, Bandeja);
          return null;
     }

     public ArrayList<Mail> filtrar(String aBuscar, Bandeja bandeja){
          ArrayList<Mail> mails = buscarString(aBuscar, bandeja);
          return mails;
     }

     public void setNombre(String nombre){
          this.nombre = nombre;
     }

     public String getNombre(){
          return nombre;
     }
}
