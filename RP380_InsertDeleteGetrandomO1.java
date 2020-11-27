package Lecode.Hash;

import java.util.*;

public class RP380_InsertDeleteGetrandomO1 {
    public static void main(String[] args) {
        // 初始化一个空的集合。
        RP380_InsertDeleteGetrandomO1 randomSet = new RP380_InsertDeleteGetrandomO1();
        // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        boolean a=randomSet.insert(1);
        System.out.println(a);
        // 返回 false ，表示集合中不存在 2 。
        boolean b=randomSet.remove(2);
        System.out.println(b);
        // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        boolean c=randomSet.insert(2);
        System.out.println(c);

        // getRandom 应随机返回 1 或 2 。
        int d=randomSet.getRandom();
        System.out.println(d);
        // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        boolean e=randomSet.remove(1);
        System.out.println(e);

        // 2 已在集合中，所以返回 false 。
        boolean f=randomSet.insert(2);
        System.out.println(f);

        // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
        int g=randomSet.getRandom();
        System.out.println(g);

    }
    private static Map<Integer, Integer> map=new HashMap<>();
    private static List<Integer> list=new ArrayList<>();
    private static Random rand = new Random();
    public RP380_InsertDeleteGetrandomO1() { }
    public boolean insert(int val) {
        if (map.containsKey(val))  return false;
        map.put(val,list.size());
        list.add(list.size(),val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)){
            return false;
        }
        int last=list.get(list.size()-1);
        int now=map.get(val);
        list.set(now,last);
        list.remove(list.size()-1);
        map.put(last,now);
        map.remove(val);
        return true;
    }
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
