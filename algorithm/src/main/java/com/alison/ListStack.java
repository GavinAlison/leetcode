package com.alison;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author alison
 * @Date 2019/8/5  23:52
 * @Version 1.0
 * @Description
 */
public class ListStack<E> {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Node<E> {
        private E value;
        private Node next;
    }

    private Node<E> head;

    private int size;

    public ListStack() {
        head = null;
        size = 0;
    }

    public void push(E e) {
        Node curr = head;
        Node newNode = new Node(e, curr);
        size++;
        head = newNode;
    }

    public E pop() {
        E result = null;
        Node curr = head;
        if (curr != null) {
            result = (E) curr.value;
            curr = curr.next;
            size--;
        }
        head = curr;
        return result;
    }

    public E peek() {
        E result = null;
        if (head != null)
            result = (E) head.value;
        return result;
    }

    public void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ListStack<Integer> listStack = new ListStack<>();
        listStack.push(1);
        listStack.push(2);
        listStack.push(3);
        listStack.push(4);
        listStack.display();
        System.out.println(listStack.pop());
        System.out.println(listStack.peek());
        listStack.display();
    }

}
