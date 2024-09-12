package com.facebook.imagepipeline.listener;

import com.facebook.imagepipeline.producers.ProducerContext;
import java.util.Map;
import javax.annotation.Nullable;

public class BaseRequestListener2 implements RequestListener2 {
    public void onProducerEvent(ProducerContext producerContext, String str, String str2) {
    }

    public void onProducerFinishWithCancellation(ProducerContext producerContext, String str, @Nullable Map<String, String> map) {
    }

    public void onProducerFinishWithFailure(ProducerContext producerContext, String str, Throwable th, @Nullable Map<String, String> map) {
    }

    public void onProducerFinishWithSuccess(ProducerContext producerContext, String str, @Nullable Map<String, String> map) {
    }

    public void onProducerStart(ProducerContext producerContext, String str) {
    }

    public void onRequestCancellation(ProducerContext producerContext) {
    }

    public void onRequestFailure(ProducerContext producerContext, Throwable th) {
    }

    public void onRequestStart(ProducerContext producerContext) {
    }

    public void onRequestSuccess(ProducerContext producerContext) {
    }

    public void onUltimateProducerReached(ProducerContext producerContext, String str, boolean z) {
    }

    public boolean requiresExtraMap(ProducerContext producerContext, String str) {
        return false;
    }
}
