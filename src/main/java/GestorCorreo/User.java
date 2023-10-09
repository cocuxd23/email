package GestorCorreo;

import GestorCorreo.Filters.*;


import java.util.ArrayList;

public class User {

    private ArrayList<Contacto> listaContactos = new ArrayList<>(); //Array list para los contactos

    private Bandeja entrada = new Bandeja(); //Creamos la bandeja de entrada
    private Bandeja salida = new Bandeja(); //Creamos la bandeja de salida

    private String nombre;
    private String apellido;
    private String direccionCorreo;

    public User(String nombre, String apellido, String direccionCorreo){
        this.setNombre(nombre); //Asigan el set nombre el valor nombre 
        this.setApellido(apellido);
        this.setDireccionCorreo(direccionCorreo);
    }

    public Contacto anadirContacto(String nombre, String apellido, String direccionCorreo){ 
        Contacto nuevoContacto = new Contacto(nombre, apellido, direccionCorreo);
        listaContactos.add(nuevoContacto);
        return nuevoContacto;
    }

    public ArrayList<Contacto> getListaContactos(){ //Te muestra la lista de contactos
        return listaContactos;
    }
    //Crea un un array de strings que se llama mails donde recorremos toda la lista de contactos
    public ArrayList<String> getTodosLosMailsDeContactos(){
        ArrayList<String> mails = new ArrayList<>();

        for(Contacto contact : listaContactos){ //Tomamos todos los contactos que estan en la lista, lo recorremos
            mails.add(contact.getDireccionCorreo()); //Y a la lista de contactos se le añade la direccion de correo
        }

        return mails;
    }

    public void crearMensaje(MailManager aplicacion, String asunto, String mensaje, String para) {
        ArrayList<String> listPara = new ArrayList<>();
        listPara.add(para);

        crearMensaje(aplicacion, asunto, mensaje, listPara);
    }
    public void crearMensaje(MailManager aplicacion, String asunto, String mensaje, ArrayList<String> para) { 
        Mail mail = new Mail(asunto, mensaje, this.getDireccionCorreo(), para); //Creo un nuevo email
        aplicacion.mandarMensaje(this, mail);
    }

    public ArrayList<Mail> filtrarSalida(String toSearch, Filtro filterType){
        ArrayList<Mail> finded = filterType.filtrar(toSearch, salida);
        return finded;
    }
    public ArrayList<Mail> filtrarSalida(String searchTitle, String searchOther, Filtro filterType){
        ArrayList<Mail> finded = filterType.filtrar(searchTitle, searchOther, salida);
        return finded;
    }
    public ArrayList<Mail> filtrarEntrada(String toSearch, Filtro filterType){
        ArrayList<Mail> finded = filterType.filtrar(toSearch, entrada);
        return finded;
    }
    public ArrayList<Mail> filtrarEntrada(String searchTitle, String searchOther, Filtro filterType){
        ArrayList<Mail> finded = filterType.filtrar(searchTitle, searchOther, entrada);
        return finded;
    }
    //Añade un mail a la entrada, pero añade un clon, porque si no clona la persona puede modificar el mail
    public void anadirMailEntrada(Mail mail){ 
        Mail newMail = new Mail(mail.getAsunto(), mail.getMensaje(), mail.getRemitente(), mail.getPara());
        entrada.anadir(newMail);
    }

    public void anadirMailSalida(Mail mail){ //Usamos añadir porque no queres mostrar sino añadir una lista
        salida.anadir(mail); //Se añade el original
    }

    public void setDireccionCorreo(String direccionCorreo) {
        if(direccionCorreo.contains("@")){
            this.direccionCorreo = direccionCorreo;
        } else {
            this.direccionCorreo = direccionCorreo + "@hyperex.com";
        }
    }

    public String getDireccionCorreo() {
        return direccionCorreo;
    }

    public void setNombre(String nombre) { //Tenemos la instancia nombre que va a ser un nuevo nombre
        this.nombre = nombre;
    }

    public String getNombre() { //Y con el get me retorna ese nombre
        return nombre;
    }

    public void setApellido(String apellido) {
       this.apellido = apellido;
    }

    public String getApelldio() {
        return apellido;
    }

    public Bandeja getSalida() {
        return salida;
    }
    
    public Bandeja getEntrada() {
        return entrada;
    }
}
