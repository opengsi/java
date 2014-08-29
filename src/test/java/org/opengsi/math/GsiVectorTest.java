/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/.
 *
 * Copyright (C) 2014, Young-Mook Kang <youngmook@opengsi.org>.
 */
package org.opengsi.math;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.opengsi.interfaces.IGsiList;
import org.opengsi.math.interfaces.IGsiVector;

/**
 *
 * @author Young-Mook Kang <youngmook@opengsi.org>
 */
public class GsiVectorTest {

    IGsiVector v1;
    IGsiVector v2;
    IGsiVector v3;
    IGsiVector v4;
    IGsiVector v5;
    IGsiVector z;

    public GsiVectorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        v1 = new GsiVector(3);
        v2 = new GsiVector(3);
        v3 = new GsiVector(3);
        v4 = new GsiVector(4);
        v5 = new GsiVector(5);
        z = new GsiVector(3);

        // v1 = (1, 2, 3)
        v1.set(0, 1);
        v1.set(1, 2);
        v1.set(2, 3);

        // v2 = (4, 3, 6)
        v2.set(0, 4);
        v2.set(1, 3);
        v2.set(2, 6);

        // v3 = (1.1, 5.4, 7.8)
        v3.set(0, 1.1);
        v3.set(1, 5.4);
        v3.set(2, 7.8);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class GsiVector.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        v1.add(v2);
        assertTrue(5.0 == v1.get(0));
        assertTrue(5.0 == v1.get(1));
        assertTrue(9.0 == v1.get(2));

    }

    /**
     * Test of plus method, of class GsiVector.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        IGsiVector v = null;
        v = v1.plus(v2);
        assertTrue(5.0 == v.get(0));
        assertTrue(5.0 == v.get(1));
        assertTrue(9.0 == v.get(2));
    }

    /**
     * Test of subtract method, of class GsiVector.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        v1.subtract(v2);
        assertTrue(-3.0 == v1.get(0));
        assertTrue(-1.0 == v1.get(1));
        assertTrue(-3.0 == v1.get(2));
    }

    /**
     * Test of minus method, of class GsiVector.
     */
    @Test
    public void testMinus() {
        System.out.println("minus");
        IGsiVector v = v1.minus(v2);
        assertTrue(-3 == v.get(0));
        assertTrue(-1 == v.get(1));
        assertTrue(-3 == v.get(2));
    }

    /**
     * Test of dot method, of class GsiVector.
     */
    @Test
    public void testDot() throws Exception {
        System.out.println("dot");
        assertEquals(v1.dot(v2), 28, 1e-10);
        assertEquals(v3.dot(v2), 67.4, 1e-10);
    }

    /**
     * Test of dotProduct method, of class GsiVector.
     */
    @Test
    public void testDotProduct() throws Exception {
        System.out.println("dotProduct");
        assertEquals(v1.dotProduct(v2), 28, 1e-10);
        assertEquals(v3.dotProduct(v2), 67.4, 1e-10);
    }

    /**
     * Test of get method, of class GsiVector.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        assertTrue(v1.get(0) == 1);
        assertTrue(v1.get(1) == 2);
        assertTrue(v1.get(2) == 3);
    }

    /**
     * Test of getValue method, of class GsiVector.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        assertTrue(v1.getValue(0) == 1);
        assertTrue(v1.getValue(1) == 2);
        assertTrue(v1.getValue(2) == 3);
    }

    /**
     * Test of norm method, of class GsiVector.
     */
    @Test
    public void testNorm() {
        System.out.println("norm");
        assertEquals(v3.norm(), 9.5503926620846328425, 1e-10);

    }

    /**
     * Test of normSquared method, of class GsiVector.
     */
    @Test
    public void testNormSquared() {
        System.out.println("normSquared");
        assertEquals(v3.normSquared(), 91.21, 1e-10);
    }

    /**
     * Test of getNorm method, of class GsiVector.
     */
    @Test
    public void testGetNorm() {
        System.out.println("getNorm");
        assertEquals(v3.getNorm(), 9.5503926620846328425, 1e-10);

    }

    /**
     * Test of getNormSquared method, of class GsiVector.
     */
    @Test
    public void testGetNormSquared() {
        System.out.println("getNormSquared");
        assertEquals(v3.getNormSquared(), 91.21, 1e-10);

    }

    /**
     * Test of remove method, of class GsiVector.
     *
     * @Test public void testRemove_0args() { System.out.println("remove");
     * fail("The test case is a prototype.");
    }
     */
    /**
     * Test of remove method, of class GsiVector.
     *
     * @Test public void testRemove_int() { System.out.println("remove");
     * fail("The test case is a prototype.");
    }
     */
    /**
     * Test of resize method, of class GsiVector.
     *
     * @Test public void testResize() throws Exception {
     * System.out.println("resize"); fail("The test case is a prototype.");
    }
     */
    /**
     * Test of set method, of class GsiVector.
     */
    @Test
    public void testSet_IGsiVector() {
        System.out.println("set");
        v1.set(v3);
        v2.set(v3);
        for(int l = v1.size(), i=0; i<l;i++) {
            assertEquals(v1.getValue(i), v3.getValue(i), 0.0);
            assertEquals(v2.getValue(i), v3.getValue(i), 0.0);
            assertEquals(v1.getValue(i), v2.getValue(i), 0.0);
            v2.setValue(i, v3.getValue(i)+1);
            assertFalse(v2.getValue(i) == v3.getValue(i));
        }
    }

    /**
     * Test of set method, of class GsiVector.
     */
    @Test
    public void testSet_DoubleArr() {
        System.out.println("set");
        v1.set(v3.toArray());
        v2.set(v3.toArray());
        for(int l = v1.size(), i=0; i<l;i++) {
            assertEquals(v1.getValue(i), v3.getValue(i), 0.0);
            assertEquals(v2.getValue(i), v3.getValue(i), 0.0);
            assertEquals(v1.getValue(i), v2.getValue(i), 0.0);
            v2.setValue(i, v3.getValue(i)+1);
            assertFalse(v2.getValue(i) == v3.getValue(i));
        }
    }

    /**
     * Test of set method, of class GsiVector.
     */
    @Test
    public void testSet_GenericType() {
        System.out.println("set");
        List<Double> theVector = new Vector<Double>();
        theVector.add(1.1);
        theVector.add(2.4);
        theVector.add(5.75);
        v1.set(theVector);
        for(int l=v1.size(), i=0;i<l;i++) {
            assertEquals(v1.getValue(i), theVector.get(i), 0.0);
        }
    }

    /**
     * Test of set method, of class GsiVector.
     */
    @Test
    public void testSet_int_double() {
        System.out.println("set");
        Double theOrigValue = v1.getValue(0);
        v1.set(0, theOrigValue+0.1);
        assertEquals(v1.getValue(0), theOrigValue+0.1, 0.0);
    }



    /**
     * Test of setValue method, of class GsiVector.
     */
    @Test
    public void testSetValue_int_double() {
        System.out.println("setValue");
        Double theOrigValue = v1.getValue(0);
        v1.setValue(0, theOrigValue+0.1);
        assertEquals(v1.getValue(0), theOrigValue+0.1, 0.0);
    }

    /**
     * Test of size method, of class GsiVector.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        assertEquals(v1.size(), 3, 0);
        assertEquals(v2.size(), 3, 0);
        assertEquals(v3.size(), 3, 0);
        assertEquals(v4.size(), 4, 0);
        assertEquals(v5.size(), 5, 0);

    }

    /**
     * Test of toUnitVector method, of class GsiVector.
     *
    @Test
    public void testToUnitVector() {
        System.out.println("toUnitVector");

        fail("The test case is a prototype.");
    }*/

    /**
     * Test of toArray method, of class GsiVector.
     */
    @Test
    public void testToArray() {
        System.out.println("toArray");
        Double[] dv = v1.toArray();
        for (int i = 0, l = v1.size(); i < l; i++) {
            assertEquals(v1.get(i), dv[i], 0.0);
        }
        assertEquals(v1.size(), dv.length, 0.0);
    }

    /**
     * Test of toGsiArray method, of class GsiVector.
     */
    @Test
    public void testToGsiArray() {
        System.out.println("toGsiArray");
        IGsiList<Double> ga = v1.toGsiArray();
        for (int i = 0, l = v1.size(); i < l; i++) {
            assertEquals(v1.get(i), ga.get(i), 0.0);
        }
        assertEquals(v1.size(), ga.size(), 0.0);
        System.out.println(ga.getClass().getName());
        assertEquals(ga.getClass().getName(), "org.opengsi.GsiArray");
    }

    /**
     * Test of scale method, of class GsiVector.
     */
    @Test
    public void testScale() {
        System.out.println("scale");
        v1.scale(-0.1);
        assertEquals(v1.get(0), -0.1, 1e-10);
        assertEquals(v1.get(1), -0.2, 1e-10);
        assertEquals(v1.get(2), -0.3, 1e-10);
    }

    /**
     * Test of iterator method, of class GsiVector.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        Iterator<Double> theIterator = v1.iterator();
        int i = 0;
        while(theIterator.hasNext()) {
            assertEquals(v1.getValue(i), theIterator.next(), 0.0);
            i++;
        }
    }

    /**
     * Test of compareTo method, of class GsiVector.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        GsiVector gv = new GsiVector(v1);
        assertTrue(v1.compareTo(v2) < 0);
        assertTrue(v2.compareTo(v2) == 0);
        assertTrue(v2.compareTo(v1) > 0);
        assertTrue(v2 == v2);
        assertTrue(v1 == v1);
    }

    /**
     * Test of remove method, of class GsiVector.
     */
    @Test
    public void testRemove_int_int() {
        System.out.println("remove");

    }

}
