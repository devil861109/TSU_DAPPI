public class App {

    enum Season {
        SPRING(1),
        SUMMER(2),
        AUTUMN(3),
        WINTER(4);

        public final int label;
        Season(int label) {
            this.label = label;
        }

        public int getLabel() {
            return label;
        }
    }

    public static void main(String[] args) {
        //System.out.println(Day.MONDAY);

        for (Day d : Day.values()){
            System.out.println(d);
        }

        for (Season e : Season.values()) {
            System.out.println(e.getLabel());
        }

    }
}
