package StudyPlan;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class LRUCache {

    Node head, tail;
    int capacity, size;

    HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            put(key, node.getData());
            return node.getData();
        }
        return -1;
    }

    public void remove(Node node) {
        if (node == this.tail) {
            this.tail = node.getPrev();
        }
        if (node.getPrev() != null) {
            node.getPrev()
                    .setNext(node.getNext());
        }
        if (node.getNext() != null) {
            node.getNext()
                    .setPrev(node.getPrev());
        }
        if (node == this.head && map.size() == 1) {
            this.head = null;
        }

        --size;
        map.remove(node.getKey());
    }

    public void put(int key, int value) {
        if (this.head != null && this.head.getKey() == key) {
            this.head.setData(value);
        } else {
            if (map.containsKey(key)) {
                remove(map.get(key));
            } else if (size == capacity) {
                removeAtEnd();
            }
            insertAtStart(key, value);
        }
    }

    public int firstUniqChar(String s) {
        HashMap<Character , Integer> set  = new HashMap<>();
        char[] chars = s.toCharArray();
        for(char c : chars){
           set.put(c , set.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i< chars.length ; i++){
            if(set.get(chars[i]) == 1)
                return i;
        }

        return  -1;
    }

    private void insertAtStart(int key, int value) {
        Node node = new Node(this.head, null, value, key);
        map.put(key, node);
        if (this.head != null) {
            this.head.setPrev(node);
        }
        if (this.tail == null) {
            this.tail = node;
        }
        this.head = node;
        ++size;
    }

    private void removeAtEnd() {
        Node node = tail.getPrev();
        map.remove(tail.getKey());
        if (node != null) {
            node.setNext(null);
        }
        tail.setPrev(null);
        this.tail = node;
        --size;
    }

    public static void main(String[] args) {
//        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(2, 1);
//        lRUCache.put(3, 2);
//        System.out.println(lRUCache.get(3));
//
//        System.out.println(lRUCache.get(2));
//        lRUCache.put(4, 3);
//        System.out.println(lRUCache.get(2));
//        System.out.println(lRUCache.get(3));
//        System.out.println(lRUCache.get(4));

        LRUCache lRUCache = new LRUCache(1);
        lRUCache.put(2, 1);
        System.out.println(lRUCache.get(2));
        lRUCache.put(3, 2);
        System.out.println(lRUCache.get(2));

        System.out.println(lRUCache.get(3));
    }
}

class Node {

    private Node next;
    private int key;
    private Node prev;

    public Node(Node next, Node prev, int data, int key) {
        this.next = next;
        this.prev = prev;
        this.data = data;
        this.key = key;
    }

    private int data;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
