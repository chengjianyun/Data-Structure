package personal.janyun.ds;

public class ArrayHeap implements Heap<Integer> {
	private Integer[] data;
	private int size;
	private int capacity;

	public ArrayHeap(int size) {
		this.capacity = size;
		data = new Integer[capacity];
	}

	public ArrayHeap(Integer[] data, int size) throws Exception {
		// TODO Auto-generated constructor stub
		if(data.length>size)
			throw new Exception("data capacity over flow the size");
		this.data = data;
		this.size = data.length;
		this.capacity = size;
	}

	/**
	 * ��ȡ��ǰ�ڵ����ӽڵ�λ��
	 * 
	 * @param i
	 * @return
	 */
	public int left(int i) {
		return 2 * i + 1;
	}

	/**
	 * ��ȡ��ǰ�ڵ��Һ��ӽڵ�λ��
	 * 
	 * @param i
	 * @return
	 */
	public int right(int i) {
		return 2 * i + 2;
	}

	/**
	 * ά���ѵ����ʣ��Ե�ǰ�ڵ�Ϊ���Ķѵ����ʣ����������ӶѶ��Ǵ����
	 * 
	 * @param i
	 */
	public void heapfiy(int i) {
		// TODO Auto-generated method stub
		int l = left(i);
		int r = right(i);
		int largest = 0;
		if (l < size && data[l] > data[i])
			largest = l;
		else
			largest = i;

		if (r < size && data[r] > data[largest])
			largest = r;
		if (largest != i) {
			Integer tmp = data[i];
			data[i] = data[largest];
			data[largest] = data[i];
			heapfiy(largest);
		}
	}

	/**
	 * ���ز�ɾ���Ѷ�Ԫ��
	 */
	public Integer pop() {
		// TODO Auto-generated method stub
		if (data.length > 0) {
			Integer t = data[0];
			delete(0);
			return t;
		}
		return null;
	}

	/**
	 * ���ضѶ�Ԫ��
	 */
	public Integer peek() {
		// TODO Auto-generated method stub
		if (data.length > 0)
			return data[0];
		return null;
	}

	/**
	 * ����һ����
	 */
	public void build() {
		// TODO Auto-generated method stub
		if (size < 1)
			return;
		for (int i = (size - 1) / 2 - 1; i >= 0; i--) {
			heapfiy(i);
		}
	}

	/**
	 * ����в���Ԫ��
	 */
	public void insert(Integer value) {
		// TODO Auto-generated method stub
		if (size < capacity && size > 0) {
			data[size] = data[0];
		}
		data[0] = value;
		heapfiy(0);
	}

	/**
	 * ɾ������ָ��λ�õ�Ԫ��
	 */
	public Integer delete(int index) {
		// TODO Auto-generated method stub
		if (index < 0 && index > size)
			return null;
		Integer value = data[index];
		if (index != size - 1) {
			data[index] = data[size - 1];
			heapfiy(index);
		}
		size--;
		return value;
	}

}
