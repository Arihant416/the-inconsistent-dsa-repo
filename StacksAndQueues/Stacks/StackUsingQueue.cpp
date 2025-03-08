#include <bits/stdc++.h>
using namespace std;

class SQ
{
private:
  queue<int> q;

public:
  SQ()
  {
  }

  void push(int element)
  {
    q.push(element);
    int size = q.size();
    for (int i = 1; i < size; i++)
    {
      q.push(q.front());
      q.pop();
    }
  }

  int pop()
  {
    if (q.empty())
    {
      cout << "Stack is empty" << endl;
      return -1;
    }
    int element = q.front();
    q.pop();
    return element;
  }

  int top()
  {
    return q.front();
  }

  ~SQ()
  {
  }
};

int main()
{
  SQ s;
  s.push(1);
  s.push(2);
  s.push(3);
  cout << s.top() << endl;
  cout << s.pop() << endl;
  cout << s.top() << endl;
  s.push(5);
  cout << s.top() << endl;
}