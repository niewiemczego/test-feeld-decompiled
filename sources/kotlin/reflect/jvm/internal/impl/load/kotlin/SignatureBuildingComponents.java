package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SignatureBuildingComponents.kt */
public final class SignatureBuildingComponents {
    public static final SignatureBuildingComponents INSTANCE = new SignatureBuildingComponents();

    private SignatureBuildingComponents() {
    }

    public final String javaLang(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return "java/lang/" + str;
    }

    public final String javaUtil(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return "java/util/" + str;
    }

    public final String javaFunction(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return "java/util/function/" + str;
    }

    public final Set<String> inJavaLang(String str, String... strArr) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(strArr, "signatures");
        return inClass(javaLang(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final Set<String> inJavaUtil(String str, String... strArr) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(strArr, "signatures");
        return inClass(javaUtil(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final Set<String> inClass(String str, String... strArr) {
        Intrinsics.checkNotNullParameter(str, "internalName");
        Intrinsics.checkNotNullParameter(strArr, "signatures");
        Collection linkedHashSet = new LinkedHashSet();
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            linkedHashSet.add(str + '.' + strArr[i]);
        }
        return (Set) linkedHashSet;
    }

    public final String signature(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "internalName");
        Intrinsics.checkNotNullParameter(str2, "jvmDescriptor");
        return str + '.' + str2;
    }

    public final String jvmDescriptor(String str, List<String> list, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS);
        Intrinsics.checkNotNullParameter(str2, "ret");
        return str + '(' + CollectionsKt.joinToString$default(list, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, SignatureBuildingComponents$jvmDescriptor$1.INSTANCE, 30, (Object) null) + ')' + escapeClassName(str2);
    }

    /* access modifiers changed from: private */
    public final String escapeClassName(String str) {
        return str.length() > 1 ? 'L' + str + ';' : str;
    }

    public final String[] constructors(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "signatures");
        Collection arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            arrayList.add("<init>(" + strArr[i] + ")V");
        }
        Object[] array = ((List) arrayList).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }
}
