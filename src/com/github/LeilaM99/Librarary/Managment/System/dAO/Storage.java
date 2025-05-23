package com.github.LeilaM99.Librarary.Managment.System.dAO;
import java.io.*;
import com.github.LeilaM99.Librarary.Managment.System.dS.LinkedList;

public abstract class Storage<T> {

    protected final String fileName;

    public Storage(String fileName) {
        this.fileName = fileName;
    }

    public abstract void save(LinkedList<T> list);


    public abstract LinkedList<T> load();
}
