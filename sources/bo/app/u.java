package bo.app;

import com.braze.enums.CardKey;
import com.braze.models.cards.Card;
import com.braze.storage.ICardStorageProvider;
import com.braze.support.BrazeLogger;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;

public final class u {
    public static final u a = new u();

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.braze.enums.CardType[] r0 = com.braze.enums.CardType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.braze.enums.CardType r1 = com.braze.enums.CardType.IMAGE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.braze.enums.CardType r1 = com.braze.enums.CardType.CAPTIONED_IMAGE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.braze.enums.CardType r1 = com.braze.enums.CardType.SHORT_NEWS     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.braze.enums.CardType r1 = com.braze.enums.CardType.TEXT_ANNOUNCEMENT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.braze.enums.CardType r1 = com.braze.enums.CardType.CONTROL     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bo.app.u.a.<clinit>():void");
        }
    }

    public static final class b extends Lambda implements Function1 {
        final /* synthetic */ JSONArray b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(JSONArray jSONArray) {
            super(1);
            this.b = jSONArray;
        }

        public final Boolean a(int i) {
            return Boolean.valueOf(this.b.opt(i) instanceof Object);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public static final class c extends Lambda implements Function1 {
        final /* synthetic */ JSONArray b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(JSONArray jSONArray) {
            super(1);
            this.b = jSONArray;
        }

        public final Object a(int i) {
            Object obj = this.b.get(i);
            if (obj != null) {
                return obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    static final class d extends Lambda implements Function1 {
        final /* synthetic */ CardKey.Provider b;
        final /* synthetic */ z1 c;
        final /* synthetic */ ICardStorageProvider d;
        final /* synthetic */ b2 e;
        final /* synthetic */ JSONArray f;

        static final class a extends Lambda implements Function0 {
            final /* synthetic */ Object b;
            final /* synthetic */ JSONArray c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Object obj, JSONArray jSONArray) {
                super(0);
                this.b = obj;
                this.c = jSONArray;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Unable to create Card JSON in array. Ignoring. Was on element: " + this.b + " of json array: " + this.c;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(CardKey.Provider provider, z1 z1Var, ICardStorageProvider iCardStorageProvider, b2 b2Var, JSONArray jSONArray) {
            super(1);
            this.b = provider;
            this.c = z1Var;
            this.d = iCardStorageProvider;
            this.e = b2Var;
            this.f = jSONArray;
        }

        /* renamed from: a */
        public final Card invoke(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            try {
                return u.a.a(obj.toString(), this.b, this.c, this.d, this.e);
            } catch (Exception e2) {
                BrazeLogger.INSTANCE.brazelog((Object) u.a, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) new a(obj, this.f));
                return null;
            }
        }
    }

    private u() {
    }

    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r0v15, types: [com.braze.models.cards.ImageOnlyCard] */
    /* JADX WARNING: type inference failed for: r0v16, types: [com.braze.models.cards.CaptionedImageCard] */
    /* JADX WARNING: type inference failed for: r0v17, types: [com.braze.models.cards.ShortNewsCard] */
    /* JADX WARNING: type inference failed for: r0v18, types: [com.braze.models.cards.TextAnnouncementCard] */
    /* JADX WARNING: type inference failed for: r0v19, types: [com.braze.models.cards.ControlCard] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.braze.models.cards.Card a(org.json.JSONObject r7, com.braze.enums.CardKey.Provider r8, bo.app.z1 r9, com.braze.storage.ICardStorageProvider r10, bo.app.b2 r11) {
        /*
            java.lang.String r0 = "jsonObject"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "cardKeyProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "brazeManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "cardStorageProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "cardAnalyticsProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            com.braze.enums.CardType r0 = r8.getCardTypeFromJson(r7)
            if (r0 != 0) goto L_0x0021
            r0 = -1
            goto L_0x0029
        L_0x0021:
            int[] r1 = bo.app.u.a.a
            int r0 = r0.ordinal()
            r0 = r1[r0]
        L_0x0029:
            r1 = 1
            if (r0 == r1) goto L_0x006b
            r1 = 2
            if (r0 == r1) goto L_0x005f
            r1 = 3
            if (r0 == r1) goto L_0x0053
            r1 = 4
            if (r0 == r1) goto L_0x0047
            r1 = 5
            if (r0 == r1) goto L_0x003b
            r7 = 0
            goto L_0x0077
        L_0x003b:
            com.braze.models.cards.ControlCard r6 = new com.braze.models.cards.ControlCard
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0076
        L_0x0047:
            com.braze.models.cards.TextAnnouncementCard r6 = new com.braze.models.cards.TextAnnouncementCard
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0076
        L_0x0053:
            com.braze.models.cards.ShortNewsCard r6 = new com.braze.models.cards.ShortNewsCard
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0076
        L_0x005f:
            com.braze.models.cards.CaptionedImageCard r6 = new com.braze.models.cards.CaptionedImageCard
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0076
        L_0x006b:
            com.braze.models.cards.ImageOnlyCard r6 = new com.braze.models.cards.ImageOnlyCard
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x0076:
            r7 = r6
        L_0x0077:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.u.a(org.json.JSONObject, com.braze.enums.CardKey$Provider, bo.app.z1, com.braze.storage.ICardStorageProvider, bo.app.b2):com.braze.models.cards.Card");
    }

    /* access modifiers changed from: private */
    public final Card a(String str, CardKey.Provider provider, z1 z1Var, ICardStorageProvider iCardStorageProvider, b2 b2Var) {
        return a(new JSONObject(str), provider, z1Var, iCardStorageProvider, b2Var);
    }

    public static final List a(JSONArray jSONArray, CardKey.Provider provider, z1 z1Var, ICardStorageProvider iCardStorageProvider, b2 b2Var) {
        Intrinsics.checkNotNullParameter(jSONArray, "cardJsonStringArray");
        Intrinsics.checkNotNullParameter(provider, "cardKeyProvider");
        Intrinsics.checkNotNullParameter(z1Var, "brazeManager");
        Intrinsics.checkNotNullParameter(iCardStorageProvider, "cardStorageProvider");
        Intrinsics.checkNotNullParameter(b2Var, "cardAnalyticsProvider");
        return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.asSequence(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(RangesKt.until(0, jSONArray.length())), new b(jSONArray)), new c(jSONArray)).iterator()), new d(provider, z1Var, iCardStorageProvider, b2Var, jSONArray)));
    }
}
