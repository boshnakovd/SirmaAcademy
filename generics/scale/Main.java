package scale;

public class Main {
    public static void main(String[] args) {

        Scale<Integer> intScale = new Scale<>(10, 20);
        System.out.println("Heavier Integer: " + intScale.getHeavier());

        Scale<String> stringScale = new Scale<>("Apple", "Banana");
        System.out.println("Heavier String: " + stringScale.getHeavier());

        Scale<String> equalScale = new Scale<>("Same", "Same");
        System.out.println("Heavier or equal: " + equalScale.getHeavier());
    }
}