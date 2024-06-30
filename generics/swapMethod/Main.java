package swapMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();


        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLine());
        }


        String[] swapCommand = scanner.nextLine().split(" ");
        int index1 = Integer.parseInt(swapCommand[0]);
        int index2 = Integer.parseInt(swapCommand[1]);


        Util.swap(list, index1, index2);


        for (String item : list) {
            System.out.println("java.lang.String: " + item);
        }

        scanner.close();
    }
}