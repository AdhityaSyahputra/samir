package samir.test.samir;

import java.util.List;

public class NumberUtils {

    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 6, 7);
        System.out.println("Jumlah angka genap: " + sumEvenNumbers(nums));
    }
}

