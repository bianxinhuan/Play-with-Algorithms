import java.util.Arrays;

/**
 * -
 *
 * @author bianxinhuan
 * @date 2019-06-28 22:08:27
 */
public class Main {

    /**
     * 比较Merge Sort和Merge Sort Bottom Up两种排序算法的性能效率
     * 整体而言, 两种算法的效率是差不多的。但是如果进行仔细测试, 自底向上的归并排序会略胜一筹。
     * 更详细的测试, 可以参考课程的这个问题: http://coding.imooc.com/learn/questiondetail/3208.html
     * 本章节的代码仓也会给出更详细的测试代码
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
        SortTestHelper.testSort(MergeSortBU.class.getName(), arr2);

        System.out.println();

        // 测试2 测试近乎有序的数组
        int swapTimes = 10;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort(MergeSort.class.getName(), arr1);
        SortTestHelper.testSort(MergeSortBU.class.getName(), arr2);
    }
}
