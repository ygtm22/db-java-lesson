package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enitity.Product;
import service.ProductService;
import util.ParamUtil;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        String productName = request.getParameter("productName");
        Integer price = ParamUtil.checkAndParseInt(request.getParameter("price"));

        // ログインチェック
        ProductService productService = new ProductService();
        
        Product product = new Product(null, productName, price);
        
        List<Product> list = productService.find(product);
        
        // 表示メッセージの受け渡し
        if (list.isEmpty()) {
            request.setAttribute("msg", "対象のデータはありません");

            // 次画面指定
            request.getRequestDispatcher("/top.jsp").forward(request, response);
        } else {
            // メッセージ設定
            request.setAttribute("list", list);

            // 次画面指定
            request.getRequestDispatcher("/searchResult.jsp").forward(request, response);
        }
    }
}
