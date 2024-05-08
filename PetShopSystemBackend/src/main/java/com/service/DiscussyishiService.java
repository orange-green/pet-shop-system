package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussyishiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussyishiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussyishiView;


/**
 * 医师评论表
 *
 * @author 
 * @email 
 * @date 2024-04-10 23:32:26
 */
public interface DiscussyishiService extends IService<DiscussyishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyishiVO> selectListVO(Wrapper<DiscussyishiEntity> wrapper);
   	
   	DiscussyishiVO selectVO(@Param("ew") Wrapper<DiscussyishiEntity> wrapper);
   	
   	List<DiscussyishiView> selectListView(Wrapper<DiscussyishiEntity> wrapper);
   	
   	DiscussyishiView selectView(@Param("ew") Wrapper<DiscussyishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyishiEntity> wrapper);

   	

}

