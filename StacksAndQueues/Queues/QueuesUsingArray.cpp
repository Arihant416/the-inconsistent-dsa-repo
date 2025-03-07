/*
Author : Arihant Jain
github:https://github.com/Arihant416
linkedin : https://www.linkedin.com/in/arihant416
*/
#include <bits/stdc++.h>
using namespace std;

class CustomQueue
{
private:
  int size;
  int front;
  int last;
  int *queue;

public:
  CustomQueue()
  {
    size = 10;
    front = -1;
    last = -1;
    queue = new int[size];
  }

  void enqueue(int element)
  {
    if ((last + 1) % size == front)
    {
      cout << "Queue is full" << endl;
      return;
    }
    last = (last + 1) % size;
    queue[last] = element;
  }

  int dequeue()
  {
    if (last == front)
    {
      cout << "Queue is empty" << endl;
      return -1;
    }
    else
    {
      front = (front + 1) % size;
      return queue[front];
    }
  }

  int peek()
  {
    if (last == front)
    {
      cout << "Queue is empty" << endl;
      return -1;
    }
    else
    {
      return queue[(front + 1) % size];
    }
  }

  ~CustomQueue()
  {
    delete[] queue;
  }

  void printQueue()
  {
    if (last == front)
    {
      cout << "Queue is Empty" << endl;
    }
    else
    {
      for (int i = (front + 1) % size; i != (last + 1) % size; i = (i + 1) % size)
      {
        cout << queue[i] << " ";
      }
      cout << endl;
    }
  }
};

int32_t main()
{
  CustomQueue q;
  q.enqueue(10);
  q.enqueue(20);
  q.enqueue(30);

  q.printQueue(); // Output: 10 20 30

  cout << "Dequeued: " << q.dequeue() << endl; // Output: 10
  q.printQueue();                              // Output: 20 30

  cout << "Peek: " << q.peek() << endl; // Output: 20
  q.printQueue();

  q.enqueue(40);
  q.enqueue(50);
  q.enqueue(60);
  q.enqueue(70);
  q.enqueue(80);
  q.enqueue(90);
  q.enqueue(100);
  q.enqueue(110);
  q.enqueue(120); // This should print "Queue is full"

  q.printQueue();
  return 0;
}