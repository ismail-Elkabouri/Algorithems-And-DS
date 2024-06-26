// Binary Tree in C++
#include <stdlib.h>
#include <iostream>
#include<bits/stdc++.h>
using namespace std;

struct node {
  int data;
  struct node *left;
  struct node *right;
};

// New node creation
struct node *newNode(int data) {
  struct node *node = (struct node *)malloc(sizeof(struct node));

  node->data = data;

  node->left = NULL;
  node->right = NULL;
  return (node);
}

// Traverse 1st order
void traverse1stOrder(struct node *temp) {
    stack<node *> s;
    node *curr = temp;
  
    while (curr != NULL || s.empty() == false)
    {
        while (curr !=  NULL)
        {
            s.push(curr);
            curr = curr->left;
        }

        curr = s.top();
        s.pop();
  
        cout << curr->data << " ";

        curr = curr->right;
  
    } 
}

// Traverse midlle order
void traverseMidOrder(struct node *temp) {
    stack<node *> s;
    node *curr = temp;
  
    while (curr != NULL || s.empty() == false)
    {

        while (curr !=  NULL)
        {
            s.push(curr);
            curr = curr->left;
        }
        curr = s.top();
        cout << curr->data << " ";
        s.pop();
        curr = curr->right;
  
    } 
}

// Traverse Last order
void traverseLastOrder(struct node *temp) {
    if (temp == NULL)
        return ;
    stack<node*> s;
    s.push(temp);
    node* prev = NULL;
    while (!s.empty()) {
        node* current = s.top();
        if (prev == NULL || prev->left == current
            || prev->right == current) {
            if (current->left)
                s.push(current->left);
            else if (current->right)
                s.push(current->right);
            else {
                s.pop();
                cout << current->data <<" ";
            }
        }
 
        else if (current->left == prev) {
            if (current->right)
                s.push(current->right);
            else {
                s.pop();
            cout << current->data <<" ";
            }
        }
        else if (current->right == prev) {
            s.pop();
            cout << current->data <<" ";
        }
        prev = current;
    }
}

int main() {
  struct node *root = newNode(1);
  root->left = newNode(2);
  root->right = newNode(3);
  root->left->left = newNode(4);
  root->left->right = newNode(5);
  root->right->left = newNode(6);
  root->right->right = newNode(7);
  root->right->left->left = newNode(8);
  root->right->right->left = newNode(9);

  cout << "1st order traversal: ";
  traverse1stOrder(root);
  cout << "\nmidlle order traversal: ";
  traverseMidOrder(root);
  cout << "\nLast order traversal: ";
  traverseLastOrder(root);
  cout << "\n";
}
