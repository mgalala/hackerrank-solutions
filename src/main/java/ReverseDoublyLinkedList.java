import java.io.BufferedWriter;
import java.io.IOException;

public class ReverseDoublyLinkedList {

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
	static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
		if (head.next == null) {
			return head;
		} else {
			head.prev = head.next;
			head.next = null;
		}
		boolean lastNode = false;
		DoublyLinkedListNode nodeToCheck = head.prev;
		DoublyLinkedListNode tailNode = null;
		while (!lastNode) {
			if (nodeToCheck.next == null) {
				lastNode = true;
				nodeToCheck.next = nodeToCheck.prev;
				nodeToCheck.prev = null;
				tailNode = nodeToCheck;
			} else {
				DoublyLinkedListNode oldNext = nodeToCheck.next;
				nodeToCheck.next = nodeToCheck.prev;
				nodeToCheck.prev = oldNext;
				nodeToCheck = oldNext;
			}

		}
		return tailNode;
	}

	public static void main(String[] args) throws IOException {
		DoublyLinkedList llist = new DoublyLinkedList();

		int total = 20;
		for (int i = 0; i < total; i++) {
			llist.insertNode(i);
		}

		DoublyLinkedListNode llist1 = reverse(llist.head);
		DoublyLinkedListNode nextNode = llist1;
		int i = 0;
		while (i < total) {
			System.out.println(nextNode.data);
			nextNode = nextNode.next;
			i++;
		}
	}
}