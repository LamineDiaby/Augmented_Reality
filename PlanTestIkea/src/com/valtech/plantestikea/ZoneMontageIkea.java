/**
 * 
 */
package com.valtech.plantestikea;

import android.view.View;

import com.metaio.sdk.MetaioDebug;
import com.metaio.sdk.jni.IGeometry;
import com.metaio.sdk.jni.IMetaioSDKCallback;
import com.metaio.sdk.jni.Vector3d;
import com.metaio.tools.io.AssetsManager;

/**
 * @author mohamed.diaby
 *
 */
public class ZoneMontageIkea extends ARViewActivity {

	/**
	 * 
	 */
	
	private String mTrakingFile;
	private IGeometry mMan;
	private IGeometry mboat;
	
	
	/* (non-Javadoc)
	 * @see com.valtech.plantestikea.ARViewActivity#getGUILayout()
	 */
	@Override
	protected int getGUILayout() {
		// TODO Auto-generated method stub
		return R.layout.ar_view;
	}

	/* (non-Javadoc)
	 * @see com.valtech.plantestikea.ARViewActivity#getMetaioSDKCallbackHandler()
	 */
	@Override
	protected IMetaioSDKCallback getMetaioSDKCallbackHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.valtech.plantestikea.ARViewActivity#loadContents()
	 */
	@Override
	protected void loadContents() {
		// TODO Auto-generated method stub
		
		mTrakingFile = AssetsManager.getAssetPath("Asset1/TrackingData_MarkerlessFast.xml");
		boolean result = metaioSDK.setTrackingConfiguration(mTrakingFile);
		MetaioDebug.log("Id Marker tracking data loaded: " + result);
		
		String modelPath = AssetsManager.getAssetPath("Asset1/metaioman.md2");
		
		if(modelPath != null)
		{
			mMan = metaioSDK.createGeometry(modelPath);
			if(mMan!= null)
			{
				mMan.setScale(new Vector3d(4.0f, 4.0f, 4.0f));
				mMan.setVisible(true);
				MetaioDebug.log("Loaded geometry : " +modelPath);
			}
			else
			{
				MetaioDebug.log("Error loading geometry :"+modelPath);
			}
		}
		
		String modelPath1 = AssetsManager.getAssetPath("Asset1/trackingFile.zip");
		if(modelPath1 != null)
		{
			mboat = metaioSDK.createGeometry(modelPath);
			if(mboat!= null)
			{
				mboat.setScale(new Vector3d(4.0f, 4.0f, 4.0f));
				mboat.setVisible(false);
				MetaioDebug.log("Loaded geometry : " +modelPath);
			}
			else
			{
				MetaioDebug.log("Error loading geometry :"+modelPath);
			}
		}

	}

	/* (non-Javadoc)
	 * @see com.valtech.plantestikea.ARViewActivity#onGeometryTouched(com.metaio.sdk.jni.IGeometry)
	 */
	@Override
	protected void onGeometryTouched(IGeometry geometry) {
		// TODO Auto-generated method stub

	}
	
	public void onManButtonClick(View v)
	{
		mMan.setVisible(true);
		mboat.setVisible(false);
	}
	
	public void onboatButtonClick(View v)
	{
		mMan.setVisible(false);
		mboat.setVisible(true);
	}

}
