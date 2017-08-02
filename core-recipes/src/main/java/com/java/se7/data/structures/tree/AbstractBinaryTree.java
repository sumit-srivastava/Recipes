package com.java.se7.data.structures.tree;

/**
 * @author sumitsrivastava
 */

import com.java.se7.data.structures.common.Position;

import java.util.ArrayList;
import java.util.List;

/** An abstract base class providing some base functionality of the BinaryTree interface. */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

    // O(1)
    @Override
    public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
        Position<E> parent = parent(p);
        if (parent == null) return null;
        if (p == left(parent))
            return right(parent);
        else
            return left(parent);
    }

    // O(1)
    public int numChildren(Position<E> p) {
        int count = 0;
        if (left(p) != null)
            count++;
        if (right(p) != null)
            count++;
        return count;
    }

    // O(1)
    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        List<Position<E>> snapshot = new ArrayList<>(2);
        if (left(p) != null)
            snapshot.add(left(p));
        if (right(p) != null)
            snapshot.add(right(p));
        return snapshot;
    }

    /**
     *  Algorithm: inorder(p):
     *      if p has a left child lc then
     *          inorder(lc)                 {recursively traverse the left subtree of p}
     *      perform the "visit" action for position p
     *      if p has a right child rc then
     *          inorder(rc)                 {recursively traverse the right subtree of p}
     *
     * @param p         Position serving as the root of a subtree
     * @param snapshot  a list to which results are appended
     */
    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        if (left(p) != null) {
            inorderSubtree(left(p), snapshot);
        }
        snapshot.add(p);
        if (right(p) != null) {
            inorderSubtree(right(p), snapshot);
        }
    }

    /**
     * Returns an iterable collection of positions of the tree, reported in inorder.
     *
     * @return iterable collection of the tree's positions in inorder
     */
    public Iterable<Position<E>> inorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            inorderSubtree(root(), snapshot);
        }
        return snapshot;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return inorder();
    }
}
