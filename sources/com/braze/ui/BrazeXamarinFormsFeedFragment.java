package com.braze.ui;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.view.GestureDetectorCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.braze.Braze;
import com.braze.IBraze;
import com.braze.enums.CardCategory;
import com.braze.events.FeedUpdatedEvent;
import com.braze.events.IEventSubscriber;
import com.braze.support.BrazeLogger;
import com.braze.ui.adapters.BrazeListAdapter;
import java.util.ArrayList;
import java.util.EnumSet;

public class BrazeXamarinFormsFeedFragment extends ListFragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final long AUTO_HIDE_REFRESH_INDICATOR_DELAY_MS = 2500;
    private static final int MAX_FEED_TTL_SECONDS = 60;
    private static final int NETWORK_PROBLEM_WARNING_MS = 5000;
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) BrazeXamarinFormsFeedFragment.class);
    /* access modifiers changed from: private */
    public int currentCardIndexAtBottomOfScreen;
    /* access modifiers changed from: private */
    public BrazeListAdapter mAdapter;
    private IBraze mBraze;
    private EnumSet<CardCategory> mCategories;
    private LinearLayout mEmptyFeedLayout;
    private RelativeLayout mFeedRootLayout;
    /* access modifiers changed from: private */
    public SwipeRefreshLayout mFeedSwipeLayout;
    private IEventSubscriber<FeedUpdatedEvent> mFeedUpdatedSubscriber;
    private GestureDetectorCompat mGestureDetector;
    /* access modifiers changed from: private */
    public ProgressBar mLoadingSpinner;
    private final Handler mMainThreadLooper = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public LinearLayout mNetworkErrorLayout;
    private final Runnable mShowNetworkError = new Runnable() {
        public void run() {
            if (BrazeXamarinFormsFeedFragment.this.mLoadingSpinner != null) {
                BrazeXamarinFormsFeedFragment.this.mLoadingSpinner.setVisibility(8);
            }
            if (BrazeXamarinFormsFeedFragment.this.mNetworkErrorLayout != null) {
                BrazeXamarinFormsFeedFragment.this.mNetworkErrorLayout.setVisibility(0);
            }
        }
    };
    private boolean mSkipCardImpressionsReset;
    private View mTransparentFullBoundsContainerView;
    /* access modifiers changed from: private */
    public int previousVisibleHeadCardIndex;

    public void onAttach(Context context) {
        super.onAttach(context);
        this.mBraze = Braze.getInstance(context);
        if (this.mAdapter == null) {
            this.mAdapter = new BrazeListAdapter(context, R.id.tag, new ArrayList());
            this.mCategories = CardCategory.getAllCategories();
        }
        setRetainInstance(true);
        this.mGestureDetector = new GestureDetectorCompat(context, new FeedGestureListener());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.com_braze_feed, viewGroup, false);
        this.mNetworkErrorLayout = (LinearLayout) inflate.findViewById(R.id.com_braze_feed_network_error);
        this.mLoadingSpinner = (ProgressBar) inflate.findViewById(R.id.com_braze_feed_loading_spinner);
        this.mEmptyFeedLayout = (LinearLayout) inflate.findViewById(R.id.com_braze_feed_empty_feed);
        this.mFeedRootLayout = (RelativeLayout) inflate.findViewById(R.id.com_braze_feed_root);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) inflate.findViewById(R.id.braze_feed_swipe_container);
        this.mFeedSwipeLayout = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(this);
        this.mFeedSwipeLayout.setEnabled(false);
        this.mFeedSwipeLayout.setColorSchemeResources(R.color.com_braze_newsfeed_swipe_refresh_color_1, R.color.com_braze_newsfeed_swipe_refresh_color_2, R.color.com_braze_newsfeed_swipe_refresh_color_3, R.color.com_braze_newsfeed_swipe_refresh_color_4);
        this.mTransparentFullBoundsContainerView = inflate.findViewById(R.id.com_braze_feed_transparent_full_bounds_container_view);
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.mSkipCardImpressionsReset) {
            this.mSkipCardImpressionsReset = false;
        } else {
            this.mAdapter.resetCardImpressionTracker();
            BrazeLogger.d(TAG, "Resetting card impressions.");
        }
        LayoutInflater from = LayoutInflater.from(getActivity());
        ListView listView = getListView();
        listView.addHeaderView(from.inflate(R.layout.com_braze_feed_header, (ViewGroup) null));
        listView.addFooterView(from.inflate(R.layout.com_braze_feed_footer, (ViewGroup) null));
        this.mFeedRootLayout.setOnTouchListener(new BrazeXamarinFormsFeedFragment$$ExternalSyntheticLambda1(this));
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                BrazeXamarinFormsFeedFragment.this.mFeedSwipeLayout.setEnabled(i == 0);
                if (i2 != 0) {
                    int i4 = i - 1;
                    if (i4 > BrazeXamarinFormsFeedFragment.this.previousVisibleHeadCardIndex) {
                        BrazeXamarinFormsFeedFragment.this.mAdapter.batchSetCardsToRead(BrazeXamarinFormsFeedFragment.this.previousVisibleHeadCardIndex, i4);
                    }
                    int unused = BrazeXamarinFormsFeedFragment.this.previousVisibleHeadCardIndex = i4;
                    int unused2 = BrazeXamarinFormsFeedFragment.this.currentCardIndexAtBottomOfScreen = i + i2;
                }
            }
        });
        this.mTransparentFullBoundsContainerView.setOnTouchListener(new BrazeXamarinFormsFeedFragment$$ExternalSyntheticLambda2());
        this.mBraze.removeSingleSubscription(this.mFeedUpdatedSubscriber, FeedUpdatedEvent.class);
        BrazeXamarinFormsFeedFragment$$ExternalSyntheticLambda3 brazeXamarinFormsFeedFragment$$ExternalSyntheticLambda3 = new BrazeXamarinFormsFeedFragment$$ExternalSyntheticLambda3(this, listView);
        this.mFeedUpdatedSubscriber = brazeXamarinFormsFeedFragment$$ExternalSyntheticLambda3;
        this.mBraze.subscribeToFeedUpdates(brazeXamarinFormsFeedFragment$$ExternalSyntheticLambda3);
        listView.setAdapter(this.mAdapter);
        this.mBraze.requestFeedRefreshFromCache();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onActivityCreated$0$com-braze-ui-BrazeXamarinFormsFeedFragment  reason: not valid java name */
    public /* synthetic */ boolean m169lambda$onActivityCreated$0$combrazeuiBrazeXamarinFormsFeedFragment(View view, MotionEvent motionEvent) {
        return this.mGestureDetector.onTouchEvent(motionEvent);
    }

    static /* synthetic */ boolean lambda$onActivityCreated$1(View view, MotionEvent motionEvent) {
        return view.getVisibility() == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onActivityCreated$3$com-braze-ui-BrazeXamarinFormsFeedFragment  reason: not valid java name */
    public /* synthetic */ void m171lambda$onActivityCreated$3$combrazeuiBrazeXamarinFormsFeedFragment(ListView listView, FeedUpdatedEvent feedUpdatedEvent) {
        Activity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new BrazeXamarinFormsFeedFragment$$ExternalSyntheticLambda4(this, feedUpdatedEvent, listView));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onActivityCreated$2$com-braze-ui-BrazeXamarinFormsFeedFragment  reason: not valid java name */
    public /* synthetic */ void m170lambda$onActivityCreated$2$combrazeuiBrazeXamarinFormsFeedFragment(FeedUpdatedEvent feedUpdatedEvent, ListView listView) {
        String str = TAG;
        BrazeLogger.d(str, "Updating feed views in response to FeedUpdatedEvent: " + feedUpdatedEvent);
        this.mMainThreadLooper.removeCallbacks(this.mShowNetworkError);
        this.mNetworkErrorLayout.setVisibility(8);
        if (feedUpdatedEvent.getCardCount(this.mCategories) == 0) {
            listView.setVisibility(8);
            this.mAdapter.clear();
        } else {
            this.mEmptyFeedLayout.setVisibility(8);
            this.mLoadingSpinner.setVisibility(8);
            this.mTransparentFullBoundsContainerView.setVisibility(8);
        }
        if (feedUpdatedEvent.isFromOfflineStorage() && (feedUpdatedEvent.lastUpdatedInSecondsFromEpoch() + 60) * 1000 < System.currentTimeMillis()) {
            BrazeLogger.i(str, "Feed received was older than the max time to live of 60 seconds, displaying it for now, but requesting an updated view from the server.");
            this.mBraze.requestFeedRefresh();
            if (feedUpdatedEvent.getCardCount(this.mCategories) == 0) {
                BrazeLogger.d(str, "Old feed was empty, putting up a network spinner and registering the network error message on a delay of 5000ms.");
                this.mEmptyFeedLayout.setVisibility(8);
                this.mLoadingSpinner.setVisibility(0);
                this.mTransparentFullBoundsContainerView.setVisibility(0);
                this.mMainThreadLooper.postDelayed(this.mShowNetworkError, 5000);
                return;
            }
        }
        if (feedUpdatedEvent.getCardCount(this.mCategories) == 0) {
            this.mLoadingSpinner.setVisibility(8);
            this.mEmptyFeedLayout.setVisibility(0);
            this.mTransparentFullBoundsContainerView.setVisibility(0);
        } else {
            this.mAdapter.replaceFeed(feedUpdatedEvent.getFeedCards(this.mCategories));
            listView.setVisibility(0);
        }
        this.mFeedSwipeLayout.setRefreshing(false);
    }

    public void onResume() {
        super.onResume();
        Braze.getInstance(getActivity()).logFeedDisplayed();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.mBraze.removeSingleSubscription(this.mFeedUpdatedSubscriber, FeedUpdatedEvent.class);
        setOnScreenCardsToRead();
    }

    public void onPause() {
        super.onPause();
        setOnScreenCardsToRead();
    }

    private void setOnScreenCardsToRead() {
        this.mAdapter.batchSetCardsToRead(this.previousVisibleHeadCardIndex, this.currentCardIndexAtBottomOfScreen);
    }

    public void onDetach() {
        super.onDetach();
        setListAdapter((ListAdapter) null);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (isVisible()) {
            this.mSkipCardImpressionsReset = true;
        }
    }

    public EnumSet<CardCategory> getCategories() {
        return this.mCategories;
    }

    public void setCategory(CardCategory cardCategory) {
        setCategories(EnumSet.of(cardCategory));
    }

    public void setCategories(EnumSet<CardCategory> enumSet) {
        if (enumSet == null) {
            BrazeLogger.i(TAG, "The categories passed into setCategories are null, BrazeFeedFragment is going to display all the cards in cache.");
            this.mCategories = CardCategory.getAllCategories();
        } else if (enumSet.isEmpty()) {
            BrazeLogger.w(TAG, "The categories set had no elements and have been ignored. Please pass a valid EnumSet of CardCategory.");
            return;
        } else if (!enumSet.equals(this.mCategories)) {
            this.mCategories = enumSet;
        } else {
            return;
        }
        IBraze iBraze = this.mBraze;
        if (iBraze != null) {
            iBraze.requestFeedRefreshFromCache();
        }
    }

    public void onRefresh() {
        this.mBraze.requestFeedRefresh();
        this.mMainThreadLooper.postDelayed(new BrazeXamarinFormsFeedFragment$$ExternalSyntheticLambda0(this), AUTO_HIDE_REFRESH_INDICATOR_DELAY_MS);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onRefresh$4$com-braze-ui-BrazeXamarinFormsFeedFragment  reason: not valid java name */
    public /* synthetic */ void m172lambda$onRefresh$4$combrazeuiBrazeXamarinFormsFeedFragment() {
        this.mFeedSwipeLayout.setRefreshing(false);
    }

    public class FeedGestureListener extends GestureDetector.SimpleOnGestureListener {
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public FeedGestureListener() {
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            BrazeXamarinFormsFeedFragment.this.getListView().smoothScrollBy((int) f2, 0);
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            long eventTime = (motionEvent2.getEventTime() - motionEvent.getEventTime()) * 2;
            BrazeXamarinFormsFeedFragment.this.getListView().smoothScrollBy(-((int) ((f2 * ((float) eventTime)) / 1000.0f)), (int) (eventTime * 2));
            return true;
        }
    }
}
