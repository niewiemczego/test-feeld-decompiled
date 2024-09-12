package expo.modules.kotlin.objects;

import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.EventsDefinition;
import expo.modules.kotlin.functions.AsyncFunction;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0005J,\u0010\u001d\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u001f\u0018\u00012\u0006\u0010\u001e\u001a\u00020\u00052\u000e\b\u0004\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001f0\rH\bø\u0001\u0000J+\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00052\u0010\b\u0004\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH\bø\u0001\u0000¢\u0006\u0002\b!JI\u0010\u001d\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u001f\u0018\u0001\"\u0006\b\u0001\u0010\"\u0018\u00012\u0006\u0010\u001e\u001a\u00020\u00052#\b\u0004\u0010 \u001a\u001d\u0012\u0013\u0012\u0011H\"¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(%\u0012\u0004\u0012\u0002H\u001f0#H\bø\u0001\u0000Jf\u0010\u001d\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u001f\u0018\u0001\"\u0006\b\u0001\u0010\"\u0018\u0001\"\u0006\b\u0002\u0010&\u0018\u00012\u0006\u0010\u001e\u001a\u00020\u000528\b\u0004\u0010 \u001a2\u0012\u0013\u0012\u0011H\"¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b((\u0012\u0004\u0012\u0002H\u001f0'H\bø\u0001\u0000J\u0001\u0010\u001d\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u001f\u0018\u0001\"\u0006\b\u0001\u0010\"\u0018\u0001\"\u0006\b\u0002\u0010&\u0018\u0001\"\u0006\b\u0003\u0010)\u0018\u00012\u0006\u0010\u001e\u001a\u00020\u00052M\b\u0004\u0010 \u001aG\u0012\u0013\u0012\u0011H\"¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002H\u001f0*H\bø\u0001\u0000J \u0001\u0010\u001d\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u001f\u0018\u0001\"\u0006\b\u0001\u0010\"\u0018\u0001\"\u0006\b\u0002\u0010&\u0018\u0001\"\u0006\b\u0003\u0010)\u0018\u0001\"\u0006\b\u0004\u0010,\u0018\u00012\u0006\u0010\u001e\u001a\u00020\u00052b\b\u0004\u0010 \u001a\\\u0012\u0013\u0012\u0011H\"¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(+\u0012\u0013\u0012\u0011H,¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(.\u0012\u0004\u0012\u0002H\u001f0-H\bø\u0001\u0000J½\u0001\u0010\u001d\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u001f\u0018\u0001\"\u0006\b\u0001\u0010\"\u0018\u0001\"\u0006\b\u0002\u0010&\u0018\u0001\"\u0006\b\u0003\u0010)\u0018\u0001\"\u0006\b\u0004\u0010,\u0018\u0001\"\u0006\b\u0005\u0010/\u0018\u00012\u0006\u0010\u001e\u001a\u00020\u00052w\b\u0004\u0010 \u001aq\u0012\u0013\u0012\u0011H\"¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(+\u0012\u0013\u0012\u0011H,¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(.\u0012\u0013\u0012\u0011H/¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(1\u0012\u0004\u0012\u0002H\u001f00H\bø\u0001\u0000JÜ\u0001\u0010\u001d\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u001f\u0018\u0001\"\u0006\b\u0001\u0010\"\u0018\u0001\"\u0006\b\u0002\u0010&\u0018\u0001\"\u0006\b\u0003\u0010)\u0018\u0001\"\u0006\b\u0004\u0010,\u0018\u0001\"\u0006\b\u0005\u0010/\u0018\u0001\"\u0006\b\u0006\u00102\u0018\u00012\u0006\u0010\u001e\u001a\u00020\u00052\u0001\b\u0004\u0010 \u001a\u0001\u0012\u0013\u0012\u0011H\"¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(+\u0012\u0013\u0012\u0011H,¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(.\u0012\u0013\u0012\u0011H/¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(1\u0012\u0013\u0012\u0011H2¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(4\u0012\u0004\u0012\u0002H\u001f03H\bø\u0001\u0000Jù\u0001\u0010\u001d\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u001f\u0018\u0001\"\u0006\b\u0001\u0010\"\u0018\u0001\"\u0006\b\u0002\u0010&\u0018\u0001\"\u0006\b\u0003\u0010)\u0018\u0001\"\u0006\b\u0004\u0010,\u0018\u0001\"\u0006\b\u0005\u0010/\u0018\u0001\"\u0006\b\u0006\u00102\u0018\u0001\"\u0006\b\u0007\u00105\u0018\u00012\u0006\u0010\u001e\u001a\u00020\u00052¢\u0001\b\u0004\u0010 \u001a\u0001\u0012\u0013\u0012\u0011H\"¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(+\u0012\u0013\u0012\u0011H,¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(.\u0012\u0013\u0012\u0011H/¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(1\u0012\u0013\u0012\u0011H2¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(4\u0012\u0013\u0012\u0011H5¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(7\u0012\u0004\u0012\u0002H\u001f06H\bø\u0001\u0000J\u0002\u0010\u001d\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u001f\u0018\u0001\"\u0006\b\u0001\u0010\"\u0018\u0001\"\u0006\b\u0002\u0010&\u0018\u0001\"\u0006\b\u0003\u0010)\u0018\u0001\"\u0006\b\u0004\u0010,\u0018\u0001\"\u0006\b\u0005\u0010/\u0018\u0001\"\u0006\b\u0006\u00102\u0018\u0001\"\u0006\b\u0007\u00105\u0018\u0001\"\u0006\b\b\u00108\u0018\u00012\u0006\u0010\u001e\u001a\u00020\u00052·\u0001\b\u0004\u0010 \u001a°\u0001\u0012\u0013\u0012\u0011H\"¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(+\u0012\u0013\u0012\u0011H,¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(.\u0012\u0013\u0012\u0011H/¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(1\u0012\u0013\u0012\u0011H2¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(4\u0012\u0013\u0012\u0011H5¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(7\u0012\u0013\u0012\u0011H8¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(:\u0012\u0004\u0012\u0002H\u001f09H\bø\u0001\u0000J\"\u0010;\u001a\u00020<2\u001a\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e0\rJ;\u0010;\u001a\u00020<2.\u0010=\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010?0>\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010?¢\u0006\u0002\u0010@J\u001d\u0010A\u001a\u00020<2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00050>H\u0007¢\u0006\u0004\bC\u0010DJ\u001f\u0010A\u001a\u00020<2\u0012\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050>\"\u00020\u0005¢\u0006\u0002\u0010DJ,\u0010E\u001a\u00020\u0019\"\u0006\b\u0000\u0010\u001f\u0018\u00012\u0006\u0010\u001e\u001a\u00020\u00052\u000e\b\u0004\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001f0\rH\bø\u0001\u0000J+\u0010E\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00052\u0010\b\u0004\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH\bø\u0001\u0000¢\u0006\u0002\bFJI\u0010E\u001a\u00020\u0019\"\u0006\b\u0000\u0010\u001f\u0018\u0001\"\u0006\b\u0001\u0010\"\u0018\u00012\u0006\u0010\u001e\u001a\u00020\u00052#\b\u0004\u0010 \u001a\u001d\u0012\u0013\u0012\u0011H\"¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(%\u0012\u0004\u0012\u0002H\u001f0#H\bø\u0001\u0000Jf\u0010E\u001a\u00020\u0019\"\u0006\b\u0000\u0010\u001f\u0018\u0001\"\u0006\b\u0001\u0010\"\u0018\u0001\"\u0006\b\u0002\u0010&\u0018\u00012\u0006\u0010\u001e\u001a\u00020\u000528\b\u0004\u0010 \u001a2\u0012\u0013\u0012\u0011H\"¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b((\u0012\u0004\u0012\u0002H\u001f0'H\bø\u0001\u0000J\u0001\u0010E\u001a\u00020\u0019\"\u0006\b\u0000\u0010\u001f\u0018\u0001\"\u0006\b\u0001\u0010\"\u0018\u0001\"\u0006\b\u0002\u0010&\u0018\u0001\"\u0006\b\u0003\u0010)\u0018\u00012\u0006\u0010\u001e\u001a\u00020\u00052M\b\u0004\u0010 \u001aG\u0012\u0013\u0012\u0011H\"¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002H\u001f0*H\bø\u0001\u0000J \u0001\u0010E\u001a\u00020\u0019\"\u0006\b\u0000\u0010\u001f\u0018\u0001\"\u0006\b\u0001\u0010\"\u0018\u0001\"\u0006\b\u0002\u0010&\u0018\u0001\"\u0006\b\u0003\u0010)\u0018\u0001\"\u0006\b\u0004\u0010,\u0018\u00012\u0006\u0010\u001e\u001a\u00020\u00052b\b\u0004\u0010 \u001a\\\u0012\u0013\u0012\u0011H\"¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(+\u0012\u0013\u0012\u0011H,¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(.\u0012\u0004\u0012\u0002H\u001f0-H\bø\u0001\u0000J½\u0001\u0010E\u001a\u00020\u0019\"\u0006\b\u0000\u0010\u001f\u0018\u0001\"\u0006\b\u0001\u0010\"\u0018\u0001\"\u0006\b\u0002\u0010&\u0018\u0001\"\u0006\b\u0003\u0010)\u0018\u0001\"\u0006\b\u0004\u0010,\u0018\u0001\"\u0006\b\u0005\u0010/\u0018\u00012\u0006\u0010\u001e\u001a\u00020\u00052w\b\u0004\u0010 \u001aq\u0012\u0013\u0012\u0011H\"¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(+\u0012\u0013\u0012\u0011H,¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(.\u0012\u0013\u0012\u0011H/¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(1\u0012\u0004\u0012\u0002H\u001f00H\bø\u0001\u0000JÜ\u0001\u0010E\u001a\u00020\u0019\"\u0006\b\u0000\u0010\u001f\u0018\u0001\"\u0006\b\u0001\u0010\"\u0018\u0001\"\u0006\b\u0002\u0010&\u0018\u0001\"\u0006\b\u0003\u0010)\u0018\u0001\"\u0006\b\u0004\u0010,\u0018\u0001\"\u0006\b\u0005\u0010/\u0018\u0001\"\u0006\b\u0006\u00102\u0018\u00012\u0006\u0010\u001e\u001a\u00020\u00052\u0001\b\u0004\u0010 \u001a\u0001\u0012\u0013\u0012\u0011H\"¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(+\u0012\u0013\u0012\u0011H,¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(.\u0012\u0013\u0012\u0011H/¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(1\u0012\u0013\u0012\u0011H2¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(4\u0012\u0004\u0012\u0002H\u001f03H\bø\u0001\u0000Jù\u0001\u0010E\u001a\u00020\u0019\"\u0006\b\u0000\u0010\u001f\u0018\u0001\"\u0006\b\u0001\u0010\"\u0018\u0001\"\u0006\b\u0002\u0010&\u0018\u0001\"\u0006\b\u0003\u0010)\u0018\u0001\"\u0006\b\u0004\u0010,\u0018\u0001\"\u0006\b\u0005\u0010/\u0018\u0001\"\u0006\b\u0006\u00102\u0018\u0001\"\u0006\b\u0007\u00105\u0018\u00012\u0006\u0010\u001e\u001a\u00020\u00052¢\u0001\b\u0004\u0010 \u001a\u0001\u0012\u0013\u0012\u0011H\"¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(+\u0012\u0013\u0012\u0011H,¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(.\u0012\u0013\u0012\u0011H/¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(1\u0012\u0013\u0012\u0011H2¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(4\u0012\u0013\u0012\u0011H5¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(7\u0012\u0004\u0012\u0002H\u001f06H\bø\u0001\u0000J\u0002\u0010E\u001a\u00020\u0019\"\u0006\b\u0000\u0010\u001f\u0018\u0001\"\u0006\b\u0001\u0010\"\u0018\u0001\"\u0006\b\u0002\u0010&\u0018\u0001\"\u0006\b\u0003\u0010)\u0018\u0001\"\u0006\b\u0004\u0010,\u0018\u0001\"\u0006\b\u0005\u0010/\u0018\u0001\"\u0006\b\u0006\u00102\u0018\u0001\"\u0006\b\u0007\u00105\u0018\u0001\"\u0006\b\b\u00108\u0018\u00012\u0006\u0010\u001e\u001a\u00020\u00052·\u0001\b\u0004\u0010 \u001a°\u0001\u0012\u0013\u0012\u0011H\"¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(+\u0012\u0013\u0012\u0011H,¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(.\u0012\u0013\u0012\u0011H/¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(1\u0012\u0013\u0012\u0011H2¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(4\u0012\u0013\u0012\u0011H5¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(7\u0012\u0013\u0012\u0011H8¢\u0006\f\b$\u0012\b\b\u001e\u0012\u0004\b\b(:\u0012\u0004\u0012\u0002H\u001f09H\bø\u0001\u0000J\u001c\u0010G\u001a\u00020<2\u000e\b\u0004\u0010 \u001a\b\u0012\u0004\u0012\u00020<0\rH\bø\u0001\u0000J\u001c\u0010H\u001a\u00020<2\u000e\b\u0004\u0010 \u001a\b\u0012\u0004\u0012\u00020<0\rH\bø\u0001\u0000J\u000e\u0010I\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0005J*\u0010I\u001a\u00020\u0014\"\u0004\b\u0000\u0010J2\u0006\u0010\u001e\u001a\u00020\u00052\u000e\b\u0004\u0010 \u001a\b\u0012\u0004\u0012\u0002HJ0\rH\bø\u0001\u0000J\u0006\u0010K\u001a\u00020LJ\u0010\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u0005H\u0002R0\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e0\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\u0004X\u000e¢\u0006\u0002\n\u0000R0\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00140\u00048\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR0\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u00048\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0002\u001a\u0004\b\u001b\u0010\t\"\u0004\b\u001c\u0010\u000b\u0002\u0007\n\u0005\b20\u0001¨\u0006P"}, d2 = {"Lexpo/modules/kotlin/objects/ObjectDefinitionBuilder;", "", "()V", "asyncFunctions", "", "", "Lexpo/modules/kotlin/functions/AsyncFunction;", "getAsyncFunctions$annotations", "getAsyncFunctions", "()Ljava/util/Map;", "setAsyncFunctions", "(Ljava/util/Map;)V", "constantsProvider", "Lkotlin/Function0;", "", "eventsDefinition", "Lexpo/modules/kotlin/events/EventsDefinition;", "functionBuilders", "Lexpo/modules/kotlin/functions/AsyncFunctionBuilder;", "properties", "Lexpo/modules/kotlin/objects/PropertyComponentBuilder;", "getProperties$annotations", "getProperties", "setProperties", "syncFunctions", "Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "getSyncFunctions$annotations", "getSyncFunctions", "setSyncFunctions", "AsyncFunction", "name", "R", "body", "AsyncFunctionWithoutArgs", "P0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "p0", "P1", "Lkotlin/Function2;", "p1", "P2", "Lkotlin/Function3;", "p2", "P3", "Lkotlin/Function4;", "p3", "P4", "Lkotlin/Function5;", "p4", "P5", "Lkotlin/Function6;", "p5", "P6", "Lkotlin/Function7;", "p6", "P7", "Lkotlin/Function8;", "p7", "Constants", "", "constants", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)V", "Events", "events", "EventsWithArray", "([Ljava/lang/String;)V", "Function", "FunctionWithoutArgs", "OnStartObserving", "OnStopObserving", "Property", "T", "buildObject", "Lexpo/modules/kotlin/objects/ObjectDefinitionData;", "containsFunction", "", "functionName", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public class ObjectDefinitionBuilder {
    private Map<String, AsyncFunction> asyncFunctions = new LinkedHashMap();
    private Function0<? extends Map<String, ? extends Object>> constantsProvider = ObjectDefinitionBuilder$constantsProvider$1.INSTANCE;
    private EventsDefinition eventsDefinition;
    private Map<String, AsyncFunctionBuilder> functionBuilders = new LinkedHashMap();
    private Map<String, PropertyComponentBuilder> properties = new LinkedHashMap();
    private Map<String, SyncFunctionComponent> syncFunctions = new LinkedHashMap();

    public static /* synthetic */ void getAsyncFunctions$annotations() {
    }

    public static /* synthetic */ void getProperties$annotations() {
    }

    public static /* synthetic */ void getSyncFunctions$annotations() {
    }

    public final Map<String, SyncFunctionComponent> getSyncFunctions() {
        return this.syncFunctions;
    }

    public final void setSyncFunctions(Map<String, SyncFunctionComponent> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.syncFunctions = map;
    }

    public final Map<String, AsyncFunction> getAsyncFunctions() {
        return this.asyncFunctions;
    }

    public final void setAsyncFunctions(Map<String, AsyncFunction> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.asyncFunctions = map;
    }

    public final Map<String, PropertyComponentBuilder> getProperties() {
        return this.properties;
    }

    public final void setProperties(Map<String, PropertyComponentBuilder> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.properties = map;
    }

    public final ObjectDefinitionData buildObject() {
        if (this.eventsDefinition != null) {
            if (!containsFunction("addListener")) {
                getSyncFunctions().put("addListener", new SyncFunctionComponent("addListener", new AnyType[]{AnyTypeKt.toAnyType(Reflection.typeOf(String.class))}, new ObjectDefinitionBuilder$buildObject$lambda2$$inlined$Function$1()));
            }
            if (!containsFunction("removeListeners")) {
                getSyncFunctions().put("removeListeners", new SyncFunctionComponent("removeListeners", new AnyType[]{AnyTypeKt.toAnyType(Reflection.typeOf(Integer.TYPE))}, new ObjectDefinitionBuilder$buildObject$lambda2$$inlined$Function$2()));
            }
        }
        Function0<? extends Map<String, ? extends Object>> function0 = this.constantsProvider;
        Map<String, SyncFunctionComponent> map = this.syncFunctions;
        Map<String, AsyncFunction> map2 = this.asyncFunctions;
        Map<String, AsyncFunctionBuilder> map3 = this.functionBuilders;
        Map linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map3.size()));
        for (Map.Entry entry : map3.entrySet()) {
            linkedHashMap.put(entry.getKey(), ((AsyncFunctionBuilder) entry.getValue()).build$expo_modules_core_release());
        }
        Map<String, AsyncFunction> plus = MapsKt.plus(map2, (Map<String, AsyncFunction>) linkedHashMap);
        EventsDefinition eventsDefinition2 = this.eventsDefinition;
        Map<String, PropertyComponentBuilder> map4 = this.properties;
        Map linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(map4.size()));
        for (Map.Entry entry2 : map4.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), ((PropertyComponentBuilder) entry2.getValue()).build());
        }
        return new ObjectDefinitionData(function0, map, plus, eventsDefinition2, linkedHashMap2);
    }

    private final boolean containsFunction(String str) {
        return this.syncFunctions.containsKey(str) || this.asyncFunctions.containsKey(str) || this.functionBuilders.containsKey(str);
    }

    public final void Constants(Function0<? extends Map<String, ? extends Object>> function0) {
        Intrinsics.checkNotNullParameter(function0, "constantsProvider");
        this.constantsProvider = function0;
    }

    public final void Constants(Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "constants");
        this.constantsProvider = new ObjectDefinitionBuilder$Constants$1(pairArr);
    }

    public final SyncFunctionComponent FunctionWithoutArgs(String str, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function0, "body");
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, new AnyType[0], new ObjectDefinitionBuilder$Function$1(function0));
        getSyncFunctions().put(str, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R> SyncFunctionComponent Function(String str, Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function0, "body");
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, new AnyType[0], new ObjectDefinitionBuilder$Function$3(function0));
        getSyncFunctions().put(str, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0> SyncFunctionComponent Function(String str, Function1<? super P0, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "body");
        Intrinsics.reifiedOperationMarker(6, "P0");
        AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null)};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, anyTypeArr, new ObjectDefinitionBuilder$Function$5(function1));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        getSyncFunctions().put(str, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1> SyncFunctionComponent Function(String str, Function2<? super P0, ? super P1, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function2, "body");
        Intrinsics.reifiedOperationMarker(6, "P0");
        Intrinsics.reifiedOperationMarker(6, "P1");
        AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, anyTypeArr, new ObjectDefinitionBuilder$Function$7(function2));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        getSyncFunctions().put(str, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2> SyncFunctionComponent Function(String str, Function3<? super P0, ? super P1, ? super P2, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function3, "body");
        Intrinsics.reifiedOperationMarker(6, "P0");
        Intrinsics.reifiedOperationMarker(6, "P1");
        Intrinsics.reifiedOperationMarker(6, "P2");
        AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, anyTypeArr, new ObjectDefinitionBuilder$Function$9(function3));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        getSyncFunctions().put(str, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> SyncFunctionComponent Function(String str, Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends R> function4) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function4, "body");
        Intrinsics.reifiedOperationMarker(6, "P0");
        Intrinsics.reifiedOperationMarker(6, "P1");
        Intrinsics.reifiedOperationMarker(6, "P2");
        Intrinsics.reifiedOperationMarker(6, "P3");
        AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, anyTypeArr, new ObjectDefinitionBuilder$Function$11(function4));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        getSyncFunctions().put(str, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> SyncFunctionComponent Function(String str, Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> function5) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function5, "body");
        Intrinsics.reifiedOperationMarker(6, "P0");
        Intrinsics.reifiedOperationMarker(6, "P1");
        Intrinsics.reifiedOperationMarker(6, "P2");
        Intrinsics.reifiedOperationMarker(6, "P3");
        Intrinsics.reifiedOperationMarker(6, "P4");
        AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, anyTypeArr, new ObjectDefinitionBuilder$Function$13(function5));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        getSyncFunctions().put(str, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> SyncFunctionComponent Function(String str, Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> function6) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function6, "body");
        Intrinsics.reifiedOperationMarker(6, "P0");
        Intrinsics.reifiedOperationMarker(6, "P1");
        Intrinsics.reifiedOperationMarker(6, "P2");
        Intrinsics.reifiedOperationMarker(6, "P3");
        Intrinsics.reifiedOperationMarker(6, "P4");
        Intrinsics.reifiedOperationMarker(6, "P5");
        AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, anyTypeArr, new ObjectDefinitionBuilder$Function$15(function6));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        getSyncFunctions().put(str, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> SyncFunctionComponent Function(String str, Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> function7) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function7, "body");
        Intrinsics.reifiedOperationMarker(6, "P0");
        Intrinsics.reifiedOperationMarker(6, "P1");
        Intrinsics.reifiedOperationMarker(6, "P2");
        Intrinsics.reifiedOperationMarker(6, "P3");
        Intrinsics.reifiedOperationMarker(6, "P4");
        Intrinsics.reifiedOperationMarker(6, "P5");
        Intrinsics.reifiedOperationMarker(6, "P6");
        AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, anyTypeArr, new ObjectDefinitionBuilder$Function$17(function7));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        getSyncFunctions().put(str, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6, P7> SyncFunctionComponent Function(String str, Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> function8) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function8, "body");
        Intrinsics.reifiedOperationMarker(6, "P0");
        Intrinsics.reifiedOperationMarker(6, "P1");
        Intrinsics.reifiedOperationMarker(6, "P2");
        Intrinsics.reifiedOperationMarker(6, "P3");
        Intrinsics.reifiedOperationMarker(6, "P4");
        Intrinsics.reifiedOperationMarker(6, "P5");
        Intrinsics.reifiedOperationMarker(6, "P6");
        Intrinsics.reifiedOperationMarker(6, "P7");
        AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, anyTypeArr, new ObjectDefinitionBuilder$Function$19(function8));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        getSyncFunctions().put(str, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final AsyncFunction AsyncFunctionWithoutArgs(String str, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function0, "body");
        AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent(str, new AnyType[0], new ObjectDefinitionBuilder$AsyncFunction$1(function0));
        getAsyncFunctions().put(str, asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R> AsyncFunction AsyncFunction(String str, Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function0, "body");
        AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent(str, new AnyType[0], new ObjectDefinitionBuilder$AsyncFunction$3(function0));
        getAsyncFunctions().put(str, asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0> AsyncFunction AsyncFunction(String str, Function1<? super P0, ? extends R> function1) {
        AsyncFunction asyncFunction;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "body");
        Intrinsics.reifiedOperationMarker(4, "P0");
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Object.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            Intrinsics.needClassReification();
            asyncFunction = new AsyncFunctionWithPromiseComponent(str, new AnyType[0], new ObjectDefinitionBuilder$AsyncFunction$5(function1));
        } else {
            Intrinsics.reifiedOperationMarker(6, "P0");
            AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            asyncFunction = new AsyncFunctionComponent(str, anyTypeArr, new ObjectDefinitionBuilder$AsyncFunction$6(function1));
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        getAsyncFunctions().put(str, asyncFunction);
        return asyncFunction;
    }

    public final /* synthetic */ <R, P0, P1> AsyncFunction AsyncFunction(String str, Function2<? super P0, ? super P1, ? extends R> function2) {
        AsyncFunction asyncFunction;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function2, "body");
        Intrinsics.reifiedOperationMarker(4, "P1");
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Object.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            Intrinsics.reifiedOperationMarker(6, "P0");
            AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            asyncFunction = new AsyncFunctionWithPromiseComponent(str, anyTypeArr, new ObjectDefinitionBuilder$AsyncFunction$8(function2));
        } else {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            AnyType[] anyTypeArr2 = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            asyncFunction = new AsyncFunctionComponent(str, anyTypeArr2, new ObjectDefinitionBuilder$AsyncFunction$9(function2));
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        getAsyncFunctions().put(str, asyncFunction);
        return asyncFunction;
    }

    public final /* synthetic */ <R, P0, P1, P2> AsyncFunction AsyncFunction(String str, Function3<? super P0, ? super P1, ? super P2, ? extends R> function3) {
        AsyncFunction asyncFunction;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function3, "body");
        Intrinsics.reifiedOperationMarker(4, "P2");
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Object.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            asyncFunction = new AsyncFunctionWithPromiseComponent(str, anyTypeArr, new ObjectDefinitionBuilder$AsyncFunction$11(function3));
        } else {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            Intrinsics.reifiedOperationMarker(6, "P2");
            AnyType[] anyTypeArr2 = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            asyncFunction = new AsyncFunctionComponent(str, anyTypeArr2, new ObjectDefinitionBuilder$AsyncFunction$12(function3));
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        getAsyncFunctions().put(str, asyncFunction);
        return asyncFunction;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> AsyncFunction AsyncFunction(String str, Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends R> function4) {
        AsyncFunction asyncFunction;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function4, "body");
        Intrinsics.reifiedOperationMarker(4, "P3");
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Object.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            Intrinsics.reifiedOperationMarker(6, "P2");
            AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            asyncFunction = new AsyncFunctionWithPromiseComponent(str, anyTypeArr, new ObjectDefinitionBuilder$AsyncFunction$14(function4));
        } else {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            Intrinsics.reifiedOperationMarker(6, "P2");
            Intrinsics.reifiedOperationMarker(6, "P3");
            AnyType[] anyTypeArr2 = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            asyncFunction = new AsyncFunctionComponent(str, anyTypeArr2, new ObjectDefinitionBuilder$AsyncFunction$15(function4));
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        getAsyncFunctions().put(str, asyncFunction);
        return asyncFunction;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> AsyncFunction AsyncFunction(String str, Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> function5) {
        AsyncFunction asyncFunction;
        String str2 = str;
        Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> function52 = function5;
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(function52, "body");
        Intrinsics.reifiedOperationMarker(4, "P4");
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Object.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            Intrinsics.reifiedOperationMarker(6, "P2");
            Intrinsics.reifiedOperationMarker(6, "P3");
            AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            asyncFunction = new AsyncFunctionWithPromiseComponent(str2, anyTypeArr, new ObjectDefinitionBuilder$AsyncFunction$17(function52));
        } else {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            Intrinsics.reifiedOperationMarker(6, "P2");
            Intrinsics.reifiedOperationMarker(6, "P3");
            Intrinsics.reifiedOperationMarker(6, "P4");
            AnyType[] anyTypeArr2 = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            asyncFunction = new AsyncFunctionComponent(str2, anyTypeArr2, new ObjectDefinitionBuilder$AsyncFunction$18(function52));
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        getAsyncFunctions().put(str2, asyncFunction);
        return asyncFunction;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> AsyncFunction AsyncFunction(String str, Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> function6) {
        AsyncFunction asyncFunction;
        String str2 = str;
        Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> function62 = function6;
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(function62, "body");
        Intrinsics.reifiedOperationMarker(4, "P5");
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Object.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            Intrinsics.reifiedOperationMarker(6, "P2");
            Intrinsics.reifiedOperationMarker(6, "P3");
            Intrinsics.reifiedOperationMarker(6, "P4");
            AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            asyncFunction = new AsyncFunctionWithPromiseComponent(str2, anyTypeArr, new ObjectDefinitionBuilder$AsyncFunction$20(function62));
        } else {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            Intrinsics.reifiedOperationMarker(6, "P2");
            Intrinsics.reifiedOperationMarker(6, "P3");
            Intrinsics.reifiedOperationMarker(6, "P4");
            Intrinsics.reifiedOperationMarker(6, "P5");
            AnyType[] anyTypeArr2 = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            asyncFunction = new AsyncFunctionComponent(str2, anyTypeArr2, new ObjectDefinitionBuilder$AsyncFunction$21(function62));
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        getAsyncFunctions().put(str2, asyncFunction);
        return asyncFunction;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> AsyncFunction AsyncFunction(String str, Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> function7) {
        AsyncFunction asyncFunction;
        String str2 = str;
        Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> function72 = function7;
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(function72, "body");
        Intrinsics.reifiedOperationMarker(4, "P6");
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Object.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            Intrinsics.reifiedOperationMarker(6, "P2");
            Intrinsics.reifiedOperationMarker(6, "P3");
            Intrinsics.reifiedOperationMarker(6, "P4");
            Intrinsics.reifiedOperationMarker(6, "P5");
            AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            asyncFunction = new AsyncFunctionWithPromiseComponent(str2, anyTypeArr, new ObjectDefinitionBuilder$AsyncFunction$23(function72));
        } else {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            Intrinsics.reifiedOperationMarker(6, "P2");
            Intrinsics.reifiedOperationMarker(6, "P3");
            Intrinsics.reifiedOperationMarker(6, "P4");
            Intrinsics.reifiedOperationMarker(6, "P5");
            Intrinsics.reifiedOperationMarker(6, "P6");
            AnyType[] anyTypeArr2 = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            asyncFunction = new AsyncFunctionComponent(str2, anyTypeArr2, new ObjectDefinitionBuilder$AsyncFunction$24(function72));
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        getAsyncFunctions().put(str2, asyncFunction);
        return asyncFunction;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6, P7> AsyncFunction AsyncFunction(String str, Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> function8) {
        AsyncFunction asyncFunction;
        String str2 = str;
        Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> function82 = function8;
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(function82, "body");
        Intrinsics.reifiedOperationMarker(4, "P7");
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Object.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            Intrinsics.reifiedOperationMarker(6, "P2");
            Intrinsics.reifiedOperationMarker(6, "P3");
            Intrinsics.reifiedOperationMarker(6, "P4");
            Intrinsics.reifiedOperationMarker(6, "P5");
            Intrinsics.reifiedOperationMarker(6, "P6");
            AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            asyncFunction = new AsyncFunctionWithPromiseComponent(str2, anyTypeArr, new ObjectDefinitionBuilder$AsyncFunction$26(function82));
        } else {
            Intrinsics.reifiedOperationMarker(6, "P0");
            Intrinsics.reifiedOperationMarker(6, "P1");
            Intrinsics.reifiedOperationMarker(6, "P2");
            Intrinsics.reifiedOperationMarker(6, "P3");
            Intrinsics.reifiedOperationMarker(6, "P4");
            Intrinsics.reifiedOperationMarker(6, "P5");
            Intrinsics.reifiedOperationMarker(6, "P6");
            Intrinsics.reifiedOperationMarker(6, "P7");
            AnyType[] anyTypeArr2 = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
            Intrinsics.needClassReification();
            asyncFunction = new AsyncFunctionComponent(str2, anyTypeArr2, new ObjectDefinitionBuilder$AsyncFunction$27(function82));
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        getAsyncFunctions().put(str2, asyncFunction);
        return asyncFunction;
    }

    public final AsyncFunctionBuilder AsyncFunction(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        AsyncFunctionBuilder asyncFunctionBuilder = new AsyncFunctionBuilder(str);
        this.functionBuilders.put(str, asyncFunctionBuilder);
        return asyncFunctionBuilder;
    }

    public final void Events(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "events");
        this.eventsDefinition = new EventsDefinition(strArr);
    }

    public final void EventsWithArray(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "events");
        this.eventsDefinition = new EventsDefinition(strArr);
    }

    public final PropertyComponentBuilder Property(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        PropertyComponentBuilder propertyComponentBuilder = new PropertyComponentBuilder(str);
        this.properties.put(str, propertyComponentBuilder);
        return propertyComponentBuilder;
    }

    public final <T> PropertyComponentBuilder Property(String str, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function0, "body");
        PropertyComponentBuilder propertyComponentBuilder = new PropertyComponentBuilder(str);
        propertyComponentBuilder.setGetter(new SyncFunctionComponent("get", new AnyType[0], new PropertyComponentBuilder$get$1$1(function0)));
        getProperties().put(str, propertyComponentBuilder);
        return propertyComponentBuilder;
    }

    public final void OnStartObserving(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "body");
        AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent("startObserving", new AnyType[0], new ObjectDefinitionBuilder$AsyncFunction$1(function0));
        getAsyncFunctions().put("startObserving", asyncFunctionComponent);
        AsyncFunction asyncFunction = asyncFunctionComponent;
    }

    public final void OnStopObserving(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "body");
        AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent("stopObserving", new AnyType[0], new ObjectDefinitionBuilder$AsyncFunction$1(function0));
        getAsyncFunctions().put("stopObserving", asyncFunctionComponent);
        AsyncFunction asyncFunction = asyncFunctionComponent;
    }
}
