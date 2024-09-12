package androidx.room.util;

import java.nio.ByteBuffer;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001¨\u0006\u0006"}, d2 = {"convertByteToUUID", "Ljava/util/UUID;", "bytes", "", "convertUUIDToByte", "uuid", "room-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: UUIDUtil.kt */
public final class UUIDUtil {
    public static final UUID convertByteToUUID(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        return new UUID(wrap.getLong(), wrap.getLong());
    }

    public static final byte[] convertUUIDToByte(UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        ByteBuffer wrap = ByteBuffer.wrap(new byte[16]);
        wrap.putLong(uuid.getMostSignificantBits());
        wrap.putLong(uuid.getLeastSignificantBits());
        byte[] array = wrap.array();
        Intrinsics.checkNotNullExpressionValue(array, "buffer.array()");
        return array;
    }
}
