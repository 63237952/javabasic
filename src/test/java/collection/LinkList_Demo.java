package collection;

import java.util.LinkedList;

public class LinkList_Demo {
    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(1);
        int index = integers.lastIndexOf(1);
        integers.add(index+1,3);
        integers.offer(4);
        integers.offerFirst(2);
        //找到头元素，并移除
//        integers.poll();
        System.out.println(integers);
    }
}
