#include <iostream>
#include <stdlib.h>
#include <set>
using namespace std;
struct Node 
{ 
    int data; 
    struct Node* next; 
};
int main(int argc, char const *argv[])
{
	int size=0;
	Node* newNode; 
    Node* head1 = (struct Node*)malloc(1 * sizeof(struct Node)); 
    head1->data = 10; 
    Node* head2 = (struct Node*)malloc(1 * sizeof(struct Node)); 
    head2->data = 3; 
    newNode = (struct Node*)malloc(1 * sizeof(struct Node)); 
    newNode->data = 6; 
    head2->next = newNode; 
    newNode = (struct Node*)malloc(1 * sizeof(struct Node)); 
    newNode->data = 9; 
    head2->next->next = newNode; 
    newNode = (struct Node*)malloc(1 * sizeof(struct Node)); 
    newNode->data = 15; 
    head1->next = newNode; 
    head2->next->next->next = newNode; 
    newNode = (struct Node*)malloc(1 * sizeof(struct Node)); 
    newNode->data = 30; 
    head1->next->next = newNode; 
    head1->next->next->next = NULL;
    set<Node*> s;
    while(head1!=NULL)
    {
    	s.insert(head1);
    	++size;
    	head1=head1->next;
    }
    while(head2!=NULL)
    {
    	s.insert(head2);
    	++size;
    	if(s.size()!=size)
    		break;
    	head2=head2->next;
    }
    if(head2!=NULL)
    	cout << "Intersection point is " << head2->data;
    else
    	cout << "There is no Intersection";
	return 0;
}