package io.sentry.clientreport;

import io.sentry.DataCategory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

final class AtomicClientReportStorage implements IClientReportStorage {
    private final Map<ClientReportKey, AtomicLong> lostEventCounts;

    public AtomicClientReportStorage() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (DiscardReason discardReason : DiscardReason.values()) {
            for (DataCategory category : DataCategory.values()) {
                concurrentHashMap.put(new ClientReportKey(discardReason.getReason(), category.getCategory()), new AtomicLong(0));
            }
        }
        this.lostEventCounts = Collections.unmodifiableMap(concurrentHashMap);
    }

    public void addCount(ClientReportKey clientReportKey, Long l) {
        AtomicLong atomicLong = this.lostEventCounts.get(clientReportKey);
        if (atomicLong != null) {
            atomicLong.addAndGet(l.longValue());
        }
    }

    public List<DiscardedEvent> resetCountsAndGet() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.lostEventCounts.entrySet()) {
            Long valueOf = Long.valueOf(((AtomicLong) next.getValue()).getAndSet(0));
            if (valueOf.longValue() > 0) {
                arrayList.add(new DiscardedEvent(((ClientReportKey) next.getKey()).getReason(), ((ClientReportKey) next.getKey()).getCategory(), valueOf));
            }
        }
        return arrayList;
    }
}
