package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0001VB\u0007\b\u0016¢\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bBM\b\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0002\u0010\u0014J\u0015\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u001d\u0010\u001b\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0016\u0010!\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J&\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010&\u001a\u00020\nH\u0002J\u001d\u0010'\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010 J\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000)J\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\u001eH\u0016J\u0014\u0010,\u001a\u00020\u00112\n\u0010-\u001a\u0006\u0012\u0002\b\u00030)H\u0002J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\nH\u0002J\u0010\u00100\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\nH\u0002J\u0013\u00101\u001a\u00020\u00112\b\u0010-\u001a\u0004\u0018\u000102H\u0002J\u0016\u00103\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\nH\u0002¢\u0006\u0002\u00104J\b\u00105\u001a\u00020\nH\u0016J\u0015\u00106\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00107J\u0018\u00108\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0002J\b\u00109\u001a\u00020\u0011H\u0016J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000;H\u0002J\u0015\u0010<\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00107J\u000e\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000>H\u0016J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000>2\u0006\u0010\u001f\u001a\u00020\nH\u0016J\u0015\u0010?\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0016\u0010@\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0015\u0010A\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\nH\u0016¢\u0006\u0002\u00104J\u0015\u0010B\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\nH\u0002¢\u0006\u0002\u00104J\u0018\u0010C\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\nH\u0002J\u0016\u0010F\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J.\u0010G\u001a\u00020\n2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010H\u001a\u00020\u0011H\u0002J\u001e\u0010I\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010JJ\u001e\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020\nH\u0016J\u0015\u0010N\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\rH\u0016¢\u0006\u0002\u0010OJ'\u0010N\u001a\b\u0012\u0004\u0012\u0002HP0\r\"\u0004\b\u0001\u0010P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002HP0\rH\u0016¢\u0006\u0002\u0010RJ\b\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u000202H\u0002R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006W"}, d2 = {"Lkotlin/collections/builders/ListBuilder;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "initialCapacity", "", "(I)V", "array", "", "offset", "length", "isReadOnly", "", "backing", "root", "([Ljava/lang/Object;IIZLkotlin/collections/builders/ListBuilder;Lkotlin/collections/builders/ListBuilder;)V", "[Ljava/lang/Object;", "isEffectivelyReadOnly", "()Z", "size", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "addAllInternal", "i", "n", "addAtInternal", "build", "", "checkIsMutable", "clear", "contentEquals", "other", "ensureCapacity", "minCapacity", "ensureExtraCapacity", "equals", "", "get", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "insertAtInternal", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainAll", "retainOrRemoveAllInternal", "retain", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "toArray", "()[Ljava/lang/Object;", "T", "destination", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "writeReplace", "Itr", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListBuilder.kt */
public final class ListBuilder<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList {
    /* access modifiers changed from: private */
    public E[] array;
    private final ListBuilder<E> backing;
    private boolean isReadOnly;
    /* access modifiers changed from: private */
    public int length;
    /* access modifiers changed from: private */
    public int offset;
    private final ListBuilder<E> root;

    private ListBuilder(E[] eArr, int i, int i2, boolean z, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.array = eArr;
        this.offset = i;
        this.length = i2;
        this.isReadOnly = z;
        this.backing = listBuilder;
        this.root = listBuilder2;
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int i) {
        this(ListBuilderKt.arrayOfUninitializedElements(i), 0, 0, false, (ListBuilder) null, (ListBuilder) null);
    }

    public final List<E> build() {
        if (this.backing == null) {
            checkIsMutable();
            this.isReadOnly = true;
            return this;
        }
        throw new IllegalStateException();
    }

    private final Object writeReplace() {
        if (isEffectivelyReadOnly()) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    public int getSize() {
        return this.length;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public E get(int i) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, this.length);
        return this.array[this.offset + i];
    }

    public E set(int i, E e) {
        checkIsMutable();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, this.length);
        E[] eArr = this.array;
        int i2 = this.offset;
        E e2 = eArr[i2 + i];
        eArr[i2 + i] = e;
        return e2;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < this.length; i++) {
            if (Intrinsics.areEqual((Object) this.array[this.offset + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object obj) {
        for (int i = this.length - 1; i >= 0; i--) {
            if (Intrinsics.areEqual((Object) this.array[this.offset + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    public Iterator<E> iterator() {
        return new Itr<>(this, 0);
    }

    public ListIterator<E> listIterator() {
        return new Itr<>(this, 0);
    }

    public ListIterator<E> listIterator(int i) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i, this.length);
        return new Itr<>(this, i);
    }

    public boolean add(E e) {
        checkIsMutable();
        addAtInternal(this.offset + this.length, e);
        return true;
    }

    public void add(int i, E e) {
        checkIsMutable();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i, this.length);
        addAtInternal(this.offset + i, e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        checkIsMutable();
        int size = collection.size();
        addAllInternal(this.offset + this.length, collection, size);
        return size > 0;
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        checkIsMutable();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i, this.length);
        int size = collection.size();
        addAllInternal(this.offset + i, collection, size);
        return size > 0;
    }

    public void clear() {
        checkIsMutable();
        removeRangeInternal(this.offset, this.length);
    }

    public E removeAt(int i) {
        checkIsMutable();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, this.length);
        return removeAtInternal(this.offset + i);
    }

    public boolean remove(Object obj) {
        checkIsMutable();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        return indexOf >= 0;
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        checkIsMutable();
        return retainOrRemoveAllInternal(this.offset, this.length, collection, false) > 0;
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        checkIsMutable();
        return retainOrRemoveAllInternal(this.offset, this.length, collection, true) > 0;
    }

    public List<E> subList(int i, int i2) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, this.length);
        E[] eArr = this.array;
        int i3 = this.offset + i;
        int i4 = i2 - i;
        boolean z = this.isReadOnly;
        ListBuilder<E> listBuilder = this.root;
        return new ListBuilder<>(eArr, i3, i4, z, this, listBuilder == null ? this : listBuilder);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "destination");
        int length2 = tArr.length;
        int i = this.length;
        if (length2 < i) {
            E[] eArr = this.array;
            int i2 = this.offset;
            T[] copyOfRange = Arrays.copyOfRange(eArr, i2, i + i2, tArr.getClass());
            Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(array, offse…h, destination.javaClass)");
            return copyOfRange;
        }
        E[] eArr2 = this.array;
        int i3 = this.offset;
        ArraysKt.copyInto((T[]) eArr2, tArr, 0, i3, i + i3);
        int length3 = tArr.length;
        int i4 = this.length;
        if (length3 > i4) {
            tArr[i4] = null;
        }
        return tArr;
    }

    public Object[] toArray() {
        E[] eArr = this.array;
        int i = this.offset;
        return ArraysKt.copyOfRange((T[]) eArr, i, this.length + i);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof List) && contentEquals((List) obj));
    }

    public int hashCode() {
        return ListBuilderKt.subarrayContentHashCode(this.array, this.offset, this.length);
    }

    public String toString() {
        return ListBuilderKt.subarrayContentToString(this.array, this.offset, this.length);
    }

    private final void ensureCapacity(int i) {
        if (this.backing != null) {
            throw new IllegalStateException();
        } else if (i < 0) {
            throw new OutOfMemoryError();
        } else if (i > this.array.length) {
            this.array = ListBuilderKt.copyOfUninitializedElements(this.array, ArrayDeque.Companion.newCapacity$kotlin_stdlib(this.array.length, i));
        }
    }

    private final void checkIsMutable() {
        if (isEffectivelyReadOnly()) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.root;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isEffectivelyReadOnly() {
        /*
            r1 = this;
            boolean r0 = r1.isReadOnly
            if (r0 != 0) goto L_0x000f
            kotlin.collections.builders.ListBuilder<E> r0 = r1.root
            if (r0 == 0) goto L_0x000d
            boolean r0 = r0.isReadOnly
            if (r0 == 0) goto L_0x000d
            goto L_0x000f
        L_0x000d:
            r0 = 0
            goto L_0x0010
        L_0x000f:
            r0 = 1
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.builders.ListBuilder.isEffectivelyReadOnly():boolean");
    }

    private final void ensureExtraCapacity(int i) {
        ensureCapacity(this.length + i);
    }

    private final boolean contentEquals(List<?> list) {
        return ListBuilderKt.subarrayContentEquals(this.array, this.offset, this.length, list);
    }

    private final void insertAtInternal(int i, int i2) {
        ensureExtraCapacity(i2);
        E[] eArr = this.array;
        ArraysKt.copyInto((T[]) eArr, (T[]) eArr, i + i2, i, this.offset + this.length);
        this.length += i2;
    }

    private final void addAtInternal(int i, E e) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAtInternal(i, e);
            this.array = this.backing.array;
            this.length++;
            return;
        }
        insertAtInternal(i, 1);
        this.array[i] = e;
    }

    private final void addAllInternal(int i, Collection<? extends E> collection, int i2) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAllInternal(i, collection, i2);
            this.array = this.backing.array;
            this.length += i2;
            return;
        }
        insertAtInternal(i, i2);
        Iterator<? extends E> it = collection.iterator();
        for (int i3 = 0; i3 < i2; i3++) {
            this.array[i + i3] = it.next();
        }
    }

    private final E removeAtInternal(int i) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            this.length--;
            return listBuilder.removeAtInternal(i);
        }
        E[] eArr = this.array;
        E e = eArr[i];
        ArraysKt.copyInto((T[]) eArr, (T[]) eArr, i, i + 1, this.offset + this.length);
        ListBuilderKt.resetAt(this.array, (this.offset + this.length) - 1);
        this.length--;
        return e;
    }

    private final void removeRangeInternal(int i, int i2) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.removeRangeInternal(i, i2);
        } else {
            E[] eArr = this.array;
            ArraysKt.copyInto((T[]) eArr, (T[]) eArr, i, i + i2, this.length);
            E[] eArr2 = this.array;
            int i3 = this.length;
            ListBuilderKt.resetRange(eArr2, i3 - i2, i3);
        }
        this.length -= i2;
    }

    private final int retainOrRemoveAllInternal(int i, int i2, Collection<? extends E> collection, boolean z) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            int retainOrRemoveAllInternal = listBuilder.retainOrRemoveAllInternal(i, i2, collection, z);
            this.length -= retainOrRemoveAllInternal;
            return retainOrRemoveAllInternal;
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i + i3;
            if (collection.contains(this.array[i5]) == z) {
                E[] eArr = this.array;
                i3++;
                eArr[i4 + i] = eArr[i5];
                i4++;
            } else {
                i3++;
            }
        }
        int i6 = i2 - i4;
        E[] eArr2 = this.array;
        ArraysKt.copyInto((T[]) eArr2, (T[]) eArr2, i + i4, i2 + i, this.length);
        E[] eArr3 = this.array;
        int i7 = this.length;
        ListBuilderKt.resetRange(eArr3, i7 - i6, i7);
        this.length -= i6;
        return i6;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0010\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\r\u0010\u0013\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Itr;", "E", "", "list", "Lkotlin/collections/builders/ListBuilder;", "index", "", "(Lkotlin/collections/builders/ListBuilder;I)V", "lastIndex", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ListBuilder.kt */
    private static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
        private int index;
        private int lastIndex = -1;
        private final ListBuilder<E> list;

        public Itr(ListBuilder<E> listBuilder, int i) {
            Intrinsics.checkNotNullParameter(listBuilder, "list");
            this.list = listBuilder;
            this.index = i;
        }

        public boolean hasPrevious() {
            return this.index > 0;
        }

        public boolean hasNext() {
            return this.index < this.list.length;
        }

        public int previousIndex() {
            return this.index - 1;
        }

        public int nextIndex() {
            return this.index;
        }

        public E previous() {
            int i = this.index;
            if (i > 0) {
                int i2 = i - 1;
                this.index = i2;
                this.lastIndex = i2;
                return this.list.array[this.list.offset + this.lastIndex];
            }
            throw new NoSuchElementException();
        }

        public E next() {
            if (this.index < this.list.length) {
                int i = this.index;
                this.index = i + 1;
                this.lastIndex = i;
                return this.list.array[this.list.offset + this.lastIndex];
            }
            throw new NoSuchElementException();
        }

        public void set(E e) {
            int i = this.lastIndex;
            if (i != -1) {
                this.list.set(i, e);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        }

        public void add(E e) {
            ListBuilder<E> listBuilder = this.list;
            int i = this.index;
            this.index = i + 1;
            listBuilder.add(i, e);
            this.lastIndex = -1;
        }

        public void remove() {
            int i = this.lastIndex;
            if (i != -1) {
                this.list.remove(i);
                this.index = this.lastIndex;
                this.lastIndex = -1;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        }
    }
}
