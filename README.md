# Data Structures and Algorithms Portfolio
## Max Rome | Computer Science Student

### Overview
A comprehensive collection of data structures and algorithms implemented from scratch in Java. This portfolio demonstrates my understanding of fundamental computer science concepts and ability to implement complex algorithms efficiently.

### Featured Projects

#### 1. Text Analysis Engine
- **Purpose**: Analyzes text files to find most common words using three different data structures
- **Technologies**: Binary Search Tree, AVL Tree, HashMap implementations
- **Complexity**: O(n log n) for tree structures, O(1) average for HashMap
- **Key Features**: 
  - Command-line interface with comprehensive error handling
  - Performance comparison between different data structures
  - Handles large text files (tested with Bible.txt)
- **Usage**: `java CommonWordFinder bible.txt hash 10`

#### 2. Expression Calculator
- **Purpose**: Evaluates mathematical expressions using infix-to-postfix conversion
- **Algorithms**: Shunting yard algorithm, stack-based evaluation
- **Features**: Parentheses support, operator precedence, unary operators
- **Usage**: `java IntCalculator "(2 + 3) ^ 2"`

#### 3. Graph Algorithms
- **Purpose**: Implements topological sorting for directed acyclic graphs
- **Algorithms**: Kahn's algorithm with priority queue
- **Features**: Cycle detection, lexicographically smallest ordering
- **Application**: Solves competitive programming problems

#### 4. Algorithmic Optimization
- **Purpose**: Counts inversions using two different approaches
- **Algorithms**: O(n²) brute force vs O(n log n) merge sort modification
- **Educational Value**: Demonstrates algorithmic complexity understanding

### Data Structure Implementations

#### HashMap with Chaining
- Dynamic resizing with prime number table sizes
- Collision resolution using linked lists
- Load factor management (0.75 threshold)

#### Self-Balancing AVL Tree
- Height-balanced binary search tree
- Automatic rebalancing with rotations
- O(log n) guaranteed performance

#### Dynamic Arrays and Linked Lists
- Resizable array implementation
- Singly linked list with tail pointer
- Iterator implementations

### Technical Highlights

- **Language**: Java 11
- **Concepts**: Data Structures, Algorithms, Time Complexity Analysis
- **Testing**: Comprehensive test cases for all implementations
- **Documentation**: Detailed README files for each project

### Learning Outcomes

This portfolio demonstrates:
- Algorithm Design: Implementing complex algorithms from scratch
- Data Structure Mastery: Building core data structures from the ground up
- Performance Analysis: Understanding time and space complexity
- Problem Solving: Converting requirements into working solutions
- Code Quality: Clean, well-documented, maintainable code

### Getting Started

```bash
# Clone the repository
git clone https://github.com/maximusrome/Data-Structures-and-Algorithms-Portfolio.git

# Navigate to any project
cd projects/text-analysis
javac *.java
java CommonWordFinder sample.txt bst 10
```

### Project Structure

```
projects/
├── text-analysis/          # Word frequency analysis
├── expression-calculator/  # Mathematical expression evaluator
├── graph-algorithms/       # Topological sorting
├── algorithmic-optimization/ # Inversion counting
├── data-structures/        # Core data structure implementations
│   ├── hash-map/          # HashMap with chaining
│   ├── avl-tree/          # Self-balancing tree
│   └── dynamic-arrays/    # ArrayList and LinkedList
└── fundamental-algorithms/ # Basic algorithms
```

---

*This portfolio showcases my journey through fundamental computer science concepts, from basic data structures to complex algorithmic implementations.*
