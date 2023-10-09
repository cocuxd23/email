package GestorCorreo.Filters;

import java.util.ArrayList;

import GestorCorreo.*;

public class FiltroMensajeAsunto extends Filtro {
     public FiltroMensajeAsunto(){
          super.setNombre("Filtro de Asunto y Mensaje");
     }

     @Override
     public ArrayList<Mail> filtrar(String asuntoBuscar, String mensajeBuscar, Bandeja bandeja){
          FiltroAsunto asuntoFiltro = new FiltroAsunto();
          FiltroMensaje mensajeFiltro = new FiltroMensaje();
          
          ArrayList<Mail> asuntos = asuntoFiltro.filtrar(asuntoBuscar, bandeja);
          ArrayList<Mail> mensajes = mensajeFiltro.filtrar(mensajeBuscar, bandeja);

          ArrayList<Mail> resultado = new ArrayList<>(asuntos);
          resultado.retainAll(mensajes);

          return resultado;
     }

}