package app.notifee.core.model;

import android.os.Bundle;
import java.util.Objects;

public class NotificationModel {
    public Bundle a;

    public NotificationModel(Bundle bundle) {
        this.a = bundle;
    }

    public NotificationAndroidModel a() {
        return NotificationAndroidModel.fromBundle(this.a.getBundle("android"));
    }

    public Integer b() {
        return Integer.valueOf(c().hashCode());
    }

    public String c() {
        return (String) Objects.requireNonNull(this.a.getString("id"));
    }

    public Bundle toBundle() {
        return (Bundle) this.a.clone();
    }
}
