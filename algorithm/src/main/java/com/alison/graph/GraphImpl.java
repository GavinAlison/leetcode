//package com.alison.graph;
//
///**
// * @Author alison
// * @Date 2019/8/19  23:08
// * @Version 1.0
// * @Description
// */
//public class GraphImpl implements Graph {
//
//    Integer[][] a;
//
//    private GraphType type;
//
//    @Override
//    public void creatGraph(EdgeElement[] d) {
//        int i;
//        for (i = 0; i < d.length; i++) {
//            if (d[i] == null) break;
//            int v1, v2;
//            v1 = d[i].fromvex;
//            v2 = d[i].endvex;
//            if (v1 < 0 || v1 > n - 1 || v2 < 0 || v2 > n - 1 || v1 == v2) {
//                System.out.println("边的顶点序号无效，退出运行");
//                System.exit(0);
//            }
//            if (type == GraphType.NoDirectionNoWeight) {
//                a[v1][v2] = a[v2][v1] = 1;
//            } else if (type == GraphType.NoDirectionWeight) {
//                a[v1][v2] = a[v2][v1] = d[i].weight;
//            } else if (type == GraphType.DirectionNoWeight) {
//                a[v1][v2] = 1;
//            } else {
//                a[v1][v2] = d[i].weight;
//            }
//        }
//        e = i; //边的数目
//    }
//
//    @Override
//    public GraphType graphType() {
//        return null;
//    }
//
//    @Override
//    public int vertices() {
//        return 0;
//    }
//
//    @Override
//    public int edges() {
//        return 0;
//    }
//
//    @Override
//    public boolean find(int i, int j) {
//        return false;
//    }
//
//    @Override
//    public void putEdge(EdgeElement theEdge) {
//
//    }
//
//    @Override
//    public void removeEdge(int i, int j) {
//
//    }
//
//    @Override
//    public int degree(int i) {
//        return 0;
//    }
//
//    @Override
//    public int inDegree(int i) {
//        return 0;
//    }
//
//    @Override
//    public int outDegree(int i) {
//        return 0;
//    }
//
//    @Override
//    public void output() {
//
//    }
//
//    @Override
//    public void depthFirstSearch(int v) {
//
//    }
//
//    @Override
//    public void breadthFirstSearch(int v) {
//
//    }
//}
