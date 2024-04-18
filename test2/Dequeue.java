//Problem statement
//You need to implement a class for Dequeue i.e. for double ended queue. In this queue, elements can be inserted and deleted from both the ends.
//
//You don't need to double the capacity.
//
//You need to implement the following functions -
//
//1. constructor
//You need to create the appropriate constructor. Size for the queue passed is 10.
//
//2. insertFront -
//This function takes an element as input and insert the element at the front of queue. Insert the element only if queue is not full. And if queue is full, print -1 and return.
//
//3. insertRear -
//This function takes an element as input and insert the element at the end of queue. Insert the element only if queue is not full. And if queue is full, print -1 and return.
//
//4. deleteFront -
//This function removes an element from the front of queue. Print -1 if queue is empty.
//
//5. deleteRear -
//This function removes an element from the end of queue. Print -1 if queue is empty.
//
//6. getFront -
//Returns the element which is at front of the queue. Return -1 if queue is empty.
//
//7. getRear -
//Returns the element which is at end of the queue. Return -1 if queue is empty.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//5 1 49 1 64 2 99 5 6 -1
//Sample Output 1:
//-1
//64
//99
//Explanation:
//The first choice code corresponds to getFront. Since the queue is empty, hence the output is -1. 
//The following input adds 49 at the top and the resultant queue becomes: 49.
//The following input adds 64 at the top and the resultant queue becomes: 64 -> 49
//The following input add 99 at the end and the resultant queue becomes: 64 -> 49 -> 99
//The following input corresponds to getFront. Hence the output is 64.
//The following input corresponds to getRear. Hence the output is 99.


/******************
* Following is the main function we are using internally.
* Refer this for completing the Dequeue class
*
public static void main(String[] args) {
Scanner s = new Scanner(System.in);
Dequeue dq = new Dequeue(10);
while(true){
int choice = s.nextInt(),input;
switch (choice) {
case 1:
input = s.nextInt();
dq.insertFront(input);
break;
case 2:
input = s.nextInt();
dq.insertRear(input);
break;
case 3:
dq.deleteFront();
break;
case 4:
dq.deleteRear();
break;
case 5:
System.out.println(dq.getFront());
break;
case 6:
System.out.println(dq.getRear());
break;
default:
return ;
}
}
}
******************/
package test2;

public class Dequeue {
// Complete this class
	int arr[];
	int front;
	int rear;
	int size;

	Dequeue(int size) {
		front = -1;
		rear = 0;
		this.size = size;
		arr = new int[size];
	}

	Dequeue() {
		front = -1;
		rear = 0;
		this.size = 10;
		arr = new int[size];
	}

//Checks whether deque is full or not.
	boolean isFull()

	{
// used % operator is insertion and deletion is in circular manner
		return (front == (rear + 1) % size);
	}

//Checks whether Deque is empty or not.
	boolean isEmpty() {
		return (front == -1);
	}

// Inserts an element at front
	void insertFront(int input) {
		if (isFull()) {
			System.out.println(-1);
			return;
		}
		if (front == -1) {
			front = 0;
			rear = 0;
		} else {
// used % operator is insertion is in circular manner
			front = ((front - 1) % size + size) % size;
		}
		arr[front] = input;
	}

// function to inset element at rear end of Deque.
	void insertRear(int input) {
		if (isFull()) {
			System.out.println(-1);
			return;
		}
		if (front == -1) {
			front = 0;
			rear = 0;
		} else {
// used % operator is insertion is in circular manner
			rear = (rear + 1) % size;
		}
		arr[rear] = input;
	}

// Deletes element at front end of Deque
	void deleteFront() {
		if (isEmpty()) {
			System.out.println(-1);
			return;
		}
		if (front == rear) {
			front = -1;
			rear = -1;
		} else {
			front = (front + 1) % size;
		}
	}

// Delete element at rear end of Deque
	void deleteRear() {
		if (isEmpty()) {
			System.out.println(-1);
			return;
		}
		if (front == rear) {
			front = -1;
			rear = -1;
		} else {
// used % operator is deletion is in circular manner
			rear = ((rear - 1) % size + size) % size;
		}
	}

// Returns front element of Deque
	int getFront() {
		if (isEmpty()) {
			return -1;
		}
		return arr[front];
	}

// function return rear element of Deque
	int getRear() {
		if (isEmpty() || rear < 0) {
			return -1;
		}
		return arr[rear];
	}
}
