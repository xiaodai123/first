package booksM.com.booksM.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class AuthCode {
	public static final int AUTHCODE_LENGTH = 4;        //锟斤拷证锟诫长锟斤拷  
    public static final int SINGLECODE_WIDTH = 15;  //锟斤拷锟斤拷锟斤拷证锟斤拷锟斤拷  
    public static final int SINGLECODE_HEIGHT = 30; //锟斤拷锟斤拷锟斤拷证锟斤拷叨锟� 
    public static final int SINGLECODE_GAP = 4;     //锟斤拷锟斤拷锟斤拷证锟斤拷之锟斤拷锟斤拷  
    public static final int IMG_WIDTH = AUTHCODE_LENGTH * (SINGLECODE_WIDTH + SINGLECODE_GAP);  
    public static final int IMG_HEIGHT = SINGLECODE_HEIGHT;  
      
    public static String getAuthCode() {  
        String authCode = "";  
        for(int i = 0; i < AUTHCODE_LENGTH; i++) {  
            authCode += (new Random()).nextInt(10);  
        }  
        return authCode;  
    }  
      
    public static BufferedImage getAuthImg(String authCode) {  
        //锟斤拷锟斤拷图片锟侥高★拷锟�锟斤拷锟斤拷  
        //RGB锟斤拷锟诫：red锟斤拷green锟斤拷blue  
        BufferedImage img = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_BGR);  
        //锟矫碉拷图片锟较碉拷一锟斤拷锟斤拷锟斤拷  
        Graphics g = img.getGraphics();  
        //锟斤拷锟矫伙拷锟绞碉拷锟斤拷色锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷色  
        g.setColor(Color.YELLOW);  
        //锟矫伙拷锟斤拷锟斤拷锟斤拷锟揭伙拷锟斤拷锟斤拷危锟斤拷锟斤拷蔚锟斤拷锟斤拷辖锟斤拷锟疥，锟�锟斤拷  
        g.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);  
        //锟斤拷锟斤拷锟斤拷锟斤拷色锟斤拷锟斤拷为锟斤拷色锟斤拷锟斤拷锟斤拷写锟斤拷  
        g.setColor(Color.BLACK);  
        //锟斤拷锟斤拷锟斤拷锟藉：锟斤拷锟藉、锟斤拷锟斤拷锟绞斤拷摹锟斤拷趾锟� 
        g.setFont(new Font("锟斤拷锟斤拷", Font.PLAIN, SINGLECODE_HEIGHT + 5));  
          
        //锟斤拷锟斤拷锟斤拷锟� 
        char c;  
        for(int i = 0; i < authCode.toCharArray().length; i++) {  
            //取锟斤拷锟斤拷应位锟矫碉拷锟街凤拷  
            c = authCode.charAt(i);  
            //锟斤拷锟斤拷一锟斤拷锟街凤拷要锟斤拷锟斤拷锟斤拷锟捷ｏ拷锟斤拷始锟斤拷位锟矫ｏ拷锟竭讹拷  
            g.drawString(c + "", i * (SINGLECODE_WIDTH + SINGLECODE_GAP)+ SINGLECODE_GAP / 2, IMG_HEIGHT);  
        }  
        Random random = new Random();  
        //锟斤拷锟斤拷锟斤拷  
        for(int i = 0; i < 20; i++) {  
            int x = random.nextInt(IMG_WIDTH);  
            int y = random.nextInt(IMG_HEIGHT);  
            int x2 = random.nextInt(IMG_WIDTH);  
            int y2 = random.nextInt(IMG_HEIGHT);  
            g.drawLine(x, y, x + x2, y + y2);  
        }  
        return img;  
    }  
}  

