package com.example.bletest;

import android.util.Log;

public class DataUtil {

	public static int ORDER_DATA=3;
	public static int ORDER_ZERO=4;
	public static int ORDER_STANDARD=5;
	public static int ORDER_ABORT=7;
	public static int LIGHT_1=11;
	public static int LIGHT_2=12;
	public static int LIGHT_3=13;
	public static int LIGHT_4=14;
	
	public static String ZERO_YES="ZERO_YES";
	public static String ZERO_NO="ZERO_NO";
	public static String STANDARD_YES="STANDARD_YES";
	public static String STANDARD_NO="STANDARD_NO";
	public static String LIGHT_1_YES="LIGHT_1_YES";
	public static String LIGHT_1_NO="LIGHT_1_NO";
	public static String LIGHT_2_YES="LIGHT_2_YES";
	public static String LIGHT_2_NO="LIGHT_2_NO";
	public static String LIGHT_3_YES="LIGHT_3_YES";
	public static String LIGHT_3_NO="LIGHT_3_NO";
	public static String LIGHT_4_YES="LIGHT_4_YES";
	public static String LIGHT_4_NO="LIGHT_4_NO";
	
	public static byte[] getFirstMessage(){
		byte[] bs=new byte[15];
		bs[0]=-38;
		bs[1]=-38;
		for(int i=2;i<bs.length;i++)
			bs[i]=(byte) ((int)(Math.random()*256)&0xEE);
		bs[bs.length-2]=-34;
		bs[bs.length-1]=-34;
		bs[4]=(byte) ((int)(Math.random()*256)&0xEE<<3);
		bs[2]=(byte) ((int)(Math.random()*256)&0xEE&(-127)|(45<<1));
		System.out.println("第一次发送   "+Integer.toBinaryString((int)(bs[2])));
		return bs;
	}
	
	public static byte[] getWriteBluetoothLight(){
		byte[] bs=new byte[15];
		bs[0]=-38;
		bs[1]=-38;
		for(int i=2;i<bs.length;i++)
			bs[i]=(byte) ((int)(Math.random()*256)&0xEE);
		bs[bs.length-2]=-34;
		bs[bs.length-1]=-34;
		bs[4]=(byte) ((int)(Math.random()*256)&0xEE<<3);
		bs[11]=(byte) ((int)(Math.random()*256)&0xEE&(-127)|(6<<1));
//		System.out.println("蓝牙灯-------:"+bs[2]+"   "+Integer.toBinaryString((int)(bs[11])));
		return bs;
	}
	
	public static byte[] getWriteClear(){
		byte[] bs=new byte[15];
		bs[0]=-38;
		bs[1]=-38;
		for(int i=2;i<bs.length;i++)
			bs[i]=(byte) ((int)(Math.random()*256)&0xEE);
		bs[bs.length-2]=-34;
		bs[bs.length-1]=-34;
		bs[4]=(byte) ((int)(Math.random()*256)&0xEE<<3);
		bs[11]=(byte) ((int)(Math.random()*256)&0xEE&(-127)|(4<<1));
		System.out.println("清零-------:"+bs[2]+"   "+Integer.toBinaryString((int)(bs[11])));
		return bs;
	}
	
	public static byte[] getWriteMark(){
		byte[] bs=new byte[15];
		bs[0]=-38;
		bs[1]=-38;
		for(int i=2;i<bs.length;i++)
			bs[i]=(byte) ((int)(Math.random()*256)&0xEE);
		bs[bs.length-2]=-34;
		bs[bs.length-1]=-34;
		bs[4]=(byte) ((int)(Math.random()*256)&0xEE<<3);
		bs[11]=(byte) ((int)(Math.random()*256)&0xEE&(-127)|(5<<1));
		System.out.println("标记-------:"+bs[2]+"   "+Integer.toBinaryString((int)(bs[11])));
		return bs;
	}
	
