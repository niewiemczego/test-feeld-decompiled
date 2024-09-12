package com.braze.ui;

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
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.ListFragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.braze.Braze;
import com.braze.enums.CardCategory;
import com.braze.events.FeedUpdatedEvent;
import com.braze.events.IEventSubscriber;
import com.braze.models.cards.Card;
import com.braze.support.BrazeLogger;
import com.braze.ui.adapters.BrazeListAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

public class BrazeFeedFragment extends ListFragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final long AUTO_HIDE_REFRESH_INDICATOR_DELAY_MS = 2500;
    private static final int MAX_FEED_TTL_SECONDS = 60;
    private static final int NETWORK_PROBLEM_WARNING_MS = 5000;
    static final String SAVED_INSTANCE_STATE_KEY_CARD_CATEGORY = "CARD_CATEGORY";
    static final String SAVED_INSTANCE_STATE_KEY_CURRENT_CARD_INDEX_AT_BOTTOM_OF_SCREEN = "CURRENT_CARD_INDEX_AT_BOTTOM_OF_SCREEN";
    static final String SAVED_INSTANCE_STATE_KEY_PREVIOUS_VISIBLE_HEAD_CARD_INDEX = "PREVIOUS_VISIBLE_HEAD_CARD_INDEX";
    static final String SAVED_INSTANCE_STATE_KEY_SKIP_CARD_IMPRESSIONS_RESET = "SKIP_CARD_IMPRESSIONS_RESET";
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) BrazeFeedFragment.class);
    /* access modifiers changed from: private */
    public BrazeListAdapter mAdapter;
    private EnumSet<CardCategory> mCategories;
    int mCurrentCardIndexAtBottomOfScreen = 0;
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
    int mPreviousVisibleHeadCardIndex = 0;
    private final Runnable mShowNetworkError = new Runnable() {
        public void run() {
            if (BrazeFeedFragment.this.mLoadingSpinner != null) {
                BrazeFeedFragment.this.mLoadingSpinner.setVisibility(8);
            }
            if (BrazeFeedFragment.this.mNetworkErrorLayout != null) {
                BrazeFeedFragment.this.mNetworkErrorLayout.setVisibility(0);
            }
        }
    };
    boolean mSkipCardImpressionsReset = false;
    private boolean mSortEnabled = false;
    private View mTransparentFullBoundsContainerView;

    public void onAttach(Context context) {
        super.onAttach(context);
        if (this.mAdapter == null) {
            this.mAdapter = new BrazeListAdapter(context, R.id.tag, new ArrayList());
            this.mCategories = CardCategory.getAllCategories();
        }
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

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        loadFragmentStateFromSavedInstanceState(bundle);
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
        this.mFeedRootLayout.setOnTouchListener(new BrazeFeedFragment$$ExternalSyntheticLambda0(this));
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                BrazeFeedFragment.this.mFeedSwipeLayout.setEnabled(i == 0);
                if (i2 != 0) {
                    int i4 = i - 1;
                    if (i4 > BrazeFeedFragment.this.mPreviousVisibleHeadCardIndex) {
                        BrazeFeedFragment.this.mAdapter.batchSetCardsToRead(BrazeFeedFragment.this.mPreviousVisibleHeadCardIndex, i4);
                    }
                    BrazeFeedFragment.this.mPreviousVisibleHeadCardIndex = i4;
                    BrazeFeedFragment.this.mCurrentCardIndexAtBottomOfScreen = i + i2;
                }
            }
        });
        this.mTransparentFullBoundsContainerView.setOnTouchListener(new BrazeFeedFragment$$ExternalSyntheticLambda1());
        Braze.getInstance(getContext()).removeSingleSubscription(this.mFeedUpdatedSubscriber, FeedUpdatedEvent.class);
        this.mFeedUpdatedSubscriber = new BrazeFeedFragment$$ExternalSyntheticLambda2(this, listView);
        Braze.getInstance(getContext()).subscribeToFeedUpdates(this.mFeedUpdatedSubscriber);
        listView.setAdapter(this.mAdapter);
        Braze.getInstance(getContext()).requestFeedRefreshFromCache();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onViewCreated$0$com-braze-ui-BrazeFeedFragment  reason: not valid java name */
    public /* synthetic */ boolean m166lambda$onViewCreated$0$combrazeuiBrazeFeedFragment(View view, MotionEvent motionEvent) {
        return this.mGestureDetector.onTouchEvent(motionEvent);
    }

    static /* synthetic */ boolean lambda$onViewCreated$1(View view, MotionEvent motionEvent) {
        return view.getVisibility() == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onViewCreated$3$com-braze-ui-BrazeFeedFragment  reason: not valid java name */
    public /* synthetic */ void m168lambda$onViewCreated$3$combrazeuiBrazeFeedFragment(ListView listView, FeedUpdatedEvent feedUpdatedEvent) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new BrazeFeedFragment$$ExternalSyntheticLambda5(this, feedUpdatedEvent, listView));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onViewCreated$2$com-braze-ui-BrazeFeedFragment  reason: not valid java name */
    public /* synthetic */ void m167lambda$onViewCreated$2$combrazeuiBrazeFeedFragment(FeedUpdatedEvent feedUpdatedEvent, ListView listView) {
        String str = TAG;
        BrazeLogger.v(str, "Updating feed views in response to FeedUpdatedEvent: " + feedUpdatedEvent);
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
            Braze.getInstance(getContext()).requestFeedRefresh();
            if (feedUpdatedEvent.getCardCount(this.mCategories) == 0) {
                BrazeLogger.d(str, "Old feed was empty, putting up a network spinner and registering the network error message with a delay of 5000ms.");
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
            if (!this.mSortEnabled || feedUpdatedEvent.getCardCount(this.mCategories) == feedUpdatedEvent.getUnreadCardCount(this.mCategories)) {
                this.mAdapter.replaceFeed(feedUpdatedEvent.getFeedCards(this.mCategories));
            } else {
                this.mAdapter.replaceFeed(sortFeedCards(feedUpdatedEvent.getFeedCards(this.mCategories)));
            }
            listView.setVisibility(0);
        }
        this.mFeedSwipeLayout.setRefreshing(false);
    }

    static /* synthetic */ int lambda$sortFeedCards$4(Card card, Card card2) {
        if (card.isIndicatorHighlighted() == card2.isIndicatorHighlighted()) {
            return 0;
        }
        return card.isIndicatorHighlighted() ? 1 : -1;
    }

    public List<Card> sortFeedCards(List<Card> list) {
        Collections.sort(list, new BrazeFeedFragment$$ExternalSyntheticLambda4());
        return list;
    }

    public void onResume() {
        super.onResume();
        Braze.getInstance(getContext()).logFeedDisplayed();
    }

    public void onDestroyView() {
        super.onDestroyView();
        Braze.getInstance(getContext()).removeSingleSubscription(this.mFeedUpdatedSubscriber, FeedUpdatedEvent.class);
        setOnScreenCardsToRead();
    }

    public void onPause() {
        super.onPause();
        setOnScreenCardsToRead();
    }

    private void setOnScreenCardsToRead() {
        this.mAdapter.batchSetCardsToRead(this.mPreviousVisibleHeadCardIndex, this.mCurrentCardIndexAtBottomOfScreen);
    }

    public void onDetach() {
        super.onDetach();
        setListAdapter((ListAdapter) null);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(SAVED_INSTANCE_STATE_KEY_PREVIOUS_VISIBLE_HEAD_CARD_INDEX, this.mPreviousVisibleHeadCardIndex);
        bundle.putInt(SAVED_INSTANCE_STATE_KEY_CURRENT_CARD_INDEX_AT_BOTTOM_OF_SCREEN, this.mCurrentCardIndexAtBottomOfScreen);
        bundle.putBoolean(SAVED_INSTANCE_STATE_KEY_SKIP_CARD_IMPRESSIONS_RESET, this.mSkipCardImpressionsReset);
        if (this.mCategories == null) {
            this.mCategories = CardCategory.getAllCategories();
        }
        ArrayList arrayList = new ArrayList(this.mCategories.size());
        Iterator it = this.mCategories.iterator();
        while (it.hasNext()) {
            arrayList.add(((CardCategory) it.next()).name());
        }
        bundle.putStringArrayList(SAVED_INSTANCE_STATE_KEY_CARD_CATEGORY, arrayList);
        super.onSaveInstanceState(bundle);
        if (isVisible()) {
            this.mSkipCardImpressionsReset = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void loadFragmentStateFromSavedInstanceState(Bundle bundle) {
        if (bundle != null) {
            if (this.mCategories == null) {
                this.mCategories = CardCategory.getAllCategories();
            }
            this.mPreviousVisibleHeadCardIndex = bundle.getInt(SAVED_INSTANCE_STATE_KEY_PREVIOUS_VISIBLE_HEAD_CARD_INDEX, 0);
            this.mCurrentCardIndexAtBottomOfScreen = bundle.getInt(SAVED_INSTANCE_STATE_KEY_CURRENT_CARD_INDEX_AT_BOTTOM_OF_SCREEN, 0);
            this.mSkipCardImpressionsReset = bundle.getBoolean(SAVED_INSTANCE_STATE_KEY_SKIP_CARD_IMPRESSIONS_RESET, false);
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SAVED_INSTANCE_STATE_KEY_CARD_CATEGORY);
            if (stringArrayList != null) {
                this.mCategories.clear();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    this.mCategories.add(CardCategory.valueOf(it.next()));
                }
            }
        }
    }

    public EnumSet<CardCategory> getCategories() {
        return this.mCategories;
    }

    public boolean getSortEnabled() {
        return this.mSortEnabled;
    }

    public void setSortEnabled(boolean z) {
        this.mSortEnabled = z;
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
        if (Braze.getInstance(getContext()) != null) {
            Braze.getInstance(getContext()).requestFeedRefreshFromCache();
        }
    }

    public void onRefresh() {
        Braze.getInstance(getContext()).requestFeedRefresh();
        this.mMainThreadLooper.postDelayed(new BrazeFeedFragment$$ExternalSyntheticLambda3(this), AUTO_HIDE_REFRESH_INDICATOR_DELAY_MS);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onRefresh$5$com-braze-ui-BrazeFeedFragment  reason: not valid java name */
    public /* synthetic */ void m165lambda$onRefresh$5$combrazeuiBrazeFeedFragment() {
        this.mFeedSwipeLayout.setRefreshing(false);
    }

    public class FeedGestureListener extends GestureDetector.SimpleOnGestureListener {
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public FeedGestureListener() {
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            BrazeFeedFragment.this.getListView().smoothScrollBy((int) f2, 0);
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            long eventTime = (motionEvent2.getEventTime() - motionEvent.getEventTime()) * 2;
            BrazeFeedFragment.this.getListView().smoothScrollBy(-((int) ((f2 * ((float) eventTime)) / 1000.0f)), (int) (eventTime * 2));
            return true;
        }
    }
}
