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

public final class NoOpWindowCallback implements Window.Callback {
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onActionModeFinished(ActionMode actionMode) {
    }

    public void onActionModeStarted(ActionMode actionMode) {
    }

    public void onAttachedToWindow() {
    }

    public void onContentChanged() {
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return false;
    }

    public View onCreatePanelView(int i) {
        return null;
    }

    public void onDetachedFromWindow() {
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return false;
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return false;
    }

    public void onPanelClosed(int i, Menu menu) {
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return false;
    }

    public boolean onSearchRequested() {
        return false;
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return false;
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
    }

    public void onWindowFocusChanged(boolean z) {
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        return null;
    }
}
