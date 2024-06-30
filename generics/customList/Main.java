package customList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> customList = new CustomList<>();

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }

            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    String elementToAdd = tokens[1];
                    customList.add(elementToAdd);
                    break;

                case "Remove":
                    int indexToRemove = Integer.parseInt(tokens[1]);
                    customList.remove(indexToRemove);
                    break;

                case "Contains":
                    String elementToCheck = tokens[1];
                    System.out.println(customList.contains(elementToCheck));
                    break;

                case "Swap":
                    int index1 = Integer.parseInt(tokens[1]);
                    int index2 = Integer.parseInt(tokens[2]);
                    customList.swap(index1, index2);
                    break;

                case "Greater":
                    String elementToCompare = tokens[1];
                    System.out.println(customList.countGreaterThan(elementToCompare));
                    break;

                case "Max":
                    System.out.println(customList.getMax());
                    break;

                case "Min":
                    System.out.println(customList.getMin());
                    break;

                case "Print":
                    customList.print();
                    break;

                default:
                    System.out.println("Unknown command.");
                    break;
            }
        }

        scanner.close();
    }
}