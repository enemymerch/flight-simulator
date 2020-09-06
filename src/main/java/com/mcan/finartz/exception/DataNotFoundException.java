package com.mcan.finartz.exception;

import org.hibernate.ObjectNotFoundException;

import java.io.Serializable;

public class DataNotFoundException extends ObjectNotFoundException {
    public DataNotFoundException() {
        super(404L,"com.mcan.finartz.data.not.found");
    }
}
