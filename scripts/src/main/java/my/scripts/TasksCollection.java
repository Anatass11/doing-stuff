package my.scripts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class TasksCollection {

    public String task1() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // Читаем количество строк
            int n = Integer.parseInt(reader.readLine());

            int water = 0;
            int previousTime = 0;

            // Обрабатываем каждую строку
            for (int i = 0; i < n; i++) {
                String[] parts = reader.readLine().split(" ");
                int T = Integer.parseInt(parts[0]);
                int V = Integer.parseInt(parts[1]);

                // Учитываем утечку с момента предыдущего долива
                int timeDiff = T - previousTime;
                water = Math.max(0, water - timeDiff);

                // Доливаем воду
                water += V;

                previousTime = T;
            }
            reader.close();

            return String.valueOf(water);
        }
        catch (IOException e) {
            return "0";
        }
    }

    public String task2(String A, String B) {
        char[] aDigits = A.toCharArray();

        // Max-heap для хранения цифр из B в порядке убывания
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((x, y) -> y - x);
        for (char c : B.toCharArray()) {
            maxHeap.offer(c);
        }

        for (int i = 0; i < aDigits.length && !maxHeap.isEmpty(); i++) {
            char best = maxHeap.peek();
            if (best > aDigits[i]) {
                aDigits[i] = maxHeap.poll();
            }
        }

        return new String(aDigits);
    }

    public void task3(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            throw new IllegalArgumentException("Массив должен содержать хотя бы 2 числа");
        }


        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        // Находим два наименьших числа за O(n)
        for (int num : numbers) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        System.out.println("2 числа с наименьшей суммой: " + min1 + ", " + min2);
    }

    public void task4(int[] numbers, int k) {
        if (numbers == null || numbers.length < k) {
            throw new IllegalArgumentException("Массив должен иметь больше значений");
        }

        int copy = numbers[k-1];
        int steps = 0;

        while (!allEqual(numbers)){
            numbers = popAdd(numbers, copy);
            ++steps;
        }
        System.out.println(Arrays.stream(numbers).boxed().toList() + "\nШагов: " + steps);
    }

    private boolean allEqual(int[] arr) {
        if (arr.length == 0) return true;
        int first = arr[0];
        for (int num : arr) {
            if (num != first) return false;
        }
        return true;
    }

    private int[] popAdd(int[] arr, int k) {
        int n = arr.length;
        int[] newArray = new int[n];
        System.arraycopy(arr, 1, newArray, 0, n - 1);
        newArray[n - 1] = k;
        return newArray;
    }
}
