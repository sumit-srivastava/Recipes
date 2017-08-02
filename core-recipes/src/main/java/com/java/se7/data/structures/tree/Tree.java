package com.java.se7.data.structures.tree;

/**
 * @author sumitsrivastava
 */

import com.java.se7.data.structures.common.Position;

import java.util.Iterator;
/** nonlinear data structure - tree */

/** A tree is an abstract data type that stores elements hierarchically. With the exception of the top element,
 *  each element in a tree has a parent element and zero or more children elements. */

/** A tree is ordered if there is a meaningful linear order among the children of each node */

/** Depth - Let p be a position within tree T. The depth of p is the number of ancestors of p, other than p itself. */

/** linear data structure - arrays or linked lists */
/** An interface for a tree where nodes can have an arbitrary number of children. */
public interface Tree<E> extends Iterable<E> {

    Position<E> root();
    Position<E> parent(Position<E> p) throws IllegalArgumentException;
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;
    int numChildren(Position<E> p) throws IllegalArgumentException;
    int depth(Position<E> p);
    int height(Position<E> p);
    boolean isInternal(Position<E> p) throws IllegalArgumentException;
    boolean isExternal(Position<E> p) throws IllegalArgumentException;
    boolean isRoot(Position<E> p) throws IllegalArgumentException;
    int size();
    boolean isEmpty();
    Iterator<E> iterator();
    Iterable<Position<E>> positions();
}
