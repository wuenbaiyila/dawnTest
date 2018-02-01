package com.dawn.controller;

import com.dawn.pojo.SysPermission;
import com.dawn.pojo.SysRole;
import com.dawn.pojo.SysRolePermission;
import com.dawn.service.SysPermissionService;
import com.dawn.service.SysRolePermissionService;
import com.dawn.service.SysRoleService;
import com.dawn.util.Result;
import com.dawn.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sysrole/*")
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysPermissionService sysPermissionService;
	@Autowired
	private SysRolePermissionService sysRolePermissionService;

	/**
	 * 查询所有角色
	 * <p>
	 * Title: findSysRoleAll
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 */
	@RequestMapping("findSysRoleAll")
	@ResponseBody
	public Result findSysRoleAll(int page, int rows) {
		return sysRoleService.findSysRolefindAll(page, rows);
	}

	/**
	 * 删除角色
	 * <p>
	 * Title: deleteSysRole
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 //* @param id
	 * @return
	 */
	@RequestMapping("deleteSysRole")
	@ResponseBody
	public Map deleteSysRole(String delIds) {
		Map result = new HashMap();
		String str[] = delIds.split(",");
		for (int i = 0; i < str.length; i++) {
			// 判断该角色下是否还有用户
			boolean f = sysRoleService.isRoleUser(Integer.valueOf(str[i]));
			if (f) {
				result.put("errorIndex", i);
				result.put("errorMsg", "角色下面有用户，不能删除！");
				return result;
			}
		}
		// 删除角色
		for (int i = 0; i < str.length; i++) {
			sysRoleService.deleteSysRole(Integer.valueOf(str[i]));
		}
		result.put("success", "删除成功!!");
		return result;
	}

	/**
	 * 新增角色
	 * <p>
	 * Title: addSysRole
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * available 0停用 1 可用
	 * 
	// * @param sysrole
	 * @return
	 */
	@RequestMapping("addSysRole")
	@ResponseBody
	public String addSysRole(String roleName, String available) {
		SysRole role = new SysRole();
		role.setName(roleName);
		role.setAvailable(available);
		int i = sysRoleService.addSysRole(role);
		String msg = "";
		if (i > 0) {
			msg = "{\"msg\":\"新增成功\"}";
		} else {
			msg = "{\"errorMsg\":\"新增失败\"}";
		}
		return msg;
	}

	/**
	 * 修改角色
	 * <p>
	 * Title: updateSysRole
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
//	 * @param sysrole
	 * @return
	 */
	@RequestMapping("updateSysRole")
	@ResponseBody
	public String updateSysRole(Integer roleId, String roleName, String available) {
		SysRole role = sysRoleService.findByIdSysRole(roleId);
		role.setName(roleName);
		role.setAvailable(available);
		int i = sysRoleService.updateSysRole(role);
		String msg = "";
		if (i > 0) {
			msg = "{\"msg\":\"修改成功\"}";
		} else {
			msg = "{\"errorMsg\":\"修改失败\"}";
		}
		return msg;
	}

	// 弹出角色授权对话框
	@RequestMapping("selectParentIdPermission")
	@ResponseBody
	public List<SysPermission> selectParentIdPermission(@RequestParam(value = "id", defaultValue = "0") int parentid,
			String roleId) {
		List<SysPermission> list = sysPermissionService.findPermissionByParentId(parentid);
		List<SysRolePermission> listrole = sysRolePermissionService.queryByRoleId(roleId);// 根据权限id查询权限菜单
		List resultMap = new ArrayList  ();
		String authids = "";
		// 判断该角色是否有权限
		if (listrole.size() > 0) {
			// 接口参数
			for (SysRolePermission sysRolePermission : listrole) {
				authids += sysRolePermission.getSysPermissionId() + ",";
			}
			String authidss = authids.substring(0, authids.length() - 1);
			for (SysPermission sysPermission : list) {
				Map node = new HashMap  ();
				node.put("id", sysPermission.getId());
				node.put("text", sysPermission.getName());
				node.put("state", sysPermissionService.findByIsParentId(sysPermission.getId()) ? "closed" : "open");
				// 设置被选中的状态
				if (StringUtil.existStrArr(sysPermission.getId() + "", authidss.split(","))) {
					node.put("checked", true);
				}
				resultMap.add(node);
			}
			return resultMap;
		}

		for (SysPermission sysPermission : list) {
			Map node = new HashMap  ();
			node.put("id", sysPermission.getId());
			node.put("text", sysPermission.getName());
			node.put("state", sysPermissionService.findByIsParentId(sysPermission.getId()) ? "closed" : "open");
			resultMap.add(node);
		}
		return resultMap;
	}

	// 角色授权
	@RequestMapping("saveRole")
	@ResponseBody
	public Map saveRole(String roleId, String authIds) {
		Map map = new HashMap  ();
		try {
			String[] authIdsArr = authIds.split(",");
			for (int i = 0; i < authIdsArr.length; i++) {
				SysRolePermission sysrole = new SysRolePermission();
				sysrole.setSysRoleId(roleId);
				sysrole.setSysPermissionId(authIdsArr[i]);
				sysRolePermissionService.addSysRolePermissionService(sysrole);
			}
			map.put("success", "授权成功!!");

		} catch (Exception e) {
			e.printStackTrace();
			map.put("errorMsg", "授权失败!!");
		}
		return map;
	}

}
