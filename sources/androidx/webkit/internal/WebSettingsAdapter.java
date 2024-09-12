package androidx.webkit.internal;

import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

public class WebSettingsAdapter {
    private WebSettingsBoundaryInterface mBoundaryInterface;

    public WebSettingsAdapter(WebSettingsBoundaryInterface webSettingsBoundaryInterface) {
        this.mBoundaryInterface = webSettingsBoundaryInterface;
    }

    public void setOffscreenPreRaster(boolean z) {
        this.mBoundaryInterface.setOffscreenPreRaster(z);
    }

    public boolean getOffscreenPreRaster() {
        return this.mBoundaryInterface.getOffscreenPreRaster();
    }

    public void setSafeBrowsingEnabled(boolean z) {
        this.mBoundaryInterface.setSafeBrowsingEnabled(z);
    }

    public boolean getSafeBrowsingEnabled() {
        return this.mBoundaryInterface.getSafeBrowsingEnabled();
    }

    public void setDisabledActionModeMenuItems(int i) {
        this.mBoundaryInterface.setDisabledActionModeMenuItems(i);
    }

    public int getDisabledActionModeMenuItems() {
        return this.mBoundaryInterface.getDisabledActionModeMenuItems();
    }

    public void setWillSuppressErrorPage(boolean z) {
        this.mBoundaryInterface.setWillSuppressErrorPage(z);
    }

    public boolean willSuppressErrorPage() {
        return this.mBoundaryInterface.getWillSuppressErrorPage();
    }

    public void setForceDark(int i) {
        this.mBoundaryInterface.setForceDark(i);
    }

    public int getForceDark() {
        return this.mBoundaryInterface.getForceDark();
    }

    public void setForceDarkStrategy(int i) {
        this.mBoundaryInterface.setForceDarkBehavior(i);
    }

    public int getForceDarkStrategy() {
        return this.mBoundaryInterface.getForceDarkBehavior();
    }
}
