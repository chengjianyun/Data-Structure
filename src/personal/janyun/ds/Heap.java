package personal.janyun.ds;

public interface Heap<E> {
	public int getSize();
	public void heapfiy(int i);
	public E pop();
	public E peek();
	public void build();
	public E delete(int index);
	public void insert(E value);
}