package org.checkerframework.checker.signedness.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.DefaultFor;
import org.checkerframework.framework.qual.SubtypeOf;
import org.checkerframework.framework.qual.TypeKind;
import org.checkerframework.framework.qual.UpperBoundFor;

@DefaultFor(typeKinds = {TypeKind.CHAR}, types = {Character.class})
@SubtypeOf({UnknownSignedness.class})
@Documented
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@UpperBoundFor(typeKinds = {TypeKind.CHAR}, types = {Character.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface Unsigned {
}
