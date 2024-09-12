package io.sentry;

import io.sentry.profilemeasurements.ProfileMeasurement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class Hint {
    private static final Map<String, Class<?>> PRIMITIVE_MAPPINGS;
    private final List<Attachment> attachments = new ArrayList();
    private final Map<String, Object> internalStorage = new HashMap();
    private Attachment screenshot = null;
    private Attachment threadDump = null;
    private Attachment viewHierarchy = null;

    static {
        HashMap hashMap = new HashMap();
        PRIMITIVE_MAPPINGS = hashMap;
        hashMap.put("boolean", Boolean.class);
        hashMap.put("char", Character.class);
        hashMap.put(ProfileMeasurement.UNIT_BYTES, Byte.class);
        hashMap.put("short", Short.class);
        hashMap.put("int", Integer.class);
        hashMap.put("long", Long.class);
        hashMap.put("float", Float.class);
        hashMap.put("double", Double.class);
    }

    public static Hint withAttachment(Attachment attachment) {
        Hint hint = new Hint();
        hint.addAttachment(attachment);
        return hint;
    }

    public static Hint withAttachments(List<Attachment> list) {
        Hint hint = new Hint();
        hint.addAttachments(list);
        return hint;
    }

    public synchronized void set(String str, Object obj) {
        this.internalStorage.put(str, obj);
    }

    public synchronized Object get(String str) {
        return this.internalStorage.get(str);
    }

    public synchronized <T> T getAs(String str, Class<T> cls) {
        T t = this.internalStorage.get(str);
        if (cls.isInstance(t)) {
            return t;
        }
        if (isCastablePrimitive(t, cls)) {
            return t;
        }
        return null;
    }

    public synchronized void remove(String str) {
        this.internalStorage.remove(str);
    }

    public void addAttachment(Attachment attachment) {
        if (attachment != null) {
            this.attachments.add(attachment);
        }
    }

    public void addAttachments(List<Attachment> list) {
        if (list != null) {
            this.attachments.addAll(list);
        }
    }

    public List<Attachment> getAttachments() {
        return new ArrayList(this.attachments);
    }

    public void replaceAttachments(List<Attachment> list) {
        clearAttachments();
        addAttachments(list);
    }

    public void clearAttachments() {
        this.attachments.clear();
    }

    public synchronized void clear() {
        Iterator<Map.Entry<String, Object>> it = this.internalStorage.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (next.getKey() == null || !((String) next.getKey()).startsWith("sentry:")) {
                it.remove();
            }
        }
    }

    public void setScreenshot(Attachment attachment) {
        this.screenshot = attachment;
    }

    public Attachment getScreenshot() {
        return this.screenshot;
    }

    public void setViewHierarchy(Attachment attachment) {
        this.viewHierarchy = attachment;
    }

    public Attachment getViewHierarchy() {
        return this.viewHierarchy;
    }

    public void setThreadDump(Attachment attachment) {
        this.threadDump = attachment;
    }

    public Attachment getThreadDump() {
        return this.threadDump;
    }

    private boolean isCastablePrimitive(Object obj, Class<?> cls) {
        Class cls2 = PRIMITIVE_MAPPINGS.get(cls.getCanonicalName());
        return obj != null && cls.isPrimitive() && cls2 != null && cls2.isInstance(obj);
    }
}
