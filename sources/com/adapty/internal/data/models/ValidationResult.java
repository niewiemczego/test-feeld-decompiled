package com.adapty.internal.data.models;

import com.google.android.gms.common.Scopes;
import com.google.gson.annotations.SerializedName;
import io.sentry.Session;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001:\u0001\rB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0002\u0010\bR&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/adapty/internal/data/models/ValidationResult;", "", "profile", "Lcom/adapty/internal/data/models/ProfileDto;", "errors", "Ljava/util/ArrayList;", "Lcom/adapty/internal/data/models/ValidationResult$SideError;", "Lkotlin/collections/ArrayList;", "(Lcom/adapty/internal/data/models/ProfileDto;Ljava/util/ArrayList;)V", "getErrors", "()Ljava/util/ArrayList;", "getProfile", "()Lcom/adapty/internal/data/models/ProfileDto;", "SideError", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ValidationResult.kt */
public final class ValidationResult {
    @SerializedName("errors")
    private final ArrayList<SideError> errors;
    @SerializedName("profile")
    private final ProfileDto profile;

    public ValidationResult(ProfileDto profileDto, ArrayList<SideError> arrayList) {
        Intrinsics.checkNotNullParameter(profileDto, Scopes.PROFILE);
        Intrinsics.checkNotNullParameter(arrayList, Session.JsonKeys.ERRORS);
        this.profile = profileDto;
        this.errors = arrayList;
    }

    public final ProfileDto getProfile() {
        return this.profile;
    }

    public final ArrayList<SideError> getErrors() {
        return this.errors;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/adapty/internal/data/models/ValidationResult$SideError;", "", "purchaseToken", "", "message", "(Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getPurchaseToken", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ValidationResult.kt */
    public static final class SideError {
        @SerializedName("message")
        private final String message;
        @SerializedName("purchase_token")
        private final String purchaseToken;

        public SideError(String str, String str2) {
            this.purchaseToken = str;
            this.message = str2;
        }

        public final String getPurchaseToken() {
            return this.purchaseToken;
        }

        public final String getMessage() {
            return this.message;
        }
    }
}
