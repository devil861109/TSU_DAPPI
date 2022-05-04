public class StringIntern {
    public static void main(String[] args) {
        String constantString = "Kevin";

        String newString = new String("Kevin");
        System.out.println(constantString == newString); //false
        System.out.println(constantString.equals(newString));//true

        newString = newString.intern();

        System.out.println(constantString == newString); //true
        System.out.println(constantString.equals(newString));//true
    }
}
