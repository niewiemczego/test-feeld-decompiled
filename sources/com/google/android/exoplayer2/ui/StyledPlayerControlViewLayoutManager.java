package com.google.android.exoplayer2.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;

final class StyledPlayerControlViewLayoutManager {
    private static final long ANIMATION_INTERVAL_MS = 2000;
    private static final long DURATION_FOR_HIDING_ANIMATION_MS = 250;
    private static final long DURATION_FOR_SHOWING_ANIMATION_MS = 250;
    private static final int UX_STATE_ALL_VISIBLE = 0;
    private static final int UX_STATE_ANIMATING_HIDE = 3;
    private static final int UX_STATE_ANIMATING_SHOW = 4;
    private static final int UX_STATE_NONE_VISIBLE = 2;
    private static final int UX_STATE_ONLY_PROGRESS_VISIBLE = 1;
    private boolean animationEnabled = true;
    /* access modifiers changed from: private */
    public final ViewGroup basicControls;
    private final ViewGroup bottomBar;
    /* access modifiers changed from: private */
    public final ViewGroup centerControls;
    /* access modifiers changed from: private */
    public final View controlsBackground;
    private final ViewGroup extraControls;
    /* access modifiers changed from: private */
    public final ViewGroup extraControlsScrollView;
    private final AnimatorSet hideAllBarsAnimator;
    private final Runnable hideAllBarsRunnable = new StyledPlayerControlViewLayoutManager$$ExternalSyntheticLambda8(this);
    private final Runnable hideControllerRunnable = new StyledPlayerControlViewLayoutManager$$ExternalSyntheticLambda11(this);
    private final AnimatorSet hideMainBarAnimator;
    private final Runnable hideMainBarRunnable = new StyledPlayerControlViewLayoutManager$$ExternalSyntheticLambda10(this);
    private final AnimatorSet hideProgressBarAnimator;
    private final Runnable hideProgressBarRunnable = new StyledPlayerControlViewLayoutManager$$ExternalSyntheticLambda9(this);
    /* access modifiers changed from: private */
    public boolean isMinimalMode;
    /* access modifiers changed from: private */
    public final ViewGroup minimalControls;
    /* access modifiers changed from: private */
    public boolean needToShowBars;
    private final View.OnLayoutChangeListener onLayoutChangeListener = new StyledPlayerControlViewLayoutManager$$ExternalSyntheticLambda12(this);
    private final ValueAnimator overflowHideAnimator;
    private final ValueAnimator overflowShowAnimator;
    private final View overflowShowButton;
    private final StyledPlayerControlView playerControlView;
    private final AnimatorSet showAllBarsAnimator;
    /* access modifiers changed from: private */
    public final Runnable showAllBarsRunnable = new StyledPlayerControlViewLayoutManager$$ExternalSyntheticLambda5(this);
    private final AnimatorSet showMainBarAnimator;
    private final List<View> shownButtons = new ArrayList();
    /* access modifiers changed from: private */
    public final View timeBar;
    private final ViewGroup timeView;
    private int uxState = 0;

