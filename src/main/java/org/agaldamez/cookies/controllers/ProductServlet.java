package org.agaldamez.cookies.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.agaldamez.cookies.models.Product;
import org.agaldamez.cookies.service.LoginService;
import org.agaldamez.cookies.service.LoginServiceImpl;
import org.agaldamez.cookies.service.ProductService;
import org.agaldamez.cookies.service.ProductServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productos.html", "/productos"})
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService service = new ProductServiceImpl();
        List<Product> productList = service.listar();

        LoginService login = new LoginServiceImpl();
        Optional<String> cookieOp = login.getUsername(req);

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("     <head>");
            out.println("         <meta charset=\"UTF-8\">");
            out.println("         <title></title>");
            out.println("     </head>");
            out.println("     <body>");
            out.println("           <h1>Listado de Productos!!</h1>");
            cookieOp.ifPresent(s -> out.println("<div>Hola " + s + " bienvenido</div>"));
            out.println("         <table>");
            out.println("               <tr>");
            out.println("                   <th>id</th>");
            out.println("                   <th>Nombre</th>");
            out.println("                   <th>Tipo</th>");
            if (cookieOp.isPresent()) {
                out.println("               <th>Precio</th>");
            }
            productList.forEach(p -> {
                out.println("           <tr>");
                out.println("               <td>" + p.getId() + "</td>");
                out.println("               <td>" + p.getName() + "</td>");
                out.println("               <td>" + p.getType() + "</td>");
                if (cookieOp.isPresent()) {
                    out.println("               <td>" + p.getPrice() + "</td>");
                }
                out.println("           </tr>");
            });
            out.println("               </tr>");
            out.println("         </table>");
            out.println("     </body>");
            out.println("<html>");
        }
    }
}
