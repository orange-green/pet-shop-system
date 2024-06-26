package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ZaixianyuyueEntity;
import com.entity.view.ZaixianyuyueView;
import com.entity.vo.ZaixianyuyueVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 在线预约
 *
 * @author 
 * @email 
 * @date 2024-04-10 23:32:25
 */
public interface ZaixianyuyueService extends IService<ZaixianyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZaixianyuyueVO> selectListVO(Wrapper<ZaixianyuyueEntity> wrapper);
   	
   	ZaixianyuyueVO selectVO(@Param("ew") Wrapper<ZaixianyuyueEntity> wrapper);
   	
   	List<ZaixianyuyueView> selectListView(Wrapper<ZaixianyuyueEntity> wrapper);
   	
   	ZaixianyuyueView selectView(@Param("ew") Wrapper<ZaixianyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZaixianyuyueEntity> wrapper);


	ZaixianyuyueVO existApply(String doctorName, Date applyDate);
}

