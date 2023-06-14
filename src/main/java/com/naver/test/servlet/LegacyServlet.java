package com.naver.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
public class LegacyServlet extends HttpServlet {
    public static List<Integer> list = new ArrayList<Integer>();
    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doHead(req, resp);
    }
    @Override
    public void init() throws ServletException {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String id = req.getParameter("id");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>");
        writer.println("</head>");
        writer.println("<body>");
        if(list.contains(Integer.parseInt(id))){
            for (int i = 0; i < 5; i++) {
                writer.println("<h1>legacy 안녕 세상</h1>");
                writer.println(id + "님 환영하요");
            }
        }else {
            writer.println("돌아가세요");
        }
        writer.println("</body>");
        writer.println("</html>");
        writer.close();
        super.doGet(req, resp);
    }


}