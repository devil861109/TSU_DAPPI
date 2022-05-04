public class Usuario4 {
     private String nombre;
     private int edad;
     private String direccion;

     /* El constructor de la clase Usuario4 esta sobrecargado */
     public Usuario4() {
        nombre = null;
        edad = 0;
        direccion = null;
     }

     public Usuario4(String nombre, int edad, String direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
     }

     public Usuario4(Usuario4 usr) {
        nombre = usr.getNombre();
        edad = usr.getEdad();
        direccion = usr.getDireccion();
     }

     public void setNombre(String n) {
        nombre = n;
     }

     public String getNombre() {
        return nombre;
     }

     /* El metodo setEdad() está sobrecargado */
     public void setEdad(int e) {
        edad = e;
     }

     public void setEdad(float e) {
        edad = (int)e;
     }

     public int getEdad() {
        return edad;
     }

     public void setDireccion(String d) {
        direccion = d;
     }

     public String getDireccion() {
        return direccion;
     }
}