package GestorCorreo;


public class Contacto {

     private String nombre;
     private String apellido;
     private String direccionCorreo;

    public Contacto(String nombre, String apellido, String direccionCorreo){
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDireccionCorreo(direccionCorreo);
    }

    public void setDireccionCorreo(String direccionCorreo) {
        this.direccionCorreo = direccionCorreo;
    }

    public String getDireccionCorreo() {
        return direccionCorreo;
    }

    public void setNombre(String nombre) {
          this.nombre = nombre;
    }

    public String getNombre(){
          return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }
}