/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/.
 *
 * Copyright (C) 2014, youngmook.
 */

package org.opengsi.comsci.exceptions;

/**
 *
 * @author youngmook
 */
public class MismatchedSizeException extends Exception {

    /**
     * Creates a new instance of <code>MismatchedSizeException</code> without
     * detail message.
     */
    public MismatchedSizeException() {
    }

    /**
     * Constructs an instance of <code>MismatchedSizeException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public MismatchedSizeException(String msg) {
        super(msg);
    }
}
