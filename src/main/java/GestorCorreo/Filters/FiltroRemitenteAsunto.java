package GestorCorreo.Filters;

import java.util.ArrayList;

import GestorCorreo.*;

public class FiltroRemitenteAsunto extends Filtro {
     public FiltroRemitenteAsunto(){
          super.setNombre("Filtro de Asunto y Remitente");
     }

     @Override
     public ArrayList<Mail> filtrar(String asuntoBuscar, String remitenteABuscar, Bandeja bandeja){
          FiltroAsunto asuntoFiltro = new FiltroAsunto();
          FiltroRemitente remitenteFiltro = new FiltroRemitente();

          ArrayList<Mail> asuntos = asuntoFiltro.filtrar(asuntoBuscar, bandeja);
          ArrayList<Mail> remitentes = remitenteFiltro.filtrar(remitenteABuscar, bandeja);

          ArrayList<Mail> resultado = new ArrayList<>(asuntos);
          resultado.retainAll(remitentes);

          return resultado;
     }

}
