public class List{
    private Node head = null;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int lenght(){
        Node current = this.head;
        int l = 0;
        while(current.getNext() != null){
            l++;
            current = current.getNext();
        }
        return l;
    }

    public void addEnd(Node node){
        Node current = this.getHead();
        while(current != null){
            current = current.getNext();
        }
        current.setNext(node);
    }

    public void addFront(Node node){
        node.setNext(this.head);
        this.head.setPrevious(node);
        this.head = node;
    }

    public void addAfter(Node node, Node newNode){
        Node next = node.getNext();
        node.setNext(newNode);
        newNode.setPrevious(node);
        newNode.setNext(next);
        next.setPrevious(newNode);
    }

    public void addBefore(Node newNode, Node node){
        Node previous = node.getPrevious();
        previous.setNext(node);
        node.setPrevious(previous);
        newNode.setNext(node);
        node.setPrevious(newNode);
    }

    public void concat(List list){
        Node current = this.head;
        while(current != null){
            current = current.getNext();
        }
        current.setNext(list.getHead());
        list.getHead().setPrevious(current);
    }

    public int find(Node node){
        Node current = this.getHead();
        int i = 0;
        while(current != null){
            if(current.getData() == node.getData()){
                break;
            }
            i++;
        }
        if(current != null){
            return i;
        }
        return -1;
    }

    public void pop(){
        Node current = this.getHead();
        while(current.getNext() != null){
            current = current.getNext();
        }
        
        current.getPrevious().setNext(null);
    }

    public void deleteFirst(){
        this.setHead(this.getHead().getNext());
        this.getHead().setPrevious(null);
    }

    public void deleteAfter(Node node){
        Node next = node.getNext().getNext();
        node.setNext(next);
        next.setPrevious(node);
    }

    public void deleteBefore(Node node){
        Node previous = node.getPrevious().getPrevious();
        node.setPrevious(previous);
        previous.setNext(node);
    }

    public void print(){
        Node current = this.head;
        while(current != null){
            System.out.print(current.getData());
            current = current.getNext();
        }
    }
}

