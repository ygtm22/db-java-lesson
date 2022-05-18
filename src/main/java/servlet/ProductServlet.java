package servlet;

import java.io.IOException;

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

        
        Integer productId = ParamUtil.checkAndParseInt(request.getParameter("productId"));

       
        if (productId == null) {
            // メッセージ設定
            request.setAttribute("msg", "product_idを入力してください。  ");

            // 次画面指定
            request.getRequestDispatcher("/top.jsp").forward(request, response);
            return;
        }

        
        ProductService productService = new ProductService();
        Product product = productService.findByProductId(productId);

        // 表示メッセージの受け渡し
        if (product == null) {
            // メッセージ設定
        	request.setAttribute("msg", "対象のデータはありませんでした。  ");

            // 次画面指定
        	request.getRequestDispatcher("/top.jsp").forward(request, response);
        } else {
            // メッセージ設定
        	request.setAttribute("msg", "データを取得しました。  ");
        	request.setAttribute("product", product);

            // 次画面指定
        	request.getRequestDispatcher("/searchResult.jsp").forward(request, response);  
        }
    }
}
