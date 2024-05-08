package com.dao;

import com.entity.DiscussyishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussyishiVO;
import com.entity.view.DiscussyishiView;


/**
 * 医师评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-10 23:32:26
 */
public interface DiscussyishiDao extends BaseMapper<DiscussyishiEntity> {
	
	List<DiscussyishiVO> selectListVO(@Param("ew") Wrapper<DiscussyishiEntity> wrapper);
	
	DiscussyishiVO selectVO(@Param("ew") Wrapper<DiscussyishiEntity> wrapper);
	
	List<DiscussyishiView> selectListView(@Param("ew") Wrapper<DiscussyishiEntity> wrapper);

	List<DiscussyishiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyishiEntity> wrapper);

	
	DiscussyishiView selectView(@Param("ew") Wrapper<DiscussyishiEntity> wrapper);
	

}
