package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.braze.support.BrazeFileUtils;
import com.braze.support.BrazeLogger;
import com.braze.support.IntentUtils;
import com.braze.support.WebContentUtils;
import com.google.firebase.dynamiclinks.DynamicLink;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

public final class f6 implements s2 {
    public static final a e = new a((DefaultConstructorMarker) null);
    private final SharedPreferences a;
    private final Map b;
    private final Map c = new LinkedHashMap();
    private final File d;

    public static final class a {

        /* renamed from: bo.app.f6$a$a  reason: collision with other inner class name */
        static final class C0007a extends Lambda implements Function0 {
            final /* synthetic */ File[] b;

            /* renamed from: bo.app.f6$a$a$a  reason: collision with other inner class name */
            static final class C0008a extends Lambda implements Function1 {
                public static final C0008a b = new C0008a();

                C0008a() {
                    super(1);
                }

                /* renamed from: a */
                public final CharSequence invoke(File file) {
                    String name = file.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "it.name");
                    return name;
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0007a(File[] fileArr) {
                super(0);
                this.b = fileArr;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Local triggered asset directory contains files: " + ArraysKt.joinToString$default((Object[]) this.b, (CharSequence) " , ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) C0008a.b, 30, (Object) null);
            }
        }

        static final class b extends Lambda implements Function0 {
            final /* synthetic */ File b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(File file) {
                super(0);
                this.b = file;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Deleting obsolete asset '" + this.b.getPath() + "' from filesystem.";
            }
        }

        static final class c extends Lambda implements Function0 {
            public static final c b = new c();

