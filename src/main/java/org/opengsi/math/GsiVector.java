/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/.
 *
 * Copyright (C) 2014, Young-Mook Kang <youngmook@opengsi.org>.
 */
package org.opengsi.math;

import java.io.Serializable;
import java.util.Iterator;
import org.opengsi.GsiArray;
import org.opengsi.comsci.exceptions.MismatchedSizeException;
import org.opengsi.interfaces.IGsiList;
import org.opengsi.math.interfaces.IGsiVector;

/**
 *
 * @author Young-Mook Kang <youngmook@opengsi.org>
 * @since v0.1
 */
public class GsiVector implements IGsiVector, Cloneable, Serializable {

    // Compatible with 1.1
    private static final long serialVersionUID = -730543448252997925L;

    private static final int DEFAULT_VECTOR_SIZE = 3;
    private static final double DEFAULT_VECTOR_VALUE = 0.0;
    private static final double ZERO_VALUE = 0.0;
    private static final int MIN_LENGTH = 1;

    IGsiList<Double> itsElements = null;

    /**
     * Constructs a new GsiVector of the default length (3) with all vector
     * elements initialized to 0.
     */
    public GsiVector() {
        this.itsElements = new GsiArray<Double>(DEFAULT_VECTOR_SIZE);
        for (int i = 0; i < DEFAULT_VECTOR_SIZE; i++) {
            this.itsElements.add(DEFAULT_VECTOR_VALUE);
        }
    }

    /**
     * Constructs a new GsiVector of the specified length with all vector
     * elements initialized to 0.
     *
     * @param theLength the number of elements in this GsiVector.
     */
    public GsiVector(final int theLength) {
        this.itsElements = new GsiArray<Double>(theLength);
        for (int i = 0; i < theLength; i++) {
            this.itsElements.add(DEFAULT_VECTOR_VALUE);
        }
    }

    /**
     * Constructs a new GsiVector from the specified vector. The vector elements
     * are copied into this new GsiVector.
     *
     * @param theVector the source GsiVector for this new GsiVector.
     */
    public GsiVector(final GsiVector theVector) {
        int theLength = theVector.itsElements.size();
        this.itsElements = new GsiArray<Double>();
        for (int i = 0; i < theLength; i++) {
            this.itsElements.add(theVector.itsElements.get(i));
        }
    }

    public <T extends Iterable<Double>> GsiVector(final T theIterableType) {
        this.itsElements = new GsiArray<Double>();
        Iterator<Double> theIterator = theIterableType.iterator();
        while (theIterator.hasNext()) {
            this.itsElements.add(theIterator.next());
        }
    }

    @Override
    public void add(IGsiVector theVector) {
        int theLastIndex = Math.min(this.size(), theVector.size());
        for (int i = 0; i < theLastIndex; i++) {
            this.setValue(i, this.getValue(i) + theVector.getValue(i));
        }
    }

    @Override
    public IGsiVector plus(IGsiVector theVector) {
        IGsiVector theResultVector = new GsiVector(this);
        theResultVector.add(theVector);
        return theResultVector;
    }

    @Override
    public void subtract(IGsiVector theVector) {
        int theLastIndex = Math.min(this.size(), theVector.size());
        for (int i = 0; i < theLastIndex; i++) {
            this.setValue(i, this.getValue(i) - theVector.getValue(i));
        }
    }

    @Override
    public IGsiVector minus(IGsiVector theVector) {
        IGsiVector theResultVector = new GsiVector(this);
        theResultVector.subtract(theVector);
        return theResultVector;
    }

    @Override
    public final double dot(IGsiVector theVector) throws MismatchedSizeException {
        if (this.size() == theVector.size()) {
            double theDotProduct = 0.0;
            for (int i = 0, s = this.size(); i < s; i++) {
                theDotProduct += this.get(i) * theVector.get(i);
            }
            return theDotProduct;
        } else {
            throw new MismatchedSizeException("Input vector size is wrong.");
        }
    }

    @Override
    public final double dotProduct(IGsiVector theVector) throws MismatchedSizeException  {
        return this.dot(theVector);
    }

    @Override
    public final double get(int theIndex) {
        return this.itsElements.get(theIndex);
    }

    @Override
    public final double getValue(int theIndex) {
        return this.itsElements.get(theIndex);
    }

