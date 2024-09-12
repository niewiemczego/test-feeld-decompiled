package com.facebook.react.shell;

import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.react.TurboReactPackage;
import com.facebook.react.animated.NativeAnimatedModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.modules.accessibilityinfo.AccessibilityInfoModule;
import com.facebook.react.modules.appearance.AppearanceModule;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.modules.blob.BlobModule;
import com.facebook.react.modules.blob.FileReaderModule;
import com.facebook.react.modules.camera.ImageStoreManager;
import com.facebook.react.modules.clipboard.ClipboardModule;
import com.facebook.react.modules.dialog.DialogModule;
import com.facebook.react.modules.fresco.FrescoModule;
import com.facebook.react.modules.i18nmanager.I18nManagerModule;
import com.facebook.react.modules.image.ImageLoaderModule;
import com.facebook.react.modules.intent.IntentModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.modules.permissions.PermissionsModule;
import com.facebook.react.modules.share.ShareModule;
import com.facebook.react.modules.sound.SoundManagerModule;
import com.facebook.react.modules.statusbar.StatusBarModule;
import com.facebook.react.modules.toast.ToastModule;
import com.facebook.react.modules.vibration.VibrationModule;
import com.facebook.react.modules.websocket.WebSocketModule;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.drawer.ReactDrawerLayoutManager;
import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollContainerViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollViewManager;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.facebook.react.views.slider.ReactSliderManager;
import com.facebook.react.views.swiperefresh.SwipeRefreshLayoutManager;
import com.facebook.react.views.switchview.ReactSwitchManager;
import com.facebook.react.views.text.ReactRawTextManager;
import com.facebook.react.views.text.ReactTextViewManager;
import com.facebook.react.views.text.ReactVirtualTextViewManager;
import com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageViewManager;
import com.facebook.react.views.textinput.ReactTextInputManager;
import com.facebook.react.views.unimplementedview.ReactUnimplementedViewManager;
import com.facebook.react.views.view.ReactViewManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.CharUtils;

public class MainReactPackage extends TurboReactPackage {
    private MainPackageConfig mConfig;

    public MainReactPackage() {
    }

