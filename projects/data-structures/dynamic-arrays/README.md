# Dynamic Arrays and Linked Lists

## Overview
Custom implementations of fundamental data structures: ArrayList (dynamic array) and LinkedList (singly linked list).

## Features

### MyArrayList
- **Dynamic Resizing**: Automatically grows when capacity is exceeded
- **Generic Implementation**: Supports any data type
- **Efficient Access**: O(1) random access to elements

### MyLinkedList
- **Singly Linked Structure**: Each node points to the next
- **Tail Pointer**: Efficient append operations
- **Generic Implementation**: Supports any data type

## Implementation Details

### MyArrayList
- **Access**: O(1)
- **Insert (end)**: O(1) amortized
- **Insert (middle)**: O(n)

### MyLinkedList
- **Access**: O(n)
- **Insert (end)**: O(1)
- **Insert (middle)**: O(n)

## Files
- `MyArrayList.java` - Dynamic array implementation
- `MyLinkedList.java` - Singly linked list implementation
- `MyList.java` - Common interface for both implementations
