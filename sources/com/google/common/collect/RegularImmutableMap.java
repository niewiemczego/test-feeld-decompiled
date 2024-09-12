package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;
import kotlin.UShort;

@ElementTypesAreNonnullByDefault
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    private static final byte ABSENT = -1;
    private static final int BYTE_MASK = 255;
    private static final int BYTE_MAX_SIZE = 128;
    static final ImmutableMap<Object, Object> EMPTY = new RegularImmutableMap((Object) null, new Object[0], 0);
    private static final int SHORT_MASK = 65535;
    private static final int SHORT_MAX_SIZE = 32768;
    private static final long serialVersionUID = 0;
    final transient Object[] alternatingKeysAndValues;
    @CheckForNull
    private final transient Object hashTable;
    private final transient int size;

    /* access modifiers changed from: package-private */
    public boolean isPartialView() {
        return false;
    }

    static <K, V> RegularImmutableMap<K, V> create(int i, Object[] objArr) {
        return create(i, objArr, (ImmutableMap.Builder) null);
    }

    static <K, V> RegularImmutableMap<K, V> create(int i, Object[] objArr, ImmutableMap.Builder<K, V> builder) {
        if (i == 0) {
            return (RegularImmutableMap) EMPTY;
        }
        if (i == 1) {
            CollectPreconditions.checkEntryNotNull(Objects.requireNonNull(objArr[0]), Objects.requireNonNull(objArr[1]));
            return new RegularImmutableMap<>((Object) null, objArr, 1);
        }
        Preconditions.checkPositionIndex(i, objArr.length >> 1);
        Object createHashTable = createHashTable(objArr, i, ImmutableSet.chooseTableSize(i), 0);
        if (createHashTable instanceof Object[]) {
            Object[] objArr2 = (Object[]) createHashTable;
            ImmutableMap.Builder.DuplicateKey duplicateKey = (ImmutableMap.Builder.DuplicateKey) objArr2[2];
            if (builder != null) {
                builder.duplicateKey = duplicateKey;
                Object obj = objArr2[0];
                int intValue = ((Integer) objArr2[1]).intValue();
                objArr = Arrays.copyOf(objArr, intValue * 2);
                createHashTable = obj;
                i = intValue;
            } else {
                throw duplicateKey.exception();
            }
        }
        return new RegularImmutableMap<>(createHashTable, objArr, i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    @javax.annotation.CheckForNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object createHashTable(java.lang.Object[] r16, int r17, int r18, int r19) {
        /*
            r0 = r17
            r1 = r18
            r2 = 0
            r3 = 1
            if (r0 != r3) goto L_0x001a
            r0 = r16[r19]
            java.lang.Object r0 = java.util.Objects.requireNonNull(r0)
            r1 = r19 ^ 1
            r1 = r16[r1]
            java.lang.Object r1 = java.util.Objects.requireNonNull(r1)
            com.google.common.collect.CollectPreconditions.checkEntryNotNull(r0, r1)
            return r2
        L_0x001a:
            int r4 = r1 + -1
            r5 = 128(0x80, float:1.794E-43)
            r6 = 3
            r7 = -1
            r8 = 2
            r9 = 0
            if (r1 > r5) goto L_0x0091
            byte[] r1 = new byte[r1]
            java.util.Arrays.fill(r1, r7)
            r5 = r9
            r7 = r5
        L_0x002b:
            if (r5 >= r0) goto L_0x0080
            int r10 = r5 * 2
            int r10 = r10 + r19
            int r11 = r7 * 2
            int r11 = r11 + r19
            r12 = r16[r10]
            java.lang.Object r12 = java.util.Objects.requireNonNull(r12)
            r10 = r10 ^ r3
            r10 = r16[r10]
            java.lang.Object r10 = java.util.Objects.requireNonNull(r10)
            com.google.common.collect.CollectPreconditions.checkEntryNotNull(r12, r10)
            int r13 = r12.hashCode()
            int r13 = com.google.common.collect.Hashing.smear(r13)
        L_0x004d:
            r13 = r13 & r4
            byte r14 = r1[r13]
            r15 = 255(0xff, float:3.57E-43)
            r14 = r14 & r15
            if (r14 != r15) goto L_0x0063
            byte r14 = (byte) r11
            r1[r13] = r14
            if (r7 >= r5) goto L_0x0060
            r16[r11] = r12
            r11 = r11 ^ 1
            r16[r11] = r10
        L_0x0060:
            int r7 = r7 + 1
            goto L_0x007a
        L_0x0063:
            r15 = r16[r14]
            boolean r15 = r12.equals(r15)
            if (r15 == 0) goto L_0x007d
            com.google.common.collect.ImmutableMap$Builder$DuplicateKey r2 = new com.google.common.collect.ImmutableMap$Builder$DuplicateKey
            r11 = r14 ^ 1
            r13 = r16[r11]
            java.lang.Object r13 = java.util.Objects.requireNonNull(r13)
            r2.<init>(r12, r10, r13)
            r16[r11] = r10
        L_0x007a:
            int r5 = r5 + 1
            goto L_0x002b
        L_0x007d:
            int r13 = r13 + 1
            goto L_0x004d
        L_0x0080:
            if (r7 != r0) goto L_0x0083
            goto L_0x0090
        L_0x0083:
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r0[r9] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            r0[r3] = r1
            r0[r8] = r2
            r1 = r0
        L_0x0090:
            return r1
        L_0x0091:
            r5 = 32768(0x8000, float:4.5918E-41)
            if (r1 > r5) goto L_0x0104
            short[] r1 = new short[r1]
            java.util.Arrays.fill(r1, r7)
            r5 = r9
            r7 = r5
        L_0x009d:
            if (r5 >= r0) goto L_0x00f3
            int r10 = r5 * 2
            int r10 = r10 + r19
            int r11 = r7 * 2
            int r11 = r11 + r19
            r12 = r16[r10]
            java.lang.Object r12 = java.util.Objects.requireNonNull(r12)
            r10 = r10 ^ r3
            r10 = r16[r10]
            java.lang.Object r10 = java.util.Objects.requireNonNull(r10)
            com.google.common.collect.CollectPreconditions.checkEntryNotNull(r12, r10)
            int r13 = r12.hashCode()
            int r13 = com.google.common.collect.Hashing.smear(r13)
        L_0x00bf:
            r13 = r13 & r4
            short r14 = r1[r13]
            r15 = 65535(0xffff, float:9.1834E-41)
            r14 = r14 & r15
            if (r14 != r15) goto L_0x00d6
            short r14 = (short) r11
            r1[r13] = r14
            if (r7 >= r5) goto L_0x00d3
            r16[r11] = r12
            r11 = r11 ^ 1
            r16[r11] = r10
        L_0x00d3:
            int r7 = r7 + 1
            goto L_0x00ed
        L_0x00d6:
            r15 = r16[r14]
            boolean r15 = r12.equals(r15)
            if (r15 == 0) goto L_0x00f0
            com.google.common.collect.ImmutableMap$Builder$DuplicateKey r2 = new com.google.common.collect.ImmutableMap$Builder$DuplicateKey
            r11 = r14 ^ 1
            r13 = r16[r11]
            java.lang.Object r13 = java.util.Objects.requireNonNull(r13)
            r2.<init>(r12, r10, r13)
            r16[r11] = r10
        L_0x00ed:
            int r5 = r5 + 1
            goto L_0x009d
        L_0x00f0:
            int r13 = r13 + 1
            goto L_0x00bf
        L_0x00f3:
            if (r7 != r0) goto L_0x00f6
            goto L_0x0103
        L_0x00f6:
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r0[r9] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            r0[r3] = r1
            r0[r8] = r2
            r1 = r0
        L_0x0103:
            return r1
        L_0x0104:
            int[] r1 = new int[r1]
            java.util.Arrays.fill(r1, r7)
            r5 = r9
            r10 = r5
        L_0x010b:
            if (r5 >= r0) goto L_0x015e
            int r11 = r5 * 2
            int r11 = r11 + r19
            int r12 = r10 * 2
            int r12 = r12 + r19
            r13 = r16[r11]
            java.lang.Object r13 = java.util.Objects.requireNonNull(r13)
            r11 = r11 ^ r3
            r11 = r16[r11]
            java.lang.Object r11 = java.util.Objects.requireNonNull(r11)
            com.google.common.collect.CollectPreconditions.checkEntryNotNull(r13, r11)
            int r14 = r13.hashCode()
            int r14 = com.google.common.collect.Hashing.smear(r14)
        L_0x012d:
            r14 = r14 & r4
            r15 = r1[r14]
            if (r15 != r7) goto L_0x013f
            r1[r14] = r12
            if (r10 >= r5) goto L_0x013c
            r16[r12] = r13
            r12 = r12 ^ 1
            r16[r12] = r11
        L_0x013c:
            int r10 = r10 + 1
            goto L_0x0156
        L_0x013f:
            r7 = r16[r15]
            boolean r7 = r13.equals(r7)
            if (r7 == 0) goto L_0x015a
            com.google.common.collect.ImmutableMap$Builder$DuplicateKey r2 = new com.google.common.collect.ImmutableMap$Builder$DuplicateKey
            r7 = r15 ^ 1
            r12 = r16[r7]
            java.lang.Object r12 = java.util.Objects.requireNonNull(r12)
            r2.<init>(r13, r11, r12)
            r16[r7] = r11
        L_0x0156:
            int r5 = r5 + 1
            r7 = -1
            goto L_0x010b
        L_0x015a:
            int r14 = r14 + 1
            r7 = -1
            goto L_0x012d
        L_0x015e:
            if (r10 != r0) goto L_0x0161
            goto L_0x016e
        L_0x0161:
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r0[r9] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)
            r0[r3] = r1
            r0[r8] = r2
            r1 = r0
        L_0x016e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.RegularImmutableMap.createHashTable(java.lang.Object[], int, int, int):java.lang.Object");
    }

    @CheckForNull
    static Object createHashTableOrThrow(Object[] objArr, int i, int i2, int i3) {
        Object createHashTable = createHashTable(objArr, i, i2, i3);
        if (!(createHashTable instanceof Object[])) {
            return createHashTable;
        }
        throw ((ImmutableMap.Builder.DuplicateKey) ((Object[]) createHashTable)[2]).exception();
    }

    private RegularImmutableMap(@CheckForNull Object obj, Object[] objArr, int i) {
        this.hashTable = obj;
        this.alternatingKeysAndValues = objArr;
        this.size = i;
    }

    public int size() {
        return this.size;
    }

    @CheckForNull
    public V get(@CheckForNull Object obj) {
        V v = get(this.hashTable, this.alternatingKeysAndValues, this.size, 0, obj);
        if (v == null) {
            return null;
        }
        return v;
    }

    @CheckForNull
    static Object get(@CheckForNull Object obj, Object[] objArr, int i, int i2, @CheckForNull Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i == 1) {
            if (Objects.requireNonNull(objArr[i2]).equals(obj2)) {
                return Objects.requireNonNull(objArr[i2 ^ 1]);
            }
            return null;
        } else if (obj == null) {
            return null;
        } else {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                int length = bArr.length - 1;
                int smear = Hashing.smear(obj2.hashCode());
                while (true) {
                    int i3 = smear & length;
                    byte b = bArr[i3] & 255;
                    if (b == 255) {
                        return null;
                    }
                    if (obj2.equals(objArr[b])) {
                        return objArr[b ^ 1];
                    }
                    smear = i3 + 1;
                }
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                int length2 = sArr.length - 1;
                int smear2 = Hashing.smear(obj2.hashCode());
                while (true) {
                    int i4 = smear2 & length2;
                    short s = sArr[i4] & UShort.MAX_VALUE;
                    if (s == 65535) {
                        return null;
                    }
                    if (obj2.equals(objArr[s])) {
                        return objArr[s ^ 1];
                    }
                    smear2 = i4 + 1;
                }
            } else {
                int[] iArr = (int[]) obj;
                int length3 = iArr.length - 1;
                int smear3 = Hashing.smear(obj2.hashCode());
                while (true) {
                    int i5 = smear3 & length3;
                    int i6 = iArr[i5];
                    if (i6 == -1) {
                        return null;
                    }
                    if (obj2.equals(objArr[i6])) {
                        return objArr[i6 ^ 1];
                    }
                    smear3 = i5 + 1;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet(this, this.alternatingKeysAndValues, 0, this.size);
    }

    static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        /* access modifiers changed from: private */
        public final transient Object[] alternatingKeysAndValues;
        /* access modifiers changed from: private */
        public final transient int keyOffset;
        private final transient ImmutableMap<K, V> map;
        /* access modifiers changed from: private */
        public final transient int size;

        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return true;
        }

        EntrySet(ImmutableMap<K, V> immutableMap, Object[] objArr, int i, int i2) {
            this.map = immutableMap;
            this.alternatingKeysAndValues = objArr;
            this.keyOffset = i;
            this.size = i2;
        }

        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }

        /* access modifiers changed from: package-private */
        public int copyIntoArray(Object[] objArr, int i) {
            return asList().copyIntoArray(objArr, i);
        }

        /* access modifiers changed from: package-private */
        public ImmutableList<Map.Entry<K, V>> createAsList() {
            return new ImmutableList<Map.Entry<K, V>>() {
                public boolean isPartialView() {
                    return true;
                }

                public Map.Entry<K, V> get(int i) {
                    Preconditions.checkElementIndex(i, EntrySet.this.size);
                    int i2 = i * 2;
                    return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(EntrySet.this.alternatingKeysAndValues[EntrySet.this.keyOffset + i2]), Objects.requireNonNull(EntrySet.this.alternatingKeysAndValues[i2 + (EntrySet.this.keyOffset ^ 1)]));
                }

                public int size() {
                    return EntrySet.this.size;
                }
            };
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.map.get(key))) {
                return false;
            }
            return true;
        }

        public int size() {
            return this.size;
        }
    }

    /* access modifiers changed from: package-private */
    public ImmutableSet<K> createKeySet() {
        return new KeySet(this, new KeysOrValuesAsList(this.alternatingKeysAndValues, 0, this.size));
    }

    static final class KeysOrValuesAsList extends ImmutableList<Object> {
        private final transient Object[] alternatingKeysAndValues;
        private final transient int offset;
        private final transient int size;

        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return true;
        }

        KeysOrValuesAsList(Object[] objArr, int i, int i2) {
            this.alternatingKeysAndValues = objArr;
            this.offset = i;
            this.size = i2;
        }

        public Object get(int i) {
            Preconditions.checkElementIndex(i, this.size);
            return Objects.requireNonNull(this.alternatingKeysAndValues[(i * 2) + this.offset]);
        }

        public int size() {
            return this.size;
        }
    }

    static final class KeySet<K> extends ImmutableSet<K> {
        private final transient ImmutableList<K> list;
        private final transient ImmutableMap<K, ?> map;

        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return true;
        }

        KeySet(ImmutableMap<K, ?> immutableMap, ImmutableList<K> immutableList) {
            this.map = immutableMap;
            this.list = immutableList;
        }

        public UnmodifiableIterator<K> iterator() {
            return asList().iterator();
        }

        /* access modifiers changed from: package-private */
        public int copyIntoArray(Object[] objArr, int i) {
            return asList().copyIntoArray(objArr, i);
        }

        public ImmutableList<K> asList() {
            return this.list;
        }

        public boolean contains(@CheckForNull Object obj) {
            return this.map.get(obj) != null;
        }

        public int size() {
            return this.map.size();
        }
    }

    /* access modifiers changed from: package-private */
    public ImmutableCollection<V> createValues() {
        return new KeysOrValuesAsList(this.alternatingKeysAndValues, 1, this.size);
    }
}
