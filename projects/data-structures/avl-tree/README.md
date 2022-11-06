# AVL Tree Implementation

## Overview
A self-balancing binary search tree implementation that maintains height balance through automatic rotations.

## Features
- **Self-Balancing**: Automatically maintains height balance
- **Height Tracking**: Each node stores its height for balance checking
- **Automatic Rotations**: Single and double rotations as needed
- **Generic Implementation**: Supports any comparable key type

## Implementation Details
- **Time Complexity**: O(log n) guaranteed for all operations
- **Space Complexity**: O(n) where n is number of nodes
- **Balance Factor**: ±1 allowed imbalance

## Files
- `AVLTreeMap.java` - Main AVL tree implementation
- `BSTMap.java` - Base binary search tree class
- `MyMap.java` - Interface for map operations
- `Node.java` - Tree node with height tracking
