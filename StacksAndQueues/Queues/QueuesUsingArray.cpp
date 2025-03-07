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
    this->size = 10;
    this->front = -1;
    this->last = -1;
    this->queue = new int[size];
  }

  void enqueue(int element)
  {
    if (last == size - 1)
    {
      cout << "Queue Overflowing" << endl;
    }
    else
    {
      this->queue[++last] = element;
    }
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
      return this->queue[++front];
    }
  }

  int peek()
  {
    if (front != -1 && last != front)
    {
      return this->queue[front + 1];
    }
    else
    {
      cout << "Queue is empty" << endl;
      return -1;
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
      for (int i = front + 1; i <= last; i++)
      {
        cout << queue[i] << endl;
      }
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
  return 0;
}