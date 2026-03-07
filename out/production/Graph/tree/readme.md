# Tree Data Structure

## What is Tree Data Structure?

A **Tree** is a hierarchical, non-linear data structure that consists of nodes connected by edges. Unlike linear data structures (arrays, linked lists), trees organize data in a way that represents relationships between elements.

### Key Characteristics:
- **Root Node**: The topmost node in a tree (no parent)
- **Parent Node**: A node that has child nodes
- **Child Node**: A node that has a parent node
- **Leaf Node**: A node with no children (terminal node)
- **Edge**: Connection between two nodes
- **Path**: Sequence of nodes connected by edges
- **Height**: Length of the longest path from root to a leaf
- **Depth**: Length of path from root to a specific node
- **Level**: Set of nodes at the same depth

### Tree Structure Example:
```
        A (Root)
       / \
      B   C
     / \   \
    D   E   F
           /
          G
```

---

## Types of Trees

### 1. Binary Tree
A tree where each node has **at most two children** (left and right child).

**Properties:**
- Each node can have 0, 1, or 2 children
- No specific ordering rule for values
- Maximum nodes at level `i` = 2^i
- Maximum nodes in a tree of height `h` = 2^(h+1) - 1

**Example:**
```
      10
     /  \
    5    20
   / \
  3   7
```

### 2. Binary Search Tree (BST)
A special type of binary tree with ordering rules:

**Rules:**
- **Left Subtree**: All values are **less than** the parent node
- **Right Subtree**: All values are **greater than** the parent node
- No duplicate values (typically)

**Properties:**
- Enables fast search, insert, and delete operations
- In-order traversal gives sorted sequence
- Time Complexity: O(log n) for balanced BST, O(n) for skewed BST

**Example:**
```
      15
     /  \
   10    20
  / \    / \
 5  12  17  25
```

**Why BST is Useful:**
- Fast search operations (O(log n) average case)
- Efficient insertion and deletion
- Maintains sorted order automatically
- Used in databases, file systems, and search algorithms

### 3. Balanced Binary Tree
A binary tree where the height difference between left and right subtrees is at most 1.

**Types:**
- **AVL Tree**: Self-balancing BST
- **Red-Black Tree**: Self-balancing BST with color properties
- **B-Tree**: Used in databases and file systems

### 4. Complete Binary Tree
A binary tree where all levels are completely filled except possibly the last level, which is filled from left to right.

### 5. Full Binary Tree
A binary tree where every node has either 0 or 2 children (no node has only one child).

### 6. Perfect Binary Tree
A binary tree where all internal nodes have two children and all leaf nodes are at the same level.

---

## Tree Traversals

Tree traversal means visiting every node in the tree exactly once.

### 1. Depth-First Search (DFS) Traversals

#### Preorder Traversal (Root → Left → Right)
**Algorithm:**
1. Visit the root node
2. Traverse the left subtree
3. Traverse the right subtree

**Use Cases:**
- Creating a copy of the tree
- Getting prefix expression of an expression tree
- Preorder serialization

**Example:** For tree `1 / \ 2 3`, output: `1 2 3`

#### Inorder Traversal (Left → Root → Right)
**Algorithm:**
1. Traverse the left subtree
2. Visit the root node
3. Traverse the right subtree

**Use Cases:**
- For BST: Returns nodes in sorted order
- Infix expression evaluation
- Binary search tree operations

**Example:** For BST `2 / \ 1 3`, output: `1 2 3`

#### Postorder Traversal (Left → Right → Root)
**Algorithm:**
1. Traverse the left subtree
2. Traverse the right subtree
3. Visit the root node

**Use Cases:**
- Deleting a tree
- Postfix expression evaluation
- Computing directory sizes

**Example:** For tree `1 / \ 2 3`, output: `2 3 1`

### 2. Breadth-First Search (BFS) / Level Order Traversal

**Algorithm:**
1. Start from root
2. Visit nodes level by level (left to right)
3. Use a queue to maintain order

**Use Cases:**
- Printing tree level by level
- Finding minimum depth
- Level-order serialization

**Example:** For tree `1 / \ 2 3 / 4`, output: `1 2 3 4`

---

## Common Tree Operations

### 1. Insertion
- **Binary Tree**: Insert at first available position
- **BST**: Insert maintaining BST property (left < root < right)

**Time Complexity:**
- BST: O(log n) average, O(n) worst case (skewed tree)
- Binary Tree: O(n) - need to find insertion point

### 2. Search
- **BST**: O(log n) average, O(n) worst case
- **Binary Tree**: O(n) - need to check all nodes

### 3. Deletion
- **BST**: O(log n) average, O(n) worst case
- **Binary Tree**: O(n)

### 4. Traversal
- All traversals: O(n) - visit each node once

---

## Tree Implementation

### Node Structure
```java
class Node {
    int data;
    Node left;
    Node right;
    
    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
```

### Building a Tree
- **Recursive Approach**: Build left subtree, then right subtree
- **Level Order Approach**: Use queue to build level by level
- **BST Insertion**: Compare values and insert at appropriate position

---

## Time & Space Complexity

| Operation | Binary Tree | BST (Balanced) | BST (Skewed) |
|-----------|-------------|----------------|--------------|
| Search    | O(n)        | O(log n)       | O(n)         |
| Insert    | O(n)        | O(log n)       | O(n)         |
| Delete    | O(n)        | O(log n)       | O(n)         |
| Traversal | O(n)        | O(n)           | O(n)         |
| Space     | O(n)        | O(n)           | O(n)         |

---

## Applications of Trees

1. **File Systems**: Directory structure representation
2. **Database Indexing**: B-trees for efficient data retrieval
3. **Expression Evaluation**: Expression trees for arithmetic expressions
4. **Decision Trees**: Machine learning and AI
5. **Huffman Coding**: Data compression
6. **Priority Queues**: Heap data structure
7. **Routing Algorithms**: Network routing tables
8. **Syntax Trees**: Compiler design
9. **Game Trees**: AI game playing (chess, tic-tac-toe)
10. **Organizational Charts**: Company hierarchy

---

## Advantages of Trees

**Hierarchical Representation**: Natural representation of hierarchical data
**Fast Search**: BST provides O(log n) search time
**Flexible Size**: Dynamic size, no fixed capacity
**Efficient Insertion/Deletion**: Better than arrays for frequent operations
**Sorted Data**: BST maintains sorted order automatically
**Multiple Traversals**: Different ways to access data

---

## Disadvantages of Trees

**Memory Overhead**: Each node stores pointers/references
**No Random Access**: Cannot access elements by index
**Skewed Trees**: Performance degrades to O(n) for unbalanced trees
**Complex Implementation**: More complex than linear structures
**Balancing Required**: Need balancing algorithms for optimal performance
