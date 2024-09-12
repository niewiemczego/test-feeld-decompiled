package expo.modules.camera.utils;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a9\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00030\u0005H\bø\u0001\u0000\u001a9\u0010\t\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00030\u0005H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\n"}, d2 = {"mapX", "", "", "", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "it", "mapY", "expo-camera_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: BarCodeScannerListMappers.kt */
public final class BarCodeScannerListMappersKt {
    public static final void mapY(List<Integer> list, Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, list.size()), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (true) {
                list.set(first, function1.invoke(Integer.valueOf(first)));
                if (first != last) {
                    first += step2;
                } else {
                    return;
                }
            }
        }
    }

    public static final void mapX(List<Integer> list, Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        IntProgression step = RangesKt.step((IntProgression) RangesKt.until(1, list.size()), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (true) {
                list.set(first, function1.invoke(Integer.valueOf(first)));
                if (first != last) {
                    first += step2;
                } else {
                    return;
                }
            }
        }
    }
}
