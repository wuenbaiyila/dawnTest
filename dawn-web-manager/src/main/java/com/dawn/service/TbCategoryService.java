package com.dawn.service;

import java.util.List;

import com.dawn.pojo.TbCategory;
import com.dawn.util.TreePojo;

public interface TbCategoryService {
	// 查询知识点
	public List<TreePojo> queryCategory(long parentid);

	// 查询是否有子节点
	public List<TbCategory> getChildList(long parentid);

	// 新增知识点
	public void saveCategory(TbCategory category);

	// 修改知识点
	public void updateCategory(TbCategory tbCategory);

	// 按照Id查询
	public TbCategory queryById(long categordId);

	// 删除
	public void deleteCategory(long categordId);
}
