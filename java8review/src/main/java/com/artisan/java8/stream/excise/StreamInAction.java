package com.artisan.java8.stream.excise;



import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by wangwenjun on 2016/10/22.
 */
public class StreamInAction {
    public static void main(String[] args) {

        Trader raoul = new  Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );



         // (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）
        List<Transaction> collect = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(toList());

        System.out.println(collect);

        System.out.println("==============================================================");

        //   (2) 交易员都在哪些不同的城市工作过？

        List<String> collect1 = transactions.stream()
                .map(t->t.getTrader().getCity())
                .distinct()
                .collect(toList());

        System.out.println(collect1);

        System.out.println("===========2===================================================");

        //   (3) 查找所有来自于剑桥的交易员，并按姓名排序。

        transactions.stream().map(t->t.getTrader())
                .filter(x -> x.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);



        System.out.println("==============================================================");
        //    (4) 返回所有交易员的姓名字符串，按字母顺序排序。

        transactions.stream()
                .map(t->t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (a,b)->a+b);

        //   (5) 有没有交易员是在米兰工作的？

        transactions.stream().anyMatch(t->t.getTrader().getCity().equals("Milan"));


        //   (6) 打印生活在剑桥的交易员的所有交易额。


        transactions.stream()
                .filter(t->t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        System.out.println("======ffffff=======================");

        //    (7) 所有交易中，最高的交易额是多少？
        Optional<Integer> reduce = transactions.stream().map(Transaction::getValue)
                .reduce((i, j) -> i > j ? i : j);

        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue).reduce(Integer::max);

        System.out.println(max.get());
        System.out.println(reduce.get());

        System.out.println("======ddd=======================");

        //    (8) 找到交易额最小的交易

        Optional<Integer> minValue1 = transactions.stream()
                .map(Transaction::getValue).reduce(Integer::min);

        System.out.println(minValue1.get());




        //1. Find all transactions in the year 2011 and sort them by value (small to high).
        List<Transaction> result = transactions.stream().filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(toList());

        System.out.println(result);


        //2.What are all the unique cities where the traders work?
        transactions.stream().map(t -> t.getTrader().getCity())
                .distinct().forEach(System.out::println);
        System.out.println("==================");

        //3.Find all traders from Cambridge and sort them by name.
        transactions.stream().map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);

        //4.Return a string of all traders’ names sorted alphabetically

        String value = transactions.stream().map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (name1, name2) -> name1 + name2);
        System.out.println(value);


        //5. Are any traders based in Milan?

        boolean liveInMilan1 = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        boolean liveInMilan2 = transactions.stream().map(Transaction::getTrader).anyMatch(t -> t.getCity().equals("Milan"));

        System.out.println(liveInMilan1);
        System.out.println(liveInMilan2);

        //6.Print all transactions’ values from the traders living in Cambridge.

        transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);


        //7.What’s the highest value of all the transactions?
        Optional<Integer> maxValue = transactions.stream().map(Transaction::getValue).reduce((i, j) -> i > j ? i : j);
        System.out.println(maxValue.get());

        //8.Find the transaction with the smallest value.
        Optional<Integer> minValue = transactions.stream().map(Transaction::getValue).reduce(Integer::min);
        System.out.println(minValue.get());
    }

}