    public StyledPlayerControlViewLayoutManager(final StyledPlayerControlView styledPlayerControlView) {
        this.playerControlView = styledPlayerControlView;
        this.controlsBackground = styledPlayerControlView.findViewById(R.id.exo_controls_background);
        this.centerControls = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_center_controls);
        this.minimalControls = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_minimal_controls);
        ViewGroup viewGroup = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_bottom_bar);
        this.bottomBar = viewGroup;
        this.timeView = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_time);
        View findViewById = styledPlayerControlView.findViewById(R.id.exo_progress);
        this.timeBar = findViewById;
        this.basicControls = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_basic_controls);
        this.extraControls = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_extra_controls);
        this.extraControlsScrollView = (ViewGroup) styledPlayerControlView.findViewById(R.id.exo_extra_controls_scroll_view);
        View findViewById2 = styledPlayerControlView.findViewById(R.id.exo_overflow_show);
        this.overflowShowButton = findViewById2;
        View findViewById3 = styledPlayerControlView.findViewById(R.id.exo_overflow_hide);
        if (!(findViewById2 == null || findViewById3 == null)) {
            findViewById2.setOnClickListener(new StyledPlayerControlViewLayoutManager$$ExternalSyntheticLambda1(this));
            findViewById3.setOnClickListener(new StyledPlayerControlViewLayoutManager$$ExternalSyntheticLambda1(this));
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new StyledPlayerControlViewLayoutManager$$ExternalSyntheticLambda2(this));
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                if ((StyledPlayerControlViewLayoutManager.this.timeBar instanceof DefaultTimeBar) && !StyledPlayerControlViewLayoutManager.this.isMinimalMode) {
                    ((DefaultTimeBar) StyledPlayerControlViewLayoutManager.this.timeBar).hideScrubber(250);
                }
            }

            public void onAnimationEnd(Animator animator) {
                if (StyledPlayerControlViewLayoutManager.this.controlsBackground != null) {
                    StyledPlayerControlViewLayoutManager.this.controlsBackground.setVisibility(4);
                }
                if (StyledPlayerControlViewLayoutManager.this.centerControls != null) {
                    StyledPlayerControlViewLayoutManager.this.centerControls.setVisibility(4);
                }
                if (StyledPlayerControlViewLayoutManager.this.minimalControls != null) {
                    StyledPlayerControlViewLayoutManager.this.minimalControls.setVisibility(4);
                }
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addUpdateListener(new StyledPlayerControlViewLayoutManager$$ExternalSyntheticLambda3(this));
        ofFloat2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                int i = 0;
                if (StyledPlayerControlViewLayoutManager.this.controlsBackground != null) {
                    StyledPlayerControlViewLayoutManager.this.controlsBackground.setVisibility(0);
                }
                if (StyledPlayerControlViewLayoutManager.this.centerControls != null) {
                    StyledPlayerControlViewLayoutManager.this.centerControls.setVisibility(0);
                }
                if (StyledPlayerControlViewLayoutManager.this.minimalControls != null) {
                    ViewGroup access$400 = StyledPlayerControlViewLayoutManager.this.minimalControls;
                    if (!StyledPlayerControlViewLayoutManager.this.isMinimalMode) {
                        i = 4;
                    }
                    access$400.setVisibility(i);
                }
                if ((StyledPlayerControlViewLayoutManager.this.timeBar instanceof DefaultTimeBar) && !StyledPlayerControlViewLayoutManager.this.isMinimalMode) {
                    ((DefaultTimeBar) StyledPlayerControlViewLayoutManager.this.timeBar).showScrubber(250);
                }
            }
        });
        Resources resources = styledPlayerControlView.getResources();
        float dimension = resources.getDimension(R.dimen.exo_styled_bottom_bar_height) - resources.getDimension(R.dimen.exo_styled_progress_bar_height);
        float dimension2 = resources.getDimension(R.dimen.exo_styled_bottom_bar_height);
        AnimatorSet animatorSet = new AnimatorSet();
        this.hideMainBarAnimator = animatorSet;
        animatorSet.setDuration(250);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.setUxState(3);
            }

            public void onAnimationEnd(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.setUxState(1);
                if (StyledPlayerControlViewLayoutManager.this.needToShowBars) {
                    styledPlayerControlView.post(StyledPlayerControlViewLayoutManager.this.showAllBarsRunnable);
                    boolean unused = StyledPlayerControlViewLayoutManager.this.needToShowBars = false;
                }
            }
        });
        animatorSet.play(ofFloat).with(ofTranslationY(0.0f, dimension, findViewById)).with(ofTranslationY(0.0f, dimension, viewGroup));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.hideProgressBarAnimator = animatorSet2;
        animatorSet2.setDuration(250);
        animatorSet2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.setUxState(3);
            }

            public void onAnimationEnd(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.setUxState(2);
                if (StyledPlayerControlViewLayoutManager.this.needToShowBars) {
                    styledPlayerControlView.post(StyledPlayerControlViewLayoutManager.this.showAllBarsRunnable);
                    boolean unused = StyledPlayerControlViewLayoutManager.this.needToShowBars = false;
                }
            }
        });
        animatorSet2.play(ofTranslationY(dimension, dimension2, findViewById)).with(ofTranslationY(dimension, dimension2, viewGroup));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.hideAllBarsAnimator = animatorSet3;
        animatorSet3.setDuration(250);
        animatorSet3.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.setUxState(3);
            }

            public void onAnimationEnd(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.setUxState(2);
                if (StyledPlayerControlViewLayoutManager.this.needToShowBars) {
                    styledPlayerControlView.post(StyledPlayerControlViewLayoutManager.this.showAllBarsRunnable);
                    boolean unused = StyledPlayerControlViewLayoutManager.this.needToShowBars = false;
                }
            }
        });
        animatorSet3.play(ofFloat).with(ofTranslationY(0.0f, dimension2, findViewById)).with(ofTranslationY(0.0f, dimension2, viewGroup));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.showMainBarAnimator = animatorSet4;
        animatorSet4.setDuration(250);
        animatorSet4.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.setUxState(4);
            }

            public void onAnimationEnd(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.setUxState(0);
            }
        });
        animatorSet4.play(ofFloat2).with(ofTranslationY(dimension, 0.0f, findViewById)).with(ofTranslationY(dimension, 0.0f, viewGroup));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.showAllBarsAnimator = animatorSet5;
        animatorSet5.setDuration(250);
        animatorSet5.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.setUxState(4);
            }

            public void onAnimationEnd(Animator animator) {
                StyledPlayerControlViewLayoutManager.this.setUxState(0);
            }
        });
        animatorSet5.play(ofFloat2).with(ofTranslationY(dimension2, 0.0f, findViewById)).with(ofTranslationY(dimension2, 0.0f, viewGroup));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.overflowShowAnimator = ofFloat3;
        ofFloat3.setDuration(250);
        ofFloat3.addUpdateListener(new StyledPlayerControlViewLayoutManager$$ExternalSyntheticLambda6(this));
        ofFloat3.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                if (StyledPlayerControlViewLayoutManager.this.extraControlsScrollView != null) {
                    StyledPlayerControlViewLayoutManager.this.extraControlsScrollView.setVisibility(0);
                    StyledPlayerControlViewLayoutManager.this.extraControlsScrollView.setTranslationX((float) StyledPlayerControlViewLayoutManager.this.extraControlsScrollView.getWidth());
                    StyledPlayerControlViewLayoutManager.this.extraControlsScrollView.scrollTo(StyledPlayerControlViewLayoutManager.this.extraControlsScrollView.getWidth(), 0);
                }
            }

            public void onAnimationEnd(Animator animator) {
                if (StyledPlayerControlViewLayoutManager.this.basicControls != null) {
                    StyledPlayerControlViewLayoutManager.this.basicControls.setVisibility(4);
                }
            }
        });
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.overflowHideAnimator = ofFloat4;
        ofFloat4.setDuration(250);
        ofFloat4.addUpdateListener(new StyledPlayerControlViewLayoutManager$$ExternalSyntheticLambda7(this));
        ofFloat4.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                if (StyledPlayerControlViewLayoutManager.this.basicControls != null) {
                    StyledPlayerControlViewLayoutManager.this.basicControls.setVisibility(0);
                }
            }

            public void onAnimationEnd(Animator animator) {
                if (StyledPlayerControlViewLayoutManager.this.extraControlsScrollView != null) {
                    StyledPlayerControlViewLayoutManager.this.extraControlsScrollView.setVisibility(4);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-google-android-exoplayer2-ui-StyledPlayerControlViewLayoutManager  reason: not valid java name */
    public /* synthetic */ void m540lambda$new$0$comgoogleandroidexoplayer2uiStyledPlayerControlViewLayoutManager(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.controlsBackground;
        if (view != null) {
            view.setAlpha(floatValue);
        }
        ViewGroup viewGroup = this.centerControls;
        if (viewGroup != null) {
            viewGroup.setAlpha(floatValue);
        }
        ViewGroup viewGroup2 = this.minimalControls;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(floatValue);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$1$com-google-android-exoplayer2-ui-StyledPlayerControlViewLayoutManager  reason: not valid java name */
    public /* synthetic */ void m541lambda$new$1$comgoogleandroidexoplayer2uiStyledPlayerControlViewLayoutManager(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.controlsBackground;
        if (view != null) {
            view.setAlpha(floatValue);
        }
        ViewGroup viewGroup = this.centerControls;
        if (viewGroup != null) {
            viewGroup.setAlpha(floatValue);
        }
        ViewGroup viewGroup2 = this.minimalControls;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(floatValue);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$2$com-google-android-exoplayer2-ui-StyledPlayerControlViewLayoutManager  reason: not valid java name */
    public /* synthetic */ void m542lambda$new$2$comgoogleandroidexoplayer2uiStyledPlayerControlViewLayoutManager(ValueAnimator valueAnimator) {
        animateOverflow(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$3$com-google-android-exoplayer2-ui-StyledPlayerControlViewLayoutManager  reason: not valid java name */
    public /* synthetic */ void m543lambda$new$3$comgoogleandroidexoplayer2uiStyledPlayerControlViewLayoutManager(ValueAnimator valueAnimator) {
        animateOverflow(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public void show() {
        if (!this.playerControlView.isVisible()) {
            this.playerControlView.setVisibility(0);
            this.playerControlView.updateAll();
            this.playerControlView.requestPlayPauseFocus();
        }
        showAllBars();
    }

    public void hide() {
        int i = this.uxState;
        if (i != 3 && i != 2) {
            removeHideCallbacks();
            if (!this.animationEnabled) {
                hideController();
            } else if (this.uxState == 1) {
                hideProgressBar();
            } else {
                hideAllBars();
            }
        }
    }

    public void hideImmediately() {
        int i = this.uxState;
        if (i != 3 && i != 2) {
            removeHideCallbacks();
            hideController();
        }
    }

    public void setAnimationEnabled(boolean z) {
        this.animationEnabled = z;
    }

    public boolean isAnimationEnabled() {
        return this.animationEnabled;
    }

    public void resetHideCallbacks() {
        if (this.uxState != 3) {
            removeHideCallbacks();
            int showTimeoutMs = this.playerControlView.getShowTimeoutMs();
            if (showTimeoutMs <= 0) {
                return;
            }
            if (!this.animationEnabled) {
                postDelayedRunnable(this.hideControllerRunnable, (long) showTimeoutMs);
            } else if (this.uxState == 1) {
                postDelayedRunnable(this.hideProgressBarRunnable, 2000);
            } else {
                postDelayedRunnable(this.hideMainBarRunnable, (long) showTimeoutMs);
            }
        }
    }

    public void removeHideCallbacks() {
        this.playerControlView.removeCallbacks(this.hideControllerRunnable);
        this.playerControlView.removeCallbacks(this.hideAllBarsRunnable);
        this.playerControlView.removeCallbacks(this.hideMainBarRunnable);
        this.playerControlView.removeCallbacks(this.hideProgressBarRunnable);
    }

    public void onAttachedToWindow() {
        this.playerControlView.addOnLayoutChangeListener(this.onLayoutChangeListener);
    }

    public void onDetachedFromWindow() {
        this.playerControlView.removeOnLayoutChangeListener(this.onLayoutChangeListener);
    }

    public boolean isFullyVisible() {
        return this.uxState == 0 && this.playerControlView.isVisible();
    }

    public void setShowButton(View view, boolean z) {
        if (view != null) {
            if (!z) {
                view.setVisibility(8);
                this.shownButtons.remove(view);
                return;
            }
            if (!this.isMinimalMode || !shouldHideInMinimalMode(view)) {
                view.setVisibility(0);
            } else {
                view.setVisibility(4);
            }
            this.shownButtons.add(view);
        }
    }

    public boolean getShowButton(View view) {
        return view != null && this.shownButtons.contains(view);
    }

    /* access modifiers changed from: private */
    public void setUxState(int i) {
        int i2 = this.uxState;
        this.uxState = i;
        if (i == 2) {
            this.playerControlView.setVisibility(8);
        } else if (i2 == 2) {
            this.playerControlView.setVisibility(0);
        }
        if (i2 != i) {
            this.playerControlView.notifyOnVisibilityChange();
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view = this.controlsBackground;
        if (view != null) {
            view.layout(0, 0, i3 - i, i4 - i2);
        }
    }

    /* access modifiers changed from: private */
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        boolean useMinimalMode = useMinimalMode();
        if (this.isMinimalMode != useMinimalMode) {
            this.isMinimalMode = useMinimalMode;
            view.post(new StyledPlayerControlViewLayoutManager$$ExternalSyntheticLambda0(this));
        }
        boolean z = i3 - i != i7 - i5;
        if (!this.isMinimalMode && z) {
            view.post(new StyledPlayerControlViewLayoutManager$$ExternalSyntheticLambda4(this));
        }
    }

    /* access modifiers changed from: private */
    public void onOverflowButtonClick(View view) {
        resetHideCallbacks();
        if (view.getId() == R.id.exo_overflow_show) {
            this.overflowShowAnimator.start();
        } else if (view.getId() == R.id.exo_overflow_hide) {
            this.overflowHideAnimator.start();
        }
    }

    /* access modifiers changed from: private */
    public void showAllBars() {
        if (!this.animationEnabled) {
            setUxState(0);
            resetHideCallbacks();
            return;
        }
        int i = this.uxState;
        if (i == 1) {
            this.showMainBarAnimator.start();
        } else if (i == 2) {
            this.showAllBarsAnimator.start();
        } else if (i == 3) {
            this.needToShowBars = true;
        } else if (i == 4) {
            return;
        }
        resetHideCallbacks();
    }

    /* access modifiers changed from: private */
    public void hideAllBars() {
        this.hideAllBarsAnimator.start();
    }

    /* access modifiers changed from: private */
    public void hideProgressBar() {
        this.hideProgressBarAnimator.start();
    }

    /* access modifiers changed from: private */
    public void hideMainBar() {
        this.hideMainBarAnimator.start();
        postDelayedRunnable(this.hideProgressBarRunnable, 2000);
    }

    /* access modifiers changed from: private */
    public void hideController() {
        setUxState(2);
    }

    private static ObjectAnimator ofTranslationY(float f, float f2, View view) {
        return ObjectAnimator.ofFloat(view, "translationY", new float[]{f, f2});
    }

    private void postDelayedRunnable(Runnable runnable, long j) {
        if (j >= 0) {
            this.playerControlView.postDelayed(runnable, j);
        }
    }

    private void animateOverflow(float f) {
        ViewGroup viewGroup = this.extraControlsScrollView;
        if (viewGroup != null) {
            this.extraControlsScrollView.setTranslationX((float) ((int) (((float) viewGroup.getWidth()) * (1.0f - f))));
        }
        ViewGroup viewGroup2 = this.timeView;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f);
        }
        ViewGroup viewGroup3 = this.basicControls;
        if (viewGroup3 != null) {
            viewGroup3.setAlpha(1.0f - f);
        }
    }

    private boolean useMinimalMode() {
        int width = (this.playerControlView.getWidth() - this.playerControlView.getPaddingLeft()) - this.playerControlView.getPaddingRight();
        int height = (this.playerControlView.getHeight() - this.playerControlView.getPaddingBottom()) - this.playerControlView.getPaddingTop();
        int widthWithMargins = getWidthWithMargins(this.centerControls);
        ViewGroup viewGroup = this.centerControls;
        int paddingLeft = widthWithMargins - (viewGroup != null ? viewGroup.getPaddingLeft() + this.centerControls.getPaddingRight() : 0);
        int heightWithMargins = getHeightWithMargins(this.centerControls);
        ViewGroup viewGroup2 = this.centerControls;
        int paddingTop = viewGroup2 != null ? viewGroup2.getPaddingTop() + this.centerControls.getPaddingBottom() : 0;
        int max = Math.max(paddingLeft, getWidthWithMargins(this.timeView) + getWidthWithMargins(this.overflowShowButton));
        int heightWithMargins2 = (heightWithMargins - paddingTop) + (getHeightWithMargins(this.bottomBar) * 2);
        if (width <= max || height <= heightWithMargins2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void updateLayoutForSizeChange() {
        ViewGroup viewGroup = this.minimalControls;
        if (viewGroup != null) {
            viewGroup.setVisibility(this.isMinimalMode ? 0 : 4);
        }
        if (this.timeBar != null) {
            int dimensionPixelSize = this.playerControlView.getResources().getDimensionPixelSize(R.dimen.exo_styled_progress_margin_bottom);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.timeBar.getLayoutParams();
            if (marginLayoutParams != null) {
                if (this.isMinimalMode) {
                    dimensionPixelSize = 0;
                }
                marginLayoutParams.bottomMargin = dimensionPixelSize;
                this.timeBar.setLayoutParams(marginLayoutParams);
            }
            View view = this.timeBar;
            if (view instanceof DefaultTimeBar) {
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view;
                if (this.isMinimalMode) {
                    defaultTimeBar.hideScrubber(true);
                } else {
                    int i = this.uxState;
                    if (i == 1) {
                        defaultTimeBar.hideScrubber(false);
                    } else if (i != 3) {
                        defaultTimeBar.showScrubber();
                    }
                }
            }
        }
        for (View next : this.shownButtons) {
            next.setVisibility((!this.isMinimalMode || !shouldHideInMinimalMode(next)) ? 0 : 4);
        }
    }

    private boolean shouldHideInMinimalMode(View view) {
        int id = view.getId();
        return id == R.id.exo_bottom_bar || id == R.id.exo_prev || id == R.id.exo_next || id == R.id.exo_rew || id == R.id.exo_rew_with_amount || id == R.id.exo_ffwd || id == R.id.exo_ffwd_with_amount;
    }

    /* access modifiers changed from: private */
    public void onLayoutWidthChanged() {
        int i;
        if (this.basicControls != null && this.extraControls != null) {
            int width = (this.playerControlView.getWidth() - this.playerControlView.getPaddingLeft()) - this.playerControlView.getPaddingRight();
            while (true) {
                if (this.extraControls.getChildCount() <= 1) {
                    break;
                }
                int childCount = this.extraControls.getChildCount() - 2;
                View childAt = this.extraControls.getChildAt(childCount);
                this.extraControls.removeViewAt(childCount);
                this.basicControls.addView(childAt, 0);
            }
            View view = this.overflowShowButton;
            if (view != null) {
                view.setVisibility(8);
            }
            int widthWithMargins = getWidthWithMargins(this.timeView);
            int childCount2 = this.basicControls.getChildCount() - 1;
            for (int i2 = 0; i2 < childCount2; i2++) {
                widthWithMargins += getWidthWithMargins(this.basicControls.getChildAt(i2));
            }
            if (widthWithMargins > width) {
                View view2 = this.overflowShowButton;
                if (view2 != null) {
                    view2.setVisibility(0);
                    widthWithMargins += getWidthWithMargins(this.overflowShowButton);
                }
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < childCount2; i3++) {
                    View childAt2 = this.basicControls.getChildAt(i3);
                    widthWithMargins -= getWidthWithMargins(childAt2);
                    arrayList.add(childAt2);
                    if (widthWithMargins <= width) {
                        break;
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.basicControls.removeViews(0, arrayList.size());
                    for (i = 0; i < arrayList.size(); i++) {
                        this.extraControls.addView((View) arrayList.get(i), this.extraControls.getChildCount() - 1);
                    }
                    return;
                }
                return;
            }
            ViewGroup viewGroup = this.extraControlsScrollView;
            if (viewGroup != null && viewGroup.getVisibility() == 0 && !this.overflowHideAnimator.isStarted()) {
                this.overflowShowAnimator.cancel();
                this.overflowHideAnimator.start();
            }
        }
    }

    private static int getWidthWithMargins(View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return width;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return width + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    }

    private static int getHeightWithMargins(View view) {
        if (view == null) {
            return 0;
        }
        int height = view.getHeight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return height;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return height + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }
}
