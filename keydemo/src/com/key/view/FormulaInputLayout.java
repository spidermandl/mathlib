package com.key.view;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class FormulaInputLayout extends LinearLayout {
	/**
	 * 子view队列
	 */
	private ArrayList<View> childrenInputs=new ArrayList<View>();
    /**
     * 当前获取焦点
     */
	private int currentFocusedIndex;

	public FormulaInputLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public FormulaInputLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	public FormulaInputLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return super.onTouchEvent(event);
	}

}
