package com.example.mathias.timebook.Database;

/**
 * Created by Niklas on 2015-11-09.
 * Abstract class for generic use of database.
 */
public abstract class DatabaseHandler<T> {

    abstract public boolean Add(T obj);
    abstract public boolean Update(T obj);
    abstract public T Get(String indata);
    abstract public boolean Delete(T obj);
}
