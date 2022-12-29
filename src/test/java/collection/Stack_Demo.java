package collection;

import java.util.Stack;

public class Stack_Demo {
    public static void main(String[] args) {
        Stack<Integer> integers = new Stack<>();
        integers.add(11);
        integers.add(12);
        System.out.println(integers.pop());
        System.out.println(integers);
    }
}
