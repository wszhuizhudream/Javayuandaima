package linkedlist;

/**
 * Author:WSChase
 * Created:2018/11/27
 */
public class Node {
    private Object data;
    private Node next;//指向下一个节点

    public Node(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
