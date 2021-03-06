package project.data_structure.Queue.Design_Circular_Queue;

/**
 * @author wt
 * @create 2019-04-07 下午5:07
 */
public class MyCircularQueue {

    private Integer[] nums;
    private int head;
    private int tail;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.nums = new Integer[k];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else if(this.head == this.tail && this.tail == -1){
            this.head++;
            this.tail++;
            nums[this.tail] = value;
        } else {
            this.tail = (this.tail + 1) % nums.length;
            this.nums[this.tail] = value;
        }
        this.size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else if (this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
        } else {
            this.head = (this.head + 1) % this.nums.length;
        }
        this.size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        } else {
            return this.nums[this.head];
        }
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        } else {
            return this.nums[this.tail];
        }
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if (this.size == this.nums.length) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(8);
        myCircularQueue.enQueue(3);
        myCircularQueue.enQueue(9);
        myCircularQueue.enQueue(5);
        myCircularQueue.enQueue(0);
        myCircularQueue.deQueue();
        myCircularQueue.isEmpty();
        myCircularQueue.isEmpty();
        myCircularQueue.Rear();
        myCircularQueue.Rear();
        myCircularQueue.deQueue();
    }
}
