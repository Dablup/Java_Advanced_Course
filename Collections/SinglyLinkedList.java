package Collections;

import java.util.Arrays;

public class SinglyLinkedList {
    /**
     * Node head - the first node of the list
     * size - the size of the list
     */
    private Node head;
    private int size;

    /**
     * Method to add value to the list
     * @param value - what you want to add to the list
     * @return true if success
     */
    public boolean add(int value){
        if (head == null){
            this.head = new Node(value);
        } else{
            Node temporary_head = this.head;
            while (temporary_head.getNext() != null){
                temporary_head = temporary_head.getNext();
            }
            temporary_head.setNext(new Node(value));
        }
        this.size++;
        return true;
    }

    /**
     * Method to remove element from list
     * @param index - from which position you want to delete the element from the list
     * @throws IllegalArgumentException - if entered index is not appropriate to the list
     */
    public void remove(int index) throws IllegalArgumentException{
        if (index > this.size || index < 0){
            throw new IllegalArgumentException("Your index is greater than size of the list or index is negative");
        }
        int current_index = 0;
        Node temp = head;
        if (index == 0){
            this.head = head.getNext();
            size--;
            return;
        } else if (this.size < 2 && (index != 0)) {
            throw new IllegalArgumentException("There is no such index in the list");
        } else {
            while (temp != null){
                if (current_index  == index - 1){
                    temp.setNext(temp.getNext().getNext());
                    this.size--;
                    return;
                }
                temp = temp.getNext();
                current_index++;
            }
        }
        throw new IllegalArgumentException("There is no such index in the list");
    }

    /**
     * Method to get element from the list from the 'index' position
     * @param index - from which position you want to get the element
     * @return - element on the 'index' position
     * @throws IllegalArgumentException - if entered index is not appropriate to the list
     */
    public int get(int index) throws IllegalArgumentException{
        if (index > this.size || index < 0){
            throw new IllegalArgumentException("Your index is greater than size of the list or index is negative");
        }
        Node temp = head;
        int current_index = 0;
        while (temp != null){
            if (current_index == index){
                System.out.println(temp.getValue());
                return temp.getValue();
            }
            temp = temp.getNext();
            current_index++;
        }
        throw new IllegalArgumentException();
    }

    /**
     * Method to output the list as string
     * @return list as string
     */
    public String toString(){
        int[] result = new int[this.size];
        Node temp = this.head;

        for (int i = 0; i < this.size; i++) {
            result[i] = temp.getValue();
            temp = temp.getNext();
        }
        return Arrays.toString(result);
    }

    /**
     * Inner class 'Node'
     */
    private static class Node {
        private Node next;
        private int value;


        public Node(int value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public int getValue() {
            return value;
        }
    }
}
