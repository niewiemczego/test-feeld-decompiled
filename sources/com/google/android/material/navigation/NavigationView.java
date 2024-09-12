package com.google.android.material.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.R;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int DEF_STYLE_RES = R.style.Widget_Design_NavigationView;
    private static final int[] DISABLED_STATE_SET = {-16842910};
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    private boolean bottomInsetScrimEnabled;
    private int drawerLayoutCornerSize;
    private int layoutGravity;
    OnNavigationItemSelectedListener listener;
    private final int maxWidth;
    private final NavigationMenu menu;
    private MenuInflater menuInflater;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    /* access modifiers changed from: private */
    public final NavigationMenuPresenter presenter;
    private final RectF shapeClipBounds;
    private Path shapeClipPath;
    /* access modifiers changed from: private */
    public final int[] tmpLocation;
    private boolean topInsetScrimEnabled;

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(MenuItem menuItem);
    }

    public NavigationView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationViewStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NavigationView(android.content.Context r17, android.util.AttributeSet r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r7 = r18
            r8 = r19
            int r9 = DEF_STYLE_RES
            r1 = r17
            android.content.Context r1 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r1, r7, r8, r9)
            r0.<init>(r1, r7, r8)
            com.google.android.material.internal.NavigationMenuPresenter r10 = new com.google.android.material.internal.NavigationMenuPresenter
            r10.<init>()
            r0.presenter = r10
            r1 = 2
            int[] r1 = new int[r1]
            r0.tmpLocation = r1
            r11 = 1
            r0.topInsetScrimEnabled = r11
            r0.bottomInsetScrimEnabled = r11
            r12 = 0
            r0.layoutGravity = r12
            r0.drawerLayoutCornerSize = r12
            android.graphics.RectF r1 = new android.graphics.RectF
            r1.<init>()
            r0.shapeClipBounds = r1
            android.content.Context r13 = r16.getContext()
            com.google.android.material.internal.NavigationMenu r14 = new com.google.android.material.internal.NavigationMenu
            r14.<init>(r13)
            r0.menu = r14
            int[] r3 = com.google.android.material.R.styleable.NavigationView
            int[] r6 = new int[r12]
            r1 = r13
            r2 = r18
            r4 = r19
            r5 = r9
            androidx.appcompat.widget.TintTypedArray r1 = com.google.android.material.internal.ThemeEnforcement.obtainTintedStyledAttributes(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.R.styleable.NavigationView_android_background
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x0058
            int r2 = com.google.android.material.R.styleable.NavigationView_android_background
            android.graphics.drawable.Drawable r2 = r1.getDrawable(r2)
            androidx.core.view.ViewCompat.setBackground(r0, r2)
        L_0x0058:
            int r2 = com.google.android.material.R.styleable.NavigationView_drawerLayoutCornerSize
            int r2 = r1.getDimensionPixelSize(r2, r12)
            r0.drawerLayoutCornerSize = r2
            int r2 = com.google.android.material.R.styleable.NavigationView_android_layout_gravity
            int r2 = r1.getInt(r2, r12)
            r0.layoutGravity = r2
            android.graphics.drawable.Drawable r2 = r16.getBackground()
            if (r2 == 0) goto L_0x0076
            android.graphics.drawable.Drawable r2 = r16.getBackground()
            boolean r2 = r2 instanceof android.graphics.drawable.ColorDrawable
            if (r2 == 0) goto L_0x009e
        L_0x0076:
            com.google.android.material.shape.ShapeAppearanceModel$Builder r2 = com.google.android.material.shape.ShapeAppearanceModel.builder((android.content.Context) r13, (android.util.AttributeSet) r7, (int) r8, (int) r9)
            com.google.android.material.shape.ShapeAppearanceModel r2 = r2.build()
            android.graphics.drawable.Drawable r3 = r16.getBackground()
            com.google.android.material.shape.MaterialShapeDrawable r4 = new com.google.android.material.shape.MaterialShapeDrawable
            r4.<init>((com.google.android.material.shape.ShapeAppearanceModel) r2)
            boolean r2 = r3 instanceof android.graphics.drawable.ColorDrawable
            if (r2 == 0) goto L_0x0098
            android.graphics.drawable.ColorDrawable r3 = (android.graphics.drawable.ColorDrawable) r3
            int r2 = r3.getColor()
            android.content.res.ColorStateList r2 = android.content.res.ColorStateList.valueOf(r2)
            r4.setFillColor(r2)
        L_0x0098:
            r4.initializeElevationOverlay(r13)
            androidx.core.view.ViewCompat.setBackground(r0, r4)
        L_0x009e:
            int r2 = com.google.android.material.R.styleable.NavigationView_elevation
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x00b0
            int r2 = com.google.android.material.R.styleable.NavigationView_elevation
            int r2 = r1.getDimensionPixelSize(r2, r12)
            float r2 = (float) r2
            r0.setElevation(r2)
        L_0x00b0:
            int r2 = com.google.android.material.R.styleable.NavigationView_android_fitsSystemWindows
            boolean r2 = r1.getBoolean(r2, r12)
            r0.setFitsSystemWindows(r2)
            int r2 = com.google.android.material.R.styleable.NavigationView_android_maxWidth
            int r2 = r1.getDimensionPixelSize(r2, r12)
            r0.maxWidth = r2
            int r2 = com.google.android.material.R.styleable.NavigationView_subheaderColor
            boolean r2 = r1.hasValue(r2)
            r3 = 0
            if (r2 == 0) goto L_0x00d1
            int r2 = com.google.android.material.R.styleable.NavigationView_subheaderColor
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            goto L_0x00d2
        L_0x00d1:
            r2 = r3
        L_0x00d2:
            int r4 = com.google.android.material.R.styleable.NavigationView_subheaderTextAppearance
            boolean r4 = r1.hasValue(r4)
            if (r4 == 0) goto L_0x00e1
            int r4 = com.google.android.material.R.styleable.NavigationView_subheaderTextAppearance
            int r4 = r1.getResourceId(r4, r12)
            goto L_0x00e2
        L_0x00e1:
            r4 = r12
        L_0x00e2:
            r5 = 16842808(0x1010038, float:2.3693715E-38)
            if (r4 != 0) goto L_0x00ed
            if (r2 != 0) goto L_0x00ed
            android.content.res.ColorStateList r2 = r0.createDefaultColorStateList(r5)
        L_0x00ed:
            int r6 = com.google.android.material.R.styleable.NavigationView_itemIconTint
            boolean r6 = r1.hasValue(r6)
            if (r6 == 0) goto L_0x00fc
            int r5 = com.google.android.material.R.styleable.NavigationView_itemIconTint
            android.content.res.ColorStateList r5 = r1.getColorStateList(r5)
            goto L_0x0100
        L_0x00fc:
            android.content.res.ColorStateList r5 = r0.createDefaultColorStateList(r5)
        L_0x0100:
            int r6 = com.google.android.material.R.styleable.NavigationView_itemTextAppearance
            boolean r6 = r1.hasValue(r6)
            if (r6 == 0) goto L_0x010f
            int r6 = com.google.android.material.R.styleable.NavigationView_itemTextAppearance
            int r6 = r1.getResourceId(r6, r12)
            goto L_0x0110
        L_0x010f:
            r6 = r12
        L_0x0110:
            int r7 = com.google.android.material.R.styleable.NavigationView_itemIconSize
            boolean r7 = r1.hasValue(r7)
            if (r7 == 0) goto L_0x0121
            int r7 = com.google.android.material.R.styleable.NavigationView_itemIconSize
            int r7 = r1.getDimensionPixelSize(r7, r12)
            r0.setItemIconSize(r7)
        L_0x0121:
            int r7 = com.google.android.material.R.styleable.NavigationView_itemTextColor
            boolean r7 = r1.hasValue(r7)
            if (r7 == 0) goto L_0x0130
            int r7 = com.google.android.material.R.styleable.NavigationView_itemTextColor
            android.content.res.ColorStateList r7 = r1.getColorStateList(r7)
            goto L_0x0131
        L_0x0130:
            r7 = r3
        L_0x0131:
            if (r6 != 0) goto L_0x013c
            if (r7 != 0) goto L_0x013c
            r7 = 16842806(0x1010036, float:2.369371E-38)
            android.content.res.ColorStateList r7 = r0.createDefaultColorStateList(r7)
        L_0x013c:
            int r8 = com.google.android.material.R.styleable.NavigationView_itemBackground
            android.graphics.drawable.Drawable r8 = r1.getDrawable(r8)
            if (r8 != 0) goto L_0x016c
            boolean r9 = r0.hasShapeAppearance(r1)
            if (r9 == 0) goto L_0x016c
            android.graphics.drawable.Drawable r8 = r0.createDefaultItemBackground(r1)
            int r9 = com.google.android.material.R.styleable.NavigationView_itemRippleColor
            android.content.res.ColorStateList r9 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r13, (androidx.appcompat.widget.TintTypedArray) r1, (int) r9)
            int r15 = android.os.Build.VERSION.SDK_INT
            r11 = 21
            if (r15 < r11) goto L_0x016c
            if (r9 == 0) goto L_0x016c
            android.graphics.drawable.Drawable r11 = r0.createDefaultItemDrawable(r1, r3)
            android.graphics.drawable.RippleDrawable r15 = new android.graphics.drawable.RippleDrawable
            android.content.res.ColorStateList r9 = com.google.android.material.ripple.RippleUtils.sanitizeRippleDrawableColor(r9)
            r15.<init>(r9, r3, r11)
            r10.setItemForeground(r15)
        L_0x016c:
            int r3 = com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding
            boolean r3 = r1.hasValue(r3)
            if (r3 == 0) goto L_0x017d
            int r3 = com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding
            int r3 = r1.getDimensionPixelSize(r3, r12)
            r0.setItemHorizontalPadding(r3)
        L_0x017d:
            int r3 = com.google.android.material.R.styleable.NavigationView_itemVerticalPadding
            boolean r3 = r1.hasValue(r3)
            if (r3 == 0) goto L_0x018e
            int r3 = com.google.android.material.R.styleable.NavigationView_itemVerticalPadding
            int r3 = r1.getDimensionPixelSize(r3, r12)
            r0.setItemVerticalPadding(r3)
        L_0x018e:
            int r3 = com.google.android.material.R.styleable.NavigationView_dividerInsetStart
            int r3 = r1.getDimensionPixelSize(r3, r12)
            r0.setDividerInsetStart(r3)
            int r3 = com.google.android.material.R.styleable.NavigationView_dividerInsetEnd
            int r3 = r1.getDimensionPixelSize(r3, r12)
            r0.setDividerInsetEnd(r3)
            int r3 = com.google.android.material.R.styleable.NavigationView_subheaderInsetStart
            int r3 = r1.getDimensionPixelSize(r3, r12)
            r0.setSubheaderInsetStart(r3)
            int r3 = com.google.android.material.R.styleable.NavigationView_subheaderInsetEnd
            int r3 = r1.getDimensionPixelSize(r3, r12)
            r0.setSubheaderInsetEnd(r3)
            int r3 = com.google.android.material.R.styleable.NavigationView_topInsetScrimEnabled
            boolean r9 = r0.topInsetScrimEnabled
            boolean r3 = r1.getBoolean(r3, r9)
            r0.setTopInsetScrimEnabled(r3)
            int r3 = com.google.android.material.R.styleable.NavigationView_bottomInsetScrimEnabled
            boolean r9 = r0.bottomInsetScrimEnabled
            boolean r3 = r1.getBoolean(r3, r9)
            r0.setBottomInsetScrimEnabled(r3)
            int r3 = com.google.android.material.R.styleable.NavigationView_itemIconPadding
            int r3 = r1.getDimensionPixelSize(r3, r12)
            int r9 = com.google.android.material.R.styleable.NavigationView_itemMaxLines
            r11 = 1
            int r9 = r1.getInt(r9, r11)
            r0.setItemMaxLines(r9)
            com.google.android.material.navigation.NavigationView$1 r9 = new com.google.android.material.navigation.NavigationView$1
            r9.<init>()
            r14.setCallback(r9)
            r10.setId(r11)
            r10.initForMenu(r13, r14)
            if (r4 == 0) goto L_0x01eb
            r10.setSubheaderTextAppearance(r4)
        L_0x01eb:
            r10.setSubheaderColor(r2)
            r10.setItemIconTintList(r5)
            int r2 = r16.getOverScrollMode()
            r10.setOverScrollMode(r2)
            if (r6 == 0) goto L_0x01fd
            r10.setItemTextAppearance(r6)
        L_0x01fd:
            r10.setItemTextColor(r7)
            r10.setItemBackground(r8)
            r10.setItemIconPadding(r3)
            r14.addMenuPresenter(r10)
            androidx.appcompat.view.menu.MenuView r2 = r10.getMenuView(r0)
            android.view.View r2 = (android.view.View) r2
            r0.addView(r2)
            int r2 = com.google.android.material.R.styleable.NavigationView_menu
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x0223
            int r2 = com.google.android.material.R.styleable.NavigationView_menu
            int r2 = r1.getResourceId(r2, r12)
            r0.inflateMenu(r2)
        L_0x0223:
            int r2 = com.google.android.material.R.styleable.NavigationView_headerLayout
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x0234
            int r2 = com.google.android.material.R.styleable.NavigationView_headerLayout
            int r2 = r1.getResourceId(r2, r12)
            r0.inflateHeaderView(r2)
        L_0x0234:
            r1.recycle()
            r16.setupInsetScrimsListener()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setOverScrollMode(int i) {
        super.setOverScrollMode(i);
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        if (navigationMenuPresenter != null) {
            navigationMenuPresenter.setOverScrollMode(i);
        }
    }

    private void maybeUpdateCornerSizeForDrawerLayout(int i, int i2) {
        if (!(getParent() instanceof DrawerLayout) || this.drawerLayoutCornerSize <= 0 || !(getBackground() instanceof MaterialShapeDrawable)) {
            this.shapeClipPath = null;
            this.shapeClipBounds.setEmpty();
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = (MaterialShapeDrawable) getBackground();
        ShapeAppearanceModel.Builder builder = materialShapeDrawable.getShapeAppearanceModel().toBuilder();
        if (GravityCompat.getAbsoluteGravity(this.layoutGravity, ViewCompat.getLayoutDirection(this)) == 3) {
            builder.setTopRightCornerSize((float) this.drawerLayoutCornerSize);
            builder.setBottomRightCornerSize((float) this.drawerLayoutCornerSize);
        } else {
            builder.setTopLeftCornerSize((float) this.drawerLayoutCornerSize);
            builder.setBottomLeftCornerSize((float) this.drawerLayoutCornerSize);
        }
        materialShapeDrawable.setShapeAppearanceModel(builder.build());
        if (this.shapeClipPath == null) {
            this.shapeClipPath = new Path();
        }
        this.shapeClipPath.reset();
        this.shapeClipBounds.set(0.0f, 0.0f, (float) i, (float) i2);
        ShapeAppearancePathProvider.getInstance().calculatePath(materialShapeDrawable.getShapeAppearanceModel(), materialShapeDrawable.getInterpolation(), this.shapeClipBounds, this.shapeClipPath);
        invalidate();
    }

    private boolean hasShapeAppearance(TintTypedArray tintTypedArray) {
        return tintTypedArray.hasValue(R.styleable.NavigationView_itemShapeAppearance) || tintTypedArray.hasValue(R.styleable.NavigationView_itemShapeAppearanceOverlay);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        maybeUpdateCornerSizeForDrawerLayout(i, i2);
    }

    public void setElevation(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.setElevation(f);
        }
        MaterialShapeUtils.setElevation(this, f);
    }

    private Drawable createDefaultItemBackground(TintTypedArray tintTypedArray) {
        return createDefaultItemDrawable(tintTypedArray, MaterialResources.getColorStateList(getContext(), tintTypedArray, R.styleable.NavigationView_itemShapeFillColor));
    }

    private Drawable createDefaultItemDrawable(TintTypedArray tintTypedArray, ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(getContext(), tintTypedArray.getResourceId(R.styleable.NavigationView_itemShapeAppearance, 0), tintTypedArray.getResourceId(R.styleable.NavigationView_itemShapeAppearanceOverlay, 0)).build());
        materialShapeDrawable.setFillColor(colorStateList);
        return new InsetDrawable(materialShapeDrawable, tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetStart, 0), tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetTop, 0), tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetEnd, 0), tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.menuState = new Bundle();
        this.menu.savePresenterStates(savedState.menuState);
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.menu.restorePresenterStates(savedState.menuState);
    }

    public void setNavigationItemSelectedListener(OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.listener = onNavigationItemSelectedListener;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), this.maxWidth), 1073741824);
        } else if (mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.shapeClipPath == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.clipPath(this.shapeClipPath);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    /* access modifiers changed from: protected */
    public void onInsetsChanged(WindowInsetsCompat windowInsetsCompat) {
        this.presenter.dispatchApplyWindowInsets(windowInsetsCompat);
    }

    public void inflateMenu(int i) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(i, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(false);
    }

    public Menu getMenu() {
        return this.menu;
    }

    public View inflateHeaderView(int i) {
        return this.presenter.inflateHeaderView(i);
    }

    public void addHeaderView(View view) {
        this.presenter.addHeaderView(view);
    }

    public void removeHeaderView(View view) {
        this.presenter.removeHeaderView(view);
    }

    public int getHeaderCount() {
        return this.presenter.getHeaderCount();
    }

    public View getHeaderView(int i) {
        return this.presenter.getHeaderView(i);
    }

    public ColorStateList getItemIconTintList() {
        return this.presenter.getItemTintList();
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.presenter.setItemIconTintList(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.presenter.getItemTextColor();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.presenter.setItemTextColor(colorStateList);
    }

    public Drawable getItemBackground() {
        return this.presenter.getItemBackground();
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(ContextCompat.getDrawable(getContext(), i));
    }

    public void setItemBackground(Drawable drawable) {
        this.presenter.setItemBackground(drawable);
    }

    public int getItemHorizontalPadding() {
        return this.presenter.getItemHorizontalPadding();
    }

    public void setItemHorizontalPadding(int i) {
        this.presenter.setItemHorizontalPadding(i);
    }

    public void setItemHorizontalPaddingResource(int i) {
        this.presenter.setItemHorizontalPadding(getResources().getDimensionPixelSize(i));
    }

    public int getItemVerticalPadding() {
        return this.presenter.getItemVerticalPadding();
    }

    public void setItemVerticalPadding(int i) {
        this.presenter.setItemVerticalPadding(i);
    }

    public void setItemVerticalPaddingResource(int i) {
        this.presenter.setItemVerticalPadding(getResources().getDimensionPixelSize(i));
    }

    public int getItemIconPadding() {
        return this.presenter.getItemIconPadding();
    }

    public void setItemIconPadding(int i) {
        this.presenter.setItemIconPadding(i);
    }

    public void setItemIconPaddingResource(int i) {
        this.presenter.setItemIconPadding(getResources().getDimensionPixelSize(i));
    }

    public void setCheckedItem(int i) {
        MenuItem findItem = this.menu.findItem(i);
        if (findItem != null) {
            this.presenter.setCheckedItem((MenuItemImpl) findItem);
        }
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem findItem = this.menu.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.presenter.setCheckedItem((MenuItemImpl) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    public MenuItem getCheckedItem() {
        return this.presenter.getCheckedItem();
    }

    public void setItemTextAppearance(int i) {
        this.presenter.setItemTextAppearance(i);
    }

    public void setItemIconSize(int i) {
        this.presenter.setItemIconSize(i);
    }

    public void setItemMaxLines(int i) {
        this.presenter.setItemMaxLines(i);
    }

    public int getItemMaxLines() {
        return this.presenter.getItemMaxLines();
    }

    public boolean isTopInsetScrimEnabled() {
        return this.topInsetScrimEnabled;
    }

    public void setTopInsetScrimEnabled(boolean z) {
        this.topInsetScrimEnabled = z;
    }

    public boolean isBottomInsetScrimEnabled() {
        return this.bottomInsetScrimEnabled;
    }

    public void setBottomInsetScrimEnabled(boolean z) {
        this.bottomInsetScrimEnabled = z;
    }

    public int getDividerInsetStart() {
        return this.presenter.getDividerInsetStart();
    }

    public void setDividerInsetStart(int i) {
        this.presenter.setDividerInsetStart(i);
    }

    public int getDividerInsetEnd() {
        return this.presenter.getDividerInsetEnd();
    }

    public void setDividerInsetEnd(int i) {
        this.presenter.setDividerInsetEnd(i);
    }

    public int getSubheaderInsetStart() {
        return this.presenter.getSubheaderInsetStart();
    }

    public void setSubheaderInsetStart(int i) {
        this.presenter.setSubheaderInsetStart(i);
    }

    public int getSubheaderInsetEnd() {
        return this.presenter.getSubheaderInsetEnd();
    }

    public void setSubheaderInsetEnd(int i) {
        this.presenter.setSubheaderInsetStart(i);
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater == null) {
            this.menuInflater = new SupportMenuInflater(getContext());
        }
        return this.menuInflater;
    }

    private ColorStateList createDefaultColorStateList(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        int[] iArr = DISABLED_STATE_SET;
        return new ColorStateList(new int[][]{iArr, CHECKED_STATE_SET, EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i2, defaultColor});
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT < 16) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.onGlobalLayoutListener);
        } else {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        }
    }

    private void setupInsetScrimsListener() {
        this.onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                NavigationView navigationView = NavigationView.this;
                navigationView.getLocationOnScreen(navigationView.tmpLocation);
                boolean z = true;
                boolean z2 = NavigationView.this.tmpLocation[1] == 0;
                NavigationView.this.presenter.setBehindStatusBar(z2);
                NavigationView navigationView2 = NavigationView.this;
                navigationView2.setDrawTopInsetForeground(z2 && navigationView2.isTopInsetScrimEnabled());
                Activity activity = ContextUtils.getActivity(NavigationView.this.getContext());
                if (activity != null && Build.VERSION.SDK_INT >= 21) {
                    boolean z3 = activity.findViewById(16908290).getHeight() == NavigationView.this.getHeight();
                    boolean z4 = Color.alpha(activity.getWindow().getNavigationBarColor()) != 0;
                    NavigationView navigationView3 = NavigationView.this;
                    if (!z3 || !z4 || !navigationView3.isBottomInsetScrimEnabled()) {
                        z = false;
                    }
                    navigationView3.setDrawBottomInsetForeground(z);
                }
            }
        };
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public Bundle menuState;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuState = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.menuState);
        }
    }
}
