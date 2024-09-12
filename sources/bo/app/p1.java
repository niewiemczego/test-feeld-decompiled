package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.enums.CardKey;
import com.braze.events.FeedUpdatedEvent;
import com.braze.models.cards.Card;
import com.braze.storage.ICardStorageProvider;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p1 implements ICardStorageProvider {
    public static final b f = new b((DefaultConstructorMarker) null);
    private final z1 a;
    private final SharedPreferences b;
    private final Set c;
    private final Set d;
    private final b2 e = new o1();

    public enum a {
        READ_CARDS("read_cards_set", "read_cards_flat"),
        VIEWED_CARDS("viewed_cards_set", "viewed_cards_flat");
        
        private final String b;
        private final String c;

        private a(String str, String str2) {
            this.b = str;
            this.c = str2;
        }

        public final String b() {
            return this.c;
        }

        public final String c() {
            return this.b;
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set a(String str) {
            Intrinsics.checkNotNullParameter(str, "input");
            HashSet hashSet = new HashSet();
            String[] strArr = (String[]) StringsKt.split$default((CharSequence) str, new String[]{";"}, false, 0, 6, (Object) null).toArray(new String[0]);
            Collections.addAll(hashSet, Arrays.copyOf(strArr, strArr.length));
            return hashSet;
        }

        private b() {
        }

        public final Set a(JSONArray jSONArray) {
            Intrinsics.checkNotNullParameter(jSONArray, "cardsArray");
            HashSet hashSet = new HashSet();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                CardKey cardKey = CardKey.ID;
                if (jSONObject.has(cardKey.getFeedKey())) {
                    String string = jSONObject.getString(cardKey.getFeedKey());
                    Intrinsics.checkNotNullExpressionValue(string, "card.getString(CardKey.ID.feedKey)");
                    hashSet.add(string);
                }
            }
            return hashSet;
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
            return "Updating offline feed for user with id: " + this.b;
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str, String str2) {
            super(0);
            this.b = str;
            this.c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "The received cards are for user " + this.b + " and the current user is " + this.c + ", the cards will be discarded and no changes will be made.";
        }
    }

    public p1(Context context, String str, z1 z1Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(z1Var, "brazeManager");
        this.a = z1Var;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.storage.feedstorageprovider" + StringUtils.getCacheFileSuffix(context, str == null ? "" : str), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…Id, Context.MODE_PRIVATE)");
        this.b = sharedPreferences;
        this.c = a(a.VIEWED_CARDS);
        this.d = a(a.READ_CARDS);
        a(str);
    }

    /* renamed from: a */
    public FeedUpdatedEvent getCachedCardsAsEvent() {
        return a(new JSONArray(this.b.getString("cards", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)), this.b.getString("uid", ""), true, this.b.getLong("cards_timestamp", -1));
    }

    public void markCardAsClicked(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
    }

    public void markCardAsDismissed(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
    }

    public void markCardAsViewed(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        if (!this.c.contains(str)) {
            this.c.add(str);
            a(this.c, a.VIEWED_CARDS);
        }
    }

    public void markCardAsVisuallyRead(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        if (!this.d.contains(str)) {
            this.d.add(str);
            a(this.d, a.READ_CARDS);
        }
    }

    public final FeedUpdatedEvent a(JSONArray jSONArray, String str) {
        Intrinsics.checkNotNullParameter(jSONArray, "cardsArray");
        String str2 = str == null ? "" : str;
        String string = this.b.getString("uid", "");
        if (Intrinsics.areEqual((Object) string, (Object) str2)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new c(str), 2, (Object) null);
            long nowInSeconds = DateTimeUtils.nowInSeconds();
            a(jSONArray, nowInSeconds);
            Set set = this.c;
            b bVar = f;
            set.retainAll(bVar.a(jSONArray));
            a(this.c, a.VIEWED_CARDS);
            this.d.retainAll(bVar.a(jSONArray));
            a(this.d, a.READ_CARDS);
            return a(jSONArray, str, false, nowInSeconds);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new d(str, string), 3, (Object) null);
        return null;
    }

    private final FeedUpdatedEvent a(JSONArray jSONArray, String str, boolean z, long j) {
        List list;
        if (jSONArray.length() == 0) {
            list = new ArrayList();
        } else {
            list = u.a(jSONArray, new CardKey.Provider(false), this.a, (ICardStorageProvider) this, this.e);
        }
        List<Card> list2 = list;
        for (Card card : list2) {
            if (this.c.contains(card.getId())) {
                card.setViewed(true);
                card.setIndicatorHighlighted(true);
            }
            if (this.d.contains(card.getId())) {
                card.setIndicatorHighlighted(true);
            }
        }
        return new FeedUpdatedEvent(list2, str, z, j);
    }

    private final Set a(a aVar) {
        String b2 = aVar.b();
        if (this.b.contains(b2)) {
            Set set = null;
            String string = this.b.getString(b2, (String) null);
            if (string != null) {
                set = f.a(string);
            }
            SharedPreferences.Editor edit = this.b.edit();
            edit.remove(b2);
            edit.apply();
            if (set != null) {
                a(set, aVar);
                return set;
            }
        }
        return new ConcurrentSkipListSet(this.b.getStringSet(aVar.c(), new HashSet()));
    }

    private final void a(JSONArray jSONArray, long j) {
        SharedPreferences.Editor edit = this.b.edit();
        if (jSONArray.length() == 0) {
            edit.remove("cards");
        } else {
            edit.putString("cards", jSONArray.toString());
        }
        edit.putLong("cards_timestamp", j);
        edit.apply();
    }

    private final void a(String str) {
        SharedPreferences.Editor edit = this.b.edit();
        edit.putString("uid", str);
        edit.apply();
    }

    public final void a(Set set, a aVar) {
        Intrinsics.checkNotNullParameter(set, "cardIds");
        Intrinsics.checkNotNullParameter(aVar, "property");
        String c2 = aVar.c();
        SharedPreferences.Editor edit = this.b.edit();
        if (set.isEmpty()) {
            edit.remove(c2);
        } else {
            edit.putStringSet(c2, set);
        }
        edit.apply();
    }
}
