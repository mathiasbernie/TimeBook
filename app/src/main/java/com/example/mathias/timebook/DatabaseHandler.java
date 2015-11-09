package com.example.mathias.timebook;

/**
 * Created by Niklas on 2015-11-09.
 * Abstract class for generic use of database.
 */
public abstract class DatabaseHandler<T> {

    abstract public boolean Add(T obj);
    abstract public boolean Update(T obj);
    abstract public T Get(T obj);
    abstract public boolean Delete(T obj);
    abstract public boolean DeleteIndex(int index);
}
