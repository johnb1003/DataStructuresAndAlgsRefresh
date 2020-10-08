# Data Structures

## Importance

Different data structures present different complexities for the various data set operations (search, access, insert, delete)



## Array

- Search: O(n)

- Access: O(1)

- Insert:
    - Append: O(1)
    - Replace: O(1)
    - Insert: O(n) - due to shifting

- Delete:
    - By index: O(1)
    - By value: O(n)



## Dynamic Array

Similar to array but has dynamic resizing. If size is not large enough to add an element, array contents are copied to a new array of double the original size, then new element is added. Solves overflow, still allows for unused memory allocation.

- Search: O(n)

- Access: O(1)

- Insert: O(n) - due to shifting

- Delete: O(n)



## Linked List

Series of nodes with a value and a "next" pointer. Create a Node class with value and node attributes.

- Search: O(n)

- Access: O(n)

- Insert: O(n) for adding in order. O(1) for adding to head

- Delete: O(n)

## Doubly-Linked List

Same as Linked List but each node holds 2 pointer nodes rather than 1 - previous and next. (attributes = previous, next, value).

- Search: O(n)

- Access: O(n)

- Insert: O(n) for adding in order. O(1) for adding to head

- Delete: O(n)



## Hash Map

Based on key and value pairs. Hash map takes key, inputs it into hashing algorithm, then generates an index and stores the value at the generated index of an array. Each index has a linked list of elements for elements that create the same hash index.




## Stack

Simple LIFO collection (Last-in ~push~ first-out ~pop~). Can be implemented easily with LinkedList(add and remove from head) or array.



## Queue

Simple FIFO collection (First-in ~push~ first-out ~pop~). Can be implemented easily with LinkedList(add to tail, remove from head) or array.
Priority queue can be useful.





# Collections

## Underlying Implementaions in Java

- ArrayList => Dynamic array

- LinkedList => LinkedList

- HashMap => HashTable

- Set => HashTable

- Stack => Dynamic array

- Queue => Dynamic array

- Priority queue => Dynamic array



## ArrayList

Good for searching and retrieving data, bad for updating and deleting.



## LinkedList

Good for inserting and deleting (to beginning or end). Bad for searching and retrieving.



## HashMap

