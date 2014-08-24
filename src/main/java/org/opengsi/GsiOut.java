/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/.
 *
 * Copyright (C) 2014, Young-Mook Kang <youngmook@opengsi.org>.
 */

package org.opengsi;

/**
 *
 * @author Young-Mook Kang <youngmook@opengsi.org>
 * @since  v0.1
 */
public class GsiOut {

    /**
     * 
     * @param theObjects array of objects
     */
    public static void print(Object... theObjects) {
        if(theObjects.length > 0) {
            for(int i = 0, theLength = theObjects.length-1;i< theLength;i++) {
                System.out.print(theObjects[i]);
                System.out.print(" ");
            }
            System.out.print(theObjects[theObjects.length-1]);
        }
        System.out.print("\n");
    }   
    
    /**
     * 
     * @param theObjects array of objects
     */
    public static void printWarning(Object... theObjects) {
        if(theObjects.length > 0) {
            for(int i = 0, theLength = theObjects.length-1;i< theLength;i++) {
                System.err.print(theObjects[i]);
                System.err.print(" ");
            }
            System.err.print(theObjects[theObjects.length-1]);
        }
        System.err.print("\n");
    }     
}
