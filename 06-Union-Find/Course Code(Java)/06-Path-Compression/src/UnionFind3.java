/**
 * 我们的第三版Union-Find
 *
 * @author bianxinhuan
 * @date 2019-07-23 19:32:49
 */
public class UnionFind3 {

    /**
     * 我们的第二版Union-Find, 使用一个数组构建一棵指向父节点的树
     * parent[i]表示第一个元素所指向的父节点
     */
    private int[] parent;
    /**
     * sz[i]表示以i为根的集合中元素个数
     */
    private int[] sz;
    private int count;

    public UnionFind3(int count) {
        this.count = count;
        this.parent = new int[count];
        this.sz = new int[count];

        // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    /**
     * 查找过程, 查找元素p所对应的集合编号
     * O(h)复杂度, h为树的高度
     *
     * @param p
     * @return
     */
    public int find(int p) {

        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    /**
     * 查看元素p和元素q是否所属一个集合
     * O(h)复杂度, h为树的高度
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
     * O(h)复杂度, h为树的高度
     *
     * @param p
     * @param q
     */
    public void unionElements(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        // 根据两个元素所在树的元素个数不同判断合并方向
        // 将元素个数少的集合合并到元素个数多的集合上
        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
}
