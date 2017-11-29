package com.samapps.sachinmalik.chatapp;

/**
 * Created by sachinmalik on 29/11/17.
 */

import java.lang.ref.SoftReference;
import java.util.Hashtable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class UiUtil {
    public static final String TAG = "UiUtil";
    private static final Hashtable<String, SoftReference<Typeface>> fontCache = new Hashtable();

    public static Typeface getFont(Context paramContext, String paramString) {
        synchronized (fontCache) {
            if (fontCache.get(paramString) != null) {
                SoftReference localSoftReference = (SoftReference) fontCache
                        .get(paramString);
                if (localSoftReference.get() != null) {
                    Typeface localTypeface2 = (Typeface) localSoftReference
                            .get();
                    return localTypeface2;
                }
            }
            Typeface localTypeface1 = Typeface.createFromAsset(
                    paramContext.getAssets(), "fonts/" + paramString);
            fontCache.put(paramString, new SoftReference(localTypeface1));
            return localTypeface1;
        }
    }

    public static void setCustomFont(View paramView, Context paramContext,
                                     AttributeSet paramAttributeSet, int[] paramArrayOfInt, int paramInt) {

        TypedArray localTypedArray = paramContext.obtainStyledAttributes(
                paramAttributeSet, paramArrayOfInt);
        setCustomFont(paramView, paramContext,
                localTypedArray.getString(paramInt));
        localTypedArray.recycle();
    }

    private static boolean setCustomFont(View paramView, Context paramContext,
                                         String paramString) {
        if (TextUtils.isEmpty(paramString))
            return false;
        try {
            Typeface localTypeface = getFont(paramContext, paramString);
            if ((paramView instanceof TextView))
                ((TextView) paramView).setTypeface(localTypeface);
            else if ((paramView instanceof Button))
                ((Button) paramView).setTypeface(localTypeface);
            else if ((paramView instanceof EditText))
                ((EditText) paramView).setTypeface(localTypeface);
            else
                ((CheckBox) paramView).setTypeface(localTypeface);
        } catch (Exception localException) {
            Log.e("UiUtil", "Could not get typeface: " + paramString,
                    localException);
            return false;
        }
        return true;
    }
}
