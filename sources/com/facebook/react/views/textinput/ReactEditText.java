package com.facebook.react.views.textinput;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.QwertyKeyListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.uimanager.FabricViewStateManager;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.text.CustomLetterSpacingSpan;
import com.facebook.react.views.text.CustomLineHeightSpan;
import com.facebook.react.views.text.CustomStyleSpan;
import com.facebook.react.views.text.ReactAbsoluteSizeSpan;
import com.facebook.react.views.text.ReactBackgroundColorSpan;
import com.facebook.react.views.text.ReactForegroundColorSpan;
import com.facebook.react.views.text.ReactSpan;
import com.facebook.react.views.text.ReactStrikethroughSpan;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.ReactTypefaceUtils;
import com.facebook.react.views.text.ReactUnderlineSpan;
import com.facebook.react.views.text.TextAttributes;
import com.facebook.react.views.text.TextInlineImageSpan;
import com.facebook.react.views.text.TextLayoutManager;
import com.facebook.react.views.view.ReactViewBackgroundManager;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class ReactEditText extends AppCompatEditText implements FabricViewStateManager.HasFabricViewStateManager {
    public static final boolean DEBUG_MODE = false;
    private static final int UNSET = -1;
    /* access modifiers changed from: private */
    public static final KeyListener sKeyListener = QwertyKeyListener.getInstanceForFullKeyboard();
    private final String TAG = "ReactEditText";
    private boolean mAutoFocus = false;
    protected boolean mContainsImages;
    private ContentSizeWatcher mContentSizeWatcher;
    private int mDefaultGravityHorizontal;
    private int mDefaultGravityVertical;
    private boolean mDetectScrollMovement = false;
    private boolean mDidAttachToWindow = false;
    private boolean mDisableFullscreen;
    protected boolean mDisableTextDiffing = false;
    private EventDispatcher mEventDispatcher;
    private final FabricViewStateManager mFabricViewStateManager = new FabricViewStateManager();
    /* access modifiers changed from: private */
    public String mFontFamily = null;
    /* access modifiers changed from: private */
    public int mFontStyle = -1;
    /* access modifiers changed from: private */
    public int mFontWeight = -1;
    private final InputMethodManager mInputMethodManager;
    protected boolean mIsSettingTextFromJS;
    protected boolean mIsSettingTextFromState = false;
    private InternalKeyListener mKeyListener;
    /* access modifiers changed from: private */
    public ArrayList<TextWatcher> mListeners;
    protected int mNativeEventCount;
    private boolean mOnKeyPress = false;
    /* access modifiers changed from: private */
    public ReactViewBackgroundManager mReactBackgroundManager;
    private String mReturnKeyType;
    private ScrollWatcher mScrollWatcher;
    private SelectionWatcher mSelectionWatcher;
    private int mStagedInputType;
    private String mSubmitBehavior = null;
    /* access modifiers changed from: private */
    public TextAttributes mTextAttributes;
    private TextWatcherDelegator mTextWatcherDelegator;
    private boolean mTypefaceDirty = false;

    interface SpanPredicate<T> {
        boolean test(T t);
    }

    public boolean isLayoutRequested() {
        return false;
    }

    public ReactEditText(Context context) {
        super(context);
        setFocusableInTouchMode(false);
        this.mReactBackgroundManager = new ReactViewBackgroundManager(this);
        this.mInputMethodManager = (InputMethodManager) Assertions.assertNotNull(context.getSystemService("input_method"));
        this.mDefaultGravityHorizontal = getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        this.mDefaultGravityVertical = getGravity() & 112;
        this.mNativeEventCount = 0;
        this.mIsSettingTextFromJS = false;
        this.mDisableFullscreen = false;
        this.mListeners = null;
        this.mTextWatcherDelegator = null;
        this.mStagedInputType = getInputType();
        if (this.mKeyListener == null) {
            this.mKeyListener = new InternalKeyListener();
        }
        this.mScrollWatcher = null;
        this.mTextAttributes = new TextAttributes();
        applyTextAttributes();
        if (Build.VERSION.SDK_INT >= 26 && Build.VERSION.SDK_INT <= 27) {
            setLayerType(1, (Paint) null);
        }
        ViewCompat.setAccessibilityDelegate(this, new ReactAccessibilityDelegate(this, isFocusable(), getImportantForAccessibility()) {
            public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                if (i != 16) {
                    return super.performAccessibilityAction(view, i, bundle);
                }
                int length = ReactEditText.this.getText().length();
                if (length > 0) {
                    ReactEditText.this.setSelection(length);
                }
                return ReactEditText.this.requestFocusInternal();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        TextLayoutManager.deleteCachedSpannableForTag(getId());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        onContentSizeChange();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mDetectScrollMovement = true;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2 && this.mDetectScrollMovement) {
            if (!canScrollVertically(-1) && !canScrollVertically(1) && !canScrollHorizontally(-1) && !canScrollHorizontally(1)) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            this.mDetectScrollMovement = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 66 || isMultiline()) {
            return super.onKeyUp(i, keyEvent);
        }
        hideSoftKeyboard();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        ScrollWatcher scrollWatcher = this.mScrollWatcher;
        if (scrollWatcher != null) {
            scrollWatcher.onScrollChanged(i, i2, i3, i4);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        ReactContext reactContext = UIManagerHelper.getReactContext(this);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && this.mOnKeyPress) {
            onCreateInputConnection = new ReactEditTextInputConnectionWrapper(onCreateInputConnection, reactContext, this, this.mEventDispatcher);
        }
        if (isMultiline() && (shouldBlurOnReturn() || shouldSubmitOnReturn())) {
            editorInfo.imeOptions &= -1073741825;
        }
        return onCreateInputConnection;
    }

    public void clearFocus() {
        setFocusableInTouchMode(false);
        super.clearFocus();
        hideSoftKeyboard();
    }

    public boolean requestFocus(int i, Rect rect) {
        return isFocused();
    }

    /* access modifiers changed from: private */
    public boolean requestFocusInternal() {
        setFocusableInTouchMode(true);
        boolean requestFocus = super.requestFocus(TsExtractor.TS_STREAM_TYPE_HDMV_DTS, (Rect) null);
        if (getShowSoftInputOnFocus()) {
            showSoftKeyboard();
        }
        return requestFocus;
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
            super.addTextChangedListener(getTextWatcherDelegator());
        }
        this.mListeners.add(textWatcher);
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        ArrayList<TextWatcher> arrayList = this.mListeners;
        if (arrayList != null) {
            arrayList.remove(textWatcher);
            if (this.mListeners.isEmpty()) {
                this.mListeners = null;
                super.removeTextChangedListener(getTextWatcherDelegator());
            }
        }
    }

    public void setContentSizeWatcher(ContentSizeWatcher contentSizeWatcher) {
        this.mContentSizeWatcher = contentSizeWatcher;
    }

    public void setScrollWatcher(ScrollWatcher scrollWatcher) {
        this.mScrollWatcher = scrollWatcher;
    }

    public void maybeSetSelection(int i, int i2, int i3) {
        if (canUpdateWithEventCount(i) && i2 != -1 && i3 != -1) {
            setSelection(clampToTextLength(i2), clampToTextLength(i3));
        }
    }

    private int clampToTextLength(int i) {
        return Math.max(0, Math.min(i, getText() == null ? 0 : getText().length()));
    }

    public void setSelection(int i, int i2) {
        super.setSelection(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        if (this.mSelectionWatcher != null && hasFocus()) {
            this.mSelectionWatcher.onSelectionChanged(i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        SelectionWatcher selectionWatcher;
        super.onFocusChanged(z, i, rect);
        if (z && (selectionWatcher = this.mSelectionWatcher) != null) {
            selectionWatcher.onSelectionChanged(getSelectionStart(), getSelectionEnd());
        }
    }

    public void setSelectionWatcher(SelectionWatcher selectionWatcher) {
        this.mSelectionWatcher = selectionWatcher;
    }

    public void setOnKeyPress(boolean z) {
        this.mOnKeyPress = z;
    }

    public boolean shouldBlurOnReturn() {
        String submitBehavior = getSubmitBehavior();
        if (submitBehavior == null) {
            return !isMultiline();
        }
        return submitBehavior.equals("blurAndSubmit");
    }

    public boolean shouldSubmitOnReturn() {
        String submitBehavior = getSubmitBehavior();
        if (submitBehavior == null) {
            if (isMultiline()) {
                return false;
            }
        } else if (!submitBehavior.equals("submit") && !submitBehavior.equals("blurAndSubmit")) {
            return false;
        }
        return true;
    }

    public String getSubmitBehavior() {
        return this.mSubmitBehavior;
    }

    public void setSubmitBehavior(String str) {
        this.mSubmitBehavior = str;
    }

    public void setDisableFullscreenUI(boolean z) {
        this.mDisableFullscreen = z;
        updateImeOptions();
    }

    public boolean getDisableFullscreenUI() {
        return this.mDisableFullscreen;
    }

    public void setReturnKeyType(String str) {
        this.mReturnKeyType = str;
        updateImeOptions();
    }

    public String getReturnKeyType() {
        return this.mReturnKeyType;
    }

    /* access modifiers changed from: package-private */
    public int getStagedInputType() {
        return this.mStagedInputType;
    }

    /* access modifiers changed from: package-private */
    public void setStagedInputType(int i) {
        this.mStagedInputType = i;
    }

    /* access modifiers changed from: package-private */
    public void commitStagedInputType() {
        if (getInputType() != this.mStagedInputType) {
            int selectionStart = getSelectionStart();
            int selectionEnd = getSelectionEnd();
            setInputType(this.mStagedInputType);
            setSelection(selectionStart, selectionEnd);
        }
    }

    public void setInputType(int i) {
        Typeface typeface = super.getTypeface();
        super.setInputType(i);
        this.mStagedInputType = i;
        super.setTypeface(typeface);
        if (isMultiline()) {
            setSingleLine(false);
        }
        if (this.mKeyListener == null) {
            this.mKeyListener = new InternalKeyListener();
        }
        this.mKeyListener.setInputType(i);
        setKeyListener(this.mKeyListener);
    }

    public void setFontFamily(String str) {
        this.mFontFamily = str;
        this.mTypefaceDirty = true;
    }

    public void setFontWeight(String str) {
        int parseFontWeight = ReactTypefaceUtils.parseFontWeight(str);
        if (parseFontWeight != this.mFontWeight) {
            this.mFontWeight = parseFontWeight;
            this.mTypefaceDirty = true;
        }
    }

    public void setFontStyle(String str) {
        int parseFontStyle = ReactTypefaceUtils.parseFontStyle(str);
        if (parseFontStyle != this.mFontStyle) {
            this.mFontStyle = parseFontStyle;
            this.mTypefaceDirty = true;
        }
    }

    public void setFontFeatureSettings(String str) {
        if (!Objects.equals(str, getFontFeatureSettings())) {
            super.setFontFeatureSettings(str);
            this.mTypefaceDirty = true;
        }
    }

    public void maybeUpdateTypeface() {
        if (this.mTypefaceDirty) {
            this.mTypefaceDirty = false;
            setTypeface(ReactTypefaceUtils.applyStyles(getTypeface(), this.mFontStyle, this.mFontWeight, this.mFontFamily, getContext().getAssets()));
            if (this.mFontStyle == -1 && this.mFontWeight == -1 && this.mFontFamily == null && getFontFeatureSettings() == null) {
                setPaintFlags(getPaintFlags() & -129);
            } else {
                setPaintFlags(getPaintFlags() | 128);
            }
        }
    }

    public void requestFocusFromJS() {
        requestFocusInternal();
    }

    /* access modifiers changed from: package-private */
    public void clearFocusFromJS() {
        clearFocus();
    }

    public int incrementAndGetEventCounter() {
        int i = this.mNativeEventCount + 1;
        this.mNativeEventCount = i;
        return i;
    }

    public void maybeSetTextFromJS(ReactTextUpdate reactTextUpdate) {
        this.mIsSettingTextFromJS = true;
        maybeSetText(reactTextUpdate);
        this.mIsSettingTextFromJS = false;
    }

    public void maybeSetTextFromState(ReactTextUpdate reactTextUpdate) {
        this.mIsSettingTextFromState = true;
        maybeSetText(reactTextUpdate);
        this.mIsSettingTextFromState = false;
    }

    public boolean canUpdateWithEventCount(int i) {
        return i >= this.mNativeEventCount;
    }

    public void maybeSetText(ReactTextUpdate reactTextUpdate) {
        if ((!isSecureText() || !TextUtils.equals(getText(), reactTextUpdate.getText())) && canUpdateWithEventCount(reactTextUpdate.getJsEventCounter())) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(reactTextUpdate.getText());
            manageSpans(spannableStringBuilder);
            stripStyleEquivalentSpans(spannableStringBuilder);
            this.mContainsImages = reactTextUpdate.containsImages();
            this.mDisableTextDiffing = true;
            if (reactTextUpdate.getText().length() == 0) {
                setText((CharSequence) null);
            } else {
                getText().replace(0, length(), spannableStringBuilder);
            }
            this.mDisableTextDiffing = false;
            if (Build.VERSION.SDK_INT >= 23 && getBreakStrategy() != reactTextUpdate.getTextBreakStrategy()) {
                setBreakStrategy(reactTextUpdate.getTextBreakStrategy());
            }
            updateCachedSpannable();
        }
    }

    private void manageSpans(SpannableStringBuilder spannableStringBuilder) {
        Object[] spans = getText().getSpans(0, length(), Object.class);
        for (Object obj : spans) {
            int spanFlags = getText().getSpanFlags(obj);
            boolean z = (spanFlags & 33) == 33;
            if (obj instanceof ReactSpan) {
                getText().removeSpan(obj);
            }
            if (z) {
                int spanStart = getText().getSpanStart(obj);
                int spanEnd = getText().getSpanEnd(obj);
                getText().removeSpan(obj);
                if (sameTextForSpan(getText(), spannableStringBuilder, spanStart, spanEnd)) {
                    spannableStringBuilder.setSpan(obj, spanStart, spanEnd, spanFlags);
                }
            }
        }
    }

    private void stripStyleEquivalentSpans(SpannableStringBuilder spannableStringBuilder) {
        stripSpansOfKind(spannableStringBuilder, ReactAbsoluteSizeSpan.class, new SpanPredicate<ReactAbsoluteSizeSpan>() {
            public boolean test(ReactAbsoluteSizeSpan reactAbsoluteSizeSpan) {
                return reactAbsoluteSizeSpan.getSize() == ReactEditText.this.mTextAttributes.getEffectiveFontSize();
            }
        });
        stripSpansOfKind(spannableStringBuilder, ReactBackgroundColorSpan.class, new SpanPredicate<ReactBackgroundColorSpan>() {
            public boolean test(ReactBackgroundColorSpan reactBackgroundColorSpan) {
                return reactBackgroundColorSpan.getBackgroundColor() == ReactEditText.this.mReactBackgroundManager.getBackgroundColor();
            }
        });
        stripSpansOfKind(spannableStringBuilder, ReactForegroundColorSpan.class, new SpanPredicate<ReactForegroundColorSpan>() {
            public boolean test(ReactForegroundColorSpan reactForegroundColorSpan) {
                return reactForegroundColorSpan.getForegroundColor() == ReactEditText.this.getCurrentTextColor();
            }
        });
        stripSpansOfKind(spannableStringBuilder, ReactStrikethroughSpan.class, new SpanPredicate<ReactStrikethroughSpan>() {
            public boolean test(ReactStrikethroughSpan reactStrikethroughSpan) {
                return (ReactEditText.this.getPaintFlags() & 16) != 0;
            }
        });
        stripSpansOfKind(spannableStringBuilder, ReactUnderlineSpan.class, new SpanPredicate<ReactUnderlineSpan>() {
            public boolean test(ReactUnderlineSpan reactUnderlineSpan) {
                return (ReactEditText.this.getPaintFlags() & 8) != 0;
            }
        });
        if (Build.VERSION.SDK_INT >= 21) {
            stripSpansOfKind(spannableStringBuilder, CustomLetterSpacingSpan.class, new SpanPredicate<CustomLetterSpacingSpan>() {
                public boolean test(CustomLetterSpacingSpan customLetterSpacingSpan) {
                    return customLetterSpacingSpan.getSpacing() == ReactEditText.this.mTextAttributes.getEffectiveLetterSpacing();
                }
            });
        }
        stripSpansOfKind(spannableStringBuilder, CustomStyleSpan.class, new SpanPredicate<CustomStyleSpan>() {
            public boolean test(CustomStyleSpan customStyleSpan) {
                return customStyleSpan.getStyle() == ReactEditText.this.mFontStyle && Objects.equals(customStyleSpan.getFontFamily(), ReactEditText.this.mFontFamily) && customStyleSpan.getWeight() == ReactEditText.this.mFontWeight && Objects.equals(customStyleSpan.getFontFeatureSettings(), ReactEditText.this.getFontFeatureSettings());
            }
        });
    }

    private <T> void stripSpansOfKind(SpannableStringBuilder spannableStringBuilder, Class<T> cls, SpanPredicate<T> spanPredicate) {
        for (Object obj : spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), cls)) {
            if (spanPredicate.test(obj)) {
                spannableStringBuilder.removeSpan(obj);
            }
        }
    }

    private void addSpansFromStyleAttributes(SpannableStringBuilder spannableStringBuilder) {
        spannableStringBuilder.setSpan(new ReactAbsoluteSizeSpan(this.mTextAttributes.getEffectiveFontSize()), 0, spannableStringBuilder.length(), 16711698);
        spannableStringBuilder.setSpan(new ReactForegroundColorSpan(getCurrentTextColor()), 0, spannableStringBuilder.length(), 16711698);
        int backgroundColor = this.mReactBackgroundManager.getBackgroundColor();
        if (backgroundColor != 0) {
            spannableStringBuilder.setSpan(new ReactBackgroundColorSpan(backgroundColor), 0, spannableStringBuilder.length(), 16711698);
        }
        if ((getPaintFlags() & 16) != 0) {
            spannableStringBuilder.setSpan(new ReactStrikethroughSpan(), 0, spannableStringBuilder.length(), 16711698);
        }
        if ((getPaintFlags() & 8) != 0) {
            spannableStringBuilder.setSpan(new ReactUnderlineSpan(), 0, spannableStringBuilder.length(), 16711698);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            float effectiveLetterSpacing = this.mTextAttributes.getEffectiveLetterSpacing();
            if (!Float.isNaN(effectiveLetterSpacing)) {
                spannableStringBuilder.setSpan(new CustomLetterSpacingSpan(effectiveLetterSpacing), 0, spannableStringBuilder.length(), 16711698);
            }
        }
        if (!(this.mFontStyle == -1 && this.mFontWeight == -1 && this.mFontFamily == null && getFontFeatureSettings() == null)) {
            spannableStringBuilder.setSpan(new CustomStyleSpan(this.mFontStyle, this.mFontWeight, getFontFeatureSettings(), this.mFontFamily, getContext().getAssets()), 0, spannableStringBuilder.length(), 16711698);
        }
        float effectiveLineHeight = this.mTextAttributes.getEffectiveLineHeight();
        if (!Float.isNaN(effectiveLineHeight)) {
            spannableStringBuilder.setSpan(new CustomLineHeightSpan(effectiveLineHeight), 0, spannableStringBuilder.length(), 16711698);
        }
    }

    private static boolean sameTextForSpan(Editable editable, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        if (i > spannableStringBuilder.length() || i2 > spannableStringBuilder.length()) {
            return false;
        }
        while (i < i2) {
            if (editable.charAt(i) != spannableStringBuilder.charAt(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean showSoftKeyboard() {
        return this.mInputMethodManager.showSoftInput(this, 0);
    }

    /* access modifiers changed from: protected */
    public void hideSoftKeyboard() {
        this.mInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }

    private TextWatcherDelegator getTextWatcherDelegator() {
        if (this.mTextWatcherDelegator == null) {
            this.mTextWatcherDelegator = new TextWatcherDelegator();
        }
        return this.mTextWatcherDelegator;
    }

    /* access modifiers changed from: package-private */
    public boolean isMultiline() {
        return (getInputType() & 131072) != 0;
    }

    private boolean isSecureText() {
        return (getInputType() & 144) != 0;
    }

    /* access modifiers changed from: private */
    public void onContentSizeChange() {
        ContentSizeWatcher contentSizeWatcher = this.mContentSizeWatcher;
        if (contentSizeWatcher != null) {
            contentSizeWatcher.onLayout();
        }
        setIntrinsicContentSize();
    }

    private void setIntrinsicContentSize() {
        ReactContext reactContext = UIManagerHelper.getReactContext(this);
        FabricViewStateManager fabricViewStateManager = this.mFabricViewStateManager;
        if (fabricViewStateManager != null && !fabricViewStateManager.hasStateWrapper() && !reactContext.isBridgeless()) {
            ReactTextInputLocalData reactTextInputLocalData = new ReactTextInputLocalData(this);
            UIManagerModule uIManagerModule = (UIManagerModule) reactContext.getNativeModule(UIManagerModule.class);
            if (uIManagerModule != null) {
                uIManagerModule.setViewLocalData(getId(), reactTextInputLocalData);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int getGravityHorizontal() {
        return getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
    }

    /* access modifiers changed from: package-private */
    public void setGravityHorizontal(int i) {
        if (i == 0) {
            i = this.mDefaultGravityHorizontal;
        }
        setGravity(i | (getGravity() & -8 & -8388616));
    }

    /* access modifiers changed from: package-private */
    public void setGravityVertical(int i) {
        if (i == 0) {
            i = this.mDefaultGravityVertical;
        }
        setGravity(i | (getGravity() & -113));
    }

    private void updateImeOptions() {
        String str = this.mReturnKeyType;
        int i = 5;
        if (str != null) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1273775369:
                    if (str.equals("previous")) {
                        c = 0;
                        break;
                    }
                    break;
                case -906336856:
                    if (str.equals("search")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3304:
                    if (str.equals("go")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3089282:
                    if (str.equals("done")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3377907:
                    if (str.equals("next")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3387192:
                    if (str.equals("none")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3526536:
                    if (str.equals("send")) {
                        c = 6;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    i = 7;
                    break;
                case 1:
                    i = 3;
                    break;
                case 2:
                    i = 2;
                    break;
                case 4:
                    break;
                case 5:
                    i = 1;
                    break;
                case 6:
                    i = 4;
                    break;
            }
        }
        i = 6;
        if (this.mDisableFullscreen) {
            setImeOptions(33554432 | i);
        } else {
            setImeOptions(i);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        if (this.mContainsImages) {
            Editable text = getText();
            for (TextInlineImageSpan drawable2 : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                if (drawable2.getDrawable() == drawable) {
                    return true;
                }
            }
        }
        return super.verifyDrawable(drawable);
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.mContainsImages) {
            Editable text = getText();
            for (TextInlineImageSpan drawable2 : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                if (drawable2.getDrawable() == drawable) {
                    invalidate();
                }
            }
        }
        super.invalidateDrawable(drawable);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mContainsImages) {
            Editable text = getText();
            for (TextInlineImageSpan onDetachedFromWindow : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                onDetachedFromWindow.onDetachedFromWindow();
            }
        }
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.mContainsImages) {
            Editable text = getText();
            for (TextInlineImageSpan onStartTemporaryDetach : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                onStartTemporaryDetach.onStartTemporaryDetach();
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        super.setTextIsSelectable(true);
        if (this.mContainsImages) {
            Editable text = getText();
            for (TextInlineImageSpan onAttachedToWindow : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                onAttachedToWindow.onAttachedToWindow();
            }
        }
        if (this.mAutoFocus && !this.mDidAttachToWindow) {
            requestFocusInternal();
        }
        this.mDidAttachToWindow = true;
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.mContainsImages) {
            Editable text = getText();
            for (TextInlineImageSpan onFinishTemporaryDetach : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                onFinishTemporaryDetach.onFinishTemporaryDetach();
            }
        }
    }

    public void setBackgroundColor(int i) {
        this.mReactBackgroundManager.setBackgroundColor(i);
    }

    public void setBorderWidth(int i, float f) {
        this.mReactBackgroundManager.setBorderWidth(i, f);
    }

    public void setBorderColor(int i, float f, float f2) {
        this.mReactBackgroundManager.setBorderColor(i, f, f2);
    }

    public int getBorderColor(int i) {
        return this.mReactBackgroundManager.getBorderColor(i);
    }

    public void setBorderRadius(float f) {
        this.mReactBackgroundManager.setBorderRadius(f);
    }

    public void setBorderRadius(float f, int i) {
        this.mReactBackgroundManager.setBorderRadius(f, i);
    }

    public void setBorderStyle(String str) {
        this.mReactBackgroundManager.setBorderStyle(str);
    }

    public void setLetterSpacingPt(float f) {
        this.mTextAttributes.setLetterSpacing(f);
        applyTextAttributes();
    }

    public void setAllowFontScaling(boolean z) {
        if (this.mTextAttributes.getAllowFontScaling() != z) {
            this.mTextAttributes.setAllowFontScaling(z);
            applyTextAttributes();
        }
    }

    public void setFontSize(float f) {
        this.mTextAttributes.setFontSize(f);
        applyTextAttributes();
    }

    public void setMaxFontSizeMultiplier(float f) {
        if (f != this.mTextAttributes.getMaxFontSizeMultiplier()) {
            this.mTextAttributes.setMaxFontSizeMultiplier(f);
            applyTextAttributes();
        }
    }

    public void setAutoFocus(boolean z) {
        this.mAutoFocus = z;
    }

    /* access modifiers changed from: protected */
    public void applyTextAttributes() {
        setTextSize(0, (float) this.mTextAttributes.getEffectiveFontSize());
        float effectiveLetterSpacing = this.mTextAttributes.getEffectiveLetterSpacing();
        if (!Float.isNaN(effectiveLetterSpacing) && Build.VERSION.SDK_INT >= 21) {
            setLetterSpacing(effectiveLetterSpacing);
        }
    }

    public FabricViewStateManager getFabricViewStateManager() {
        return this.mFabricViewStateManager;
    }

    /* access modifiers changed from: private */
    public void updateCachedSpannable() {
        FabricViewStateManager fabricViewStateManager = this.mFabricViewStateManager;
        if (fabricViewStateManager != null && fabricViewStateManager.hasStateWrapper() && getId() != -1) {
            Editable text = getText();
            boolean z = text != null && text.length() > 0;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (z) {
                try {
                    spannableStringBuilder.append(text.subSequence(0, text.length()));
                } catch (IndexOutOfBoundsException e) {
                    ReactSoftExceptionLogger.logSoftException(this.TAG, e);
                }
            }
            if (!z) {
                if (getHint() == null || getHint().length() <= 0) {
                    spannableStringBuilder.append("I");
                } else {
                    spannableStringBuilder.append(getHint());
                }
            }
            addSpansFromStyleAttributes(spannableStringBuilder);
            TextLayoutManager.setCachedSpannabledForTag(getId(), spannableStringBuilder);
        }
    }

    /* access modifiers changed from: package-private */
    public void setEventDispatcher(EventDispatcher eventDispatcher) {
        this.mEventDispatcher = eventDispatcher;
    }

    private class TextWatcherDelegator implements TextWatcher {
        private TextWatcherDelegator() {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!ReactEditText.this.mIsSettingTextFromJS && ReactEditText.this.mListeners != null) {
                Iterator it = ReactEditText.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((TextWatcher) it.next()).beforeTextChanged(charSequence, i, i2, i3);
                }
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!ReactEditText.this.mIsSettingTextFromJS && ReactEditText.this.mListeners != null) {
                Iterator it = ReactEditText.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((TextWatcher) it.next()).onTextChanged(charSequence, i, i2, i3);
                }
            }
            ReactEditText.this.updateCachedSpannable();
            ReactEditText.this.onContentSizeChange();
        }

        public void afterTextChanged(Editable editable) {
            if (!ReactEditText.this.mIsSettingTextFromJS && ReactEditText.this.mListeners != null) {
                Iterator it = ReactEditText.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((TextWatcher) it.next()).afterTextChanged(editable);
                }
            }
        }
    }

    private static class InternalKeyListener implements KeyListener {
        private int mInputType = 0;

        public void setInputType(int i) {
            this.mInputType = i;
        }

        public int getInputType() {
            return this.mInputType;
        }

        public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
            return ReactEditText.sKeyListener.onKeyDown(view, editable, i, keyEvent);
        }

        public boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
            return ReactEditText.sKeyListener.onKeyUp(view, editable, i, keyEvent);
        }

        public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
            return ReactEditText.sKeyListener.onKeyOther(view, editable, keyEvent);
        }

        public void clearMetaKeyState(View view, Editable editable, int i) {
            ReactEditText.sKeyListener.clearMetaKeyState(view, editable, i);
        }
    }
}
