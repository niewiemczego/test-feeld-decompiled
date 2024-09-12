package androidx.room;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003\u001b\u001c\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002JV\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00070\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0007\u0012\u0004\u0012\u00020\u00040\rH\u0002JO\u0010\u000e\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112$\u0010\u0013\u001a \u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0007\u0012\u0004\u0012\u00020\u00040\u0014H\u0002¢\u0006\u0002\u0010\u0015J5\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0011H\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001e"}, d2 = {"Landroidx/room/AmbiguousColumnResolver;", "", "()V", "dfs", "", "T", "content", "", "current", "", "depth", "", "block", "Lkotlin/Function1;", "rabinKarpSearch", "Landroidx/room/AmbiguousColumnResolver$ResultColumn;", "pattern", "", "", "onHashMatch", "Lkotlin/Function3;", "(Ljava/util/List;[Ljava/lang/String;Lkotlin/jvm/functions/Function3;)V", "resolve", "", "resultColumns", "mappings", "([Ljava/lang/String;[[Ljava/lang/String;)[[I", "Match", "ResultColumn", "Solution", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AmbiguousColumnResolver.kt */
public final class AmbiguousColumnResolver {
    public static final AmbiguousColumnResolver INSTANCE = new AmbiguousColumnResolver();

    private AmbiguousColumnResolver() {
    }

    @JvmStatic
    public static final int[][] resolve(String[] strArr, String[][] strArr2) {
        boolean z;
        String[] strArr3 = strArr;
        String[][] strArr4 = strArr2;
        Intrinsics.checkNotNullParameter(strArr3, "resultColumns");
        Intrinsics.checkNotNullParameter(strArr4, "mappings");
        int length = strArr3.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            z = true;
            if (i2 >= length) {
                break;
            }
            String str = strArr3[i2];
            if (str.charAt(0) == '`' && str.charAt(str.length() - 1) == '`') {
                str = str.substring(1, str.length() - 1);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            strArr3[i2] = lowerCase;
            i2++;
        }
        Object[] objArr = (Object[]) strArr4;
        int length2 = objArr.length;
        for (int i3 = 0; i3 < length2; i3++) {
            int length3 = strArr4[i3].length;
            for (int i4 = 0; i4 < length3; i4++) {
                String[] strArr5 = strArr4[i3];
                String str2 = strArr5[i4];
                Locale locale2 = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale2, "US");
                String lowerCase2 = str2.toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                strArr5[i4] = lowerCase2;
            }
        }
        Set createSetBuilder = SetsKt.createSetBuilder();
        for (Object obj : objArr) {
            CollectionsKt.addAll(createSetBuilder, (T[]) (String[]) obj);
        }
        Set build = SetsKt.build(createSetBuilder);
        List createListBuilder = CollectionsKt.createListBuilder();
        int length4 = strArr3.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length4) {
            String str3 = strArr3[i5];
            int i7 = i6 + 1;
            if (build.contains(str3)) {
                createListBuilder.add(new ResultColumn(str3, i6));
            }
            i5++;
            i6 = i7;
        }
        List<ResultColumn> build2 = CollectionsKt.build(createListBuilder);
        int length5 = objArr.length;
        ArrayList arrayList = new ArrayList(length5);
        for (int i8 = 0; i8 < length5; i8++) {
            arrayList.add(new ArrayList());
        }
        List list = arrayList;
        int length6 = objArr.length;
        int i9 = 0;
        int i10 = 0;
        while (i9 < length6) {
            int i11 = i10 + 1;
            String[] strArr6 = (String[]) objArr[i9];
            INSTANCE.rabinKarpSearch(build2, strArr6, new AmbiguousColumnResolver$resolve$1$1(strArr6, list, i10));
            if (((List) list.get(i10)).isEmpty()) {
                Collection arrayList2 = new ArrayList(strArr6.length);
                int length7 = strArr6.length;
                int i12 = i;
                while (i12 < length7) {
                    String str4 = strArr6[i12];
                    List createListBuilder2 = CollectionsKt.createListBuilder();
                    for (ResultColumn resultColumn : build2) {
                        if (Intrinsics.areEqual((Object) str4, (Object) resultColumn.getName())) {
                            createListBuilder2.add(Integer.valueOf(resultColumn.getIndex()));
                        }
                    }
                    List build3 = CollectionsKt.build(createListBuilder2);
                    if (!build3.isEmpty()) {
                        arrayList2.add(build3);
                        i12++;
                    } else {
                        throw new IllegalStateException(("Column " + str4 + " not found in result").toString());
                    }
                }
                dfs$default(INSTANCE, (List) arrayList2, (List) null, 0, new AmbiguousColumnResolver$resolve$1$2(list, i10), 6, (Object) null);
            }
            i9++;
            i10 = i11;
            i = 0;
        }
        Iterable iterable = list;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!(!((List) it.next()).isEmpty())) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = Solution.Companion.getNO_SOLUTION();
            dfs$default(INSTANCE, list, (List) null, 0, new AmbiguousColumnResolver$resolve$4(objectRef), 6, (Object) null);
            Iterable<Match> matches = ((Solution) objectRef.element).getMatches();
            Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(matches, 10));
            for (Match resultIndices : matches) {
                arrayList3.add(CollectionsKt.toIntArray(resultIndices.getResultIndices()));
            }
            Object[] array = ((List) arrayList3).toArray(new int[0][]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return (int[][]) array;
        }
        throw new IllegalStateException("Failed to find matches for all mappings".toString());
    }

    private final void rabinKarpSearch(List<ResultColumn> list, String[] strArr, Function3<? super Integer, ? super Integer, ? super List<ResultColumn>, Unit> function3) {
        int i = 0;
        int i2 = 0;
        for (String hashCode : strArr) {
            i2 += hashCode.hashCode();
        }
        int length = strArr.length;
        int i3 = 0;
        for (ResultColumn name : list.subList(0, length)) {
            i3 += name.getName().hashCode();
        }
        while (true) {
            if (i2 == i3) {
                function3.invoke(Integer.valueOf(i), Integer.valueOf(length), list.subList(i, length));
            }
            i++;
            length++;
            if (length <= list.size()) {
                i3 = (i3 - list.get(i - 1).getName().hashCode()) + list.get(length - 1).getName().hashCode();
            } else {
                return;
            }
        }
    }

    static /* synthetic */ void dfs$default(AmbiguousColumnResolver ambiguousColumnResolver, List list, List list2, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            list2 = new ArrayList();
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        ambiguousColumnResolver.dfs(list, list2, i, function1);
    }

    private final <T> void dfs(List<? extends List<? extends T>> list, List<T> list2, int i, Function1<? super List<? extends T>, Unit> function1) {
        if (i == list.size()) {
            function1.invoke(CollectionsKt.toList(list2));
            return;
        }
        for (Object add : (Iterable) list.get(i)) {
            list2.add(add);
            INSTANCE.dfs(list, list2, i + 1, function1);
            CollectionsKt.removeLast(list2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$ResultColumn;", "", "name", "", "index", "", "(Ljava/lang/String;I)V", "getIndex", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AmbiguousColumnResolver.kt */
    private static final class ResultColumn {
        private final int index;
        private final String name;

        public static /* synthetic */ ResultColumn copy$default(ResultColumn resultColumn, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = resultColumn.name;
            }
            if ((i2 & 2) != 0) {
                i = resultColumn.index;
            }
            return resultColumn.copy(str, i);
        }

        public final String component1() {
            return this.name;
        }

        public final int component2() {
            return this.index;
        }

        public final ResultColumn copy(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "name");
            return new ResultColumn(str, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResultColumn)) {
                return false;
            }
            ResultColumn resultColumn = (ResultColumn) obj;
            return Intrinsics.areEqual((Object) this.name, (Object) resultColumn.name) && this.index == resultColumn.index;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + Integer.hashCode(this.index);
        }

        public String toString() {
            return "ResultColumn(name=" + this.name + ", index=" + this.index + ')';
        }

        public ResultColumn(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "name");
            this.name = str;
            this.index = i;
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getName() {
            return this.name;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$Match;", "", "resultRange", "Lkotlin/ranges/IntRange;", "resultIndices", "", "", "(Lkotlin/ranges/IntRange;Ljava/util/List;)V", "getResultIndices", "()Ljava/util/List;", "getResultRange", "()Lkotlin/ranges/IntRange;", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AmbiguousColumnResolver.kt */
    private static final class Match {
        private final List<Integer> resultIndices;
        private final IntRange resultRange;

        public Match(IntRange intRange, List<Integer> list) {
            Intrinsics.checkNotNullParameter(intRange, "resultRange");
            Intrinsics.checkNotNullParameter(list, "resultIndices");
            this.resultRange = intRange;
            this.resultIndices = list;
        }

        public final IntRange getResultRange() {
            return this.resultRange;
        }

        public final List<Integer> getResultIndices() {
            return this.resultIndices;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0000H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0011"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$Solution;", "", "matches", "", "Landroidx/room/AmbiguousColumnResolver$Match;", "coverageOffset", "", "overlaps", "(Ljava/util/List;II)V", "getCoverageOffset", "()I", "getMatches", "()Ljava/util/List;", "getOverlaps", "compareTo", "other", "Companion", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AmbiguousColumnResolver.kt */
    private static final class Solution implements Comparable<Solution> {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final Solution NO_SOLUTION = new Solution(CollectionsKt.emptyList(), Integer.MAX_VALUE, Integer.MAX_VALUE);
        private final int coverageOffset;
        private final List<Match> matches;
        private final int overlaps;

        public Solution(List<Match> list, int i, int i2) {
            Intrinsics.checkNotNullParameter(list, "matches");
            this.matches = list;
            this.coverageOffset = i;
            this.overlaps = i2;
        }

        public final List<Match> getMatches() {
            return this.matches;
        }

        public final int getCoverageOffset() {
            return this.coverageOffset;
        }

        public final int getOverlaps() {
            return this.overlaps;
        }

        public int compareTo(Solution solution) {
            Intrinsics.checkNotNullParameter(solution, "other");
            int compare = Intrinsics.compare(this.overlaps, solution.overlaps);
            if (compare != 0) {
                return compare;
            }
            return Intrinsics.compare(this.coverageOffset, solution.coverageOffset);
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$Solution$Companion;", "", "()V", "NO_SOLUTION", "Landroidx/room/AmbiguousColumnResolver$Solution;", "getNO_SOLUTION", "()Landroidx/room/AmbiguousColumnResolver$Solution;", "build", "matches", "", "Landroidx/room/AmbiguousColumnResolver$Match;", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: AmbiguousColumnResolver.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Solution getNO_SOLUTION() {
                return Solution.NO_SOLUTION;
            }

            public final Solution build(List<Match> list) {
                boolean z;
                Intrinsics.checkNotNullParameter(list, "matches");
                Iterable<Match> iterable = list;
                int i = 0;
                int i2 = 0;
                for (Match match : iterable) {
                    i2 += ((match.getResultRange().getLast() - match.getResultRange().getFirst()) + 1) - match.getResultIndices().size();
                }
                Iterator it = iterable.iterator();
                if (it.hasNext()) {
                    int first = ((Match) it.next()).getResultRange().getFirst();
                    while (it.hasNext()) {
                        int first2 = ((Match) it.next()).getResultRange().getFirst();
                        if (first > first2) {
                            first = first2;
                        }
                    }
                    Iterator it2 = iterable.iterator();
                    if (it2.hasNext()) {
                        int last = ((Match) it2.next()).getResultRange().getLast();
                        while (it2.hasNext()) {
                            int last2 = ((Match) it2.next()).getResultRange().getLast();
                            if (last < last2) {
                                last = last2;
                            }
                        }
                        Iterable intRange = new IntRange(first, last);
                        if (!(intRange instanceof Collection) || !((Collection) intRange).isEmpty()) {
                            Iterator it3 = intRange.iterator();
                            int i3 = 0;
                            while (it3.hasNext()) {
                                int nextInt = ((IntIterator) it3).nextInt();
                                Iterator it4 = iterable.iterator();
                                int i4 = 0;
                                while (true) {
                                    if (!it4.hasNext()) {
                                        z = false;
                                        break;
                                    }
                                    if (((Match) it4.next()).getResultRange().contains(nextInt)) {
                                        i4++;
                                        continue;
                                    }
                                    if (i4 > 1) {
                                        z = true;
                                        break;
                                    }
                                }
                                if (z && (i3 = i3 + 1) < 0) {
                                    CollectionsKt.throwCountOverflow();
                                }
                            }
                            i = i3;
                        }
                        return new Solution(list, i2, i);
                    }
                    throw new NoSuchElementException();
                }
                throw new NoSuchElementException();
            }
        }
    }
}
