package expo.modules.kotlin.jni;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.jni.HybridData;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001:\u0001%B\u000f\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH J!\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH J#\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000b\u001a\u00020\fH J#\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000b\u001a\u00020\fH J(\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00002\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J(\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00112\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J&\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J&\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J&\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\f2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J(\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J(\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J#\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fH J\b\u0010\u0018\u001a\u00020\u0006H\u0004J\u0011\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH J\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u001bH ¢\u0006\u0002\u0010\u001cJ\u0011\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH J\u0019\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH J\u0019\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000eH J\u001b\u0010 \u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0000H J\u001b\u0010!\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0011H J\u0018\u0010\"\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0000J\u0018\u0010\"\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0011J\u0016\u0010\"\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\"\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000eJ\u0016\u0010\"\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\fJ\u0018\u0010\"\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0018\u0010\"\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u001b\u0010#\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH J\u0011\u0010$\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lexpo/modules/kotlin/jni/JavaScriptObject;", "", "mHybridData", "Lcom/facebook/jni/HybridData;", "(Lcom/facebook/jni/HybridData;)V", "defineBoolProperty", "", "name", "", "value", "", "options", "", "defineDoubleProperty", "", "defineJSObjectProperty", "defineJSValueProperty", "Lexpo/modules/kotlin/jni/JavaScriptValue;", "defineProperty", "", "Lexpo/modules/kotlin/jni/JavaScriptObject$PropertyDescriptor;", "null", "", "defineStringProperty", "finalize", "getProperty", "getPropertyNames", "", "()[Ljava/lang/String;", "hasProperty", "setBoolProperty", "setDoubleProperty", "setJSObjectProperty", "setJSValueProperty", "setProperty", "setStringProperty", "unsetProperty", "PropertyDescriptor", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: JavaScriptObject.kt */
public class JavaScriptObject {
    private final HybridData mHybridData;

    private final native void defineBoolProperty(String str, boolean z, int i);

    private final native void defineDoubleProperty(String str, double d, int i);

    private final native void defineJSObjectProperty(String str, JavaScriptObject javaScriptObject, int i);

    private final native void defineJSValueProperty(String str, JavaScriptValue javaScriptValue, int i);

    private final native void defineStringProperty(String str, String str2, int i);

    private final native void setBoolProperty(String str, boolean z);

    private final native void setDoubleProperty(String str, double d);

    private final native void setJSObjectProperty(String str, JavaScriptObject javaScriptObject);

    private final native void setJSValueProperty(String str, JavaScriptValue javaScriptValue);

    private final native void setStringProperty(String str, String str2);

    private final native void unsetProperty(String str);

    public final native JavaScriptValue getProperty(String str);

    public final native String[] getPropertyNames();

    public final native boolean hasProperty(String str);

    public JavaScriptObject(HybridData hybridData) {
        Intrinsics.checkNotNullParameter(hybridData, "mHybridData");
        this.mHybridData = hybridData;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lexpo/modules/kotlin/jni/JavaScriptObject$PropertyDescriptor;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Configurable", "Enumerable", "Writable", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: JavaScriptObject.kt */
    public enum PropertyDescriptor {
        Configurable(1),
        Enumerable(2),
        Writable(4);
        
        private final int value;

        private PropertyDescriptor(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public final void setProperty(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        setBoolProperty(str, z);
    }

    public final void setProperty(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "name");
        setDoubleProperty(str, (double) i);
    }

    public final void setProperty(String str, double d) {
        Intrinsics.checkNotNullParameter(str, "name");
        setDoubleProperty(str, d);
    }

    public final void setProperty(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        setStringProperty(str, str2);
    }

    public final void setProperty(String str, JavaScriptValue javaScriptValue) {
        Intrinsics.checkNotNullParameter(str, "name");
        setJSValueProperty(str, javaScriptValue);
    }

    public final void setProperty(String str, JavaScriptObject javaScriptObject) {
        Intrinsics.checkNotNullParameter(str, "name");
        setJSObjectProperty(str, javaScriptObject);
    }

    public final void setProperty(String str, Void voidR) {
        Intrinsics.checkNotNullParameter(str, "name");
        unsetProperty(str);
    }

    public static /* synthetic */ void defineProperty$default(JavaScriptObject javaScriptObject, String str, boolean z, List list, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                list = CollectionsKt.emptyList();
            }
            javaScriptObject.defineProperty(str, z, (List<? extends PropertyDescriptor>) list);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defineProperty");
    }

    public final void defineProperty(String str, boolean z, List<? extends PropertyDescriptor> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        defineBoolProperty(str, z, JavaScriptObjectKt.toCppOptions(list));
    }

    public static /* synthetic */ void defineProperty$default(JavaScriptObject javaScriptObject, String str, int i, List list, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                list = CollectionsKt.emptyList();
            }
            javaScriptObject.defineProperty(str, i, (List<? extends PropertyDescriptor>) list);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defineProperty");
    }

