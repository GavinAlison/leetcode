package com.alison.graph;

/**
 * @Author alison
 * @Date 2019/8/19  23:01
 * @Version 1.0
 * @Description
 */
public interface Graph {
    //可以通过边集来得到一个图的构成
    void creatGraph(EdgeElement d[]);         //通过边结点来构建一个图

    GraphType graphType();                    //返回图的类型  无向无权图 无向有权图  有向无权图  有向有权图 定义一个枚举变量

    int vertices();                           //返回图的顶点数

    int edges();                              //返回图的边数

    boolean find(int i, int j);               //从图中查找一条边(i,j)是否存在

    void putEdge(EdgeElement theEdge);        //像图中插入一条边 theEdge

    void removeEdge(int i, int j);            //从图中删除一条边

    int degree(int i);                      //返回顶点i的度

    int inDegree(int i);                    //返回顶点i的入度

    int outDegree(int i);                   //返回顶点i的出度

    void output();                          //以图的顶点集和边集的形式输出一个图

    void depthFirstSearch(int v);            //从顶点v开始深度优先搜索整幅图

    void breadthFirstSearch(int v);            //从顶点v开始广度优先搜索整幅图

}
