package com.samapps.sachinmalik.chatapp;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by sachinmalik on 29/11/17.
 */

public class samtextview extends android.support.v7.widget.AppCompatTextView {
    public samtextview(Context paramContext) {
        super(paramContext);
    }

    public samtextview(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        UiUtil.setCustomFont(this, paramContext, paramAttributeSet,
                R.styleable.samTextView, 0);
    }

    public samtextview(Context paramContext,
                            AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        UiUtil.setCustomFont(this, paramContext, paramAttributeSet,
                R.styleable.samTextView, 0);
    }
}
