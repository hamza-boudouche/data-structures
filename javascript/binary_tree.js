/*
*implement node class
*implement tree class
*height of tree
*height of node
*is leaf node
*depth of node
*enumerating nodes
*searching for a node
*adding node in a position
deleting a node
pruning: removing a subtree
grafting: adding a subtree
finding the lowest common ancestor of 2 nodes
pre order walk 
post order walk
in order traversal
level order traversal
*/


class Node {
    constructor(data, leftChild = null, rightChild = null) {
        this.data = data;
        this.rightChild = rightChild;
        this.leftChild = leftChild;
    }

    isleaf() {
        if (this.rightChild || this.leftChild) {
            return false;
        }
        return true;
    }

}

class Tree {
    constructor(root) {
        this.root = root;
    }

    insert(parentNode, childNode) {
        if (parentNode.rightChild) {
            if (parentNode.leftChild) {
                return;
            }
            parentNode.leftChild = childNode;
        }
        parentNode.rightChild = childNode;
    }

    size() {
        function s(node) {
            let result = 1;
            if (node.leftChild) { result += s(node.leftChild); }
            if (node.rightChild) { result += s(node.rightChild); }
            return result;
        }

        return s(this.root);
    }

    height(node = this.root) {
        function h(n) {
            if (!n) {
                return 0;
            }
            return 1 + Math.max(h(n.leftChild), h(n.rightChild));
        }

        return h(node);
    }

    depth(node) {
        if (!this.isIn(node)) {
            return -1;
        }
        let currentRow = [this.root];
        let depth = 0;
        while (!currentRow.includes(node)) {
            depth += 1;
            let newRow = [];
            for (let n of currentRow) {
                if (n.leftChild) {
                    newRow.push(n.leftChild);
                }
                if (n.rightChild) {
                    newRow.push(n.rightChild);
                }
                currentRow = newRow;
            }
        }
        return depth;
    }

    isIn(node) {
        let currentRow = [this.root];
        while (!currentRow.includes(node) && currentRow.length) {
            let newRow = [];
            for (let n of currentRow) {
                if (n.leftChild) {
                    newRow.push(n.leftChild);
                }
                if (n.rightChild) {
                    newRow.push(n.rightChild);
                }
                currentRow = newRow;
            }
        }
        return !!currentRow.length;
    }
    delete(node) {
        if (!(this.isIn(node))) {
            return;
        } else if (node == this.root) {
            this.root = null;
        }
        let currentRow = [this.root];
        let i = 0;
        let nextRow = [];
        while (!nextRow.includes(node)) {
            for (let n of currentRow) {
                //console.log(n.data);
                //console.log(n.leftChild);
                if (n.leftChild != null) {
                    //console.log("in1");
                    nextRow.push(n.leftChild);
                }
                if (n.rightChild != null) {
                    //console.log("in2");
                    nextRow.push(n.rightChild);
                }
                if (nextRow.includes(node)) {
                    break;
                }
                i++;
                //console.log("current");
                //console.log(currentRow);
                //console.log("next")
                //console.log(nextRow);
            }
            currentRow = nextRow;
            nextRow = [];
        }
        let parentNode = currentRow[i];
        if (parentNode.leftChild == node) {
            parentNode.leftChild = null;
        } else {
            parentNode.rightChild = null;
        }
    }
}

let n5 = new Node(5);
let n4 = new Node(4);
let n3 = new Node(3);
let n2 = new Node(2, n4, n5);
let n1 = new Node(1, n2, n3);

let t = new Tree(n1);

let n6 = new Node(6);

t.insert(n3, n6);
t.delete(n5);

console.log(t.height(n2));

console.log(t.isIn(n6));