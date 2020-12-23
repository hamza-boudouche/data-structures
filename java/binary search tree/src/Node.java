import java.util.ArrayList;

public class Node {
    protected int data;
    protected Node leftChild;
    protected Node rightChild;

    Node(int key) {
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

    // get the values of the left sub-tree of a given node
    // used in Tree.isSearchTree()
    public ArrayList<Integer> getVLeftSubTree() {
        ArrayList<Node> nodes = new ArrayList<Node>(0);
        ArrayList<Node> current = new ArrayList<Node>(0);
        current.add(this.getLeftChild());
        ArrayList<Node> next = new ArrayList<Node>(0);
        while (current.size() != 0) {
            nodes.addAll(current);
            for (Node node : current) {
                if (node.getLeftChild() != null) {
                    next.add(node.getLeftChild());
                }
                if (node.getRightChild() != null) {
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

    // get the values of the right sub-tree of a given node
    // used in Tree.isSearchTree()
    public ArrayList<Integer> getVRightSubTree() {
        ArrayList<Node> nodes = new ArrayList<Node>(0);
        ArrayList<Node> current = new ArrayList<Node>(0);
        current.add(this.getRightChild());
        ArrayList<Node> next = new ArrayList<Node>(0);
        while (current.size() != 0) {
            nodes.addAll(current);
            for (Node node : current) {
                if (node.getLeftChild() != null) {
                    next.add(node.getLeftChild());
                }
                if (node.getRightChild() != null) {
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

    // get the right sub-tree of a given node
    public Tree getRightSubTree() {
        Tree t = new Tree();
        t.setRoot(this.getRightChild());
        return t;
    }

    // get the left sub-tree of a given node
    public Tree getLeftSubTree() {
        Tree t = new Tree();
        t.setRoot(this.getLeftChild());
        return t;
    }

    public Node parent(Tree tree) {
        // algorithm:
        // if this.key < tree.root.key
        // --if tree.root.left.key == this.key
        // ----return tree.root
        // --return this.parent(this.leftSubTree)
        // else if this.key > tree.root.key
        // --if tree.root.right.key == this.key
        // ----return tree.root
        // --return this.parent(this.rightSubTree)
        // return new Node(-1)
        if (this.getData() < tree.getRoot().getData()) {
            if (tree.getRoot().getLeftChild().getData() == this.getData()) {
                return tree.getRoot();
            }
            return this.parent(this.getLeftSubTree());
        } else if (this.getData() > tree.getRoot().getData()) {
            if (tree.getRoot().getRightChild().getData() == this.getData()) {
                return tree.getRoot();
            }
            return this.parent(this.getRightSubTree());
        }
        return new Node(-1);
    }

    public boolean isRightChild(Tree tree) {
        // if this.parent.right.key == this.key
        // --return true
        // return false
        if (this.parent(tree).getRightChild().getData() == this.getData()) {
            return true;
        }
        return false;
    }

    public boolean isLeftChild(Tree tree) {
        return !this.isRightChild(tree);
    }

    public boolean line(Tree tree) {
        // if this.isRightChild and this.parent.isRightChild
        // --return true
        // else if this.isLeftChild and this.parent.isLeftChild
        // --return true
        // return false
        if (this.isRightChild(tree) && this.parent(tree).isRightChild(tree)) {
            return true;
        } else if (this.isLeftChild(tree) && this.parent(tree).isLeftChild(tree)) {
            return true;
        }
        return false;
    }

    public boolean angle(Tree tree) {
        return !this.line(tree);
    }

    
    // rotations

    public void leftRotation(Tree tree) {
        // algorithm:
        // if node is right child then
        // --node.parent.right = node.left
        // --node.left = node.parent
        // --if not node.parent is root then node.parent = node.parent.parent
        if (this.isRightChild(tree)) {
            this.parent(tree).setRightChild(this.getLeftChild());
            this.setLeftChild(this.parent(tree));
            if (this.parent(tree) != tree.getRoot()) {
                if (this.parent(tree).isLeftChild(tree)) {
                    this.parent(tree).parent(tree).setLeftChild(this.parent(tree));
                } else {
                    this.parent(tree).parent(tree).setRightChild(this.parent(tree));
                }
            }
        }
    }

    public void rightRotation(Tree tree) {
        // algorithm:
        // if node is left child then
        // --node.parent.left = node.right
        // --node.right = node.parent
        // --if not node.parent is root then node.parent = node.parent.parent
        if (this.isLeftChild(tree)) {
            this.parent(tree).setLeftChild(this.getRightChild());
            this.setRightChild(this.parent(tree));
            if (this.parent(tree) != tree.getRoot()) {
                if (this.parent(tree).isLeftChild(tree)) {
                    this.parent(tree).parent(tree).setLeftChild(this.parent(tree));
                } else {
                    this.parent(tree).parent(tree).setRightChild(this.parent(tree));
                }
            }
        }
    }
}
