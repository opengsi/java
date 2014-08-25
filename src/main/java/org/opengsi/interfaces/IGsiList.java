/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/.
 *
 * Copyright (C) 2014, Young-Mook Kang <youngmook@opengsi.org>.
 */
package org.opengsi.interfaces;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Young-Mook Kang <youngmook@opengsi.org>
 * @param <E>
 * @since  v0.1
 */
public interface IGsiList<E extends Object> extends IGsiCollection<E>, List<E> {

    @Override
    public List<E> subList(int theBeginIndex, int theEndIndex);

    @Override
    public ListIterator<E> listIterator(int i);
    
    @Override
    public ListIterator<E> listIterator();

    @Override
    public int lastIndexOf(Object theObject);

    @Override
    public int indexOf(Object theObject);

    @Override
    public E remove(int i);

    @Override
    public void add(int i, E theElement);

    @Override
    public E set(int i, E theElement);

    @Override
    public E get(int i);

    @Override
    public void clear();

    @Override
    public boolean retainAll(Collection<?> theCollection);

    @Override
    public boolean removeAll(Collection<?> theCollection);

    @Override
    public boolean addAll(int i, Collection<? extends E> theCollection);

    @Override
    public boolean addAll(Collection<? extends E> theCollection);

    @Override
    public boolean containsAll(Collection<?> theCollection);

    @Override
    public boolean remove(Object theObject);

    @Override
    public boolean add(E theElement);

    @Override
    public <T> T[] toArray(T[] ts);

    @Override
    public Object[] toArray();

    @Override
    public Iterator<E> iterator();

    @Override
    public boolean contains(Object theObject);

    @Override
    public boolean isEmpty();

    @Override
    public int size();

    @Override
    public String toString();

    @Override
    public boolean equals(Object theObject);

    @Override
    public int hashCode();

}
