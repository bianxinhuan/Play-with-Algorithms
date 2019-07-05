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
        // 加入了随机选择标定点的步骤后, 我们的快速排序可以轻松处理近乎有序的数组
        // 但是对于近乎有序的数组, 其效率比优化后的归并排序要低, 但完全再容忍范围里
        // 思考一下为什么对于近乎有序的数组, 快排的性能比优化后的归并排序低? :)
        int swapTimes = 100;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort(MergeSort.class.getName(), arr1);
        SortTestHelper.testSort(QuickSort.class.getName(), arr2);

        System.out.println();

        // 测试3 测试存在包含大量相同元素的数组。【在我的环境下(Mac Oracle JDK 1.8)1000000的数据规模会造成栈溢出异常java.lang.StackOverflowError，为了方便测试可以将数据规模改为300000。】
        // 但此时, 对于含有大量相同元素的数组, 我们的快速排序算法再次退化成了O(n^2)级别的算法
        // 思考一下为什么在这种情况下, 快排退化成了O(n^2)的算法? :)
        // System.out.println("Test for random array, size = " + N + " , random range [0,10]");
        //
        // arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        // arr2 = Arrays.copyOf(arr1, arr1.length);
        //
        // SortTestHelper.testSort(MergeSort.class.getName(), arr1);
        // SortTestHelper.testSort(QuickSort.class.getName(), arr2);
    }
}
