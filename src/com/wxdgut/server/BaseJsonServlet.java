package com.wxdgut.server;

import com.alibaba.fastjson.JSON;
import com.wxdgut.server.response.entity.ResponseEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author jiajian.yu
 * @program: NetStudy
 * @date 2022-10-20 14:29:37
 * Copyright (c) 2022 http://wxdgut.com
 * Email: hello_luyao@163.com
 * Profile:专门处理json的基类
 */
public abstract class BaseJsonServlet extends BaseServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void onResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8"); //响应头
        //处理子类
        ResponseEntity entity = null;
        try {
            entity = onHandler(req, resp);
        } catch (Exception e) {
            entity = new ResponseEntity();
        }
        PrintWriter printWriter = resp.getWriter();
        //把复制到NetStudy\web\WEB-INF\lib目录下，不需要做其他事情
        String responseJsonStr = JSON.toJSONString(entity);
        printWriter.write(responseJsonStr);
        printWriter.flush();
        printWriter.close();
    }

    protected abstract ResponseEntity onHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
