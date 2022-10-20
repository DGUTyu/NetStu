package com.wxdgut.server;


import com.alibaba.fastjson.JSON;
import com.wxdgut.server.response.entity.ResponseEntity;
import com.wxdgut.server.response.entity.UserInfoEntitiy;

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
 * Profile:
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends BaseJsonServlet {
    //请求路径：http://localhost:8088/LoginServlet?username=luyao
    //响应 Set-Cookie: username=luyao; Max-Age=10; Expires=Thu, 20-Oct-2022 08:43:05 GMT
    //请求 Cookie: JSESSIONID=0F79D9C3835321269661EDBCC313BAEF; username=luyao
    private static final long serialVersionUID = 1L;

    @Override
    protected ResponseEntity onHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.code = "2023";
        responseEntity.msg = "用户名或密码错误";

        String username = req.getParameter("username");
        //不可以写成 if (username.equals("luyao")) { 因为username为空，服务器会一直报错
        if ("luyao".equals(username)) {
            responseEntity.code = "0001";
            responseEntity.msg = "登录成功";
            //模拟查询用户信息
            UserInfoEntitiy userInfoEntitiy = new UserInfoEntitiy("小余", "男");
            responseEntity.data = JSON.toJSONString(userInfoEntitiy);
            //设置登录cookie,有效期为一天
            Cookie cookie = new Cookie("username", "luyao");
            //cookie.setMaxAge(expiry); //设置cookie的过期事件，时间单位 秒
            cookie.setMaxAge(20);
            resp.addCookie(cookie);
        }
        return responseEntity;
    }
}
