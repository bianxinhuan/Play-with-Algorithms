/**
 * 感谢github @zhengquan45 提出, 可以对选择排序进行优化
 * 在每一轮中, 可以同时找到当前未处理元素的最大值和最小值
 *
 * @author bianxinhuan
 * @date 2019-06-29 21:28:58
 */
public class SelectionSort2 {


    /**
     * 算法不允许产生任何实例
     */
    private SelectionSort2() {
    }

    public static void sort(Comparable[] arr) {

        int left = 0, right = arr.length - 1;
        while (left < right) {
            int minIndex = left;
            int maxIndex = right;

            // 在每一轮查找时，要保证arr[minIndex] <= arr[maxIndex]
            if (arr[minIndex].compareTo(arr[maxIndex]) > 0) {
                swap(arr, minIndex, maxIndex);
            }

            for (int i = left + 1; i < right; i++) {
                if (arr[i].compareTo(arr[minIndex]) < 0) {
                    minIndex = i;
                } else if (arr[i].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = i;
                }
            }

            swap(arr, left, minIndex);
            swap(arr, right, maxIndex);

            left++;
            right--;
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * 测试SelectionSort2
     *
     * @param args
     */
    public static void main(String[] args) {

        // 测试排序算法辅助函数
        int N = 100000;

        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);

        SortTestHelper.testSort(SelectionSort2.class.getName(), arr);
    }
}
