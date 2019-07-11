/**
 * -
 *
 * @author bianxinhuan
 * @date 2019-07-11 21:21:26
 */
public class HeapSort2 {

    /**
     * 我们的算法类不允许产生任何实例
     */
    private HeapSort2() {
    }

    /**
     * 对整个arr数组使用HeapSort2排序
     * HeapSort2，借助我们的heapify过程创建堆
     * 此时，创建堆的过程时间复杂度为O(n)，将所有元素依次从堆中取出来，时间复杂度为O(nlogn)
     * 堆排序的总体时间复杂度依然是O(nlogn)，但是比HeapSort1性能更优，因为创建堆的性能更优
     *
     * @param arr
     */
    public static void sort(Comparable[] arr) {

        int n = arr.length;

        MaxHeap<Comparable> maxHeap = new MaxHeap<>(arr);

        // 由于每次取出的是最大元素，所以从后往前给数组赋值
        for (int i = n - 1; i >= 1; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    /**
     * 测试 HeapSort2
     * @param args
     */
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort(HeapSort2.class.getName(), arr);
    }
}
