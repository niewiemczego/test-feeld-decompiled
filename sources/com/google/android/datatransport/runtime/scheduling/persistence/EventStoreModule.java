package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.Binds;
import com.google.android.datatransport.runtime.dagger.Module;
import com.google.android.datatransport.runtime.dagger.Provides;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import javax.inject.Named;
import javax.inject.Singleton;

@Module
public abstract class EventStoreModule {
    @Provides
    @Named("SQLITE_DB_NAME")
    static String dbName() {
        return "com.google.android.datatransport.events";
    }

    /* access modifiers changed from: package-private */
    @Binds
    public abstract ClientHealthMetricsStore clientHealthMetricsStore(SQLiteEventStore sQLiteEventStore);

    /* access modifiers changed from: package-private */
    @Binds
    public abstract EventStore eventStore(SQLiteEventStore sQLiteEventStore);

    /* access modifiers changed from: package-private */
    @Binds
    public abstract SynchronizationGuard synchronizationGuard(SQLiteEventStore sQLiteEventStore);

    @Provides
    static EventStoreConfig storeConfig() {
        return EventStoreConfig.DEFAULT;
    }

    @Provides
    @Named("SCHEMA_VERSION")
    static int schemaVersion() {
        return SchemaManager.SCHEMA_VERSION;
    }

    @Singleton
    @Provides
    @Named("PACKAGE_NAME")
    static String packageName(Context context) {
        return context.getPackageName();
    }
}