	public static byte[] getWriteLight1(){
		byte[] bs=new byte[15];
		bs[0]=-38;
		bs[1]=-38;
		for(int i=2;i<bs.length-2;i++)
			bs[i]=(byte) ((int)(Math.random()*256)&0xEE);
		bs[bs.length-2]=-34;
		bs[bs.length-1]=-34;
		bs[4]=(byte) ((int)(Math.random()*256)&0xEE<<3|0x1);
		bs[11]=(byte) ((int)(Math.random()*256)&0xEE&(-127)|(6<<1));
		System.out.println("加密  灯1:   "+Integer.toBinaryString((int)(bs[4])));
		return bs;
	}
	
	public static byte[] getWriteLight2(){
		byte[] bs=new byte[15];
		bs[0]=-38;
		bs[1]=-38;
		for(int i=2;i<bs.length-2;i++)
			bs[i]=(byte) ((int)(Math.random()*256)&0xEE);
		bs[bs.length-2]=-34;
		bs[bs.length-1]=-34;
		bs[4]=(byte) ((int)(Math.random()*256)&0xEE<<3|0x2);
		bs[11]=(byte) ((int)(Math.random()*256)&0xEE&(-127)|(6<<1));
		System.out.println("加密  灯2:   "+Integer.toBinaryString((int)(bs[4])));
		return bs;
	}
	
	public static byte[] getWriteLight3(){
		byte[] bs=new byte[15];
		bs[0]=-38;
		bs[1]=-38;
		for(int i=2;i<bs.length-2;i++)
			bs[i]=(byte) ((int)(Math.random()*256)&0xEE);
		bs[bs.length-2]=-34;
		bs[bs.length-1]=-34;
		bs[4]=(byte) ((int)(Math.random()*256)&0xEE<<3|0x3);
		bs[11]=(byte) ((int)(Math.random()*256)&0xEE&(-127)|(6<<1));
		System.out.println("加密  灯3:   "+Integer.toBinaryString((int)(bs[4])));
		return bs;
	}
	
	public static byte[] getWriteLight4(){
		byte[] bs=new byte[15];
		bs[0]=-38;
		bs[1]=-38;
		for(int i=2;i<bs.length-2;i++)
			bs[i]=(byte) ((int)(Math.random()*256)&0xEE);
		bs[bs.length-2]=-34;
		bs[bs.length-1]=-34;
		bs[4]=(byte) ((int)(Math.random()*256)&0xEE<<3|0x4);
		bs[11]=(byte) ((int)(Math.random()*256)&0xEE&(-127)|(6<<1));
		System.out.println("加密  灯4:   "+Integer.toBinaryString((int)(bs[4])));
		return bs;
	}
	
	public static byte[] getDataByRandom(byte[] bs,int state) throws Exception{
		
		if(state==ORDER_DATA){
			return arrayRandom(bs,ORDER_DATA);
		}else if(state==ORDER_ZERO){
			return arrayRandom(bs,ORDER_ZERO);
		}else if(state==ORDER_STANDARD){
			return arrayRandom(bs,ORDER_STANDARD);
		}else if(state==LIGHT_1){
			return arrayRandom(bs,LIGHT_1);
		}else if(state==LIGHT_2){
			return arrayRandom(bs,LIGHT_2);
		}else if(state==LIGHT_3){
			return arrayRandom(bs,LIGHT_3);
		}else if(state==LIGHT_4){
			return arrayRandom(bs,LIGHT_4);
		}else{
			throw new Exception("error state");
		}
	}

