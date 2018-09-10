package com.atguigu.atcrowdfunding.listener;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.atguigu.atcrowdfunding.bean.Permission;
import com.atguigu.atcrowdfunding.manager.service.PermissionService;
import com.atguigu.atcrowdfunding.util.Const;

public class StartSystemListener implements ServletContextListener {

	//鍦ㄦ湇鍔″櫒鍚姩鏃�,鍒涘缓application瀵硅薄鏃堕渶瑕佹墽琛岀殑鏂规硶.
	public void contextInitialized(ServletContextEvent sce) {
		//1.灏嗛」鐩笂涓嬫枃璺緞(request.getContextPath())鏀剧疆鍒癮pplication鍩熶腑.
		ServletContext application = sce.getServletContext();
		String contextPath = application.getContextPath();
		application.setAttribute("APP_PATH", contextPath);
		System.out.println("APP_PATH...");
		
		//2.鍔犺浇鎵�鏈夎鍙矾寰�
		ApplicationContext ioc = WebApplicationContextUtils.getWebApplicationContext(application);	
		PermissionService permissionService = ioc.getBean(PermissionService.class);
		List<Permission> queryAllPermission = permissionService.queryAllPermission();
		
		Set<String> allURIs = new HashSet<String>();
		
		for (Permission permission : queryAllPermission) {
			allURIs.add("/"+permission.getUrl());
		}
		
		application.setAttribute(Const.ALL_PERMISSION_URI, allURIs);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
