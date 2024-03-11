package gb_collections.lists;

import gb_collections.GBList;
import gb_collections.lists.util.ArrayIterator;

import java.util.Iterator;

public class GBArrayList<E> implements GBList<E> {
    private E[] values;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public GBArrayList() {
        this.size = 0;
        this.capacity = 10;
        try {
            this.values = (E[]) new Object[capacity];
        } catch (ClassCastException e){
            e.printStackTrace();
        };
    }

    @SuppressWarnings("unchecked")
    private void addCapacity(){
        try {
            capacity = capacity + capacity / 2;
            E[] arr = (E[]) new Object[capacity];
            System.arraycopy(values, 0, arr, 0, values.length);
            this.values = arr;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(E value) {
        if (size == capacity) addCapacity();
        values[size++] = value;
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public void remove(E value) {
        for (int i=0; i < values.length; i++){
            if(values[i].equals(value)){
                removeByIndex(i);
                return;
            }
        }
        throw new RuntimeException("Element was not found.");
    }

    @Override @SuppressWarnings("unchecked")
    public void removeByIndex(int index) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            int amountElementsAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, values, index, amountElementsAfterIndex);
            size--;
        } catch (ClassCastException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(values);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        int i = 0;
        while (values[i] != null) {
            builder.append(values[i]).append(", ");
            i++;
        }
        if (builder.length() == 1)
            return "[]";
        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }
}