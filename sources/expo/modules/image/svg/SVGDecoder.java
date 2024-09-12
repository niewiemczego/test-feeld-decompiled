package expo.modules.image.svg;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.SimpleResource;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J0\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000f"}, d2 = {"Lexpo/modules/image/svg/SVGDecoder;", "Lcom/bumptech/glide/load/ResourceDecoder;", "Ljava/io/InputStream;", "Lcom/caverock/androidsvg/SVG;", "()V", "decode", "Lcom/bumptech/glide/load/engine/Resource;", "source", "width", "", "height", "options", "Lcom/bumptech/glide/load/Options;", "handles", "", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SVGDecoder.kt */
public final class SVGDecoder implements ResourceDecoder<InputStream, SVG> {
    public boolean handles(InputStream inputStream, Options options) {
        Intrinsics.checkNotNullParameter(inputStream, "source");
        Intrinsics.checkNotNullParameter(options, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        return true;
    }

    public Resource<SVG> decode(InputStream inputStream, int i, int i2, Options options) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "source");
        Intrinsics.checkNotNullParameter(options, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        try {
            SVG fromInputStream = SVG.getFromInputStream(inputStream);
            Intrinsics.checkNotNullExpressionValue(fromInputStream, "getFromInputStream(source)");
            if (i != Integer.MIN_VALUE) {
                fromInputStream.setDocumentWidth((float) i);
            }
            if (i2 != Integer.MIN_VALUE) {
                fromInputStream.setDocumentHeight((float) i2);
            }
            return new SimpleResource<>(fromInputStream);
        } catch (SVGParseException e) {
            throw new IOException("Cannot load SVG from stream", e);
        }
    }
}
