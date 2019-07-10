/**
 * 在堆的有关操作中，需要比较堆中元素的大小，所以E需要extends Comparable
 *
 * @author bianxinhuan
 * @date 2019-07-10 21:04:20
 */
public class MaxHeap<E extends Comparable> {

    protected E[] data;
    protected int count;
    protected int capacity;

    /**
     * 构造一个空堆，可容纳capacity个元素
     *
     * @param capacity
     */
    public MaxHeap(int capacity) {
        // 由于我们的索引是从1开始的（0的位置留空），所以capacity需要+1
        this.data = (E[]) new Comparable[capacity + 1];
        this.count = 0;
        this.capacity = capacity;
    }

    /**
     * 返回堆中的元素个数
     *
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 返回一个布尔值，表示堆中是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 向最大堆中插入一个新的元素 e
     *
     * @param e
     */
    public void insert(E e) {

        assert count + 1 <= capacity;

        data[count + 1] = e;

        count++;

        shiftUp(count);
    }

    /**
     * 从最大堆中取出堆顶元素，即堆中所存储的最大元素
     *
     * @return
     */
    public E extractMax() {

        assert count > 0;

        E ret = data[1];

        swap(1, count);

        count--;

        // 元素下沉
        shiftDown(1);

        return ret;
    }

    /**
     * 获取最大堆中的堆顶元素
     *
     * @return
     */
    public E getMax() {
        assert count > 0;
        return data[1];
    }

    /**
     * 交换堆中索引为i和j的两个元素
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        E e = data[i];
        data[i] = data[j];
        data[j] = e;
    }

    /**
     * ********************
     * * 最大堆核心辅助函数
     * ********************
     *
     * @param k
     */
    private void shiftUp(int k) {

        // 如果元素小于它的父亲节点，则交换位置，继续向上比较
        while (k > 1 && data[k].compareTo(data[k / 2]) > 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    /**
     * 元素下沉
     *
     * @param k
     */
    private void shiftDown(int k) {

        while (2 * k <= count) {
            // 在此轮循环中，data[k]和data[j]交换位置（元素k下沉）
            // j表示k的子节点中的最大的那个
            int j = 2 * k;
            // 如果k有2个子节点，并且右孩子比左孩子大，则j表示右孩子节点
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0) {
                j++;
            }

            // 如果当前元素大于它的孩子节点，则不需要下沉
            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }

            // 下沉：把k和它的孩子节点交换
            swap(k, j);

            k = j;
        }
    }

    /**
     * 测试MaxHeap
     *
     * @param args
     */
    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);

        // 堆中元素个数
        int N = 100;
        // 堆中元素取值范围[0,M]
        int M = 100;

        for (int i = 0; i < N; i++) {
            maxHeap.insert((int) (Math.random() * M));
        }

        Integer[] arr = new Integer[N];

        // 将maxheap中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for (int i = 0; i < N; i++) {
            arr[i] = maxHeap.extractMax();
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        // 确保arr数组是从大到小排列的
        for (int i = 0; i < N; i++) {
            assert arr[i - 1] >= arr[i];
        }
    }
}
