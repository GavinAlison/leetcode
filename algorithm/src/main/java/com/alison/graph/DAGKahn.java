package com.alison.graph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * @Author alison
 * @Date 2019/8/29  0:02
 * @Version 1.0
 * @Description
 * @link [图文并貌的DAG（有向无环图）拓扑排序：Kahn算法](https://blog.csdn.net/yanwumuxi/article/details/67633766)
 */
public class DAGKahn {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Node {
        String name;
        public String toString() {
            return name;
        }
    }

    private static class Graph {
        //建立一个Map叫map
        Map<Node, List<Node>> map = new HashMap<Node, List<Node>>();
    }

    //定义结果数组
    List result = new ArrayList();

    //用LinkedList接口实现Queue，将入度为0的点放入队列中
    Queue<Node> zeroIndegree = new LinkedList<Node>();
    Graph graph = new Graph();//定义一个图

    public DAGKahn(Graph graph) {
        this.graph = graph;
    }

    //Kahn方法实现
    public void Kahn() {
        //在main函数中先传入一个入度为0的node
        //队列不为空
        while (!zeroIndegree.isEmpty()) {
            //队首元素取出
            Node node1 = zeroIndegree.poll();
            //放到结果数组中
            result.add(node1);
            //遍历map中的key
            for (Node node : graph.map.keySet()) {
                //如果map中的list含有node1，就删除node1
                if (graph.map.get(node).contains(node1)) {
                    graph.map.get(node).remove(node1);
                    //如果map中的list中有为空的node，将其加入队列
                    if (graph.map.get(node).isEmpty()) {
                        zeroIndegree.add(node);
                    }
                }
            }
        }
        //输出结果数组
        System.out.print(result);
    }

    public static void main(String[] args) {
        //定义每一个node
        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        Node n5 = new Node("5");
        Node n6 = new Node("6");
        Node n7 = new Node("7");
        Node n8 = new Node("8");
        //将每一个node加到List中
        List<Node> list1 = new ArrayList<Node>();
        list1.add(null);
        List<Node> list2 = new ArrayList<Node>();
        list2.add(n1);
        List<Node> list3 = new ArrayList<Node>();
        list3.add(n1);
        list3.add(n2);
        List<Node> list4 = new ArrayList<Node>();
        list4.add(n2);
        List<Node> list5 = new ArrayList<Node>();
        list5.add(n2);
        list5.add(n3);
        list5.add(n4);
        List<Node> list6 = new ArrayList<Node>();
        list6.add(n5);
        List<Node> list7 = new ArrayList<Node>();
        list7.add(n3);
        List<Node> list8 = new ArrayList<Node>();
        list8.add(n3);
        list8.add(n7);
        //将定义的node和list加到map中，完成键图
        Graph graph = new Graph();
        graph.map.put(n1, list1);
        graph.map.put(n2, list2);
        graph.map.put(n3, list3);
        graph.map.put(n4, list4);
        graph.map.put(n5, list5);
        graph.map.put(n6, list6);
        graph.map.put(n7, list7);
        graph.map.put(n8, list8);
        Set<Node> keys = graph.map.keySet();
        //遍历map中的node值，输出图
        for (Node key : keys) {
            System.out.print("key=" + key + "  value=" + graph.map.get(key) + "\n");
        }
        DAGKahn dag = new DAGKahn(graph);
        dag.zeroIndegree.add(n1);
        dag.Kahn();
    }
}
