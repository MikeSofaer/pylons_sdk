package com.pylons.client; // idk
import com.unity3d.player.UnityPlayerActivity;
import android.content.*;
import android.os.Bundle;
import android.util.Log;
import android.app.PendingIntent;
import android.app.IntentService;
import java.lang.ref.WeakReference;
import java.util.Random;


public class UnityAndroidBridgeActivity extends UnityPlayerActivity {
	final static String ACTION_INVOKE_WALLET_SERVICE = "com.pylons.action.INVOKE_WALLET";
	final static String ACTION_INVOKE_WALLET_UI = "com.pylons.action.INVOKE_WALLET_UI";
	final static String ACTION_REQUIRE_WALLET_UI = "com.pylons.action.REQUIRE_WALLET_UI";
	final static String ACTION_RETURN_TO_CLIENT = "com.pylons.action.RETURN_TO_CLIENT";
	final static String ACTION_PASS_DATA_TO_SHIM = "com.pylons.action.WALLET_SERVICE_RETURN_DATA_TO_CLIENT";
	protected static WeakReference<UnityAndroidBridgeActivity> thisActivityReference;
	private Intent m_data;
	protected boolean messageReady;
	static final String magicKeyPrefix = "_@P";
	
	public static class ReceptorService extends IntentService {
		
		public ReceptorService () {
			super("ReceptorService");
		}
		
		@Override
		public void onHandleIntent (Intent intent) {
			// This is heavier than it needs to be but dealing with system-managed broadcasts is a _headache_
			Intent inner = intent.getParcelableExtra("_@PINNER");
			Log.i("ReceptorService.onHandleIntent", inner.getAction());
			switch (inner.getAction()) {
				case ACTION_REQUIRE_WALLET_UI:
					IntentData.startActivityForResultWithPreparedIntent(0);
					break;
				case ACTION_RETURN_TO_CLIENT:
					thisActivityReference.get().finalizeMessage(inner);
					break;
			}
		}
		
	}
	
	public static class IntentData {	
		private static Intent outgoingIntent;
		
		public static boolean[] getBooleanArrayExtra (String name) {
			return thisActivityReference.get().m_data.getBooleanArrayExtra(name);
		}
		
		public static String[] getBooleanArrayExtrasKeys () {
			return thisActivityReference.get().m_data.getStringArrayExtra("_@PKEYS_BOOLEAN[]");
		}
		
		public static boolean getBooleanExtra (String name, boolean defaultValue) {
			return thisActivityReference.get().m_data.getBooleanExtra(name, defaultValue);
		}
		
		public static String[] getBooleanExtrasKeys () {
			return thisActivityReference.get().m_data.getStringArrayExtra("_@PKEYS_BOOLEAN");
		}
		
		public static byte[] getByteArrayExtra (String name) {
			return thisActivityReference.get().m_data.getByteArrayExtra(name);
		}
		
		public static String[] getByteArrayExtrasKeys () {
			return thisActivityReference.get().m_data.getStringArrayExtra("_@PKEYS_BYTE[]");
		}
		
		public static byte getByteExtra (String name, byte defaultValue) {
			return thisActivityReference.get().m_data.getByteExtra(name, defaultValue);
		}
		
		public static String[] getByteExtrasKeys () {
			return thisActivityReference.get().m_data.getStringArrayExtra("_@PKEYS_BYTE");
		}
		
		public static char[] getCharArrayExtra (String name) {
			return thisActivityReference.get().m_data.getCharArrayExtra(name);
		}
		
		public static String[] getCharArrayExtrasKeys () {
			return thisActivityReference.get().m_data.getStringArrayExtra("_@PKEYS_CHAR[]");
		}
		
		public static char getCharExtra (String name, char defaultValue) {
			return thisActivityReference.get().m_data.getCharExtra(name, defaultValue);
		}
		
