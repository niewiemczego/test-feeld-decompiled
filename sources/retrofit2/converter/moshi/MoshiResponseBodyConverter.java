package retrofit2.converter.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import java.io.IOException;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.ByteString;
import retrofit2.Converter;

final class MoshiResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private static final ByteString UTF8_BOM = ByteString.decodeHex("EFBBBF");
    private final JsonAdapter<T> adapter;

    MoshiResponseBodyConverter(JsonAdapter<T> jsonAdapter) {
        this.adapter = jsonAdapter;
    }

    public T convert(ResponseBody responseBody) throws IOException {
        BufferedSource source = responseBody.source();
        try {
            ByteString byteString = UTF8_BOM;
            if (source.rangeEquals(0, byteString)) {
                source.skip((long) byteString.size());
            }
            JsonReader of = JsonReader.of(source);
            T fromJson = this.adapter.fromJson(of);
            if (of.peek() == JsonReader.Token.END_DOCUMENT) {
                return fromJson;
            }
            throw new JsonDataException("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}