            c() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Exception while deleting obsolete assets from filesystem.";
            }
        }

        static final class d extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Not removing local path for remote path " + this.b + " from cache because it is being preserved until the end of the app run.";
            }
        }

        static final class e extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ String c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(String str, String str2) {
                super(0);
                this.b = str;
                this.c = str2;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Removing obsolete local path " + this.b + " for obsolete remote path " + this.c + " from cache.";
            }
        }

        static final class f extends Lambda implements Function0 {
            final /* synthetic */ File b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(File file) {
                super(0);
                this.b = file;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Deleting triggers directory at: " + this.b.getAbsolutePath();
            }
        }

        static final class g extends Lambda implements Function0 {
            final /* synthetic */ Ref.ObjectRef b;
            final /* synthetic */ String c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            g(Ref.ObjectRef objectRef, String str) {
                super(0);
                this.b = objectRef;
                this.c = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Using file extension " + ((String) this.b.element) + " for remote asset url: " + this.c;
            }
        }

        static final class h extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ String c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            h(String str, String str2) {
                super(0);
                this.b = str;
                this.c = str2;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Retrieving trigger local asset path '" + this.b + "' from local storage for remote path '" + this.c + '\'';
            }
        }

        static final class i extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            i(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Encountered unexpected exception while parsing stored triggered action local assets on remote asset '" + this.b + '\'';
            }
        }

        static final class j extends Lambda implements Function0 {
            final /* synthetic */ z2 b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            j(z2 z2Var) {
                super(0);
                this.b = z2Var;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Pre-fetch off for triggered action " + this.b.getId() + ". Not pre-fetching assets.";
            }
        }

        static final class k extends Lambda implements Function0 {
            final /* synthetic */ z2 b;
            final /* synthetic */ String c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            k(z2 z2Var, String str) {
                super(0);
                this.b = z2Var;
                this.c = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Received new remote path for triggered action " + this.b.getId() + " at " + this.c + '.';
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            File file = new File(context.getCacheDir(), "ab_triggers");
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new f(file), 2, (Object) null);
            BrazeFileUtils.deleteFileOrDirectory(file);
        }

        public final String b(String str) {
            int lastIndexOf$default;
            Intrinsics.checkNotNullParameter(str, "remoteAssetUrl");
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String lastPathSegment = parse.getLastPathSegment();
                if (!(lastPathSegment == null || lastPathSegment.length() == 0) && (lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) lastPathSegment, '.', 0, false, 6, (Object) null)) > -1) {
                    T substring = lastPathSegment.substring(lastIndexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    objectRef.element = substring;
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f6.e, BrazeLogger.Priority.V, (Throwable) null, (Function0) new g(objectRef, str), 2, (Object) null);
                }
            }
            return IntentUtils.getRequestCode() + ((String) objectRef.element);
        }

        private a() {
        }

        public final void a(File file, Map map, Map map2) {
            Intrinsics.checkNotNullParameter(file, "triggeredAssetDirectory");
            Intrinsics.checkNotNullParameter(map, "remoteToLocalAssetsMap");
            Intrinsics.checkNotNullParameter(map2, "preservedLocalAssetMap");
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new C0007a(listFiles), 2, (Object) null);
                try {
                    ArrayList arrayList = new ArrayList();
                    for (File file2 : listFiles) {
                        if (!map.containsValue(file2.getPath())) {
                            arrayList.add(file2);
                        }
                    }
                    ArrayList<File> arrayList2 = new ArrayList<>();
                    for (Object next : arrayList) {
                        if (!map2.containsValue(((File) next).getPath())) {
                            arrayList2.add(next);
                        }
                    }
                    for (File file3 : arrayList2) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f6.e, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new b(file3), 3, (Object) null);
                        Intrinsics.checkNotNullExpressionValue(file3, "obsoleteFile");
                        BrazeFileUtils.deleteFileOrDirectory(file3);
                    }
                } catch (Exception e2) {
                    BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) c.b);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0046 A[Catch:{ Exception -> 0x005e }] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0027 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.Map a(android.content.SharedPreferences r15) {
            /*
                r14 = this;
                java.lang.String r0 = "storagePrefs"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
                java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
                r0.<init>()
                java.util.Map r1 = r15.getAll()
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L_0x001b
                boolean r4 = r1.isEmpty()
                if (r4 == 0) goto L_0x0019
                goto L_0x001b
            L_0x0019:
                r4 = r2
                goto L_0x001c
            L_0x001b:
                r4 = r3
            L_0x001c:
                if (r4 == 0) goto L_0x001f
                return r0
            L_0x001f:
                java.util.Set r1 = r1.keySet()
                java.util.Iterator r1 = r1.iterator()
            L_0x0027:
                boolean r4 = r1.hasNext()
                if (r4 == 0) goto L_0x006c
                java.lang.Object r4 = r1.next()
                java.lang.String r4 = (java.lang.String) r4
                r5 = 0
                java.lang.String r5 = r15.getString(r4, r5)     // Catch:{ Exception -> 0x005e }
                if (r5 == 0) goto L_0x0043
                boolean r6 = kotlin.text.StringsKt.isBlank(r5)     // Catch:{ Exception -> 0x005e }
                if (r6 == 0) goto L_0x0041
                goto L_0x0043
            L_0x0041:
                r6 = r2
                goto L_0x0044
            L_0x0043:
                r6 = r3
            L_0x0044:
                if (r6 != 0) goto L_0x0027
                com.braze.support.BrazeLogger r7 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x005e }
                r9 = 0
                r10 = 0
                bo.app.f6$a$h r11 = new bo.app.f6$a$h     // Catch:{ Exception -> 0x005e }
                r11.<init>(r5, r4)     // Catch:{ Exception -> 0x005e }
                r12 = 3
                r13 = 0
                r8 = r14
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r7, (java.lang.Object) r8, (com.braze.support.BrazeLogger.Priority) r9, (java.lang.Throwable) r10, (kotlin.jvm.functions.Function0) r11, (int) r12, (java.lang.Object) r13)     // Catch:{ Exception -> 0x005e }
                java.lang.String r6 = "remoteAssetKey"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)     // Catch:{ Exception -> 0x005e }
                r0.put(r4, r5)     // Catch:{ Exception -> 0x005e }
                goto L_0x0027
            L_0x005e:
                r5 = move-exception
                com.braze.support.BrazeLogger r6 = com.braze.support.BrazeLogger.INSTANCE
                com.braze.support.BrazeLogger$Priority r7 = com.braze.support.BrazeLogger.Priority.E
                bo.app.f6$a$i r8 = new bo.app.f6$a$i
                r8.<init>(r4)
                r6.brazelog((java.lang.Object) r14, (com.braze.support.BrazeLogger.Priority) r7, (java.lang.Throwable) r5, (kotlin.jvm.functions.Function0<java.lang.String>) r8)
                goto L_0x0027
            L_0x006c:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: bo.app.f6.a.a(android.content.SharedPreferences):java.util.Map");
        }

        public final void a(SharedPreferences.Editor editor, Map map, Set set, Map map2) {
            Intrinsics.checkNotNullParameter(editor, "editor");
            Intrinsics.checkNotNullParameter(map, "localAssetPaths");
            Intrinsics.checkNotNullParameter(set, "newRemotePathStrings");
            Intrinsics.checkNotNullParameter(map2, "preservedLocalAssetPathMap");
            Iterator it = new HashSet(map.keySet()).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (map2.containsKey(str)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new d(str), 3, (Object) null);
                } else if (!set.contains(str)) {
                    map.remove(str);
                    editor.remove(str);
                    String str2 = (String) map.get(str);
                    if (!(str2 == null || StringsKt.isBlank(str2))) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new e(str2, str), 3, (Object) null);
                        BrazeFileUtils.deleteFileOrDirectory(new File(str2));
                    }
                }
            }
        }

        public final boolean a(String str) {
            Intrinsics.checkNotNullParameter(str, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
            return new File(str).exists();
        }

        public final Pair a(List list) {
            Intrinsics.checkNotNullParameter(list, "triggeredActions");
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                z2 z2Var = (z2) it.next();
                if (!z2Var.d()) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new j(z2Var), 3, (Object) null);
                } else {
                    for (s4 s4Var : z2Var.l()) {
                        String b2 = s4Var.b();
                        if (!StringsKt.isBlank(b2)) {
                            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new k(z2Var, b2), 3, (Object) null);
                            linkedHashSet.add(s4Var);
                            linkedHashSet2.add(b2);
                        }
                    }
                }
            }
            return new Pair(linkedHashSet, linkedHashSet2);
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                bo.app.t4[] r0 = bo.app.t4.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                bo.app.t4 r1 = bo.app.t4.ZIP     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                bo.app.t4 r1 = bo.app.t4.IMAGE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                bo.app.t4 r1 = bo.app.t4.FILE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bo.app.f6.b.<clinit>():void");
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str, String str2) {
            super(0);
            this.b = str;
            this.c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Storing local triggered action html zip asset at local path " + this.b + " for remote path " + this.c;
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to store html zip asset for remote path " + this.b + ". Not storing local asset";
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not download " + this.b;
        }
    }

    static final class f extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ Map c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(String str, Map map) {
            super(0);
            this.b = str;
            this.c = map;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not caching " + this.b + " due to headers " + this.c;
        }
    }

    static final class g extends Lambda implements Function0 {
        final /* synthetic */ Uri b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(Uri uri, String str) {
            super(0);
            this.b = uri;
            this.c = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Storing local triggered action asset at local path " + this.b.getPath() + " for remote path " + this.c;
        }
    }

    static final class h extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to store asset for remote path " + this.b + ". Not storing local asset";
        }
    }

    static final class i extends Lambda implements Function0 {
        final /* synthetic */ z2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(z2 z2Var) {
            super(0);
            this.b = z2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Prefetch is turned off for this triggered action. Not retrieving local asset paths. Action id: " + this.b.getId();
        }
    }

    static final class j extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(String str, String str2) {
            super(0);
            this.b = str;
            this.c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Found local asset at path " + this.b + " for remote asset at path: " + this.c;
        }
    }

    static final class k extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not find local asset for remote path " + this.b;
        }
    }

    static final class l extends Lambda implements Function0 {
        final /* synthetic */ z2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(z2 z2Var) {
            super(0);
            this.b = z2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "No local assets found for action id: " + this.b.getId();
        }
    }

    static final class m extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(String str, String str2) {
            super(0);
            this.b = str;
            this.c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Adding new local path '" + this.b + "' for remote path '" + this.c + "' to cache.";
        }
    }

    static final class n extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add new local path for remote path " + this.b;
        }
    }

    public f6(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, DynamicLink.Builder.KEY_API_KEY);
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.storage.triggers.local_assets." + str, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ey, Context.MODE_PRIVATE)");
        this.a = sharedPreferences;
        this.b = e.a(sharedPreferences);
        this.d = new File(context.getCacheDir().getPath() + "/ab_triggers");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x007e A[Catch:{ Exception -> 0x0096 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.List r12) {
        /*
            r11 = this;
            java.lang.String r0 = "triggeredActions"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            bo.app.f6$a r0 = e
            kotlin.Pair r12 = r0.a((java.util.List) r12)
            java.lang.Object r1 = r12.component1()
            java.util.Set r1 = (java.util.Set) r1
            java.lang.Object r12 = r12.component2()
            java.util.Set r12 = (java.util.Set) r12
            android.content.SharedPreferences r2 = r11.a
            android.content.SharedPreferences$Editor r2 = r2.edit()
            java.lang.String r3 = "localAssetEditor"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.util.Map r3 = r11.b
            java.util.Map r4 = r11.c
            r0.a(r2, r3, r12, r4)
            java.io.File r12 = r11.d
            java.util.Map r3 = r11.b
            java.util.Map r4 = r11.c
            r0.a(r12, r3, r4)
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.Iterator r0 = r1.iterator()
        L_0x003b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0058
            java.lang.Object r1 = r0.next()
            r3 = r1
            bo.app.s4 r3 = (bo.app.s4) r3
            java.util.Map r4 = r11.b
            java.lang.String r3 = r3.b()
            boolean r3 = r4.containsKey(r3)
            if (r3 != 0) goto L_0x003b
            r12.add(r1)
            goto L_0x003b
        L_0x0058:
            java.util.Iterator r12 = r12.iterator()
        L_0x005c:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x00a4
            java.lang.Object r0 = r12.next()
            bo.app.s4 r0 = (bo.app.s4) r0
            java.lang.String r1 = r0.b()
            java.lang.String r0 = r11.a((bo.app.s4) r0)     // Catch:{ Exception -> 0x0096 }
            if (r0 == 0) goto L_0x007b
            boolean r3 = kotlin.text.StringsKt.isBlank(r0)     // Catch:{ Exception -> 0x0096 }
            if (r3 == 0) goto L_0x0079
            goto L_0x007b
        L_0x0079:
            r3 = 0
            goto L_0x007c
        L_0x007b:
            r3 = 1
        L_0x007c:
            if (r3 != 0) goto L_0x005c
            com.braze.support.BrazeLogger r4 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x0096 }
            r6 = 0
            r7 = 0
            bo.app.f6$m r8 = new bo.app.f6$m     // Catch:{ Exception -> 0x0096 }
            r8.<init>(r0, r1)     // Catch:{ Exception -> 0x0096 }
            r9 = 3
            r10 = 0
            r5 = r11
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (kotlin.jvm.functions.Function0) r8, (int) r9, (java.lang.Object) r10)     // Catch:{ Exception -> 0x0096 }
            java.util.Map r3 = r11.b     // Catch:{ Exception -> 0x0096 }
            r3.put(r1, r0)     // Catch:{ Exception -> 0x0096 }
            r2.putString(r1, r0)     // Catch:{ Exception -> 0x0096 }
            goto L_0x005c
        L_0x0096:
            r0 = move-exception
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.E
            bo.app.f6$n r5 = new bo.app.f6$n
            r5.<init>(r1)
            r3.brazelog((java.lang.Object) r11, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r0, (kotlin.jvm.functions.Function0<java.lang.String>) r5)
            goto L_0x005c
        L_0x00a4:
            r2.apply()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.f6.a(java.util.List):void");
    }

    public Map a(z2 z2Var) {
        Intrinsics.checkNotNullParameter(z2Var, "triggeredAction");
        if (!z2Var.d()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new i(z2Var), 3, (Object) null);
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (s4 b2 : z2Var.l()) {
            String b3 = b2.b();
            String str = (String) this.b.get(b3);
            if (str == null || !e.a(str)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new k(b3), 2, (Object) null);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new j(str, b3), 3, (Object) null);
                this.c.put(b3, str);
                linkedHashMap.put(b3, str);
            }
        }
        if (linkedHashMap.isEmpty()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new l(z2Var), 2, (Object) null);
        }
        return linkedHashMap;
    }

    public final String a(s4 s4Var) {
        Long a2;
        Intrinsics.checkNotNullParameter(s4Var, "remotePath");
        String b2 = s4Var.b();
        int i2 = b.a[s4Var.a().ordinal()];
        boolean z = true;
        if (i2 == 1) {
            String localHtmlUrlFromRemoteUrl = WebContentUtils.getLocalHtmlUrlFromRemoteUrl(this.d, b2);
            if (localHtmlUrlFromRemoteUrl != null && !StringsKt.isBlank(localHtmlUrlFromRemoteUrl)) {
                z = false;
            }
            if (!z) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new c(localHtmlUrlFromRemoteUrl, b2), 2, (Object) null);
                return localHtmlUrlFromRemoteUrl;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new d(b2), 3, (Object) null);
            return null;
        } else if (i2 == 2 || i2 == 3) {
            String b3 = e.b(b2);
            try {
                String file = this.d.toString();
                Intrinsics.checkNotNullExpressionValue(file, "triggeredAssetDirectory.toString()");
                Pair downloadFileToPath$default = BrazeFileUtils.downloadFileToPath$default(file, b2, b3, (String) null, 8, (Object) null);
                File file2 = (File) downloadFileToPath$default.component1();
                Map map = (Map) downloadFileToPath$default.component2();
                String str = (String) map.get(PermissionsResponse.EXPIRES_KEY);
                if (str == null || (a2 = com.braze.support.g.a(str)) == null || a2.longValue() > 0) {
                    Uri fromFile = Uri.fromFile(file2);
                    if (fromFile != null) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new g(fromFile, b2), 2, (Object) null);
                        return fromFile.getPath();
                    }
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new h(b2), 3, (Object) null);
                    return null;
                }
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new f(b2, map), 3, (Object) null);
                return null;
            } catch (Exception e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) new e(b2));
                return null;
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
