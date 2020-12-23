import java.util.ArrayList;
public class expTree extends Tree{
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
                return ((expTree) this.getRoot().getLeftSubTree()).calculate()
                        + ((expTree) this.getRoot().getRightSubTree()).calculate();
            case DIV:
                return ((expTree) this.getRoot().getLeftSubTree()).calculate()
                        / ((expTree) this.getRoot().getRightSubTree()).calculate();
            case MUL:
                return ((expTree) this.getRoot().getLeftSubTree()).calculate()
                        * ((expTree) this.getRoot().getRightSubTree()).calculate();
            case SUB:
                return ((expTree) this.getRoot().getLeftSubTree()).calculate()
                        - ((expTree) this.getRoot().getRightSubTree()).calculate();
            default:
                return 0;
        }

    }

    // depth first traversals:

    // inOrder traversal
    private ArrayList<opNode> inOrderarr = new ArrayList<opNode>(0);

    public ArrayList<opNode> opinOrder() {
        if (this.getRoot().getLeftChild() != null) {
            inOrderarr.addAll(((expTree) this.getRoot().getLeftSubTree()).opinOrder());
        }
        inOrderarr.add(this.getRoot());
        if (this.getRoot().getRightChild() != null) {
            inOrderarr.addAll(((expTree) this.getRoot().getRightSubTree()).opinOrder());
        }
        return inOrderarr;
    }

    // preOrder traversal
    private ArrayList<opNode> preOrderarr = new ArrayList<opNode>(0);

    public ArrayList<opNode> oppreOrder() {
        if (this.getRoot().getLeftChild() != null) {
            preOrderarr.addAll(((expTree) this.getRoot().getLeftSubTree()).oppreOrder());
        }
        preOrderarr.add(this.getRoot());
        if (this.getRoot().getRightChild() != null) {
            preOrderarr.addAll(((expTree) this.getRoot().getRightSubTree()).oppreOrder());
        }
        return preOrderarr;
    }

    // postOrder traversal
    private ArrayList<opNode> postOrderarr = new ArrayList<opNode>(0);

    public ArrayList<opNode> oppostOrder() {
        if (this.getRoot().getLeftChild() != null) {
            postOrderarr.addAll(((expTree) this.getRoot().getLeftSubTree()).oppostOrder());
        }
        postOrderarr.add(this.getRoot());
        if (this.getRoot().getRightChild() != null) {
            postOrderarr.addAll(((expTree) this.getRoot().getRightSubTree()).oppostOrder());
        }
        return postOrderarr;
    }

    // Breadth First or Level Order Traversal

    private ArrayList<opNode> breadthFirstArr = new ArrayList<opNode>(0);

    public ArrayList<opNode> opbreadthFirst() {
        ArrayList<opNode> current = new ArrayList<opNode>(0);
        current.add(this.getRoot());
        ArrayList<opNode> next = new ArrayList<opNode>(0);
        while (current.size() != 0) {
            breadthFirstArr.addAll(current);
            for (opNode node : current) {
                if (node.getLeftChild() != null) {
                    next.add((opNode) node.getLeftChild());
                }
                if (node.getRightChild() != null) {
                    next.add((opNode) node.getRightChild());
                }
            }
            current = new ArrayList<opNode>(next);
            next = new ArrayList<opNode>(0);
        }
        return breadthFirstArr;
    }

    public void zeroAddressInstructions() {
        for (opNode opNode : this.oppreOrder()) {
            if (opNode.getOperation() != null) {
                System.out.println(opNode.getOperation());
            } else {
                System.out.print("PUSH ");
                System.out.println(opNode.getData());
            }
        }
    }
}
