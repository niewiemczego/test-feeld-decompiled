package io.sentry;

import java.io.IOException;

public interface JsonSerializable {
    void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException;
}
