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
        // algorithm
        // if a node is a left child then its value and the values in its right sub tree
        // must be smaller than the value of its parent node
        // if a node is a right child then its value and the value in its left seb tree
        // must be greater than the value of its parent node
        if (this.getRoot().getLeftChild() != null) {
            boolean a = this.getRoot().getData() >= this.getRoot().getLeftChild().getData();
            boolean c = this.getRoot().getLeftSubTree().isSearchTree();
            boolean e = true;
            for (int n : this.getRoot().getLeftChild().getVRightSubTree()) {
                if (n > this.getRoot().getData()) {
                    e = false;
                    break;
                }
            }
            if (this.getRoot().getRightChild() != null) {
                boolean b = this.getRoot().getData() <= this.getRoot().getRightChild().getData();
                boolean d = this.getRoot().getRightSubTree().isSearchTree();
                boolean f = true;
                for (int n : this.getRoot().getRightChild().getVLeftSubTree()) {
                    if (n < this.getRoot().getData()) {
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
        if (this.getRoot().getData() == key) {
            return true;
        } else if (this.getRoot().getData() < key) {
            if (this.getRoot().getLeftChild() == null) {
                return false;
            }
            return this.getRoot().getLeftSubTree().contains(key);
        } else {
            if (this.getRoot().getRightChild() == null) {
                return false;
            }
            return this.getRoot().getRightSubTree().contains(key);
        }
    }

    public void insert(int key) {
        if (!this.contains(key)) {
            if (this.getRoot().getData() > key) {
                if (this.getRoot().getLeftChild() != null) {
                    this.getRoot().getLeftSubTree().insert(key);
                }
                Node n = new Node(key);
                this.getRoot().setLeftChild(n);
            } else {
                if (this.getRoot().getRightChild() != null) {
                    this.getRoot().getRightSubTree().insert(key);
                }
                Node n = new Node(key);
                this.getRoot().setRightChild(n);
            }
        }
    }

    public void delete(int key) {
        // code
        // needs inorder successor of node to delete
    }

    public int size() {
        if (this.getRoot().getLeftChild() != null) {
            if (this.getRoot().getRightChild() != null) {
                return 2 + this.getRoot().getLeftSubTree().size() + this.getRoot().getRightSubTree().size();
            }
            return 1 + this.getRoot().getLeftSubTree().size();
        }
        if (this.getRoot().getRightChild() != null) {
            return 1 + this.getRoot().getRightSubTree().size();
        }
        return 1;
    }

    // depth first traversals:

    // inOrder traversal
    private ArrayList<Integer> inOrderarr = new ArrayList<Integer>(0);
    public ArrayList<Integer> inOrder() {
        if(this.getRoot().getLeftChild() != null){
            inOrderarr.addAll(this.getRoot().getLeftSubTree().inOrder());
        }
        inOrderarr.add(this.getRoot().getData());
        if(this.getRoot().getRightChild() != null){
            inOrderarr.addAll(this.getRoot().getRightSubTree().inOrder());
        }
        return inOrderarr;
    }
    
    // preOrder traversal
    private ArrayList<Integer> preOrderarr = new ArrayList<Integer>(0);
    public ArrayList<Integer> preOrder() {
        preOrderarr.add(this.getRoot().getData());
        if(this.getRoot().getLeftChild() != null){
            preOrderarr.addAll(this.getRoot().getLeftSubTree().preOrder());
        }
        if(this.getRoot().getRightChild() != null){
            preOrderarr.addAll(this.getRoot().getRightSubTree().preOrder());
        }
        return preOrderarr;
    }

    // postOrder traversal
    private ArrayList<Integer> postOrderarr = new ArrayList<Integer>(0);
    public ArrayList<Integer> postOrder() {
        if(this.getRoot().getLeftChild() != null){
            postOrderarr.addAll(this.getRoot().getLeftSubTree().postOrder());
        }
        if(this.getRoot().getRightChild() != null){
            postOrderarr.addAll(this.getRoot().getRightSubTree().postOrder());
        }
        postOrderarr.add(this.getRoot().getData());
        return postOrderarr;
    }
}

class expTree extends Tree {
    private opNode root;

    expTree(opNode root) {
        this.root = root;
    }

    public void setRoot(opNode root) {
        this.root = root;
    }

    public opNode getRoot() {
        return root;
    }

    public int calculate() {
        if (this.getRoot().getLeftChild() == null) {
            return this.getRoot().getData();
        }
        switch (this.root.getOperation()) {
            case ADD:
                return ((expTree) this.getRoot().getLeftSubTree()).calculate() + ((expTree) this.getRoot().getRightSubTree()).calculate();
            case DIV:
                return ((expTree) this.getRoot().getLeftSubTree()).calculate() / ((expTree) this.getRoot().getRightSubTree()).calculate();
            case MUL:
                return ((expTree) this.getRoot().getLeftSubTree()).calculate() * ((expTree) this.getRoot().getRightSubTree()).calculate();
            case SUB:
                return ((expTree) this.getRoot().getLeftSubTree()).calculate() - ((expTree) this.getRoot().getRightSubTree()).calculate();
            default:
                return 0;
        }

    }

    // depth first traversals:

    // inOrder traversal
    private ArrayList<opNode> inOrderarr = new ArrayList<opNode>(0);
    public ArrayList<opNode> opinOrder() {
        if(this.getRoot().getLeftChild() != null){
            inOrderarr.addAll(((expTree) this.getRoot().getLeftSubTree()).opinOrder());
        }
        inOrderarr.add(this.getRoot());
        if(this.getRoot().getRightChild() != null){
            inOrderarr.addAll(((expTree) this.getRoot().getRightSubTree()).opinOrder());
        }
        return inOrderarr;
    }

    // preOrder traversal
    private ArrayList<opNode> preOrderarr = new ArrayList<opNode>(0);
    public ArrayList<opNode> oppreOrder() {
        if(this.getRoot().getLeftChild() != null){
            preOrderarr.addAll(((expTree) this.getRoot().getLeftSubTree()).oppreOrder());
        }
        preOrderarr.add(this.getRoot());
        if(this.getRoot().getRightChild() != null){
            preOrderarr.addAll(((expTree) this.getRoot().getRightSubTree()).oppreOrder());
        }
        return preOrderarr;
    }

    // postOrder traversal
    private ArrayList<opNode> postOrderarr = new ArrayList<opNode>(0);
    public ArrayList<opNode> oppostOrder() {
        if(this.getRoot().getLeftChild() != null){
            postOrderarr.addAll(((expTree) this.getRoot().getLeftSubTree()).oppostOrder());
        }
        postOrderarr.add(this.getRoot());
        if(this.getRoot().getRightChild() != null){
            postOrderarr.addAll(((expTree) this.getRoot().getRightSubTree()).oppostOrder());
        }
        return postOrderarr;
    }
}