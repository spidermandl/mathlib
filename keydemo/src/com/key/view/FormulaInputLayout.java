package com.key.view;

import java.util.ArrayList;

import com.key.application.KeyApplication;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class FormulaInputLayout extends ViewGroup implements SymbolInterface {
	/**
	 * 子view队列
	 */
	private ArrayList<SymbolView> childrenInputs=new ArrayList<SymbolView>();
    /**
     * 当前获取焦点
     */
	private int currentFocusedIndex;

	@Override
	public void addView(View child, int index, LayoutParams params) {
		childrenInputs.add((SymbolView)child);
		super.addView(child, index, params);
	}
	
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

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//		int w=MeasureSpec.getSize(widthMeasureSpec);
//		int h=MeasureSpec.getSize(heightMeasureSpec);
//		int wrapW=MeasureSpec.getMode(widthMeasureSpec);
//		int wrapH=MeasureSpec.getMode(heightMeasureSpec);
		int height=0,width=0;
		for(SymbolView child:childrenInputs){
			width+=child.getMeasuredWidth();
			if(height<child.getPreMeasuredHeight())
				height=child.getPreMeasuredHeight();
			child.measure(widthMeasureSpec, heightMeasureSpec);
		}
		width=width<KeyApplication.getInstance().getScreen_w()?KeyApplication.getInstance().getScreen_w():width;
		setMeasuredDimension(width, height);
		//super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		int gap=0;
		for(SymbolView child:childrenInputs){
			//child.layout(l+gap, t, l+gap+child.getWidth(), t+child.getHeight());
			child.layout(l, t+(b-t-child.getPreMeasuredHeight())/2, r, t+(b-t+child.getPreMeasuredHeight())/2);
			//child.layout(l, t, r, b);
			gap+=child.getWidth();
		}
		
	}

	@Override
	public Editable getFocusedEditable() {
		// TODO Auto-generated method stub
		return childrenInputs.get(currentFocusedIndex).getFocusedEditable();
	}

	@Override
	public EditText getFocusedEditText() {
		// TODO Auto-generated method stub
		return childrenInputs.get(currentFocusedIndex).getFocusedEditText();
	}

	@Override
	public void setInputTouchListener(OnTouchListener listener) {
		for(SymbolView child:childrenInputs){
			child.setInputTouchListener(listener);
		}
		
	}

}

/**
 * 	第一点：背景
	第二点：模式    abc模式 代理 商家 消费者模式
	第三点：返利计划
	第四点：系统
	第五点：产品     厂家与之合作 淘众福招商产品
	第六点：先机

	1 推荐商家提成 -------商家提供商品商家到淘众福，由淘众福推广，或推荐其他商家商品到淘众福
	2 引导消费福分 -------引导他人开网店，提成网店消费
	3 超低折扣零售 -------赚中间差价
	4 开地面服务店 -------淘众福地面店 全国50多家
*/
