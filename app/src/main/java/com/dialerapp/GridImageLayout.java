package com.dialerapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

public class GridImageLayout extends GridLayout {
    public GridImageLayout(Context context) {
        super(context);
    }

    public GridImageLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GridImageLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public GridImageLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void addImage(View item){
        setRowCount(2);
        setColumnCount(2);
        if (item instanceof ImageView){
            if (getChildCount()<4){
                addView(item);
            }else {

            }
        }
    }
}
