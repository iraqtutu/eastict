package com.eastict.controller.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.eastict.common.utils.JsonUtils;

@Controller
@RequestMapping(value = "/project")
public class ProjectController {
    @Autowired
    private RequestMappingHandlerMapping handlerMapping;
	
	@RequestMapping(value = "/help",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getUrlMaps(HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		Map<String,Object> rlt = new HashMap<String,Object>();
        Map map =  this.handlerMapping.getHandlerMethods();
        Iterator<?> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            sb.append("访问路径" + entry.getKey().toString() + "\r\n------对应的方法" + entry.getValue() + "\r\n\r\n");
            System.out.println(entry.getKey() +"\n" + entry.getValue() + "\r\n\r\n");
        }
        return sb.toString();
        		
		//return requestToMethodItemList;//new ModelAndView("index").addObject("MethodList", requestToMethodItemList);
	}
}
