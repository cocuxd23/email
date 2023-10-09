package GestorCorreo;

import java.util.ArrayList;

public class Bandeja {

    private ArrayList<Mail> mails = new ArrayList<>();

    public int tamano(){  //Cuenta los espacios de memoria que tiene mails 
        return mails.size();  //Y te devuelve un valor entero que va a ser un tamaño
    }


    public void anadir(Mail mail) {
        mails.add(mail);
    }

    public Mail traer(int index){ //Getea el index y trae el primer mail
        return mails.get(index);  //Vos decidis que mail queres que te traiga
    }

    public ArrayList<Mail> traerTodo(){
        return mails;  //Retorna todos los mails
    }
}
