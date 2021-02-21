package deque;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class LinkedListDeque<T> implements Deque<T>{
    private class IntNode{
        public T item;
        public IntNode previous;
        public IntNode next;
        public IntNode(T f, IntNode p, IntNode n){
            item = f;
            previous = p;
            next = n;
        }
    }
    private int size;
    private IntNode sentinel;

    public LinkedListDeque(){
        size = 0;
        sentinel = new IntNode(null,null,null);
        sentinel.next = sentinel;
        sentinel.previous = sentinel;
    }

    @Override
    public void addFirst(T value) {
        size += 1;
        IntNode node = sentinel;
        IntNode firstNode = node.next;
        IntNode addNew = new IntNode(value, node, firstNode);
        node.next = addNew;
        firstNode.previous = addNew;
    }

    @Override
    public void addLast(T value) {
        size += 1;
        IntNode node = sentinel;
        IntNode lastNode = node.previous;
        IntNode addNew = new IntNode(value, lastNode, node);
        node.previous = addNew;
        lastNode.next = addNew;
    }

    @Override
    public T removeFirst() {
        if (this.isEmpty()){
            return null;
        }
        size -= 1;
        IntNode removedFirst = sentinel.next;
        IntNode newFirst = removedFirst.next;
        sentinel.next = newFirst;
        newFirst.previous = sentinel;

        return newFirst.item;
    }

    @Override
    public T removeLast() {
        if (this.isEmpty()){
            return null;
        }
        size -= 1;
        IntNode removedLast = sentinel.previous;
        IntNode newLast = removedLast.previous;
        sentinel.previous = newLast;
        newLast.next = sentinel;

        return newLast.item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        IntNode first = sentinel.next;
        String res = '';
        while (first != sentinel){
            res += first.item.toString();
            first = first.next;
        }
        System.out.println(res + "\n");
    }

    @Override
    public T get(int index) {
        IntNode head = sentinel;
        for(int i = 0; i < index; i++){
            if(head == null){
                return null;
            }
            head = head.next;
        }
        return head.next.item;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private class LLDIterator implements Iterator<T>{

    }
}
