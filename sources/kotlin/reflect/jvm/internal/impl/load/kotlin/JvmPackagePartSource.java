package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

/* compiled from: JvmPackagePartSource.kt */
public final class JvmPackagePartSource implements DeserializedContainerSource {
    private final DeserializedContainerAbiStability abiStability;
    private final JvmClassName className;
    private final JvmClassName facadeClassName;
    private final IncompatibleVersionErrorData<JvmMetadataVersion> incompatibility;
    private final boolean isPreReleaseInvisible;
    private final KotlinJvmBinaryClass knownJvmBinaryClass;
    private final String moduleName;

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0034, code lost:
        r2 = r5.getString(r2.intValue());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JvmPackagePartSource(kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName r2, kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName r3, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package r4, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r5, kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion> r6, boolean r7, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability r8, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass r9) {
        /*
            r1 = this;
            java.lang.String r0 = "className"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "packageProto"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "nameResolver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "abiStability"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r1.<init>()
            r1.className = r2
            r1.facadeClassName = r3
            r1.incompatibility = r6
            r1.isPreReleaseInvisible = r7
            r1.abiStability = r8
            r1.knownJvmBinaryClass = r9
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtendableMessage r4 = (kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage) r4
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package, java.lang.Integer> r2 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.packageModuleName
            java.lang.String r3 = "packageModuleName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.Object r2 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt.getExtensionOrNull(r4, r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 == 0) goto L_0x0040
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.String r2 = r5.getString(r2)
            if (r2 != 0) goto L_0x0042
        L_0x0040:
            java.lang.String r2 = "main"
        L_0x0042:
            r1.moduleName = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource.<init>(kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName, kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver, kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData, boolean, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass):void");
    }

    public JvmClassName getClassName() {
        return this.className;
    }

    public JvmClassName getFacadeClassName() {
        return this.facadeClassName;
    }

    public final KotlinJvmBinaryClass getKnownJvmBinaryClass() {
        return this.knownJvmBinaryClass;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JvmPackagePartSource(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass r11, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package r12, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r13, kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion> r14, boolean r15, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability r16) {
        /*
            r10 = this;
            java.lang.String r0 = "kotlinClass"
            r9 = r11
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "packageProto"
            r4 = r12
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "nameResolver"
            r5 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "abiStability"
            r8 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            kotlin.reflect.jvm.internal.impl.name.ClassId r0 = r11.getClassId()
            kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName r2 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName.byClassId(r0)
            java.lang.String r0 = "byClassId(kotlinClass.classId)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader r0 = r11.getClassHeader()
            java.lang.String r0 = r0.getMultifileClassName()
            r1 = 0
            if (r0 == 0) goto L_0x0043
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x003c
            r3 = 1
            goto L_0x003d
        L_0x003c:
            r3 = 0
        L_0x003d:
            if (r3 == 0) goto L_0x0043
            kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName r1 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName.byInternalName(r0)
        L_0x0043:
            r3 = r1
            r1 = r10
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r16
            r9 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource.<init>(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver, kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData, boolean, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability):void");
    }

    public String getPresentableString() {
        return "Class '" + getClassId().asSingleFqName().asString() + '\'';
    }

    public final Name getSimpleName() {
        String internalName = getClassName().getInternalName();
        Intrinsics.checkNotNullExpressionValue(internalName, "className.internalName");
        Name identifier = Name.identifier(StringsKt.substringAfterLast$default(internalName, (char) IOUtils.DIR_SEPARATOR_UNIX, (String) null, 2, (Object) null));
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(className.int….substringAfterLast('/'))");
        return identifier;
    }

    public final ClassId getClassId() {
        return new ClassId(getClassName().getPackageFqName(), getSimpleName());
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + getClassName();
    }

    public SourceFile getContainingFile() {
        SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
        Intrinsics.checkNotNullExpressionValue(sourceFile, "NO_SOURCE_FILE");
        return sourceFile;
    }
}
