package com.java.se7.data.structures.tree;

import com.java.se7.data.structures.common.Position;

/**
 * A binary tree is an ordered tree with the following properties:

    1. Every node has at most two children.
    2. Each child node is labeled as being either a left child or a right child.
    3. A left child precedes a right child in the order of children of a node.

   Left subtree or right subtree:
   The subtree rooted at a left or right child of an internal node v is called a left subtree or
   right subtree, respectively, of v.

   Proper binary tree:
   A binary tree is proper if each node has either zero or two children. Some people also refer to such trees as
   being full binary trees. Thus, in a proper binary tree, every internal node has exactly two children. A binary
   tree that is not proper is improper.


   PROPERTIES OF BINARY TREES:
   Let T be a nonempty binary tree, and let n, nE, nI, and h denote the number of nodes, number of external nodes,
   number of internal nodes, and height of T, respectively. Then T has the following properties:

   1. h + 1 ≤ n ≤ 2pow(h+1) − 1
   2. 1 ≤ nE ≤ 2pow(h)
   3. h ≤ nI ≤ 2pow(h) − 1
   4. log(n + 1) − 1 ≤ h ≤ n − 1

   Also, if T is proper, then T has the following properties:

   1. 2h + 1 ≤ n ≤ 2pow(h+1) − 1
   2. h + 1 ≤ nE ≤ 2pow(h)
   3. h ≤ nI ≤ 2pow(h) − 1
   4. log(n + 1) − 1 ≤ h ≤ (n − 1)/2

   In a nonempty proper binary tree T, with nE external nodes and nI internal nodes, we have nE = nI + 1.



 */

/** An interface of Binary tree in which each node has at most two children. */
public interface BinaryTree<E> extends Tree<E> {

    /** Returns the Position of p's left child (or null if no child exists). */
    Position<E> left(Position<E> p) throws IllegalArgumentException;

    /** Returns the Position of p's right child (or null if no child exists). */
    Position<E> right(Position<E> p) throws IllegalArgumentException;

    /** Returns the Position of p's sibling (or null if no sibling exists). */
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}
