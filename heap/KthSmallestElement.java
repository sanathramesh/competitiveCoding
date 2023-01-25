import java.util.*;

//identfication - Kth smallest or largest

class Heap {
	private int[] data;
	private int size;
	private int maxSize;

	private static final int front = 1;

	public Heap(int maxSize) {
		this.maxSize = maxSize;
		this.size = 0;
		data = new int[maxSize + 1];
		data[0] = Integer.MIN_VALUE;
	}

	private int parent(int position) {
		return (position)/2;
	}

	private int leftChild(int position) {
		return 2*position;
	}

	private int rightChild(int position) {
		return 2*position + 1;
	}

	private boolean isLeaf(int position) {
		if(position>=(this.size)/2)
			return true;
		else
			return false;
	}

	private void swapNodes(int position1, int position2) {
		int temp = data[position1] ;
		data[position1] = data[position2];
		data[position2] = temp;
	}

	private void Heapify(int position) {
		if(!isLeaf(position)) {
			int swapPos;
			if(rightChild(position)<=size) {
				swapPos = this.data[rightChild(position)] < this.data[leftChild(position)] ? rightChild(position) : leftChild(position);
			} else {
				swapPos = leftChild(position);
			}
			if(this.data[position] > this.data[swapPos]) {
				swapNodes(position, swapPos);
				Heapify(swapPos);
			}
		}
	}

	public void insert(int number) {
		if(this.size>=this.maxSize) {
			return;
		}
		size++;
		this.data[size] = number;
		int currentPos = size;
		while(this.data[currentPos]<this.data[parent(currentPos)] && currentPos>1) {
			swapNodes(currentPos, parent(currentPos));
			currentPos = parent(currentPos);
		}
	}

	public int getMin() {
		if(size==0) {
			return Integer.MIN_VALUE;
		} else {
			int result = this.data[front];
			this.data[front] = this.data[size];
			size--;
			this.Heapify(front);
			return result;
		}
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

class KthSmallestElement {

	public static void main(String[] args) {
		Heap minHeap = new Heap(9);
		minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
 
        // Print all elements of the heap
        minHeap.print();
 
        // Removing minimum value from above heap
        // and printing it
        System.out.println("The Min val is " + minHeap.getMin());
        System.out.println("The Min val is " + minHeap.getMin());
        System.out.println("The Min val is " + minHeap.getMin());
        minHeap.print();
	}
}