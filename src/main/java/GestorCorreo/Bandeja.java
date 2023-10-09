package GestorCorreo;

import java.util.ArrayList;

public class Bandeja {

    private ArrayList<Mail> mails = new ArrayList<>();

    public int tamano(){
        return mails.size();
    }


    public void anadir(Mail mail) {
        mails.add(mail);
    }

    public Mail traer(int index){
        return mails.get(index);
    }

    public ArrayList<Mail> traerTodo(){
        return mails;
    }
}