	public static byte[] arrayRandom(byte[] bs,int state) throws Exception {
		byte[] result=new byte[10];
		switch(getByteRandom(bs[10])){
			case 10:{
				result[0]=bs[0];
				result[1]=bs[7];
				result[2]=bs[3];
				result[3]=bs[6];
				result[4]=bs[5];
				result[5]=bs[1];
				result[6]=bs[8];
				result[7]=bs[4];
				
				result[8]=bs[2];
				result[9]=bs[9];
			}break;
			case 1:{
				result[0]=bs[9];
				result[1]=bs[6];
				result[2]=bs[2];
				result[3]=bs[5];
				result[4]=bs[4];
				result[5]=bs[0];
				result[6]=bs[7];
				result[7]=bs[3];
				
				result[8]=bs[1];
				result[9]=bs[8];
			}break;
			case 2:{
				result[0]=bs[8];
				result[1]=bs[5];
				result[2]=bs[1];
				result[3]=bs[4];
				result[4]=bs[3];
				result[5]=bs[9];
				result[6]=bs[6];
				result[7]=bs[2];
				
				result[8]=bs[0];
				result[9]=bs[7];
			}break;
			case 3:{
				result[0]=bs[7];
				result[1]=bs[4];
				result[2]=bs[0];
				result[3]=bs[3];
				result[4]=bs[2];
				result[5]=bs[8];
				result[6]=bs[5];
				result[7]=bs[1];
				
				result[8]=bs[9];
				result[9]=bs[6];
			}break;
			case 4:{
				result[0]=bs[6];
				result[1]=bs[3];
				result[2]=bs[9];
				result[3]=bs[2];
				result[4]=bs[1];
				result[5]=bs[7];
				result[6]=bs[4];
				result[7]=bs[0];
				
				result[8]=bs[8];
				result[9]=bs[5];
			}break;
			case 5:{
				result[0]=bs[5];
				result[1]=bs[2];
				result[2]=bs[8];
				result[3]=bs[1];
				result[4]=bs[0];
				result[5]=bs[6];
				result[6]=bs[3];
				result[7]=bs[9];
				
				result[8]=bs[7];
				result[9]=bs[4];
			}break;
			case 6:{
				result[0]=bs[4];
				result[1]=bs[1];
				result[2]=bs[7];
				result[3]=bs[0];
				result[4]=bs[9];
				result[5]=bs[5];
				result[6]=bs[2];
				result[7]=bs[8];
				
				result[8]=bs[6];
				result[9]=bs[3];
			}break;
			case 7:{
				result[0]=bs[3];
				result[1]=bs[0];
				result[2]=bs[6];
				result[3]=bs[9];
				result[4]=bs[8];
				result[5]=bs[4];
				result[6]=bs[1];
				result[7]=bs[7];
				
				result[8]=bs[5];
				result[9]=bs[2];
			}break;
			case 8:{
				result[0]=bs[2];
				result[1]=bs[9];
				result[2]=bs[5];
				result[3]=bs[8];
				result[4]=bs[7];
				result[5]=bs[3];
				result[6]=bs[0];
				result[7]=bs[6];
				
				result[8]=bs[4];
				result[9]=bs[1];
			}break;
			case 9:{
				result[0]=bs[1];
				result[1]=bs[8];
				result[2]=bs[4];
				result[3]=bs[7];
				result[4]=bs[6];
				result[5]=bs[2];
				result[6]=bs[9];
				result[7]=bs[5];
				
				result[8]=bs[3];
				result[9]=bs[0];
			}break;
			default:return null;
		}
		result=judgeOrder(result,state);
		return result;
	}

	public static byte[] judgeOrder(byte[] result,int state) throws Exception {
		int order=de_ByteToOrder(result[9]);
		int alarm=de_ByteToAlarm(result[8]);
		if(order==7){
			throw new Exception("abort");
		}
		if(state==ORDER_ZERO){
			//调零成功
			if(order==4){
				result=new String(ZERO_YES).getBytes();
			}else{
				result=new String(ZERO_NO).getBytes();
			}
			return result;
		}else if(state==ORDER_STANDARD){
			//标定成功
			if(order==5){
				result=new String(STANDARD_YES).getBytes();
			}else{
				result=new String(STANDARD_NO).getBytes();
			}
			return result;
		}else if(state==LIGHT_1){
			Log.i("DataUtil", "light_1   "+alarm);
			if(alarm==1){
				result=new String(LIGHT_1_YES).getBytes();
			}else{
				result=new String(LIGHT_1_NO).getBytes();
			}
			return result;
		}else if(state==LIGHT_2){
			Log.i("DataUtil", "light_2   "+alarm);
			if(alarm==2){
				result=new String(LIGHT_2_YES).getBytes();
			}else{
				result=new String(LIGHT_2_NO).getBytes();
			}
			return result;
		}else if(state==LIGHT_3){
			Log.i("DataUtil", "light_3   "+alarm);
			if(alarm==3){
				result=new String(LIGHT_3_YES).getBytes();
			}else{
				result=new String(LIGHT_3_NO).getBytes();
			}
			return result;
		}else if(state==LIGHT_4){
			Log.i("DataUtil", "light_4   "+alarm);
			if(alarm==4){
				result=new String(LIGHT_4_YES).getBytes();
			}else{
				result=new String(LIGHT_4_NO).getBytes();
			}
			return result;
		}else{
			return result;
		}
		
	}
	
