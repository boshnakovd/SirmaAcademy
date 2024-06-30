package jar;
import java.util.Stack;

public class Jar<T> {
    private Stack<T> elements;

    // Constructor
    public Jar() {
        this.elements = new Stack<>();
    }

    // Add an element to the jar
    public void add(T element) {
        elements.push(element);
    }

    // Remove the topmost element from the jar
    public T remove() {
        if (elements.isEmpty()) {
            throw new RuntimeException("Jar is empty");
        }
        return elements.pop();
    }

    // Check if the jar is empty
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    // Get the size of the jar
    public int size() {
        return elements.size();
    }
}
