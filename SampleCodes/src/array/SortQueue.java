package array;

import java.util.ArrayDeque;
import java.util.Queue;

public class SortQueue {
	Queue<Integer> original;
	Queue<Integer> temp;

	public SortQueue(ArrayDeque<Integer> a) {
		this.original = a;
		temp = new ArrayDeque<Integer>(a.size());
	}

	public void sortQueue() {
		
	}
}
