package cn.key;

import com.key.view.FormulaInputLayout;
import com.key.view.MonoSymbolView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;

public class KeydemoActivity extends Activity {
	private Context ctx;
	private Activity act;
	private EditText edit;
	private EditText edit1;
	private FormulaInputLayout formulaView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ctx = this;
		act = this;

//		edit = (EditText) this.findViewById(R.id.edit);
//		edit.setInputType(InputType.TYPE_NULL);
//
//		edit1 = (EditText) this.findViewById(R.id.edit1);
//
//		edit.setOnTouchListener(new OnTouchListener() {
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				new KeyboardUtil(act, ctx, edit).showKeyboard();
//				return false;
//			}
//		});
//
//		edit1.setOnTouchListener(new OnTouchListener() {
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				int inputback = edit1.getInputType();
//				edit1.setInputType(InputType.TYPE_NULL);
//				new KeyboardUtil(act, ctx, edit1).showKeyboard();
//				edit1.setInputType(inputback);
//				return false;
//			}
//		});
		
		formulaView = (FormulaInputLayout)findViewById(R.id.panel);
		formulaView.addView(new MonoSymbolView(this));
		formulaView.setInputTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				EditText ed=(EditText)v;
				new KeyboardUtil(act, ctx, ed).showKeyboard();
				return true;
			}
		});
	}
}