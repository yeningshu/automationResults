/**
 * @author yedeng
 * @date 2022年11月25日
 * 
 */
package com.example.automationResults.service.runResult;


import com.example.automationResults.bean.runResultBean.RunResultBean;
import com.example.automationResults.pojo.RunResultPojo;
import com.example.automationResults.util.ResultData;
import com.github.pagehelper.PageInfo;

public interface RunResultService {
	
	// 新增 -- 不包含成功数、失败数等数据 -- 返回主键id
	public ResultData<Integer> addResult(RunResultBean runResultBean);
	
	// 查询
	public ResultData<PageInfo<RunResultPojo>> getResult(String projectName,Integer pageNum,Integer pageSize);
	
	// 修改表-- 添加成功数、失败数等数据
	public ResultData<Integer> updateResult(RunResultBean runResultBean);

}
