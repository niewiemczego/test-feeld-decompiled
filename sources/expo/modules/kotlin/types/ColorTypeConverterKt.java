package expo.modules.kotlin.types;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"namedColors", "", "", "", "", "expo-modules-core_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ColorTypeConverter.kt */
public final class ColorTypeConverterKt {
    /* access modifiers changed from: private */
    public static final Map<String, List<Float>> namedColors;

    static {
        Integer valueOf = Integer.valueOf(PsExtractor.VIDEO_STREAM_MASK);
        Integer valueOf2 = Integer.valueOf(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        Map mapOf = MapsKt.mapOf(TuplesKt.to("aliceblue", new Integer[]{valueOf, 248, 255, 255}), TuplesKt.to("antiquewhite", new Integer[]{valueOf2, 235, Integer.valueOf(JfifUtil.MARKER_RST7), 255}), TuplesKt.to("aqua", new Integer[]{0, 255, 255, 255}), TuplesKt.to("aquamarine", new Integer[]{127, 255, 212, 255}), TuplesKt.to("azure", new Integer[]{valueOf, 255, 255, 255}), TuplesKt.to("beige", new Integer[]{245, 245, 220, 255}), TuplesKt.to("bisque", new Integer[]{255, 228, 196, 255}), TuplesKt.to("black", new Integer[]{0, 0, 0, 255}), TuplesKt.to("blanchedalmond", new Integer[]{255, 235, 205, 255}), TuplesKt.to("blue", new Integer[]{0, 0, 255, 255}), TuplesKt.to("blueviolet", new Integer[]{Integer.valueOf(TsExtractor.TS_STREAM_TYPE_DTS), 43, 226, 255}), TuplesKt.to("brown", new Integer[]{165, 42, 42, 255}), TuplesKt.to("burlywood", new Integer[]{222, 184, Integer.valueOf(TsExtractor.TS_STREAM_TYPE_E_AC3), 255}), TuplesKt.to("cadetblue", new Integer[]{95, 158, 160, 255}), TuplesKt.to("chartreuse", new Integer[]{127, 255, 0, 255}), TuplesKt.to("chocolate", new Integer[]{210, 105, 30, 255}), TuplesKt.to("coral", new Integer[]{255, 127, 80, 255}), TuplesKt.to("cornflowerblue", new Integer[]{100, 149, 237, 255}), TuplesKt.to("cornsilk", new Integer[]{255, 248, 220, 255}), TuplesKt.to("crimson", new Integer[]{220, 20, 60, 255}), TuplesKt.to("cyan", new Integer[]{0, 255, 255, 255}), TuplesKt.to("darkblue", new Integer[]{0, 0, 139, 255}), TuplesKt.to("darkcyan", new Integer[]{0, 139, 139, 255}), TuplesKt.to("darkgoldenrod", new Integer[]{184, Integer.valueOf(TsExtractor.TS_STREAM_TYPE_SPLICE_INFO), 11, 255}), TuplesKt.to("darkgray", new Integer[]{169, 169, 169, 255}), TuplesKt.to("darkgreen", new Integer[]{0, 100, 0, 255}), TuplesKt.to("darkgrey", new Integer[]{169, 169, 169, 255}), TuplesKt.to("darkkhaki", new Integer[]{Integer.valueOf(PsExtractor.PRIVATE_STREAM_1), 183, 107, 255}), TuplesKt.to("darkmagenta", new Integer[]{139, 0, 139, 255}), TuplesKt.to("darkolivegreen", new Integer[]{85, 107, 47, 255}), TuplesKt.to("darkorange", new Integer[]{255, 140, 0, 255}), TuplesKt.to("darkorchid", new Integer[]{153, 50, 204, 255}), TuplesKt.to("darkred", new Integer[]{139, 0, 0, 255}), TuplesKt.to("darksalmon", new Integer[]{233, 150, 122, 255}), TuplesKt.to("darkseagreen", new Integer[]{143, Integer.valueOf(TsExtractor.TS_PACKET_SIZE), 143, 255}), TuplesKt.to("darkslateblue", new Integer[]{72, 61, 139, 255}), TuplesKt.to("darkslategray", new Integer[]{47, 79, 79, 255}), TuplesKt.to("darkslategrey", new Integer[]{47, 79, 79, 255}), TuplesKt.to("darkturquoise", new Integer[]{0, 206, 209, 255}), TuplesKt.to("darkviolet", new Integer[]{148, 0, 211, 255}), TuplesKt.to("deeppink", new Integer[]{255, 20, 147, 255}), TuplesKt.to("deepskyblue", new Integer[]{0, 191, 255, 255}), TuplesKt.to("dimgray", new Integer[]{105, 105, 105, 255}), TuplesKt.to("dimgrey", new Integer[]{105, 105, 105, 255}), TuplesKt.to("dodgerblue", new Integer[]{30, 144, 255, 255}), TuplesKt.to("firebrick", new Integer[]{178, 34, 34, 255}), TuplesKt.to("floralwhite", new Integer[]{255, valueOf2, valueOf, 255}), TuplesKt.to("forestgreen", new Integer[]{34, 139, 34, 255}), TuplesKt.to("fuchsia", new Integer[]{255, 0, 255, 255}), TuplesKt.to("gainsboro", new Integer[]{220, 220, 220, 255}), TuplesKt.to("ghostwhite", new Integer[]{248, 248, 255, 255}), TuplesKt.to("gold", new Integer[]{255, Integer.valueOf(JfifUtil.MARKER_RST7), 0, 255}), TuplesKt.to("goldenrod", new Integer[]{Integer.valueOf(JfifUtil.MARKER_SOS), 165, 32, 255}), TuplesKt.to("gray", new Integer[]{128, 128, 128, 255}), TuplesKt.to("green", new Integer[]{0, 128, 0, 255}), TuplesKt.to("greenyellow", new Integer[]{173, 255, 47, 255}), TuplesKt.to("grey", new Integer[]{128, 128, 128, 255}), TuplesKt.to("honeydew", new Integer[]{valueOf, 255, valueOf, 255}), TuplesKt.to("hotpink", new Integer[]{255, 105, Integer.valueOf(RotationOptions.ROTATE_180), 255}), TuplesKt.to("indianred", new Integer[]{205, 92, 92, 255}), TuplesKt.to("indigo", new Integer[]{75, 0, Integer.valueOf(TsExtractor.TS_STREAM_TYPE_HDMV_DTS), 255}), TuplesKt.to("ivory", new Integer[]{255, 255, valueOf, 255}), TuplesKt.to("khaki", new Integer[]{valueOf, 230, 140, 255}), TuplesKt.to("lavender", new Integer[]{230, 230, valueOf2, 255}), TuplesKt.to("lavenderblush", new Integer[]{255, valueOf, 245, 255}), TuplesKt.to("lawngreen", new Integer[]{124, 252, 0, 255}), TuplesKt.to("lemonchiffon", new Integer[]{255, valueOf2, 205, 255}), TuplesKt.to("lightblue", new Integer[]{173, Integer.valueOf(JfifUtil.MARKER_SOI), 230, 255}), TuplesKt.to("lightcoral", new Integer[]{valueOf, 128, 128, 255}), TuplesKt.to("lightcyan", new Integer[]{224, 255, 255, 255}), TuplesKt.to("lightgoldenrodyellow", new Integer[]{valueOf2, valueOf2, 210, 255}), TuplesKt.to("lightgray", new Integer[]{211, 211, 211, 255}), TuplesKt.to("lightgreen", new Integer[]{144, 238, 144, 255}), TuplesKt.to("lightgrey", new Integer[]{211, 211, 211, 255}), TuplesKt.to("lightpink", new Integer[]{255, 182, 193, 255}), TuplesKt.to("lightsalmon", new Integer[]{255, 160, 122, 255}), TuplesKt.to("lightseagreen", new Integer[]{32, 178, 170, 255}), TuplesKt.to("lightskyblue", new Integer[]{Integer.valueOf(TsExtractor.TS_STREAM_TYPE_E_AC3), 206, valueOf2, 255}), TuplesKt.to("lightslategray", new Integer[]{119, 136, 153, 255}), TuplesKt.to("lightslategrey", new Integer[]{119, 136, 153, 255}), TuplesKt.to("lightsteelblue", new Integer[]{176, 196, 222, 255}), TuplesKt.to("lightyellow", new Integer[]{255, 255, 224, 255}), TuplesKt.to("lime", new Integer[]{0, 255, 0, 255}), TuplesKt.to("limegreen", new Integer[]{50, 205, 50, 255}), TuplesKt.to("linen", new Integer[]{valueOf2, valueOf, 230, 255}), TuplesKt.to("magenta", new Integer[]{255, 0, 255, 255}), TuplesKt.to("maroon", new Integer[]{128, 0, 0, 255}), TuplesKt.to("mediumaquamarine", new Integer[]{102, 205, 170, 255}), TuplesKt.to("mediumblue", new Integer[]{0, 0, 205, 255}), TuplesKt.to("mediumorchid", new Integer[]{186, 85, 211, 255}), TuplesKt.to("mediumpurple", new Integer[]{147, 112, 219, 255}), TuplesKt.to("mediumseagreen", new Integer[]{60, 179, 113, 255}), TuplesKt.to("mediumslateblue", new Integer[]{123, 104, 238, 255}), TuplesKt.to("mediumspringgreen", new Integer[]{0, valueOf2, 154, 255}), TuplesKt.to("mediumturquoise", new Integer[]{72, 209, 204, 255}), TuplesKt.to("mediumvioletred", new Integer[]{199, 21, 133, 255}), TuplesKt.to("midnightblue", new Integer[]{25, 25, 112, 255}), TuplesKt.to("mintcream", new Integer[]{245, 255, valueOf2, 255}), TuplesKt.to("mistyrose", new Integer[]{255, 228, Integer.valueOf(JfifUtil.MARKER_APP1), 255}), TuplesKt.to("moccasin", new Integer[]{255, 228, 181, 255}), TuplesKt.to("navajowhite", new Integer[]{255, 222, 173, 255}), TuplesKt.to("navy", new Integer[]{0, 0, 128, 255}), TuplesKt.to("oldlace", new Integer[]{253, 245, 230, 255}), TuplesKt.to("olive", new Integer[]{128, 128, 0, 255}), TuplesKt.to("olivedrab", new Integer[]{107, 142, 35, 255}), TuplesKt.to("orange", new Integer[]{255, 165, 0, 255}), TuplesKt.to("orangered", new Integer[]{255, 69, 0, 255}), TuplesKt.to("orchid", new Integer[]{Integer.valueOf(JfifUtil.MARKER_SOS), 112, 214, 255}), TuplesKt.to("palegoldenrod", new Integer[]{238, 232, 170, 255}), TuplesKt.to("palegreen", new Integer[]{152, 251, 152, 255}), TuplesKt.to("paleturquoise", new Integer[]{175, 238, 238, 255}), TuplesKt.to("palevioletred", new Integer[]{219, 112, 147, 255}), TuplesKt.to("papayawhip", new Integer[]{255, 239, 213, 255}), TuplesKt.to("peachpuff", new Integer[]{255, Integer.valueOf(JfifUtil.MARKER_SOS), 185, 255}), TuplesKt.to("peru", new Integer[]{205, 133, 63, 255}), TuplesKt.to("pink", new Integer[]{255, 192, 203, 255}), TuplesKt.to("plum", new Integer[]{221, 160, 221, 255}), TuplesKt.to("powderblue", new Integer[]{176, 224, 230, 255}), TuplesKt.to("purple", new Integer[]{128, 0, 128, 255}), TuplesKt.to("rebeccapurple", new Integer[]{102, 51, 153, 255}), TuplesKt.to("red", new Integer[]{255, 0, 0, 255}), TuplesKt.to("rosybrown", new Integer[]{Integer.valueOf(TsExtractor.TS_PACKET_SIZE), 143, 143, 255}), TuplesKt.to("royalblue", new Integer[]{65, 105, Integer.valueOf(JfifUtil.MARKER_APP1), 255}), TuplesKt.to("saddlebrown", new Integer[]{139, 69, 19, 255}), TuplesKt.to("salmon", new Integer[]{valueOf2, 128, 114, 255}), TuplesKt.to("sandybrown", new Integer[]{244, 164, 96, 255}), TuplesKt.to("seagreen", new Integer[]{46, 139, 87, 255}), TuplesKt.to("seashell", new Integer[]{255, 245, 238, 255}), TuplesKt.to("sienna", new Integer[]{160, 82, 45, 255}), TuplesKt.to("silver", new Integer[]{192, 192, 192, 255}), TuplesKt.to("skyblue", new Integer[]{Integer.valueOf(TsExtractor.TS_STREAM_TYPE_E_AC3), 206, 235, 255}), TuplesKt.to("slateblue", new Integer[]{106, 90, 205, 255}), TuplesKt.to("slategray", new Integer[]{112, 128, 144, 255}), TuplesKt.to("slategrey", new Integer[]{112, 128, 144, 255}), TuplesKt.to("snow", new Integer[]{255, valueOf2, valueOf2, 255}), TuplesKt.to("springgreen", new Integer[]{0, 255, 127, 255}), TuplesKt.to("steelblue", new Integer[]{70, Integer.valueOf(TsExtractor.TS_STREAM_TYPE_HDMV_DTS), Integer.valueOf(RotationOptions.ROTATE_180), 255}), TuplesKt.to("tan", new Integer[]{210, Integer.valueOf(RotationOptions.ROTATE_180), 140, 255}), TuplesKt.to("teal", new Integer[]{0, 128, 128, 255}), TuplesKt.to("thistle", new Integer[]{Integer.valueOf(JfifUtil.MARKER_SOI), 191, Integer.valueOf(JfifUtil.MARKER_SOI), 255}), TuplesKt.to("tomato", new Integer[]{255, 99, 71, 255}), TuplesKt.to("transparent", new Integer[]{0, 0, 0, 0}), TuplesKt.to("turquoise", new Integer[]{64, 224, Integer.valueOf(JfifUtil.MARKER_RST0), 255}), TuplesKt.to("violet", new Integer[]{238, Integer.valueOf(TsExtractor.TS_STREAM_TYPE_HDMV_DTS), 238, 255}), TuplesKt.to("wheat", new Integer[]{245, 222, 179, 255}), TuplesKt.to("white", new Integer[]{255, 255, 255, 255}), TuplesKt.to("whitesmoke", new Integer[]{245, 245, 245, 255}), TuplesKt.to("yellow", new Integer[]{255, 255, 0, 255}), TuplesKt.to("yellowgreen", new Integer[]{154, 205, 50, 255}));
        Map<String, List<Float>> linkedHashMap = new LinkedHashMap<>(MapsKt.mapCapacity(mapOf.size()));
        for (Map.Entry entry : mapOf.entrySet()) {
            Object key = entry.getKey();
            Integer[] numArr = (Integer[]) entry.getValue();
            Collection arrayList = new ArrayList(numArr.length);
            for (Integer intValue : numArr) {
                arrayList.add(Float.valueOf(((float) intValue.intValue()) / 255.0f));
            }
            linkedHashMap.put(key, (List) arrayList);
        }
        namedColors = linkedHashMap;
    }
}
