#include <stdio.h>
#include <stdlib.h>

// Definition of a node in the BST
struct Node {
    int data;
    struct Node* left;
    struct Node* right;
};

// Function to create a new node
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->left = newNode->right = NULL;
    return newNode;
}

// Function to insert a new node into the BST
struct Node* insert(struct Node* node, int data) {
    if (node == NULL) {
        return createNode(data);
    }
    if (data < node->data) {
        node->left = insert(node->left, data);
    } else if (data > node->data) {
        node->right = insert(node->right, data);
    }
    return node;
}

// Function to search for a value in the BST
struct Node* search(struct Node* root, int data) {
    if (root == NULL || root->data == data) {
        return root;
    }
    if (data < root->data) {
        return search(root->left, data);
    }
    return search(root->right, data);
}

// Function to find the minimum value node
struct Node* findMin(struct Node* node) {
    struct Node* current = node;
    while (current && current->left != NULL) {
	current = current->left;
    }
    return current;
}

// Function to delete a node from the BST
struct Node* deleteNode(struct Node* root, int data) {
    struct Node* temp1=findMin(root->right);
    if (root == NULL) {
	return root;
    }
    if (data < root->data) {
	root->left = deleteNode(root->left, data);
    } else if (data > root->data) {
	root->right = deleteNode(root->right, data);
    } else {
	if (root->left == NULL) {
	    struct Node* temp = root->right;
	    free(root);
	    return temp;
	} else if (root->right == NULL) {
	    struct Node* temp = root->left;
	    free(root);
	    return temp;
	}

	root->data = temp1->data;
	root->right = deleteNode(root->right, temp1->data);
    }
    return root;
}

// Function to perform in-order traversal of the BST
void inorderTraversal(struct Node* root) {
    if (root != NULL) {
	inorderTraversal(root->left);
        printf("%d ", root->data);
        inorderTraversal(root->right);
    }
}

int main() {
    struct Node* root = NULL;
    int choice, value;

    while (1) {
        printf("\n\nBinary Search Tree Operations:\n");
        printf("1. Insert\n");
        printf("2. Search\n");
        printf("3. Delete\n");
        printf("4. In-order Traversal\n");
        printf("5. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter value to insert: ");
                scanf("%d", &value);
		root = insert(root, value);
		printf("\tNode Inserted\n");
                break;
            case 2:
                printf("Enter value to search: ");
                scanf("%d", &value);
                if (search(root, value) != NULL) {
                    printf("%d found in the BST.\n", value);
                } else {
                    printf("%d not found in the BST.\n", value);
                }
                break;
            case 3:
                printf("Enter value to delete: ");
                scanf("%d", &value);
                root = deleteNode(root, value);
                printf("In-order traversal after deletion: ");
                inorderTraversal(root);
                printf("\n");
                break;
            case 4:
                printf("In-order traversal: ");
                inorderTraversal(root);
                printf("\n");
                break;
            case 5:
		exit(0);
		break;
	    default:
		printf("Invalid choice! Please enter a valid option.\n");
	}
    }
    return 0;
}