    public MainReactPackage(MainPackageConfig mainPackageConfig) {
        this.mConfig = mainPackageConfig;
    }

    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2115067288:
                if (str.equals(ToastModule.NAME)) {
                    c = 0;
                    break;
                }
                break;
            case -1962922905:
                if (str.equals(ImageStoreManager.NAME)) {
                    c = 1;
                    break;
                }
                break;
            case -1850625090:
                if (str.equals(SoundManagerModule.NAME)) {
                    c = 2;
                    break;
                }
                break;
            case -1654566518:
                if (str.equals(DialogModule.NAME)) {
                    c = 3;
                    break;
                }
                break;
            case -1344126773:
                if (str.equals(FileReaderModule.NAME)) {
                    c = 4;
                    break;
                }
                break;
            case -1062061717:
                if (str.equals(PermissionsModule.NAME)) {
                    c = 5;
                    break;
                }
                break;
            case -657277650:
                if (str.equals(ImageLoaderModule.NAME)) {
                    c = 6;
                    break;
                }
                break;
            case -570370161:
                if (str.equals(I18nManagerModule.NAME)) {
                    c = 7;
                    break;
                }
                break;
            case -504784764:
                if (str.equals(AppearanceModule.NAME)) {
                    c = 8;
                    break;
                }
                break;
            case -457866500:
                if (str.equals(AccessibilityInfoModule.NAME)) {
                    c = 9;
                    break;
                }
                break;
            case -382654004:
                if (str.equals(StatusBarModule.NAME)) {
                    c = 10;
                    break;
                }
                break;
            case -254310125:
                if (str.equals("WebSocketModule")) {
                    c = 11;
                    break;
                }
                break;
            case 163245714:
                if (str.equals(FrescoModule.NAME)) {
                    c = 12;
                    break;
                }
                break;
            case 403570038:
                if (str.equals(ClipboardModule.NAME)) {
                    c = CharUtils.CR;
                    break;
                }
                break;
            case 563961875:
                if (str.equals(IntentModule.NAME)) {
                    c = 14;
                    break;
                }
                break;
            case 1221389072:
                if (str.equals(AppStateModule.NAME)) {
                    c = 15;
                    break;
                }
                break;
            case 1515242260:
                if (str.equals(NetworkingModule.NAME)) {
                    c = 16;
                    break;
                }
                break;
            case 1547941001:
                if (str.equals(BlobModule.NAME)) {
                    c = 17;
                    break;
                }
                break;
            case 1555425035:
                if (str.equals(ShareModule.NAME)) {
                    c = 18;
                    break;
                }
                break;
            case 1721274886:
                if (str.equals(NativeAnimatedModule.NAME)) {
                    c = 19;
                    break;
                }
                break;
            case 1922110066:
                if (str.equals(VibrationModule.NAME)) {
                    c = 20;
                    break;
                }
                break;
        }
        ImagePipelineConfig imagePipelineConfig = null;
        switch (c) {
            case 0:
                return new ToastModule(reactApplicationContext);
            case 1:
                return new ImageStoreManager(reactApplicationContext);
            case 2:
                return new SoundManagerModule(reactApplicationContext);
            case 3:
                return new DialogModule(reactApplicationContext);
            case 4:
                return new FileReaderModule(reactApplicationContext);
            case 5:
                return new PermissionsModule(reactApplicationContext);
            case 6:
                return new ImageLoaderModule(reactApplicationContext);
            case 7:
                return new I18nManagerModule(reactApplicationContext);
            case 8:
                return new AppearanceModule(reactApplicationContext);
            case 9:
                return new AccessibilityInfoModule(reactApplicationContext);
            case 10:
                return new StatusBarModule(reactApplicationContext);
            case 11:
                return new WebSocketModule(reactApplicationContext);
            case 12:
                MainPackageConfig mainPackageConfig = this.mConfig;
                if (mainPackageConfig != null) {
                    imagePipelineConfig = mainPackageConfig.getFrescoConfig();
                }
                return new FrescoModule(reactApplicationContext, true, imagePipelineConfig);
            case 13:
                return new ClipboardModule(reactApplicationContext);
            case 14:
                return new IntentModule(reactApplicationContext);
            case 15:
                return new AppStateModule(reactApplicationContext);
            case 16:
                return new NetworkingModule(reactApplicationContext);
            case 17:
                return new BlobModule(reactApplicationContext);
            case 18:
                return new ShareModule(reactApplicationContext);
            case 19:
                return new NativeAnimatedModule(reactApplicationContext);
            case 20:
                return new VibrationModule(reactApplicationContext);
            default:
                return null;
        }
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ReactDrawerLayoutManager());
        arrayList.add(new ReactHorizontalScrollViewManager());
        arrayList.add(new ReactHorizontalScrollContainerViewManager());
        arrayList.add(new ReactProgressBarViewManager());
        arrayList.add(new ReactScrollViewManager());
        arrayList.add(new ReactSliderManager());
        arrayList.add(new ReactSwitchManager());
        arrayList.add(new SwipeRefreshLayoutManager());
        arrayList.add(new FrescoBasedReactTextInlineImageViewManager());
        arrayList.add(new ReactImageManager());
        arrayList.add(new ReactModalHostManager());
        arrayList.add(new ReactRawTextManager());
        arrayList.add(new ReactTextInputManager());
        arrayList.add(new ReactTextViewManager());
        arrayList.add(new ReactViewManager());
        arrayList.add(new ReactVirtualTextViewManager());
        arrayList.add(new ReactUnimplementedViewManager());
        return arrayList;
    }

    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        try {
            return (ReactModuleInfoProvider) Class.forName("com.facebook.react.shell.MainReactPackage$$ReactModuleInfoProvider").newInstance();
        } catch (ClassNotFoundException unused) {
            Class[] clsArr = {AccessibilityInfoModule.class, AppearanceModule.class, AppStateModule.class, BlobModule.class, FileReaderModule.class, ClipboardModule.class, DialogModule.class, FrescoModule.class, I18nManagerModule.class, ImageLoaderModule.class, ImageStoreManager.class, IntentModule.class, NativeAnimatedModule.class, NetworkingModule.class, PermissionsModule.class, ShareModule.class, StatusBarModule.class, SoundManagerModule.class, ToastModule.class, VibrationModule.class, WebSocketModule.class};
            final HashMap hashMap = new HashMap();
            for (int i = 0; i < 21; i++) {
                Class cls = clsArr[i];
                ReactModule reactModule = (ReactModule) cls.getAnnotation(ReactModule.class);
                hashMap.put(reactModule.name(), new ReactModuleInfo(reactModule.name(), cls.getName(), reactModule.canOverrideExistingModule(), reactModule.needsEagerInit(), reactModule.hasConstants(), reactModule.isCxxModule(), TurboModule.class.isAssignableFrom(cls)));
            }
            return new ReactModuleInfoProvider() {
                public Map<String, ReactModuleInfo> getReactModuleInfos() {
                    return hashMap;
                }
            };
        } catch (InstantiationException e) {
            throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", e2);
        }
    }
}
