package org.apache.commons.io.function;

import java.io.IOException;
import java.util.Objects;

@FunctionalInterface
public interface IOConsumer<T> {
    void accept(T t) throws IOException;

    IOConsumer<T> andThen(IOConsumer<? super T> iOConsumer) {
        Objects.requireNonNull(iOConsumer);
        return new IOConsumer$$ExternalSyntheticLambda0(this, iOConsumer);
    }

    static /* synthetic */ void lambda$andThen$0(IOConsumer _this, IOConsumer iOConsumer, Object obj) throws IOException {
        _this.accept(obj);
        iOConsumer.accept(obj);
    }
}
