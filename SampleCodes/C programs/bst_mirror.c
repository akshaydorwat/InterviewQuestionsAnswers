#include <stdio.h>
#include <stdlib.h>

struct tree{
	struct tree *left;
	struct tree *right;
	int data;
};


struct tree * newNode(int val){
	struct tree *temp;
	temp = malloc(sizeof(struct tree));
	temp->data = val;
	temp->left = NULL;
	temp->right = NULL;
}

struct tree * _mirror(struct tree *root){
	
	struct tree *temp;

	if(root == NULL){
		return NULL;
	}
	
	temp = newNode(root->data);
	temp->left = _mirror(root->right);
	temp->right = _mirror(root->left);
	
	return temp;
}

struct tree * mirror(struct tree *root){
	
	if(root == NULL){
		return NULL;
	}else{
		return _mirror(root);
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
	struct tree *mirror_root;

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

	mirror_root = mirror(root);

	printf("mirror : ");
	inorder(mirror_root);
	printf("\n\n");
	

	return 0;
}
