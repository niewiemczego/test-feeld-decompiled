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
@DebugMetadata(c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3}, l = {184, 190, 199, 205}, m = "invokeSuspend", n = {"$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "path$iv", "$this$iterator", "stack", "entriesReader", "$this$iterator", "stack", "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", "stack", "entriesReader"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
/* compiled from: PathTreeWalk.kt */
final class PathTreeWalk$dfsIterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ PathTreeWalk this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PathTreeWalk$dfsIterator$1(PathTreeWalk pathTreeWalk, Continuation<? super PathTreeWalk$dfsIterator$1> continuation) {
        super(2, continuation);
        this.this$0 = pathTreeWalk;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PathTreeWalk$dfsIterator$1 pathTreeWalk$dfsIterator$1 = new PathTreeWalk$dfsIterator$1(this.this$0, continuation);
        pathTreeWalk$dfsIterator$1.L$0 = obj;
        return pathTreeWalk$dfsIterator$1;
    }

    public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
        return ((PathTreeWalk$dfsIterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: kotlin.sequences.SequenceScope} */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0224 A[SYNTHETIC] */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 0
            r8 = 1
            if (r2 == 0) goto L_0x006f
            if (r2 == r8) goto L_0x0052
            if (r2 == r6) goto L_0x0018
            if (r2 == r5) goto L_0x0031
            if (r2 != r4) goto L_0x0029
        L_0x0018:
            java.lang.Object r2 = r0.L$2
            kotlin.io.path.DirectoryEntriesReader r2 = (kotlin.io.path.DirectoryEntriesReader) r2
            java.lang.Object r6 = r0.L$1
            kotlin.collections.ArrayDeque r6 = (kotlin.collections.ArrayDeque) r6
            java.lang.Object r9 = r0.L$0
            kotlin.sequences.SequenceScope r9 = (kotlin.sequences.SequenceScope) r9
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x0145
        L_0x0029:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0031:
            java.lang.Object r2 = r0.L$5
            java.nio.file.Path r2 = (java.nio.file.Path) r2
            java.lang.Object r6 = r0.L$4
            kotlin.io.path.PathTreeWalk r6 = (kotlin.io.path.PathTreeWalk) r6
            java.lang.Object r9 = r0.L$3
            kotlin.io.path.PathNode r9 = (kotlin.io.path.PathNode) r9
            java.lang.Object r10 = r0.L$2
            kotlin.io.path.DirectoryEntriesReader r10 = (kotlin.io.path.DirectoryEntriesReader) r10
            java.lang.Object r11 = r0.L$1
            kotlin.collections.ArrayDeque r11 = (kotlin.collections.ArrayDeque) r11
            java.lang.Object r12 = r0.L$0
            kotlin.sequences.SequenceScope r12 = (kotlin.sequences.SequenceScope) r12
            kotlin.ResultKt.throwOnFailure(r19)
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r0
            goto L_0x01b7
        L_0x0052:
            java.lang.Object r2 = r0.L$5
            java.nio.file.Path r2 = (java.nio.file.Path) r2
            java.lang.Object r6 = r0.L$4
            kotlin.io.path.PathTreeWalk r6 = (kotlin.io.path.PathTreeWalk) r6
            java.lang.Object r9 = r0.L$3
            kotlin.io.path.PathNode r9 = (kotlin.io.path.PathNode) r9
            java.lang.Object r10 = r0.L$2
            kotlin.io.path.DirectoryEntriesReader r10 = (kotlin.io.path.DirectoryEntriesReader) r10
            java.lang.Object r11 = r0.L$1
            kotlin.collections.ArrayDeque r11 = (kotlin.collections.ArrayDeque) r11
            java.lang.Object r12 = r0.L$0
            kotlin.sequences.SequenceScope r12 = (kotlin.sequences.SequenceScope) r12
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x00e9
        L_0x006f:
            kotlin.ResultKt.throwOnFailure(r19)
            java.lang.Object r2 = r0.L$0
            r9 = r2
            kotlin.sequences.SequenceScope r9 = (kotlin.sequences.SequenceScope) r9
            kotlin.collections.ArrayDeque r2 = new kotlin.collections.ArrayDeque
            r2.<init>()
            kotlin.io.path.DirectoryEntriesReader r10 = new kotlin.io.path.DirectoryEntriesReader
            kotlin.io.path.PathTreeWalk r11 = r0.this$0
            boolean r11 = r11.getFollowLinks()
            r10.<init>(r11)
            kotlin.io.path.PathNode r11 = new kotlin.io.path.PathNode
            kotlin.io.path.PathTreeWalk r12 = r0.this$0
            java.nio.file.Path r12 = r12.start
            kotlin.io.path.PathTreeWalk r13 = r0.this$0
            java.nio.file.Path r13 = r13.start
            kotlin.io.path.PathTreeWalk r14 = r0.this$0
            java.nio.file.LinkOption[] r14 = r14.getLinkOptions()
            java.lang.Object r13 = kotlin.io.path.PathTreeWalkKt.keyOf(r13, r14)
            r11.<init>(r12, r13, r7)
            kotlin.io.path.PathTreeWalk r12 = r0.this$0
            java.nio.file.Path r13 = r11.getPath()
            java.nio.file.LinkOption[] r14 = r12.getLinkOptions()
            int r15 = r14.length
            java.lang.Object[] r14 = java.util.Arrays.copyOf(r14, r15)
            java.nio.file.LinkOption[] r14 = (java.nio.file.LinkOption[]) r14
            int r15 = r14.length
            java.lang.Object[] r14 = java.util.Arrays.copyOf(r14, r15)
            java.nio.file.LinkOption[] r14 = (java.nio.file.LinkOption[]) r14
            boolean r14 = java.nio.file.Files.isDirectory(r13, r14)
            if (r14 == 0) goto L_0x011f
            boolean r6 = kotlin.io.path.PathTreeWalkKt.createsCycle(r11)
            if (r6 != 0) goto L_0x0115
            boolean r6 = r12.getIncludeDirectories()
            if (r6 == 0) goto L_0x00ee
            r6 = r0
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r0.L$0 = r9
            r0.L$1 = r2
            r0.L$2 = r10
            r0.L$3 = r11
            r0.L$4 = r12
            r0.L$5 = r13
            r0.label = r8
            java.lang.Object r6 = r9.yield(r13, r6)
            if (r6 != r1) goto L_0x00e4
            return r1
        L_0x00e4:
            r6 = r12
            r12 = r9
            r9 = r11
            r11 = r2
            r2 = r13
        L_0x00e9:
            r13 = r2
            r2 = r11
            r11 = r9
            r9 = r12
            r12 = r6
        L_0x00ee:
            java.nio.file.LinkOption[] r6 = r12.getLinkOptions()
            int r12 = r6.length
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r12)
            java.nio.file.LinkOption[] r6 = (java.nio.file.LinkOption[]) r6
            int r12 = r6.length
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r12)
            java.nio.file.LinkOption[] r6 = (java.nio.file.LinkOption[]) r6
            boolean r6 = java.nio.file.Files.isDirectory(r13, r6)
            if (r6 == 0) goto L_0x0143
            java.util.List r6 = r10.readEntries(r11)
            java.util.Iterator r6 = r6.iterator()
            r11.setContentIterator(r6)
            r2.addLast(r11)
            goto L_0x0143
        L_0x0115:
            java.nio.file.FileSystemLoopException r1 = new java.nio.file.FileSystemLoopException
            java.lang.String r2 = r13.toString()
            r1.<init>(r2)
            throw r1
        L_0x011f:
            java.nio.file.LinkOption[] r11 = new java.nio.file.LinkOption[r8]
            java.nio.file.LinkOption r12 = java.nio.file.LinkOption.NOFOLLOW_LINKS
            r11[r3] = r12
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r11, r8)
            java.nio.file.LinkOption[] r11 = (java.nio.file.LinkOption[]) r11
            boolean r11 = java.nio.file.Files.exists(r13, r11)
            if (r11 == 0) goto L_0x0143
            r11 = r0
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r0.L$0 = r9
            r0.L$1 = r2
            r0.L$2 = r10
            r0.label = r6
            java.lang.Object r6 = r9.yield(r13, r11)
            if (r6 != r1) goto L_0x0143
            return r1
        L_0x0143:
            r6 = r2
            r2 = r10
        L_0x0145:
            r10 = r0
        L_0x0146:
            r11 = r6
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r11 = r11.isEmpty()
            r11 = r11 ^ r8
            if (r11 == 0) goto L_0x0224
            java.lang.Object r11 = r6.last()
            kotlin.io.path.PathNode r11 = (kotlin.io.path.PathNode) r11
            java.util.Iterator r11 = r11.getContentIterator()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x021f
            java.lang.Object r11 = r11.next()
            kotlin.io.path.PathNode r11 = (kotlin.io.path.PathNode) r11
            kotlin.io.path.PathTreeWalk r12 = r10.this$0
            java.nio.file.Path r13 = r11.getPath()
            java.nio.file.LinkOption[] r14 = r12.getLinkOptions()
            int r15 = r14.length
            java.lang.Object[] r14 = java.util.Arrays.copyOf(r14, r15)
            java.nio.file.LinkOption[] r14 = (java.nio.file.LinkOption[]) r14
            int r15 = r14.length
            java.lang.Object[] r14 = java.util.Arrays.copyOf(r14, r15)
            java.nio.file.LinkOption[] r14 = (java.nio.file.LinkOption[]) r14
            boolean r14 = java.nio.file.Files.isDirectory(r13, r14)
            if (r14 == 0) goto L_0x01f5
            boolean r14 = kotlin.io.path.PathTreeWalkKt.createsCycle(r11)
            if (r14 != 0) goto L_0x01eb
            boolean r14 = r12.getIncludeDirectories()
            if (r14 == 0) goto L_0x01c3
            r14 = r10
            kotlin.coroutines.Continuation r14 = (kotlin.coroutines.Continuation) r14
            r10.L$0 = r9
            r10.L$1 = r6
            r10.L$2 = r2
            r10.L$3 = r11
            r10.L$4 = r12
            r10.L$5 = r13
            r10.label = r5
            java.lang.Object r14 = r9.yield(r13, r14)
            if (r14 != r1) goto L_0x01ab
            return r1
        L_0x01ab:
            r16 = r11
            r11 = r2
            r2 = r13
            r13 = r9
            r9 = r16
            r17 = r12
            r12 = r6
            r6 = r17
        L_0x01b7:
            r16 = r13
            r13 = r2
            r2 = r11
            r11 = r9
            r9 = r16
            r17 = r12
            r12 = r6
            r6 = r17
        L_0x01c3:
            java.nio.file.LinkOption[] r12 = r12.getLinkOptions()
            int r14 = r12.length
            java.lang.Object[] r12 = java.util.Arrays.copyOf(r12, r14)
            java.nio.file.LinkOption[] r12 = (java.nio.file.LinkOption[]) r12
            int r14 = r12.length
            java.lang.Object[] r12 = java.util.Arrays.copyOf(r12, r14)
            java.nio.file.LinkOption[] r12 = (java.nio.file.LinkOption[]) r12
            boolean r12 = java.nio.file.Files.isDirectory(r13, r12)
            if (r12 == 0) goto L_0x0146
            java.util.List r12 = r2.readEntries(r11)
            java.util.Iterator r12 = r12.iterator()
            r11.setContentIterator(r12)
            r6.addLast(r11)
            goto L_0x0146
        L_0x01eb:
            java.nio.file.FileSystemLoopException r1 = new java.nio.file.FileSystemLoopException
            java.lang.String r2 = r13.toString()
            r1.<init>(r2)
            throw r1
        L_0x01f5:
            java.nio.file.LinkOption[] r11 = new java.nio.file.LinkOption[r8]
            java.nio.file.LinkOption r12 = java.nio.file.LinkOption.NOFOLLOW_LINKS
            r11[r3] = r12
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r11, r8)
            java.nio.file.LinkOption[] r11 = (java.nio.file.LinkOption[]) r11
            boolean r11 = java.nio.file.Files.exists(r13, r11)
            if (r11 == 0) goto L_0x0146
            r11 = r10
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r10.L$0 = r9
            r10.L$1 = r6
            r10.L$2 = r2
            r10.L$3 = r7
            r10.L$4 = r7
            r10.L$5 = r7
            r10.label = r4
            java.lang.Object r11 = r9.yield(r13, r11)
            if (r11 != r1) goto L_0x0146
            return r1
        L_0x021f:
            r6.removeLast()
            goto L_0x0146
        L_0x0224:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathTreeWalk$dfsIterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
