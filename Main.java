public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(0);
        list.add(-1);
//        list.get(-1);
        System.out.println(list);
        list.remove(1);
        list.remove(1);
        list.remove(0);
        System.out.println(list);
    }
}
