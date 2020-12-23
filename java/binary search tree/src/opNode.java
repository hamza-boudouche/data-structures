public class opNode extends Node{
    enum Operation {
        ADD, SUB, MUL, DIV
    }

    private Operation operation = null;

    opNode(int key) {
        super(key);
    }

    opNode(int key, Operation operation) {
        super(key);
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
