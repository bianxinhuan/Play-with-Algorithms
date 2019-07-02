import java.util.Arrays;

/**
 * 优化的Merge Sort算法
 *
 * @author bianxinhuan
 * @date 2019-07-01 21:01:07
 */
public class MergeSort {

    /**
     * 我们的算法类不允许产生任何实例
     */
    private MergeSort() {
    }

    /**
     * 将arr[l...mid]和arr[mid+1...r]两部分进行归并
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static void merge(Comparable[] arr, int l, int mid, int r) {

        // 辅助空间
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // 初始化，i指向左半部分数组的起始索引位置l；j指向右半部分数组起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {

            // 如果左半部分数组元素已经全部处理完毕
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            }
            // 如果右半部分数组元素已经全部处理完毕
            else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            }
            // 左半部分数组所指元素 < 右半部分数组所指元素
            else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                arr[k] = aux[i - l];
                i++;
            }
            // 左半部分数组所指元素 >= 右半部分数组所指元素
            else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    /**
     * 递归使用归并排序,对arr[l...r]的范围进行排序
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void sort(Comparable[] arr, int l, int r) {

        // 对于小规模数组，使用插入排序
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        // 对于arr[mid] <= arr[mid+1]的情况(已经有序)不进行merge
        // 对于近乎有序的数组非常有效，但是对于一般情况，有一定的性能损失
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;

        sort(arr, 0, n - 1);
    }

    /**
     * 测试MergeSort
     *
     * @param args
     */
    public static void main(String[] args) {

        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易尝试使用SelectionSort，InsertionSort或者BubbleSort处理100万级的数据
        // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort(MergeSort.class.getName(), arr);
    }
}
