package kotlin.io.path;

import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlin.io.path.PathTreeWalk$bfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1}, l = {184, 190}, m = "invokeSuspend", n = {"$this$iterator", "queue", "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", "queue", "entriesReader"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
/* compiled from: PathTreeWalk.kt */
final class PathTreeWalk$bfsIterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ PathTreeWalk this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PathTreeWalk$bfsIterator$1(PathTreeWalk pathTreeWalk, Continuation<? super PathTreeWalk$bfsIterator$1> continuation) {
        super(2, continuation);
        this.this$0 = pathTreeWalk;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PathTreeWalk$bfsIterator$1 pathTreeWalk$bfsIterator$1 = new PathTreeWalk$bfsIterator$1(this.this$0, continuation);
        pathTreeWalk$bfsIterator$1.L$0 = obj;
        return pathTreeWalk$bfsIterator$1;
    }

    public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
        return ((PathTreeWalk$bfsIterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x013a A[SYNTHETIC] */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0046
            if (r1 == r4) goto L_0x0028
            if (r1 != r2) goto L_0x0020
            java.lang.Object r1 = r14.L$2
            kotlin.io.path.DirectoryEntriesReader r1 = (kotlin.io.path.DirectoryEntriesReader) r1
            java.lang.Object r5 = r14.L$1
            kotlin.collections.ArrayDeque r5 = (kotlin.collections.ArrayDeque) r5
            java.lang.Object r6 = r14.L$0
            kotlin.sequences.SequenceScope r6 = (kotlin.sequences.SequenceScope) r6
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = r14
            goto L_0x0080
        L_0x0020:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0028:
            java.lang.Object r1 = r14.L$5
            java.nio.file.Path r1 = (java.nio.file.Path) r1
            java.lang.Object r5 = r14.L$4
            kotlin.io.path.PathTreeWalk r5 = (kotlin.io.path.PathTreeWalk) r5
            java.lang.Object r6 = r14.L$3
            kotlin.io.path.PathNode r6 = (kotlin.io.path.PathNode) r6
            java.lang.Object r7 = r14.L$2
            kotlin.io.path.DirectoryEntriesReader r7 = (kotlin.io.path.DirectoryEntriesReader) r7
            java.lang.Object r8 = r14.L$1
            kotlin.collections.ArrayDeque r8 = (kotlin.collections.ArrayDeque) r8
            java.lang.Object r9 = r14.L$0
            kotlin.sequences.SequenceScope r9 = (kotlin.sequences.SequenceScope) r9
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = r14
            goto L_0x00da
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.Object r15 = r14.L$0
            kotlin.sequences.SequenceScope r15 = (kotlin.sequences.SequenceScope) r15
            kotlin.collections.ArrayDeque r1 = new kotlin.collections.ArrayDeque
            r1.<init>()
            kotlin.io.path.DirectoryEntriesReader r5 = new kotlin.io.path.DirectoryEntriesReader
            kotlin.io.path.PathTreeWalk r6 = r14.this$0
            boolean r6 = r6.getFollowLinks()
            r5.<init>(r6)
            kotlin.io.path.PathNode r6 = new kotlin.io.path.PathNode
            kotlin.io.path.PathTreeWalk r7 = r14.this$0
            java.nio.file.Path r7 = r7.start
            kotlin.io.path.PathTreeWalk r8 = r14.this$0
            java.nio.file.Path r8 = r8.start
            kotlin.io.path.PathTreeWalk r9 = r14.this$0
            java.nio.file.LinkOption[] r9 = r9.getLinkOptions()
            java.lang.Object r8 = kotlin.io.path.PathTreeWalkKt.access$keyOf(r8, r9)
            r6.<init>(r7, r8, r3)
            r1.addLast(r6)
            r6 = r15
            r15 = r14
            r12 = r5
            r5 = r1
            r1 = r12
        L_0x0080:
            r7 = r5
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            r7 = r7 ^ r4
            if (r7 == 0) goto L_0x013a
            java.lang.Object r7 = r5.removeFirst()
            kotlin.io.path.PathNode r7 = (kotlin.io.path.PathNode) r7
            kotlin.io.path.PathTreeWalk r8 = r15.this$0
            java.nio.file.Path r9 = r7.getPath()
            java.nio.file.LinkOption[] r10 = r8.getLinkOptions()
            int r11 = r10.length
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r11)
            java.nio.file.LinkOption[] r10 = (java.nio.file.LinkOption[]) r10
            int r11 = r10.length
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r11)
            java.nio.file.LinkOption[] r10 = (java.nio.file.LinkOption[]) r10
            boolean r10 = java.nio.file.Files.isDirectory(r9, r10)
            if (r10 == 0) goto L_0x010f
            boolean r10 = kotlin.io.path.PathTreeWalkKt.access$createsCycle(r7)
            if (r10 != 0) goto L_0x0105
            boolean r10 = r8.getIncludeDirectories()
            if (r10 == 0) goto L_0x00e2
            r10 = r15
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r15.L$0 = r6
            r15.L$1 = r5
            r15.L$2 = r1
            r15.L$3 = r7
            r15.L$4 = r8
            r15.L$5 = r9
            r15.label = r4
            java.lang.Object r10 = r6.yield(r9, r10)
            if (r10 != r0) goto L_0x00d2
            return r0
        L_0x00d2:
            r12 = r7
            r7 = r1
            r1 = r9
            r9 = r6
            r6 = r12
            r13 = r8
            r8 = r5
            r5 = r13
        L_0x00da:
            r12 = r9
            r9 = r1
            r1 = r7
            r7 = r6
            r6 = r12
            r13 = r8
            r8 = r5
            r5 = r13
        L_0x00e2:
            java.nio.file.LinkOption[] r8 = r8.getLinkOptions()
            int r10 = r8.length
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r10)
            java.nio.file.LinkOption[] r8 = (java.nio.file.LinkOption[]) r8
            int r10 = r8.length
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r10)
            java.nio.file.LinkOption[] r8 = (java.nio.file.LinkOption[]) r8
            boolean r8 = java.nio.file.Files.isDirectory(r9, r8)
            if (r8 == 0) goto L_0x0080
            java.util.List r7 = r1.readEntries(r7)
            java.util.Collection r7 = (java.util.Collection) r7
            r5.addAll(r7)
            goto L_0x0080
        L_0x0105:
            java.nio.file.FileSystemLoopException r15 = new java.nio.file.FileSystemLoopException
            java.lang.String r0 = r9.toString()
            r15.<init>(r0)
            throw r15
        L_0x010f:
            java.nio.file.LinkOption[] r7 = new java.nio.file.LinkOption[r4]
            r8 = 0
            java.nio.file.LinkOption r10 = java.nio.file.LinkOption.NOFOLLOW_LINKS
            r7[r8] = r10
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r4)
            java.nio.file.LinkOption[] r7 = (java.nio.file.LinkOption[]) r7
            boolean r7 = java.nio.file.Files.exists(r9, r7)
            if (r7 == 0) goto L_0x0080
            r7 = r15
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r15.L$0 = r6
            r15.L$1 = r5
            r15.L$2 = r1
            r15.L$3 = r3
            r15.L$4 = r3
            r15.L$5 = r3
            r15.label = r2
            java.lang.Object r7 = r6.yield(r9, r7)
            if (r7 != r0) goto L_0x0080
            return r0
        L_0x013a:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathTreeWalk$bfsIterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
