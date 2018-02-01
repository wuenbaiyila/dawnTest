package com.dawn.controller;

import com.dawn.pojo.ActiveUser;
import com.dawn.pojo.TbTitle;
import com.dawn.pojo.TbTitleCustom;
import com.dawn.service.TbTitleService;
import com.dawn.util.DawnResult;
import com.dawn.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TbTitleController {
	@Autowired
	private TbTitleService titleService;

	/**
	 * 
	 * <p>
	 * Title: getTitleList
	 * </p>
	 * <p>
	 * Description:查询题目列表
	 * </p>
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/title/list/{categoryId}")
	@ResponseBody
	public Result getTitleList(@PathVariable Long categoryId, int page, int rows) {

		return titleService.getTitleList(categoryId, page, rows);
	}

	/**
	 * 加载用户下的未审核、未通过的面试题
	 * 
	 * @param userid
	 * @return
	 */
	@RequestMapping("/title/auditStatus")
	@ResponseBody
	public List auditStatus(Integer userid) {
		List<TbTitle> list = titleService.getTitleAuditList(userid);
		return list;
	}

	/**
	 * 跳转页面到
	 * 
	 * @return
	 */
	@RequestMapping("/title/toTitleStatus")
	public String toauditStatus3() {
		return "title_status";
	}

	@RequestMapping("/title/audits")
	public String toaudit() {
		return "title_audit";
	}

	/**
	 * 根据题目id 查询题目名称
	 * 
	 * @param tbtitleId
	 * @return
	 */
	@RequestMapping("/title/selectTitleById/{tbtitleId}")
	@ResponseBody
	public List selectTitleById(@PathVariable Long tbtitleId) {
		List list = new ArrayList();
		String title = titleService.selectTitleById(tbtitleId);
		list.add(title);
		return list;
	}

	/**
	 * 
	 * <p>
	 * Title: addTitle
	 * </p>
	 * <p>
	 * Description: 添加题目
	 * </p>
	 * 
	 * @param title
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/title/add", method = RequestMethod.POST)
	@ResponseBody
	public DawnResult addTitle(TbTitle title, String titleDesc, HttpServletRequest request) throws Exception {
		// 从session中获取登陆信息
		ActiveUser activeUser = (ActiveUser) request.getSession().getAttribute("activeUser");
		Integer userType = 0;
		if (activeUser != null && activeUser.getUser_type() != 0) {
			userType = activeUser.getUser_type();
		}
		return titleService.saveTitle(title, titleDesc, userType, activeUser.getUserid());
	}

	/**
	 * 
	 * <p>
	 * Title: delTitle
	 * </p>
	 * <p>
	 * Description: 删除题目
	 * </p>
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("/title/delete")
	@ResponseBody
	public DawnResult delTitle(String ids) {
		// AuthPermission auth = new AuthPermission();

		String ides = ids.substring(0, ids.length() - 1);
		String[] id = ides.split(",");

		/*
		 * boolean flag = false; for (int i = 0; i < id.length; i++) { flag =
		 * auth.authPermissionUserTitle(Long.valueOf(id[i]), request); }
		 */
		// 判断是否有权限操作
		// if (flag) {
		for (int i = 0; i < id.length; i++) {
			titleService.delTitle(Long.valueOf(id[i]));
			titleService.delDesc(Long.valueOf(id[i]));
		}
		return DawnResult.ok();
		// }
		// return DawnResult.build(400, "您无权操作此功能");
	}

	// 学生未通过的题目直接删除
	@RequestMapping("/title/deleteStudent")
	@ResponseBody
	public DawnResult delTitleStudent(String ids, HttpServletRequest request) {
		/*
		 * boolean flag = false; for (int i = 0; i < id.length; i++) { flag =
		 * auth.authPermissionUserTitle(Long.valueOf(id[i]), request); }
		 */
		// 判断是否有权限操作
		// if (flag) {
		titleService.delTitle(Long.valueOf(ids));
		titleService.delDesc(Long.valueOf(ids));
		return DawnResult.ok();
		// }
		// return DawnResult.build(400, "您无权操作此功能");
	}

	// 题目和答案的修改
	@RequestMapping(value = "/title/update", method = RequestMethod.POST)
	@ResponseBody
	public DawnResult updateTitle(TbTitle title, String titleDesc, HttpServletRequest request) throws Exception {
		titleService.updateTitle(title, titleDesc);
		return DawnResult.ok();
	}

	// 学生审核未通过后修改题目和答案的修改
	@RequestMapping(value = "/title/updateStudent", method = RequestMethod.POST)
	@ResponseBody
	public DawnResult updateTitles(TbTitle title, String titleDesc, HttpServletRequest request) throws Exception {

		titleService.updateTitle(title, titleDesc);
		return DawnResult.ok();

	}

	// 根据知识点名称进行模糊查询
	@RequestMapping("/title/like/{categoryId}")
	@ResponseBody
	public Result queryLike(int page, int rows, @PathVariable String categoryId, HttpServletRequest request) {
		ActiveUser activeUser = (ActiveUser) request.getSession().getAttribute("activeUser");
		Integer userType = activeUser.getUser_type();// 用户类型
		try {
			categoryId = new String(categoryId.getBytes("ISO8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Result results = titleService.getByName(categoryId, page, rows, userType);
		return results;
	}

	// 查询我的审核
	@RequestMapping("/title/audit")
	@ResponseBody
	public List<TbTitleCustom> getByAuditStatu(HttpServletRequest request) {
		// 从session中获取登录的用户id。
		ActiveUser user = (ActiveUser) request.getSession().getAttribute("activeUser");
		return titleService.getByAuditStatu(user.getUserid());
	}

	// 通过，根据题目id修改审核状态码，并刷新当前页面。
	@RequestMapping("/title/updateStatu")
	@ResponseBody
	public DawnResult updateStatu(@RequestParam("id") long id) {
		titleService.updateStatu(id);
		return DawnResult.ok();
	}

	// 未通过
	@RequestMapping("/title/updated")
	@ResponseBody
	public DawnResult updateTbtitle(long tbtitleId, TbTitleCustom custom) {
		String cause = custom.getCause();
		if (cause.equals("1")) {
			// 已有该知识点执行删除。
			delTitle(String.valueOf(tbtitleId));
		} else {
			titleService.updateTbtitle(tbtitleId, cause);
		}
		return DawnResult.ok();
	}

}
