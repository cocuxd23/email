package GestorCorreo;

import java.util.ArrayList;

public class Mail {  //Creamos la clase mail
    //priate para que no todos tengan acceso
    private String asunto;
    private String mensaje;
    private String remitente;
    private ArrayList<String> para = new ArrayList<>();  //Guarda una lista de String, que son los correos
    
    //Crea la clase Mail, con los parametros:
    public Mail(String asunto, String mensaje,  String remitente, ArrayList<String> para){ 
        this.asunto = asunto; //Da un espacio de memoria e instancia a las clases
        this.mensaje = mensaje;
        this.remitente = remitente;
        this.para = para;
    }
    //Con el uso de get podemos acceder a las clases
    public String getAsunto() { //Con el get me devulve el nombre 
        return asunto; 
    }

    public ArrayList<String> getPara() {
        return para;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getRemitente(){
        return remitente;
    }
}
