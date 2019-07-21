import java.util.Currency;
import java.util.LinkedList;
import java.util.Queue;

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

        public Node(Node node){
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
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
     * 查看二分搜索树中是否存在键key
     *
     * @param key
     * @return
     */
    public boolean contain(K key) {
        return contain(root, key);
    }

    /**
     * 在二分搜索树中搜索键key所对应的值。如果这个值不存在，则返回null
     *
     * @param key
     * @return
     */
    public V search(K key) {
        return search(root, key);
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 二分搜索树的层序遍历
     */
    public void levelOrder() {

        Queue<Node> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()) {

            Node node = q.poll();

            System.out.println(node.key);

            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
    }

    /**
     * 寻找二分搜索树的最小的键值
     */
    public K minimum() {
        assert count != 0;
        Node minNode = minimum(root);
        return minNode.key;
    }

    /**
     * 寻找二分搜索树的最大的键值
     */
    public K maximum() {
        assert count != 0;
        Node maxNode = maximum(root);
        return maxNode.key;
    }

    /**
     * 从二分搜索树中删除最小值所在节点
     */
    public void removeMin() {

        if (root != null) {
            root = removeMin(root);
        }
    }

    /**
     * 从二分搜索树中删除最小值所在节点
     */
    public void removeMax() {

        if (root != null) {
            root = removeMax(root);
        }
    }

    /**
     * 从二分搜索树中删除键值为key的节点
     *
     * @param key
     */
    public void remove(K key) {
        root = remove(root, key);
    }

    /**
     * 返回以node为根的二分搜索树的最小键值所在的节点
     *
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    /**
     * 返回以node为根的二分搜索树的最大键值所在的节点
     *
     * @param node
     * @return
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            count--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最大节点
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMax(Node node) {

        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            count--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除掉以node为根的二分搜索树中键值为key的节点, 递归算法
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     */
    private Node remove(Node node, K key) {

        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else { // key.compareTo(node.key) == 0

            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                count--;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                count--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = new Node(minimum(node.right));
            count++;

            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            count--;

            return successor;
        }
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
            node.left = insert(node.left, key, value);
        } else { // key > node->key
            node.right = insert(node.right, key, value);
        }

        return node;
    }

    /**
     * 查看以node为根的二分搜索树中是否包含键值为key的节点, 使用递归算法
     *
     * @param node
     * @param key
     */
    private boolean contain(Node node, K key) {

        if (node == null) {
            return false;
        }

        if (key.compareTo(node.key) == 0) {
            return true;
        } else if (key.compareTo(node.key) < 0) {
            return contain(node.left, key);
        } else { // key > node->key
            return contain(node.right, key);
        }
    }

    /**
     * 在以node为根的二分搜索树中查找key所对应的value, 递归算法
     * 若value不存在, 则返回NULL
     *
     * @param node
     * @param key
     * @return
     */
    private V search(Node node, K key) {

        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node.value;
        } else if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        } else { // key > node->key
            return search(node.right, key);
        }
    }

    /**
     * 对以node为根的二叉搜索树进行前序遍历, 递归算法
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 对以node为根的二叉搜索树进行中序遍历, 递归算法
     *
     * @param node
     */
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    /**
     * @param node
     */
    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }

    /**
     * 测试二分搜索树
     *
     * @param args
     */
    public static void main(String[] args) {

        int N = 1000000;

        // 创建一个数组，包含[0...N]的所有元素
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }

        // 打乱数组顺序
        for (int i = 0; i < N; i++) {
            int pos = (int) (Math.random() * (i + 1));
            Integer t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }

        // 由于我们实现的二分搜索树不是平衡二叉树，
        // 所以如果按照顺序插入一组数据，我们的二分搜索树会退化成为一个链表
        // 平衡二叉树的实现，我们在这个课程中没有涉及，
        // 有兴趣的同学可以查看资料自学诸如红黑树的实现
        // 以后有机会，我会在别的课程里向大家介绍平衡二叉树的实现的：）

        // 我们测试用的的二分搜索树的键类型为Integer，值类型为String
        // 键值的对应关系为每个整型对应代表这个整型的字符串
        BST<Integer, String> bst = new BST<>();
        for (int i = 0; i < N; i++) {
            bst.insert(arr[i], Integer.toString(arr[i]));
        }

        // 对[0...2*N)的所有整型测试在二分搜索树中查找
        // 若i在[0...N)之间，则能查找到整型所对应的字符串
        // 若i在[N...2*N)之间，则结果为null
        for (int i = 0; i < 2 * N; i++) {
            String res = bst.search(i);
            if (i < N) {
                assert res.equals(Integer.toString(i));
            } else {
                assert res == null;
            }
        }
    }
}
