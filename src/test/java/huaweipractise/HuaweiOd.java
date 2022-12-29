package huaweipractise;

import org.junit.Test;

import java.util.*;
/*
* 思考点如何队map集合的key进行排序
* 1.使用map.keyset()获取所有健的Set集合;Set集合可以转化成为array数组使用toArray;再用数组工具类Arrays.sort方法队数组排序。
* 2.使用treeMap，treeMap会对健进行排序。该集合怎么对健进行排序的？
* 3.使用map.keyset()获取所有健的Set集合；构造ArrayList集合使用set参数构造;在使用Collections工具类对List集合进行排序;
*
* */
public class HuaweiOd {
    public static void main(String[] args) {
        //方式一
      /*  Scanner scanner = new Scanner(System.in);
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
            String a = scanner.nextLine();
            int n=Integer.valueOf(a);
            for (int i=0;i<n;i++){
                String str = scanner.nextLine();
                String[] split = str.split(" ");
                int index = Integer.valueOf(split[0]);
                int value = Integer.valueOf(split[1]);
                if (map.containsKey(index)) {
                    Integer origin = map.get(index);
                    map.put(index,value+origin);
                }else {
                    map.put(index, value);
                }
            }
            Set<Integer> keys = map.keySet();
            Integer[] integer=new Integer[keys.size()];
            Integer[] integers = keys.toArray(integer);
            Arrays.sort(integers);
            for (Integer key : integers) {
                Integer value = map.get(key);
                System.out.println(key+" "+value);
            }*/
        //方式二
        /*Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        String a = scanner.nextLine();
        int n = Integer.valueOf(a);
        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            String[] split = str.split(" ");
            int index = Integer.valueOf(split[0]);
            int value = Integer.valueOf(split[1]);
            if (map.containsKey(index)) {
                Integer origin = map.get(index);
                map.put(index, value + origin);
            } else {
                map.put(index, value);
            }
        }

        Set<Integer> integers = map.keySet();
        for (Integer key : integers) {
            Integer value = map.get(key);
            System.out.println(key + " " + value);
        }*/
        //方式三
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        String a = scanner.nextLine();
        int n = Integer.valueOf(a);
        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            String[] split = str.split(" ");
            int index = Integer.valueOf(split[0]);
            int value = Integer.valueOf(split[1]);
            if (map.containsKey(index)) {
                Integer origin = map.get(index);
                map.put(index, value + origin);
            } else {
                map.put(index, value);
            }
        }

        Set<Integer> integers = map.keySet();
        //将set集合转化为List集合
        List<Integer> list=new ArrayList<Integer>(integers);
        //默认时升序的排列
        Collections.sort(list);
        for (Integer key : list) {
            Integer value = map.get(key);
            System.out.println(key + " " + value);
        }
//        Arrays.sort();
    }
    @Test
    public void test1(){
        //向上取整
        System.out.println(Math.floor(10));
        //向下取整
        System.out.println(Math.ceil(10));
        //怎么将浮点型转化为整形
        //包装类中有对应的方法
        double a=5.0;
        Double aDouble = Double.valueOf(a);
        System.out.println(aDouble.intValue());

    }
}
