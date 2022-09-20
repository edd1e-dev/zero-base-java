package CodingTest.TestProblem.Problem2;
import java.util.*;

public class Problem2 {
    public static int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();

        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (list.size() != 0 && list.get(list.size() - 1) != arr[i]) {
                list.add(arr[i]);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,1,3,3,0,1,1})); // [1,3,0,1]
        System.out.println(solution(new int[] {4,4,4,3,3})); // [4,3]
    }
}
