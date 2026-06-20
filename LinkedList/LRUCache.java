package LinkedList;

import java.util.*;

class LRUCache {
    // Node for Doubly Linked List
    private class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) { key = k; value = v; }
    }

    private final int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0); // dummy head
        tail = new Node(0, 0); // dummy tail
        head.next = tail;
        tail.prev = head;
    }

    // Remove node from DLL
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert node at front (MRU position)
    private void insert(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Get value
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node); // move to MRU
            return node.value;
        }
        return -1;
    }

    // Put key-value
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            // remove LRU node
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
        Node node = new Node(key, value);
        insert(node);
        map.put(key, node);
    }

    // Debugging
    public void display() {
        Node curr = head.next;
        System.out.print("Cache state: ");
        while (curr != tail) {
            System.out.print("[" + curr.key + ":" + curr.value + "] ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.display(); // [2:2] [1:1]

        System.out.println(cache.get(1)); // 1
        cache.display(); // [1:1] [2:2]

        cache.put(3, 3); // evicts key 2
        cache.display(); // [3:3] [1:1]

        System.out.println(cache.get(2)); // -1
    }
}

