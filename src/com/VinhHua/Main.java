package com.VinhHua;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(8);
        tree.insert(5);
        tree.insert(4);
        tree.insert(7);
        tree.insert(11);
        tree.insert(1);
        tree.insert(12);
        tree.traverseBF();
        System.out.println();
        tree.traverseDF();
        System.out.println(tree.isRoot(8));
        System.out.println("\n"+tree.max());
        System.out.println(tree.min());
        System.out.println(tree.getSum());
        System.out.println(tree.getHeight());

    }
}
