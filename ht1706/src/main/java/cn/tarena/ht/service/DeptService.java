package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Dept;

public interface DeptService {
	public List<Dept> findAll();

	public void deleteDepts(String[] deptIds);

	public void updateState(String[] deptIds, int state);

	public void saveDept(Dept dept);

	public Dept findDeptById(String deptId);

	public void updateDept(Dept dept);

	public List<Dept> findParentlist(String deptId);
}
