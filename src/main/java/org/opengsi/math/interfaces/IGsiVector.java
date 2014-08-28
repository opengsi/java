/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/.
 *
 * Copyright (C) 2014, Young-Mook Kang <youngmook@opengsi.org>.
 */
package org.opengsi.math.interfaces;

import java.util.Collection;
import java.util.List;
import org.opengsi.comsci.exceptions.MismatchedSizeException;
import org.opengsi.interfaces.IGsiList;

/**
 *
 * @author Young-Mook Kang <youngmook@opengsi.org>
 */
public interface IGsiVector extends Iterable<Double>, Comparable<IGsiVector> {

    public void add(final IGsiVector theVector);

    public IGsiVector plus(final IGsiVector theVector);

    public void subtract(final IGsiVector theVector);

    public IGsiVector minus(final IGsiVector theVector);

    public double dot(final IGsiVector theVector) throws MismatchedSizeException;

    public double dotProduct(final IGsiVector theVector) throws MismatchedSizeException;

    public double get(final int theIndex);

    public double getValue(final int theIndex);

    public double norm();

    public double getNorm();

    public double normSquared();

    public double getNormSquared();

    public void remove();

    public void remove(final int theIndex);

    public void remove(final int theBegin, final int theLength);

    public void resize(final int theSize) throws MismatchedSizeException;

    public void set(final IGsiVector theVector);

    public void set(final Double[] theDoubleArray);

    public <T extends Iterable<Double>> void set(final T theIterableType);

    public void set(final int theIndex, final double theValue);

    public Double set(final int theIndex);

    public void setValue(final int theIndex, final double theValue);

    public Double setValue(final int theIndex);

    public int size();

    public void scale(double theScalarValue);

    public IGsiVector toUnitVector();

    public Double[] toArray();

    public IGsiList<Double> toGsiArray();

}
