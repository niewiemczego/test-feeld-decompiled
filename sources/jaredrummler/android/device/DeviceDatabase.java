package jaredrummler.android.device;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import io.sentry.protocol.Device;
import jaredrummler.android.device.DeviceName;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DeviceDatabase extends SQLiteOpenHelper {
    private final File a;
    private final Context b;

    public DeviceDatabase(Context context) {
        super(context, "android-devices.db", (SQLiteDatabase.CursorFactory) null, 2);
        this.b = context.getApplicationContext();
        File databasePath = context.getDatabasePath("android-devices.db");
        this.a = databasePath;
        if (!databasePath.exists()) {
            a();
        }
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private void b() {
        InputStream open = this.b.getAssets().open("android-devices.db");
        FileOutputStream fileOutputStream = new FileOutputStream(this.a);
        byte[] bArr = new byte[2048];
        while (true) {
            int read = open.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.flush();
                a(fileOutputStream);
                a(open);
                return;
            }
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 <= i) {
            return;
        }
        if (this.b.deleteDatabase("android-devices.db") || this.a.delete() || !this.a.exists()) {
            a();
        }
    }

    private void a() {
        try {
            getReadableDatabase();
            close();
            b();
        } catch (IOException e) {
            throw new SQLException("Error creating android-devices.db database", e);
        }
    }

    public DeviceName.DeviceInfo a(String str, String str2) {
        String str3;
        String[] strArr;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        String[] strArr2 = {Device.JsonKeys.MANUFACTURER, "name", "codename", "model"};
        DeviceName.DeviceInfo deviceInfo = null;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            strArr = new String[]{str, str2};
            str3 = "codename LIKE ? AND model LIKE ?";
        } else if (!TextUtils.isEmpty(str)) {
            strArr = new String[]{str};
            str3 = "codename LIKE ?";
        } else {
            if (!TextUtils.isEmpty(str2)) {
                strArr = new String[]{str2};
                str3 = "model LIKE ?";
            }
            return deviceInfo;
        }
        Cursor query = readableDatabase.query("devices", strArr2, str3, strArr, (String) null, (String) null, (String) null);
        if (query.moveToFirst()) {
            deviceInfo = new DeviceName.DeviceInfo(query.getString(query.getColumnIndexOrThrow(Device.JsonKeys.MANUFACTURER)), query.getString(query.getColumnIndexOrThrow("name")), query.getString(query.getColumnIndexOrThrow("codename")), query.getString(query.getColumnIndexOrThrow("model")));
        }
        a(query);
        a(readableDatabase);
        return deviceInfo;
    }
}
