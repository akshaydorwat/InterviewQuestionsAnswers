#include<stdio.h>
#include<stdlib.h>

struct node 
{
  int data;
  struct node *left;
  struct node *right;
};

struct node * bintree2listUtil(struct node *root)
{
  struct node *left = NULL, *right = NULL;
  struct node *ret = NULL;
  
  if(root->right == NULL && root->left == NULL)
  {
      return root;
  }   
  
  if(root->right != NULL)
  {
    right = bintree2listUtil(root->right);
  }
      
  if(root->left != NULL)
  {
    left = bintree2listUtil(root->left);
  }
  
  if(left != NULL && right != NULL){
	  ret = left;
	  
	  while(left->right != NULL){
		  left = left->right;
	  }
	  left->right =  right;
	  while(right->right != NULL){
		  right = right->right;
	  }
	  right->right = root;
	  root->right = NULL;
  
  }else if(left != NULL){
	  ret = left;
	  
	  while(left->right != NULL){
		  left = left->right;
	  }
	  left->right = root;
	  root->right = NULL;

  }else if(right != NULL){
	  ret = right;

	  while(right->right != NULL){
		  right = right->right;
	  }
	  right->right = root;
	  root->right = NULL;
  }else{
	  root->right = NULL;
	  ret = root;
  }
  
  return ret;
}

struct node* bintree2list(struct node *root)
{
    // Base case
    if (root == NULL)
        return root;
 
    // Convert to DLL using bintree2listUtil()
    root = bintree2listUtil(root);
 
    // bintree2listUtil() returns root node of the converted
    // DLL.  We need pointer to the leftmost node which is
    // head of the constructed DLL, so move to the leftmost node
    // while (root->left != NULL)
    //    root = root->left;
 
    return (root);
}
 
/* Helper function that allocates a new node with the
   given data and NULL left and right pointers. */
struct node* newNode(int data)
{
    struct node* new_node = malloc(sizeof(struct node));
    new_node->data = data;
    new_node->left = new_node->right = NULL;
    return (new_node);
}
 
/* Function to print nodes in a given doubly linked list */
void printList(struct node *node)
{
    while (node!=NULL)
    {
        printf("%d ", node->data);
        node = node->right;
    }
	printf("\n");
}
 
/* Driver program to test above functions*/
int main()
{
    // Let us create the tree shown in above diagram
    struct node *root        = newNode(10);
    root->left        = newNode(12);
    root->right       = newNode(15);
    root->left->left  = newNode(25);
    root->left->right = newNode(30);
    root->right->left = newNode(36);
 
    // Convert to DLL
    struct node *head = bintree2list(root);
 
    // Print the converted list
    printList(head);
 
    return 0;
}
