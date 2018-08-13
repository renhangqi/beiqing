package com.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.TrainInfo;
import com.google.gson.Gson;
import com.service.TrainInfoService;
import com.service.impl.TrainInfoServiceImpl;

@Controller
public class AjaxServerController {
	  @RequestMapping("getData1.do")
	   public void getData1(HttpServletResponse response) throws Exception{
		   //返回所有火车信息
		   TrainInfoService trainInfoService=new TrainInfoServiceImpl();
		   List<TrainInfo> list=trainInfoService.getAllTrainInfo();
		   //1.利用out对象输出异步数据
		   //1.1设置响应类型
		   response.setContentType("text/html");//application/josn
		   response.setCharacterEncoding("utf-8");
		   PrintWriter out =response.getWriter();
		   //1.2输出jso数据
		   //out.println("[\"helloword\"]");
		   //1.3使用Gson将java对象转化为json对象
		   Gson gson=new Gson();
		   String jsonStr=gson.toJson(list);
		   out.println(jsonStr);
	   }
	  @ResponseBody
	  @RequestMapping("getData2.do")
	  public List<TrainInfo> getData2() throws Exception{
		  TrainInfoService trainInfoService=new TrainInfoServiceImpl();
		   List<TrainInfo> list=trainInfoService.getAllTrainInfo();
		   return list;
	  }
}
