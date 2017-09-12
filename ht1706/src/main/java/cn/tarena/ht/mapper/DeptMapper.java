package cn.tarena.ht.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.Dept;

public interface DeptMapper {
	public List<Dept> findAll();

	public void deleteDepts(String[] deptIds);

	//Mybaits 提供了Map封装工具类    @Param(value="")注解自动将 value值转化为key,将数组中的值作为value
	public void updateState(@Param("deptIds")String[] deptIds,@Param("state") int state);

	public void saveDept(Dept dept);

	public Dept findDeptById(String deptId);

	public void updateDept(Dept dept);

	public List<Dept> findParentList(String deptId);
}
