package gb_collections.lists;

import gb_collections.GBList;
import gb_collections.lists.util.GBNode;

import java.util.Iterator;


public class GBLinkedList<U> implements GBList<U> {
    private int size;
    private GBNode<U> head;

    public GBLinkedList() {
        this.size = 0;
        this.head = null;
    }

    @Override
    public void add(U value) {
        GBNode<U> link = new GBNode<>(value);
        if (head == null) {
            head = link;
        } else {
            GBNode<U> link2 = head;
            while (link2.getNext() != null){
                link2 = link2.getNext();
            }
            link2.setNext(link);
            link.setPrev(link2);
        }
        size++;
    }

    @Override
    public U get(int index) {
        if (!(index >= 0 && index < size)){
            throw new IndexOutOfBoundsException();
        } else {
            GBNode<U> node = head;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
            return node.getElement();
        }
    }

    @Override
    public void remove(U value) {
        Iterator<U> iter = iterator();
        int index = 0;
        while (iter.hasNext()){
            if(value.equals(iter.next())){
                removeByIndex(index);
                return;
            }
            index++;
        }
    }

    @Override
    public void removeByIndex(int index) {
            if (index == 0) {
                head = head.getNext();
                size--;
                return;
            }

            int count = 0;
            GBNode<U> prev = null;
            GBNode<U> curr = head;
            while (count != index){
                prev = curr;
                curr = curr.getNext();
                count++;
            }

            prev.setNext(curr.getNext());
            size--;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<U> iterator() {
        return new Iterator<U>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public U next() {
                return get(index++);
            }
        };
    }

    @Override
    public String toString() {
        String result = "[";
        GBNode<U> current = head;
        while (current != null) {
            result += current.getElement();
            if(current.getNext() != null){
                result += ", ";
            }
            current = current.getNext();
        }
        return result + "]";
    }

}
