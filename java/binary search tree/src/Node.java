import java.util.ArrayList;

public class Node {
    protected int data;
    protected Node leftChild;
    protected Node rightChild;

    Node(int key){
        this.data = key;
        this.leftChild = null;
        this.rightChild = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    //get the values of the left sub-tree of a given node
    //used in Tree.isSearchTree()
    public ArrayList<Integer> getVLeftSubTree() { //this needs to be fixed
        ArrayList<Node> nodes = new ArrayList<Node>(0);
        ArrayList<Node> current = new ArrayList<Node>(0);
        current.add(this.getLeftChild());
        ArrayList<Node> next = new ArrayList<Node>(0);
        while(current.size() != 0){
            nodes.addAll(current);
            for (Node node : current) {
                if(node.getLeftChild() != null){
                    next.add(node.getLeftChild());
                }
                if(node.getRightChild() != null){
                    next.add(node.getRightChild());
                }
            }
            current = new ArrayList<Node>(next);
            next = new ArrayList<Node>(0);
        }
        ArrayList<Integer> result = new ArrayList<Integer>(0);
        result.add(this.getData());
        for (Node node : nodes) {
            result.add(node.getData());
        }
        return result;
    }

    //get the values of the right sub-tree of a given node
    //used in Tree.isSearchTree()
    public ArrayList<Integer> getVRightSubTree() { //this needs to be fixed
        ArrayList<Node> nodes = new ArrayList<Node>(0);
        ArrayList<Node> current = new ArrayList<Node>(0);
        current.add(this.getRightChild());
        ArrayList<Node> next = new ArrayList<Node>(0);
        while(current.size() != 0){
            nodes.addAll(current);
            for (Node node : current) {
                if(node.getLeftChild() != null){
                    next.add(node.getLeftChild());
                }
                if(node.getRightChild() != null){
                    next.add(node.getRightChild());
                }
            }
            current = new ArrayList<Node>(next);
            next = new ArrayList<Node>(0);
        }
        ArrayList<Integer> result = new ArrayList<Integer>(0);
        result.add(this.getData());
        for (Node node : nodes) {
            result.add(node.getData());
        }
        return result;
    }

    //get the right sub-tree of a given node
    public Tree getRightSubTree() {
        Tree t = new Tree();
        t.setRoot(this.getRightChild());
        return t;
    }

    //get the left sub-tree of a given node
    public Tree getLeftSubTree(){
        Tree t = new Tree();
        t.setRoot(this.getLeftChild());
        return t;
    }
}


class opNode extends Node{
    enum Operation {
        ADD,
        SUB,
        MUL,
        DIV
    }

    private Operation operation = null;

    opNode(int key){
        super(key);
    }

    opNode(int key, Operation operation){
        super(key);
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

}