	/**
	 * 获取随即数
	 * @param b 随即数所在byte
	 * @return 随即数
	 */
	public static int getByteRandom(byte b){
		int i=(b&15);
//		String str=Integer.toBinaryString(b);
//		str=str.substring(str.length()-4,str.length());
//		System.out.println("随机数：【"+i+"】"+Integer.toHexString(b));
		return i;
	}
	
	/**
	 * 字节转为警报灯号
	 * @param b 传入字节
	 * @return 警报灯号  0 1 2 3
	 */
	public static int de_ByteToAlarm(byte b) {
		String str=Integer.toBinaryString(b|256);
		str=str.substring(str.length()-3,str.length());
		int num=Integer.valueOf(str,2);
		Log.i("thread","alarm-------------二进制转换:"+str);
		return num;
	}
	
	/**
	 * 警报灯号为字节转
	 * @param b 传入报警灯号
	 * @return byte
	 * @throws Exception 命令超出
	 */
	public static byte en_AlarmToByte(int i) throws Exception {
		if(!(i>=0&&i<4)){ throw new Exception("无该命令");}
		i=(int)(Math.random()*31)<<3|i;
//		String str=Integer.toBinaryString(i);
//		str=str.substring(str.length()-8, str.length());
//		System.out.println(str);
		return (byte)i;
	}

	/**
	 * 字节转为命令号
	 * @param b 传入字节
	 * @return 命令号 
	 */
	public static int de_ByteToOrder(byte b) {
		String str=Integer.toBinaryString(b|256);
		str=str.substring(str.length()-7,str.length()-1);
//		System.out.println("Order--------------二进制为:"+str);
		int num=Integer.valueOf(str,2);
//		System.out.println("Order--------------十进制转换:"+num);
		Log.i("thread","Order---------二进制转换："+str);
		return num;
	}
	
	/**
	 * 命令号转为字节
	 * @param i 命令号
	 * @return 字节
	 * @throws Exception 命令超出
	 */
	public static byte en_OrderToByte(int i) throws Exception {
		if(!(i>4&&i<9)){ throw new Exception("无该命令");}
		i=(int)(Math.random()*256)&-127|(i<<1);
//		String str=Integer.toBinaryString(i|256);
//		str=str.substring(str.length()-8, str.length());
//		System.out.println(str);
		return (byte)i;
	}
	
	public static String toHexString1(byte[] b) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < b.length; ++i) {
			buffer.append(toHexString1(b[i]));
		}
		return buffer.toString();
	}

	public static String toHexString1(byte b) {
		String s = Integer.toHexString(b & 0xFF);
		if (s.length() == 1) {
			return "0" + s;
		} else {
			return s;
		}
	}

	public static String toHexString2(byte[] b) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < b.length; ++i) {
			buffer.append(toHexString2(b[i]));
		}
		return buffer.toString();
	}

	public static String toHexString2(byte b) {
		char[] buffer = new char[2];
		buffer[0] = Character.forDigit((b >>> 4) & 0x0F, 16);
		buffer[1] = Character.forDigit(b & 0x0F, 16);
		return new String(buffer);
	}
	
	public static byte uniteBytes(byte src0, byte src1) {
		byte _b0 = Byte.decode("0x" + new String(new byte[] { src0 }))
				.byteValue();
		_b0 = (byte) (_b0 << 4);
		byte _b1 = Byte.decode("0x" + new String(new byte[] { src1 }))
				.byteValue();
		byte ret = (byte) (_b0 ^ _b1);
		return ret;
	}

	public static byte[] HexString2Bytes(String src) {
		byte[] ret = new byte[src.length() / 2];
		byte[] tmp = src.getBytes();
		for (int i = 0; i < tmp.length / 2; i++) {
			ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
		}
		return ret;
	}
}
