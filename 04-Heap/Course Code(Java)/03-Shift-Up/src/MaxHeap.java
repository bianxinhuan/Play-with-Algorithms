/**
 * 在堆的有关操作中，需要比较堆中元素的大小，所以E需要extends Comparable
 *
 * @author bianxinhuan
 * @date 2019-07-09 20:47:20
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
     * 测试MaxHeap
     *
     * @param args
     */
    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);

        // 堆中元素个数
        int N = 50;
        // 堆中元素取值范围[0,M]
        int M = 100;

        for (int i = 0; i < N; i++) {
            maxHeap.insert((int) (Math.random() * M));
        }

        System.out.println(maxHeap.size());
    }
}
