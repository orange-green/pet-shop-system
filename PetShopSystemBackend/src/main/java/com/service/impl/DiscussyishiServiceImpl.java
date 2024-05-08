package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussyishiDao;
import com.entity.DiscussyishiEntity;
import com.service.DiscussyishiService;
import com.entity.vo.DiscussyishiVO;
import com.entity.view.DiscussyishiView;

@Service("discussyishiService")
public class DiscussyishiServiceImpl extends ServiceImpl<DiscussyishiDao, DiscussyishiEntity> implements DiscussyishiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyishiEntity> page = this.selectPage(
                new Query<DiscussyishiEntity>(params).getPage(),
                new EntityWrapper<DiscussyishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyishiEntity> wrapper) {
		  Page<DiscussyishiView> page =new Query<DiscussyishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussyishiVO> selectListVO(Wrapper<DiscussyishiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyishiVO selectVO(Wrapper<DiscussyishiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyishiView> selectListView(Wrapper<DiscussyishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyishiView selectView(Wrapper<DiscussyishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
