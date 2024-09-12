package com.facebook.appevents.codeless.internal;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\fH\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\fH\u0007J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0016\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010#\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0007J\u001e\u0010$\u001a\u0004\u0018\u00010\f2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010(\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\b\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010\u0012\u001a\u00020\fH\u0003J\u0018\u0010-\u001a\u00020,2\u0006\u0010\u0012\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010\fJ\u0010\u0010.\u001a\u00020,2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u001a\u0010/\u001a\u00020*2\u0006\u0010\u0012\u001a\u00020\f2\b\u00100\u001a\u0004\u0018\u00010\u001dH\u0007J \u00101\u001a\u00020*2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u000204H\u0007J\u0018\u00105\u001a\u00020*2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u00102\u001a\u00020\u0017H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000e*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/facebook/appevents/codeless/internal/ViewHierarchy;", "", "()V", "CLASS_RCTROOTVIEW", "", "CLASS_RCTVIEWGROUP", "CLASS_TOUCHTARGETHELPER", "ICON_MAX_EDGE_LENGTH", "", "METHOD_FIND_TOUCHTARGET_VIEW", "RCTRootViewReference", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "TAG", "kotlin.jvm.PlatformType", "methodFindTouchTargetView", "Ljava/lang/reflect/Method;", "findRCTRootView", "view", "getChildrenOfView", "", "getClassTypeBitmask", "getDictionaryOfView", "Lorg/json/JSONObject;", "getDimensionOfView", "getExistingClass", "Ljava/lang/Class;", "className", "getExistingOnClickListener", "Landroid/view/View$OnClickListener;", "getExistingOnTouchListener", "Landroid/view/View$OnTouchListener;", "getHintOfView", "getParentOfView", "Landroid/view/ViewGroup;", "getTextOfView", "getTouchReactView", "location", "", "RCTRootView", "getViewLocationOnScreen", "initTouchTargetHelperMethods", "", "isAdapterViewItem", "", "isRCTButton", "isRCTRootView", "setOnClickListener", "newListener", "updateAppearanceOfView", "json", "displayDensity", "", "updateBasicInfoOfView", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ViewHierarchy.kt */
public final class ViewHierarchy {
    private static final String CLASS_RCTROOTVIEW = "com.facebook.react.ReactRootView";
    private static final String CLASS_RCTVIEWGROUP = "com.facebook.react.views.view.ReactViewGroup";
    private static final String CLASS_TOUCHTARGETHELPER = "com.facebook.react.uimanager.TouchTargetHelper";
    private static final int ICON_MAX_EDGE_LENGTH = 44;
    public static final ViewHierarchy INSTANCE = new ViewHierarchy();
    private static final String METHOD_FIND_TOUCHTARGET_VIEW = "findTouchTargetView";
    private static WeakReference<View> RCTRootViewReference = new WeakReference<>((Object) null);
    private static final String TAG = ViewHierarchy.class.getCanonicalName();
    private static Method methodFindTouchTargetView;

    private ViewHierarchy() {
    }

