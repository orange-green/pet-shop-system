package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ZaixianyuyueEntity;
import com.entity.view.ZaixianyuyueView;
import com.entity.vo.ZaixianyuyueVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


/**
 * 在线预约
 * 
 * @author 
 * @email 
 * @date 2024-04-10 23:32:25
 */
public interface ZaixianyuyueDao extends BaseMapper<ZaixianyuyueEntity> {
	
	List<ZaixianyuyueVO> selectListVO(@Param("ew") Wrapper<ZaixianyuyueEntity> wrapper);
	
	ZaixianyuyueVO selectVO(@Param("ew") Wrapper<ZaixianyuyueEntity> wrapper);
	
	List<ZaixianyuyueView> selectListView(@Param("ew") Wrapper<ZaixianyuyueEntity> wrapper);

	List<ZaixianyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<ZaixianyuyueEntity> wrapper);

	
	ZaixianyuyueView selectView(@Param("ew") Wrapper<ZaixianyuyueEntity> wrapper);


	ZaixianyuyueVO existApply(@Param("doctorName") String doctorName, @Param("applyDate") Date applyDate);
}
