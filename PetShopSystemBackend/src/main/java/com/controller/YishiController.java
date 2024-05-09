package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.YishiEntity;
import com.entity.ZaixianyuyueEntity;
import com.entity.view.YishiView;
import com.entity.vo.ZaixianyuyueVO;
import com.service.StoreupService;
import com.service.TokenService;
import com.service.YishiService;
import com.service.ZaixianyuyueService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 医师
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-10 23:32:25
 */
@RestController
@RequestMapping("/yishi")
public class YishiController {
    @Autowired
    private YishiService yishiService;

    @Autowired
    private StoreupService storeupService;

    @Autowired
    private ZaixianyuyueService zaixianyuyueService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		YishiEntity u = yishiService.selectOne(new EntityWrapper<YishiEntity>().eq("zhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"yishi",  "医师" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody YishiEntity yishi){
    	//ValidatorUtils.validateEntity(yishi);
    	YishiEntity u = yishiService.selectOne(new EntityWrapper<YishiEntity>().eq("zhanghao", yishi.getZhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		yishi.setId(uId);
        yishiService.insert(yishi);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        YishiEntity u = yishiService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	YishiEntity u = yishiService.selectOne(new EntityWrapper<YishiEntity>().eq("zhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        yishiService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YishiEntity yishi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			yishi.setDianpumingcheng((String)request.getSession().getAttribute("username"));
		}
		else {
            if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
                yishi.setUserid((Long)request.getSession().getAttribute("userId"));
            }
        }
        EntityWrapper<YishiEntity> ew = new EntityWrapper<YishiEntity>();

		PageUtils page = yishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yishi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YishiEntity yishi, 
		HttpServletRequest request){
        EntityWrapper<YishiEntity> ew = new EntityWrapper<YishiEntity>();

		PageUtils page = yishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yishi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YishiEntity yishi){
       	EntityWrapper<YishiEntity> ew = new EntityWrapper<YishiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yishi, "yishi")); 
        return R.ok().put("data", yishiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YishiEntity yishi){
        EntityWrapper< YishiEntity> ew = new EntityWrapper< YishiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yishi, "yishi")); 
		YishiView yishiView =  yishiService.selectView(ew);
		return R.ok("查询医师成功").put("data", yishiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YishiEntity yishi = yishiService.selectById(id);
		yishi.setClicknum(yishi.getClicknum()+1);
		yishi.setClicktime(new Date());
		yishiService.updateById(yishi);
        yishi = yishiService.selectView(new EntityWrapper<YishiEntity>().eq("id", id));
        return R.ok().put("data", yishi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YishiEntity yishi = yishiService.selectById(id);
		yishi.setClicknum(yishi.getClicknum()+1);
		yishi.setClicktime(new Date());
		yishiService.updateById(yishi);
        yishi = yishiService.selectView(new EntityWrapper<YishiEntity>().eq("id", id));
        return R.ok().put("data", yishi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YishiEntity yishi, HttpServletRequest request){
        if(yishiService.selectCount(new EntityWrapper<YishiEntity>().eq("zhanghao", yishi.getZhanghao()))>0) {
            return R.error("账号已存在");
        }
    	yishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yishi);
    	YishiEntity u = yishiService.selectOne(new EntityWrapper<YishiEntity>().eq("zhanghao", yishi.getZhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
    	yishi.setUserid((Long)request.getSession().getAttribute("userId"));
		yishi.setId(new Date().getTime());
        yishiService.insert(yishi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YishiEntity yishi, HttpServletRequest request){
        if(yishiService.selectCount(new EntityWrapper<YishiEntity>().eq("zhanghao", yishi.getZhanghao()))>0) {
            return R.error("账号已存在");
        }
    	yishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yishi);
    	YishiEntity u = yishiService.selectOne(new EntityWrapper<YishiEntity>().eq("zhanghao", yishi.getZhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		yishi.setId(new Date().getTime());
        yishiService.insert(yishi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YishiEntity yishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yishi);
        if(yishiService.selectCount(new EntityWrapper<YishiEntity>().ne("id", yishi.getId()).eq("zhanghao", yishi.getZhanghao()))>0) {
            return R.error("账号已存在");
        }
        yishiService.updateById(yishi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){

        boolean flag = false;

        System.out.println(ids);

        // 有预约未完成的医生不能删除
        List<YishiEntity> yishiEntities = yishiService.selectBatchIds(Arrays.asList(ids));
        for (YishiEntity yishi: yishiEntities) {
            EntityWrapper<ZaixianyuyueEntity> ew = new EntityWrapper<ZaixianyuyueEntity>();
            ew.eq("yishixingming", yishi.getYishixingming()).eq("sfsh", "待审核");
            System.out.println("医师姓名:"+ yishi.getYishixingming());
            List<ZaixianyuyueVO> zaixianyuyueVOS = zaixianyuyueService.selectListVO(ew);
            System.out.println(zaixianyuyueVOS);
            if (zaixianyuyueVOS != null && zaixianyuyueVOS.size() > 0) {
                flag = true;
                break;
            }

        }

        System.out.printf("flag:" + flag);

        if (flag) {
            return R.ok().put("msg", "该医师有未完成的预约");
        }
        else {
            yishiService.deleteBatchIds(Arrays.asList(ids));
            return R.ok().put("msg", "完成删除");
        }

    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,YishiEntity yishi, HttpServletRequest request,String pre){
        EntityWrapper<YishiEntity> ew = new EntityWrapper<YishiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = yishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yishi), params), params));
        return R.ok().put("data", page);
    }










}
