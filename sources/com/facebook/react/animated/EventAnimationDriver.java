package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UnexpectedNativeTypeException;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import java.util.List;

class EventAnimationDriver implements RCTEventEmitter {
    String mEventName;
    private List<String> mEventPath;
    ValueAnimatedNode mValueNode;
    int mViewTag;

    public EventAnimationDriver(String str, int i, List<String> list, ValueAnimatedNode valueAnimatedNode) {
        this.mEventName = str;
        this.mViewTag = i;
        this.mEventPath = list;
        this.mValueNode = valueAnimatedNode;
    }

    public void receiveEvent(int i, String str, WritableMap writableMap) {
        ReadableMap readableMap;
        ReadableArray readableArray;
        ReadableMap readableMap2;
        if (writableMap != null) {
            int i2 = 0;
            ReadableArray readableArray2 = null;
            ReadableMap readableMap3 = writableMap;
            while (i2 < this.mEventPath.size() - 1) {
                if (readableMap3 != null) {
                    String str2 = this.mEventPath.get(i2);
                    ReadableType type = readableMap3.getType(str2);
                    if (type == ReadableType.Map) {
                        readableMap2 = readableMap3.getMap(str2);
                    } else if (type == ReadableType.Array) {
                        readableArray = readableMap3.getArray(str2);
                        readableArray2 = readableArray;
                        readableMap = null;
                        i2++;
                        readableMap3 = readableMap;
                    } else {
                        throw new UnexpectedNativeTypeException("Unexpected type " + type + " for key '" + str2 + "'");
                    }
                } else {
                    int parseInt = Integer.parseInt(this.mEventPath.get(i2));
                    ReadableType type2 = readableArray2.getType(parseInt);
                    if (type2 == ReadableType.Map) {
                        readableMap2 = readableArray2.getMap(parseInt);
                    } else if (type2 == ReadableType.Array) {
                        readableArray = readableArray2.getArray(parseInt);
                        readableArray2 = readableArray;
                        readableMap = null;
                        i2++;
                        readableMap3 = readableMap;
                    } else {
                        throw new UnexpectedNativeTypeException("Unexpected type " + type2 + " for index '" + parseInt + "'");
                    }
                }
                readableArray2 = null;
                readableMap = readableMap2;
                i2++;
                readableMap3 = readableMap;
            }
            List<String> list = this.mEventPath;
            String str3 = list.get(list.size() - 1);
            if (readableMap3 != null) {
                this.mValueNode.mValue = readableMap3.getDouble(str3);
                return;
            }
            this.mValueNode.mValue = readableArray2.getDouble(Integer.parseInt(str3));
            return;
        }
        throw new IllegalArgumentException("Native animated events must have event data.");
    }

    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
        throw new RuntimeException("receiveTouches is not support by native animated events");
    }
}
