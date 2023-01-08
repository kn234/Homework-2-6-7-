import java.util.Arrays;

public class Homework2 {
    public static void main(String[] args) throws Exception {
        //  ===============1==============
        int[] arrayForChange = { 0, 1, 0, 0, 1, 0, 1, 0, 1, 0 };
        for (int i = 0; i < arrayForChange.length; i++) {
            arrayForChange[i] = (arrayForChange[i] == 1) ? 0 : 1;
        }
        System.out.println(Arrays.toString(arrayForChange));

        // ===============2==============
        int[] arrayForFill = new int[8];
        Integer[] arrayWithValues = Arrays
                .stream("0 3 6 9 12 15 18 21".split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        for (int i = 0; i < arrayForFill.length; i++) {
            arrayForFill[i] = arrayWithValues[i];
        }

        System.out.println(Arrays.toString(arrayForFill));

        //  ===============3==============
        int[] arrayForMulti = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        int[] arrayAfterMulti = Arrays.stream(arrayForMulti).map(el -> {
            if (el < 6) el *= 2;
            return el;
        }).toArray();

        System.out.println(Arrays.toString(arrayAfterMulti));

        //  ===============4==============
        int[][] squareArray = new int[4][4];
        for (int i = 0; i < squareArray.length; i++) {
            for (int j = 0; j < squareArray[i].length; j++) {
                if(i == j) squareArray[i][j] = 1;
            }
            squareArray[squareArray.length - i - 1][i] = 1;
        }

        StringBuilder res = new StringBuilder(" ");
        for (int i = 0; i < squareArray.length; i++) {
            res.append("\n");
            for (int j = 0; j < squareArray[i].length; j++) {
                res.append(squareArray[i][j]);
                res.append(" ");
            }
        }
        System.out.println(res);

        //  ===============5==============
        int[] findMaxArray = {7, 4, 9, 61, 1, 8, 10, 22, 5, 13, 91};
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int element : findMaxArray) {
            if (element > max) max = element;
            if (element < min) min = element;
        }
        System.out.println(max);
        System.out.println(min);

        //  ===============6==============
        int [] arrForBalance = {1, 2, 0, 1, 2};
        System.out.println(checkBalance(arrForBalance));

        //  ===============7==============
        int [] arrForMove = {3, 4, 1, 4, 1, 4, 2, 1, 4};
        System.out.println(Arrays.toString(moveArray(arrForMove, 3)));
    }

    public static boolean checkBalance(int [] array) throws Exception {
        if (array.length == 0) {
            throw new Exception("Array should not be empty");
        }

        int center = (array.length % 2 == 0) ? array.length / 2 - 1 : array.length / 2;
        int left = 0;
        int right = 0;

        for (int i = 0; i < array.length; i++) {
            if (i <= center) left += array[i];
            if (i > center) right += array[i];
        }

        return left == right;
    }

    public static int[] moveArray (int [] array, int n) throws Exception {
        if (array.length == 0) {
            throw new Exception("Array should not be empty");
        }

        if (n >= 0) {
            for (int i = 0; i < n; i++) {
                int steps = ((array.length - 1) - i) / n;
                int prevElement = array[i];
                int currIndex = i;
                array[i] = 0;
                for (int j = 1; j < steps + 1; j++) {
                    currIndex += n;
                    int next = array[currIndex];
                    array[currIndex] = prevElement;
                    prevElement = next;
                }
            }
        } else {
            for (int i = array.length - 1; i > array.length - 1 - (-n); i--) {
                int steps = -i / n;
                int prevElement = array[i];
                int currIndex = i;
                array[i] = 0;
                for (int j = 1; j < steps + 1; j++) {
                    currIndex -= -n;
                    int next = array[currIndex];
                    array[currIndex] = prevElement;
                    prevElement = next;
                }
            }
        }

        return array;
    }
}
