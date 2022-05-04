public class StringComp {
    public static void main(String[] args) {
        String n1 = "Kevin";
        String n2 = "Kevin";
        String n3 = new String("Kevin");
        String n4 = new String("Kevin");
        String n5 = new String("Peter");

        System.out.print("n1 == n2 : ");
        System.out.println(n1 == n2); //true
        System.out.print("n1.equals(n2) : ");
        System.out.println(n1.equals(n2)); //true

        System.out.print("n2 == n3 : ");
        System.out.println(n2 == n3); //false
        System.out.print("n2.equals(n3) : ");
        System.out.println(n2.equals(n3)); //true

        System.out.print("n3 == n4 : ");
        System.out.println(n3 == n4); //false
        System.out.print("n3.equals(n4) : ");
        System.out.println(n3.equals(n4)); //true

        System.out.print("n4 == n5 : ");
        System.out.println(n4 == n5); //false
        System.out.print("n4.equals(n5) : ");
        System.out.println(n4.equals(n5)); //false
    }
}
