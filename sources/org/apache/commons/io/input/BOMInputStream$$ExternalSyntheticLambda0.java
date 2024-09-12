package org.apache.commons.io.input;

import java.util.Comparator;
import org.apache.commons.io.ByteOrderMark;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BOMInputStream$$ExternalSyntheticLambda0 implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return Integer.compare(((ByteOrderMark) obj2).length(), ((ByteOrderMark) obj).length());
    }
}
