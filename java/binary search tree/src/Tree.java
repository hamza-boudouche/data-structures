import java.util.ArrayList;
import java.util.Iterator;

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
        // this supposes that the tree is a BST
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
        // tree is BST
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
        if (this.contains(key)) {
            Node node = new opNode(key);
            Node nextNode = new opNode(key);
            for (opNode opnode : ((expTree) this).opbreadthFirst()) {
                if (opnode.getData() == key) {
                    nextNode = (Node) opnode;
                }
            }
            Iterator<opNode> i = ((expTree) this).opbreadthFirst().iterator();
            node = i.next();
            while (i.next().getData() != key) {
                node = i.next();
            }

            if (node.getLeftChild() != null && node.getRightChild() != null) {
                nextNode = (Node) i.next();
                node.setData(nextNode.getData());
                nextNode = null;
            } else if (node.getLeftChild() != null) {
                node.setData(node.getLeftChild().getData());
            } else if (node.getRightChild() != null) {
                node.setData(node.getRightChild().getData());
            } else {
                node = null;
            }
        }
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
        if (this.getRoot().getLeftChild() != null) {
            inOrderarr.addAll(this.getRoot().getLeftSubTree().inOrder());
        }
        inOrderarr.add(this.getRoot().getData());
        if (this.getRoot().getRightChild() != null) {
            inOrderarr.addAll(this.getRoot().getRightSubTree().inOrder());
        }
        return inOrderarr;
    }

    // preOrder traversal
    private ArrayList<Integer> preOrderarr = new ArrayList<Integer>(0);

    public ArrayList<Integer> preOrder() {
        preOrderarr.add(this.getRoot().getData());
        if (this.getRoot().getLeftChild() != null) {
            preOrderarr.addAll(this.getRoot().getLeftSubTree().preOrder());
        }
        if (this.getRoot().getRightChild() != null) {
            preOrderarr.addAll(this.getRoot().getRightSubTree().preOrder());
        }
        return preOrderarr;
    }

    // postOrder traversal
    private ArrayList<Integer> postOrderarr = new ArrayList<Integer>(0);

    public ArrayList<Integer> postOrder() {
        if (this.getRoot().getLeftChild() != null) {
            postOrderarr.addAll(this.getRoot().getLeftSubTree().postOrder());
        }
        if (this.getRoot().getRightChild() != null) {
            postOrderarr.addAll(this.getRoot().getRightSubTree().postOrder());
        }
        postOrderarr.add(this.getRoot().getData());
        return postOrderarr;
    }

    // Breadth First or Level Order Traversal

    private ArrayList<Node> breadthFirstArr = new ArrayList<Node>(0);

    public ArrayList<Node> breadthFirst() {
        ArrayList<Node> current = new ArrayList<Node>(0);
        current.add(this.getRoot());
        ArrayList<Node> next = new ArrayList<Node>(0);
        while (current.size() != 0) {
            breadthFirstArr.addAll(current);
            for (Node node : current) {
                if (node.getLeftChild() != null) {
                    next.add((Node) node.getLeftChild());
                }
                if (node.getRightChild() != null) {
                    next.add((Node) node.getRightChild());
                }
            }
            current = new ArrayList<Node>(next);
            next = new ArrayList<Node>(0);
        }
        return breadthFirstArr;
    }
}
