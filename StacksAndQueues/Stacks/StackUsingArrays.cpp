#include <bits/stdc++.h>
using namespace std;

class StackImplementation
{
private:
  int size = 10;
  int top;
  int *arr;

public:
  StackImplementation()
  {
    this->size = 10;
    this->arr = new int[size];
    this->top = -1;
  }

  void push(int element)
  {
    if (top == size - 1)
    {
      cout << " Stack Overflow " << endl;
    }
    else
    {
      this->arr[++top] = element;
    }
  }

  int pop()
  {
    if (top == -1)
    {
      cout << " Stack Underflow " << endl;
      return -1;
    }
    else
    {
      int elem = this->arr[top];
      this->arr[top] = -1;
      top--;
      return elem;
    }
  }

  int getTop()
  {
    if (top == -1)
    {
      return -1;
    }
    else
    {
      return this->arr[top];
    }
  }

  int getSize()
  {
    return top + 1;
  }

  void printStack()
  {
    if (top == -1)
    {
      cout << "Stack is empty" << endl;
    }
    else
    {
      for (int i = 0; i <= top; i++)
      {
        cout << arr[i] << " ";
      }
      cout << endl;
    }
  }
};

int main()
{
  StackImplementation s;
  s.push(1);
  cout << s.getSize();
  cout << s.getTop();
  cout << s.pop();
  s.push(2);
  s.push(3);
  s.push(4);
  s.printStack();
  return 0;
}