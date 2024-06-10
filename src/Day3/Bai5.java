package Day3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();

        ArrayList<String> operations = new ArrayList<>();
        for (int i = 0; i <= Q; i++) {
            operations.add(sc.nextLine());
        }
        operations.remove(0);

        String s = new String();
        Stack<String> stack = new Stack<>();
        stack.push(s);


        for (int i = 0; i < Q; i++) {
            String op = operations.get(i);
            String arr[] = op.split(" ");

            switch (arr[0]) {

                case "1": {
                    s += arr[1];
                    stack.push(s);
                    break;
                }
                case "2": {
                    s = s.substring(0, s.length() - Integer.parseInt(arr[1]));
                    stack.push(s);
                    break;
                }
                case "3": {
                    int k = Integer.parseInt(arr[1]);
                    System.out.println(s.charAt(k - 1));
                    break;
                }
                case "4": {
                    stack.pop();
                    s = stack.peek();
                }

            }

        }
    }
}
