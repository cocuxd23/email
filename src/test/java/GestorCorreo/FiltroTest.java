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
          lautaro.anadirContacto("Lucas", "Salina - CASA", "lucas10@hyperex.com");
          lautaro.anadirContacto("Bruno", "Sale lol", "bruno@gmail.com");

          lautaro.crearMensaje(app, "BancoEste", "pedilo", lautaro.getTodosLosMailsDeContactos());
          lautaro.crearMensaje(app, "NoBancoEste", "pdlo", "bruno@gmail.com");
          lautaro.crearMensaje(app, "EsteSiBanco", "pedilo", "lucas10@aquilita.com");

          FiltroAsunto filtro = new FiltroAsunto();
          ArrayList<Mail> resultado = lautaro.filtrarSalida("Banco", filtro);
          assertEquals(2, resultado.size());
     }

     @Test
     public void filter_from_message(){
          lautaro.crearMensaje(app, "mensaje a lucas", "hola lucas", "lucas10@aquilita.com");
          lautaro.crearMensaje(app, "mensaje a lucas", "chau lucas", "10@aquilita.com");
     
          FiltroMensaje filtro = new FiltroMensaje();
          ArrayList<Mail> resultado = lucas.filtrarEntrada("hola", filtro);
          assertEquals(1, resultado.size());
     }

     @Test
     public void filter_from_from(){
          lautaro.crearMensaje(app, "Que onda", "Como estas", "bruno@gmail.com");
          lautaro.crearMensaje(app, "Hola", "Nos juntamos", "bruno@gmail.com");
          lucas.crearMensaje(app, "No banco este", "Mentira", "bruno@gmail.com");

          FiltroRemitente filtro = new FiltroRemitente();
          ArrayList<Mail> resultado = bruno.filtrarEntrada("felixto", filtro);
          assertEquals(2, resultado.size());
     }

     @Test
     public void filter_from_title_and_from(){
          lautaro.crearMensaje(app, "Coneau", "Les desacreditamos la carrera", "bruno@gmail.com");
          lautaro.crearMensaje(app, "LOL", "jugamos una partida", "bruno@gmail.com");
          lautaro.crearMensaje(app, "Soy", "Lau", "bruno@gmail.com");
          lucas.crearMensaje(app, "No soy", "Lau", "rodrigo@gmail.com");

          FiltroRemitenteAsunto filtro = new FiltroRemitenteAsunto();
          ArrayList<Mail> resultado = bruno.filtrarEntrada("Hola", "salina", filtro);
          assertEquals(2, resultado.size());
     }

     @Test
     public void filter_from_title_and_message(){
          lautaro.crearMensaje(app, "Sale", "chambear", "bruno@gmail.com");
          lautaro.crearMensaje(app, "Nos vemos", "mañana", "bruno@gmail.com");
          lautaro.crearMensaje(app, "Si", "quiero", "bruno@gmail.com");
          lucas.crearMensaje(app, "No", "nos juntamos mañana?", "bruno@gmail.com");

          FiltroMensajeAsunto filtro = new FiltroMensajeAsunto();
          ArrayList<Mail> resultado = bruno.filtrarEntrada("hola", "amigo", filtro);
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
