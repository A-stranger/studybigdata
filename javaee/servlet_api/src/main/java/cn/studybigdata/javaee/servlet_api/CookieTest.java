package cn.studybigdata.javaee.servlet_api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cookie
 */
public class CookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieTest() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("utf-8");
		Cookie c1 = new Cookie("username","zhangsan");
		Cookie advId = new Cookie("advertisementId","999999");
		response.addCookie(c1);
		response.addCookie(advId);
		response.getWriter().append("给你确定个广告ID：");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("utf-8");

		Cookie [] cookies = request.getCookies();
		for(Cookie c: cookies){
			if(c.getName().equals("advertisementId") & c.getValue().equals("999999")){
				response.getWriter().append("小张啊，据我了解你喜欢买电子产品，我给你推荐个新款的华为Mate60手机！");
			}
			if(c.getName().equals("advertisementId") & c.getValue().equals("888888")){
				response.getWriter().append("小李啊，据我了解你喜欢买化妆品，我给你推荐个面膜！");
			}
		}
	}
}
