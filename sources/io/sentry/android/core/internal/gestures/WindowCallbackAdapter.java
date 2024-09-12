package io.sentry.android.core.internal.gestures;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

public class WindowCallbackAdapter implements Window.Callback {
    private final Window.Callback delegate;

    public WindowCallbackAdapter(Window.Callback callback) {
        this.delegate = callback;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.delegate.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.delegate.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.delegate.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.delegate.dispatchTrackballEvent(motionEvent);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.delegate.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.delegate.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public View onCreatePanelView(int i) {
        return this.delegate.onCreatePanelView(i);
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.delegate.onCreatePanelMenu(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.delegate.onPreparePanel(i, view, menu);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return this.delegate.onMenuOpened(i, menu);
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.delegate.onMenuItemSelected(i, menuItem);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.delegate.onWindowAttributesChanged(layoutParams);
    }

    public void onContentChanged() {
        this.delegate.onContentChanged();
    }

    public void onWindowFocusChanged(boolean z) {
        this.delegate.onWindowFocusChanged(z);
    }

    public void onAttachedToWindow() {
        this.delegate.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        this.delegate.onDetachedFromWindow();
    }

    public void onPanelClosed(int i, Menu menu) {
        this.delegate.onPanelClosed(i, menu);
    }

    public boolean onSearchRequested() {
        return this.delegate.onSearchRequested();
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.delegate.onSearchRequested(searchEvent);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.delegate.onWindowStartingActionMode(callback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        return this.delegate.onWindowStartingActionMode(callback, i);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.delegate.onActionModeStarted(actionMode);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.delegate.onActionModeFinished(actionMode);
    }
}
