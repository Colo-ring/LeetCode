package Common;

/**
 * @author IntelliYJC
 * @create 2022/4/14 20:06
 *
 * 仿照C++ pair
 */
public class Pair<T, E> {
    private T a;
    private E b;

    public Pair(){}

    public Pair(T a, E b) {
        this.a = a;
        this.b = b;
    }

    public T first() {return a;}
    public E second() {return b;}
    public void setFirst(T a) {this.a  = a;}
    public void setSecond(E b) {this.b  = b;}

    // 扩展欧几里得用到
    public void swap() {
        T tem = a;
        a = (T)b;
        b = (E)tem;
    }
}
