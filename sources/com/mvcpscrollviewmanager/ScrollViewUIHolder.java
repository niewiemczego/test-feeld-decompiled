package com.mvcpscrollviewmanager;

import android.view.View;

public class ScrollViewUIHolder {
    private int currentScrollY = 0;
    private View firstVisibleView;
    private int prevFirstVisibleTop = 0;
    private int rnHandle = 0;

    public int getRnHandle() {
        return this.rnHandle;
    }

    public void setRnHandle(int i) {
        this.rnHandle = i;
    }

    public int getPrevFirstVisibleTop() {
        return this.prevFirstVisibleTop;
    }

    public void setPrevFirstVisibleTop(int i) {
        this.prevFirstVisibleTop = i;
    }

    public View getFirstVisibleView() {
        return this.firstVisibleView;
    }

    public void setFirstVisibleView(View view) {
        this.firstVisibleView = view;
    }

    public int getCurrentScrollY() {
        return this.currentScrollY;
    }

    public void setCurrentScrollY(int i) {
        this.currentScrollY = i;
    }
}
