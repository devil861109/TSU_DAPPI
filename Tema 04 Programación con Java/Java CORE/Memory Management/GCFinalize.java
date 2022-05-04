public class GCFinalize {
    public static void main(String[] args) {
        //correr varias veces y ver que es NO DETERMINADO EL GC
        //Car car = new Car();
        //car = null;
        //System.gc();

        for (int i = 0; i < 50; i++) {
            Car car = new Car();
            car = null;
            System.gc();
        }
    }
}
