package servlet;

import tools.GetOfHttps;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by haiseer on 2018/2/26.
 */
public class UserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("微信打印code（"+request.getParameter("code")+")"+new Date().toLocaleString());
        String code=request.getParameter("code");
        String res=GetOfHttps.httpsRequest("https://api.weixin.qq.com/sns/jscode2session?appid=wxc846652276d3609f&secret=1d00f19ec92b1add2a5658913f39be53&js_code="+code+"&grant_type=authorization_code","GET",null);
        //String res=GetOfHttps.httpsRequest("https://www.baidu.com","GET",null);
        System.out.println(res);
        response.setContentType("Json");
        response.sendRedirect("type1_1.jsp");
    }
}
