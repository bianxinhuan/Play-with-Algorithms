import java.util.Arrays;

/**
 * -
 *
 * @author bianxinhuan
 * @date 2019-06-28 22:08:27
 */
public class Main {

    /**
     * 比较Merge Sort和Quick Sort两种排序算法的性能效率
     * 两种排序算法虽然都是O(nlogn)级别的, 但是Quick Sort算法有常数级的优势
     * Quick Sort要比Merge Sort快, 即使我们对Merge Sort进行了优化
     *
     * @param args
     */
    public static void main(String[] args) {

        int N = 1000000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort(MergeSort.class.getName(), arr1);
        SortTestHelper.testSort(QuickSort.class.getName(), arr2);

        System.out.println();

        // 测试2 测试近乎有序的数组
        // 但是对于近乎有序的数组, 我们的快速排序算法退化成了O(n^2)级别的算法
        // 思考一下为什么对于近乎有序的数组, 快排退化成了O(n^2)的算法? :)
        int swapTimes = 100;
        assert swapTimes >= 0;

        // 原版代码中这里使用的是仍然是上方100万的数据规模进行测试，
        // 我的环境下(Oracle JDK 1.8)会造成栈溢出异常java.lang.StackOverflowError，为了方便没有更改虚拟机参数，将数据规模改为300000。
        N = 300000;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort(MergeSort.class.getName(), arr1);
        SortTestHelper.testSort(QuickSort.class.getName(), arr2);
    }
}
