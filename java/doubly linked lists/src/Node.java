public class Node{
    private Node previous = null;
    private Node next = null;
    private int data;

    Node(int i){
        this.data = i;
    }

    Node(int i, Node p){
        this.data = i;
        this.previous = p;
    }

    Node(int i, Node p, Node n){
        this.data = i;
        this.next = n;
        this.previous = p;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}