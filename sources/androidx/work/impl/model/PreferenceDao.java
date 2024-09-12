package androidx.work.impl.model;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH'¨\u0006\r"}, d2 = {"Landroidx/work/impl/model/PreferenceDao;", "", "getLongValue", "", "key", "", "(Ljava/lang/String;)Ljava/lang/Long;", "getObservableLongValue", "Landroidx/lifecycle/LiveData;", "insertPreference", "", "preference", "Landroidx/work/impl/model/Preference;", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PreferenceDao.kt */
public interface PreferenceDao {
    Long getLongValue(String str);

    LiveData<Long> getObservableLongValue(String str);

    void insertPreference(Preference preference);
}
