# Graph Algorithms - Topological Sorting

## Overview
Implementation of topological sorting for directed acyclic graphs (DAGs) using Kahn's algorithm.

## Features
- **Topological Sorting**: Finds valid ordering of vertices in a DAG
- **Cycle Detection**: Identifies if graph contains cycles
- **Lexicographic Ordering**: Produces smallest lexicographic order
- **Efficient Input Processing**: Fast input handling for competitive programming

## Usage
```bash
javac Toposort.java
echo -e "3 2\n1 2\n2 3" | java Toposort
```

## Implementation Details
- **Time Complexity**: O(V + E log V)
- **Space Complexity**: O(V + E)

## Files
- `Toposort.java` - Main application with topological sorting