		public static String[] getCharExtrasKeys () {
			return thisActivityReference.get().m_data.getStringArrayExtra("_@PKEYS_CHAR");
		}
		
		public static double[] getDoubleArrayExtra (String name) {
			return thisActivityReference.get().m_data.getDoubleArrayExtra(name);
		}
		
		public static String[] getDoubleArrayExtrasKeys () {
			return thisActivityReference.get().m_data.getStringArrayExtra("_@PKEYS_DOUBLE[]");
		}
		
		public static double getDoubleExtra (String name, double defaultValue) {
			return thisActivityReference.get().m_data.getDoubleExtra(name, defaultValue);
		}
		
		public static String[] getDoubleExtrasKeys () {
			return thisActivityReference.get().m_data.getStringArrayExtra("_@PKEYS_DOUBLE");
		}
		
		public static float[] getFloatArrayExtra (String name) {
			return thisActivityReference.get().m_data.getFloatArrayExtra(name);
		}
		
		public static String[] getFloatArrayExtrasKeys () {
			return thisActivityReference.get().m_data.getStringArrayExtra("_@PKEYS_FLOAT[]");
		}
		
		public static float getFloatExtra (String name, float defaultValue) {
			return thisActivityReference.get().m_data.getFloatExtra(name, defaultValue);
		}
		
		public static String[] getFloatExtrasKeys () {
			return thisActivityReference.get().m_data.getStringArrayExtra("_@PKEYS_FLOAT");
		}
		
		public static int[] getIntArrayExtra (String name) {
			return thisActivityReference.get().m_data.getIntArrayExtra(name);
		}
		
		public static String[] getIntArrayExtrasKeys () {
			return thisActivityReference.get().m_data.getStringArrayExtra("_@PKEYS_INT[]");
		}
		
		public static int getIntExtra (String name, int defaultValue) {
			return thisActivityReference.get().m_data.getIntExtra(name, defaultValue);
		}
		
		public static String[] getIntExtrasKeys () {
			return thisActivityReference.get().m_data.getStringArrayExtra("_@PKEYS_INT");
		}
		
		public static long[] getLongArrayExtra (String name) {
			return thisActivityReference.get().m_data.getLongArrayExtra(name);
		}
		
		public static String[] getLongArrayExtrasKeys () {
			return thisActivityReference.get().m_data.getStringArrayExtra("_@PKEYS_LONG[]");
		}
		
		public static long getLongExtra (String name, long defaultValue) {
			return thisActivityReference.get().m_data.getLongExtra(name, defaultValue);
		}
		
		public static String[] getLongExtrasKeys () {
			return thisActivityReference.get().m_data.getStringArrayExtra("_@PKEYS_LONG");
		}
		
		public static short[] getShortArrayExtra (String name) {
			return thisActivityReference.get().m_data.getShortArrayExtra(name);
		}
		
		public static String[] getShortArrayExtrasKeys () {
			return thisActivityReference.get().m_data.getStringArrayExtra("_@PKEYS_SHORT[]");
		}
		
		public static short getShortExtra (String name, short defaultValue) {
			return thisActivityReference.get().m_data.getShortExtra(name, defaultValue);
		}
		
		public static String[] getShortExtrasKeys () {
			return thisActivityReference.get().m_data.getStringArrayExtra("_@PKEYS_SHORT");
		}
		
		public static String[] getStringArrayExtra (String name) {
			return thisActivityReference.get().m_data.getStringArrayExtra(name);
		}
		
		public static String[] getStringArrayExtrasKeys () {
			return thisActivityReference.get().m_data.getStringArrayExtra("_@PKEYS_STRING[]");
		}
		
		public static String getStringExtra (String name) {
			return thisActivityReference.get().m_data.getStringExtra(name);
		}
		
		public static String[] getStringExtrasKeys () {
			return thisActivityReference.get().m_data.getStringArrayExtra("_@PKEYS_STRING");
		}
		
