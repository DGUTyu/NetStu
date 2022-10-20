package com.wxdgut.server;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jiajian.yu
 * @program: NetStudy
 * @date 2022-10-20 14:25:48
 * Copyright (c) 2022 http://wxdgut.com
 * Email: hello_luyao@163.com
 * Profile:
 */
public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        doPost(req, resp); //上线时注释掉这句代码即可
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        onResponse(req, resp);
    }

    protected abstract void onResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
