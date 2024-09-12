package com.facebook.common.callercontext;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.internal.security.CertificateUtil;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class ContextChain implements Parcelable {
    public static final Parcelable.Creator<ContextChain> CREATOR = new Parcelable.Creator<ContextChain>() {
        public ContextChain createFromParcel(Parcel parcel) {
            return new ContextChain(parcel);
        }

        public ContextChain[] newArray(int i) {
            return new ContextChain[i];
        }
    };
    private static final char PARENT_SEPARATOR = '/';
    public static final String TAG_INFRA = "i";
    public static final String TAG_PRODUCT = "p";
    public static final String TAG_PRODUCT_AND_INFRA = "pi";
    private static boolean sUseDeepEquals = false;
    @Nullable
    private Map<String, Object> mExtraData;
    private final int mLevel;
    private final String mName;
    @Nullable
    private final ContextChain mParent;
    @Nullable
    private String mSerializedString;
    private final String mTag;

    public int describeContents() {
        return 0;
    }

    public static void setUseDeepEquals(boolean z) {
        sUseDeepEquals = z;
    }

    public ContextChain(String str, String str2, @Nullable Map<String, String> map, @Nullable ContextChain contextChain) {
        this.mTag = str;
        this.mName = str2;
        this.mLevel = contextChain != null ? contextChain.mLevel + 1 : 0;
        this.mParent = contextChain;
        Map<String, Object> extraData = contextChain != null ? contextChain.getExtraData() : null;
        if (extraData != null) {
            this.mExtraData = new HashMap(extraData);
        }
        if (map != null) {
            if (this.mExtraData == null) {
                this.mExtraData = new HashMap();
            }
            this.mExtraData.putAll(map);
        }
    }

    public ContextChain(String str, String str2, @Nullable ContextChain contextChain) {
        this(str, str2, (Map<String, String>) null, contextChain);
    }

    protected ContextChain(Parcel parcel) {
        this.mTag = parcel.readString();
        this.mName = parcel.readString();
        this.mLevel = parcel.readInt();
        this.mParent = (ContextChain) parcel.readParcelable(ContextChain.class.getClassLoader());
    }

    public String getName() {
        return this.mName;
    }

    public String getTag() {
        return this.mTag;
    }

    @Nullable
    public Map<String, Object> getExtraData() {
        return this.mExtraData;
    }

    @Nullable
    public ContextChain getParent() {
        return this.mParent;
    }

    public ContextChain getRootContextChain() {
        ContextChain contextChain = this.mParent;
        return contextChain == null ? this : contextChain.getRootContextChain();
    }

    @Nullable
    public String getStringExtra(String str) {
        Object obj;
        Map<String, Object> map = this.mExtraData;
        if (map == null || (obj = map.get(str)) == null) {
            return null;
        }
        return String.valueOf(obj);
    }

    public void putObjectExtra(String str, Object obj) {
        if (this.mExtraData == null) {
            this.mExtraData = new HashMap();
        }
        this.mExtraData.put(str, obj);
    }

    public String toString() {
        if (this.mSerializedString == null) {
            this.mSerializedString = this.mTag + CertificateUtil.DELIMITER + this.mName;
            if (this.mParent != null) {
                this.mSerializedString = this.mParent.toString() + '/' + this.mSerializedString;
            }
        }
        return this.mSerializedString;
    }

    public String[] toStringArray() {
        int i = this.mLevel;
        String[] strArr = new String[(i + 1)];
        ContextChain contextChain = this;
        while (i >= 0) {
            Preconditions.checkNotNull(contextChain, "ContextChain level mismatch, this should not happen.");
            strArr[i] = contextChain.mTag + CertificateUtil.DELIMITER + contextChain.mName;
            contextChain = contextChain.mParent;
            i--;
        }
        return strArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (!sUseDeepEquals) {
            return super.equals(obj);
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ContextChain contextChain = (ContextChain) obj;
        if (Objects.equal(this.mTag, contextChain.mTag) && Objects.equal(this.mName, contextChain.mName) && this.mLevel == contextChain.mLevel) {
            ContextChain contextChain2 = this.mParent;
            ContextChain contextChain3 = contextChain.mParent;
            if (contextChain2 == contextChain3) {
                return true;
            }
            if (contextChain2 != null && contextChain2.equals(contextChain3)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (!sUseDeepEquals) {
            return super.hashCode();
        }
        int hashCode = super.hashCode() * 31;
        String str = this.mTag;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.mName;
        int hashCode3 = (((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.mLevel) * 31;
        ContextChain contextChain = this.mParent;
        if (contextChain != null) {
            i = contextChain.hashCode();
        }
        return hashCode3 + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mTag);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mLevel);
        parcel.writeParcelable(this.mParent, i);
    }
}
