package androidx.sqlite.db;

import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00002\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\n\u001a\u00020\u0000J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0003J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003J)\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006¢\u0006\u0002\u0010\u0014J\"\u0010\u0015\u001a\u00020\u0016*\u00060\u0017j\u0002`\u00182\u0006\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0002J%\u0010\u001b\u001a\u00020\u0016*\u00060\u0017j\u0002`\u00182\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0006H\u0002¢\u0006\u0002\u0010\u001cR\u001c\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u001a\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "", "table", "", "(Ljava/lang/String;)V", "bindArgs", "", "[Ljava/lang/Object;", "columns", "[Ljava/lang/String;", "distinct", "", "groupBy", "having", "limit", "orderBy", "selection", "([Ljava/lang/String;)Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "create", "Landroidx/sqlite/db/SupportSQLiteQuery;", "(Ljava/lang/String;[Ljava/lang/Object;)Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "appendClause", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "name", "clause", "appendColumns", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)V", "Companion", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SupportSQLiteQueryBuilder.kt */
public final class SupportSQLiteQueryBuilder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Pattern limitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    private Object[] bindArgs;
    private String[] columns;
    private boolean distinct;
    private String groupBy;
    private String having;
    private String limit;
    private String orderBy;
    private String selection;
    private final String table;

    public /* synthetic */ SupportSQLiteQueryBuilder(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @JvmStatic
    public static final SupportSQLiteQueryBuilder builder(String str) {
        return Companion.builder(str);
    }

    private SupportSQLiteQueryBuilder(String str) {
        this.table = str;
    }

    public final SupportSQLiteQueryBuilder distinct() {
        SupportSQLiteQueryBuilder supportSQLiteQueryBuilder = this;
        this.distinct = true;
        return this;
    }

    public final SupportSQLiteQueryBuilder columns(String[] strArr) {
        SupportSQLiteQueryBuilder supportSQLiteQueryBuilder = this;
        this.columns = strArr;
        return this;
    }

    public final SupportSQLiteQueryBuilder selection(String str, Object[] objArr) {
        SupportSQLiteQueryBuilder supportSQLiteQueryBuilder = this;
        this.selection = str;
        this.bindArgs = objArr;
        return this;
    }

    public final SupportSQLiteQueryBuilder groupBy(String str) {
        SupportSQLiteQueryBuilder supportSQLiteQueryBuilder = this;
        this.groupBy = str;
        return this;
    }

    public final SupportSQLiteQueryBuilder having(String str) {
        SupportSQLiteQueryBuilder supportSQLiteQueryBuilder = this;
        this.having = str;
        return this;
    }

    public final SupportSQLiteQueryBuilder orderBy(String str) {
        SupportSQLiteQueryBuilder supportSQLiteQueryBuilder = this;
        this.orderBy = str;
        return this;
    }

    public final SupportSQLiteQueryBuilder limit(String str) {
        Intrinsics.checkNotNullParameter(str, "limit");
        SupportSQLiteQueryBuilder supportSQLiteQueryBuilder = this;
        CharSequence charSequence = str;
        boolean matches = limitPattern.matcher(charSequence).matches();
        boolean z = true;
        if (!(charSequence.length() == 0) && !matches) {
            z = false;
        }
        if (z) {
            this.limit = str;
            return this;
        }
        throw new IllegalArgumentException(("invalid LIMIT clauses:" + str).toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
        if ((r0.length == 0) != false) goto L_0x004d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.sqlite.db.SupportSQLiteQuery create() {
        /*
            r5 = this;
            java.lang.String r0 = r5.groupBy
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0011
            int r0 = r0.length()
            if (r0 != 0) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            r0 = r1
            goto L_0x0012
        L_0x0011:
            r0 = r2
        L_0x0012:
            if (r0 == 0) goto L_0x0029
            java.lang.String r0 = r5.having
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0023
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r0 = r1
            goto L_0x0024
        L_0x0023:
            r0 = r2
        L_0x0024:
            if (r0 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r0 = r1
            goto L_0x002a
        L_0x0029:
            r0 = r2
        L_0x002a:
            if (r0 == 0) goto L_0x009c
            r0 = 120(0x78, float:1.68E-43)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            java.lang.String r0 = "SELECT "
            r3.append(r0)
            boolean r0 = r5.distinct
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = "DISTINCT "
            r3.append(r0)
        L_0x0041:
            java.lang.String[] r0 = r5.columns
            if (r0 == 0) goto L_0x004d
            int r4 = r0.length
            if (r4 != 0) goto L_0x004a
            r4 = r2
            goto L_0x004b
        L_0x004a:
            r4 = r1
        L_0x004b:
            if (r4 == 0) goto L_0x004e
        L_0x004d:
            r1 = r2
        L_0x004e:
            if (r1 != 0) goto L_0x0057
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r5.appendColumns(r3, r0)
            goto L_0x005c
        L_0x0057:
            java.lang.String r0 = "* "
            r3.append(r0)
        L_0x005c:
            java.lang.String r0 = "FROM "
            r3.append(r0)
            java.lang.String r0 = r5.table
            r3.append(r0)
            java.lang.String r0 = r5.selection
            java.lang.String r1 = " WHERE "
            r5.appendClause(r3, r1, r0)
            java.lang.String r0 = r5.groupBy
            java.lang.String r1 = " GROUP BY "
            r5.appendClause(r3, r1, r0)
            java.lang.String r0 = r5.having
            java.lang.String r1 = " HAVING "
            r5.appendClause(r3, r1, r0)
            java.lang.String r0 = r5.orderBy
            java.lang.String r1 = " ORDER BY "
            r5.appendClause(r3, r1, r0)
            java.lang.String r0 = r5.limit
            java.lang.String r1 = " LIMIT "
            r5.appendClause(r3, r1, r0)
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = "StringBuilder(capacity).…builderAction).toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            androidx.sqlite.db.SimpleSQLiteQuery r1 = new androidx.sqlite.db.SimpleSQLiteQuery
            java.lang.Object[] r2 = r5.bindArgs
            r1.<init>(r0, r2)
            androidx.sqlite.db.SupportSQLiteQuery r1 = (androidx.sqlite.db.SupportSQLiteQuery) r1
            return r1
        L_0x009c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "HAVING clauses are only permitted when using a groupBy clause"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.db.SupportSQLiteQueryBuilder.create():androidx.sqlite.db.SupportSQLiteQuery");
    }

    private final void appendClause(StringBuilder sb, String str, String str2) {
        CharSequence charSequence = str2;
        if (!(charSequence == null || charSequence.length() == 0)) {
            sb.append(str);
            sb.append(str2);
        }
    }

    private final void appendColumns(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(' ');
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteQueryBuilder$Companion;", "", "()V", "limitPattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "builder", "Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "tableName", "", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SupportSQLiteQueryBuilder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SupportSQLiteQueryBuilder builder(String str) {
            Intrinsics.checkNotNullParameter(str, "tableName");
            return new SupportSQLiteQueryBuilder(str, (DefaultConstructorMarker) null);
        }
    }
}
