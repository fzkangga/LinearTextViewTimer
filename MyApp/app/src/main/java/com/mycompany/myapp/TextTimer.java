package com.mycompany.myapp;
import android.widget.*;
import android.content.*;
import android.util.*;
import android.os.*;
import java.util.*;

public class TextTimer extends TextView
{
	Handler mHandler;
	TextView mText = this;
	final static int[] FLAVORS = {
		0xFF9C27B0, 0xFFBA68C8, // grape
		0xFFFF9800, 0xFFFFB74D, // orange
		0xFFF06292, 0xFFF8BBD0, // bubblegum
		0xFFAFB42B, 0xFFCDDC39, // lime
		0xFFFFEB3B, 0xFFFFF176, // lemon
		0xFF795548, 0xFFA1887F, // mystery flavor
    };
	
	CharSequence textText[] = {"satu",
								"dua",
								"tiga",
								"empat",
								"lima",
								"enam",
								"tujuh",
								"delapan",
								"sembilan",
								"sepuluh"};
	CharSequence[] myText = getResources().getTextArray(R.array.mytext);
	Runnable mRunnable = new Runnable()
	{
		@Override
		public void run()
		{
			// TODO: Implement this method
			mText.setText(textText[new Random().nextInt(textText.length)]);
			mText.setTextColor(FLAVORS[new Random().nextInt(FLAVORS.length)]);
		}
	};
	
	public TextTimer(Context c,AttributeSet a)
	{
		super(c,a);
		mHandler = new Handler();
		Thread mThread = new Thread()
		{
			public void run()
			{
				try
				{
					while(true)
					{
						sleep(1000);
						mHandler.post(mRunnable);
					}
				}
				catch(InterruptedException e)
				{}
			}
		};
		mThread.start();
	}
}
