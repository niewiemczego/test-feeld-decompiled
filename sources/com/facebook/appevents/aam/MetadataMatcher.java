package com.facebook.appevents.aam;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J$\u0010\f\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/appevents/aam/MetadataMatcher;", "", "()V", "MAX_INDICATOR_LENGTH", "", "getAroundViewIndicators", "", "", "view", "Landroid/view/View;", "getCurrentViewIndicators", "getTextIndicators", "matchIndicator", "", "indicator", "keys", "indicators", "matchValue", "text", "rule", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: MetadataMatcher.kt */
public final class MetadataMatcher {
    public static final MetadataMatcher INSTANCE = new MetadataMatcher();
    private static final int MAX_INDICATOR_LENGTH = 100;

    private MetadataMatcher() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:4|5|(1:7)|8|(1:10)|11|12|13|(2:15|(2:17|(1:19))(2:20|21))|22|23|(5:26|(1:28)(1:29)|(1:(2:34|46)(3:42|35|36))|41|24)|43|37) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x007e */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008f A[Catch:{ all -> 0x00c3 }] */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<java.lang.String> getCurrentViewIndicators(android.view.View r8) {
        /*
            java.lang.Class<com.facebook.appevents.aam.MetadataMatcher> r0 = com.facebook.appevents.aam.MetadataMatcher.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            java.lang.String r1 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)     // Catch:{ all -> 0x00c3 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00c3 }
            r1.<init>()     // Catch:{ all -> 0x00c3 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x00c3 }
            com.facebook.appevents.codeless.internal.ViewHierarchy r3 = com.facebook.appevents.codeless.internal.ViewHierarchy.INSTANCE     // Catch:{ all -> 0x00c3 }
            java.lang.String r3 = com.facebook.appevents.codeless.internal.ViewHierarchy.getHintOfView(r8)     // Catch:{ all -> 0x00c3 }
            r1.add(r3)     // Catch:{ all -> 0x00c3 }
            java.lang.Object r3 = r8.getTag()     // Catch:{ all -> 0x00c3 }
            if (r3 == 0) goto L_0x002c
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00c3 }
            r1.add(r3)     // Catch:{ all -> 0x00c3 }
        L_0x002c:
            java.lang.CharSequence r3 = r8.getContentDescription()     // Catch:{ all -> 0x00c3 }
            if (r3 == 0) goto L_0x0039
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00c3 }
            r1.add(r3)     // Catch:{ all -> 0x00c3 }
        L_0x0039:
            r3 = 1
            r4 = 0
            int r5 = r8.getId()     // Catch:{ NotFoundException -> 0x007e }
            r6 = -1
            if (r5 == r6) goto L_0x007e
            android.content.res.Resources r5 = r8.getResources()     // Catch:{ NotFoundException -> 0x007e }
            int r8 = r8.getId()     // Catch:{ NotFoundException -> 0x007e }
            java.lang.String r8 = r5.getResourceName(r8)     // Catch:{ NotFoundException -> 0x007e }
            java.lang.String r5 = "resourceName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)     // Catch:{ NotFoundException -> 0x007e }
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ NotFoundException -> 0x007e }
            java.lang.String r5 = "/"
            kotlin.text.Regex r6 = new kotlin.text.Regex     // Catch:{ NotFoundException -> 0x007e }
            r6.<init>((java.lang.String) r5)     // Catch:{ NotFoundException -> 0x007e }
            java.util.List r8 = r6.split(r8, r4)     // Catch:{ NotFoundException -> 0x007e }
            java.util.Collection r8 = (java.util.Collection) r8     // Catch:{ NotFoundException -> 0x007e }
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch:{ NotFoundException -> 0x007e }
            java.lang.Object[] r8 = r8.toArray(r5)     // Catch:{ NotFoundException -> 0x007e }
            if (r8 == 0) goto L_0x0076
            java.lang.String[] r8 = (java.lang.String[]) r8     // Catch:{ NotFoundException -> 0x007e }
            int r5 = r8.length     // Catch:{ NotFoundException -> 0x007e }
            r6 = 2
            if (r5 != r6) goto L_0x007e
            r8 = r8[r3]     // Catch:{ NotFoundException -> 0x007e }
            r1.add(r8)     // Catch:{ NotFoundException -> 0x007e }
            goto L_0x007e
        L_0x0076:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException     // Catch:{ NotFoundException -> 0x007e }
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.Array<T>"
            r8.<init>(r5)     // Catch:{ NotFoundException -> 0x007e }
            throw r8     // Catch:{ NotFoundException -> 0x007e }
        L_0x007e:
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x00c3 }
            r8.<init>()     // Catch:{ all -> 0x00c3 }
            java.util.List r8 = (java.util.List) r8     // Catch:{ all -> 0x00c3 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00c3 }
        L_0x0089:
            boolean r5 = r1.hasNext()     // Catch:{ all -> 0x00c3 }
            if (r5 == 0) goto L_0x00c2
            java.lang.Object r5 = r1.next()     // Catch:{ all -> 0x00c3 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x00c3 }
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x00c3 }
            int r6 = r6.length()     // Catch:{ all -> 0x00c3 }
            if (r6 <= 0) goto L_0x00a0
            r6 = r3
            goto L_0x00a1
        L_0x00a0:
            r6 = r4
        L_0x00a1:
            if (r6 == 0) goto L_0x0089
            int r6 = r5.length()     // Catch:{ all -> 0x00c3 }
            r7 = 100
            if (r6 > r7) goto L_0x0089
            if (r5 == 0) goto L_0x00ba
            java.lang.String r5 = r5.toLowerCase()     // Catch:{ all -> 0x00c3 }
            java.lang.String r6 = "(this as java.lang.String).toLowerCase()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ all -> 0x00c3 }
            r8.add(r5)     // Catch:{ all -> 0x00c3 }
            goto L_0x0089
        L_0x00ba:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException     // Catch:{ all -> 0x00c3 }
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
            r8.<init>(r1)     // Catch:{ all -> 0x00c3 }
            throw r8     // Catch:{ all -> 0x00c3 }
        L_0x00c2:
            return r8
        L_0x00c3:
            r8 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r8, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.aam.MetadataMatcher.getCurrentViewIndicators(android.view.View):java.util.List");
    }

    @JvmStatic
    public static final List<String> getAroundViewIndicators(View view) {
        Class<MetadataMatcher> cls = MetadataMatcher.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
            List<String> arrayList = new ArrayList<>();
            ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
            View parentOfView = ViewHierarchy.getParentOfView(view);
            if (parentOfView != null) {
                ViewHierarchy viewHierarchy2 = ViewHierarchy.INSTANCE;
                for (View next : ViewHierarchy.getChildrenOfView(parentOfView)) {
                    if (view != next) {
                        arrayList.addAll(INSTANCE.getTextIndicators(next));
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
    public static final boolean matchIndicator(List<String> list, List<String> list2) {
        Class<MetadataMatcher> cls = MetadataMatcher.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(list, "indicators");
            Intrinsics.checkNotNullParameter(list2, "keys");
            for (String matchIndicator : list) {
                if (INSTANCE.matchIndicator(matchIndicator, list2)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    private final boolean matchIndicator(String str, List<String> list) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            for (String contains$default : list) {
                if (StringsKt.contains$default((CharSequence) str, (CharSequence) contains$default, false, 2, (Object) null)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    @JvmStatic
    public static final boolean matchValue(String str, String str2) {
        Class<MetadataMatcher> cls = MetadataMatcher.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(str2, "rule");
            return new Regex(str2).matches(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    private final List<String> getTextIndicators(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            List<String> arrayList = new ArrayList<>();
            if (view instanceof EditText) {
                return arrayList;
            }
            if (view instanceof TextView) {
                String obj = ((TextView) view).getText().toString();
                if ((obj.length() > 0) && obj.length() < 100) {
                    if (obj != null) {
                        String lowerCase = obj.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                        arrayList.add(lowerCase);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                }
                return arrayList;
            }
            ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
            for (View textIndicators : ViewHierarchy.getChildrenOfView(view)) {
                arrayList.addAll(getTextIndicators(textIndicators));
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
