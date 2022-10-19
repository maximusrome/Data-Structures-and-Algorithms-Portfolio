# Expression Calculator

## Overview
A command-line calculator that evaluates mathematical expressions using infix-to-postfix conversion and stack-based evaluation.

## Features
- **Infix to Postfix Conversion**: Implements the Shunting Yard algorithm
- **Operator Precedence**: Handles all standard mathematical operators
- **Parentheses Support**: Full support for nested parentheses
- **Error Handling**: Comprehensive input validation

## Usage
```bash
java IntCalculator "<expression>"
```

## Implementation Details
- **Time Complexity**: O(n) where n is expression length
- **Space Complexity**: O(n) for stack operations

## Files
- `IntCalculator.java` - Main calculator application
- `MyStack.java` - Stack interface
- `MyArrayList.java` - Dynamic array implementation
