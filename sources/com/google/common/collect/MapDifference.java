package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@DoNotMock("Use Maps.difference")
public interface MapDifference<K, V> {

    @DoNotMock("Use Maps.difference")
    public interface ValueDifference<V> {
        boolean equals(@CheckForNull Object obj);

        int hashCode();

        @ParametricNullness
        V leftValue();

        @ParametricNullness
        V rightValue();
    }

    boolean areEqual();

    Map<K, ValueDifference<V>> entriesDiffering();

    Map<K, V> entriesInCommon();

    Map<K, V> entriesOnlyOnLeft();

    Map<K, V> entriesOnlyOnRight();

    boolean equals(@CheckForNull Object obj);

    int hashCode();
}
