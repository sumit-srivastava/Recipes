package com.java.se7.data.structures.tree;

/**
 * @author sumitsrivastava
 */

import com.java.se7.data.structures.common.Position;

import java.util.ArrayList;
import java.util.List;

/** An abstract base class providing some base functionality of the BinaryTree interface. */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

    @Override
    public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
        Position<E> parent = parent(p);
        if (parent == null) return null;
        if (p == left(parent))
            return right(parent);
        else
            return left(parent);
    }

    public int numChildren(Position<E> p) {
        int count = 0;
        if (left(p) != null)
            count++;
        if (right(p) != null)
            count++;
        return count;
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        List<Position<E>> snapshot = new ArrayList<>(2);
        if (left(p) != null)
            snapshot.add(left(p));
        if (right(p) != null)
            snapshot.add(right(p));
        return snapshot;
    }
}
