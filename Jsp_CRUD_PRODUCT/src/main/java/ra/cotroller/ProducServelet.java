package ra.cotroller;

import ra.model.Service.ProductService;
import ra.model.ServiceImp.ProductServiceImp;
import ra.model.entity.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProducServelet", value = "/ProducServelet")
public class ProducServelet extends HttpServlet {
    private ProductService<Product, String> productService = new ProductServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("update")) {
            String productId = request.getParameter("productId");
            Product productUpdate = productService.getById(productId);
            request.setAttribute("productupdate", productUpdate);
            request.getRequestDispatcher("views/updateproduct.jsp").forward(request, response);
        } else if (action != null && action.equals("delete")) {
            String productId = request.getParameter("productId");
            boolean result = productService.delete(productId);
            if (result) {
                getAllProduct(request, response);
            } else {
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
            }
        } else if (action != null && action.equals("search")) {
            String productSearch = request.getParameter("productsearch");
            request.setAttribute("listproduct", productService.searchProductByName(productSearch));
            request.getRequestDispatcher("views/product.jsp").forward(request, response);
        } else if (action != null && action.equals("category")) {
            getAllProduct(request,response);
        } else {
            request.getRequestDispatcher("views/index.jsp").forward(request,response);
        }
    }

    public void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> listProduct = productService.getAll();
        request.setAttribute("listproduct", listProduct);
        request.getRequestDispatcher("views/product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        Product pro = new Product();
        pro.setProductId(request.getParameter("productId"));
        pro.setProductName(request.getParameter("productName"));
        pro.setPrice(Float.parseFloat(request.getParameter("price")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            pro.setDateCreated(sdf.parse(request.getParameter("dateCreated")));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        pro.setDescriptions(request.getParameter("descriptions"));
        pro.setProductStatus(Boolean.parseBoolean(request.getParameter("productStatus")));
        if (action != null && action.equals("Create")) {
            boolean result = productService.save(pro);
            if (result) {
                getAllProduct(request, response);
            } else {
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
            }
        } else if (action != null && action.equals("update")) {
            boolean result = productService.update(pro);
            if (result) {
                getAllProduct(request, response);
            } else {
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
            }
        }
    }
}
