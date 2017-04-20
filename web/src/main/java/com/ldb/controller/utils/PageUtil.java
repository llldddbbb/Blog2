package com.ldb.controller.utils;


public class PageUtil {

	


	public static String getPageNation(long totalNum, String targetUrl,int currentPage, int pageSize){
		long totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		if(totalPage==0){
			return "未能查询到数据";
		}else{
			StringBuffer pageCode=new StringBuffer();
			pageCode.append("<li><a href='"+targetUrl+"/1'>首页</a></li>");
			if(currentPage>1){
				pageCode.append("<li><a href='"+targetUrl+"/"+(currentPage-1)+"'>上一页</a></li>");
			}
			for(int i=currentPage-4;i<=currentPage+4;i++){
				if(i<1||i>totalPage){
					continue;
				}
				if(i==currentPage){
					pageCode.append("<li class='active'><a href='"+targetUrl+"/"+i+"'>"+i+"</a></li>");
				}else{
					pageCode.append("<li><a href='"+targetUrl+"/"+i+"'>"+i+"</a></li>");
				}
			}
			if(currentPage<totalPage){
				pageCode.append("<li><a href='"+targetUrl+"/"+(currentPage+1)+"'>下一页</a></li>");
			}
			pageCode.append("<li><a href='"+targetUrl+"/"+totalPage+"'>尾页</a></li>");
			return pageCode.toString();
		}
	}
	
	
}
