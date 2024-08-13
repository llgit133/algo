package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

    // 无序输出
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("name","liming");
        map.put("age","12");
        map.put("sex","男");

        // map 的遍历  entry 拿到每一次put的记录
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        // map的遍历-2
        for (String key : map.keySet()) {
            // keySet 拿到所有的key 然后遍历
            // value

            System.out.println("key:"+ key+" value: "+map.get(key));
        }


        //contains 测试
        if (map.containsKey("name")) {
            System.out.println("测试containsKey 包含name");
        }
        if (map.containsValue("liming")) {
            System.out.println("测试containsValue  包含liming");
        }


        map.put(null,"2");
        map.put("22",null);
        System.out.println(map);

    }
}



/**
 * HashMap常用方法：
 * 1、put(K key, V value)： 将键（key）/值（value）映射存放到Map集合中。
 * 2、get(Object key)： 返回指定键所映射的值，没有该key对应的值则返回 null。
 * 3、size()： 返回Map集合中数据数量。
 * 4、clear()： 清空Map集合。
 * 5、isEmpty()： 判断Map集合中是否有数据，如果没有则返回true，否则返回false。
 * 6、remove(Object key)： 删除Map集合中键为key的数据并返回其所对应value值。
 * 7、values()： 返回Map集合中所有value组成的以Collection数据类型格式数据。
 * 8、containsKey(Object key)： 判断集合中是否包含指定键，包含返回 true，否则返回false。
 * 9、containsValue(Object value)： 判断集合中是否包含指定值，包含返回 true，否则返回false。
 * 10、keySet()： 返回Map集合中所有key组成的Set集合。
 * 11、entrySet()： 将Map集合每个key-value转换为一个Entry对象并返回由所有的Entry对象组成的Set集合。
 *
 * */
