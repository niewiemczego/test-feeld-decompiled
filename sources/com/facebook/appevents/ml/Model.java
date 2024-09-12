package com.facebook.appevents.ml;

import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001b\b\u0002\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J+\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00172\u0006\u0010\u0018\u001a\u00020\u0004¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/facebook/appevents/ml/Model;", "", "weights", "", "", "Lcom/facebook/appevents/ml/MTensor;", "(Ljava/util/Map;)V", "convs0Bias", "convs0Weight", "convs1Bias", "convs1Weight", "convs2Bias", "convs2Weight", "embedding", "fc1Bias", "fc1Weight", "fc2Bias", "fc2Weight", "finalWeights", "", "predictOnMTML", "dense", "texts", "", "task", "(Lcom/facebook/appevents/ml/MTensor;[Ljava/lang/String;Ljava/lang/String;)Lcom/facebook/appevents/ml/MTensor;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Model.kt */
public final class Model {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int SEQ_LEN = 128;
    private static final Map<String, String> mapping = MapsKt.hashMapOf(TuplesKt.to("embedding.weight", "embed.weight"), TuplesKt.to("dense1.weight", "fc1.weight"), TuplesKt.to("dense2.weight", "fc2.weight"), TuplesKt.to("dense3.weight", "fc3.weight"), TuplesKt.to("dense1.bias", "fc1.bias"), TuplesKt.to("dense2.bias", "fc2.bias"), TuplesKt.to("dense3.bias", "fc3.bias"));
    private final MTensor convs0Bias;
    private final MTensor convs0Weight;
    private final MTensor convs1Bias;
    private final MTensor convs1Weight;
    private final MTensor convs2Bias;
    private final MTensor convs2Weight;
    private final MTensor embedding;
    private final MTensor fc1Bias;
    private final MTensor fc1Weight;
    private final MTensor fc2Bias;
    private final MTensor fc2Weight;
    private final Map<String, MTensor> finalWeights;

    public /* synthetic */ Model(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(map);
    }

    private Model(Map<String, MTensor> map) {
        MTensor mTensor = map.get("embed.weight");
        if (mTensor != null) {
            this.embedding = mTensor;
            Operator operator = Operator.INSTANCE;
            MTensor mTensor2 = map.get("convs.0.weight");
            if (mTensor2 != null) {
                this.convs0Weight = Operator.transpose3D(mTensor2);
                Operator operator2 = Operator.INSTANCE;
                MTensor mTensor3 = map.get("convs.1.weight");
                if (mTensor3 != null) {
                    this.convs1Weight = Operator.transpose3D(mTensor3);
                    Operator operator3 = Operator.INSTANCE;
                    MTensor mTensor4 = map.get("convs.2.weight");
                    if (mTensor4 != null) {
                        this.convs2Weight = Operator.transpose3D(mTensor4);
                        MTensor mTensor5 = map.get("convs.0.bias");
                        if (mTensor5 != null) {
                            this.convs0Bias = mTensor5;
                            MTensor mTensor6 = map.get("convs.1.bias");
                            if (mTensor6 != null) {
                                this.convs1Bias = mTensor6;
                                MTensor mTensor7 = map.get("convs.2.bias");
                                if (mTensor7 != null) {
                                    this.convs2Bias = mTensor7;
                                    Operator operator4 = Operator.INSTANCE;
                                    MTensor mTensor8 = map.get("fc1.weight");
                                    if (mTensor8 != null) {
                                        this.fc1Weight = Operator.transpose2D(mTensor8);
                                        Operator operator5 = Operator.INSTANCE;
                                        MTensor mTensor9 = map.get("fc2.weight");
                                        if (mTensor9 != null) {
                                            this.fc2Weight = Operator.transpose2D(mTensor9);
                                            MTensor mTensor10 = map.get("fc1.bias");
                                            if (mTensor10 != null) {
                                                this.fc1Bias = mTensor10;
                                                MTensor mTensor11 = map.get("fc2.bias");
                                                if (mTensor11 != null) {
                                                    this.fc2Bias = mTensor11;
                                                    this.finalWeights = new HashMap();
                                                    for (String str : SetsKt.setOf(ModelManager.Task.MTML_INTEGRITY_DETECT.toKey(), ModelManager.Task.MTML_APP_EVENT_PREDICTION.toKey())) {
                                                        String stringPlus = Intrinsics.stringPlus(str, ".weight");
                                                        String stringPlus2 = Intrinsics.stringPlus(str, ".bias");
                                                        MTensor mTensor12 = map.get(stringPlus);
                                                        MTensor mTensor13 = map.get(stringPlus2);
                                                        if (mTensor12 != null) {
                                                            Operator operator6 = Operator.INSTANCE;
                                                            this.finalWeights.put(stringPlus, Operator.transpose2D(mTensor12));
                                                        }
                                                        if (mTensor13 != null) {
                                                            this.finalWeights.put(stringPlus2, mTensor13);
                                                        }
                                                    }
                                                    return;
                                                }
                                                throw new IllegalStateException("Required value was null.".toString());
                                            }
                                            throw new IllegalStateException("Required value was null.".toString());
                                        }
                                        throw new IllegalStateException("Required value was null.".toString());
                                    }
                                    throw new IllegalStateException("Required value was null.".toString());
                                }
                                throw new IllegalStateException("Required value was null.".toString());
                            }
                            throw new IllegalStateException("Required value was null.".toString());
                        }
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    throw new IllegalStateException("Required value was null.".toString());
                }
                throw new IllegalStateException("Required value was null.".toString());
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public static final /* synthetic */ Map access$getMapping$cp() {
        Class<Model> cls = Model.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return mapping;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public final MTensor predictOnMTML(MTensor mTensor, String[] strArr, String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(mTensor, "dense");
            Intrinsics.checkNotNullParameter(strArr, "texts");
            Intrinsics.checkNotNullParameter(str, "task");
            Operator operator = Operator.INSTANCE;
            MTensor embedding2 = Operator.embedding(strArr, 128, this.embedding);
            Operator operator2 = Operator.INSTANCE;
            MTensor conv1D = Operator.conv1D(embedding2, this.convs0Weight);
            Operator operator3 = Operator.INSTANCE;
            Operator.addmv(conv1D, this.convs0Bias);
            Operator operator4 = Operator.INSTANCE;
            Operator.relu(conv1D);
            Operator operator5 = Operator.INSTANCE;
            MTensor conv1D2 = Operator.conv1D(conv1D, this.convs1Weight);
            Operator operator6 = Operator.INSTANCE;
            Operator.addmv(conv1D2, this.convs1Bias);
            Operator operator7 = Operator.INSTANCE;
            Operator.relu(conv1D2);
            Operator operator8 = Operator.INSTANCE;
            MTensor maxPool1D = Operator.maxPool1D(conv1D2, 2);
            Operator operator9 = Operator.INSTANCE;
            MTensor conv1D3 = Operator.conv1D(maxPool1D, this.convs2Weight);
            Operator operator10 = Operator.INSTANCE;
            Operator.addmv(conv1D3, this.convs2Bias);
            Operator operator11 = Operator.INSTANCE;
            Operator.relu(conv1D3);
            Operator operator12 = Operator.INSTANCE;
            MTensor maxPool1D2 = Operator.maxPool1D(conv1D, conv1D.getShape(1));
            Operator operator13 = Operator.INSTANCE;
            MTensor maxPool1D3 = Operator.maxPool1D(maxPool1D, maxPool1D.getShape(1));
            Operator operator14 = Operator.INSTANCE;
            MTensor maxPool1D4 = Operator.maxPool1D(conv1D3, conv1D3.getShape(1));
            Operator operator15 = Operator.INSTANCE;
            Operator.flatten(maxPool1D2, 1);
            Operator operator16 = Operator.INSTANCE;
            Operator.flatten(maxPool1D3, 1);
            Operator operator17 = Operator.INSTANCE;
            Operator.flatten(maxPool1D4, 1);
            Operator operator18 = Operator.INSTANCE;
            MTensor concatenate = Operator.concatenate(new MTensor[]{maxPool1D2, maxPool1D3, maxPool1D4, mTensor});
            Operator operator19 = Operator.INSTANCE;
            MTensor dense = Operator.dense(concatenate, this.fc1Weight, this.fc1Bias);
            Operator operator20 = Operator.INSTANCE;
            Operator.relu(dense);
            Operator operator21 = Operator.INSTANCE;
            MTensor dense2 = Operator.dense(dense, this.fc2Weight, this.fc2Bias);
            Operator operator22 = Operator.INSTANCE;
            Operator.relu(dense2);
            MTensor mTensor2 = this.finalWeights.get(Intrinsics.stringPlus(str, ".weight"));
            MTensor mTensor3 = this.finalWeights.get(Intrinsics.stringPlus(str, ".bias"));
            if (mTensor2 != null) {
                if (mTensor3 != null) {
                    Operator operator23 = Operator.INSTANCE;
                    MTensor dense3 = Operator.dense(dense2, mTensor2, mTensor3);
                    Operator operator24 = Operator.INSTANCE;
                    Operator.softmax(dense3);
                    return dense3;
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/appevents/ml/Model$Companion;", "", "()V", "SEQ_LEN", "", "mapping", "", "", "build", "Lcom/facebook/appevents/ml/Model;", "file", "Ljava/io/File;", "parse", "Lcom/facebook/appevents/ml/MTensor;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: Model.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Model build(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            Map<String, MTensor> parse = parse(file);
            if (parse == null) {
                return null;
            }
            try {
                return new Model(parse, (DefaultConstructorMarker) null);
            } catch (Exception unused) {
                return null;
            }
        }

        private final Map<String, MTensor> parse(File file) {
            Utils utils = Utils.INSTANCE;
            Map<String, MTensor> parseModelWeights = Utils.parseModelWeights(file);
            if (parseModelWeights == null) {
                return null;
            }
            Map<String, MTensor> hashMap = new HashMap<>();
            Map access$getMapping$cp = Model.access$getMapping$cp();
            for (Map.Entry next : parseModelWeights.entrySet()) {
                String str = (String) next.getKey();
                if (access$getMapping$cp.containsKey(next.getKey()) && (str = (String) access$getMapping$cp.get(next.getKey())) == null) {
                    return null;
                }
                hashMap.put(str, next.getValue());
            }
            return hashMap;
        }
    }
}
