package com.key.view;

import android.text.Editable;
import android.view.View.OnTouchListener;
import android.widget.EditText;

public interface SymbolInterface {


	public Editable getFocusedEditable();
	public EditText getFocusedEditText();
	public void setInputTouchListener(OnTouchListener listener);
}
