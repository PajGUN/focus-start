package collections.impl;


import collections.Iterable;
import collections.Iterator;

import java.util.LinkedList;
import java.util.Stack;

// monster mode сделать на объъектах с дженериками
public class BinarySearchTree implements Iterable {

    private Node root;

    class Node {
        int value;
        Node left = null;
        Node right = null;

        Node(int value) {
            this.value = value;
        }
    }

    public void add(int value) {
        //todo написать реализацию
        Node x = root, y = null;
        while (x != null) {
            if (value == x.value) {
                return;
            } else {
                y = x;
                if (value < x.value) {
                    x = x.left;
                } else {
                    x = x.right;
                }
            }
        }
        Node newNode = new Node(value);
        if (y == null) {
            root = newNode;
        } else {
            if (value < y.value) {
                y.left = newNode;
            } else {
                y.right = newNode;
            }
        }
    }

    public void reverse() {
        //todo написать реализацию
        LinkedList<Node> queue = new java.util.LinkedList<>();
        if(root != null) {
            queue.add(root);
        }

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }

            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private Stack<Node> stack = new Stack<>();
            {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
            }

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public Integer next() {
                Node node = stack.pop();
                int result = node.value;
                if (node.right != null) {
                    node = node.right;
                    while (node != null) {
                        stack.push(node);
                        node = node.left;
                    }
                }
                return result;
            }
        };
    }
}
