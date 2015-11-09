package com.example.mathias.timebook.Manager;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niklas on 2015-11-09.
 * Generic containerclass for use of lists with functionality for adding,
 * updating, getting and deleting objects.
 */
public class ListManager<T> {

    ArrayList<T> m_list;

    /*
    * Constructor
    */
    public ListManager(){
        m_list = new ArrayList<T>();
    }

    /*
    * Get object T by index.
    */
    public T Get(int index){
        return m_list.get(index);
    }

    /*
    * Adding objects to list.
    */
    public void Add(T obj){
        m_list.add(obj);
    }

    /*
    * Update object at a specific index in the list.
    */
    public void Update(int index, T obj){
        m_list.add(index, obj);
    }

    /*
    * Delete all in the list.
    */
    public void DeleteAll(){
        m_list.clear();
    }

    /*
    * Delete particular object in the list.
    */
    public void Delete(T obj){
        m_list.remove(obj);
    }

    /*
    * Delete at a specific index in the list.
    */
    public void Delete(int index){
        m_list.remove(index);
    }

    /*
    * Get list size.
    */
    public int Size(){
        return m_list.size();
    }

}
