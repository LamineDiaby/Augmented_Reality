// Copyright 2007-2013 metaio GmbH. All rights reserved.
package com.valtech.projetikea;


import android.content.Intent;
import android.view.View;

import com.metaio.sdk.ARELActivity;


public class ARELViewActivity extends ARELActivity 
{
	@Override
	protected int getGUILayout() 
	{
		return R.layout.template;
	}
	
	public void onButtonClick(View v) throws ClassNotFoundException
	{
		super.onStop();
		startActivity(new Intent(getApplicationContext(), Class.forName(getPackageName()+".Zone_Montage3")));;
	}
 
}
