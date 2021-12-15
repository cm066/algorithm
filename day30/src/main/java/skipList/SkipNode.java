package skipList;

/**
 * @author Administrator
 */
public class SkipNode<T> {
    int key;
    T value;
    //右下个方向的指针
    SkipNode right,down;
    public SkipNode (int key,T value) {
        this.key=key;
        this.value=value;
    }
}
