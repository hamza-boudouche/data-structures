public class brNode extends Node{
    private boolean color;

    brNode(int key){
        super(key);
        this.color = true; //true for red, false for black
    }

    @Override
    public brNode getLeftChild() {
        return (brNode) super.getLeftChild();
    }

    @Override
    public brNode getRightChild() {
        return (brNode) super.getRightChild();
    }

    public void reColor() {
        this.color = !this.color;
    }

    public boolean getColor() {
        return this.color;
    }

    public brNode parent(redblackTree tree) {
        if (this.getData() < tree.getRoot().getData()) {
            if (tree.getRoot().getLeftChild().getData() == this.getData()) {
                return tree.getRoot();
            }
            return (brNode) this.parent(this.getLeftSubTree());
        } else if (this.getData() > tree.getRoot().getData()) {
            if (tree.getRoot().getRightChild().getData() == this.getData()) {
                return tree.getRoot();
            }
            return (brNode) this.parent(this.getRightSubTree());
        }
        return new brNode(-1);
    }

    public brNode uncle(redblackTree tree) {
        // algorithm:
        // if node is right child
        // --return node.parent.left
        // return node.parent.right
        if (this.isRightChild(tree)) {
            return this.parent(tree).getLeftChild();
        }
        return this.parent(tree).getRightChild();
    }
}
