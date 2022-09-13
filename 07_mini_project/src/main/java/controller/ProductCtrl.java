package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ProductVO;
import service.ProductService;
import service.ProductServiceIpml;

@WebServlet("/prd/*")
public class ProductCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ProductCtrl.class);
	private RequestDispatcher rdp;
	private ProductService psv;
	private int isUp;
	private String destPage;
       
    public ProductCtrl() {
    	psv= new ProductServiceIpml();
    }
    @Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");

		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		log.info(">>> path : " + path);
		
		switch (path) {
		case "buy":
			req.setAttribute("pvo", psv.getListOne(Integer.parseInt(req.getParameter("pno"))));
			destPage = "/product/buy.jsp";
			break;
		case "register":
			destPage = "/product/register.jsp";
			break;
		case "insert":
			isUp = psv.register(new ProductVO(req.getParameter("pname"),
											Integer.parseInt(req.getParameter("price")),
											req.getParameter("category"),
											req.getParameter("description")));
			log.info(">>> prodcut insert > {}", isUp > 0 ? "Success" : "Fail");
			req.setAttribute("msg_insert", isUp);
			destPage = "listAll";
			break;
		case "listAll":
				req.setAttribute("list", psv.getList()); 
				destPage ="/product/list.jsp"; 
			break;
		case "listCate":
			req.setAttribute("list", psv.getList(req.getParameter("cate")));
			destPage ="/product/list.jsp";
			break;
		case "detail":
			req.setAttribute("pvo", psv.getListOne(Integer.parseInt(req.getParameter("pno"))));
			destPage ="/product/detail.jsp";
			break;
		case "modify":
			req.setAttribute("pvo", psv.getListOne(Integer.parseInt(req.getParameter("pno"))));
			destPage ="/product/modify.jsp";
			break;
		case "update":
			isUp = psv.modify(new ProductVO(Integer.parseInt(req.getParameter("pno")),
															req.getParameter("pname"),
															req.getParameter("category"),
											Integer.parseInt(req.getParameter("price")),
											 				req.getParameter("description")));
			log.info(">>> prodcut modify > {}", isUp > 0 ? "Success" : "Fail");
			req.setAttribute("msg_mod", isUp);
			destPage ="detail?pno="+req.getParameter("pno");
			break;
		case "remove":
			log.info(req.getParameter("pno"));
			int isUp = psv.remove(Integer.parseInt(req.getParameter("pno")));
			log.info(">>> ProductRemove > {}", isUp > 0 ? "Success":"Fail");
			req.setAttribute("msg_remove", isUp);
			destPage = "listAll";
			break;
			
		default:
			break;
		}
		rdp = req.getRequestDispatcher(destPage);
		rdp.forward(req, res);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
