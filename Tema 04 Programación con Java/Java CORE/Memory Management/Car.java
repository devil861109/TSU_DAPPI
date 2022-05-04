public class Car {

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this + " object cleaned from heap memory");
    }
}
