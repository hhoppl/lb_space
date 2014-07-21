package com.example.bletest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnMenuItemClickListener,OnItemClickListener,LeScanCallback,View.OnClickListener{

	BluetoothAdapter bluetoothAdapter;
	ListView listView;
	ArrayAdapter<String> arrayAdapter;
	ArrayList<String> dataList;
	HashMap<String,BluetoothDevice> deviceMap;
	
	final static String UUID_CHARACTERISTIC="0000ffe1-0000-1000-8000-00805f9b34fb";
	final static String UUID_SERVICE="0000ffe0-0000-1000-8000-00805f9b34fb";
	
	GattCallBack gattCallBack;
	BluetoothGatt gatt;
	
	Button but_write;
	EditText edit_mes;
	TextView text_receive,text_rssi;
	
	Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
				case 0:{//更新接收数据
					text_receive.setText("接收值："+msg.obj.toString());
				}break;
				case 1:{//刷新listview
					arrayAdapter.notifyDataSetChanged();
				}break;
				default:
				break;
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		but_write=(Button) findViewById(R.id.but_write);
		but_write.setOnClickListener(this);
		edit_mes=(EditText) findViewById(R.id.editText);
		text_receive=(TextView) findViewById(R.id.textView_receive);
		text_rssi=(TextView) findViewById(R.id.rssi);
		
		BluetoothManager manager=(BluetoothManager) getSystemService(BLUETOOTH_SERVICE);
		bluetoothAdapter=manager.getAdapter();
		
		if(bluetoothAdapter==null){
			Toast.makeText(this, "无蓝牙", Toast.LENGTH_SHORT).show();
		}else if(bluetoothAdapter.isEnabled()){
			Intent in=new Intent();
			in.setAction(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(in, 1);
		}
		
		deviceMap=new HashMap<String, BluetoothDevice>();
		dataList=new ArrayList<String>();
		arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataList);
		listView=(ListView) findViewById(R.id.listView);
		listView.setAdapter(arrayAdapter);
		listView.setOnItemClickListener(this);
		
		gattCallBack=new GattCallBack(handler);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		for (int i = 0; i < menu.size(); i++) {
			menu.getItem(i).setOnMenuItemClickListener(this);
		} 
		return true;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==1){
			if(resultCode==RESULT_OK){
				Toast.makeText(this, "蓝牙开启", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(this, "蓝牙未开启", Toast.LENGTH_SHORT).show();
			}
		}
	}

	@Override
	public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
		Log.i("bluetooth",rssi+"     "+device.getName()+"     "+ device.getAddress());
		if(!deviceMap.containsKey(device.getName())){
			dataList.add(device.getName());
			deviceMap.put(device.getName(), device);
			handler.sendEmptyMessage(1);
		}else{
			text_rssi.setText(""+rssi);
		}
	}

	boolean isScaning=false;
	@Override
	public boolean onMenuItemClick(MenuItem arg0) {
		switch (arg0.getItemId()) {
		case R.id.scan: {
			Log.i("bluetooth", "scan Click");
			
			Set<BluetoothDevice> set_device=bluetoothAdapter.getBondedDevices();
			
			if (!isScaning) {
				handler.postDelayed(new Runnable() {
					public void run() {
						isScaning = false;
						bluetoothAdapter.stopLeScan(MainActivity.this);
					}
				}, 10000);
				bluetoothAdapter.startLeScan(this);
				dataList.clear();
				deviceMap.clear();
				handler.sendEmptyMessage(1);
				isScaning = true;
			} else {
				isScaning = false;
				bluetoothAdapter.stopLeScan(MainActivity.this);
			}
		}
			break;
		case R.id.disconnect:{
			if(gatt!=null){
				gatt.disconnect();
				gatt=null;
			}
		}break;
		default:
			break;
		}
		return false;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		gatt=deviceMap.get(dataList.get(arg2)).connectGatt(this, true, gattCallBack);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.but_write:{
			if(gatt!=null){
				BluetoothGattService service=gatt.getService(java.util.UUID.fromString(UUID_SERVICE));
				BluetoothGattCharacteristic characteristic=service.getCharacteristic(java.util.UUID.fromString(UUID_CHARACTERISTIC));
				if(edit_mes.getText().length()<1){
					characteristic.setValue(DataUtil.getWriteBluetoothLight());
					System.out.println(new String(DataUtil.getWriteBluetoothLight()));
				}else{
					characteristic.setValue(edit_mes.getText().toString().getBytes());
				}
				gatt.writeCharacteristic(characteristic);
			}
		}break;
		default:
			break;
		}
	}
	
}