    public final void defineProperty(String str, int i, List<? extends PropertyDescriptor> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        defineDoubleProperty(str, (double) i, JavaScriptObjectKt.toCppOptions(list));
    }

    public static /* synthetic */ void defineProperty$default(JavaScriptObject javaScriptObject, String str, double d, List list, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                list = CollectionsKt.emptyList();
            }
            javaScriptObject.defineProperty(str, d, (List<? extends PropertyDescriptor>) list);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defineProperty");
    }

    public final void defineProperty(String str, double d, List<? extends PropertyDescriptor> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        defineDoubleProperty(str, d, JavaScriptObjectKt.toCppOptions(list));
    }

    public static /* synthetic */ void defineProperty$default(JavaScriptObject javaScriptObject, String str, String str2, List list, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                list = CollectionsKt.emptyList();
            }
            javaScriptObject.defineProperty(str, str2, (List<? extends PropertyDescriptor>) list);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defineProperty");
    }

    public final void defineProperty(String str, String str2, List<? extends PropertyDescriptor> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        defineStringProperty(str, str2, JavaScriptObjectKt.toCppOptions(list));
    }

    public static /* synthetic */ void defineProperty$default(JavaScriptObject javaScriptObject, String str, JavaScriptValue javaScriptValue, List list, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                list = CollectionsKt.emptyList();
            }
            javaScriptObject.defineProperty(str, javaScriptValue, (List<? extends PropertyDescriptor>) list);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defineProperty");
    }

    public final void defineProperty(String str, JavaScriptValue javaScriptValue, List<? extends PropertyDescriptor> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        defineJSValueProperty(str, javaScriptValue, JavaScriptObjectKt.toCppOptions(list));
    }

    public static /* synthetic */ void defineProperty$default(JavaScriptObject javaScriptObject, String str, JavaScriptObject javaScriptObject2, List list, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                list = CollectionsKt.emptyList();
            }
            javaScriptObject.defineProperty(str, javaScriptObject2, (List<? extends PropertyDescriptor>) list);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defineProperty");
    }

    public final void defineProperty(String str, JavaScriptObject javaScriptObject, List<? extends PropertyDescriptor> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        defineJSObjectProperty(str, javaScriptObject, JavaScriptObjectKt.toCppOptions(list));
    }

    public static /* synthetic */ void defineProperty$default(JavaScriptObject javaScriptObject, String str, Void voidR, List list, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                list = CollectionsKt.emptyList();
            }
            javaScriptObject.defineProperty(str, voidR, (List<? extends PropertyDescriptor>) list);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defineProperty");
    }

    public final void defineProperty(String str, Void voidR, List<? extends PropertyDescriptor> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        defineJSObjectProperty(str, (JavaScriptObject) null, JavaScriptObjectKt.toCppOptions(list));
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        this.mHybridData.resetNative();
    }
}
