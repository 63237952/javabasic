package huaweipractise;

import java.util.*;

public class HuaweiOd6HJ19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Record,Integer> map=new HashMap<Record,Integer>();
        int i=1;
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String error_record = in.nextLine();
            if(error_record.length()>=1&&error_record.length()<=100){
                String[] split=error_record.split("\\\\");
                String[] split_=split[split.length-1].split(" ");
                if(split_[0].length()>16){
                    int a=split_[0].length()-8;
                    split_[0].substring(a);
                }
                Record re=new Record();
                re.setFilename(split_[0]);
                re.setLine(Integer.valueOf(split_[1]));
                if(map.containsKey(re)){
                    Set<Record> set=map.keySet();
                    for(Record res:set){
                        if(res.equals(re)){
                            res.setCount();
                        }
                    }
                    continue;
                }
                //以值作为排序
                map.put(re,i);
                System.out.println(map.keySet().iterator().next());
                i++;
                if (i==9){
                    break;
                }

            }

        }
        Set<Map.Entry<Record,Integer>> set=map.entrySet();
        List<Map.Entry<Record,Integer>> list=new ArrayList<Map.Entry<Record,Integer>>(set);
        Collections.sort(list,(Map.Entry<Record,Integer> m1,Map.Entry<Record,Integer> m2)->{
            return m1.getValue()-m2.getValue();
        });
        if(list.size()>8){
            int a=list.size()-8;
            for(int j=a;j<list.size();j++){
                Map.Entry<Record,Integer> en= list.get(j);
                System.out.println(en.getKey().getFilename()+" "+en.getKey().getLine()+" "+en.getKey().getCount());

            }
            return;
        }
        for(int j=0;j<list.size();j++){
            Map.Entry<Record,Integer> en= list.get(j);
            System.out.println(en.getKey().getFilename()+" "+en.getKey().getLine()+" "+en.getKey().getCount());
        }
        return;
    }
    static class Record{
        private String filename;
        private int line;
        private int count=1;
        public void setFilename(String str){
            this.filename=str;
        }
        public void setLine(int line){
            this.line=line;
        }
        public void setCount(){
            this.count++;
        }
        public String getFilename(){
            return this.filename;
        }
        public int getLine(){
            return this.line;
        }
        public int getCount(){
            return this.count;
        }
        @Override
        public boolean equals(Object obj){
            Record r2 = (Record) obj;
            if(!this.getFilename().equals(r2.filename)) return false;
            if(!(this.getLine()==r2.getLine())) return false;
            return true;
        }
        @Override
        public int hashCode() {
            return Objects.hash(filename,line);
        }

//        @Override
//        public int hashCode() {
//
//            return Objects.hash(filename, line, count);
//        }
    }
}
