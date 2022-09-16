package com.pichincha.mvc.service;

import java.util.List;

public interface BaseService<T, I> {
    T getById(I recordId);

    List<T> getAll();

    I create(T data);

    T update(I recordId, T data);

    void deleteById(I recordId);
}
