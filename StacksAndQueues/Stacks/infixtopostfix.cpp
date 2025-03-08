#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
  // Function to convert an infix expression to a postfix expression.
  bool isBracket(char c)
  {
    return c == '(' || c == ')';
  }

  bool isOperator(char c)
  {
    return c == '+' || c == '-' || c == '/' || c == '*' || c == '^';
  }
  bool isGreaterOrEqual(char op, char c)
  {
    switch (op)
    {
    case '^':
    {
      return true;
    }
    case '/':
    {
      return c != '^';
    }
    case '*':
      return c != '^';
    case '+':
      return c == '-' || c == '+';
    case '-':
      return c == '+' || c == '-';
    }
    return false;
  }
  void printStack(stack<char> s)
  {
    while (!s.empty())
    {
      cout << s.top() << " ";
      s.pop();
    }
  }
  string infixToPostfix(string &s)
  {
    // Your code here
    stack<char> st;
    string postfix = "";
    for (auto &c : s)
    {
      if (isBracket(c))
      {
        if (c == ')')
        {
          while (!st.empty() && st.top() != '(')
          {
            postfix += st.top();
            st.pop();
          }
          st.pop();
        }
        else
        {
          st.push(c);
        }
      }
      else if (isOperator(c))
      {
        if (st.empty())
        {
          st.push(c);
        }
        else
        {
          while (!st.empty() && isGreaterOrEqual(st.top(), c))
          {
            postfix += st.top();
            st.pop();
          }
          st.push(c);
        }
      }
      else
      {
        postfix += c;
      }
    }
    while (!st.empty())
    {
      postfix += st.top();
      st.pop();
    }
    return postfix;
  }
};

int main()
{
  string s = "A*(B+C)/D";
  Solution ob;
  cout << endl;
  cout << ob.infixToPostfix(s) << endl;
}