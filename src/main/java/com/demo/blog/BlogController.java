package com.demo.blog;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.demo.common.model.Blog;
import com.demo.utils.ExcelExportUtil;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * BlogController
 * 所有 sql 与业务逻辑写在 Model 或 Service 中，不要写在 Controller 中，养成好习惯，有利于大型项目的开发与维护
 */
@Before(BlogInterceptor.class)
public class BlogController extends Controller {
	
	@Inject
	BlogService service;
	
	public void index() {
		Page<Blog> paginate = service.paginate(getParaToInt(0, 1), 10);
		setAttr("blogPage", paginate);
		render("blog.html");
//		renderJson(paginate);
	}
	
	public void add() {
		System.out.println("添加业务···");
	    String sql = "select * from `blog`";
	        Map<String, String> titleData = new HashMap<String, String>();//标题，后面用到
	        titleData.put("id", "序号");
	        titleData.put("title", "标题");
	        titleData.put("content", "内容");
	        File file = new File(ExcelExportUtil.getTitle());
	    file = ExcelExportUtil.saveFile(titleData, sql, file);
	    this.renderFile(file);
	}
	
	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
	 * 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	@Before(BlogValidator.class)
	public void save() {
		getBean(Blog.class).save();
		redirect("/blog");
	}
	
	public void edit() {
		setAttr("blog", service.findById(getParaToInt()));
	}
	
	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
	 * 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	@Before(BlogValidator.class)
	public void update() {
		getBean(Blog.class).update();
		redirect("/blog");
	}
	
	public void delete() {
		service.deleteById(getParaToInt());
		redirect("/blog");
	}
	
	public void export(){
	    String sql = "select * from `blog`";
	    System.out.println(sql);
	        Map<String, String> titleData = new HashMap<String, String>();//标题，后面用到
	        titleData.put("id", "序号");
	        titleData.put("title", "标题");
	        titleData.put("content", "内容");
	        File file = new File(ExcelExportUtil.getTitle());
	    file = ExcelExportUtil.saveFile(titleData, sql, file);
	    this.renderFile(file);
	}
}


