package com.key.application;

import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;


import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class KeyApplication extends Application{

	private HashMap<String, Object> memCache;

	private int screen_width;
	private int screen_height;
	private int initialOrientation;
	/**
	 * compare orientation status with the initial one
	 * true if different;false if same
	 */
	private boolean reverseOrientation=false;
	private static KeyApplication instance;
	

	/**
	 * 图片缓存，所有图片资源统一内存管理
	 */
	HashMap<Integer,SoftReference<Bitmap>> bitmapCache=new HashMap<Integer, SoftReference<Bitmap>>();
    /**
     * 程序崩溃异常处理handler
     */
	
	
	public static KeyApplication getInstance(){
		return instance;
	}

	@Override
	public void onCreate() {
		instance=this;
		DisplayMetrics displaymetrics = new DisplayMetrics();
		WindowManager window=(WindowManager)(this.getSystemService(Context.WINDOW_SERVICE));
		window.getDefaultDisplay().getMetrics(displaymetrics);
		screen_width=displaymetrics.widthPixels;
		screen_height=displaymetrics.heightPixels;
		initialOrientation=this.getResources().getConfiguration().orientation;
		super.onCreate();
	}
	/**
	 * 进程退出
	 */
	public void quit(){
    	ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE); 
    	if (Build.VERSION.SDK_INT < 8){
    		am.restartPackage(getPackageName());
    	}
    	else{
			Method method;
			try {
				method = am.getClass().getMethod("killBackgroundProcesses",new Class[] {String.class });
				method.invoke(am,"com.diary.goal.setting");
	   		} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}	
    		//am.killBackgroundProcesses("com.diary.goal.setting"); 
    	}
	}
	/**
	 * 获取屏幕宽度
	 * @return
	 */
	public int getScreen_w() {
		if(!reverseOrientation)
			return screen_width;
		else
			return screen_height;
	}
	/**
	 * 获取屏幕高度
	 * @return
	 */
	public int getScreen_h() {
		if(!reverseOrientation)
			return screen_height;
		else
			return screen_width;
	}
	
	public void setBitmap(Integer resid,Bitmap bitmap){
		SoftReference<Bitmap> softBitmap=new SoftReference<Bitmap>(bitmap);
		bitmapCache.put(resid, softBitmap);
	}
	public Bitmap getBitmap(Integer resid){
		SoftReference<Bitmap> softBitmap=bitmapCache.get(resid);
		if(softBitmap!=null){
			Bitmap bitmap=softBitmap.get();
			return bitmap;
		}
		return null;
	}
	public void clearbitmap(Integer resid){
		SoftReference<Bitmap> softBitmap=bitmapCache.get(resid);
		if(softBitmap!=null){
			softBitmap.clear();
		}
	}
	public void setOrientation(int o){
		if(initialOrientation!=o)
			reverseOrientation=true;
		else
			reverseOrientation=false;
	}
	public int getOrientation(){
		return initialOrientation;
	}


}
