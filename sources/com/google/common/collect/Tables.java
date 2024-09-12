package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Table;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class Tables {
    private static final Function<? extends Map<?, ?>, ? extends Map<?, ?>> UNMODIFIABLE_WRAPPER = new Function<Map<Object, Object>, Map<Object, Object>>() {
        public Map<Object, Object> apply(Map<Object, Object> map) {
            return Collections.unmodifiableMap(map);
        }
    };

    private Tables() {
    }

    public static <R, C, V> Table.Cell<R, C, V> immutableCell(@ParametricNullness R r, @ParametricNullness C c, @ParametricNullness V v) {
        return new ImmutableCell(r, c, v);
    }

    static final class ImmutableCell<R, C, V> extends AbstractCell<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;
        @ParametricNullness
        private final C columnKey;
        @ParametricNullness
        private final R rowKey;
        @ParametricNullness
        private final V value;

        ImmutableCell(@ParametricNullness R r, @ParametricNullness C c, @ParametricNullness V v) {
            this.rowKey = r;
            this.columnKey = c;
            this.value = v;
        }

        @ParametricNullness
        public R getRowKey() {
            return this.rowKey;
        }

        @ParametricNullness
        public C getColumnKey() {
            return this.columnKey;
        }

        @ParametricNullness
        public V getValue() {
            return this.value;
        }
    }

    static abstract class AbstractCell<R, C, V> implements Table.Cell<R, C, V> {
        AbstractCell() {
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            if (!Objects.equal(getRowKey(), cell.getRowKey()) || !Objects.equal(getColumnKey(), cell.getColumnKey()) || !Objects.equal(getValue(), cell.getValue())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(getRowKey(), getColumnKey(), getValue());
        }

        public String toString() {
            String valueOf = String.valueOf(getRowKey());
            String valueOf2 = String.valueOf(getColumnKey());
            String valueOf3 = String.valueOf(getValue());
            return new StringBuilder(String.valueOf(valueOf).length() + 4 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length()).append("(").append(valueOf).append(",").append(valueOf2).append(")=").append(valueOf3).toString();
        }
    }

    public static <R, C, V> Table<C, R, V> transpose(Table<R, C, V> table) {
        if (table instanceof TransposeTable) {
            return ((TransposeTable) table).original;
        }
        return new TransposeTable(table);
    }

    private static class TransposeTable<C, R, V> extends AbstractTable<C, R, V> {
        private static final Function<Table.Cell<?, ?, ?>, Table.Cell<?, ?, ?>> TRANSPOSE_CELL = new Function<Table.Cell<?, ?, ?>, Table.Cell<?, ?, ?>>() {
            public Table.Cell<?, ?, ?> apply(Table.Cell<?, ?, ?> cell) {
                return Tables.immutableCell(cell.getColumnKey(), cell.getRowKey(), cell.getValue());
            }
        };
        final Table<R, C, V> original;

        TransposeTable(Table<R, C, V> table) {
            this.original = (Table) Preconditions.checkNotNull(table);
        }

        public void clear() {
            this.original.clear();
        }

        public Map<C, V> column(@ParametricNullness R r) {
            return this.original.row(r);
        }

        public Set<R> columnKeySet() {
            return this.original.rowKeySet();
        }

        public Map<R, Map<C, V>> columnMap() {
            return this.original.rowMap();
        }

        public boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return this.original.contains(obj2, obj);
        }

        public boolean containsColumn(@CheckForNull Object obj) {
            return this.original.containsRow(obj);
        }

        public boolean containsRow(@CheckForNull Object obj) {
            return this.original.containsColumn(obj);
        }

        public boolean containsValue(@CheckForNull Object obj) {
            return this.original.containsValue(obj);
        }

        @CheckForNull
        public V get(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return this.original.get(obj2, obj);
        }

        @CheckForNull
        public V put(@ParametricNullness C c, @ParametricNullness R r, @ParametricNullness V v) {
            return this.original.put(r, c, v);
        }

        public void putAll(Table<? extends C, ? extends R, ? extends V> table) {
            this.original.putAll(Tables.transpose(table));
        }

        @CheckForNull
        public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return this.original.remove(obj2, obj);
        }

        public Map<R, V> row(@ParametricNullness C c) {
            return this.original.column(c);
        }

        public Set<C> rowKeySet() {
            return this.original.columnKeySet();
        }

        public Map<C, Map<R, V>> rowMap() {
            return this.original.columnMap();
        }

        public int size() {
            return this.original.size();
        }

        public Collection<V> values() {
            return this.original.values();
        }

        /* access modifiers changed from: package-private */
        public Iterator<Table.Cell<C, R, V>> cellIterator() {
            return Iterators.transform(this.original.cellSet().iterator(), TRANSPOSE_CELL);
        }
    }

    public static <R, C, V> Table<R, C, V> newCustomTable(Map<R, Map<C, V>> map, Supplier<? extends Map<C, V>> supplier) {
        Preconditions.checkArgument(map.isEmpty());
        Preconditions.checkNotNull(supplier);
        return new StandardTable(map, supplier);
    }

    public static <R, C, V1, V2> Table<R, C, V2> transformValues(Table<R, C, V1> table, Function<? super V1, V2> function) {
        return new TransformedTable(table, function);
    }

    private static class TransformedTable<R, C, V1, V2> extends AbstractTable<R, C, V2> {
        final Table<R, C, V1> fromTable;
        final Function<? super V1, V2> function;

        TransformedTable(Table<R, C, V1> table, Function<? super V1, V2> function2) {
            this.fromTable = (Table) Preconditions.checkNotNull(table);
            this.function = (Function) Preconditions.checkNotNull(function2);
        }

        public boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return this.fromTable.contains(obj, obj2);
        }

        @CheckForNull
        public V2 get(@CheckForNull Object obj, @CheckForNull Object obj2) {
            if (contains(obj, obj2)) {
                return this.function.apply(NullnessCasts.uncheckedCastNullableTToT(this.fromTable.get(obj, obj2)));
            }
            return null;
        }

        public int size() {
            return this.fromTable.size();
        }

        public void clear() {
            this.fromTable.clear();
        }

        @CheckForNull
        public V2 put(@ParametricNullness R r, @ParametricNullness C c, @ParametricNullness V2 v2) {
            throw new UnsupportedOperationException();
        }

        public void putAll(Table<? extends R, ? extends C, ? extends V2> table) {
            throw new UnsupportedOperationException();
        }

        @CheckForNull
        public V2 remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            if (contains(obj, obj2)) {
                return this.function.apply(NullnessCasts.uncheckedCastNullableTToT(this.fromTable.remove(obj, obj2)));
            }
            return null;
        }

        public Map<C, V2> row(@ParametricNullness R r) {
            return Maps.transformValues(this.fromTable.row(r), this.function);
        }

        public Map<R, V2> column(@ParametricNullness C c) {
            return Maps.transformValues(this.fromTable.column(c), this.function);
        }

        /* access modifiers changed from: package-private */
        public Function<Table.Cell<R, C, V1>, Table.Cell<R, C, V2>> cellFunction() {
            return new Function<Table.Cell<R, C, V1>, Table.Cell<R, C, V2>>() {
                public Table.Cell<R, C, V2> apply(Table.Cell<R, C, V1> cell) {
                    return Tables.immutableCell(cell.getRowKey(), cell.getColumnKey(), TransformedTable.this.function.apply(cell.getValue()));
                }
            };
        }

        /* access modifiers changed from: package-private */
        public Iterator<Table.Cell<R, C, V2>> cellIterator() {
            return Iterators.transform(this.fromTable.cellSet().iterator(), cellFunction());
        }

        public Set<R> rowKeySet() {
            return this.fromTable.rowKeySet();
        }

        public Set<C> columnKeySet() {
            return this.fromTable.columnKeySet();
        }

        /* access modifiers changed from: package-private */
        public Collection<V2> createValues() {
            return Collections2.transform(this.fromTable.values(), this.function);
        }

        public Map<R, Map<C, V2>> rowMap() {
            return Maps.transformValues(this.fromTable.rowMap(), new Function<Map<C, V1>, Map<C, V2>>() {
                public Map<C, V2> apply(Map<C, V1> map) {
                    return Maps.transformValues(map, TransformedTable.this.function);
                }
            });
        }

        public Map<C, Map<R, V2>> columnMap() {
            return Maps.transformValues(this.fromTable.columnMap(), new Function<Map<R, V1>, Map<R, V2>>() {
                public Map<R, V2> apply(Map<R, V1> map) {
                    return Maps.transformValues(map, TransformedTable.this.function);
                }
            });
        }
    }

    public static <R, C, V> Table<R, C, V> unmodifiableTable(Table<? extends R, ? extends C, ? extends V> table) {
        return new UnmodifiableTable(table);
    }

    private static class UnmodifiableTable<R, C, V> extends ForwardingTable<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final Table<? extends R, ? extends C, ? extends V> delegate;

        UnmodifiableTable(Table<? extends R, ? extends C, ? extends V> table) {
            this.delegate = (Table) Preconditions.checkNotNull(table);
        }

        /* access modifiers changed from: protected */
        public Table<R, C, V> delegate() {
            return this.delegate;
        }

        public Set<Table.Cell<R, C, V>> cellSet() {
            return Collections.unmodifiableSet(super.cellSet());
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public Map<R, V> column(@ParametricNullness C c) {
            return Collections.unmodifiableMap(super.column(c));
        }

        public Set<C> columnKeySet() {
            return Collections.unmodifiableSet(super.columnKeySet());
        }

        public Map<C, Map<R, V>> columnMap() {
            return Collections.unmodifiableMap(Maps.transformValues(super.columnMap(), Tables.unmodifiableWrapper()));
        }

        @CheckForNull
        public V put(@ParametricNullness R r, @ParametricNullness C c, @ParametricNullness V v) {
            throw new UnsupportedOperationException();
        }

        public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
            throw new UnsupportedOperationException();
        }

        @CheckForNull
        public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            throw new UnsupportedOperationException();
        }

        public Map<C, V> row(@ParametricNullness R r) {
            return Collections.unmodifiableMap(super.row(r));
        }

        public Set<R> rowKeySet() {
            return Collections.unmodifiableSet(super.rowKeySet());
        }

        public Map<R, Map<C, V>> rowMap() {
            return Collections.unmodifiableMap(Maps.transformValues(super.rowMap(), Tables.unmodifiableWrapper()));
        }

        public Collection<V> values() {
            return Collections.unmodifiableCollection(super.values());
        }
    }

    public static <R, C, V> RowSortedTable<R, C, V> unmodifiableRowSortedTable(RowSortedTable<R, ? extends C, ? extends V> rowSortedTable) {
        return new UnmodifiableRowSortedMap(rowSortedTable);
    }

    static final class UnmodifiableRowSortedMap<R, C, V> extends UnmodifiableTable<R, C, V> implements RowSortedTable<R, C, V> {
        private static final long serialVersionUID = 0;

        public UnmodifiableRowSortedMap(RowSortedTable<R, ? extends C, ? extends V> rowSortedTable) {
            super(rowSortedTable);
        }

        /* access modifiers changed from: protected */
        public RowSortedTable<R, C, V> delegate() {
            return (RowSortedTable) super.delegate();
        }

        public SortedMap<R, Map<C, V>> rowMap() {
            return Collections.unmodifiableSortedMap(Maps.transformValues(delegate().rowMap(), Tables.unmodifiableWrapper()));
        }

        public SortedSet<R> rowKeySet() {
            return Collections.unmodifiableSortedSet(delegate().rowKeySet());
        }
    }

    /* access modifiers changed from: private */
    public static <K, V> Function<Map<K, V>, Map<K, V>> unmodifiableWrapper() {
        return UNMODIFIABLE_WRAPPER;
    }

    public static <R, C, V> Table<R, C, V> synchronizedTable(Table<R, C, V> table) {
        return Synchronized.table(table, (Object) null);
    }

    static boolean equalsImpl(Table<?, ?, ?> table, @CheckForNull Object obj) {
        if (obj == table) {
            return true;
        }
        if (obj instanceof Table) {
            return table.cellSet().equals(((Table) obj).cellSet());
        }
        return false;
    }
}
