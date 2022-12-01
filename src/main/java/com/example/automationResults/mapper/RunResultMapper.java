/**
 * @author yedeng
 * @date 2022年11月25日
 * 
 */
package com.example.automationResults.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.example.automationResults.pojo.RunResultPojo;

@Mapper
public interface RunResultMapper {
	
	// 新增
	public Integer insertResult(RunResultPojo runResultPojo);
	
	// 查询
	public List<RunResultPojo> getResultList(String projectName);
	
	// 通过id查询
//	public RunResultPojo getResultListById(Integer id);
	
	// 更新数据，将成功数等信息写入
	public Integer updateResultById(RunResultPojo runResultPojo);
	
}
