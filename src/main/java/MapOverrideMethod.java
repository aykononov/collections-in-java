public class MapOverrideMethod {

    private String name;
    private double sum;

    public MapOverrideMethod(String name, double sum) {
        this.name = name;
        this.sum = sum;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public static void main(String[] args) {

        MapOverrideMethod example1 = new MapOverrideMethod("Some name", 34);
        MapOverrideMethod example2 = new MapOverrideMethod("Another name", 12.5);
        System.out.println(example1.hashCode());
        System.out.println(example2.hashCode());

    }

}

/* ------------
1
1
 */