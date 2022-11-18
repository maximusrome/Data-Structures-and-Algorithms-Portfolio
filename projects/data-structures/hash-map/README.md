# HashMap Implementation

## Overview
A custom HashMap implementation with chaining collision resolution, dynamic resizing, and load factor management.

## Features
- **Chaining Collision Resolution**: Uses linked lists to handle hash collisions
- **Dynamic Resizing**: Automatically resizes when load factor exceeds 0.75
- **Prime Number Table Sizes**: Uses sequence of prime numbers for better distribution
- **Generic Implementation**: Supports any comparable key type

## Implementation Details
- **Time Complexity**: O(1) average case for insert, get, remove
- **Space Complexity**: O(n) where n is number of entries
- **Load Factor**: 0.75 threshold for resizing

## Files
- `MyHashMap.java` - Main HashMap implementation
- `MyMap.java` - Interface for map operations
- `Entry.java` - Key-value pair representation
