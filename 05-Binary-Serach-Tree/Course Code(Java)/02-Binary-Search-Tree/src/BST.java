/**
 * 二分搜索树
 * 由于Key需要能够进行比较，所以需要extends Comparable<Key>
 *
 * @author bianxinhuan
 * @date 2019-07-15 21:34:52
 */
public class BST<K extends Comparable<K>, V> {

    /**
     * 树中的节点为私有的类，外界不需要了解二分搜索树节点的具体实现
     */
    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    /**
     * 根节点
     */
    private Node root;

    /**
     * 树中的节点个数
     */
    private int count;

    /**
     * 默认构造一棵空二分搜索树
     */
    public BST() {
        root = null;
        count = 0;
    }

    /**
     * 返回二分搜索树的节点个数
     *
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 返回二分搜索树是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

    public static void main(String[] args) {

    }
}
