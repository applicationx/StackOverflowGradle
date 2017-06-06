package com.stackoverflow.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by jonasd on 2017-06-05.
 */
public class ConcurrentModificationList {

    AtomicReference<List<String>> atomicStringList = new AtomicReference<>(new CopyOnWriteArrayList<>());
    private List<String> stringList = new ArrayList<>();

    public int getSize() {
        return atomicStringList.get().size();
    }
    public void addToList(String name) {
        List<String> previousList;
        List<String> newList;
        do {
            previousList = atomicStringList.get();
            newList = new CopyOnWriteArrayList<>(previousList);
             newList.add(name);
        } while (!atomicStringList.compareAndSet(previousList, newList));
        stringList.add(name);
    }

    public void removeFromList(int numbersOfOccurencies)  {

        List<String> previousList;
        List<String> newList;
        do {
            while ((previousList = atomicStringList.get()).size() < numbersOfOccurencies) {
                try {
                    Thread.sleep(10l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            newList = previousList.subList(numbersOfOccurencies -1, previousList.size() -1);
        } while (!atomicStringList.compareAndSet(previousList, newList));
    }

}
