#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

// Structure for the adjacency list node
struct Node {
    int dest;
    struct Node* next;
};

// Structure for the adjacency list
struct AdjList {

    struct Node* head;
};

// Structure for the graph
struct Graph {
    int V;
    struct AdjList* array;
};

// Create a new adjacency list node
struct Node* newAdjListNode(int dest) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->dest = dest;
    newNode->next = NULL;
    return newNode;
}

// Create a graph with V vertices
struct Graph* createGraph(int V) {
    int i;
    struct Graph* graph = (struct Graph*)malloc(sizeof(struct Graph));
    graph->V = V;
    graph->array = (struct AdjList*)malloc(V * sizeof(struct AdjList));
    for (i = 0; i < V; ++i) {
	graph->array[i].head = NULL;
    }
    return graph;
}

// Add an edge to an undirected graph
void addEdge(struct Graph* graph, int src, int dest) {
    struct Node* newNode = newAdjListNode(dest);
    newNode->next = graph->array[src].head;
    graph->array[src].head = newNode;

    newNode = newAdjListNode(src);
    newNode->next = graph->array[dest].head;
    graph->array[dest].head = newNode;
}

// Function to perform iterative DFS
void iterativeDFS(struct Graph* graph, int startVertex) {
    int V = graph->V;
    int *visited = (int*)malloc(V * sizeof(int));
    int *stack = (int*)malloc(V * sizeof(int));
    int top = -1;
    int i, currentVertex, adjVertex;
    struct Node* temp;

    for (i = 0; i < V; i++) {
	visited[i] = 0;
    }

    stack[++top] = startVertex;

    while (top != -1) {
	currentVertex = stack[top--];

	if (!visited[currentVertex]) {
	    printf("%d - ", currentVertex);
	    visited[currentVertex] = 1;
	}

	temp = graph->array[currentVertex].head;
	while (temp) {
	    adjVertex = temp->dest;

	    if (!visited[adjVertex]) {
		stack[++top] = adjVertex;
	    }
	    temp = temp->next;
	}
    }
	printf("null");
    printf("\n");
    getch();
    free(visited);
    free(stack);
}

// Main function to test the iterative DFS
int main() {
    int V, E, i, src, dest, startVertex;
    struct Graph* graph;
    clrscr();
    printf("---Graph with traversal using iterative DFS Technique---\n");
    printf("Enter the number of vertices: ");
    scanf("%d", &V);

    graph = createGraph(V);

    printf("Enter the number of edges: ");
    scanf("%d", &E);

    printf("\nEnter the edges (source and destination):\n\n");
    for (i = 0; i < E; i++) {
	printf("Edge %d: ", i + 1);
	scanf("%d %d", &src, &dest);
	addEdge(graph, src, dest);
    }

    printf("\nEnter the starting vertex for DFS: ");
    scanf("%d", &startVertex);

    printf("Iterative DFS starting from vertex %d: \n", startVertex);
    iterativeDFS(graph, startVertex);

    return 0;
}
