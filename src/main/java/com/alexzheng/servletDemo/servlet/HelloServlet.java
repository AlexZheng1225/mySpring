package com.alexzheng.servletDemo.servlet;

import com.alexzheng.servletDemo.service.HelloService;
import com.alexzheng.servletDemo.service.impl.HelloServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Alex Zheng
 * @Date 2021/2/23 20:16
 * @Annotation
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    private HelloService helloService = new HelloServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(this.helloService.findAll().toString());
    }
}
