import java.util.*;

public class WorkWithInterfaceComparable {
    public static void main(String[] args) {
        List<New_person> peopleList = new ArrayList<>();
        Set<New_person> peopleSet = new TreeSet<>();

        addElements(peopleList);
        addElements(peopleSet);

        System.out.println(peopleList);
        System.out.println(peopleSet);
    }
    private static void addElements(Collection collection){
        collection.add(new New_person(1,"Bob"));
        collection.add(new New_person(3,"Mike"));
        collection.add(new New_person(4,"Dan"));
        collection.add(new New_person(2,"Polina"));
    }
}

class New_person implements Comparable<New_person>{
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        New_person that = (New_person) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public New_person(int id, String name) {
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

    @Override
    public int compareTo(New_person o) {
        if (this.id > o.getId()){
            return 1;
        } else if (this.id < o.getId()){
            return -1;
        } else return 0;
    }
}