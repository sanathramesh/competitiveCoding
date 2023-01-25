import java.util.*;

class MaxHeap {
	int[] data;
	int maxSize;
	int size;

	public static final int front = 1;

	public MaxHeap(int maxSize){
		this.maxSize = maxSize;
		this.data = new int[maxSize+1];
		this.size = 0;
		this.data[0] = Integer.MIN_VALUE;
	}

	private int parent(int pos) {
		return pos/2;
	}

	private int leftChild(int pos) {
		return pos*2;
	}

	private int rightChild(int pos) {
		return pos*2 + 1;
	}

	private boolean isLeaf(int pos) {
		if(pos>=this.size/2) {
			return true;
		} else {
			return false;
		}
	}

	private void swap(int pos1 , int pos2) {
		int temp = this.data[pos1];
		this.data[pos1] = this.data[pos2];
		this.data[pos2] = temp;
	}

	private void heapify(int pos) {
		if(!isLeaf(pos)) {
			int current;
			if(rightChild(pos)<=size) {
				current = this.data[rightChild(pos)]>this.data[leftChild(pos)] ? rightChild(pos) : leftChild(pos);
			} else {
				current = leftChild(pos);
			}

			if(this.data[pos]<this.data[current]) {
				swap(pos, current);
				heapify(current);
			}
		}
	}

	public void insert(int number) {
		if(size>=maxSize) return;
		this.size++;
		this.data[this.size] = number;
		int current = this.size;
		while(this.data[current] > this.data[parent(current)] && current > front) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	public int getMin() {
		if(size==0) {
			return Integer.MIN_VALUE;
		}
		int result = this.data[front];
		this.data[front] = this.data[size];
		size--;
		heapify(front);
		return result;
	}

	public void print()
    {
        for (int i = 1; i <= this.size / 2; i++) {
 
            // Printing the parent and both childrens
            System.out.print(
                " PARENT : " + this.data[i]
                + " LEFT CHILD : " + this.data[2 * i]
                + " RIGHT CHILD :" + this.data[2 * i + 1]);
             System.out.println();
        }

        System.out.println(Arrays.toString(this.data));
    }
}


class KthLargestElement {
	public static void main(String[] args){
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
		minHeap.add(5);
        minHeap.add(3);
        minHeap.add(17);
        minHeap.add(10);
        minHeap.add(84);
        minHeap.add(19);
        minHeap.add(6);
        minHeap.add(22);
        minHeap.add(9);
 
        // Print all elements of the heap
        // minHeap.print();
 
        // Removing minimum value from above heap
        // and printing it
        System.out.println("The Min val is " + minHeap.remove());
        System.out.println("The Min val is " + minHeap.remove());
        System.out.println("The Min val is " + minHeap.remove());
	}
	
}







