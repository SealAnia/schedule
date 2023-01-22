package com.example.schedule.service;

import java.util.List;

public interface DefaultService<T> {

    List<T> getAll();
    T getById(Long id);
    T addNewOrUpdate(T t);
    void delete(Long id);

}
