/**
 * -
 *
 * @author bianxinhuan
 * @date 2019-06-25 16:59:48
 */
public class Student implements Comparable<Student> {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * 定义Student的compareTo函数
     * 如果分数相等，则按照名字的字母序排序
     * 如果分数不等，则分数高的靠前
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Student o) {
        if (this.score < o.score) {
            return -1;
        } else if (this.score > o.score) {
            return 1;
        } else { // this.score == that.score
            return this.name.compareTo(o.name);
        }
    }

    @Override
    public String toString() {
        return "Student: " + this.name + " " + this.score;
    }
}
