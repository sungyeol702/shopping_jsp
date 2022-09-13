package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import domain.ReviewVO;
import handler.FileHandler;
import service.ReviewService;
import service.ReviewServiceImpl;

@WebServlet("/rev/*")
public class ReviewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ReviewCtrl.class);
	private RequestDispatcher rdp;
	private ReviewService rsv;
	private int isUp;
	private String destPage;
	private String savePath;
	private ReviewVO rvo;

	public ReviewCtrl() {
		rsv = new ReviewServiceImpl(); 
	}

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8"); 
		res.setContentType("text/html; charset=utf-8");

		String uri = req.getRequestURI();
		String path = uri.substring("/rev/".length());
		log.info(">>> path : " + path);
		String pathVar = "";
		if (path.contains("/")) {
			pathVar = path.substring(path.lastIndexOf("/") + 1); // 10
			path = path.substring(0, path.lastIndexOf("/")); // list
			
		}
		switch (path) {
		case "register":
			req.setAttribute("pno", req.getParameter("em"));
			destPage = "/review/register.jsp";
			break;
		case "insert":
			savePath = getServletContext().getRealPath("/_fileUpload");
			rvo = new FileHandler().postFile(savePath, req);
			isUp = rsv.register(rvo);
			log.info(">>> ReviewCtrl > insert > {}", isUp > 0 ? "OK" : "Fail");
			req.setAttribute("insert__msg", isUp);
			destPage = "mlist?em="+rvo.getWriter();
			break;
		case "mlist":
			req.setAttribute("mlist", rsv.getMList(req.getParameter("em")));
			destPage = "/review/mList.jsp"; 
			break; 
		case "plist": 
			try {
			List<ReviewVO> list = rsv.getPList(Integer.parseInt(pathVar));
			JSONObject[] jsonObjArr = new JSONObject[list.size()];  
			JSONArray jsonObjList = new JSONArray(); 
			for (int i = 0; i < list.size(); i++) { 
				jsonObjArr[i] = new JSONObject(); // key:value
				jsonObjArr[i].put("rno", list.get(i).getRno());
				jsonObjArr[i].put("pno", list.get(i).getPno());
				jsonObjArr[i].put("title", list.get(i).getTitle()); 
				jsonObjArr[i].put("writer", list.get(i).getWriter());
				jsonObjArr[i].put("image_file", list.get(i).getImage_file());
				jsonObjArr[i].put("reg_at", list.get(i).getReg_at());
				jsonObjArr[i].put("pname", list.get(i).getPname());
				jsonObjArr[i].put("description", list.get(i).getDescription()); 
				
				jsonObjList.add(jsonObjArr[i]); 
			}
			String jsonData = jsonObjList.toJSONString();
			PrintWriter out = res.getWriter();
			out.print(jsonData);
			}catch (Exception e) {
				log.info(">>> Review > list > Error");
			}
			break;
		case "detail":
			req.setAttribute("rvo", rsv.getDetail(Long.parseLong(req.getParameter("rno"))));
			destPage = "/review/detail.jsp"; 
			break;
		case "modify":
			req.setAttribute("rvo", rsv.getDetail(Long.parseLong(req.getParameter("rno"))));
			destPage = "/review/modify.jsp";
			break;
		case "update":
			savePath = getServletContext().getRealPath("/_fileUpload");
			rvo = new FileHandler().postFile(savePath, req);
			isUp = rsv.modify(rvo);
			log.info(">>> ReviewCtrl > modify > {}", isUp > 0 ? "OK" : "Fail");
			req.setAttribute("modify_msg", isUp);
			destPage = "detail?rno="+rvo.getRno();
			break;
		case "remove":
			long rno = Long.parseLong(req.getParameter("rno")); 
			String imageFileName = rsv.getFileName(rno);
			savePath = getServletContext().getRealPath("/_fileUpload");
			isUp =  new FileHandler().deleteFile(imageFileName, savePath);
			if(isUp>0) {
				isUp = rsv.remove(rno);
				log.info(">>> BoardCtrl > Remove > {}", isUp > 0 ? "OK" : "Fail");
			}
			req.setAttribute("remove_msg", isUp);
			destPage = "mlist?em="+req.getParameter("writer");
			break;
//			try {
//				StringBuffer sb = new StringBuffer();
//				String line = null;
//				BufferedReader br = req.getReader();
//				while ((line = br.readLine()) != null) {
//					sb.append(line);
//				}
//				log.info(">>> sb : {}", sb.toString());
//				
//				JSONParser parser = new JSONParser();
//					JSONObject jsonObj = (JSONObject) parser.parse(sb.toString());
//					isUp = rsv.remove(Long.parseLong(jsonObj.get("rno").toString()));
//					req.setAttribute("msg_Remove", isUp);
//					destPage = "mlist?em="+jsonObj.get("writer").toString();
//				} catch (ParseException e) {
//					log.info(">>> Comment > post > Error");
//					e.printStackTrace();
//				}
			
		default:
			break;
		}
		rdp = req.getRequestDispatcher(destPage);
		rdp.forward(req, res);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

}
