#include <stdio.h>
#include <stdlib.h>

struct tree{
	struct tree *left;
	struct tree *right;
	int data;
};

int num_node;

struct tree * newNode(int val){
	struct tree *temp;
	temp = malloc(sizeof(struct tree));
	temp->data = val;
	temp->left = NULL;
	temp->right = NULL;
}

struct tree * nth_inorder(struct tree *root, int n){
	
	struct tree *temp;
	if(root == NULL){
		return NULL;
	}
	
	temp = nth_inorder(root->left, n);
	if(temp != NULL) return temp;
	temp = nth_inorder(root->right, n);
	if(temp != NULL) return temp;
	
	num_node++;
	
	if(num_node == n){
		return root;
	}else{
		return NULL;
	}
}

void inorder(struct tree *root){
	if(root != NULL){
		inorder(root->left);
		printf(" %d", root->data);
		inorder(root->right);
	}
}

int main(int argc, char **argv){
	struct tree *root;
	struct tree *nth_node;

	root = newNode(4);
	root->left = newNode(2);
	root->left->left = newNode(1);
	root->left->right = newNode(3);
	root->right = newNode(6);
	root->right->left = newNode(5);
	root->right->right = newNode(7);

	printf("Original : ");
	inorder(root);
	printf("\n\n");

	nth_node = nth_inorder(root, 100);
	
	if(nth_node != NULL)
		printf("Nth node data : %d \n", nth_node->data);
	else
		printf("Out of range \n");
	

	return 0;
}
