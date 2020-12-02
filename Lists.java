package Assignment1;


// Lists interface
public interface Lists<T> {
	// creating functions for each list type (arraylist or linked list)
	T get(int index);
	boolean add(T value);
	int size();
}

// creating arraylist class that implements the Lists functions
class ArrayList<T> implements Lists<T> {
	T[] array;
	int size;

	
	public ArrayList() {
		array = (T[]) new Object[15];
		size = 0;
	}

	
	public int size() {
		return size;
	}

	
	public T get(int index) {
		if(index < 0 && index >= size) {
		System.out.println("Invalid index.");
	}
		
		return array[index];
	}

	
	public boolean add(T value) {
		if(size == array.length) {
			copyArray();
		}
			array[size] = value;
		size++;
		return true;
	}


	private void copyArray() {
		T[] new_array = (T[]) new Object[array.length * 2];
		
		for(int i = 0; i < array.length; i ++) {
			new_array[i] = array[i];
		}
		array = new_array;
	}
}


class LinkedList<T> implements Lists<T> {
	Node<T> head;
	int size;
	private class Node<T> {
		T data;
		Node<T> next, left, right;
		public Node(T value, Node<T> l, Node<T> r) {
			left = l;
			right = r;
			this.data = value;
		}
		public Node(T value) {
			this(value, null, null);
		}
	}

	public LinkedList() {
		head = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public T get(int index) {
		if(index < 0 && index >= size) {
			System.out.println("Invalid index.");
		}
		Node<T> curr = head;
		for(int i = 0; i < index; i++) {
			curr = curr.next;
		}
		return curr.data;
	}

	
	public boolean add(T value) {
		if(head == null) {
			head = new Node<>(value);
			size++;
			return true;
		}
		Node<T> prev = head;
		for(int i = 0; i < size - 1; i++) {
			prev = prev.next;
		}
		Node<T> temp = new Node<>(value);
		prev.next = temp;
		size++;
		return true;
	}
}