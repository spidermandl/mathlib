package com.key.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class MonoSymbolView extends SymbolView {

	EditText input;
	
	public MonoSymbolView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public MonoSymbolView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	public MonoSymbolView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub

	}

	@Override
	void init() {
		super.type=MONO_TYPE;
		input=new EditText(this.getContext());
		input.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		
		this.addView(input);
	}

}
