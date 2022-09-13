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

import domain.BuyListVO;
import service.BuyListService;
import service.BuyListServiceImpl;
import service.MemberService;
import service.MemberServiceImpl;

@WebServlet("/buy/*")
public class Buyctrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(Buyctrl.class);
	private RequestDispatcher rdp;
	private MemberService msv;
	private BuyListService buysv;
	private String destPage;
	private int isUp;
    public Buyctrl() {
    	buysv = new BuyListServiceImpl();
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
		case "get":
			msv = new MemberServiceImpl();
			BuyListVO buyVO = new BuyListVO(req.getParameter("buyer"),
					Integer.parseInt(req.getParameter("pno")));
			isUp = buysv.register(buyVO);
			if(isUp>0) {
				isUp= msv.plusAmount(buyVO);
				log.info(">>> buy > {}", isUp > 0 ? "Success" : "Fail");
			}
			req.setAttribute("msg_get", isUp);
			destPage = "/prd/listAll";
			break;
		case "listAll" : 
			
			req.setAttribute("list", buysv.getListAll());
			destPage = "/member/buy_list.jsp";
			break;
		case "list" : 
			req.setAttribute("list", buysv.getList(req.getParameter("em")));
			destPage = "/member/buy_list.jsp";
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
