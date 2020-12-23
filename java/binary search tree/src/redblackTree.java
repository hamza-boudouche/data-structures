import java.util.ArrayList;
public class redblackTree extends Tree{
    private brNode root;

    redblackTree(brNode root) {
        this.root = root;
    }

    @Override
    public brNode getRoot() {
        return this.root;
    }
    
    // Breadth First or Level Order Traversal

    private ArrayList<brNode> breadthFirstArr = new ArrayList<brNode>(0);

    public ArrayList<brNode> brbreadthFirst() {
        ArrayList<brNode> current = new ArrayList<brNode>(0);
        current.add(this.root);
        ArrayList<brNode> next = new ArrayList<brNode>(0);
        while (current.size() != 0) {
            breadthFirstArr.addAll(current);
            for (brNode node : current) {
                if (node.getLeftChild() != null) {
                    next.add((brNode) node.getLeftChild());
                }
                if (node.getRightChild() != null) {
                    next.add((brNode) node.getRightChild());
                }
            }
            current = new ArrayList<brNode>(next);
            next = new ArrayList<brNode>(0);
        }
        return breadthFirstArr;
    }

    public brNode check(redblackTree tree) {
        // returns the node in which there is a probleme; null if there is none
        if(this.root.getColor()){
            return this.root;
        }
        ArrayList<brNode> arr = this.brbreadthFirst();
        for (brNode brNode : arr) {
            if(this.root.getData() != brNode.getData()){
                if(brNode.getColor() && brNode.parent(tree).getColor()){
                    return brNode;
                }
            }
        }
        return null;
    }

    public void rebalance(redblackTree tree) {
        while (this.check(tree) != null) {
            brNode prbNode = this.check(tree);
            if(prbNode.getData() == tree.getRoot().getData()){
                tree.getRoot().reColor();
                //continue;
            }
            else if(prbNode.uncle(tree).getColor()){
                prbNode.parent(tree).reColor();
                prbNode.parent(tree).parent(tree).reColor();
                prbNode.uncle(tree).reColor();
            }
            else if(prbNode.angle(tree)){
                if(prbNode.isLeftChild(tree)){
                    prbNode.parent(tree).leftRotation(tree);
                }
                else{
                    prbNode.parent(tree).rightRotation(tree);
                }
            }
            else if(prbNode.line(tree)){
                if(prbNode.isLeftChild(tree)){
                    prbNode.parent(tree).parent(tree).leftRotation(tree);
                }
                else{
                    prbNode.parent(tree).parent(tree).rightRotation(tree);
                }
                prbNode.parent(tree).reColor();
                prbNode.parent(tree).parent(tree).reColor();
                prbNode.uncle(tree).reColor();
            }
        }
    }
}
