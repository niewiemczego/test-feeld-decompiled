package zendesk.conversationkit.android.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.rest.model.MessageFieldDto;
import zendesk.conversationkit.android.internal.rest.model.MessageFieldOptionDto;
import zendesk.conversationkit.android.internal.rest.model.SendFieldResponseDto;
import zendesk.conversationkit.android.internal.rest.model.SendFieldSelectDto;
import zendesk.conversationkit.android.model.Field;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0001H\u0000¨\u0006\u0005"}, d2 = {"toField", "Lzendesk/conversationkit/android/model/Field;", "Lzendesk/conversationkit/android/internal/rest/model/MessageFieldDto;", "toSendFieldResponseDto", "Lzendesk/conversationkit/android/internal/rest/model/SendFieldResponseDto;", "zendesk.conversationkit_conversationkit-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Field.kt */
public final class FieldKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Field.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FieldType.values().length];
            iArr[FieldType.TEXT.ordinal()] = 1;
            iArr[FieldType.EMAIL.ordinal()] = 2;
            iArr[FieldType.SELECT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Field toField(MessageFieldDto messageFieldDto) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(messageFieldDto, "<this>");
        FieldType findByValue = FieldType.Companion.findByValue(messageFieldDto.getType());
        int i = findByValue == null ? -1 : WhenMappings.$EnumSwitchMapping$0[findByValue.ordinal()];
        int i2 = 1;
        if (i == 1) {
            String id = messageFieldDto.getId();
            String name = messageFieldDto.getName();
            String label = messageFieldDto.getLabel();
            String placeholder = messageFieldDto.getPlaceholder();
            if (placeholder == null) {
                str = "";
            } else {
                str = placeholder;
            }
            Integer minSize = messageFieldDto.getMinSize();
            if (minSize != null) {
                i2 = minSize.intValue();
            }
            int i3 = i2;
            Integer maxSize = messageFieldDto.getMaxSize();
            int intValue = maxSize != null ? maxSize.intValue() : 128;
            String text = messageFieldDto.getText();
            if (text == null) {
                text = "";
            }
            return new Field.Text(id, name, label, str, i3, intValue, text);
        } else if (i == 2) {
            String id2 = messageFieldDto.getId();
            String name2 = messageFieldDto.getName();
            String label2 = messageFieldDto.getLabel();
            String placeholder2 = messageFieldDto.getPlaceholder();
            if (placeholder2 == null) {
                str2 = "";
            } else {
                str2 = placeholder2;
            }
            String email = messageFieldDto.getEmail();
            if (email == null) {
                email = "";
            }
            return new Field.Email(id2, name2, label2, str2, email);
        } else if (i != 3) {
            return null;
        } else {
            String id3 = messageFieldDto.getId();
            String name3 = messageFieldDto.getName();
            String label3 = messageFieldDto.getLabel();
            String placeholder3 = messageFieldDto.getPlaceholder();
            if (placeholder3 == null) {
                str3 = "";
            } else {
                str3 = placeholder3;
            }
            List<MessageFieldOptionDto> options = messageFieldDto.getOptions();
            if (options == null) {
                options = CollectionsKt.emptyList();
            }
            Iterable<MessageFieldOptionDto> iterable = options;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (MessageFieldOptionDto messageFieldOptionDto : iterable) {
                arrayList.add(new FieldOption(messageFieldOptionDto.getName(), messageFieldOptionDto.getLabel()));
            }
            List list = (List) arrayList;
            Integer selectSize = messageFieldDto.getSelectSize();
            if (selectSize != null) {
                i2 = selectSize.intValue();
            }
            int i4 = i2;
            List<MessageFieldOptionDto> select = messageFieldDto.getSelect();
            if (select == null) {
                select = CollectionsKt.emptyList();
            }
            Iterable<MessageFieldOptionDto> iterable2 = select;
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
            for (MessageFieldOptionDto messageFieldOptionDto2 : iterable2) {
                arrayList2.add(new FieldOption(messageFieldOptionDto2.getName(), messageFieldOptionDto2.getLabel()));
            }
            return new Field.Select(id3, name3, label3, str3, list, i4, (List) arrayList2);
        }
    }

    public static final SendFieldResponseDto toSendFieldResponseDto(Field field) {
        Intrinsics.checkNotNullParameter(field, "<this>");
        if (field instanceof Field.Text) {
            return new SendFieldResponseDto.Text(field.getId(), field.getName(), field.getLabel(), ((Field.Text) field).getText());
        }
        if (field instanceof Field.Email) {
            return new SendFieldResponseDto.Email(field.getId(), field.getName(), field.getLabel(), ((Field.Email) field).getEmail());
        }
        if (field instanceof Field.Select) {
            String id = field.getId();
            String name = field.getName();
            String label = field.getLabel();
            Iterable<FieldOption> select = ((Field.Select) field).getSelect();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(select, 10));
            for (FieldOption fieldOption : select) {
                arrayList.add(new SendFieldSelectDto(fieldOption.getName(), fieldOption.getLabel()));
            }
            return new SendFieldResponseDto.Select(id, name, label, (List) arrayList);
        }
        throw new NoWhenBranchMatchedException();
    }
}
