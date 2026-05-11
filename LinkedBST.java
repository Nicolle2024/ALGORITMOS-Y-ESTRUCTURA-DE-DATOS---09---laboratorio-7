package bstreelinklistinterfgeneric;

import Exceptions.ExceptionIsEmpty;
import Exceptions.ItemDuplicated;
import Exceptions.ItemNoFound;
import bstreeInterface.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LinkedBST<E> implements BinarySearchTree<E> {

    class Node<T> {
        public T data;
        public Node<T> left;
        public Node<T> right;

        public Node(T data) {
            this.data  = data;
            this.left  = null;
            this.right = null;
        }
    }

    private Node<E> root;

    public LinkedBST() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void insert(E data) throws ItemDuplicated {
        root = insert(root, data);
    }

    @SuppressWarnings("unchecked")
    private Node<E> insert(Node<E> node, E data) throws ItemDuplicated {
        if (node == null)
            return new Node<>(data);

        int cmp = ((Comparable<E>) data).compareTo(node.data);

        if      (cmp < 0) node.left  = insert(node.left,  data);
        else if (cmp > 0) node.right = insert(node.right, data);
        else
            throw new ItemDuplicated("Duplicado: " + data);

        return node;
    }

    @Override
    public E search(E data) throws ItemNoFound {
        Node<E> result = searchNode(root, data);
        if (result == null)
            throw new ItemNoFound("No encontrado: " + data);
        return result.data;
    }

    @SuppressWarnings("unchecked")
    private Node<E> searchNode(Node<E> node, E data) {
        if (node == null) return null;

        int cmp = ((Comparable<E>) data).compareTo(node.data);

        if      (cmp < 0) return searchNode(node.left,  data);
        else if (cmp > 0) return searchNode(node.right, data);
        else              return node;
    }

    @Override
    public void delete(E data) throws ExceptionIsEmpty, ItemNoFound {
        if (isEmpty())
            throw new ExceptionIsEmpty("BST vacío");
        root = delete(root, data);
    }

    @SuppressWarnings("unchecked")
    private Node<E> delete(Node<E> node, E data) {
        if (node == null) return null;

        int cmp = ((Comparable<E>) data).compareTo(node.data);

        if      (cmp < 0) node.left  = delete(node.left,  data);
        else if (cmp > 0) node.right = delete(node.right, data);
        else {
            if (node.left  == null) return node.right;
            if (node.right == null) return node.left;

            Node<E> min = findMinInternal(node.right);
            node.data  = min.data;
            node.right = delete(node.right, min.data);
        }
        return node;
    }

    private Node<E> findMinInternal(Node<E> node) {
        while (node.left != null) node = node.left;
        return node;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[BST vacio]";
        StringBuilder sb = new StringBuilder();
        printTree(root, sb, "", "");
        return sb.toString();
    }

    private void printTree(Node<E> node, StringBuilder sb,
                            String prefTop, String prefBot) {
        if (node == null) return;

        printTree(node.right, sb,
                  prefTop + "        ",
                  prefTop + "   |    ");

        sb.append(prefTop).append("   +-- [")
          .append(node.data).append("]\n");

        printTree(node.left, sb,
                  prefBot + "   |    ",
                  prefBot + "        ");
    }

    public String inOrder() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString().trim();
    }

    private void inOrder(Node<E> node, StringBuilder sb) {
        if (node == null) return;

        inOrder(node.left, sb);
        sb.append(node.data).append(" ");
        inOrder(node.right, sb);
    }

    public String preOrder() {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString().trim();
    }

    private void preOrder(Node<E> node, StringBuilder sb) {
        if (node == null) return;

        sb.append(node.data).append(" ");
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    public String postOrder() {
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        return sb.toString().trim();
    }

    private void postOrder(Node<E> node, StringBuilder sb) {
        if (node == null) return;

        postOrder(node.left, sb);
        postOrder(node.right, sb);
        sb.append(node.data).append(" ");
    }

    public E findMinNode() throws ItemNoFound {
        if (isEmpty())
            throw new ItemNoFound("BST vacío");

        Node<E> node = root;

        while (node.left != null)
            node = node.left;

        return search(node.data);
    }

    public E findMaxNode() throws ItemNoFound {
        if (isEmpty())
            throw new ItemNoFound("BST vacío");

        Node<E> node = root;

        while (node.right != null)
            node = node.right;

        return search(node.data);
    }

    public void destroyNodes() throws ExceptionIsEmpty {
        if (root == null)
            throw new ExceptionIsEmpty("El árbol está vacío");

        root = null;
    }

    public int countAllNodes() {
        return countAllRec(root);
    }

    private int countAllRec(Node<E> node) {
        if (node == null) return 0;

        return 1 + countAllRec(node.left) + countAllRec(node.right);
    }

    public int countNodes() {
        return countNodesRec(root);
    }

    private int countNodesRec(Node<E> node) {
        if (node == null) return 0;

        if (node.left == null && node.right == null)
            return 0;

        return 1 + countNodesRec(node.left) + countNodesRec(node.right);
    }

    @SuppressWarnings("unchecked")
    public int height(E x) {

        Node<E> target = null;
        Node<E> current = root;

        while (current != null) {
            int cmp = ((Comparable<E>) x).compareTo(current.data);

            if (cmp == 0) {
                target = current;
                break;
            } else if (cmp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (target == null)
            return -1;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(target);

        int height = -1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            height++;

            for (int i = 0; i < levelSize; i++) {
                Node<E> node = queue.poll();

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }
        }

        return height;
    }

    public int amplitude(int nivel) {
        if (root == null)
            return 0;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);

        int currentLevel = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (currentLevel == nivel)
                return size;

            for (int i = 0; i < size; i++) {
                Node<E> node = queue.poll();

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }

            currentLevel++;
        }

        return 0;
    }

    public int areaBST() {
        if (root == null)
            return 0;

        int leaves = 0;
        int level = -1;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for (int i = 0; i < size; i++) {
                Node<E> node = queue.poll();

                if (node.left == null && node.right == null) {
                    leaves++;
                } else {

                    if (node.left != null)
                        queue.add(node.left);

                    if (node.right != null)
                        queue.add(node.right);
                }
            }
        }

        return leaves * level;
    }

    public String drawBST() {
        StringBuilder sb = new StringBuilder();

        if (root == null) {
            sb.append("Árbol vacío");
            return sb.toString();
        }

        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node<E> node = queue.poll();

                sb.append("[").append(node.data).append("] ");

                if (node.left != null) {
                    queue.add(node.left);
                    sb.append("L:").append(node.left.data).append(" ");
                }

                if (node.right != null) {
                    queue.add(node.right);
                    sb.append("R:").append(node.right.data).append(" ");
                }
            }

            sb.append("\n");
        }

        return sb.toString();
    }

    public void parenthesize() {
        if (root == null)
            return;

        parenthesize(root, 0);
    }

    private void parenthesize(Node<E> node, int level) {
        if (node == null)
            return;

        String indent = "  ".repeat(level);

        boolean esHoja = (node.left == null && node.right == null);

        if (esHoja) {
            System.out.println(indent + node.data);
        } else {
            System.out.println(indent + node.data + " (");

            if (node.left != null)
                parenthesize(node.left, level + 1);

            if (node.right != null)
                parenthesize(node.right, level + 1);

            System.out.println(indent + ")");
        }
    }

    @SuppressWarnings("unchecked")
    public boolean isValidBST() {

        Stack<Node<E>> stack = new Stack<>();
        Node<E> current = root;
        E prev = null;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            if (prev != null &&
                ((Comparable<E>) current.data).compareTo(prev) <= 0)
                return false;

            prev = current.data;
            current = current.right;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public LinkedList<E> searchRange(E min, E max) {

        LinkedList<E> result = new LinkedList<>();
        Stack<Node<E>> stack = new Stack<>();
        Node<E> current = root;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            int cmpMin = ((Comparable<E>) current.data).compareTo(min);
            int cmpMax = ((Comparable<E>) current.data).compareTo(max);

            if (cmpMin >= 0 && cmpMax <= 0)
                result.add(current.data);

            if (cmpMax > 0)
                break;

            current = current.right;
        }

        return result;
    }

    public int countLeaves() {

        if (root == null)
            return 0;

        int count = 0;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node<E> node = queue.poll();

            if (node.left == null && node.right == null) {
                count++;
            } else {

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }
        }

        return count;
    }

    @SuppressWarnings("unchecked")
    public void printDescending() {

        Stack<Node<E>> stack = new Stack<>();
        Node<E> current = root;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.right;
            }

            current = stack.pop();

            System.out.println(current.data);

            current = current.left;
        }
    }
}
