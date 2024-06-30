package jar;

public class Main {
    public static void main(String[] args) {
        // Creating a jar for strings
        Jar<String> jarOfString = new Jar<>();
        jarOfString.add("apple");
        jarOfString.add("banana");
        System.out.println(jarOfString.remove()); // Output: banana
        System.out.println(jarOfString.remove()); // Output: apple

        // Creating a jar for integers
        Jar<Integer> jarOfInteger = new Jar<>();
        jarOfInteger.add(42);
        jarOfInteger.add(27);
        System.out.println(jarOfInteger.remove()); // Output: 27
        System.out.println(jarOfInteger.remove()); // Output: 42
    }
}