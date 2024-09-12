package io.seon.androidsdk.service;

import android.content.Context;

class Probes implements IProbes {
    private final SeonImpl a;
    private DeviceProbe b = new DeviceProbe();
    private HardwareProbe c = new HardwareProbe();
    private LocaleProbe d = new LocaleProbe();
    private MediaProbe e = new MediaProbe();
    private NetworkProbe f = new NetworkProbe();
    private OSProbe g = new OSProbe();
    private TelephonyProbe h = new TelephonyProbe();
    private GeolocationProbe i = new GeolocationProbe();
    private SecurityProbe j = new SecurityProbe();

    Probes(SeonImpl seonImpl) {
        this.a = seonImpl;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.a.getContext() != null) {
            Context context = this.a.getContext();
            boolean b2 = this.a.b();
            this.b.bootstrap(context);
            this.c.bootstrap(context);
            this.d.bootstrap(context);
            this.e.bootstrap(context);
            this.f.bootstrap(context);
            this.g.bootstrap(context);
            this.h.bootstrap(context);
            this.i.bootstrap(context);
            this.j.bootstrap(context);
            this.i.setIsOnPremise(b2);
        }
    }

    public DeviceProbe b() {
        return this.b;
    }

    public GeolocationProbe c() {
        return this.i;
    }

    public HardwareProbe d() {
        return this.c;
    }

    public LocaleProbe e() {
        return this.d;
    }

    public MediaProbe f() {
        return this.e;
    }

    public NetworkProbe g() {
        return this.f;
    }

    public OSProbe h() {
        return this.g;
    }

    public SecurityProbe i() {
        return this.j;
    }

    public TelephonyProbe j() {
        return this.h;
    }
}
