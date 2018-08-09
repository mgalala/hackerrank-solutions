import java.io.BufferedWriter;
import java.io.IOException;

public class InsertInSortedDoublyLinkedList {

	static class DoublyLinkedListNode {
		public int data;
		public DoublyLinkedListNode next;
		public DoublyLinkedListNode prev;

		public DoublyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
			this.prev = null;
		}
	}

	static class DoublyLinkedList {
		public DoublyLinkedListNode head;
		public DoublyLinkedListNode tail;

		public DoublyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
				node.prev = this.tail;
			}

			this.tail = node;
		}
	}

	public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
			throws IOException {
		while (node != null) {
			bufferedWriter.write(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				bufferedWriter.write(sep);
			}
		}
	}

	// Complete the sortedInsert function below.

	/*
	 * For your reference:
	 *
	 * DoublyLinkedListNode { int data; DoublyLinkedListNode next;
	 * DoublyLinkedListNode prev; }
	 *
	 */
	static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
		DoublyLinkedListNode node = null;
		if (data <= head.data) {
			node = new DoublyLinkedListNode(data);
			node.next = head;
			node.prev = null;
			head.prev = node;
			return node;
		} else {
			boolean lastNode = false;
			DoublyLinkedListNode nodeToCheck = head;
			while (!lastNode) {
				if (nodeToCheck.next == null) {
					lastNode = true;
					node = new DoublyLinkedListNode(data);
					node.next = null;
					node.prev = nodeToCheck;
					nodeToCheck.next = node;
				} else {
					nodeToCheck = nodeToCheck.next;
					if (data <= nodeToCheck.data) {
						DoublyLinkedListNode prev = nodeToCheck.prev;
						node = new DoublyLinkedListNode(data);
						node.next = nodeToCheck;
						node.prev = nodeToCheck.prev;
						nodeToCheck.prev = node;
						prev.next = node;
						lastNode = true;
					}
				}

			}
		}

		return head;
	}

	public static void main(String[] args) throws IOException {
		DoublyLinkedList llist = new DoublyLinkedList();

		llist.insertNode(1);
		llist.insertNode(2);
		llist.insertNode(3);
		// llist.insertNode(10);

		DoublyLinkedListNode llist1 = sortedInsert(llist.head, 4);
		DoublyLinkedListNode nextNode = llist1;
		int i = 0;
		while (i < 4) {
			System.out.println(nextNode.data);
			nextNode = nextNode.next;
			i++;
		}
	}
}