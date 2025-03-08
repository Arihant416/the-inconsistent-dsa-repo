/*
Author : Arihant Jain
github:https://github.com/Arihant416
linkedin : https://www.linkedin.com/in/arihant416
*/
#include <bits/stdc++.h>
using namespace std;

class Node
{
public:
  int data;
  Node *next;
  Node()
  {
    data = 0;
    next = nullptr;
  }
  Node(int element)
  {
    data = element;
    next = NULL;
  }
};

class Stack
{

private:
  int size;
  Node *top;

public:
  Stack()
  {
    size = 0;
    top = new Node();
  }

  void push(int element)
  {
    Node *temp = new Node(element);
    temp->next = top;
    top = temp;
    size++;
  }

  int pop()
  {
    if (!top)
    {
      cout << "Stack is empty" << endl;
      return -1;
    }
    Node *temp = top;
    int elem = temp->data;
    top = top->next;
    delete temp;
    --size;
    return elem;
  }

  int peek()
  {
    if (!top)
    {
      cout << "Stack is empty" << endl;
      return -1;
    }
    return top->data;
  }

  int ssize()
  {
    return size;
  }

  ~Stack()
  {
    while (top != nullptr)
    {
      Node *temp = top;
      top = top->next;
      delete temp;
    }
  }
};

int32_t main()
{
  Stack s;
  s.push(10);
  s.push(20);
  s.push(30);

  cout << "Top element: " << s.peek() << endl; // Output: 30
  cout << "Stack size: " << s.ssize() << endl; // Output: 3

  cout << "Popped element: " << s.pop() << endl; // Output: 30
  cout << "Top element: " << s.peek() << endl;   // Output: 20
  cout << "Stack size: " << s.ssize() << endl;   // Output: 2

  return 0;
}