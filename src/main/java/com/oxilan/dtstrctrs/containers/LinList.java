package com.oxilan.dtstrctrs.containers;

public class LinList {

    Node firstNode;
    Node lastNode;
    Node currentNode;

    public boolean hasNext() {
        return false;
    }

    public Object next() {
        return null;
    }

    public void remove() {

    }

    public void add(Object object) {

        if (firstNode == null) {
            currentNode = new Node(object, null, null);
            firstNode = currentNode;
            lastNode = currentNode;
        } else {
            Node node = new Node(object, lastNode, null);
            lastNode.nextNode = node;
            lastNode = node;

        }

    }

    private Node findNextNode(int index) { //slow
        Node iterNode = firstNode;
        for (int i = 0; i <= index; i++) {
            iterNode = iterNode.nextNode;
        }
        return iterNode;
    }

    public void add(int i, Object object) {
        Node replaceNode = findNextNode(i);
        Node node = new Node(object, replaceNode.prevNode, replaceNode);
        replaceNode.prevNode.nextNode = node;
    }

    public Object get(int index) {
        Node returneNode = findNextNode(index);
        return returneNode.value;
    }

    private static class Node {

        Object value;
        Node prevNode;
        Node nextNode;

        Node(Object value, Node prewNode, Node nextNode) {
            this.value = value;
            this.prevNode = prewNode;
            this.nextNode = nextNode;
        }

    }
}
