package org.scm.ojt.rest.utils;

/**
 * Created by Yoyok_T on 19/10/2018.
 */
public class ApiException extends Exception {
    private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
