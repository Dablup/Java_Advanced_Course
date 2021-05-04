import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WorkWithComparator {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();
        animals.add("cat");
        animals.add("dog");
        animals.add("frog");
        animals.add("a");
        animals.add("bird");
        animals.add("aaaaa");

        // First way to sort by comparator
        animals.sort(new StringLengthComparator());

        // Second way to sort by comparator
        Collections.sort(animals,new StringLengthComparator());

        // Third way (if you do not want to create a class)
        Collections.sort(animals, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()){
                    return 1;
                } else if (o1.length() < o2.length()){
                    return -1;
                } else return 0;
            }
        });
        System.out.println(animals);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(0);
        numbers.add(100);

        numbers.sort(new BackwardIntegerComparator());
        Collections.sort(numbers, new BackwardIntegerComparator());
        System.out.println(numbers);

        List<Person> people = new ArrayList<>();
        people.add(new Person(1,"Bob"));
        people.add(new Person(2,"Mike"));
        people.add(new Person(3,"Daniil"));

        // Sort people by id in descending order
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getId() > o2.getId()){
                    return -1;
                } else if (o1.getId() < o2.getId()){
                    return 1;
                } else return 0;
            }
        });

        System.out.println(people);
    }


}

class Person{
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        /*
            o1 > o2 then return 1 (it means that in the list in the beginning will be o2 and then o1)
            o1 < o2 then return -1 (it means that in the list in the beginning will be o1 and then o2). You do not need to swap them.
            o1 == o2 then return 0
         */
        if (o1.length() > o2.length()){
            return 1;
        } else if (o1.length() < o2.length()){
            return -1;
        } else return 0;
    }
}

class BackwardIntegerComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o2 > o1){
            return 1;
        } else if (o1 > o2){
            return -1;
        } else return 0;
    }
}
