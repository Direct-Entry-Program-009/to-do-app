package lk.ijse.dep9.api.util;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class HttpServlet2 extends HttpServlet {
    protected void doPatch(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if(req.getMethod().equalsIgnoreCase("PATCH")){
                doPatch(req,resp);
            }else{
                super.service(req, resp);
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
