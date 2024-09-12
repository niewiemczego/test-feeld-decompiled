package com.facebook.react.views.textinput;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.events.EventDispatcher;

class ReactEditTextInputConnectionWrapper extends InputConnectionWrapper {
    public static final String BACKSPACE_KEY_VALUE = "Backspace";
    public static final String ENTER_KEY_VALUE = "Enter";
    public static final String NEWLINE_RAW_VALUE = "\n";
    private ReactEditText mEditText;
    private EventDispatcher mEventDispatcher;
    private boolean mIsBatchEdit;
    private String mKey = null;

    public ReactEditTextInputConnectionWrapper(InputConnection inputConnection, ReactContext reactContext, ReactEditText reactEditText, EventDispatcher eventDispatcher) {
        super(inputConnection, false);
        this.mEventDispatcher = eventDispatcher;
        this.mEditText = reactEditText;
    }

    public boolean beginBatchEdit() {
        this.mIsBatchEdit = true;
        return super.beginBatchEdit();
    }

    public boolean endBatchEdit() {
        this.mIsBatchEdit = false;
        String str = this.mKey;
        if (str != null) {
            dispatchKeyEvent(str);
            this.mKey = null;
        }
        return super.endBatchEdit();
    }

    public boolean setComposingText(CharSequence charSequence, int i) {
        int selectionStart = this.mEditText.getSelectionStart();
        int selectionEnd = this.mEditText.getSelectionEnd();
        boolean composingText = super.setComposingText(charSequence, i);
        int selectionStart2 = this.mEditText.getSelectionStart();
        boolean z = false;
        boolean z2 = selectionStart == selectionEnd;
        boolean z3 = selectionStart2 == selectionStart;
        if (selectionStart2 < selectionStart || selectionStart2 <= 0) {
            z = true;
        }
        dispatchKeyEventOrEnqueue((z || (!z2 && z3)) ? BACKSPACE_KEY_VALUE : String.valueOf(this.mEditText.getText().charAt(selectionStart2 - 1)));
        return composingText;
    }

    public boolean commitText(CharSequence charSequence, int i) {
        String obj = charSequence.toString();
        if (obj.length() <= 2) {
            if (obj.equals("")) {
                obj = BACKSPACE_KEY_VALUE;
            }
            dispatchKeyEventOrEnqueue(obj);
        }
        return super.commitText(charSequence, i);
    }

    public boolean deleteSurroundingText(int i, int i2) {
        dispatchKeyEvent(BACKSPACE_KEY_VALUE);
        return super.deleteSurroundingText(i, i2);
    }

    public boolean sendKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            boolean z = keyEvent.getUnicodeChar() < 58 && keyEvent.getUnicodeChar() > 47;
            if (keyEvent.getKeyCode() == 67) {
                dispatchKeyEvent(BACKSPACE_KEY_VALUE);
            } else if (keyEvent.getKeyCode() == 66) {
                dispatchKeyEvent(ENTER_KEY_VALUE);
            } else if (z) {
                dispatchKeyEvent(String.valueOf(keyEvent.getNumber()));
            }
        }
        return super.sendKeyEvent(keyEvent);
    }

    private void dispatchKeyEventOrEnqueue(String str) {
        if (this.mIsBatchEdit) {
            this.mKey = str;
        } else {
            dispatchKeyEvent(str);
        }
    }

    private void dispatchKeyEvent(String str) {
        if (str.equals("\n")) {
            str = ENTER_KEY_VALUE;
        }
        this.mEventDispatcher.dispatchEvent(new ReactTextInputKeyPressEvent(this.mEditText.getId(), str));
    }
}
