/**
 * -
 *
 * @author bianxinhuan
 * @date 2019-06-29 22:50:41
 */
public class BubbleSort2 {

    /**
     * 我们的算法类不允许产生任何实例
     */
    private BubbleSort2() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;

        // 使用newn进行优化
        int newn;

        do {
            newn = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1].compareTo(arr[0]) > 0) {
                    swap(arr, i - 1, i);
                }
                newn = i;
            }
            n = newn;
        } while (newn > 0);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
