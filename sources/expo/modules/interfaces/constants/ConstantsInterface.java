package expo.modules.interfaces.constants;

import java.util.List;
import java.util.Map;

public interface ConstantsInterface {
    String getAppOwnership();

    String getAppScopeKey();

    Map<String, Object> getConstants();

    String getDeviceName();

    int getDeviceYearClass();

    boolean getIsDevice();

    int getStatusBarHeight();

    List<String> getSystemFonts();

    String getSystemVersion();
}
