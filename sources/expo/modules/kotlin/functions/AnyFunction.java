package expo.modules.kotlin.functions;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.ReadableArrayIterator;
import expo.modules.kotlin.ReadableArrayIteratorKt;
import expo.modules.kotlin.exception.ArgumentCastException;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.InvalidArgsNumberException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JavaScriptModuleObject;
import expo.modules.kotlin.types.AnyType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H&J\u001f\u0010\u0019\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0004¢\u0006\u0002\u0010\u001cJ'\u0010\u0019\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u00052\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005H\u0004¢\u0006\u0002\u0010\u001dJ\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fR\u0014\u0010\b\u001a\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000b¨\u0006!"}, d2 = {"Lexpo/modules/kotlin/functions/AnyFunction;", "", "name", "", "desiredArgsTypes", "", "Lexpo/modules/kotlin/types/AnyType;", "(Ljava/lang/String;[Lexpo/modules/kotlin/types/AnyType;)V", "argsCount", "", "getArgsCount$expo_modules_core_release", "()I", "getDesiredArgsTypes", "()[Lexpo/modules/kotlin/types/AnyType;", "[Lexpo/modules/kotlin/types/AnyType;", "getName", "()Ljava/lang/String;", "requiredArgumentsCount", "getRequiredArgumentsCount$expo_modules_core_release", "attachToJSObject", "", "appContext", "Lexpo/modules/kotlin/AppContext;", "jsObject", "Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "convertArgs", "args", "Lcom/facebook/react/bridge/ReadableArray;", "(Lcom/facebook/react/bridge/ReadableArray;)[Ljava/lang/Object;", "([Ljava/lang/Object;)[Ljava/lang/Object;", "getCppRequiredTypes", "", "Lexpo/modules/kotlin/jni/ExpectedType;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AnyFunction.kt */
public abstract class AnyFunction {
    private final AnyType[] desiredArgsTypes;
    private final String name;
    private final int requiredArgumentsCount;

    public abstract void attachToJSObject(AppContext appContext, JavaScriptModuleObject javaScriptModuleObject);

    public AnyFunction(String str, AnyType[] anyTypeArr) {
        int i;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(anyTypeArr, "desiredArgsTypes");
        this.name = str;
        this.desiredArgsTypes = anyTypeArr;
        AnyFunction anyFunction = this;
        Iterator it = ArraysKt.reversed((T[]) this.desiredArgsTypes).iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (!((AnyType) it.next()).getKType().isMarkedNullable()) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0) {
            i = this.desiredArgsTypes.length;
        } else {
            i = this.desiredArgsTypes.length - i2;
        }
        this.requiredArgumentsCount = i;
    }

    /* access modifiers changed from: protected */
    public final String getName() {
        return this.name;
    }

    /* access modifiers changed from: protected */
    public final AnyType[] getDesiredArgsTypes() {
        return this.desiredArgsTypes;
    }

    public final int getArgsCount$expo_modules_core_release() {
        return this.desiredArgsTypes.length;
    }

    public final int getRequiredArgumentsCount$expo_modules_core_release() {
        return this.requiredArgumentsCount;
    }

    /* access modifiers changed from: protected */
    public final Object[] convertArgs(ReadableArray readableArray) throws CodedException {
        Intrinsics.checkNotNullParameter(readableArray, StepData.ARGS);
        if (this.requiredArgumentsCount <= readableArray.size()) {
            int size = readableArray.size();
            AnyType[] anyTypeArr = this.desiredArgsTypes;
            if (size <= anyTypeArr.length) {
                int length = anyTypeArr.length;
                Object[] objArr = new Object[length];
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    objArr[i2] = null;
                }
                ReadableArrayIterator it = ReadableArrayIteratorKt.iterator(readableArray);
                int size2 = readableArray.size();
                while (i < size2) {
                    AnyType anyType = this.desiredArgsTypes[i];
                    Dynamic next = it.next();
                    try {
                        objArr[i] = anyType.convert(next);
                        Unit unit = Unit.INSTANCE;
                        Unit unit2 = Unit.INSTANCE;
                        next.recycle();
                        i++;
                    } catch (CodedException e) {
                        throw new ArgumentCastException(anyType.getKType(), i, next.getType().toString(), e);
                    } catch (expo.modules.core.errors.CodedException e2) {
                        String code = e2.getCode();
                        Intrinsics.checkNotNullExpressionValue(code, "e.code");
                        throw new ArgumentCastException(anyType.getKType(), i, next.getType().toString(), new CodedException(code, e2.getMessage(), e2.getCause()));
                    } catch (Throwable th) {
                        next.recycle();
                        throw th;
                    }
                }
                return objArr;
            }
        }
        throw new InvalidArgsNumberException(readableArray.size(), this.desiredArgsTypes.length, this.requiredArgumentsCount);
    }

    /* access modifiers changed from: protected */
    public final Object[] convertArgs(Object[] objArr) throws CodedException {
        Class<?> cls;
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        if (this.requiredArgumentsCount <= objArr.length) {
            int length = objArr.length;
            AnyType[] anyTypeArr = this.desiredArgsTypes;
            if (length <= anyTypeArr.length) {
                int length2 = anyTypeArr.length;
                Object[] objArr2 = new Object[length2];
                int i = 0;
                int i2 = 0;
                while (true) {
                    cls = null;
                    if (i2 >= length2) {
                        break;
                    }
                    objArr2[i2] = null;
                    i2++;
                }
                Iterator it = ArrayIteratorKt.iterator(objArr);
                int length3 = objArr.length;
                while (i < length3) {
                    Object next = it.next();
                    AnyType anyType = this.desiredArgsTypes[i];
                    try {
                        objArr2[i] = anyType.convert(next);
                        Unit unit = Unit.INSTANCE;
                        i++;
                    } catch (CodedException e) {
                        KType kType = anyType.getKType();
                        if (next != null) {
                            cls = next.getClass();
                        }
                        throw new ArgumentCastException(kType, i, String.valueOf(cls), e);
                    } catch (expo.modules.core.errors.CodedException e2) {
                        String code = e2.getCode();
                        Intrinsics.checkNotNullExpressionValue(code, "e.code");
                        CodedException codedException = new CodedException(code, e2.getMessage(), e2.getCause());
                        KType kType2 = anyType.getKType();
                        if (next != null) {
                            cls = next.getClass();
                        }
                        throw new ArgumentCastException(kType2, i, String.valueOf(cls), codedException);
                    } catch (Throwable th) {
                        CodedException unexpectedException = new UnexpectedException(th);
                        KType kType3 = anyType.getKType();
                        if (next != null) {
                            cls = next.getClass();
                        }
                        throw new ArgumentCastException(kType3, i, String.valueOf(cls), unexpectedException);
                    }
                }
                return objArr2;
            }
        }
        throw new InvalidArgsNumberException(objArr.length, this.desiredArgsTypes.length, this.requiredArgumentsCount);
    }

    public final List<ExpectedType> getCppRequiredTypes() {
        AnyType[] anyTypeArr = this.desiredArgsTypes;
        Collection arrayList = new ArrayList(anyTypeArr.length);
        for (AnyType cppRequiredTypes : anyTypeArr) {
            arrayList.add(cppRequiredTypes.getCppRequiredTypes());
        }
        return (List) arrayList;
    }
}
