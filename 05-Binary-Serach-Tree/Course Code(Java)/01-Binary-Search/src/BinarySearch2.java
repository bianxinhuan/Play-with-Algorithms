import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * 递归的二分查找算法
 *
 * @author bianxinhuan
 * @date 2019-07-15 21:16:06
 */
public class BinarySearch2 {

    /**
     * 我们的算法灯不允许产生任何实例
     */
    private BinarySearch2() {
    }

    private static int find(Comparable[] arr, int l, int r, Comparable target) {

        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;
        if (arr[mid].compareTo(target) == 0) {
            return mid;
        }

        if (arr[mid].compareTo(target) > 0) {
            r = mid - 1;
            return find(arr, l, r, target);
        } else {
            l = mid + 1;
            return find(arr, l, r, target);
        }
    }

    /**
     * 二分查找法，在有序数组arr中，查找target
     * 如果找到target，返回相应的索引index
     * 如果没有找到target，返回-1
     *
     * @param arr
     * @param target
     * @return
     */
    public static int find(Comparable[] arr, Comparable target) {
        return find(arr, 0, arr.length - 1, target);
    }

    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }

        // 对于我们的待查找数组[0...N)
        // 对[0...N)区间的数值使用二分查找，最终结果应该就是数字本身
        // 对[N...2*N)区间的数值使用二分查找，因为这些数字不在arr中，结果为-1
        for (int i = 0; i < 2 * N; i++) {
            int v = BinarySearch2.find(arr, i);
            if (i < N) {
                assert v == i;
            } else {
                assert v == -1;
            }
        }
    }
}
