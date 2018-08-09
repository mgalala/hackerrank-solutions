import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class LinkedListHasCycle {

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

	static boolean hasCycle(DoublyLinkedListNode head) {
		boolean lastNode = false;
		Set<DoublyLinkedListNode> visited = new HashSet<>();

		DoublyLinkedListNode nodeToCheck = head;
		while (!lastNode) {
			if (nodeToCheck.next == null) {
				lastNode = true;
			} else {
				if (visited.contains(nodeToCheck)) {
					return true;
				}
				visited.add(nodeToCheck);

				nodeToCheck = nodeToCheck.next;
			}

		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		DoublyLinkedList llist = new DoublyLinkedList();

		llist.insertNode(1);
		llist.insertNode(2);
		DoublyLinkedListNode node3 = new DoublyLinkedListNode(3);
		llist.insertNode(node3);
		llist.insertNode(4);
		DoublyLinkedListNode node5 = new DoublyLinkedListNode(5);
		node5.next = node3;
		llist.insertNode(node5);

		System.out.println(hasCycle(llist.head));
	}

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

		public void insertNode(DoublyLinkedListNode node) {
			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
				node.prev = this.tail;
			}

			this.tail = node;
		}
	}
}