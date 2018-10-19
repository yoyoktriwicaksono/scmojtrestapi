package org.scm.ojt.rest.utils;

/**
 * Created by Yoyok_T on 19/10/2018.
 */
public class NotFoundException extends ApiException {
    private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
