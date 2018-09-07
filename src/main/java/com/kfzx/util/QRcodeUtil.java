/*
package com.kfzx.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class QRcodeUtil {
	
	*/
/**
	 * 0-40  =3____   41-60=4______   60-82=5_____       83- 105= 6
	 * 106-120= 7___   120-140=8   140-160=9   160-180 = 10    180-200 = 11
	 * 
	 * @param content
	 * @return
	 *//*

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float f = Float.valueOf(120-40)/Float.valueOf(20);
		f = (float) Math.ceil(f);
		int i = (int) (f + 3);
		System.out.println(i);//+3
	}
	
	*/
/**
	 * ���ɶ�ά��(QRCode)ͼƬ�Ĺ�������
	 *  content �洢���� 
	 *  imgType ͼƬ����   jpg
	 *  size ��ά��ߴ�size = "4";
	 * 
	 *//*

	public static  BufferedImage qRCodeCommon(String content, String imgType, int size) {
		BufferedImage bufImg = null;
		try {
			Qrcode qrcodeHandler = new Qrcode();
			// ���ö�ά���Ŵ��ʣ���ѡL(7%)��M(15%)��Q(25%)��H(30%)���Ŵ���Խ�߿ɴ洢����ϢԽ�٣����Զ�ά�������ȵ�Ҫ��ԽС
			qrcodeHandler.setQrcodeErrorCorrect('M');
			qrcodeHandler.setQrcodeEncodeMode('B');
			// �������ö�ά��ߴ磬ȡֵ��Χ1-40��ֵԽ��ߴ�Խ�󣬿ɴ洢����ϢԽ��
			qrcodeHandler.setQrcodeVersion(size);
			// ������ݵ��ֽ����飬���ñ����ʽ
			byte[] contentBytes = content.getBytes("utf-8");
			// ͼƬ�ߴ�
			int imgSize = 67 + 12 * (size - 1);
			bufImg = new BufferedImage(imgSize, imgSize, BufferedImage.TYPE_INT_RGB);
			Graphics2D gs = bufImg.createGraphics();
			// ���ñ�����ɫ
			gs.setBackground(Color.WHITE);
			gs.clearRect(0, 0, imgSize, imgSize);

			// �趨ͼ����ɫ> BLACK
			gs.setColor(Color.BLACK);
			// ����ƫ�����������ÿ��ܵ��½�������
			int pixoff = 2;
			// �������> ��ά��
			if (contentBytes.length > 0 && contentBytes.length < 800) {
				boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);
				for (int i = 0; i < codeOut.length; i++) {
					for (int j = 0; j < codeOut.length; j++) {
						if (codeOut[j][i]) {
							gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
						}
					}
				}
			} else {
				throw new Exception("QRCode content bytes length = " + contentBytes.length + " not in [0, 800].");
			}
			gs.dispose();
			bufImg.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bufImg;
	}
	
	
	*/
/**
	 * 0-40  =3____   40-60=4______   60-80=5_____       80- 100= 6
	 * 100-120  =7____   120-140=8______   140-180=9_____      
	 * @param content
	 * @return
	 *//*

	public static int getSize(String content){
		int defaultSize = 3 ;
		
		if(content.length()<40){
			return defaultSize;
		}
		
		float f = Float.valueOf(content.length()-40)/Float.valueOf(20);
		f = (float) Math.ceil(f);
		int i = (int) (f + 3);
		
		return i;
	}
	

}
*/
