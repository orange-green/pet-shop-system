package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.entity.vo.ZaixianyuyueVO;
import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZaixianyuyueEntity;
import com.entity.view.ZaixianyuyueView;

import com.service.ZaixianyuyueService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 在线预约
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-10 23:32:25
 */
@RestController
@RequestMapping("/zaixianyuyue")
public class ZaixianyuyueController {
    @Autowired
    private ZaixianyuyueService zaixianyuyueService;

    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZaixianyuyueEntity zaixianyuyue,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yishi")) {
			zaixianyuyue.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			zaixianyuyue.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZaixianyuyueEntity> ew = new EntityWrapper<ZaixianyuyueEntity>();

		PageUtils page = zaixianyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zaixianyuyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZaixianyuyueEntity zaixianyuyue, 
		HttpServletRequest request){
        EntityWrapper<ZaixianyuyueEntity> ew = new EntityWrapper<ZaixianyuyueEntity>();

		PageUtils page = zaixianyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zaixianyuyue), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZaixianyuyueEntity zaixianyuyue){
       	EntityWrapper<ZaixianyuyueEntity> ew = new EntityWrapper<ZaixianyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zaixianyuyue, "zaixianyuyue")); 
        return R.ok().put("data", zaixianyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZaixianyuyueEntity zaixianyuyue){
        EntityWrapper< ZaixianyuyueEntity> ew = new EntityWrapper< ZaixianyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zaixianyuyue, "zaixianyuyue")); 
		ZaixianyuyueView zaixianyuyueView =  zaixianyuyueService.selectView(ew);
		return R.ok("查询在线预约成功").put("data", zaixianyuyueView);
    }


    @RequestMapping("/query/exist")
    public R exist(ZaixianyuyueEntity zaixianyuyue){
        EntityWrapper< ZaixianyuyueEntity> ew = new EntityWrapper< ZaixianyuyueEntity>();

//        ew.eq("yishixingming", zaixianyuyue.getYishixingming()).between("yuyueshijian", new Date())
        String msg = "不存在预约";
        ZaixianyuyueVO zaixianyuyueVO = zaixianyuyueService.existApply(zaixianyuyue.getYishixingming());
        if (zaixianyuyueVO != null) {
            msg = "已存在预约";
        }
        return R.ok(msg).put("exist", msg).put("data", zaixianyuyueVO);
    }


    @RequestMapping("/query/finish")
    public R finish(ZaixianyuyueEntity zaixianyuyue){
        EntityWrapper< ZaixianyuyueEntity> ew = new EntityWrapper< ZaixianyuyueEntity>();
        ew.eq("yishixingming", zaixianyuyue.getYishixingming()).eq("sfsh", "待审核");
        ZaixianyuyueView zaixianyuyueView =  zaixianyuyueService.selectView(ew);
        return R.ok("存在未完成的预约").put("data", zaixianyuyueView);
    }



    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZaixianyuyueEntity zaixianyuyue = zaixianyuyueService.selectById(id);
        return R.ok().put("data", zaixianyuyue);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZaixianyuyueEntity zaixianyuyue = zaixianyuyueService.selectById(id);
        return R.ok().put("data", zaixianyuyue);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZaixianyuyueEntity zaixianyuyue, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zaixianyuyue);
        zaixianyuyueService.insert(zaixianyuyue);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZaixianyuyueEntity zaixianyuyue, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zaixianyuyue);
        zaixianyuyueService.insert(zaixianyuyue);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZaixianyuyueEntity zaixianyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zaixianyuyue);

        zaixianyuyueService.updateById(zaixianyuyue);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ZaixianyuyueEntity> list = new ArrayList<ZaixianyuyueEntity>();
        for(Long id : ids) {
            ZaixianyuyueEntity zaixianyuyue = zaixianyuyueService.selectById(id);
            zaixianyuyue.setSfsh(sfsh);
            zaixianyuyue.setShhf(shhf);
            list.add(zaixianyuyue);
        }
        zaixianyuyueService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zaixianyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }













}
