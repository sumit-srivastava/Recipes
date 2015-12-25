package com.java.se7.data.structures.tree;

/**
 * @author sumitsrivastava
 */

import com.java.se7.data.structures.common.Position;

/** An abstract class providing some functionality of the Tree interface. */
public abstract class AbstractTree<E> implements Tree<E> {

    @Override
    public boolean isInternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) > 0;
    }

    @Override
    public boolean isExternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) == 0;
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalArgumentException {
        return p == root();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
