package com.transparentvideo;

import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.ArrayList;
import java.util.List;

public class TransparentVideoViewManager extends SimpleViewManager<LinearLayout> {
    public static final String REACT_CLASS = "TransparentVideoView";
    private static final String TAG = "TransparentVideoViewManager";
    private static List<LinearLayout> sInstances = new ArrayList();
    ReactApplicationContext reactContext;

    public String getName() {
        return REACT_CLASS;
    }

    public TransparentVideoViewManager(ReactApplicationContext reactApplicationContext) {
        this.reactContext = reactApplicationContext;
    }

    public LinearLayout createViewInstance(ThemedReactContext themedReactContext) {
        LinearLayout linearLayout = new LinearLayout(this.reactContext);
        sInstances.add(linearLayout);
        return linearLayout;
    }

    public static void destroyView(LinearLayout linearLayout) {
        sInstances.remove(linearLayout);
    }

    @ReactProp(name = "src")
    public void setSrc(LinearLayout linearLayout, ReadableMap readableMap) {
        AlphaMovieView alphaMovieView = (AlphaMovieView) linearLayout.getChildAt(0);
        if (alphaMovieView == null) {
            alphaMovieView = new AlphaMovieView(this.reactContext, (AttributeSet) null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            alphaMovieView.setLayoutParams(layoutParams);
            alphaMovieView.setAutoPlayAfterResume(true);
            linearLayout.addView(alphaMovieView);
        }
        alphaMovieView.setPacked(true);
        String lowerCase = readableMap.getString("uri").toLowerCase();
        Log.d("TransparentVideoViewManager setSrc", "file: " + lowerCase);
        try {
            Integer valueOf = Integer.valueOf(Utils.getRawResourceId(this.reactContext, lowerCase));
            Log.d("TransparentVideoViewManager setSrc", "ResourceID: " + valueOf);
            alphaMovieView.setVideoFromResourceId(this.reactContext, valueOf.intValue());
        } catch (RuntimeException e) {
            Log.e("TransparentVideoViewManager setSrc", e.getMessage(), e);
            alphaMovieView.setVideoByUrl(lowerCase);
        }
    }
}
