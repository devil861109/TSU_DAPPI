public class Main {
    public static void main(String[] args) {
        Empleado empleado;
        empleado = new Escritor("Juan", 15000, TipoEscritura.CLASICO);
        System.out.println("empleado = " + empleado);

        System.out.println(empleado.obtenerDetalles());

        //downcasting
        Escritor escritor = (Escritor) empleado;
        escritor.getTipoEscritura();
        //System.out.println(((Escritor)empleado).getTipoEscritura());

        //upcasting
        Empleado empleado2 = escritor;

    }
}
