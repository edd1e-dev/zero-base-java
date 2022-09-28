package LinearDataStructure.LinearDS_03.src;// Practice1
// 배열 arr 의 모든 데이터에 대해서,
// 짝수 데이터들의 평균과 홀수 데이터들의 평균을 출력하세요.

// 입출력 예시)
// 배열 arr: 1, 2, 3, 4, 5, 6, 7, 8, 9
// 결과:
// 짝수 평균: 5.0
// 홀수 평균: 5.0

public class Practice1 {
    public static void main(String[] args) {
        double odd = 0;
        double even = 0;
        int oddCount = 0;
        int evenCount = 0;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                even += arr[i];
                evenCount++;
            } else {
                odd += arr[i];
                oddCount++;
            }
        }

        System.out.println("짝수 평균: " + even / evenCount);
        System.out.println("홀수 평균: " + odd / oddCount);
    }

}
