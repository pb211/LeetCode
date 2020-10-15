package Lecode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RP133_CloneGraph {
    public int val;
    public List<RP133_CloneGraph> neighbors;
    public RP133_CloneGraph() {
        val = 0;
        neighbors = new ArrayList<RP133_CloneGraph>();
    }
    public RP133_CloneGraph(int _val) {
        val = _val;
        neighbors = new ArrayList<RP133_CloneGraph>();
    }
    public RP133_CloneGraph(int _val, ArrayList<RP133_CloneGraph> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
    public static void main(String[] args) {
        RP133_CloneGraph node1 = new RP133_CloneGraph(1);
        RP133_CloneGraph node2 = new RP133_CloneGraph(2);
        RP133_CloneGraph node3 = new RP133_CloneGraph(3);
        RP133_CloneGraph node4 = new RP133_CloneGraph(4);
        ArrayList<RP133_CloneGraph> node1List = new ArrayList<>();
        node1List.add(node2);
        node1List.add(node4);
        node1.neighbors = node1List;
        ArrayList<RP133_CloneGraph> node2List = new ArrayList<>();
        node2List.add(node1);
        node2List.add(node3);
        node2.neighbors = node2List;
        ArrayList<RP133_CloneGraph> node3List = new ArrayList<>();
        node3List.add(node2);
        node3List.add(node4);
        node3.neighbors = node3List;
        ArrayList<RP133_CloneGraph> node4List = new ArrayList<>();
        node4List.add(node1);
        node4List.add(node3);
        node4.neighbors = node4List;
        RP133_CloneGraph res = cloneGraph(node1);
        System.out.println("res = " + res);
    }

    public static RP133_CloneGraph cloneGraph(RP133_CloneGraph node) {
        //用Map集合存储已被访问和克隆的节点
        Map<RP133_CloneGraph, RP133_CloneGraph> booleaned = new HashMap<>();
        return find(node, booleaned);
    }

    private static RP133_CloneGraph find(RP133_CloneGraph node, Map<RP133_CloneGraph, RP133_CloneGraph> booleaned) {
        if (node == null){
            return null;
        }
        if (booleaned.containsKey(node)){
            // 如果节点已经被访问过了，直接取出对应的克隆节点返回
            return booleaned.get(node);
        }
        //克隆节点
        RP133_CloneGraph newGraph = new RP133_CloneGraph(node.val, new ArrayList<>());
        //集合存储
        booleaned.put(node, newGraph);
        //遍历该节点的邻居并更新克隆节点的邻居列表
        for (RP133_CloneGraph n : node.neighbors){
            newGraph.neighbors.add(find(n,booleaned));
        }
        return newGraph;
    }
}
