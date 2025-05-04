import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
4. Write a java program which first creates a list
and then determines negative , positive, even, odd numbers.

 */
public class Que4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        StringBuilder negative = new StringBuilder("Negative numbers: ");
        StringBuilder positive = new StringBuilder("Positive numbers: ");
        StringBuilder even = new StringBuilder("Even numbers: ");
        StringBuilder odd = new StringBuilder("Odd numbers: ");

        System.out.println("Enter 10 numbers:");
        for (int i = 0; i < 10; i++) {
            list.add(sc.nextInt());
        }

        for(int num: list){
            if (num < 0) negative.append(num).append(" ");
            if (num > 0) positive.append(num).append(" ");
            if (num % 2 == 0){
                even.append(num).append(" ");
            }
            else{
                odd.append(num).append(" ");
            }
        }

        System.out.println("Positive : " + positive);
        System.out.println("Negative : " + negative);
        System.out.println("even : " + even);
        System.out.println("odd : " + odd);
    }

}

