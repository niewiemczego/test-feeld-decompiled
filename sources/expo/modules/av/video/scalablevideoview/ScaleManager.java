package expo.modules.av.video.scalablevideoview;

import android.graphics.Matrix;
import android.util.Size;

public class ScaleManager {
    private Size mVideoSize;
    private Size mViewSize;

    public ScaleManager(Size size, Size size2) {
        this.mViewSize = size;
        this.mVideoSize = size2;
    }

    public Matrix getScaleMatrix(ScalableType scalableType) {
        switch (AnonymousClass1.$SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType[scalableType.ordinal()]) {
            case 1:
                return getNoScale();
            case 2:
                return fitXY();
            case 3:
                return fitCenter();
            case 4:
                return fitStart();
            case 5:
                return fitEnd();
            case 6:
                return getOriginalScale(PivotPoint.LEFT_TOP);
            case 7:
                return getOriginalScale(PivotPoint.LEFT_CENTER);
            case 8:
                return getOriginalScale(PivotPoint.LEFT_BOTTOM);
            case 9:
                return getOriginalScale(PivotPoint.CENTER_TOP);
            case 10:
                return getOriginalScale(PivotPoint.CENTER);
            case 11:
                return getOriginalScale(PivotPoint.CENTER_BOTTOM);
            case 12:
                return getOriginalScale(PivotPoint.RIGHT_TOP);
            case 13:
                return getOriginalScale(PivotPoint.RIGHT_CENTER);
            case 14:
                return getOriginalScale(PivotPoint.RIGHT_BOTTOM);
            case 15:
                return getCropScale(PivotPoint.LEFT_TOP);
            case 16:
                return getCropScale(PivotPoint.LEFT_CENTER);
            case 17:
                return getCropScale(PivotPoint.LEFT_BOTTOM);
            case 18:
                return getCropScale(PivotPoint.CENTER_TOP);
            case 19:
                return getCropScale(PivotPoint.CENTER);
            case 20:
                return getCropScale(PivotPoint.CENTER_BOTTOM);
            case 21:
                return getCropScale(PivotPoint.RIGHT_TOP);
            case 22:
                return getCropScale(PivotPoint.RIGHT_CENTER);
            case 23:
                return getCropScale(PivotPoint.RIGHT_BOTTOM);
            case 24:
                return startInside();
            case 25:
                return centerInside();
            case 26:
                return endInside();
            default:
                return null;
        }
    }

