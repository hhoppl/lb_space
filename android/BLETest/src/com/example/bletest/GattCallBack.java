package com.example.bletest;

import java.util.List;
import java.util.UUID;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothProfile;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class GattCallBack extends BluetoothGattCallback{

	Handler handler;
	
	public GattCallBack(Handler handler){
		this.handler=handler;
	}
	
	@Override
	public void onConnectionStateChange(BluetoothGatt gatt, int status,
			int newState) {
		Log.i("ble", "onConnectionStateChange");
		super.onConnectionStateChange(gatt, status, newState);
		if (newState == BluetoothProfile.STATE_CONNECTED) {
            Log.i("ble", "Connected to GATT server.");
            System.out.println("========================"+gatt.discoverServices());
        } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
            Log.i("ble", "Disconnected from GATT server.");
        }
	}
	
	@Override
	public void onServicesDiscovered(BluetoothGatt gatt, int status) {
		super.onServicesDiscovered(gatt, status);
		Log.i("ble", "onServicesDiscovered");
		if (status == BluetoothGatt.GATT_SUCCESS) {
			Log.i("ble", "GATT_SUCCESS");
			List<BluetoothGattService> list_BleService=gatt.getServices();
			System.out.println("====BluetoothGattServiceSize:"+list_BleService.size());
			for(BluetoothGattService service : list_BleService){
				List<BluetoothGattCharacteristic> list_Characteristic=service.getCharacteristics();
				System.out.println("====ServiceUUid:"+service.getUuid()+"====CharacteristicSize:"+list_Characteristic.size());
				for(BluetoothGattCharacteristic characteristic : list_Characteristic){
					gatt.setCharacteristicNotification(characteristic, true);
					System.out.println("====CharacteristicUUid:"+characteristic.getUuid());
//					List<BluetoothGattDescriptor> list_Descriptor=characteristic.getDescriptors();
//					for (BluetoothGattDescriptor descriptor : list_Descriptor) {
//						System.out.println("==========BluetoothGattDescriptor=============="+descriptor.getUuid());
//						
//					}
				}
			}
			
        } else {
            Log.i("ble", "onServicesDiscovered received: " + status);
        }
	}
	
	@Override
	public void onCharacteristicRead(BluetoothGatt gatt,
			BluetoothGattCharacteristic characteristic, int status) {
		super.onCharacteristicRead(gatt, characteristic, status);
		Log.i("ble", "onCharacteristicRead");
		 if (status == BluetoothGatt.GATT_SUCCESS) {
         }
	}
	
	@Override
	public void onCharacteristicChanged(BluetoothGatt gatt,
			BluetoothGattCharacteristic characteristic) {
		super.onCharacteristicChanged(gatt, characteristic);
		
		Log.i("ble", "onCharacteristicChanged received: " + new String(characteristic.getValue()));
		Message me=handler.obtainMessage();
		me.what=0;
		me.obj=new String(characteristic.getValue());
		me.sendToTarget();
		
	}
}
