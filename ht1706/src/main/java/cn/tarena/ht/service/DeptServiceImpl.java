package cn.tarena.ht.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.DeptMapper;
import cn.tarena.ht.pojo.Dept;

@Service("DeptService")
public class DeptServiceImpl implements DeptService{

	@Autowired
	private DeptMapper deptMapper;
	
	@Override
	public List<Dept> findAll() {
		return deptMapper.findAll();
	}

	
	@Override
	public void deleteDepts(String[] deptIds) {
		deptMapper.deleteDepts(deptIds);
	}


	@Override
	public void updateState(String[] deptIds, int state) {
		deptMapper.updateState(deptIds,state);
	}


	@Override
	public void saveDept(Dept dept) {
		dept.setCreateTime(new Date());
		dept.setUpdateTime(dept.getCreateTime());
		deptMapper.saveDept(dept);
	}


	@Override
	public Dept findDeptById(String deptId) {
		return deptMapper.findDeptById(deptId);
	}


	@Override
	public void updateDept(Dept dept) {
		dept.setUpdateTime(new Date());
		deptMapper.updateDept(dept);
	}


	@Override
	public List<Dept> findParentlist(String deptId) {
		return deptMapper.findParentList(deptId);
	}

}
