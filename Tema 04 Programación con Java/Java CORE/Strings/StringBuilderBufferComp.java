public class StringBuilderBufferComp {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        long startTime = System.currentTimeMillis();

        for (int i = 0 ; i < 10000000; i++) {
            stringBuffer.append("Java");
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Duration of StringBuffer's running is: " + duration + " milliseconds");


        StringBuilder stringBuilder = new StringBuilder();
        long startTime2 = System.currentTimeMillis();

        for (int i = 0 ; i < 10000000; i++) {
            stringBuilder.append("Java");
        }

        long endTime2 = System.currentTimeMillis();
        long duration2 = endTime2 - startTime2;
        System.out.println("Duration of StringBuffer's running is: " + duration2 + " milliseconds");
    }
}
