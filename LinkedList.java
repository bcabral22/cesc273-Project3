import java.util.Scanner;

public class LinkedList {
	private static class Node {
		/**
		 * this is a the circle
		 */
		private Contact data;
		/**
		 * this is the node
		 */
		private Node next;

		/**
		 * constructor
		 * 
		 * @param c passing in the circle
		 */
		public Node(Contact c) {
			data = c;
			next = null;
		}

		/**
		 * constructor
		 * 
		 * @param c this i pasing in the node
		 * @param n this is passing in the nodes
		 */
		public Node(Contact c, Node n) {
			data = c;
			next = n;
		}

		/*
		 * @Override public String toString( ) { return data; } this is not needed
		 */
	}

	/**
	 * parameter for the first node
	 */
	private Node first;
	/**
	 * parameter for the last node
	 */
	private Node last;

	/**
	 * constructor
	 */
	public LinkedList() {
		first = null;
		last = null;
	}

	/**
	 * size is the list
	 * 
	 * @return this returns the size of the list
	 */
	public int size() {
		int count = 0;
		Node n = first;
		while (n != null) {
			count++;
			n = n.next;
		}
		return count;
	}

	public Contact get(int i) {
		if (i < 0 || i >= size()) {
			System.out.println("Index out of bounds.");
			return new Contact(" ", " ", " ", " ", " ", " ");
		} else {
			Node n = first;
			for (int j = 1; j <= i; j++) {
				n = n.next;
			}
			return n.data;
		}
	}

	/**
	 * set this is geting the info
	 * 
	 * @param i passes in the integer
	 * @param c passes in the object
	 */
	public void set(int i, Contact c) {
		if (i < 0 || i >= size()) {
			System.out.println("Index out of bounds.");
		} else {
			Node n = first;
			for (int j = 1; j <= i; j++) {
				n = n.next;
			}
			n.data = c;
		}
	}

	/**
	 * isEmpty
	 * 
	 * @return this checks if it is empty
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * add this adds the node
	 * 
	 * @param c this passes in the object
	 */
	public void add(Contact c) {
		if (isEmpty()) {
			first = new Node(c);
			last = first;
		} else {
			Node n = new Node(c);
			last.next = n;
			last = n;
		}
	}

	/**
	 * remove this is removing a node
	 * 
	 * @param i iterate to the node
	 * @return rem this is reurning the nodes
	 */
	/*
	 * not the same as lab 8 public Contact remove(int i) { Contact rem = new
	 * Contact(" ", " ", " ", " "," "," " ); if (i < 0 || i >= size()) {
	 * System.out.println("Index out of bounds."); } else { if (i == 0) { rem =
	 * first.data; first = first.next; if (first == null) { last = null; } } else {
	 * Node n = first; for (int j = 1; j < i; j++) { n = n.next; } rem =
	 * n.next.data; n.next = n.next.next; if (n.next == null) { last = n; } } }
	 * return rem; }
	 */
	public Contact remove(int i) {
		Contact rem = new Contact(null, null, null, null, null, null);
		if (i == 0) {
			rem = first.data;
			first = first.next;
			if (first == null) {
				last = null;
			}
		} else {
			Node n = first;
			for (int j = 1; j < i; j++) {
				n = n.next;
			}
			rem = n.next.data;
			n.next = n.next.next;
			if (n.next == null) {
				last = n;
			}
		}
		return rem;
	}

	/**
	 * remove this is removing the node
	 * 
	 * @param c passing in the object
	 */
	public Contact remove(String firstName1, String lastName1) {
		Contact rem = new Contact(firstName1, lastName1, null, null, null, null);
		if (!isEmpty()) {
			if (rem.equals(first.data)) {
				rem = first.data;
				first = first.next;

				if (first == null) {
					last = null;
				}
			} else {
				Node n = first;
				while (n.next != null && !(rem.equals(n.next.data))) {
					n = n.next;
				}
				if (n.next == null) {
					System.out.println("Doesn't Exist");
				} else {
					rem = n.next.data;
					n.next = n.next.next;
					if (n.next == null) {
						last = n;
					}
				}
			}
		}
		return rem;

	}

	public int search(String firstName2, String lastName2) {
		int i=0;
		Contact ser = new Contact(firstName2,lastName2,null,null,null,null);
		if (!isEmpty()) {
			if (ser.equals(first.data)) {
				return i;
			}
			Node n = first;
			while (n.next != null &&! (ser.equals(n.next.data))) {
				n = n.next;	
				i=i+1;
					
				}
			if (n.next == null) {
				System.out.println("Name isn't here");
				return -1;
			}else {
				return i;
			}
		}
		return -1;
	}

	public LinkedList search(String lastName) {
		LinkedList lName = new LinkedList();
		if (lastName.equalsIgnoreCase(first.data.getlastName())) {
			lName.add(first.data);
		}
		Node n = first;
		while (n.next != null) {
			if (n.next.data.getlastName().equalsIgnoreCase(lastName)) {
				lName.add(n.next.data);
			}
			n = n.next;
		}

		return lName;
	}

	/**
	 * search for all contacts with the target zip code
	 * 
	 * @param zipCode target's zip code
	 * @return list of matches with the target zip
	 */
	public LinkedList search(int zipCode) {
		LinkedList zCode = new LinkedList();
		if (!isEmpty()) {
			if (zipCode == Integer.parseInt(first.data.getzipCode())) {
				zCode.add(first.data);
			}
			Node n = first;
			while (n.next != null) {
				if (Integer.parseInt(n.next.data.getzipCode()) == zipCode) {
					zCode.add(n.next.data);
				}
				n = n.next;
			}
		}
		return zCode;
	}

	/**
	 * sort the list to be in alphabetical order
	 */
	public void sort() {
		for (int current = 0; current < size(); current++) {
			int indexOfLowest = current;
			for (int next = current + 1; next < size(); next++) {
				if (get(indexOfLowest).compareTo(get(next)) > 0) {
					indexOfLowest = next;
				}
			}
			Contact swap = get(current);
			set(current, get(indexOfLowest));
			set(indexOfLowest, swap);
		}
	}
}
