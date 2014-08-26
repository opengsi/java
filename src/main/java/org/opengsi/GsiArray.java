/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/.
 *
 * Copyright (C) 2014, Young-Mook Kang <youngmook@opengsi.org>.
 */
package org.opengsi;

import java.util.ArrayList;
import java.util.Collection;
import org.opengsi.interfaces.IGsiList;

/**
 *
 * @author Young-Mook Kang <youngmook@opengsi.org>
 * @param <E>
 * @since v0.1
 */
public class GsiArray<E extends Object> extends ArrayList<E> implements IGsiList<E> {

    /**
     *
     * @param theCapacity
     */
    public GsiArray(int theCapacity) {
        super(theCapacity);
    }

    /**
     *
     * @param theLength
     * @param theElement
     */
    public GsiArray(int theLength, E theElement) {
        super();
        for (int i = 0; i < theLength; i++) {
            this.add(theElement);
        }
    }

    /**
     *
     */
    public GsiArray() {
        super();
    }

    /**
     *
     * @param theCollection
     */
    public GsiArray(Collection<? extends E> theCollection) {
        super(theCollection);
    }
}
