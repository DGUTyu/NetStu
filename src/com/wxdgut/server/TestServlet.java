package com.wxdgut.server;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author jiajian.yu
 * @program: NetStudy
 * @date 2022-10-20 13:51:48
 * Copyright (c) 2022 http://wxdgut.com
 * Email: hello_luyao@163.com
 * Profile:测试HttpServlet
 */
//访问路径：http://localhost:8088/TestServlet
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        doPost(req, resp); //上线时注释掉这句代码即可
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("test");
        printWriter.flush();
        printWriter.close();
    }
}
