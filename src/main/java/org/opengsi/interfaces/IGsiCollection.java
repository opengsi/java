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

/**
 *
 * @author Young-Mook Kang <youngmook@opengsi.org>
 * @param <E>
 * @since  v0.1
 */
public interface IGsiCollection<E extends Object> extends Collection<E> {

    @Override
    public void clear();

    @Override
    public boolean retainAll(Collection<?> clctn);

    @Override
    public boolean removeAll(Collection<?> clctn);

    @Override
    public boolean addAll(Collection<? extends E> clctn);

    @Override
    public boolean containsAll(Collection<?> clctn);

    @Override
    public boolean remove(Object o);

    @Override
    public boolean add(E e);

    @Override
    public <T> T[] toArray(T[] ts);

    @Override
    public Object[] toArray();

    @Override
    public Iterator<E> iterator();

    @Override
    public boolean contains(Object o);

    @Override
    public boolean isEmpty();

    @Override
    public int size();

    @Override
    public String toString();

    @Override
    public boolean equals(Object o);

    @Override
    public int hashCode();

}
