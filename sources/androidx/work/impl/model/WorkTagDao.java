package androidx.work.impl.model;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\t\u001a\u00020\u0005H'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH'J\u001e\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0016¨\u0006\u0010"}, d2 = {"Landroidx/work/impl/model/WorkTagDao;", "", "deleteByWorkSpecId", "", "id", "", "getTagsForWorkSpecId", "", "getWorkSpecIdsWithTag", "tag", "insert", "workTag", "Landroidx/work/impl/model/WorkTag;", "insertTags", "tags", "", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: WorkTagDao.kt */
public interface WorkTagDao {
    void deleteByWorkSpecId(String str);

    List<String> getTagsForWorkSpecId(String str);

    List<String> getWorkSpecIdsWithTag(String str);

    void insert(WorkTag workTag);

    void insertTags(String str, Set<String> set);

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: WorkTagDao.kt */
    public static final class DefaultImpls {
        public static void insertTags(WorkTagDao workTagDao, String str, Set<String> set) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(set, "tags");
            for (String workTag : set) {
                workTagDao.insert(new WorkTag(workTag, str));
            }
        }
    }
}
