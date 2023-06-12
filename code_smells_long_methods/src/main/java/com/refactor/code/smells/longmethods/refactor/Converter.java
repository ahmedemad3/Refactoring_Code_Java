package com.refactor.code.smells.longmethods.refactor;

public interface Converter<S, T> {
    T convert(S source);
}
