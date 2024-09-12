package com.facebook.react.fabric.mounting.mountitems;

public abstract class DispatchCommandMountItem implements MountItem {
    private int mNumRetries = 0;

    public void incrementRetries() {
        this.mNumRetries++;
    }

    public int getRetries() {
        return this.mNumRetries;
    }
}
