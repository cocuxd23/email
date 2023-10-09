package GestorCorreo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MailManager {
    private ArrayList<User> listaUsuarios = new ArrayList<>();
    
    public MailManager() {
    }

    public void mandarMensaje(User remitente, Mail mail){
        ArrayList<String> direccionesDeMail = mail.getPara();
        List<User> usuariosEncontrados = encontrarUsuarioConMail(direccionesDeMail);
        remitente.anadirMailSalida(mail);

        for (User user : usuariosEncontrados){
            user.anadirMailEntrada(mail);
        }
    }

    private List<User> encontrarUsuarioConMail(ArrayList<String> mails) {
        List<User> usuariosEncontrados = listaUsuarios.stream()
                .filter(usuario -> mails.stream()
                        .anyMatch(mail -> usuario.getDireccionCorreo().equals(mail)))
                .collect(Collectors.toList());

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
