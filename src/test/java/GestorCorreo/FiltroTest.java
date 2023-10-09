package GestorCorreo;

import org.junit.Test;
import static org.junit.Assert.*;
import GestorCorreo.Filters.*;

import java.util.ArrayList;


public class FiltroTest {
     MailManager app = new MailManager();
     User felix = app.crearUsuario("Lautaro", "Salina", "lautaroasalina15");
     User rodrigo = app.crearUsuario("Bruno", "Pini", "bruno@gmail.com");
     User grace = app.crearUsuario("Lucas", "Salina", "lucassalina11");

     //User felix = app.crearUsuario("Felix", "Toledo", "felixtoledoctes");
     //User rodrigo = app.crearUsuario("rodri", "Gonzalez", "rodrigo@gmail.com");
     //User grace = app.crearUsuario("grace", "meza", "gracemeza10");
     

     @Test
     public void filter_from_title(){
          felix.anadirContacto("Gracielita", "Meza - TRABAJO", "gracemeza10@aquilita.com");
          felix.anadirContacto("Rodri", "Mi hermano", "rodrigo@gmail.com");

          felix.crearMensaje(app, "BuscoEste", "mensaje", felix.getTodosLosMailsDeContactos());
          felix.crearMensaje(app, "Nobuskoezte", "mjito", "rodrigo@gmail.com");
          felix.crearMensaje(app, "EsteSiBusco", "mensaje", "gracemeza10@aquilita.com");

          FiltroAsunto filtro = new FiltroAsunto();
          ArrayList<Mail> resultado = felix.filtrarSalida("Busco", filtro);
          assertEquals(2, resultado.size());
     }

     @Test
     public void filter_from_message(){
          felix.crearMensaje(app, "mensaje a grace", "hola graciela", "gracemeza10@aquilita.com");
          felix.crearMensaje(app, "mensaje a grace", "chau grace", "gracemeza10@aquilita.com");
     
          FiltroMensaje filtro = new FiltroMensaje();
          ArrayList<Mail> resultado = grace.filtrarEntrada("hola", filtro);
          assertEquals(1, resultado.size());
     }

     @Test
     public void filter_from_from(){
          felix.crearMensaje(app, "hola", "mjito", "rodrigo@gmail.com");
          felix.crearMensaje(app, "chau", "mjito", "rodrigo@gmail.com");
          grace.crearMensaje(app, "Nobuskoezte", "mjito", "rodrigo@gmail.com");

          FiltroRemitente filtro = new FiltroRemitente();
          ArrayList<Mail> resultado = rodrigo.filtrarEntrada("felixto", filtro);
          assertEquals(2, resultado.size());
     }

     @Test
     public void filter_from_title_and_from(){
          felix.crearMensaje(app, "hola", "mjito", "rodrigo@gmail.com");
          felix.crearMensaje(app, "hola mi hermano", "quiero que hablemos", "rodrigo@gmail.com");
          felix.crearMensaje(app, "chau", "mjito", "rodrigo@gmail.com");
          grace.crearMensaje(app, "hola", "mjito", "rodrigo@gmail.com");

          FiltroRemitenteAsunto filtro = new FiltroRemitenteAsunto();
          ArrayList<Mail> resultado = rodrigo.filtrarEntrada("hola", "felix", filtro);
          assertEquals(2, resultado.size());
     }

     @Test
     public void filter_from_title_and_message(){
          felix.crearMensaje(app, "hola", "mi hermano", "rodrigo@gmail.com");
          felix.crearMensaje(app, "este no", "mi hermano", "rodrigo@gmail.com");
          felix.crearMensaje(app, "chau", "este no busco", "rodrigo@gmail.com");
          grace.crearMensaje(app, "hola", "hermano, como estas?", "rodrigo@gmail.com");

          FiltroMensajeAsunto filtro = new FiltroMensajeAsunto();
          ArrayList<Mail> resultado = rodrigo.filtrarEntrada("hola", "hermano", filtro);
          assertEquals(2, resultado.size());
     }

     @Test
     public void name_of_filters(){
          FiltroRemitente filtroRemitente = new FiltroRemitente();
          FiltroMensaje filtroMensaje = new FiltroMensaje();
          FiltroAsunto filtroAsunto = new FiltroAsunto();

          String nombreFiltroRemitente = filtroRemitente.getNombre();
          String nombreFiltroMensaje = filtroMensaje.getNombre();
          String nombreFiltroAsunto = filtroAsunto.getNombre();

          assertEquals("Filtro de Remitente", nombreFiltroRemitente);
          assertEquals("Filtro de Mensaje", nombreFiltroMensaje);
          assertEquals("Filtro de Asunto", nombreFiltroAsunto);

     }
}