    private Matrix getMatrix(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2, f3, f4);
        return matrix;
    }

    /* renamed from: expo.modules.av.video.scalablevideoview.ScaleManager$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$expo$modules$av$video$scalablevideoview$PivotPoint;
        static final /* synthetic */ int[] $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType;

        /* JADX WARNING: Can't wrap try/catch for region: R(71:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|(3:87|88|90)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(72:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|(3:87|88|90)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(73:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|(3:87|88|90)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(74:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|(3:87|88|90)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(75:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|(3:87|88|90)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(76:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|(3:87|88|90)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(77:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|(3:87|88|90)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(79:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|90) */
        /* JADX WARNING: Can't wrap try/catch for region: R(81:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|90) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x007d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0087 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0091 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x009b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00a5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00af */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00b9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00c3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00cd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00d9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00e5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00f1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x00fd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0109 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x0115 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0121 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x012d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x0139 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x0145 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x0151 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x015d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x0169 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x0175 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x0181 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x018d */
        static {
            /*
                expo.modules.av.video.scalablevideoview.PivotPoint[] r0 = expo.modules.av.video.scalablevideoview.PivotPoint.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$expo$modules$av$video$scalablevideoview$PivotPoint = r0
                r1 = 1
                expo.modules.av.video.scalablevideoview.PivotPoint r2 = expo.modules.av.video.scalablevideoview.PivotPoint.LEFT_TOP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$expo$modules$av$video$scalablevideoview$PivotPoint     // Catch:{ NoSuchFieldError -> 0x001d }
                expo.modules.av.video.scalablevideoview.PivotPoint r3 = expo.modules.av.video.scalablevideoview.PivotPoint.LEFT_CENTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$expo$modules$av$video$scalablevideoview$PivotPoint     // Catch:{ NoSuchFieldError -> 0x0028 }
                expo.modules.av.video.scalablevideoview.PivotPoint r4 = expo.modules.av.video.scalablevideoview.PivotPoint.LEFT_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$expo$modules$av$video$scalablevideoview$PivotPoint     // Catch:{ NoSuchFieldError -> 0x0033 }
                expo.modules.av.video.scalablevideoview.PivotPoint r5 = expo.modules.av.video.scalablevideoview.PivotPoint.CENTER_TOP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = $SwitchMap$expo$modules$av$video$scalablevideoview$PivotPoint     // Catch:{ NoSuchFieldError -> 0x003e }
                expo.modules.av.video.scalablevideoview.PivotPoint r6 = expo.modules.av.video.scalablevideoview.PivotPoint.CENTER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = $SwitchMap$expo$modules$av$video$scalablevideoview$PivotPoint     // Catch:{ NoSuchFieldError -> 0x0049 }
                expo.modules.av.video.scalablevideoview.PivotPoint r7 = expo.modules.av.video.scalablevideoview.PivotPoint.CENTER_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = $SwitchMap$expo$modules$av$video$scalablevideoview$PivotPoint     // Catch:{ NoSuchFieldError -> 0x0054 }
                expo.modules.av.video.scalablevideoview.PivotPoint r8 = expo.modules.av.video.scalablevideoview.PivotPoint.RIGHT_TOP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                r7 = 8
                int[] r8 = $SwitchMap$expo$modules$av$video$scalablevideoview$PivotPoint     // Catch:{ NoSuchFieldError -> 0x0060 }
                expo.modules.av.video.scalablevideoview.PivotPoint r9 = expo.modules.av.video.scalablevideoview.PivotPoint.RIGHT_CENTER     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r8[r9] = r7     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                r8 = 9
                int[] r9 = $SwitchMap$expo$modules$av$video$scalablevideoview$PivotPoint     // Catch:{ NoSuchFieldError -> 0x006c }
                expo.modules.av.video.scalablevideoview.PivotPoint r10 = expo.modules.av.video.scalablevideoview.PivotPoint.RIGHT_BOTTOM     // Catch:{ NoSuchFieldError -> 0x006c }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r9[r10] = r8     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                expo.modules.av.video.scalablevideoview.ScalableType[] r9 = expo.modules.av.video.scalablevideoview.ScalableType.values()
                int r9 = r9.length
                int[] r9 = new int[r9]
                $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType = r9
                expo.modules.av.video.scalablevideoview.ScalableType r10 = expo.modules.av.video.scalablevideoview.ScalableType.NONE     // Catch:{ NoSuchFieldError -> 0x007d }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r9[r10] = r1     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                int[] r1 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x0087 }
                expo.modules.av.video.scalablevideoview.ScalableType r9 = expo.modules.av.video.scalablevideoview.ScalableType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r1[r9] = r0     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                int[] r0 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x0091 }
                expo.modules.av.video.scalablevideoview.ScalableType r1 = expo.modules.av.video.scalablevideoview.ScalableType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0091 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0091 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0091 }
            L_0x0091:
                int[] r0 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x009b }
                expo.modules.av.video.scalablevideoview.ScalableType r1 = expo.modules.av.video.scalablevideoview.ScalableType.FIT_START     // Catch:{ NoSuchFieldError -> 0x009b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009b }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x009b }
            L_0x009b:
                int[] r0 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x00a5 }
                expo.modules.av.video.scalablevideoview.ScalableType r1 = expo.modules.av.video.scalablevideoview.ScalableType.FIT_END     // Catch:{ NoSuchFieldError -> 0x00a5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a5 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00a5 }
            L_0x00a5:
                int[] r0 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x00af }
                expo.modules.av.video.scalablevideoview.ScalableType r1 = expo.modules.av.video.scalablevideoview.ScalableType.LEFT_TOP     // Catch:{ NoSuchFieldError -> 0x00af }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00af }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00af }
            L_0x00af:
                int[] r0 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x00b9 }
                expo.modules.av.video.scalablevideoview.ScalableType r1 = expo.modules.av.video.scalablevideoview.ScalableType.LEFT_CENTER     // Catch:{ NoSuchFieldError -> 0x00b9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b9 }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x00b9 }
            L_0x00b9:
                int[] r0 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x00c3 }
                expo.modules.av.video.scalablevideoview.ScalableType r1 = expo.modules.av.video.scalablevideoview.ScalableType.LEFT_BOTTOM     // Catch:{ NoSuchFieldError -> 0x00c3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c3 }
                r0[r1] = r7     // Catch:{ NoSuchFieldError -> 0x00c3 }
            L_0x00c3:
                int[] r0 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x00cd }
                expo.modules.av.video.scalablevideoview.ScalableType r1 = expo.modules.av.video.scalablevideoview.ScalableType.CENTER_TOP     // Catch:{ NoSuchFieldError -> 0x00cd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cd }
                r0[r1] = r8     // Catch:{ NoSuchFieldError -> 0x00cd }
            L_0x00cd:
                int[] r0 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x00d9 }
                expo.modules.av.video.scalablevideoview.ScalableType r1 = expo.modules.av.video.scalablevideoview.ScalableType.CENTER     // Catch:{ NoSuchFieldError -> 0x00d9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d9 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d9 }
            L_0x00d9:
                int[] r0 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x00e5 }
                expo.modules.av.video.scalablevideoview.ScalableType r1 = expo.modules.av.video.scalablevideoview.ScalableType.CENTER_BOTTOM     // Catch:{ NoSuchFieldError -> 0x00e5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e5 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e5 }
            L_0x00e5:
                int[] r0 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x00f1 }
                expo.modules.av.video.scalablevideoview.ScalableType r1 = expo.modules.av.video.scalablevideoview.ScalableType.RIGHT_TOP     // Catch:{ NoSuchFieldError -> 0x00f1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f1 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f1 }
            L_0x00f1:
                int[] r0 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x00fd }
                expo.modules.av.video.scalablevideoview.ScalableType r1 = expo.modules.av.video.scalablevideoview.ScalableType.RIGHT_CENTER     // Catch:{ NoSuchFieldError -> 0x00fd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fd }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fd }
            L_0x00fd:
                int[] r0 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x0109 }
                expo.modules.av.video.scalablevideoview.ScalableType r1 = expo.modules.av.video.scalablevideoview.ScalableType.RIGHT_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0109 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0109 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0109 }
            L_0x0109:
                int[] r0 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x0115 }
                expo.modules.av.video.scalablevideoview.ScalableType r1 = expo.modules.av.video.scalablevideoview.ScalableType.LEFT_TOP_CROP     // Catch:{ NoSuchFieldError -> 0x0115 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0115 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0115 }
            L_0x0115:
                int[] r0 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x0121 }
                expo.modules.av.video.scalablevideoview.ScalableType r1 = expo.modules.av.video.scalablevideoview.ScalableType.LEFT_CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x0121 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0121 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0121 }
            L_0x0121:
                int[] r0 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x012d }
                expo.modules.av.video.scalablevideoview.ScalableType r1 = expo.modules.av.video.scalablevideoview.ScalableType.LEFT_BOTTOM_CROP     // Catch:{ NoSuchFieldError -> 0x012d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012d }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x012d }
            L_0x012d:
                int[] r0 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x0139 }
                expo.modules.av.video.scalablevideoview.ScalableType r1 = expo.modules.av.video.scalablevideoview.ScalableType.CENTER_TOP_CROP     // Catch:{ NoSuchFieldError -> 0x0139 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0139 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0139 }
            L_0x0139:
                int[] r0 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x0145 }
                expo.modules.av.video.scalablevideoview.ScalableType r1 = expo.modules.av.video.scalablevideoview.ScalableType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x0145 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0145 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0145 }
            L_0x0145:
                int[] r0 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x0151 }
                expo.modules.av.video.scalablevideoview.ScalableType r1 = expo.modules.av.video.scalablevideoview.ScalableType.CENTER_BOTTOM_CROP     // Catch:{ NoSuchFieldError -> 0x0151 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0151 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0151 }
            L_0x0151:
                int[] r0 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x015d }
                expo.modules.av.video.scalablevideoview.ScalableType r1 = expo.modules.av.video.scalablevideoview.ScalableType.RIGHT_TOP_CROP     // Catch:{ NoSuchFieldError -> 0x015d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x015d }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x015d }
            L_0x015d:
                int[] r0 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x0169 }
                expo.modules.av.video.scalablevideoview.ScalableType r1 = expo.modules.av.video.scalablevideoview.ScalableType.RIGHT_CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x0169 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0169 }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0169 }
            L_0x0169:
                int[] r0 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x0175 }
                expo.modules.av.video.scalablevideoview.ScalableType r1 = expo.modules.av.video.scalablevideoview.ScalableType.RIGHT_BOTTOM_CROP     // Catch:{ NoSuchFieldError -> 0x0175 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0175 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0175 }
            L_0x0175:
                int[] r0 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x0181 }
                expo.modules.av.video.scalablevideoview.ScalableType r1 = expo.modules.av.video.scalablevideoview.ScalableType.START_INSIDE     // Catch:{ NoSuchFieldError -> 0x0181 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0181 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0181 }
            L_0x0181:
                int[] r0 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x018d }
                expo.modules.av.video.scalablevideoview.ScalableType r1 = expo.modules.av.video.scalablevideoview.ScalableType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x018d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x018d }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x018d }
            L_0x018d:
                int[] r0 = $SwitchMap$expo$modules$av$video$scalablevideoview$ScalableType     // Catch:{ NoSuchFieldError -> 0x0199 }
                expo.modules.av.video.scalablevideoview.ScalableType r1 = expo.modules.av.video.scalablevideoview.ScalableType.END_INSIDE     // Catch:{ NoSuchFieldError -> 0x0199 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0199 }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0199 }
            L_0x0199:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.av.video.scalablevideoview.ScaleManager.AnonymousClass1.<clinit>():void");
        }
    }

    private Matrix getMatrix(float f, float f2, PivotPoint pivotPoint) {
        switch (AnonymousClass1.$SwitchMap$expo$modules$av$video$scalablevideoview$PivotPoint[pivotPoint.ordinal()]) {
            case 1:
                return getMatrix(f, f2, 0.0f, 0.0f);
            case 2:
                return getMatrix(f, f2, 0.0f, ((float) this.mViewSize.getHeight()) / 2.0f);
            case 3:
                return getMatrix(f, f2, 0.0f, (float) this.mViewSize.getHeight());
            case 4:
                return getMatrix(f, f2, ((float) this.mViewSize.getWidth()) / 2.0f, 0.0f);
            case 5:
                return getMatrix(f, f2, ((float) this.mViewSize.getWidth()) / 2.0f, ((float) this.mViewSize.getHeight()) / 2.0f);
            case 6:
                return getMatrix(f, f2, ((float) this.mViewSize.getWidth()) / 2.0f, (float) this.mViewSize.getHeight());
            case 7:
                return getMatrix(f, f2, (float) this.mViewSize.getWidth(), 0.0f);
            case 8:
                return getMatrix(f, f2, (float) this.mViewSize.getWidth(), ((float) this.mViewSize.getHeight()) / 2.0f);
            case 9:
                return getMatrix(f, f2, (float) this.mViewSize.getWidth(), (float) this.mViewSize.getHeight());
            default:
                throw new IllegalArgumentException("Illegal PivotPoint");
        }
    }

    private Matrix getNoScale() {
        return getMatrix(((float) this.mVideoSize.getWidth()) / ((float) this.mViewSize.getWidth()), ((float) this.mVideoSize.getHeight()) / ((float) this.mViewSize.getHeight()), PivotPoint.LEFT_TOP);
    }

    private Matrix getFitScale(PivotPoint pivotPoint) {
        float width = ((float) this.mViewSize.getWidth()) / ((float) this.mVideoSize.getWidth());
        float height = ((float) this.mViewSize.getHeight()) / ((float) this.mVideoSize.getHeight());
        float min = Math.min(width, height);
        return getMatrix(min / width, min / height, pivotPoint);
    }

    private Matrix fitXY() {
        return getMatrix(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix fitStart() {
        return getFitScale(PivotPoint.LEFT_TOP);
    }

    private Matrix fitCenter() {
        return getFitScale(PivotPoint.CENTER);
    }

    private Matrix fitEnd() {
        return getFitScale(PivotPoint.RIGHT_BOTTOM);
    }

    private Matrix getOriginalScale(PivotPoint pivotPoint) {
        return getMatrix(((float) this.mVideoSize.getWidth()) / ((float) this.mViewSize.getWidth()), ((float) this.mVideoSize.getHeight()) / ((float) this.mViewSize.getHeight()), pivotPoint);
    }

    private Matrix getCropScale(PivotPoint pivotPoint) {
        float width = ((float) this.mViewSize.getWidth()) / ((float) this.mVideoSize.getWidth());
        float height = ((float) this.mViewSize.getHeight()) / ((float) this.mVideoSize.getHeight());
        float max = Math.max(width, height);
        return getMatrix(max / width, max / height, pivotPoint);
    }

    private Matrix startInside() {
        if (this.mVideoSize.getHeight() > this.mViewSize.getWidth() || this.mVideoSize.getHeight() > this.mViewSize.getHeight()) {
            return fitStart();
        }
        return getOriginalScale(PivotPoint.LEFT_TOP);
    }

    private Matrix centerInside() {
        if (this.mVideoSize.getHeight() > this.mViewSize.getWidth() || this.mVideoSize.getHeight() > this.mViewSize.getHeight()) {
            return fitCenter();
        }
        return getOriginalScale(PivotPoint.CENTER);
    }

    private Matrix endInside() {
        if (this.mVideoSize.getHeight() > this.mViewSize.getWidth() || this.mVideoSize.getHeight() > this.mViewSize.getHeight()) {
            return fitEnd();
        }
        return getOriginalScale(PivotPoint.RIGHT_BOTTOM);
    }
}
