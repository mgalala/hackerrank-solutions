import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindMergePoint {

	/**
	 * 
	 * @param head1
	 * @param head2
	 * @return
	 */
	static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		List<Integer> list1Values = new ArrayList<Integer>();

		boolean lastNode = false;
		SinglyLinkedListNode nodeToCheck = head1;
		while (!lastNode) {
			if (nodeToCheck.next == null) {
				list1Values.add(nodeToCheck.data);
				lastNode = true;
			} else {
				list1Values.add(nodeToCheck.data);
				nodeToCheck = nodeToCheck.next;
			}
		}

		// int firstMatch = 0;
		// int matchedIndex = 0;

		SinglyLinkedListNode nodeToCheckInList2 = head2.next;
		boolean lastNodeInList2 = false;
		List<Integer> list2Values = new ArrayList<Integer>();
		while (!lastNodeInList2) {
			if (nodeToCheckInList2.next == null) {
				list2Values.add(nodeToCheckInList2.data);
				lastNodeInList2 = true;
			} else {
				list2Values.add(nodeToCheckInList2.data);
				nodeToCheckInList2 = nodeToCheckInList2.next;
			}
		}

		Collections.reverse(list1Values);
		Collections.reverse(list2Values);

		int lastMatch = 0;
		if (list1Values.size() > list2Values.size()) {
			for (int i = 0; i < list2Values.size(); i++) {
				if (list1Values.get(i) == list2Values.get(i)) {
					lastMatch = i;
				} else {
					break;
				}
			}
			return list1Values.get(lastMatch);
		} else if (list1Values.size() < list2Values.size()) {
			for (int i = 0; i < list1Values.size(); i++) {
				if (list2Values.get(i) == list1Values.get(i)) {
					lastMatch = i;
				} else {
					break;
				}
			}
			return list2Values.get(lastMatch);
		}
		return list1Values.get(0);
	}

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
			throws IOException {
		while (node != null) {
			bufferedWriter.write(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				bufferedWriter.write(sep);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		InputStream is = NewYearChaos.class.getClassLoader().getResourceAsStream("merge_point.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		final Scanner scanner = new Scanner(br);

		int tests = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int testsItr = 0; testsItr < tests; testsItr++) {
			int index = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			SinglyLinkedList llist1 = new SinglyLinkedList();

			int llist1Count = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llist1Count; i++) {
				int llist1Item = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist1.insertNode(llist1Item);
			}

			SinglyLinkedList llist2 = new SinglyLinkedList();

			int llist2Count = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llist2Count; i++) {
				int llist2Item = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist2.insertNode(llist2Item);
			}

			SinglyLinkedListNode ptr1 = llist1.head;
			SinglyLinkedListNode ptr2 = llist2.head;

			for (int i = 0; i < llist1Count; i++) {
				if (i < index) {
					ptr1 = ptr1.next;
				}
			}

			for (int i = 0; i < llist2Count; i++) {
				if (i != llist2Count - 1) {
					ptr2 = ptr2.next;
				}
			}

			ptr2.next = ptr1;

			int result = findMergeNode(llist1.head, llist2.head);
			System.out.println(result);
		}

		scanner.close();
	}
}
