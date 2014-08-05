package com.key.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public abstract class SymbolView extends ViewGroup {
	
    public final static int MONO_TYPE=1;
    
	protected int type;
	
	public SymbolView(Context context) {
		super(context);
		init();
	}
	
	public SymbolView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	public SymbolView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}
	
	abstract void init();

}
