package controller;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ReviewVO;
import service.ReviewService;
import service.ReviewServiceImpl;


@WebServlet("/revp/*")
public class ReviewProductListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ReviewProductListCtrl.class);
	private ReviewService rsv;
    public ReviewProductListCtrl() {
    	rsv = new ReviewServiceImpl(); 
    }

	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8"); 

		String uri = req.getRequestURI();
		String path = uri.substring("/revp/".length());
		log.info(">>> path : " + path);
		String pathVar = "";
		if (path.contains("/")) {
			pathVar = path.substring(path.lastIndexOf("/") + 1); // 10
			path = path.substring(0, path.lastIndexOf("/")); // list
			
		}
		
		switch (path) {
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
			log.info(jsonData);
			PrintWriter out = res.getWriter();
			out.print(jsonData);
			}catch (Exception e) {
				log.info(">>> Review > list > Error");
			}
			break;
		default:
			break;
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
