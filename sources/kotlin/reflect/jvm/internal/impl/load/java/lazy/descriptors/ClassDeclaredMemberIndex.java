package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: DeclaredMemberIndex.kt */
public class ClassDeclaredMemberIndex implements DeclaredMemberIndex {
    private final Map<Name, JavaRecordComponent> components;
    private final Map<Name, JavaField> fields;
    private final JavaClass jClass;
    /* access modifiers changed from: private */
    public final Function1<JavaMember, Boolean> memberFilter;
    private final Function1<JavaMethod, Boolean> methodFilter;
    private final Map<Name, List<JavaMethod>> methods;

    public ClassDeclaredMemberIndex(JavaClass javaClass, Function1<? super JavaMember, Boolean> function1) {
        Intrinsics.checkNotNullParameter(javaClass, "jClass");
        Intrinsics.checkNotNullParameter(function1, "memberFilter");
        this.jClass = javaClass;
        this.memberFilter = function1;
        Function1<JavaMethod, Boolean> classDeclaredMemberIndex$methodFilter$1 = new ClassDeclaredMemberIndex$methodFilter$1(this);
        this.methodFilter = classDeclaredMemberIndex$methodFilter$1;
        Sequence<T> filter = SequencesKt.filter(CollectionsKt.asSequence(javaClass.getMethods()), classDeclaredMemberIndex$methodFilter$1);
        Map<Name, List<JavaMethod>> linkedHashMap = new LinkedHashMap<>();
        for (T next : filter) {
            Name name = ((JavaMethod) next).getName();
            List<JavaMethod> list = linkedHashMap.get(name);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(name, list);
            }
            list.add(next);
        }
        this.methods = linkedHashMap;
        Sequence<T> filter2 = SequencesKt.filter(CollectionsKt.asSequence(this.jClass.getFields()), this.memberFilter);
        Map<Name, JavaField> linkedHashMap2 = new LinkedHashMap<>();
        for (T next2 : filter2) {
            linkedHashMap2.put(((JavaField) next2).getName(), next2);
        }
        this.fields = linkedHashMap2;
        Function1<JavaMember, Boolean> function12 = this.memberFilter;
        Collection arrayList = new ArrayList();
        for (Object next3 : this.jClass.getRecordComponents()) {
            if (function12.invoke(next3).booleanValue()) {
                arrayList.add(next3);
            }
        }
        Iterable iterable = (List) arrayList;
        Map<Name, JavaRecordComponent> linkedHashMap3 = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next4 : iterable) {
            linkedHashMap3.put(((JavaRecordComponent) next4).getName(), next4);
        }
        this.components = linkedHashMap3;
    }

    public Collection<JavaMethod> findMethodsByName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List list = this.methods.get(name);
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return list;
    }

    public Set<Name> getMethodNames() {
        Sequence<T> filter = SequencesKt.filter(CollectionsKt.asSequence(this.jClass.getMethods()), this.methodFilter);
        Collection linkedHashSet = new LinkedHashSet();
        for (T name : filter) {
            linkedHashSet.add(name.getName());
        }
        return (Set) linkedHashSet;
    }

    public JavaField findFieldByName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.fields.get(name);
    }

    public Set<Name> getFieldNames() {
        Sequence<T> filter = SequencesKt.filter(CollectionsKt.asSequence(this.jClass.getFields()), this.memberFilter);
        Collection linkedHashSet = new LinkedHashSet();
        for (T name : filter) {
            linkedHashSet.add(name.getName());
        }
        return (Set) linkedHashSet;
    }

    public Set<Name> getRecordComponentNames() {
        return this.components.keySet();
    }

    public JavaRecordComponent findRecordComponentByName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.components.get(name);
    }
}
