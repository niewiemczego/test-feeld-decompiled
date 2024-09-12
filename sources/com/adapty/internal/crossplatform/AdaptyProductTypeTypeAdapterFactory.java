package com.adapty.internal.crossplatform;

import com.adapty.internal.domain.models.BackendProduct;
import com.adapty.internal.domain.models.ProductType;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

class AdaptyProductTypeTypeAdapterFactory implements TypeAdapterFactory {
    private static final String BASE_PLAN_ID = "base_plan_id";
    private static final String IS_CONSUMABLE = "is_consumable";
    private static final String OFFER_ID = "offer_id";
    static Class<BackendProduct> backendProductClass = BackendProduct.class;

    AdaptyProductTypeTypeAdapterFactory() {
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        if (!ProductType.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        final TypeAdapter<JsonElement> adapter = gson.getAdapter(JsonElement.class);
        return new TypeAdapter<ProductType>() {
            public void write(JsonWriter jsonWriter, ProductType productType) throws IOException {
                JsonObject jsonObject = new JsonObject();
                if (productType instanceof ProductType.Subscription) {
                    BackendProduct.SubscriptionData subscriptionData = ((ProductType.Subscription) productType).getSubscriptionData();
                    jsonObject.addProperty("base_plan_id", subscriptionData.getBasePlanId());
                    if (subscriptionData.getOfferId() != null) {
                        jsonObject.addProperty("offer_id", subscriptionData.getOfferId());
                    }
                }
                jsonObject.addProperty("is_consumable", Boolean.valueOf(productType instanceof ProductType.Consumable));
                adapter.write(jsonWriter, jsonObject);
            }

            public ProductType read(JsonReader jsonReader) throws IOException {
                JsonObject asJsonObject = ((JsonElement) adapter.read(jsonReader)).getAsJsonObject();
                JsonElement remove = asJsonObject.remove("base_plan_id");
                BackendProduct.SubscriptionData subscriptionData = null;
                String asString = remove instanceof JsonPrimitive ? remove.getAsString() : null;
                JsonElement remove2 = asJsonObject.remove("offer_id");
                String asString2 = remove2 instanceof JsonPrimitive ? remove2.getAsString() : null;
                JsonElement remove3 = asJsonObject.remove("is_consumable");
                boolean z = false;
                if (remove3 instanceof JsonPrimitive) {
                    z = remove3.getAsBoolean();
                }
                if (asString != null) {
                    subscriptionData = new BackendProduct.SubscriptionData(asString, asString2);
                }
                if (subscriptionData != null) {
                    return new ProductType.Subscription(subscriptionData);
                }
                if (z) {
                    return ProductType.Consumable.INSTANCE;
                }
                return ProductType.NonConsumable.INSTANCE;
            }
        }.nullSafe();
    }
}
