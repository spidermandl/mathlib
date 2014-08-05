package cn.key;

import java.util.HashMap;

public class Constant {
    /**
     * 按键code表
     */
	static final HashMap<Integer, String> KEY_COLLECTION=new HashMap<Integer, String>(){
		private static final long serialVersionUID = 5513152624460815693L;

		{
			put(50001, "1") ;put(50002, "2") ;put(50003, "3") ;put(50004, "4") ;
			put(50005, "5") ;put(50006, "6") ;put(50007, "7") ;put(50008, "8") ;
			put(50009, "9") ;put(50010, ".") ;put(50011, "+") ;put(50012, "-") ;
			put(50013, "×") ;put(50014, "÷") ;put(50015, "x") ;put(50016, "y") ;
			put(50017, "f") ;put(50018, "(") ;put(50019, ")") ;put(50020, ",") ;
			put(50021, "≈") ;put(50022, "=") ;put(50023, "A") ;put(50024, "θ") ;
			put(80000, "sin") ;put(80001, "cos") ;put(80002, "tan") ;put(80003, "ctan") ;
			put(80004, "log") ;put(80005, "ln") ;
		    
		}
	};

}
