package com.lmr.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author lemonlimengran@didichuxing.com
 * @date 2019-09-16
 * @description
 */
public class JLambda {

    public static void main(String[] args) {

        System.out.println("+_+");

//        TestForEach();

//        TestPredicate();

        TestMapReduce();

    }

    private static void TestMapReduce() {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i * 100);
        }

//        list=list.stream().map(n->n+1).collect(Collectors.toList());
//        System.out.println(list.toString());

//        list=list.stream().map(n->fun(n)).collect(Collectors.toList());
//        list=list.stream().map(n->{return n-66;}).collect(Collectors.toList());
//        System.out.println(list.toString());

//        double xs = list.stream().map(n -> n + 1).reduce((sum, count) -> sum + count).get();
        double xs = list.stream().map(n -> n + 1).collect(Collectors.summingInt(x -> x));
        System.out.println(xs);

    }

    private static Integer fun(Integer x) {
        return ((int) (x * 0.5));
    }

    private static void TestPredicate() {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        Predicate<Integer> predicate = n -> n % 2 == 0;

        list.stream().filter(predicate).forEach(n -> System.out.println(n));

        list = list.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
        System.out.println(list.toString());

    }

    private static void TestForEach() {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + "");
        }

        list.forEach(n -> System.out.println(n + 1));

        list.forEach(System.out::println);

    }

}
