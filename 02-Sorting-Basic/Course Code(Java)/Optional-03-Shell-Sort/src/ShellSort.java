/**
 * -
 *
 * @author bianxinhuan
 * @date 2019-06-30 18:05:42
 */
public class ShellSort {

    /**
     * 我们的算法类不允许产生任何实例
     */
    private ShellSort() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;

        // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        int h = 1;
        while (h < n / 2) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) {

                Comparable e = arr[i];
                int j = i;
                for (; j >= h && e.compareTo(arr[j - h]) < 0; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = e;
            }
            h /= 3;
        }
    }
}
