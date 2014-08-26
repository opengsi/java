/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/.
 *
 * Copyright (C) 2014, Young-Mook Kang <youngmook@opengsi.org>.
 */

package org.opengsi.math.interfaces;

/**
 *
 * @author Young-Mook Kang <youngmook@opengsi.org>
 */
public interface IGsiVector extends Iterable<Double>, Comparable<IGsiVector> {
    
    public void add(final IGsiVector theVector);
    
    public IGsiVector plus(final IGsiVector theVector);
    
    public void subtract(final IGsiVector theVector);
    
    public IGsiVector minus(final IGsiVector theVector);
        
    public double dot(final IGsiVector theVector);
    
    public IGsiVector cross(final IGsiVector theVector);           
    
}
