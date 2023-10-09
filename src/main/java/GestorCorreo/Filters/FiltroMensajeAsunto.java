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
          
          ArrayList<Mail> asuntos = asuntoFiltro.filtrar(asuntoBuscar, bandeja); //Son todos los asuntos que me coincidio con el asuntoBuscar
          ArrayList<Mail> mensajes = mensajeFiltro.filtrar(mensajeBuscar, bandeja);

          ArrayList<Mail> resultado = new ArrayList<>(asuntos); //Guardo los asuntos en resultado
          resultado.retainAll(mensajes); //Solamente quedan los asuntos que coinciden con mensaje

          return resultado;
     }

}