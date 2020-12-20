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
    public ArrayList<Integer> getVLeftSubTree() {
        ArrayList<Integer> arr = new ArrayList<Integer>(0);
        Node current = this;
        while(current.leftChild != null){
            arr.add(current.getLeftChild().getData());
            current = current.getLeftChild();
        }
        return arr;
    }

    //get the values of the right sub-tree of a given node
    //used in Tree.isSearchTree()
    public ArrayList<Integer> getVRightSubTree() {
        ArrayList<Integer> arr = new ArrayList<Integer>(0);
        Node current = this;
        while(current.getRightChild() != null){
            arr.add(current.getRightChild().getData());
            current = current.getRightChild();
        }
        return arr;
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