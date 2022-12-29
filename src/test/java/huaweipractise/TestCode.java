package huaweipractise;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TestCode {
    public static void main(String[] args) {
        //TreeMap怎么对字符串进行排序的 按照字典的顺序排序
        //构建时，可以使用Comparator参数定义排序
        //如果需要对值进行排序的话,思考一下？
        Map<String, String> map = new TreeMap<String, String>( new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //字符串使用compareTo
                return o1.compareTo(o2);
            }
        });
/*        map.put("2019-03","c");
        map.put("2018-12","a");
        map.put("2019-01","d");
        map.put("2019-02","b");*/
        map.put("ccab","1");
        map.put("ccba","2");
        map.put("ccac","3");

        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            String value = map.get(key);
            System.out.println(key+" "+value);
        }

    }
}
