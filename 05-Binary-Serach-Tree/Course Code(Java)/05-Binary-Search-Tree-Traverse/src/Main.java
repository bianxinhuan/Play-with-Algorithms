/**
 * -
 *
 * @author bianxinhuan
 * @date 2019-07-17 21:54:52
 */
public class Main {

    /**
     * 测试二分搜索树的前中后序遍历
     *
     * @param args
     */
    public static void main(String[] args) {

        BST<Integer, Integer> bst = new BST<Integer, Integer>();

        // 取n个取值范围在[0...m)的随机整数放进二分搜索树中
        int N = 10;
        int M = 100;
        for (int i = 0; i < N; i++) {
            Integer key = (int) (Math.random() * M);
            // 为了后续测试方便,这里value值取和key值一样
            bst.insert(key, key);
            System.out.print(key + " ");
        }
        System.out.println();

        // 测试二分搜索树的size()
        System.out.println("size: " + bst.size());
        System.out.println();

        // 测试二分搜索树的前序遍历 preOrder
        System.out.println("preOrder: ");
        bst.preOrder();
        System.out.println();

        // 测试二分搜索树的中序遍历 inOrder
        System.out.println("inOrder: ");
        bst.inOrder();
        System.out.println();

        // 测试二分搜索树的后序遍历 postOrder
        System.out.println("postOrder: ");
        bst.postOrder();
        System.out.println();
    }
}
