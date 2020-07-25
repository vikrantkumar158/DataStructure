/*This may yeild an incorrect answer in some cases*/
#include <stdio.h>
#include <stdlib.h>
struct Node 
{ 
    int data; 
    struct Node* next; 
}; 
struct Node* getIntesectionNode(struct Node* head1, struct Node* head2)
{
	struct Node *temp1,*temp2;
	temp1=head1;
	temp2=head2;
	while(1)
	{
		if(temp1!=temp2&&temp1->next==temp2->next)
			return temp1->next;
		temp1=temp1->next;
		if(temp1==NULL)
			temp1=head1;
		temp2=temp2->next;
		if(temp2==NULL)
			temp2=head2;
		temp2=temp2->next;
		if(temp2==NULL)
			temp2=head2;
		if(temp1==head1&&temp2==head2)
			break;
	}
	return NULL;
}
int main(int argc, char const *argv[])
{
	struct Node* newNode; 
    struct Node* head1 = (struct Node*)malloc(1 * sizeof(struct Node)); 
    head1->data = 10; 
    struct Node* head2 = (struct Node*)malloc(1 * sizeof(struct Node)); 
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
    struct Node* temp = getIntesectionNode(head1, head2);
    if(temp!=NULL)
    	printf("The node of intersection is %d\n", temp->data);
    else
    	printf("There is no node of intersection");
	return 0;
}