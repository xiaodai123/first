package booksM.com.booksM.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import booksM.com.booksM.common.AuthCode;

public class AuthCodeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String authCode = AuthCode.getAuthCode();  
        response.setCharacterEncoding("UTF-8");
        //设置响应类型
        response.setContentType("image/jpeg");
        //禁止浏览器的缓存
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        response.setHeader("expires", "0");
        
        
        request.getSession().setAttribute("authCode", authCode);    //����֤�뱣�浽session�У������Ժ���֤  
          
        try {  
            //����ͼƬ  
            ImageIO.write(AuthCode.getAuthImg(authCode), "JPEG", response.getOutputStream());  
        } catch (IOException e){  
            e.printStackTrace();  
        }  
	}

}
