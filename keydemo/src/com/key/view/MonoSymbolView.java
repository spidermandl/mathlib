package com.key.view;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.EditText;

/**
 * 单条输入
 * @author desmond.duan
 *
 */
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
	protected void init() {
		super.type=MONO_TYPE;
		input=new EditText(this.getContext());
		input.setSingleLine(true);
		input.setGravity(Gravity.CENTER_VERTICAL);

		this.addView(input);
	}
	
	@Override
	public Editable getFocusedEditable() {
		// TODO Auto-generated method stub
		return input.getEditableText();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		input.measure(
				MeasureSpec.makeMeasureSpec(MeasureSpec.EXACTLY, r-l), 
				MeasureSpec.makeMeasureSpec(MeasureSpec.EXACTLY, b-t));
		input.layout(l, t, r, b);

	}

	@Override
	public EditText getFocusedEditText() {
		return input;
	}

	@Override
	protected int getPreMeasuredHeight() {
		return MONO_HEIGHT;
	}

	
}
