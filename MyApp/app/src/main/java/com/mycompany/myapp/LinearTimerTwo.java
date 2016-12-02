package com.mycompany.myapp;
import android.content.*;
import android.util.*;
import android.widget.*;
import android.os.*;

public class LinearTimerTwo extends LinearLayout
{
	Handler h = new Handler();
	LinearLayout mLinear = this;
	final static int[] FLAVORS = {
		0xFF9C27B0, 0xFFBA68C8, // grape
		0xFFFF9800, 0xFFFFB74D, // orange
		0xFFF06292, 0xFFF8BBD0, // bubblegum
		0xFFAFB42B, 0xFFCDDC39, // lime
		0xFFFFEB3B, 0xFFFFF176, // lemon
		0xFF795548, 0xFFA1887F, // mystery flavor
    };

	static int colorIndex()
	{
		return 2 * ((int) Math.random() / 2);
	}
	
	Runnable mlayu = new Runnable()
	{
		@Override
		public void run()
		{
			// TODO: Implement this method
			mLinear.setBackgroundColor(FLAVORS[colorIndex()]);
		}
	};
	
	public LinearTimerTwo(Context c,AttributeSet a)
	{
		super(c,a);
		h.postDelayed(mlayu,1000);
	}
}
