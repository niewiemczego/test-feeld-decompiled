package org.apache.commons.io.function;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@FunctionalInterface
public interface IOFunction<T, R> {
    static /* synthetic */ Object lambda$identity$8(Object obj) throws IOException {
        return obj;
    }

    R apply(T t) throws IOException;

    <V> IOFunction<V, R> compose(IOFunction<? super V, ? extends T> iOFunction) {
        Objects.requireNonNull(iOFunction);
        return new IOFunction$$ExternalSyntheticLambda5(this, iOFunction);
    }

    <V> IOFunction<V, R> compose(Function<? super V, ? extends T> function) {
        Objects.requireNonNull(function);
        return new IOFunction$$ExternalSyntheticLambda6(this, function);
    }

    IOSupplier<R> compose(IOSupplier<? extends T> iOSupplier) {
        Objects.requireNonNull(iOSupplier);
        return new IOFunction$$ExternalSyntheticLambda7(this, iOSupplier);
    }

    IOSupplier<R> compose(Supplier<? extends T> supplier) {
        Objects.requireNonNull(supplier);
        return new IOFunction$$ExternalSyntheticLambda0(this, supplier);
    }

    <V> IOFunction<T, V> andThen(IOFunction<? super R, ? extends V> iOFunction) {
        Objects.requireNonNull(iOFunction);
        return new IOFunction$$ExternalSyntheticLambda2(this, iOFunction);
    }

    <V> IOFunction<T, V> andThen(Function<? super R, ? extends V> function) {
        Objects.requireNonNull(function);
        return new IOFunction$$ExternalSyntheticLambda1(this, function);
    }

    IOConsumer<T> andThen(IOConsumer<? super R> iOConsumer) {
        Objects.requireNonNull(iOConsumer);
        return new IOFunction$$ExternalSyntheticLambda8(this, iOConsumer);
    }

    IOConsumer<T> andThen(Consumer<? super R> consumer) {
        Objects.requireNonNull(consumer);
        return new IOFunction$$ExternalSyntheticLambda4(this, consumer);
    }

    static <T> IOFunction<T, T> identity() {
        return new IOFunction$$ExternalSyntheticLambda3();
    }
}
