/**
 * 二分搜索树
 * 由于Key需要能够进行比较，所以需要extends Comparable<Key>
 *
 * @author bianxinhuan
 * @date 2019-07-16 21:34:52
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

    /**
     * 向二分搜索树中插入一个新的（Key,Value）数据对
     *
     * @param key
     * @param value
     */
    public void insert(K key, V value) {
        root = insert(root, key, value);
    }

    /**
     * ********************
     * * 二分搜索树的辅助函数
     * ********************
     * 向以node为根的二分搜索树中插入节点（Key,Value），使用递归算法
     * 返回插入新节点后的二分搜索树的根
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node insert(Node node, K key, V value) {

        if (node == null) {
            count++;
            node = new Node(key, value);
        }

        if (key.compareTo(node.key) == 0) {
            node.value = value;
        } else if (key.compareTo(node.key) < 0) {
            node = insert(node.left, key, value);
        } else { // key > node->key
            node = insert(node.right, key, value);
        }

        return node;
    }

    public static void main(String[] args) {
    }
}
