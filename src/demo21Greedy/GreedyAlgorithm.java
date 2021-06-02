package demo21Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        //1.初始化所有广播站的集合
        HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
        HashSet<String> b1 = new HashSet<>();
        b1.add("北京");
        b1.add("上海");
        b1.add("天津");
        broadcasts.put("K1", b1);

        HashSet<String> b2 = new HashSet<>();
        b2.add("广州");
        b2.add("北京");
        b2.add("深圳");
        broadcasts.put("K2", b2);

        HashSet<String> b3 = new HashSet<>();
        b3.add("成都");
        b3.add("上海");
        b3.add("杭州");
        broadcasts.put("K3", b3);

        HashSet<String> b4 = new HashSet<>();
        b4.add("上海");
        b4.add("天津");
        broadcasts.put("K4", b4);

        HashSet<String> b5 = new HashSet<>();
        b5.add("杭州");
        b5.add("大连");
        broadcasts.put("K5", b5);

        //2.创建集合，包含所有未覆盖的地区
        HashSet<String> allAreas = new HashSet<>();
        for (HashSet<String> area : broadcasts.values()) {
            allAreas.addAll(area);
        }

        //3.创建一个集合，放入所有被选中的广播站
        ArrayList<String> selects = new ArrayList<>();

        //4.只要allAreas不为空，就要新选中一个广播站，放入selects中
        while (!allAreas.isEmpty()) {
            //定义一个指针，指向希望选中的站
            String selectedStation = null;
            //maxArea存储当前选中的站所能覆盖的地区
            HashSet<String> maxArea = null;
            //遍历所有站
            for (String key : broadcasts.keySet()) {
                HashSet<String> area = broadcasts.get(key);
                //当前站的覆盖地区与未覆盖地区取交集
                area.retainAll(allAreas);
                //指针选中的地区（如果有的话），与未覆盖地区取交集
                if (selectedStation != null) {
                    maxArea = broadcasts.get(selectedStation);
                    maxArea.retainAll(allAreas);
                }
                if (selectedStation == null || area.size() > maxArea.size()) {
                    selectedStation = key;
                }
            }
            //将选中的站加入到selects中，并将已覆盖的地区去除
            if (selectedStation != null) {
                selects.add(selectedStation);
                allAreas.removeAll(broadcasts.get(selectedStation));
            }
        }
        //5.allAreas为空，完成全地区的覆盖
        System.out.println("被选中的站为：" + selects);
    }
}
