package com.facebook.internal.qualityvalidation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0014\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004R\u0017\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/qualityvalidation/ExcusesForDesignViolations;", "", "value", "", "Lcom/facebook/internal/qualityvalidation/Excuse;", "()[Lcom/facebook/internal/qualityvalidation/Excuse;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Retention(RetentionPolicy.SOURCE)
/* compiled from: ExcusesForDesignViolations.kt */
public @interface ExcusesForDesignViolations {
    Excuse[] value();
}
