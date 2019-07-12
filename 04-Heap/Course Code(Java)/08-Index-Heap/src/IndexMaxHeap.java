import java.util.Arrays;

/**
 * 最大索引堆
 *
 * @author bianxinhuan
 * @date 2019-07-12 21:24:46
 */
public class IndexMaxHeap<E extends Comparable> {

    /**
     * 最大索引堆中的数据
     */
    protected E[] data;

    /**
     * 最大索引堆中的索引
     */
    protected int[] indexes;
    protected int count;
    protected int capacity;

    /**
     * 构造一个空堆，可容纳capacity个元素
     *
     * @param capacity
     */
    public IndexMaxHeap(int capacity) {
        this.data = (E[]) new Comparable[capacity + 1];
        this.indexes = new int[capacity + 1];
        this.count = 0;
        this.capacity = capacity;
    }

    /**
     * 返回索引堆中的元素的个数
     *
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 返回一个布尔值，表示索引堆中是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 向最大索引堆中插入一个新元素，新元素的索引为i，元素为item
     *
     * @param i
     * @param e
     */
    public void insert(int i, E e) {

        assert count + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;

        // 内部索引是从1开始，对于使用者来说是从0开始的
        i += 1;
        data[i] = e;
        indexes[count + 1] = i;
        count++;

        shiftUp(count);
    }

    /**
     * 从最大索引堆中取出堆顶元素，即索引堆中所存储的最大数据
     *
     * @return
     */
    public E extractMax() {
        assert count > 0;

        E ret = data[indexes[1]];
        swapIndexes(1, count);
        count--;
        shiftDown(1);

        return ret;
    }

    /**
     * 从最大索引堆中取出堆顶元素的索引
     *
     * @return
     */
    public int extractMaxIndex() {
        assert count > 0;

        int ret = indexes[1] - 1;
        swapIndexes(1, count);
        count--;
        shiftDown(1);

        return ret;
    }

    /**
     * 获取最大索引堆中的堆顶元素
     *
     * @return
     */
    public E getMax() {
        assert count > 0;
        return data[indexes[1]];
    }

    /**
     * 获取最大索引堆中的堆顶元素的索引
     *
     * @return
     */
    public int getMaxIndex() {
        assert count > 0;
        return indexes[1] - 1;
    }

    /**
     * 获取最大索引堆中索引为i的元素
     *
     * @param i
     * @return
     */
    public E getItem(int i) {
        assert i + 1 >= 1 && i + 1 <= capacity;
        return data[i + 1];
    }

    /**
     * 将最大索引堆中索引为i的元素修改为newItem
     *
     * @param i
     * @param newItem
     */
    public void change(int i, E newItem) {

        i += 1;

        data[i] = newItem;

        // 找到indexes[j] = i，j表示data[i]在堆中的位置
        // 之后shiftUp(j)，再shiftDown
        for (int j = 1; j <= count; j++) {
            if (indexes[j] == i) {
                shiftUp(j);
                shiftDown(j);
            }
        }
    }

    /**
     * 交换索引堆中的元素i和j
     *
     * @param i
     * @param j
     */
    private void swapIndexes(int i, int j) {
        int t = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = t;
    }

    /**
     * 索引堆中，数据之间的比较根据data的大小进行比较，但实际操作的是索引
     *
     * @param k
     */
    private void shiftUp(int k) {

        while (k > 1 && data[indexes[k]].compareTo(data[indexes[k / 2]]) > 0) {
            swapIndexes(k, k / 2);
            k /= 2;
        }
    }

    /**
     * 索引堆中，数据之间的比较根据data的大小进行比较，但实际操作的是索引
     *
     * @param k
     */
    private void shiftDown(int k) {

        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[indexes[j + 1]].compareTo(data[indexes[j]]) > 0) {
                j++;
            }

            if (data[indexes[k]].compareTo(data[indexes[j]]) >= 0) {
                break;
            }

            swapIndexes(k, j);
            k = j;
        }
    }

    /**
     * 测试索引堆中的索引数组index
     * 注意:这个测试在向堆中插入元素以后, 不进行extract操作有效
     *
     * @return
     */
    public boolean testIndexes() {
        int[] copyIndexes = new int[count + 1];

        for (int i = 0; i <= count; i++) {
            copyIndexes[i] = indexes[i];
        }

        copyIndexes[0] = 0;
        Arrays.sort(copyIndexes);

        // 在对索引堆中的索引进行排序后, 应该正好是1...count这count个索引
        boolean res = true;
        for (int i = 1; i <= count; i++) {
            if (copyIndexes[i - 1] + 1 != copyIndexes[i]) {
                res = false;
                break;
            }
        }

        if (!res) {
            System.out.println("Error!");
            return false;
        }

        return true;
    }

    /**
     * 测试 IndexMaxHeap
     *
     * @param args
     */
    public static void main(String[] args) {

        int N = 1000000;
        IndexMaxHeap<Integer> indexMaxHeap = new IndexMaxHeap<Integer>(N);
        for (int i = 0; i < N; i++) {
            indexMaxHeap.insert(i, (int) (Math.random() * N));
        }
        assert indexMaxHeap.testIndexes();
    }
}
