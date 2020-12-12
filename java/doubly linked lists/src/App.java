public class App {
    public static void main(String[] args) throws Exception {
        Node n1 = new Node(1);
        Node n2 = new Node(2, n1);
        System.out.println(n2.getPrevious().getData());
        System.out.println(n2.getNext());
    }
}


/*
implement node class
implement tree class
print list methode
add node methode
    at the front
    after a given node
    at the end 
    before a given node
concatenate 2 linked lists
delete node 
    at the end 
    at the front
    after a given node
    before a given node
find node
print list
*/
