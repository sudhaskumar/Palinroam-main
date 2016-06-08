package com.mbarc.palinroam.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Sudhas on 5/18/2016.
 */
public class RobotoTextView extends TextView {
    public RobotoTextView(Context context) {
        super(context);
    }

    public RobotoTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RobotoTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Regular.ttf");
            setTypeface(tf);
        }
    }
}
