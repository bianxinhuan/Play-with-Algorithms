/**
 * 我们的第一版Union-Find
 *
 * @author bianxinhuan
 * @date 2019-07-22 20:16:10
 */
public class UnionFind1 {

    /**
     * 我们的第一版Union-Find本质就是一个数组
     */
    private int[] id;

    /**
     * 数据个数
     */
    private int count;

    public UnionFind1(int n) {
        this.count = n;
        this.id = new int[n];

        // 初始化, 每一个id[i]指向自己, 没有合并的元素
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    /**
     * 查找过程, 查找元素p所对应的集合编号
     * O(1)复杂度
     *
     * @param p
     * @return
     */
    public int find(int p) {
        assert p >= 0 && p < count;
        return id[p];
    }

    /**
     * 查看元素p和元素q是否所属一个集合
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p和元素q所属的集合
     * O(n) 复杂度
     *
     * @param p
     * @param q
     */
    public void unionElements(int p, int q) {

        int pID = find(p);
        int qID = find(q);

        // 已经处于一个集合
        if (pID == qID) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }
}
