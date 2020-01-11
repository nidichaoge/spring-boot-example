package com.mouse.springboot.log.logback.log;

import java.util.function.Supplier;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-01-11
 * @description 惰性日志
 */
public class LazyLogger {

    private final Supplier<?> supplier;

    public static LazyLogger lazy(Supplier<?> supplier) {
        return new LazyLogger(supplier);
    }

    private LazyLogger(Supplier<?> supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return String.valueOf(supplier.get());
    }

}
