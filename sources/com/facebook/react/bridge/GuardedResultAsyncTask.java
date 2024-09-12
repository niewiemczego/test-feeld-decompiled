package com.facebook.react.bridge;

import android.os.AsyncTask;

public abstract class GuardedResultAsyncTask<Result> extends AsyncTask<Void, Void, Result> {
    private final JSExceptionHandler mExceptionHandler;

    /* access modifiers changed from: protected */
    public abstract Result doInBackgroundGuarded();

    /* access modifiers changed from: protected */
    public abstract void onPostExecuteGuarded(Result result);

    @Deprecated
    protected GuardedResultAsyncTask(ReactContext reactContext) {
        this(reactContext.getExceptionHandler());
    }

    protected GuardedResultAsyncTask(JSExceptionHandler jSExceptionHandler) {
        this.mExceptionHandler = jSExceptionHandler;
    }

    /* access modifiers changed from: protected */
    public final Result doInBackground(Void... voidArr) {
        try {
            return doInBackgroundGuarded();
        } catch (RuntimeException e) {
            this.mExceptionHandler.handleException(e);
            throw e;
        }
    }

    /* access modifiers changed from: protected */
    public final void onPostExecute(Result result) {
        try {
            onPostExecuteGuarded(result);
        } catch (RuntimeException e) {
            this.mExceptionHandler.handleException(e);
        }
    }
}
