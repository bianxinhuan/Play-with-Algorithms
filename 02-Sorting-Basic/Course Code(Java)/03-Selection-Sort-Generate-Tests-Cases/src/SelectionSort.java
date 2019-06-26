/**
 * 选择排序
 *
 * @author bianxinhuan
 * @date 2019-06-24 23:06:00
 */
public class SelectionSort {

    /**
     * 算法不允许产生任何实例
     */
    private SelectionSort() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        // 测试排序算法辅助函数
        int N = 20000;

        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);

        SelectionSort.sort(arr);

        SortTestHelper.printArray(arr);
    }
}
