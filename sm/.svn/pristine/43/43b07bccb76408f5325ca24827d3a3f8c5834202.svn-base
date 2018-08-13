package com.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.entity.TrainInfo;
import com.service.TrainInfoService;
import com.service.impl.TrainInfoServiceImpl;

@Controller
public class TrainInfoController {
	//定义业务对象 
	TrainInfoService trainInfoService=new TrainInfoServiceImpl();
   
	
		@InitBinder
	    public void InitBinder(HttpServletRequest request,
	            ServletRequestDataBinder binder) {
	        // 不要删除下行注释!!! 将来"yyyy-MM-dd"将配置到properties文件中
	        // SimpleDateFormat dateFormat = new
	        // SimpleDateFormat(getText("date.format", request.getLocale()));
	        SimpleDateFormat dateFormat = new SimpleDateFormat(
	                "yyyy-MM-dd");  // HH:mm:ss
	        dateFormat.setLenient(false);
	        binder.registerCustomEditor(java.util.Date.class, null, new CustomDateEditor(
	                dateFormat, true));
	    }
	
	//查询所有数据的请求
	@RequestMapping("getAllInfo.do")
	public String  getAllInfo(Model model) throws Exception{
		 //调用业务
		List<TrainInfo> list=trainInfoService.getAllTrainInfo();
		model.addAttribute("list", list);
		
		return "index.jsp";
	}
	
	//添加方法
	@RequestMapping("/addTrainInfo.do")
	public String addTrainInfo(TrainInfo info,Model model) throws Exception{
		//操作实体:
		 //info.setRuntime(java.sql.Date.valueOf(runtimet));
		//调业务
     	int temp=trainInfoService.addTrainInfo(info);
     	if(temp>0) {
     		model.addAttribute("info", "添加成功!");
     		return "addTrain.jsp";
     	}
     	else
     	{
     		model.addAttribute("info", "添加失败");
     		return "addTrain.jsp";
     	}
	}
	
	//查询单条
	@RequestMapping("/getTrainInfo.do")
	public String getTrainInfo(String no,Model model) throws Exception{
		 TrainInfo info=trainInfoService.selectByPrimaryKey(no);
		 model.addAttribute("info", info);
		 return "editTrain.jsp";
	}
}
