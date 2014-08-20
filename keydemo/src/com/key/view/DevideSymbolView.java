package com.key.view;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

/**
 * 除法控件
 * @author desmond.duan
 *
 */
public class DevideSymbolView extends SymbolView {

	SymbolView upSymbolLayout,downSymbolLayout;
	EditText upInput,downInput;
	View devideLine;
	
	public DevideSymbolView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public DevideSymbolView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	public DevideSymbolView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	protected void init() {
		upInput=new EditText(this.getContext());
		downInput=new EditText(this.getContext());
		devideLine=new View(this.getContext());
		devideLine.setBackgroundColor(0xFF000000);
		
		this.addView(upInput);
		this.addView(downInput);
		this.addView(devideLine);

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int height=0,width=0;
		for(int i=0;i<this.getChildCount();i++){
			View child=this.getChildAt(i);
			height+=child.getMeasuredHeight();
			if(width<child.getMeasuredWidth())
				width=child.getMeasuredWidth();
		}
		setMeasuredDimension(width, height);
	}
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		upInput.layout(l, t, r, t+upInput.getMeasuredHeight());
		devideLine.layout(l, upInput.getMeasuredHeight()+1, r, upInput.getMeasuredHeight()+2);
		downInput.layout(l, upInput.getMeasuredHeight()+3, r, upInput.getMeasuredHeight()+3+downInput.getMeasuredHeight());
	}

	@Override
	public Editable getFocusedEditable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EditText getFocusedEditText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int getPreMeasuredHeight() {
		return MONO_HEIGHT+3;
	}

}
