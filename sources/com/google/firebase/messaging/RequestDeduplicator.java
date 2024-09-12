package com.google.firebase.messaging;

import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

class RequestDeduplicator {
    private final Executor executor;
    private final Map<String, Task<String>> getTokenRequests = new ArrayMap();

    interface GetTokenRequest {
        Task<String> start();
    }

    RequestDeduplicator(Executor executor2) {
        this.executor = executor2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002d, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.google.android.gms.tasks.Task<java.lang.String> getOrStartGetTokenRequest(java.lang.String r4, com.google.firebase.messaging.RequestDeduplicator.GetTokenRequest r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.Map<java.lang.String, com.google.android.gms.tasks.Task<java.lang.String>> r0 = r3.getTokenRequests     // Catch:{ all -> 0x0064 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0064 }
            com.google.android.gms.tasks.Task r0 = (com.google.android.gms.tasks.Task) r0     // Catch:{ all -> 0x0064 }
            r1 = 3
            if (r0 == 0) goto L_0x002e
            java.lang.String r5 = "FirebaseMessaging"
            boolean r5 = android.util.Log.isLoggable(r5, r1)     // Catch:{ all -> 0x0064 }
            if (r5 == 0) goto L_0x002c
            java.lang.String r5 = "FirebaseMessaging"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
            r1.<init>()     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "Joining ongoing request for: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0064 }
            java.lang.StringBuilder r4 = r1.append(r4)     // Catch:{ all -> 0x0064 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0064 }
            android.util.Log.d(r5, r4)     // Catch:{ all -> 0x0064 }
        L_0x002c:
            monitor-exit(r3)
            return r0
        L_0x002e:
            java.lang.String r0 = "FirebaseMessaging"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x0064 }
            if (r0 == 0) goto L_0x004e
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
            r1.<init>()     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "Making new request for: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0064 }
            java.lang.StringBuilder r1 = r1.append(r4)     // Catch:{ all -> 0x0064 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0064 }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0064 }
        L_0x004e:
            com.google.android.gms.tasks.Task r5 = r5.start()     // Catch:{ all -> 0x0064 }
            java.util.concurrent.Executor r0 = r3.executor     // Catch:{ all -> 0x0064 }
            com.google.firebase.messaging.RequestDeduplicator$$ExternalSyntheticLambda0 r1 = new com.google.firebase.messaging.RequestDeduplicator$$ExternalSyntheticLambda0     // Catch:{ all -> 0x0064 }
            r1.<init>(r3, r4)     // Catch:{ all -> 0x0064 }
            com.google.android.gms.tasks.Task r5 = r5.continueWithTask(r0, r1)     // Catch:{ all -> 0x0064 }
            java.util.Map<java.lang.String, com.google.android.gms.tasks.Task<java.lang.String>> r0 = r3.getTokenRequests     // Catch:{ all -> 0x0064 }
            r0.put(r4, r5)     // Catch:{ all -> 0x0064 }
            monitor-exit(r3)
            return r5
        L_0x0064:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.RequestDeduplicator.getOrStartGetTokenRequest(java.lang.String, com.google.firebase.messaging.RequestDeduplicator$GetTokenRequest):com.google.android.gms.tasks.Task");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$getOrStartGetTokenRequest$0$com-google-firebase-messaging-RequestDeduplicator  reason: not valid java name */
    public /* synthetic */ Task m601lambda$getOrStartGetTokenRequest$0$comgooglefirebasemessagingRequestDeduplicator(String str, Task task) throws Exception {
        synchronized (this) {
            this.getTokenRequests.remove(str);
        }
        return task;
    }
}
