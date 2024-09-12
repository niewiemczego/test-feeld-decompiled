package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.Constants;
import com.braze.enums.CardKey;
import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.models.cards.Card;
import com.braze.storage.ICardStorageProvider;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a0 implements ICardStorageProvider {
    public static final b f = new b((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Set g = SetsKt.setOf(CardKey.VIEWED.getContentCardsKey(), CardKey.DISMISSED.getContentCardsKey());
    /* access modifiers changed from: private */
    public final String a;
    private final z1 b;
    private final SharedPreferences c;
    private final SharedPreferences d;
    private final b2 e;

    static final class a extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, String str2) {
            super(0);
            this.b = str;
            this.c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Detected SDK update from '" + this.b + "' -> '" + this.c + "'. Clearing config update time.";
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(JSONObject jSONObject, JSONObject jSONObject2) {
            Intrinsics.checkNotNullParameter(jSONObject2, "serverCard");
            if (jSONObject == null) {
                return false;
            }
            String contentCardsKey = CardKey.CREATED.getContentCardsKey();
            if (!jSONObject.has(contentCardsKey) || !jSONObject2.has(contentCardsKey) || jSONObject.getLong(contentCardsKey) <= jSONObject2.getLong(contentCardsKey)) {
                return false;
            }
            return true;
        }

        public final JSONObject b(JSONObject jSONObject, JSONObject jSONObject2) {
            Intrinsics.checkNotNullParameter(jSONObject2, "serverCard");
            if (jSONObject == null) {
                return jSONObject2;
            }
            JSONObject jSONObject3 = new JSONObject();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject3.put(next, jSONObject.get(next));
            }
            Iterator<String> keys2 = jSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                if (a0.g.contains(next2)) {
                    jSONObject3.put(next2, jSONObject.getBoolean(next2) || jSONObject2.getBoolean(next2));
                } else {
                    jSONObject3.put(next2, jSONObject2.get(next2));
                }
            }
            return jSONObject3;
        }

        private b() {
        }

        public final boolean a(JSONObject jSONObject, CardKey cardKey) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            Intrinsics.checkNotNullParameter(cardKey, "cardKey");
            String contentCardsKey = cardKey.getContentCardsKey();
            if (jSONObject.has(contentCardsKey)) {
                return jSONObject.getBoolean(contentCardsKey);
            }
            return false;
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Adding card to test cache: " + this.b;
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
            return "Deleting expired card from storage with id: " + this.b;
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
            return "Card not present in storage for id: " + this.b;
        }
    }

    static final class f extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to read card json from storage. Json: " + this.b;
        }
    }

    static final class g extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Removing card from test cache: " + this.b;
        }
    }

    static final class h extends Lambda implements Function0 {
        final /* synthetic */ Set b;
        final /* synthetic */ Set c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(Set set, Set set2) {
            super(0);
            this.b = set;
            this.c = set2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Retaining card ids: " + this.b + " among cached card ids: " + this.c;
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
            return "Removing card from storage with id: " + this.b;
        }
    }

    static final class j extends Lambda implements Function0 {
        final /* synthetic */ JSONObject b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(JSONObject jSONObject) {
            super(0);
            this.b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Server card json: " + this.b;
        }
    }

    static final class k extends Lambda implements Function0 {
        final /* synthetic */ JSONObject b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(JSONObject jSONObject) {
            super(0);
            this.b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cached card json: " + this.b;
        }
    }

    static final class l extends Lambda implements Function0 {
        public static final l b = new l();

        l() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The server card received is older than the cached card. Not updating the cached card.";
        }
    }

    static final class m extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Server card is marked as removed. Removing from card storage with id: " + this.b;
        }
    }

    static final class n extends Lambda implements Function0 {
        final /* synthetic */ JSONObject b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(JSONObject jSONObject) {
            super(0);
            this.b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Server card was locally dismissed already. Not adding card to storage. Server card: " + this.b;
        }
    }

    static final class o extends Lambda implements Function0 {
        final /* synthetic */ JSONObject b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(JSONObject jSONObject) {
            super(0);
            this.b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Server card has expired already. Not adding card to storage. Server card: " + this.b;
        }
    }

    static final class p extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Server card is marked as dismissed. Adding to dismissed cached and removing from card storage with id: " + this.b;
        }
    }

    static final class q extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Can't update card field. Json cannot be parsed from disk or is not present. Id: " + this.b;
        }
    }

    static final class r extends Lambda implements Function0 {
        final /* synthetic */ Object b;
        final /* synthetic */ CardKey c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(Object obj, CardKey cardKey) {
            super(0);
            this.b = obj;
            this.c = cardKey;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to update card json field to " + this.b + " with key: " + this.c;
        }
    }

    public static final class s extends Lambda implements Function1 {
        final /* synthetic */ JSONArray b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(JSONArray jSONArray) {
            super(1);
            this.b = jSONArray;
        }

        public final Boolean a(int i) {
            return Boolean.valueOf(this.b.opt(i) instanceof JSONObject);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public static final class t extends Lambda implements Function1 {
        final /* synthetic */ JSONArray b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(JSONArray jSONArray) {
            super(1);
            this.b = jSONArray;
        }

        public final Object a(int i) {
            Object obj = this.b.get(i);
            if (obj != null) {
                return (JSONObject) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    static final class u extends Lambda implements Function0 {
        public static final u b = new u();

        u() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Input user id was null. Defaulting to the empty user id";
        }
    }

    static final class v extends Lambda implements Function0 {
        final /* synthetic */ Ref.ObjectRef b;
        final /* synthetic */ a0 c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(Ref.ObjectRef objectRef, a0 a0Var) {
            super(0);
            this.b = objectRef;
            this.c = a0Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "The received cards are for user " + ((String) this.b.element) + " and the current user is " + this.c.a + " , the cards will be discarded and no changes will be made.";
        }
    }

    static final class w extends Lambda implements Function0 {
        final /* synthetic */ Ref.ObjectRef b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(Ref.ObjectRef objectRef) {
            super(0);
            this.b = objectRef;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Updating offline Content Cards for user with id: " + ((String) this.b.element);
        }
    }

    public a0(Context context, String str, String str2, z1 z1Var, String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(str2, DynamicLink.Builder.KEY_API_KEY);
        Intrinsics.checkNotNullParameter(z1Var, "brazeManager");
        Intrinsics.checkNotNullParameter(str3, "currentSdkVersion");
        this.a = str;
        this.b = z1Var;
        String cacheFileSuffix = StringUtils.getCacheFileSuffix(context, str, str2);
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.braze.storage.content_cards_storage_provider.metadata" + cacheFileSuffix, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ix, Context.MODE_PRIVATE)");
        this.d = sharedPreferences;
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.appboy.storage.content_cards_storage_provider.cards" + cacheFileSuffix, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "context.getSharedPrefere…ix, Context.MODE_PRIVATE)");
        this.c = sharedPreferences2;
        String string = sharedPreferences.getString("last_accessed_sdk_version", "");
        if (!Intrinsics.areEqual((Object) str3, (Object) string)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new a(string, str3), 2, (Object) null);
            sharedPreferences.edit().putLong("last_full_sync_at", 0).putString("last_accessed_sdk_version", str3).apply();
        }
        this.e = new y();
    }

    private final long g() {
        return this.d.getLong("last_storage_update_timestamp", 0);
    }

    private final void i() {
        this.d.edit().putLong("last_storage_update_timestamp", DateTimeUtils.nowInSeconds()).apply();
    }

    /* renamed from: b */
    public ContentCardsUpdatedEvent getCachedCardsAsEvent() {
        return a(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
        r0 = kotlin.collections.CollectionsKt.toMutableSet((r0 = kotlin.collections.CollectionsKt.filterNotNull(r0)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Set c() {
        /*
            r3 = this;
            android.content.SharedPreferences r0 = r3.d
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.lang.String r2 = "dismissed"
            java.util.Set r0 = r0.getStringSet(r2, r1)
            if (r0 == 0) goto L_0x001b
            java.util.List r0 = kotlin.collections.CollectionsKt.filterNotNull(r0)
            if (r0 == 0) goto L_0x001b
            java.util.Set r0 = kotlin.collections.CollectionsKt.toMutableSet(r0)
            if (r0 != 0) goto L_0x0023
        L_0x001b:
            java.util.Set r0 = kotlin.collections.SetsKt.emptySet()
            java.util.Set r0 = kotlin.collections.CollectionsKt.toMutableSet(r0)
        L_0x0023:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.a0.c():java.util.Set");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
        r0 = kotlin.collections.CollectionsKt.toMutableSet((r0 = kotlin.collections.CollectionsKt.filterNotNull(r0)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Set d() {
        /*
            r3 = this;
            android.content.SharedPreferences r0 = r3.d
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.lang.String r2 = "expired"
            java.util.Set r0 = r0.getStringSet(r2, r1)
            if (r0 == 0) goto L_0x001b
            java.util.List r0 = kotlin.collections.CollectionsKt.filterNotNull(r0)
            if (r0 == 0) goto L_0x001b
            java.util.Set r0 = kotlin.collections.CollectionsKt.toMutableSet(r0)
            if (r0 != 0) goto L_0x0023
        L_0x001b:
            java.util.Set r0 = kotlin.collections.SetsKt.emptySet()
            java.util.Set r0 = kotlin.collections.CollectionsKt.toMutableSet(r0)
        L_0x0023:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.a0.d():java.util.Set");
    }

    public final long e() {
        return this.d.getLong("last_card_updated_at", 0);
    }

    public final long f() {
        return this.d.getLong("last_full_sync_at", 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
        r0 = kotlin.collections.CollectionsKt.toMutableSet((r0 = kotlin.collections.CollectionsKt.filterNotNull(r0)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Set h() {
        /*
            r3 = this;
            android.content.SharedPreferences r0 = r3.d
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.lang.String r2 = "test"
            java.util.Set r0 = r0.getStringSet(r2, r1)
            if (r0 == 0) goto L_0x001c
            java.util.List r0 = kotlin.collections.CollectionsKt.filterNotNull(r0)
            if (r0 == 0) goto L_0x001c
            java.util.Set r0 = kotlin.collections.CollectionsKt.toMutableSet(r0)
            if (r0 == 0) goto L_0x001c
            goto L_0x0024
        L_0x001c:
            java.util.Set r0 = kotlin.collections.SetsKt.emptySet()
            java.util.Set r0 = kotlin.collections.CollectionsKt.toMutableSet(r0)
        L_0x0024:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.a0.h():java.util.Set");
    }

    public void markCardAsClicked(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        a(str, CardKey.CLICKED, Boolean.TRUE);
    }

    public void markCardAsDismissed(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        a(str);
        a(str, (JSONObject) null);
    }

    public void markCardAsViewed(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        a(str, CardKey.VIEWED, Boolean.TRUE);
    }

    public void markCardAsVisuallyRead(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        a(str, CardKey.READ, Boolean.TRUE);
    }

    private final void b(JSONObject jSONObject) {
        Set c2 = c();
        Set d2 = d();
        String string = jSONObject.getString(CardKey.ID.getContentCardsKey());
        Intrinsics.checkNotNullExpressionValue(string, "serverCardId");
        JSONObject d3 = d(string);
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger brazeLogger2 = brazeLogger;
        BrazeLogger.brazelog$default(brazeLogger2, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new j(jSONObject), 3, (Object) null);
        BrazeLogger.brazelog$default(brazeLogger2, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new k(d3), 3, (Object) null);
        b bVar = f;
        if (bVar.a(d3, jSONObject)) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) l.b, 2, (Object) null);
        } else if (bVar.a(jSONObject, CardKey.REMOVED)) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new m(string), 3, (Object) null);
            e(string);
            f(string);
            a(string, (JSONObject) null);
        } else if (c2.contains(string)) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new n(jSONObject), 3, (Object) null);
        } else if (d2.contains(string)) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new o(jSONObject), 3, (Object) null);
        } else if (bVar.a(jSONObject, CardKey.DISMISSED)) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new p(string), 3, (Object) null);
            a(string);
            a(string, (JSONObject) null);
        } else {
            a(string, bVar.b(d3, jSONObject));
            if (bVar.a(jSONObject, CardKey.IS_TEST)) {
                c(string);
            }
        }
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        Set c2 = c();
        c2.remove(str);
        this.d.edit().putStringSet(UIManagerModuleConstants.ACTION_DISMISSED, c2).apply();
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new g(str), 2, (Object) null);
        Set h2 = h();
        h2.remove(str);
        this.d.edit().putStringSet("test", h2).apply();
    }

    public final ContentCardsUpdatedEvent a(z zVar, String str) {
        Intrinsics.checkNotNullParameter(zVar, "contentCardsResponse");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = str;
        if (str == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) u.b, 3, (Object) null);
            objectRef.element = "";
        }
        if (!Intrinsics.areEqual((Object) this.a, (Object) objectRef.element)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new v(objectRef, this), 2, (Object) null);
            return null;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new w(objectRef), 2, (Object) null);
        a(zVar);
        i();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        JSONArray a2 = zVar.a();
        if (!(a2 == null || a2.length() == 0)) {
            for (JSONObject jSONObject : SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(RangesKt.until(0, a2.length())), new s(a2)), new t(a2))) {
                b(jSONObject);
                String string = jSONObject.getString(CardKey.ID.getContentCardsKey());
                Intrinsics.checkNotNullExpressionValue(string, "serverCardJson.getString…rdKey.ID.contentCardsKey)");
                linkedHashSet.add(string);
            }
        }
        if (zVar.d()) {
            b((Set) linkedHashSet);
            c((Set) linkedHashSet);
            linkedHashSet.addAll(h());
            a((Set) linkedHashSet);
        }
        return a(false);
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new c(str), 2, (Object) null);
        Set h2 = h();
        h2.add(str);
        this.d.edit().putStringSet("test", h2).apply();
    }

    public final JSONObject d(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        String string = this.c.getString(str, (String) null);
        if (string == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new e(str), 3, (Object) null);
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) new f(string));
            return null;
        }
    }

    public final void c(Set set) {
        Intrinsics.checkNotNullParameter(set, "cardIdsToRetain");
        Set d2 = d();
        d2.retainAll(set);
        this.d.edit().putStringSet("expired", d2).apply();
    }

    public final void b(Set set) {
        Intrinsics.checkNotNullParameter(set, "cardIdsToRetain");
        Set c2 = c();
        c2.retainAll(set);
        this.d.edit().putStringSet(UIManagerModuleConstants.ACTION_DISMISSED, c2).apply();
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        Set d2 = d();
        d2.add(str);
        this.d.edit().putStringSet("expired", d2).apply();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(Context context, String str, String str2, z1 z1Var, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, str2, z1Var, (i2 & 16) != 0 ? Constants.BRAZE_SDK_VERSION : str3);
    }

    public final Card a(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "cardJson");
        return u.a(jSONObject, CardKey.Provider.CONTENT_CARDS, this.b, (ICardStorageProvider) this, this.e);
    }

    public final ContentCardsUpdatedEvent a(boolean z) {
        CardKey.Provider provider = CardKey.Provider.CONTENT_CARDS;
        Map<String, ?> all = this.c.getAll();
        JSONArray jSONArray = new JSONArray();
        Iterator<?> it = all.values().iterator();
        while (it.hasNext()) {
            jSONArray.put((Object) (String) it.next());
        }
        List a2 = u.a(jSONArray, provider, this.b, (ICardStorageProvider) this, this.e);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object next : a2) {
            if (((Card) next).isExpired()) {
                arrayList.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List list = (List) pair.component2();
        for (Card a3 : (List) pair.component1()) {
            a(a3);
        }
        return new ContentCardsUpdatedEvent(list, this.a, g(), z);
    }

    public final void a(Card card) {
        Intrinsics.checkNotNullParameter(card, "card");
        String id = card.getId();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new d(id), 3, (Object) null);
        a(id, (JSONObject) null);
        b(id);
        f(id);
    }

    public final void a(String str, CardKey cardKey, Object obj) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        Intrinsics.checkNotNullParameter(cardKey, "cardKey");
        Intrinsics.checkNotNullParameter(obj, "value");
        JSONObject d2 = d(str);
        if (d2 == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new q(str), 3, (Object) null);
            return;
        }
        try {
            d2.put(cardKey.getContentCardsKey(), obj);
            a(str, d2);
        } catch (JSONException e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) new r(obj, cardKey));
        }
    }

    public final void a(z zVar) {
        Intrinsics.checkNotNullParameter(zVar, "contentCardsResponse");
        SharedPreferences.Editor edit = this.d.edit();
        if (zVar.b() != -1) {
            edit.putLong("last_card_updated_at", zVar.b());
        }
        if (zVar.c() != -1) {
            edit.putLong("last_full_sync_at", zVar.c());
        }
        edit.apply();
    }

    public final void a(String str, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        SharedPreferences.Editor edit = this.c.edit();
        if (jSONObject != null) {
            edit.putString(str, jSONObject.toString());
        } else {
            edit.remove(str);
        }
        edit.apply();
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        Set c2 = c();
        c2.add(str);
        this.d.edit().putStringSet(UIManagerModuleConstants.ACTION_DISMISSED, c2).apply();
    }

    public final void a(Set set) {
        Intrinsics.checkNotNullParameter(set, "cardIdsToRetain");
        Set<String> keySet = this.c.getAll().keySet();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new h(set, keySet), 3, (Object) null);
        SharedPreferences.Editor edit = this.c.edit();
        for (String next : keySet) {
            if (!set.contains(next)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new i(next), 3, (Object) null);
                edit.remove(next);
            }
        }
        edit.apply();
    }
}
