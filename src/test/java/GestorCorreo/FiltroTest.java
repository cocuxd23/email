package GestorCorreo;

import org.junit.Test;
import static org.junit.Assert.*;
import GestorCorreo.Filters.*;

import java.util.ArrayList;


public class FiltroTest {
     MailManager app = new MailManager();
     User lautaro = app.crearUsuario("Lautaro", "Salina", "lautaroasalina15");
     User bruno = app.crearUsuario("Bruno", "Pini", "bruno@gmail.com");
     User lucas = app.crearUsuario("Lucas", "Salina", "lucassalina11");

     @Test
     public void filter_from_title(){
          lautaro.anadirContacto("Lucas", "Salina - CASA", "lucassalina11@hyperex.com");
          lautaro.anadirContacto("Bruno", "Sale lol", "bruno@gmail.com");

          lautaro.crearMensaje(app, "BancoEste", "pedilo", lautaro.getTodosLosMailsDeContactos());
          lautaro.crearMensaje(app, "NoBanc0Este", "pdlo", "bruno@gmail.com");
          lautaro.crearMensaje(app, "EsteSiBanco", "pedilo", "lucassalina11@hyperex.com");

          FiltroAsunto filtro = new FiltroAsunto();
          ArrayList<Mail> resultado = lautaro.filtrarSalida("Banco", filtro);
          assertEquals(2, resultado.size());
     }

     @Test
     public void filter_from_message(){
          lautaro.crearMensaje(app, "mensaje a lucas", "hola lucas", "lucassalina11@hyperex.com");
          lautaro.crearMensaje(app, "mensaje a lucas", "chau lucas", "lucassalina11@hyperex.com");
     
          FiltroMensaje filtro = new FiltroMensaje();
          ArrayList<Mail> resultado = lucas.filtrarEntrada("hola", filtro);
          assertEquals(1, resultado.size());
     }

     @Test
     public void filter_from_from(){
          lautaro.crearMensaje(app, "Que onda", "mensaje", "bruno@gmail.com");
          lautaro.crearMensaje(app, "Hola", "mensaje", "bruno@gmail.com");
          lucas.crearMensaje(app, "No banco este", "mensaje", "bruno@gmail.com");

          FiltroRemitente filtro = new FiltroRemitente();
          ArrayList<Mail> resultado = bruno.filtrarEntrada("lautaro", filtro);
          assertEquals(2, resultado.size());
     }

     @Test
     public void filter_from_title_and_from(){
          lautaro.crearMensaje(app, "Coneau", "Les desacreditamos la carrera", "bruno@gmail.com");
          lautaro.crearMensaje(app, "LOL", "jugamos una partida", "bruno@gmail.com");
          lautaro.crearMensaje(app, "Soy", "Lau", "bruno@gmail.com");
          lucas.crearMensaje(app, "No Soy", "Lau", "bruno@gmail.com");

          FiltroRemitenteAsunto filtro = new FiltroRemitenteAsunto();
          ArrayList<Mail> resultado = bruno.filtrarEntrada("Soy", "salina", filtro);
          assertEquals(2, resultado.size());
     }

     @Test
     public void filter_from_title_and_message(){
          lautaro.crearMensaje(app, "hola", "mensaje", "bruno@gmail.com");
          lautaro.crearMensaje(app, "hola mi hermanito", "sale chamba?", "bruno@gmail.com");
          lautaro.crearMensaje(app, "chau", "mensaje", "bruno@gmail.com");
          lucas.crearMensaje(app, "hola", "mensaje", "bruno@gmail.com");

          FiltroMensajeAsunto filtro = new FiltroMensajeAsunto();
          ArrayList<Mail> resultado = bruno.filtrarEntrada("hola", "mensaje", filtro);
          assertEquals(2, resultado.size());
     }

     @Test
     public void nombreFiltro(){
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
