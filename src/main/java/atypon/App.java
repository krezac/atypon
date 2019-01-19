package atypon;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    private int value;
    private int count;
    private Node leftNode;
    private Node rightNode;

    public Node(int value) {
        this.value = value;
        count = 1;
    }

    public void addValue(int value) {
        if (value == this.value) {
            this.count++;
        } else if (value < this.value) {
            if (leftNode == null) {
                leftNode = new Node(value);
            } else {
                leftNode.addValue(value);
            }
        } else if (value > this.value) {
            if (rightNode == null) {
                rightNode = new Node(value);
            } else {
                rightNode.addValue(value);
            }
        } 
    }

    public void printNode(StringBuffer sb) {
        sb.append(String.format("%d:%d", value, count));
    }

    public int getValue() {
        return value;
    }

    public int getCount() {
        return count;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }
}

class Tree {

    private Node root;

    public Tree(String input) {
        fillTree(input);
    }

    private void fillTree(String input) {
        String[] items = input.split("\\s*,\\s*");
        for (String s : items) {
            int value = Integer.parseInt(s);
            if (root == null) {
                root = new Node(value);
            } else {
                root.addValue(value);
            }
        }
    }

    public String printTree() {
        if (root == null) {
            return "";
        }

        boolean first = true;
        StringBuffer sb = new StringBuffer();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.size() > 0) {
            Node n = q.poll();
            if (first) {
                first = false;
            } else {
                sb.append(",");
            }
            if (n != null) {
                n.printNode(sb);
                if (n.getLeftNode() != null || n.getRightNode() != null) {
                    q.add(n.getLeftNode());
                    q.add(n.getRightNode());
                }
            }
        }

        return sb.toString();
    }
}

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            Tree t = new Tree(args[0]);
            System.out.println(t.printTree() + "\n");    
        } else {
            System.err.println("input missing");
            System.exit(-1);
        }
    }
}
