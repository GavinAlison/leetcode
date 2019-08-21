package com.alison.graph;

/**
 * @Author alison
 * @Date 2019/8/19  22:58
 * @Version 1.0
 * @Description //边集数组 ，存放边的信息
 * //邻域数组表示  和 邻域表表示  是两种不同的表示方式
 * //表示的是插入边的元素，边的起点和终点  边的权重
 */
public class EdgeElement {
    int fromvex; // 前节点
    int endvex; // 后节点
    int weight; // 权重

    public EdgeElement(int v1, int v2) {
        //对于无权重图的初始化
        fromvex = v1;
        endvex = v2;
        weight = 1;
    }

    public EdgeElement(int v1, int v2, int wgt) {
        //对于有权重图的初始化
        fromvex = v1;
        endvex = v2;
        weight = wgt;
    }


}
