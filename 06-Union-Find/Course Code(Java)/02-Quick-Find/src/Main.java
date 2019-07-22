/**
 * -
 *
 * @author bianxinhuan
 * @date 2019-07-22 20:25:26
 */
public class Main {

    /**
     * 测试UnionFind1
     *
     * @param args
     */
    public static void main(String[] args) {
        // 使用10000的数据规模
        int n = 10000;

        // 虽然isConnected只需要O(1)的时间, 但由于union操作需要O(n)的时间
        // 总体测试过程的算法复杂度是O(n^2)的
        UnionFindTestHelper.testUF1(n);
    }
}
