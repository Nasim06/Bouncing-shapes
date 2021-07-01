
/**
 * 
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).  
 * @author you
 *
 */

import java.util.NoSuchElementException;

public class Queue<T> {

	private QueueElement<T> head;
	private QueueElement<T> tail;

	/**
	 * Constructs an empty Queue.
	 */
	public Queue(){
		head = null;
		tail = null;
	}

	/**
	 * Method to check if Queue is empty
	 * 
	 * @return true if the queue is empty
	 */
	public boolean isEmpty() {
		return (head == null);
	}

	/**
	 * Method to get the element at the head of the queue
	 * 
	 * @return the element at the head of the queue
	 * @param peek holds the element at the head of the queue
	 */
	public T peek() throws NoSuchElementException {
		QueueElement<T> peek = head;
		if (head != null) {
			return peek.getElement();
		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Removes the front element of the queue and sets the second element as head if
	 * it exists
	 * 
	 * @param front Holds the element at the head of the LinkedList
	 * @newHead Holds the element after the head of the LinkedList
	 */
	public void dequeue() throws NoSuchElementException {
		QueueElement<T> front = head;
		if (front == null) {
			throw new NoSuchElementException() ;
		} else {
			if (front.getNext() != null) { // to check if there is an element after the head
				QueueElement<T> newHead = front.getNext();
				this.head = newHead;
			}else {
				this.head = null;
			}
			front.setElement(null);
		
		}
	}

	/**
	 * Puts an element on the back of the queue.
	 * 
	 * @param back The element to be put at the back of the queue
	 */
	public void enqueue(T element) {
		QueueElement<T> back = new QueueElement<T>(element, null);
		if (isEmpty()) {
			// if the array is empty, the new element is now the head and tail
			this.head = back;
			this.tail = back;
		} else {
			tail.setNext(back);
			this.tail = back;// the new element is now the tail
		}
	}

	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print() {
		String toPrint = "";
		if (isEmpty()) {
			toPrint = "The queue is empty";
			System.out.println(toPrint);
		} else {
			QueueElement<T> current = head;
			toPrint = current.getElement().toString();
			while (current.getNext() != null) {
				current = current.getNext();
				toPrint = toPrint + "\n" + current.getElement().toString();
			}
			System.out.println(toPrint);
			System.out.println("");
		}
		
		
		

	}

}
