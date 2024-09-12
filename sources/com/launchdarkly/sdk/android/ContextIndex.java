package com.launchdarkly.sdk.android;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.launchdarkly.sdk.json.SerializationException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

final class ContextIndex {
    final List<IndexEntry> data;

    static class IndexEntry {
        final String contextId;
        final long timestamp;

        IndexEntry(String str, long j) {
            this.contextId = str;
            this.timestamp = j;
        }
    }

    ContextIndex() {
        this(new ArrayList());
    }

    ContextIndex(List<IndexEntry> list) {
        this.data = list == null ? new ArrayList<>() : list;
    }

    public ContextIndex updateTimestamp(String str, long j) {
        ArrayList arrayList = new ArrayList();
        for (IndexEntry next : this.data) {
            if (!next.contextId.equals(str)) {
                arrayList.add(next);
            }
        }
        arrayList.add(new IndexEntry(str, j));
        return new ContextIndex(arrayList);
    }

    public ContextIndex prune(int i, List<String> list) {
        if (this.data.size() <= i || i < 0) {
            return this;
        }
        List<IndexEntry> list2 = this.data;
        IndexEntry[] indexEntryArr = (IndexEntry[]) list2.toArray(new IndexEntry[list2.size()]);
        Arrays.sort(indexEntryArr, new Comparator<IndexEntry>() {
            public int compare(IndexEntry indexEntry, IndexEntry indexEntry2) {
                return Long.compare(indexEntry.timestamp, indexEntry2.timestamp);
            }
        });
        ArrayList arrayList = new ArrayList(Arrays.asList(indexEntryArr));
        int size = arrayList.size() - i;
        for (int i2 = 0; i2 < size; i2++) {
            list.add(((IndexEntry) arrayList.get(0)).contextId);
            arrayList.remove(0);
        }
        return new ContextIndex(arrayList);
    }

    public static ContextIndex fromJson(String str) throws SerializationException {
        ArrayList arrayList = new ArrayList();
        JsonReader jsonReader = new JsonReader(new StringReader(str));
        try {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                jsonReader.beginArray();
                if (jsonReader.hasNext()) {
                    String nextString = jsonReader.nextString();
                    if (jsonReader.hasNext()) {
                        arrayList.add(new IndexEntry(nextString, jsonReader.nextLong()));
                    }
                }
                while (jsonReader.hasNext()) {
                }
                jsonReader.endArray();
            }
            jsonReader.endArray();
            return new ContextIndex(arrayList);
        } catch (Exception e) {
            throw new SerializationException((Throwable) e);
        }
    }

    public String toJson() {
        StringWriter stringWriter = new StringWriter();
        try {
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            jsonWriter.beginArray();
            for (IndexEntry next : this.data) {
                jsonWriter.beginArray();
                jsonWriter.value(next.contextId);
                jsonWriter.value(next.timestamp);
                jsonWriter.endArray();
            }
            jsonWriter.endArray();
            jsonWriter.flush();
            return stringWriter.toString();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
