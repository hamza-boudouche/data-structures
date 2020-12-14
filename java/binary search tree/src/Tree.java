import java.util.ArrayList;

public class Tree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean isSearchTree() {
        //algorithm
        //if a node is a left child then its value and the values in its right sub tree must be smaller than the value of its parent node
        //if a node is a right child then its value and the value in its left seb tree must be greater than the value of its parent node
        if(this.getRoot().getLeftChild() != null){
            boolean a = this.getRoot().getData() >= this.getRoot().getLeftChild().getData();
            boolean c = this.getRoot().getLeftSubTree().isSearchTree();
            boolean e = true;
            for(int n: this.getRoot().getLeftChild().getVRightSubTree()){
                if(n > this.getRoot().getData()){
                    e = false;
                    break;
                }
            }
            if(this.getRoot().getRightChild() != null){
                boolean b = this.getRoot().getData() <= this.getRoot().getRightChild().getData();
                boolean d = this.getRoot().getRightSubTree().isSearchTree();
                boolean f = true;
                for(int n: this.getRoot().getRightChild().getVLeftSubTree()){
                    if(n < this.getRoot().getData()){
                        f = false;
                        break;
                    }
                }
                return a && b && c && d && e && f;
            }
            return a && c;
        }
        return true;
    }

    public boolean contains(int key) {
        if(this.getRoot().getData() == key){
            return true;
        }
        else if(this.getRoot().getData() < key){
            if(this.getRoot().getLeftChild() == null){
                return false;
            }
            return this.getRoot().getLeftSubTree().contains(key);
        }
        else{
            if(this.getRoot().getRightChild() == null){
                return false;
            }
            return this.getRoot().getRightSubTree().contains(key);
        }
    }

    public void insert(int key) {
        if(!this.contains(key)){
            if(this.getRoot().getData() > key){
                if(this.getRoot().getLeftChild() != null){
                    this.getRoot().getLeftSubTree().insert(key);
                }
                Node n = new Node(key);
                this.getRoot().setLeftChild(n);
            }
            else{
                if(this.getRoot().getRightChild() != null){
                    this.getRoot().getRightSubTree().insert(key);
                }
                Node n = new Node(key);
                this.getRoot().setRightChild(n);
            }
        }
    }

    public void delete(int key) {
        //code
        //needs inorder successor of node to delete
    }

    public int size() {
        if(this.getRoot().getLeftChild() != null){
            if(this.getRoot().getRightChild() != null){
                return 2 + this.getRoot().getLeftSubTree().size() + this.getRoot().getRightSubTree().size();
            }
            return 1 + this.getRoot().getLeftSubTree().size();
        }
        if(this.getRoot().getRightChild() != null){
            return 1 + this.getRoot().getRightSubTree().size();
        }
        return 1;
    }

    //depth first traversals: 
    
    //inOrder traversal
    public ArrayList<Integer> inOrder() {
        ArrayList<Integer> arr = new ArrayList<Integer>(0);
        //code
        //needs variable arr to stay the same after each iteration of inOrder methode
        //or alternatively make a nested methode and run it recursively or with a loop
        return arr;
    }
}