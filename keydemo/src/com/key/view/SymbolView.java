package com.key.view;

import cn.key.KeyboardUtil;
import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public abstract class SymbolView extends ViewGroup implements SymbolInterface{
	
    public final static int MONO_TYPE=1;
    public final static int MONO_HEIGHT=200;
    
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
	
	
	@Override
	public void setInputTouchListener(OnTouchListener listener) {
		for(int i=0;i<this.getChildCount();i++){
			View child=this.getChildAt(i);
			if(child instanceof EditText){
				((EditText)child).setOnTouchListener(listener);
			}
		}
	}
	
	abstract protected void init();
	abstract protected int getPreMeasuredHeight();

}
