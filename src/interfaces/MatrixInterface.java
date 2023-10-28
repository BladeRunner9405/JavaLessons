package interfaces;

public interface MatrixInterface<T> {
    void add(T el);
    void del(int cId, int rId);
    T get(int cId, int rId);
}
