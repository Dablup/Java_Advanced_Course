import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /**
         * Work with created singly linked list
         */
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

        /**
         * Work with hashmap structure
         */
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");

        for(Map.Entry<Integer, String> entry: map.entrySet()){
            System.out.println(entry.getKey()+" : " + entry.getValue());
        }

    }
}
