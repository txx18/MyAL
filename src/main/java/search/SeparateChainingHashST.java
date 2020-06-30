package search;

/**
 * @author Shane Tang
 * @create 2020-06-29 10:50
 */
public class SeparateChainingHashST<Key, Value> extends SimpleST<Key, Value> {
    /**
     * 键值对总数
     */
    private int N;
    /**
     * 散列表的大小（有多少条链表）
     */
    private int M;
    /**
     * 底层是顺序查找符号表（底层链表）的数组
     */
    private SequentialSearchST<Key, Value>[] st;

    /**
     * 初始化M条链表
     * @param M
     */
    public SeparateChainingHashST(int M) {
        this.M = M;
        // 初始化链表数组
        this.st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M]; // Java不允许泛型数组，所以要进行类型转换
        // 别忘了对每个链表初始化
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<>();
        }
    }

    /**
     * 计算hashcode
     * @param key
     * @return
     */
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    @Override
    public void put(Key key, Value val) {
        // （除留余数法）计算索引
        int index = hash(key);
        // put进相应索引的SqST
        st[index].put(key, val);
    }

    @Override
    public Value get(Key key) {
        // （除留余数法）计算索引
        int index = hash(key);
        return (Value) st[index].get(key);
    }

    @Override
    int size() {
        return 0;
    }

    @Override
    Iterable<Key> keys() {
        return null;
    }

}
