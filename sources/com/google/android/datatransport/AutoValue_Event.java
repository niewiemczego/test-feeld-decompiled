package com.google.android.datatransport;

final class AutoValue_Event<T> extends Event<T> {
    private final Integer code;
    private final T payload;
    private final Priority priority;
    private final ProductData productData;

    AutoValue_Event(Integer num, T t, Priority priority2, ProductData productData2) {
        this.code = num;
        if (t != null) {
            this.payload = t;
            if (priority2 != null) {
                this.priority = priority2;
                this.productData = productData2;
                return;
            }
            throw new NullPointerException("Null priority");
        }
        throw new NullPointerException("Null payload");
    }

    public Integer getCode() {
        return this.code;
    }

    public T getPayload() {
        return this.payload;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public ProductData getProductData() {
        return this.productData;
    }

    public String toString() {
        return "Event{code=" + this.code + ", payload=" + this.payload + ", priority=" + this.priority + ", productData=" + this.productData + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        Integer num = this.code;
        if (num != null ? num.equals(event.getCode()) : event.getCode() == null) {
            if (this.payload.equals(event.getPayload()) && this.priority.equals(event.getPriority())) {
                ProductData productData2 = this.productData;
                if (productData2 == null) {
                    if (event.getProductData() == null) {
                        return true;
                    }
                } else if (productData2.equals(event.getProductData())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.code;
        int i = 0;
        int hashCode = ((((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.payload.hashCode()) * 1000003) ^ this.priority.hashCode()) * 1000003;
        ProductData productData2 = this.productData;
        if (productData2 != null) {
            i = productData2.hashCode();
        }
        return hashCode ^ i;
    }
}
