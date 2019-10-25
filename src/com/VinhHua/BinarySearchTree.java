package com.VinhHua;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

    private Node root;

    public void insert(int data) {
        if (isEmpty()) {
            root = new Node(data);
        } else {
            insertHelper(data, root);
        }
    }

    private void insertHelper(int data, Node root) {
        if (root.data == data) {
            return;
        }

        if (root.data > data) {
            if (root.left != null) {
                insertHelper(data, root.left);
            } else {
                root.setLeft(new Node(data));
            }
        }

        if (root.data < data) {
            if (root.right != null) {
                insertHelper(data, root.right);
            } else {
                root.setRight(new Node(data));
            }
        }
    }

//    public Node search(int data) {
//        return searchHelper(root, data);
//    }
//    private Node searchHelper(Node root, int data) {
//        if (root == null || root.data == data) {
//            return root;
//        }
//        if (data < root.data)
//            return searchHelper(root.right, data);
//        return searchHelper(root.left, data);
//    }

    public boolean isRoot(int data) {
        if (root.data == data) {
            if (root.left != null && root.right != null) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int max() {
        if (root == null) return -1;
        return root.getMax();
    }

    public int min() {
        if (root == null) return -1;
        return root.getMin();
    }

    public void traverseBF() {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node myNode = queue.remove();
            System.out.print(myNode.data + " ");
            if (myNode.right != null)
                queue.add(myNode.right);
            if (myNode.left != null)
                queue.add(myNode.left);
        }
    }

    public void traverseDF() {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node myNode = stack.pop();
            System.out.print(myNode.data + " ");
            if (myNode.left != null)
                stack.push(myNode.left);
            if (myNode.right != null)
                stack.push(myNode.right);
        }
    }

    public int getSum() {
        return getSumHelper(root);
    }

    private int getSumHelper(Node root) {
        if (root == null) return 0;
        return (root.data + getSumHelper(root.left) + getSumHelper(root.right));
    }

    private class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getMax() {
            if (right == null) return data;
            return right.getMax();
        }

        public int getMin() {
            if (left == null) return data;
            return left.getMin();
        }

        @Override
        public String toString() {
            return "node: " + data;
        }
    }
}
