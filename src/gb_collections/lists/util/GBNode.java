package gb_collections.lists.util;

public class GBNode<U> {
    private U element;
    private GBNode<U> prev;
    private GBNode<U> next;

    public GBNode(U element) {
        this.element = element;
        this.prev = null;
        this.next = null;
    }

    public U getElement() {
        return element;
    }

    public GBNode<U> getPrev() {
        return prev;
    }

    public GBNode<U> getNext() {
        return next;
    }

    public void setElement(U element) {
        this.element = element;
    }

    public void setPrev(GBNode<U> prev) {
        this.prev = prev;
    }

    public void setNext(GBNode<U> next) {
        this.next = next;
    }
}
