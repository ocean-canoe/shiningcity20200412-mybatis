package com.shiningcity.javaApi.pojo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class MapTest {
    
    private static Logger logger = LoggerFactory.getLogger(MapTest.class);
    
    //三种map集合
    public static void HashMapHashTableTreeMap() {
        
        //compareTo 大于0表示前一个数据比后一个数据大， 0表示相同，小于0表示第一个数据小于第二个数据
        int compareTo1 = "1".compareTo("2");//-1
        int compareTo2 = "2".compareTo("2");//0
        int compareTo3 = new String("2").compareTo("2");//0
        int compareTo4 = new String("2").compareTo(new String("2"));//0
        logger.warn("compareTo1={},compareTo2={},compareTo3={},compareTo4={}",compareTo1,compareTo2,compareTo3,compareTo4);
        boolean boolean1 = "1"=="2";//false，不相等
        boolean boolean2 = "2"=="2";//true，相等
        boolean boolean3 = new String("2")=="2";//false，不相等
        boolean boolean4 = new String("2")==new String("2");//false，不相等
        logger.warn("boolean1={},boolean2={},boolean3={},boolean4={}",boolean1,boolean2,boolean3,boolean4);
        
        //数组结构：查询快，添加和删除慢。
        //链表结构：添加和删除快，查询慢。
        
        //HashMap，数组加链表结构，无序，线程不安全。初始容量默认为16，默认加载因子是0.75，可自定义，扩容方式：原容量*2。
        //添加和删除快，查询也快，key和value都和以为null
        //hash碰撞时，数据保存在链表的下一个节点。jdk8中链表长度超过8以后就会改为红黑树结构。
        //计算index方法：index = hash & (tab.length – 1)
        //扩容针对整个Map，每次扩容时，原来数组中的元素依次重新计算存放位置，并重新插入
        //插入元素后才判断该不该扩容，有可能无效扩容（插入后如果扩容，如果没有再次插入，就会产生无效扩容）
        Map<Object, Object> hashMap = new HashMap<Object, Object>(16, 0.75F);
        hashMap.put(1, 111);
        hashMap.put(2, 222);
        hashMap.put("a", 333);
        hashMap.put("b", 444);
        hashMap.put(null, null);
        //转为线程安全的集合
        Map<Object, Object> synchronizedHashMap = Collections.synchronizedMap(hashMap);
        //或者如下
        Map<Object, Object> synchronizedHashMap2 = Collections.synchronizedMap(new HashMap<Object, Object>());
        
        //HashTable，哈希表结构（也叫散列表结构）（也有人所是数组加链表结构），无序，线程安全。初始容量11,默认加载因子是0.75，扩容方式：原容量*2+1。
        //查询快，但是多线程中有线程锁会影响效率，添加和删除慢，key和value都不能为null
        //计算index的方法：index = (hash & 0x7FFFFFFF) % tab.length
        Map<Object, Object> hashTable = new Hashtable<Object, Object>(11,0.75F);
        
        //TreeMap，红黑树结构，有序，可自定义排序规则，线程不安全，容量不受限制。
        //treeMap中默认键类型必须一致，否则无法排序，如果需要不一致，则需要定义排序规则。
        //添加和删除快，查询效率也快。如果不定义排序规则，key不能为null，value可以为null，如果定义了排序规则，对null做了判断，则key可以为null。
        Map<Object, Object> treeMap = new TreeMap<Object, Object>();
        //转换线程安全。
        Map<Object, Object> synchronizedHashMap3 = Collections.synchronizedMap(treeMap);
        //自定义排序规则
        Map<Object, Object> treeMap2 = new TreeMap<Object, Object>(new Comparator<Object>() {
            //大于0表示前一个数据比后一个数据大， 0表示相同，小于0表示第一个数据小于第二个数据
            //return 大于0向后排，小于0向前排
            public int compare(Object a,Object b){
                int result = 1;//其余向后排序。
                if (a == null) {
                    result = 1;
                }else if (b == null) {
                    result = -1;
                }else if (a instanceof Integer && b instanceof Integer) {
                    result = (int)a-(int)b;
                }else if (a instanceof String && b instanceof String) {
                    result = ((String)a).compareTo((String)b);
                }else if (a instanceof Integer && b instanceof String) {
                    result = -1;//数字比字母小，数字在前
                }else if (a instanceof String && b instanceof Integer) {
                    result = 1;//字母比数字大，字母在后
                }
                return result;
            }
        });
        //treeMap.put(3, 10);
        treeMap.put("d", "g");
        //treeMap.put(1, 5);
        treeMap.put("j", "c");
        treeMap.put("f", null);
        //treeMap.put(5, 11);
        treeMap.put("a", "h");
        logger.warn("treeMap={}",JSON.toJSON(treeMap));
        treeMap.forEach((k,v)->logger.warn("k={},v={}",k,v));
        treeMap2.put(3, 10);
        treeMap2.put("d", "g");
        treeMap2.put(1, 5);
        treeMap2.put("j", "c");
        treeMap2.put(null, "df");
        treeMap2.put(5, 11);
        treeMap2.put("a", "h");
        //key为null时，toJSON会报错，toJSONString不报错
        logger.warn("treeMap2={}",JSON.toJSONString(treeMap2));
        treeMap2.forEach((k,v)->logger.warn("k={},v={}",k,v));
        
        //ConcurrentHashMap
        //初始容量16，默认加载因子0.75，分为16个线程段，段内扩容，添加数据前判断扩容。
        //Java5提供了ConcurrentHashMap，它是HashTable的替代，比HashTable的扩展性更好。
        //ConcurrentHashMap是使用了锁分段技术来保证线程安全的。
        //ConcurrentHashMap默认将hash表分为16个桶，诸如get、put、remove等常用操作只锁住当前需要用到的桶。这样，原来只能一个线程进入，现在却能同时有16个写线程执行，并发性能的提升是显而易见的。(读操作不加锁，由于HashEntry的value变量是 volatile的，也能保证读取到最新的值。)
        //有些方法需要跨段，比如size()和containsValue()，它们可能需要锁定整个表而而不仅仅是某个段，这需要按顺序锁定所有段，操作完毕后，又按顺序释放所有段的锁
        //段内扩容（段内元素超过该段对应Entry数组长度的75%触发扩容，不会对整个Map进行扩容），插入前检测需不需要扩容，有效避免无效扩容
        ConcurrentHashMap<Object, Object> conHashMap = new ConcurrentHashMap<Object, Object>(16,0.75f);
        
        
    }
    /*
并发操作HashMap，是有可能带来死循环以及数据丢失的问题的。
并发环境下，建议使用Java.util.concurrent包中的ConcurrentHashMap以保证线程安全，它采用分段所来保证线程安全。
至于HashTable，它并未使用分段锁，而是锁住整个数组，高并发环境下效率非常的低，会导致大量线程等待。
同样的，Synchronized关键字、Lock性能都不如分段锁实现的ConcurrentHashMap。
     */
    
    /*
     * Map结合的遍历方法
    Map集合的遍历：
      1、通过内部类Entry进行遍历
      2、通过迭代器进行遍历，先获得Entry的Set集合
      3、通过keySet方法获得键的Set集合，通过遍历键取值
      4、通过map.values()获得所有值，但是不能获得键
      5、lambda表达式遍历。
     */
    public static void HashMapBianli() {
        
        Map<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("aa", 111);
        hashMap.put("bb", 222);
        hashMap.put("cc", 333);
        hashMap.put("dd", 444);
        
        //遍历1，不能做删除操作
        for (String key:hashMap.keySet()) {
            logger.warn("遍历1：key={},vlaue={}",key,hashMap.get(key));
        }
        
        //遍历2，可执行删除操作
        Iterator<Entry<String, Object>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<String, Object> entry = iterator.next();
            logger.warn("遍历2：key={},value={}",entry.getKey(),entry.getValue());
            if (entry.getKey().equals("dd")) {
                iterator.remove();
            }
        }
        
        //遍历3，容量大时推荐使用，不能做删除操作。
        for (Entry<String, Object> entry:hashMap.entrySet()) {
            logger.warn("遍历3：key={},value={}",entry.getKey(),entry.getValue());
        }
        
        //遍历4
        for (Object value:hashMap.values()) {
            logger.warn("遍历4：value={}",value);
        }
        
        //遍历5（jdk8，Lambda表达式）
        hashMap.forEach((pakey,paval)->logger.warn("遍历5：key={},value={}",pakey,paval));
        
        //List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
    }
    
    public static void lambdafun(){
        String[] atp = {"Rafael Nadal", "Novak Djokovic",  
                   "Stanislas Wawrinka",  
                   "David Ferrer","Roger Federer",  
                   "Andy Murray","Tomas Berdych",  
                   "Juan Martin Del Potro"};  
        List<String> players =  Arrays.asList(atp);  
        
        // 以前的循环方式  
        for (String player : players) {  
             //System.out.println(player + "; ");  
        }  
              
        // 使用 lambda 表达式以及函数操作(functional operation)  
        players.forEach((player) -> logger.warn("{};",player));  
           
        // 在 Java 8 中使用双冒号操作符(double colon operator)  
        players.forEach(System.out::println);
    }
    
    public static void main(String[] args) {
        HashMapHashTableTreeMap();
        //HashMapBianli();
        //lambdafun();
    }
    
}
