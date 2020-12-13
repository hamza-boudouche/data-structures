import java.util.ArrayList;

public class Node {
    private int data;
    private Node leftChild;
    private Node rightChild;

    Node(int key){
        this.data = key;
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

    public ArrayList<Integer> getVLeftSubTree() {
        ArrayList<Integer> arr = new ArrayList<Integer>(0);
        Node current = this;
        while(current.leftChild != null){
            arr.add(current.getLeftChild().getData());
            current = current.getLeftChild();
        }
        return arr;
    }

    public ArrayList<Integer> getVRightSubTree() {
        ArrayList<Integer> arr = new ArrayList<Integer>(0);
        Node current = this;
        while(current.getRightChild() != null){
            arr.add(current.getRightChild().getData());
            current = current.getRightChild();
        }
        return arr;
    }

    public Tree getRightSubTree() {
        Tree t = new Tree();
        t.setRoot(this.getRightChild());
        return t;
    }

    public Tree getLeftSubTree(){
        Tree t = new Tree();
        t.setRoot(this.getLeftChild());
        return t;
    }
}