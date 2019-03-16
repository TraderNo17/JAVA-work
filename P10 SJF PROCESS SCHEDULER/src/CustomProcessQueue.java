//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: SJF PROCESS SCHEDULER
// Files: CustomProcess.java,CustomProcessQueue.java,ProcessScheduler.java,
// ProcessSchedulerTests.java,WaitingQueueADT.java
// Course: CS300,fall,2018
//
// Author: Yida Wu
// Email: ywu479@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: None
// Online Sources: None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * this class implements WaitingQueueADT. it is the core part of the program. all methods in this
 * class are centered around heap sort.
 * 
 * @author YIDA WU
 */
public class CustomProcessQueue implements WaitingQueueADT<CustomProcess> {
  private static final int INITIAL_CAPACITY = 20; // the initial capacity of the heap
  private CustomProcess[] heap; // array-based min heap storing the data. This is an oversize array
  private int size; // number of CustomProcesses present in this CustomProcessQueue

  /**
   * this is the constructor of the class, initialize values.
   */
  public CustomProcessQueue() {
    heap = new CustomProcess[1 + INITIAL_CAPACITY]; // add 1 to keep the size reasonable
    this.size = 0;
  }

  /**
   * this is a private method that used in enqueue method. keep the sort in heap reasonable.
   * 
   * @param index the index of the input.
   */
  private void minHeapPercolateUp(int index) {
    while (index > 1) {
      int parent = index / 2;
      if (heap[index].compareTo(heap[parent]) > 0) {
        return;
      }
      CustomProcess temp = heap[index]; // begin swap to keep the right order
      heap[index] = heap[parent];
      heap[parent] = temp;
      index = parent;
    }
  }

  /**
   * this is also a private method used in dequeue method. keep the order in heap is right.
   * 
   * @param index the index of the input.
   */
  private void minHeapPercolateDown(int index) {
    while (index * 2 <= size) {
      int child = index * 2;
      for (int i = 0; i < 2; i++) {
        if (i + child <= size && heap[i + child].compareTo(heap[index]) < 0) {
          child = i + child; // to keep swap the right thing
          CustomProcess temp = heap[index]; // swap begins
          heap[index] = heap[child];
          heap[child] = temp;
          break;
        }
        if (i == 1) {
          return;
        }
      }
      index = child;
    }
  }

  /**
   * this method overrides a method in WaitingQueueADT interface. enqueue an object into the heap.
   * 
   * @see WaitingQueueADT#enqueue(java.lang.Comparable)
   */
  @Override
  public void enqueue(CustomProcess newObject) {
    size++;
    if (size > heap.length) {
      CustomProcess[] newHeap = new CustomProcess[heap.length + INITIAL_CAPACITY];
      // check the capacity
      for (int i = 1; i < heap.length; i++) {
        newHeap[i] = heap[i];
      }
      heap = newHeap;
    }
    heap[size] = newObject;
    minHeapPercolateUp(size); // call private method help to sort
  }


  /**
   * this method overrides a method in WaitingQueueADT interface. dequeue an object in the heap.
   * 
   * @see WaitingQueueADT#dequeue()
   */
  @Override
  public CustomProcess dequeue() {
    if (size == 0) {
      return null;
    }
    CustomProcess temp = heap[1];
    heap[1] = heap[size]; // put the last one into the first.
    heap[size] = null;
    size--;
    minHeapPercolateDown(1);// call private method help to sort
    return temp;
  }


  /**
   * this method overrides a method in WaitingQueueADT interface. peek an object in the heap.
   * 
   * @see WaitingQueueADT#peek()
   */
  @Override
  public CustomProcess peek() {
    if (size == 0) { // if no object, it will return null.
      return null;
    }
    return heap[1];
  }

  /**
   * this method overrides a method in WaitingQueueADT interface. to get the size of heap array.
   * 
   * @see WaitingQueueADT#size()
   */
  @Override
  public int size() {
    // TODO Auto-generated method stub
    return size;
  }

  /**
   * this method checks whether the heap is empty or not.
   * 
   * @see WaitingQueueADT#isEmpty()
   */
  @Override
  public boolean isEmpty() {
    if (size == 0) {
      return true;// empty array's size is 0.
    }
    return false;
  }
}
