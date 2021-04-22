import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
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

        /*
         * Work with a hash map structure
         * In hash map, the data is not structured. It means that it does not maintain the order of adding elements to the map.
         * (When you output your map, your data can be outputted in a different order than the order of adding)
         */
        Map<String, String> map = new HashMap<>();
        map.put("кошка","cat");
        map.put("волк","wolf");
        map.put("слон","elephant");

        for(Map.Entry<String , String> entry: map.entrySet()){
            System.out.println(entry.getKey()+" : " + entry.getValue());
        }


        /*
         * Work with a linked hash map structure
         * In the linked hash map, the data is structured. It means that it maintains the order of adding elements to the map.
         * (When you output your map, your data will be outputted in the order of adding)
         */
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("кошка","cat");
        linkedHashMap.put("волк","wolf");
        linkedHashMap.put("слон","elephant");

        for(Map.Entry<String , String> entry: linkedHashMap.entrySet()){
            System.out.println(entry.getKey()+" : " + entry.getValue());
        }

        /*
         * Work with a tree map structure
         * In the tree map, the data is sorted by key.
         */
        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("кошка","cat");
        treeMap.put("волк","wolf");
        treeMap.put("слон","elephant");

        for(Map.Entry<String , String> entry: treeMap.entrySet()){
            System.out.println(entry.getKey()+" : " + entry.getValue());
        }


        /*
            Set contains only unique entries
            Hash set has no any order
            Linked hash set has the same order of entries as they were added
            In tree set entries are sorted
         */
        Set<Integer> hashSet1 = new HashSet<>();
        Set<Integer> hashSet2 = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();



        //union
        hashSet1.add(0);
        hashSet1.add(1);
        hashSet1.add(2);
        hashSet1.add(3);

        hashSet2.add(2);
        hashSet2.add(3);
        hashSet2.add(4);

        Set<Integer> union = new HashSet<>(hashSet1);
        union.addAll(hashSet2);
        System.out.println(union);

        //intersection
        Set<Integer> intersection = new HashSet<>(hashSet1);
        intersection.retainAll(hashSet2);
        System.out.println(intersection);

        //difference
        Set<Integer> difference = new HashSet<>(hashSet1);
        difference.removeAll(hashSet2);
        System.out.println(difference);
    }
}
