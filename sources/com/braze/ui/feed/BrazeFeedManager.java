package com.braze.ui.feed;

import com.braze.ui.feed.listeners.BrazeDefaultFeedClickActionListener;
import com.braze.ui.feed.listeners.IFeedClickActionListener;

public class BrazeFeedManager {
    private static volatile BrazeFeedManager sInstance;
    private IFeedClickActionListener mCustomFeedClickActionListener;
    private final IFeedClickActionListener mDefaultFeedClickActionListener = new BrazeDefaultFeedClickActionListener();

    public static BrazeFeedManager getInstance() {
        if (sInstance == null) {
            synchronized (BrazeFeedManager.class) {
                if (sInstance == null) {
                    sInstance = new BrazeFeedManager();
                }
            }
        }
        return sInstance;
    }

    public void setFeedCardClickActionListener(IFeedClickActionListener iFeedClickActionListener) {
        this.mCustomFeedClickActionListener = iFeedClickActionListener;
    }

    public IFeedClickActionListener getFeedCardClickActionListener() {
        IFeedClickActionListener iFeedClickActionListener = this.mCustomFeedClickActionListener;
        return iFeedClickActionListener != null ? iFeedClickActionListener : this.mDefaultFeedClickActionListener;
    }
}
