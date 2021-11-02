package Lambda;

import java.util.ArrayList;
import java.util.List;

interface Executable{
    int execute(int x, int y);
}

class Runner{
    void run(Executable e){
        int a = e.execute(2,3);
        System.out.println(a);
    }
}
public class Lambda {
    public static void main(String[] args) {
        Runner runner = new Runner();

        // Using anonymous class
        runner.run(new Executable() {
            @Override
            public int execute(int x, int y) {
                return x + y;
            }
        });

        // Using lambda expressions
        runner.run((x,y) -> x+y);

        // Sorting of the list using lambda expression (NOT comparator)
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("aa");
        list.add("a");
        list.sort((s1,s2) -> {
            if (s1.length() > s2.length()){
                return 1;
            } else if (s1.length() < s2.length()){
                return -1;
            } else {
                return 0;
            }
        });
        System.out.println(list);
    }
}
