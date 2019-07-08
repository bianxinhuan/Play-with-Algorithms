import org.omg.CORBA.Object;

/**
 * -
 *
 * @author bianxinhuan
 * @date 2019-07-08 20:47:20
 */
public class MaxHeap<E> {

    private E[] data;
    private int count;

    /**
     * 构造一个空堆，可容纳capacity个元素
     *
     * @param capacity
     */
    public MaxHeap(int capacity) {
        // 由于我们的索引是从1开始的（0的位置留空），所以capacity需要+1
        this.data = (E[]) new Object[capacity + 1];
        this.count = 0;
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
     * 测试MaxHeap
     *
     * @param args
     */
    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);
        System.out.println(maxHeap.size());
    }
}
