package GestorCorreo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MailManager { //Mail manager es el unico que conoce a todos los usuarios
    private ArrayList<User> listaUsuarios = new ArrayList<>();
    
    public void mandarMensaje(User remitente, Mail mail){ //Remitenete: usuario que manda y Mail: que se va a mandar
        ArrayList<String> direccionesDeMail = mail.getPara(); //La lista de array los guarda en el para 
        List<User> usuariosEncontrados = encontrarUsuarioConMail(direccionesDeMail);
        remitente.anadirMailSalida(mail); //Añade al mail de entrada

        for (User user : usuariosEncontrados){
            user.anadirMailEntrada(mail); //Añade al mail de salida
        }
    }

    private List<User> encontrarUsuarioConMail(ArrayList<String> mails) { //Esta lista lo paso a .stream para filtrar
        List<User> usuariosEncontrados = listaUsuarios.stream()
                .filter(usuario -> mails.stream() //El filtro reccore listaUsuarios y le pone un nombre dependiente en que usuario este
                        .anyMatch(mail -> usuario.getDireccionCorreo().equals(mail))) //Compara los usuarios de lista con los mails de la lista
                .collect(Collectors.toList()); //Si coincide me devuele (colecta)

        return usuariosEncontrados;
    }

    public void anadirUsuarioALista(User usuarioNuevo) {
        listaUsuarios.add(usuarioNuevo);
    }
    
    public User crearUsuario(String nombre, String apellido, String direcCorreo){
        User usuario = new User(nombre, apellido, direcCorreo);
        anadirUsuarioALista(usuario);
        return usuario;
    }

    //Test purpose
    public ArrayList<User> getListaUsuarios() {
        return listaUsuarios;
    }
}
