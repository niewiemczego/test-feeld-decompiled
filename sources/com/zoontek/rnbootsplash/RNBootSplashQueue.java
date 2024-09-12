package com.zoontek.rnbootsplash;

import java.util.Vector;

public class RNBootSplashQueue<E> extends Vector<E> {
    public synchronized E shift() {
        if (size() == 0) {
            return null;
        }
        E elementAt = elementAt(0);
        removeElementAt(0);
        return elementAt;
    }

    public void push(E e) {
        addElement(e);
    }
}
