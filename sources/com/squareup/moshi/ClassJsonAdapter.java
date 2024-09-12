package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.Nullable;

final class ClassJsonAdapter<T> extends JsonAdapter<T> {
    public static final JsonAdapter.Factory FACTORY = new JsonAdapter.Factory() {
        @Nullable
        public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            if (!(type instanceof Class) && !(type instanceof ParameterizedType)) {
                return null;
            }
            Class<?> rawType = Types.getRawType(type);
            if (rawType.isInterface() || rawType.isEnum() || !set.isEmpty()) {
                return null;
            }
            if (Util.isPlatformType(rawType)) {
                throwIfIsCollectionClass(type, List.class);
                throwIfIsCollectionClass(type, Set.class);
                throwIfIsCollectionClass(type, Map.class);
                throwIfIsCollectionClass(type, Collection.class);
                String str = "Platform " + rawType;
                if (type instanceof ParameterizedType) {
                    str = str + " in " + type;
                }
                throw new IllegalArgumentException(str + " requires explicit JsonAdapter to be registered");
            } else if (rawType.isAnonymousClass()) {
                throw new IllegalArgumentException("Cannot serialize anonymous class " + rawType.getName());
            } else if (rawType.isLocalClass()) {
                throw new IllegalArgumentException("Cannot serialize local class " + rawType.getName());
            } else if (rawType.getEnclosingClass() != null && !Modifier.isStatic(rawType.getModifiers())) {
                throw new IllegalArgumentException("Cannot serialize non-static nested class " + rawType.getName());
            } else if (Modifier.isAbstract(rawType.getModifiers())) {
                throw new IllegalArgumentException("Cannot serialize abstract class " + rawType.getName());
            } else if (!Util.isKotlin(rawType)) {
                ClassFactory<?> classFactory = ClassFactory.get(rawType);
                TreeMap treeMap = new TreeMap();
                while (type != Object.class) {
                    createFieldBindings(moshi, type, treeMap);
                    type = Types.getGenericSuperclass(type);
                }
                return new ClassJsonAdapter(classFactory, treeMap).nullSafe();
            } else {
                throw new IllegalArgumentException("Cannot serialize Kotlin type " + rawType.getName() + ". Reflective serialization of Kotlin classes without using kotlin-reflect has undefined and unexpected behavior. Please use KotlinJsonAdapterFactory from the moshi-kotlin artifact or use code gen from the moshi-kotlin-codegen artifact.");
            }
        }

        private void throwIfIsCollectionClass(Type type, Class<?> cls) {
            Class<?> rawType = Types.getRawType(type);
            if (cls.isAssignableFrom(rawType)) {
                throw new IllegalArgumentException("No JsonAdapter for " + type + ", you should probably use " + cls.getSimpleName() + " instead of " + rawType.getSimpleName() + " (Moshi only supports the collection interfaces by default) or else register a custom JsonAdapter.");
            }
        }

        private void createFieldBindings(Moshi moshi, Type type, Map<String, FieldBinding<?>> map) {
            Json json;
            Class<?> rawType = Types.getRawType(type);
            boolean isPlatformType = Util.isPlatformType(rawType);
            for (Field field : rawType.getDeclaredFields()) {
                if (includeField(isPlatformType, field.getModifiers()) && ((json = (Json) field.getAnnotation(Json.class)) == null || !json.ignore())) {
                    Type resolve = Util.resolve(type, rawType, field.getGenericType());
                    Set<? extends Annotation> jsonAnnotations = Util.jsonAnnotations((AnnotatedElement) field);
                    String name = field.getName();
                    JsonAdapter<T> adapter = moshi.adapter(resolve, jsonAnnotations, name);
                    field.setAccessible(true);
                    String jsonName = Util.jsonName(name, json);
                    FieldBinding fieldBinding = new FieldBinding(jsonName, field, adapter);
                    FieldBinding put = map.put(jsonName, fieldBinding);
                    if (put != null) {
                        throw new IllegalArgumentException("Conflicting fields:\n    " + put.field + "\n    " + fieldBinding.field);
                    }
                }
            }
        }

        private boolean includeField(boolean z, int i) {
            if (Modifier.isStatic(i) || Modifier.isTransient(i)) {
                return false;
            }
            if (Modifier.isPublic(i) || Modifier.isProtected(i) || !z) {
                return true;
            }
            return false;
        }
    };
    private final ClassFactory<T> classFactory;
    private final FieldBinding<?>[] fieldsArray;
    private final JsonReader.Options options;

    ClassJsonAdapter(ClassFactory<T> classFactory2, Map<String, FieldBinding<?>> map) {
        this.classFactory = classFactory2;
        this.fieldsArray = (FieldBinding[]) map.values().toArray(new FieldBinding[map.size()]);
        this.options = JsonReader.Options.of((String[]) map.keySet().toArray(new String[map.size()]));
    }

    public T fromJson(JsonReader jsonReader) throws IOException {
        try {
            T newInstance = this.classFactory.newInstance();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    int selectName = jsonReader.selectName(this.options);
                    if (selectName == -1) {
                        jsonReader.skipName();
                        jsonReader.skipValue();
                    } else {
                        this.fieldsArray[selectName].read(jsonReader, newInstance);
                    }
                }
                jsonReader.endObject();
                return newInstance;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            throw Util.rethrowCause(e2);
        } catch (IllegalAccessException unused2) {
            throw new AssertionError();
        }
    }

    public void toJson(JsonWriter jsonWriter, T t) throws IOException {
        try {
            jsonWriter.beginObject();
            for (FieldBinding<?> fieldBinding : this.fieldsArray) {
                jsonWriter.name(fieldBinding.name);
                fieldBinding.write(jsonWriter, t);
            }
            jsonWriter.endObject();
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        }
    }

    public String toString() {
        return "JsonAdapter(" + this.classFactory + ")";
    }

    static class FieldBinding<T> {
        final JsonAdapter<T> adapter;
        final Field field;
        final String name;

        FieldBinding(String str, Field field2, JsonAdapter<T> jsonAdapter) {
            this.name = str;
            this.field = field2;
            this.adapter = jsonAdapter;
        }

        /* access modifiers changed from: package-private */
        public void read(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
            this.field.set(obj, this.adapter.fromJson(jsonReader));
        }

        /* access modifiers changed from: package-private */
        public void write(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IOException {
            this.adapter.toJson(jsonWriter, this.field.get(obj));
        }
    }
}