    @Override
    public final double norm() {
        return (Math.sqrt(this.getNormSquared()));
    }

    @Override
    public double normSquared() {
        return this.getNormSquared();
    }

    @Override
    public double getNorm() {
        return (Math.sqrt(this.getNormSquared()));
    }

    @Override
    public double getNormSquared() {
        double theSquares = 0.0;
        for (int i = 0, l = this.size(); i < l; i++) {
            theSquares += this.getValue(i) * this.getValue(i);
        }
        return theSquares;
    }

    @Override
    public void remove() {
        int theLength = this.size();
        if (theLength > 1) {
            this.itsElements.remove(theLength - 1);
        } else {
            this.itsElements.clear();
            this.itsElements.add(ZERO_VALUE);
        }
    }

    @Override
    public void remove(int theIndex) {
        int theLength = this.size();
        if (theIndex < theLength) {
            this.itsElements.remove(theIndex);
        } else {
            this.itsElements.clear();
            this.itsElements.add(ZERO_VALUE);
        }
    }

    @Override
    public void resize(int theLength)  throws MismatchedSizeException {
        if (theLength < MIN_LENGTH) {
            throw new MismatchedSizeException("Input length is low");
        } else {
            this.itsElements = (IGsiList) (this.itsElements.subList(0, theLength));
        }
    }

    @Override
    public void set(IGsiVector theVector) {
        this.itsElements = theVector.toGsiArray();
    }

    @Override
    public void set(Double[] theDoubleArray) {
        IGsiList<Double> theClone = new GsiArray<Double>();
        for (int i = 0, l = theDoubleArray.length; i < l; i++) {
            theClone.add(theDoubleArray[i]);
        }
        this.itsElements = theClone;
    }

    @Override
    public <T extends Iterable<Double>> void set(T theIterableType) {
        IGsiList<Double> theClone = new GsiArray<Double>();
        Iterator<Double> theIterator = theIterableType.iterator();
        while (theIterator.hasNext()) {
            theClone.add(theIterator.next());
        }
        this.itsElements = theClone;
    }

    @Override
    public void set(int theIndex, double theValue) {
        this.itsElements.set(theIndex, theValue);
    }

    @Override
    public Double set(int theIndex) {
        return this.itsElements.get(theIndex);
    }

    @Override
    public void setValue(int theIndex, double theValue) {
        this.itsElements.set(theIndex, theValue);
    }

    @Override
    public Double setValue(int theIndex) {
        return this.itsElements.get(theIndex);
    }

    @Override
    public int size() {
        return this.itsElements.size();
    }

    /**
     * @deprecated Coming soon this function
     */
    @Override
    public IGsiVector toUnitVector() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double[] toArray() {
        Double[] theDoubleArray = null;
        return this.itsElements.toArray(theDoubleArray);
    }

    @Override
    public IGsiList<Double> toGsiArray() {
        IGsiList<Double> theClone = new GsiArray<Double>();
        Iterator<Double> theIterator = this.itsElements.iterator();
        while (theIterator.hasNext()) {
            theClone.add(theIterator.next());
        }
        return theClone;
    }

    @Override
    public void scale(double theScalarValue) {
        for (int i = 0, l = this.size(); i < l; i++) {
            this.set(i, this.get(i) * theScalarValue);
        }
    }

    @Override
    public Iterator<Double> iterator() {
        return this.itsElements.iterator();
    }

    @Override
    public int compareTo(IGsiVector theVector) {
        int theLess = -1, theGreater = 1, theEqual = 0;
        if (this.size() == theVector.size()) {
            for (int i = 0, l = this.size(); i < l; i++) {
                if (this.get(i) > theVector.get(i)) {
                    return theGreater;
                } else if (this.get(i) < theVector.get(i)) {
                    return theLess;
                }
            }
            return theEqual;
        } else {
            int theMinLength = Math.min(this.size(), theVector.size());
            for (int i = 0; i < theMinLength; i++) {
                if (this.get(i) > theVector.get(i)) {
                    return theGreater;
                } else if (this.get(i) < theVector.get(i)) {
                    return theLess;
                }
            }
            if (this.size() > theVector.size()) {
                return theGreater;
            } else {
                return theLess;
            }
        }
    }

    /**
     * @deprecated Coming soon this function
     */
    @Override
    public void remove(int theBegin, int theLength) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