		public static boolean hasExtra (String name) {
			return thisActivityReference.get().m_data.hasExtra(name);
		}
		
		public static boolean isIncomingMessageReady () {
			return thisActivityReference.get().messageReady;
		}
		
		public static void prepareNewIntent () { 
			thisActivityReference.get().messageReady = false;
			outgoingIntent = new Intent();
			//outgoingIntent.putExtra("_@PORIGIN", new ComponentName(thisActivityReference.get().getApplicationContext(), Receiver.class));
		}
		
		public static void putExtra (String name, boolean[] value) {
			outgoingIntent.putExtra(name, value);
		}
		
		public static void putExtra (String name, boolean value) {
			outgoingIntent.putExtra(name, value);
		}
		
		public static void putExtra (String name, byte[] value) {
			outgoingIntent.putExtra(name, value);
		}
		
		public static void putExtra (String name, byte value) {
			outgoingIntent.putExtra(name, value);
		}
		
		public static void putExtra (String name, char[] value) {
			outgoingIntent.putExtra(name, value);
		}
		
		public static void putExtra (String name, char value) {
			outgoingIntent.putExtra(name, value);
		}
		
		public static void putExtra (String name, double[] value) {
			outgoingIntent.putExtra(name, value);
		}
		
		public static void putExtra (String name, double value) {
			outgoingIntent.putExtra(name, value);
		}
		
		public static void putExtra (String name, float[] value) {
			outgoingIntent.putExtra(name, value);
		}
		
		public static void putExtra (String name, float value) {
			outgoingIntent.putExtra(name, value);
		}
		
		public static void putExtra (String name, int[] value) {
			outgoingIntent.putExtra(name, value);
		}
		
		public static void putExtra (String name, int value) {
			outgoingIntent.putExtra(name, value);
		}
		
		public static void putExtra (String name, long[] value) {
			outgoingIntent.putExtra(name, value);
		}
		
		public static void putExtra (String name, long value) {
			outgoingIntent.putExtra(name, value);
		}
		
		public static void putExtra (String name, short[] value) {
			outgoingIntent.putExtra(name, value);
		}
		
		public static void putExtra (String name, short value) {
			outgoingIntent.putExtra(name, value);
		}
		
		public static void putExtra (String name, String[] value) {
			outgoingIntent.putExtra(name, value);
		}
		
		public static void putExtra (String name, String value) {
			outgoingIntent.putExtra(name, value);
		}
		
		public static void startActivityForResultWithPreparedIntent (int requestCode) {
			outgoingIntent.setAction(ACTION_INVOKE_WALLET_UI);
			outgoingIntent.setClassName("com.pylons.wallet", "com.pylons.wallet.MainActivity");
			thisActivityReference.get().startActivityForResult(outgoingIntent, requestCode);
		}
		
		
		public static void invokeServiceWithPreparedIntent () {
			Intent p = new Intent(ACTION_PASS_DATA_TO_SHIM);
			p.setClass(thisActivityReference.get().getApplicationContext(), ReceptorService.class);
			outgoingIntent.putExtra("_@PPENDING", PendingIntent.getService(thisActivityReference.get().getApplicationContext(), 0, p, PendingIntent.FLAG_ONE_SHOT & PendingIntent.FLAG_CANCEL_CURRENT));
			outgoingIntent.setAction(ACTION_INVOKE_WALLET_SERVICE);
			outgoingIntent.setClassName("com.pylons.wallet", "com.pylons.wallet.WalletService");
			thisActivityReference.get().getApplicationContext().startForegroundService(outgoingIntent);
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		thisActivityReference = new WeakReference<UnityAndroidBridgeActivity>(this);
		super.onCreate(savedInstanceState);	
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		finalizeMessage(data);
  }
  
  protected void finalizeMessage(Intent data) {
	  	messageReady = true;
		m_data = data;
		// Log.i("info", m_data.getStringExtra("info"));
  }
}