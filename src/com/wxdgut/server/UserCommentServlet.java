package com.wxdgut.server;




import com.wxdgut.server.response.entity.ResponseEntity;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jiajian.yu
 * @program: NetStudy
 * @date 2022-10-20 14:43:26
 * Copyright (c) 2022 http://wxdgut.com
 * Email: hello_luyao@163.com
 * Profile: 用户发表评论的Servlet
 */
@WebServlet("/UserCommentServlet")
public class UserCommentServlet extends BaseJsonServlet {
    //请求路径：http://localhost:8088/LoginServlet?username=luyao
    //响应 Set-Cookie: username=luyao; Max-Age=10; Expires=Thu, 20-Oct-2022 08:43:05 GMT
    //请求 Cookie: JSESSIONID=0F79D9C3835321269661EDBCC313BAEF; username=luyao
    private static final long serialVersionUID = 1L;

    @Override
    protected ResponseEntity onHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        // 判断该用户有没有登录，没有登录或者登录过期都不让评论
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.code = "0033";
        responseEntity.msg = "评论失败，用户未登录";

        Cookie[] cookies = req.getCookies();
        //cookies默认有一个cookie：JSESSIONID 故 >1 cookie最多只有2个
        if (cookies != null && cookies.length > 1) {
            //getName()取的是username，getValue()取的是luyao1
            String userName = cookies[1].getValue();
            if (userName != null) {
                responseEntity.code = "0000";
                responseEntity.msg = userName + "评论成功";
                return responseEntity;
            }
        }
        return responseEntity;
    }
}