    @JvmStatic
    public static final ViewGroup getParentOfView(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls) || view == null) {
            return null;
        }
        try {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                return (ViewGroup) parent;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    @JvmStatic
    public static final List<View> getChildrenOfView(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (view instanceof ViewGroup) {
                int childCount = ((ViewGroup) view).getChildCount();
                int i = 0;
                if (childCount > 0) {
                    while (true) {
                        int i2 = i + 1;
                        arrayList.add(((ViewGroup) view).getChildAt(i));
                        if (i2 >= childCount) {
                            break;
                        }
                        i = i2;
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    @JvmStatic
    public static final void updateBasicInfoOfView(View view, JSONObject jSONObject) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
                Intrinsics.checkNotNullParameter(jSONObject, "json");
                ViewHierarchy viewHierarchy = INSTANCE;
                String textOfView = getTextOfView(view);
                String hintOfView = getHintOfView(view);
                Object tag = view.getTag();
                CharSequence contentDescription = view.getContentDescription();
                jSONObject.put(ViewHierarchyConstants.CLASS_NAME_KEY, (Object) view.getClass().getCanonicalName());
                jSONObject.put(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY, getClassTypeBitmask(view));
                jSONObject.put("id", view.getId());
                SensitiveUserDataUtils sensitiveUserDataUtils = SensitiveUserDataUtils.INSTANCE;
                if (!SensitiveUserDataUtils.isSensitiveUserData(view)) {
                    Utility utility = Utility.INSTANCE;
                    Utility utility2 = Utility.INSTANCE;
                    jSONObject.put("text", (Object) Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(textOfView), ""));
                } else {
                    jSONObject.put("text", (Object) "");
                    jSONObject.put(ViewHierarchyConstants.IS_USER_INPUT_KEY, true);
                }
                Utility utility3 = Utility.INSTANCE;
                Utility utility4 = Utility.INSTANCE;
                jSONObject.put(ViewHierarchyConstants.HINT_KEY, (Object) Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(hintOfView), ""));
                if (tag != null) {
                    Utility utility5 = Utility.INSTANCE;
                    Utility utility6 = Utility.INSTANCE;
                    jSONObject.put("tag", (Object) Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(tag.toString()), ""));
                }
                if (contentDescription != null) {
                    Utility utility7 = Utility.INSTANCE;
                    Utility utility8 = Utility.INSTANCE;
                    jSONObject.put("description", (Object) Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(contentDescription.toString()), ""));
                }
                jSONObject.put(ViewHierarchyConstants.DIMENSION_KEY, (Object) viewHierarchy.getDimensionOfView(view));
            } catch (JSONException e) {
                Utility utility9 = Utility.INSTANCE;
                Utility.logd(TAG, (Exception) e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @JvmStatic
    public static final void updateAppearanceOfView(View view, JSONObject jSONObject, float f) {
        Bitmap bitmap;
        Typeface typeface;
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
                Intrinsics.checkNotNullParameter(jSONObject, "json");
                JSONObject jSONObject2 = new JSONObject();
                if ((view instanceof TextView) && (typeface = ((TextView) view).getTypeface()) != null) {
                    jSONObject2.put(ViewHierarchyConstants.TEXT_SIZE, (double) ((TextView) view).getTextSize());
                    jSONObject2.put(ViewHierarchyConstants.TEXT_IS_BOLD, typeface.isBold());
                    jSONObject2.put(ViewHierarchyConstants.TEXT_IS_ITALIC, typeface.isItalic());
                    jSONObject.put(ViewHierarchyConstants.TEXT_STYLE, (Object) jSONObject2);
                }
                if (view instanceof ImageView) {
                    Drawable drawable = ((ImageView) view).getDrawable();
                    if (drawable instanceof BitmapDrawable) {
                        float f2 = (float) 44;
                        if (((float) view.getHeight()) / f <= f2 && ((float) view.getWidth()) / f <= f2 && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                            jSONObject.put(ViewHierarchyConstants.ICON_BITMAP, (Object) Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
                        }
                    }
                }
            } catch (JSONException e) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, (Exception) e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @JvmStatic
    public static final JSONObject getDictionaryOfView(View view) {
        JSONObject jSONObject;
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
            if (Intrinsics.areEqual((Object) view.getClass().getName(), (Object) CLASS_RCTROOTVIEW)) {
                RCTRootViewReference = new WeakReference<>(view);
            }
            jSONObject = new JSONObject();
            updateBasicInfoOfView(view, jSONObject);
            JSONArray jSONArray = new JSONArray();
            List<View> childrenOfView = getChildrenOfView(view);
            int i = 0;
            int size = childrenOfView.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i2 = i + 1;
                    jSONArray.put((Object) getDictionaryOfView(childrenOfView.get(i)));
                    if (i2 > size) {
                        break;
                    }
                    i = i2;
                }
            }
            jSONObject.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, (Object) jSONArray);
        } catch (JSONException e) {
            Log.e(TAG, "Failed to create JSONObject for view.", e);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
        return jSONObject;
    }

    @JvmStatic
    public static final int getClassTypeBitmask(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return 0;
        }
        try {
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
            int i = view instanceof ImageView ? 2 : 0;
            if (view.isClickable()) {
                i |= 32;
            }
            ViewHierarchy viewHierarchy = INSTANCE;
            if (isAdapterViewItem(view)) {
                i |= 512;
            }
            if (view instanceof TextView) {
                int i2 = i | 1024 | 1;
                if (view instanceof Button) {
                    i2 |= 4;
                    if (view instanceof Switch) {
                        i2 |= 8192;
                    } else if (view instanceof CheckBox) {
                        i2 |= 32768;
                    }
                }
                if (view instanceof EditText) {
                    return i2 | 2048;
                }
                return i2;
            }
            if (!(view instanceof Spinner)) {
                if (!(view instanceof DatePicker)) {
                    if (view instanceof RatingBar) {
                        return i | 65536;
                    }
                    if (view instanceof RadioGroup) {
                        return i | 16384;
                    }
                    return (!(view instanceof ViewGroup) || !viewHierarchy.isRCTButton(view, (View) RCTRootViewReference.get())) ? i : i | 64;
                }
            }
            return i | 4096;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return 0;
        }
    }

    @JvmStatic
    private static final boolean isAdapterViewItem(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            ViewParent parent = view.getParent();
            if (parent instanceof AdapterView) {
                return true;
            }
            ViewHierarchy viewHierarchy = INSTANCE;
            Class<?> existingClass = viewHierarchy.getExistingClass("android.support.v4.view.NestedScrollingChild");
            if (existingClass != null && existingClass.isInstance(parent)) {
                return true;
            }
            Class<?> existingClass2 = viewHierarchy.getExistingClass("androidx.core.view.NestedScrollingChild");
            if (existingClass2 == null || !existingClass2.isInstance(parent)) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    @JvmStatic
    public static final String getTextOfView(View view) {
        Object obj;
        Object selectedItem;
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (view instanceof TextView) {
                obj = ((TextView) view).getText();
                if (view instanceof Switch) {
                    obj = ((Switch) view).isChecked() ? "1" : "0";
                }
            } else {
                if (!(view instanceof Spinner)) {
                    int i = 0;
                    if (view instanceof DatePicker) {
                        int year = ((DatePicker) view).getYear();
                        int month = ((DatePicker) view).getMonth();
                        int dayOfMonth = ((DatePicker) view).getDayOfMonth();
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        obj = String.format("%04d-%02d-%02d", Arrays.copyOf(new Object[]{Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(dayOfMonth)}, 3));
                        Intrinsics.checkNotNullExpressionValue(obj, "java.lang.String.format(format, *args)");
                    } else if (view instanceof TimePicker) {
                        Integer currentHour = ((TimePicker) view).getCurrentHour();
                        Intrinsics.checkNotNullExpressionValue(currentHour, "view.currentHour");
                        int intValue = currentHour.intValue();
                        Integer currentMinute = ((TimePicker) view).getCurrentMinute();
                        Intrinsics.checkNotNullExpressionValue(currentMinute, "view.currentMinute");
                        int intValue2 = currentMinute.intValue();
                        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                        obj = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(intValue), Integer.valueOf(intValue2)}, 2));
                        Intrinsics.checkNotNullExpressionValue(obj, "java.lang.String.format(format, *args)");
                    } else if (view instanceof RadioGroup) {
                        int checkedRadioButtonId = ((RadioGroup) view).getCheckedRadioButtonId();
                        int childCount = ((RadioGroup) view).getChildCount();
                        if (childCount > 0) {
                            while (true) {
                                int i2 = i + 1;
                                View childAt = ((RadioGroup) view).getChildAt(i);
                                if (childAt.getId() == checkedRadioButtonId && (childAt instanceof RadioButton)) {
                                    obj = ((RadioButton) childAt).getText();
                                    break;
                                } else if (i2 >= childCount) {
                                    break;
                                } else {
                                    i = i2;
                                }
                            }
                        }
                    } else if (view instanceof RatingBar) {
                        obj = String.valueOf(((RatingBar) view).getRating());
                    }
                } else if (((Spinner) view).getCount() > 0 && (selectedItem = ((Spinner) view).getSelectedItem()) != null) {
                    obj = selectedItem.toString();
                }
                obj = null;
            }
            if (obj == null) {
                return "";
            }
            String obj2 = obj.toString();
            if (obj2 == null) {
                return "";
            }
            return obj2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    @JvmStatic
    public static final String getHintOfView(View view) {
        CharSequence charSequence;
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (view instanceof EditText) {
                charSequence = ((EditText) view).getHint();
            } else {
                charSequence = view instanceof TextView ? ((TextView) view).getHint() : null;
            }
            if (charSequence == null) {
                return "";
            }
            String obj = charSequence.toString();
            if (obj == null) {
                return "";
            }
            return obj;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private final JSONObject getDimensionOfView(View view) {
        JSONObject jSONObject;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            jSONObject = new JSONObject();
            jSONObject.put("top", view.getTop());
            jSONObject.put("left", view.getLeft());
            jSONObject.put("width", view.getWidth());
            jSONObject.put("height", view.getHeight());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_SCROLL_X_KEY, view.getScrollX());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_SCROLL_Y_KEY, view.getScrollY());
            jSONObject.put("visibility", view.getVisibility());
        } catch (JSONException e) {
            Log.e(TAG, "Failed to create JSONObject for dimension.", e);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
        return jSONObject;
    }

    @JvmStatic
    public static final View.OnClickListener getExistingOnClickListener(View view) {
        Field declaredField;
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener")) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 != null) {
                return (View.OnClickListener) obj2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.View.OnClickListener");
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002c A[ADDED_TO_REGION] */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void setOnClickListener(android.view.View r5, android.view.View.OnClickListener r6) {
        /*
            java.lang.Class<com.facebook.appevents.codeless.internal.ViewHierarchy> r0 = com.facebook.appevents.codeless.internal.ViewHierarchy.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            if (r1 == 0) goto L_0x0009
            return
        L_0x0009:
            java.lang.String r1 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)     // Catch:{ all -> 0x004b }
            r1 = 0
            java.lang.String r2 = "android.view.View"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0028 }
            java.lang.String r3 = "mListenerInfo"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0028 }
            java.lang.String r3 = "android.view.View$ListenerInfo"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0029 }
            java.lang.String r4 = "mOnClickListener"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0029 }
            goto L_0x002a
        L_0x0028:
            r2 = r1
        L_0x0029:
            r3 = r1
        L_0x002a:
            if (r2 == 0) goto L_0x0047
            if (r3 != 0) goto L_0x002f
            goto L_0x0047
        L_0x002f:
            r4 = 1
            r2.setAccessible(r4)     // Catch:{ Exception -> 0x004a }
            r3.setAccessible(r4)     // Catch:{ Exception -> 0x004a }
            r2.setAccessible(r4)     // Catch:{ IllegalAccessException -> 0x003d }
            java.lang.Object r1 = r2.get(r5)     // Catch:{ IllegalAccessException -> 0x003d }
        L_0x003d:
            if (r1 != 0) goto L_0x0043
            r5.setOnClickListener(r6)     // Catch:{ Exception -> 0x004a }
            return
        L_0x0043:
            r3.set(r1, r6)     // Catch:{ Exception -> 0x004a }
            goto L_0x004a
        L_0x0047:
            r5.setOnClickListener(r6)     // Catch:{ Exception -> 0x004a }
        L_0x004a:
            return
        L_0x004b:
            r5 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.internal.ViewHierarchy.setOnClickListener(android.view.View, android.view.View$OnClickListener):void");
    }

    @JvmStatic
    public static final View.OnTouchListener getExistingOnTouchListener(View view) {
        Field declaredField;
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener")) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 != null) {
                return (View.OnTouchListener) obj2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.View.OnTouchListener");
        } catch (NoSuchFieldException e) {
            Utility utility = Utility.INSTANCE;
            Utility.logd(TAG, (Exception) e);
        } catch (ClassNotFoundException e2) {
            Utility utility2 = Utility.INSTANCE;
            Utility.logd(TAG, (Exception) e2);
        } catch (IllegalAccessException e3) {
            Utility utility3 = Utility.INSTANCE;
            Utility.logd(TAG, (Exception) e3);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
        return null;
    }

    private final View getTouchReactView(float[] fArr, View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            initTouchTargetHelperMethods();
            Method method = methodFindTouchTargetView;
            if (!(method == null || view == null)) {
                if (method != null) {
                    Object invoke = method.invoke((Object) null, new Object[]{fArr, view});
                    if (invoke != null) {
                        View view2 = (View) invoke;
                        if (view2.getId() > 0) {
                            ViewParent parent = view2.getParent();
                            if (parent != null) {
                                return (View) parent;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                    }
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            }
        } catch (IllegalAccessException e) {
            Utility utility = Utility.INSTANCE;
            Utility.logd(TAG, (Exception) e);
        } catch (InvocationTargetException e2) {
            Utility utility2 = Utility.INSTANCE;
            Utility.logd(TAG, (Exception) e2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
        return null;
    }

    public final boolean isRCTButton(View view, View view2) {
        View touchReactView;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
            if (!Intrinsics.areEqual((Object) view.getClass().getName(), (Object) CLASS_RCTVIEWGROUP) || (touchReactView = getTouchReactView(getViewLocationOnScreen(view), view2)) == null || touchReactView.getId() != view.getId()) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final boolean isRCTRootView(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return Intrinsics.areEqual((Object) view.getClass().getName(), (Object) CLASS_RCTROOTVIEW);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    @JvmStatic
    public static final View findRCTRootView(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        while (view != null) {
            try {
                if (!INSTANCE.isRCTRootView(view)) {
                    ViewParent parent = view.getParent();
                    if (!(parent instanceof View)) {
                        break;
                    }
                    view = (View) parent;
                } else {
                    return view;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
        return null;
    }

    private final float[] getViewLocationOnScreen(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            return new float[]{(float) iArr[0], (float) iArr[1]};
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final void initTouchTargetHelperMethods() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (methodFindTouchTargetView == null) {
                    Method declaredMethod = Class.forName(CLASS_TOUCHTARGETHELPER).getDeclaredMethod(METHOD_FIND_TOUCHTARGET_VIEW, new Class[]{float[].class, ViewGroup.class});
                    methodFindTouchTargetView = declaredMethod;
                    if (declaredMethod != null) {
                        declaredMethod.setAccessible(true);
                        return;
                    }
                    throw new IllegalStateException("Required value was null.".toString());
                }
            } catch (ClassNotFoundException e) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, (Exception) e);
            } catch (NoSuchMethodException e2) {
                Utility utility2 = Utility.INSTANCE;
                Utility.logd(TAG, (Exception) e2);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final Class<?> getExistingClass(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            Class cls = null;
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
