
public class Sobrecarga{
    public void demoSobrec(){
        System.out.println("Sin parámetros\n");
    }
    
    //Sobrecargando demoSobrec para un parámetro int
    public void demoSobrec(int a){
        System.out.println("Un parámetro: " +a+"\n");
    }
    
    //Sobrecargando demoSobrec para dos parámetros int
    public int demoSobrec(int a, int b){
        System.out.println("Dos parámetros: "+a+", "+b);
        return a+b;
    }
    
    //Sobrecargando demoSobrec para dos parámetros double
    public double demoSobrec(double a, double b){
        System.out.println("Dos parámetros tipo double: "+a+", "+b);
        return a+b;
    }
}