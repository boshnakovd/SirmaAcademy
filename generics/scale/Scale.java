package scale;

public class Scale<T extends Comparable<T>> {
    private final T left;
    private final T right;

    // Constructor
    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    // Method to get the heavier element
    public T getHeavier() {
        int comparison = left.compareTo(right);
        if (comparison > 0) {
            return left;
        } else if (comparison < 0) {
            return right;
        } else {
            String s = "equal";
            return (T) s;
        }
    }
}