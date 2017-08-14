package main.java.com.weifeng.test.sort;

public class Sort {
    public static void main(String[] args) {
        int[] is = { 30, 12, 22, 56, 31, 100, 2 };
        // int[] after = sortBubble1(is);
        // int[] after = sortSelect(is);
        int[] after = insertSort(is);
        for (int i : after) {
            System.out.println(i);
        }

    }

    /**
     * @param int[] 未排序数组
     * @return int[] 排完序数组
     */
    static int[] sortBubble1(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        return array;
    }

    /**
     * @param int[] 未排序数组
     * @return int[] 排完序数组
     */
    static int[] sortSelect(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int miniPost = i;
            for (int m = i + 1; m < arr.length; m++) {
                if (arr[m] < arr[miniPost])
                    miniPost = m;
            }
            if (arr[i] > arr[miniPost]) {
                int temp = arr[i];
                arr[i] = arr[miniPost];
                arr[miniPost] = temp;
            }
        }
        return arr;
    }

    /**
     * @param int[] 未排序数组
     * @return int[] 排完序数组
     */
    static int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }

}
