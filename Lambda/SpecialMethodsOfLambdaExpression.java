package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SpecialMethodsOfLambdaExpression {
    public static void main(String[] args) {
        int[] array = new int[10];
        List<Integer> list = new ArrayList<>();
        fillArray(array);
        fillList(list);
        System.out.println(list);
        System.out.println(Arrays.toString(array));
        System.out.println();

        // method MAP(if you want to perfom some operation on the elements of the array or list
        System.out.println("After map");
        array = Arrays.stream(array).map(i -> i*2).toArray();
        list = list.stream().map(i -> i*2).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(Arrays.toString(array));

        // method FILTER(if you want to get some part of the data from array or list using some predicate)
        System.out.println("After filter");
        int[] array2 = new int[10];
        List<Integer> list2 = new ArrayList<>();
        fillArray(array2);
        fillList(list2);

        array2 = Arrays.stream(array2).filter(a -> a % 2 == 0).toArray();
        System.out.println(Arrays.toString(array2));

        // method FOR EACH
        Arrays.stream(array2).forEach(a -> System.out.print(a));
        list2.stream().forEach(a -> System.out.print(a));
        System.out.println();
        System.out.println();


        // method REDUCE(если хотите преобразовать список или массив в одно значение. Например: сумма всех элементов
        System.out.println("Method REDUCE");
        int[] array3 = new int[10];
        List<Integer> list3 = new ArrayList<>();
        fillList(list3);
        fillArray(array3);

        int sum = Arrays.stream(array3).reduce((acc, b) -> acc + b).getAsInt();
        int sum2 = list3.stream().reduce((acc,b) -> acc + b).get();
        System.out.println(sum);
        System.out.println(sum2);
    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
    }

    private static void fillArray(int[] array) {
        for (int i = 0; i < 10 ; i++) {
            array[i] = i;
        }
    }
}
