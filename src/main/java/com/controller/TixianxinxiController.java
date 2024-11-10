package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.TixianxinxiEntity;
import com.entity.view.TixianxinxiView;

import com.service.TixianxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 提现信息
 * 后端接口
 * @author 
 * @email 
 * @date 2022-03-27 20:32:02
 */
@RestController
@RequestMapping("/tixianxinxi")
public class TixianxinxiController {
    @Autowired
    private TixianxinxiService tixianxinxiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TixianxinxiEntity tixianxinxi,
                @RequestParam(required = false) Double jinestart,
                @RequestParam(required = false) Double jineend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("maijia")) {
			tixianxinxi.setMaijiazhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TixianxinxiEntity> ew = new EntityWrapper<TixianxinxiEntity>();
                if(jinestart!=null) ew.ge("jine", jinestart);
                if(jineend!=null) ew.le("jine", jineend);
		PageUtils page = tixianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tixianxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TixianxinxiEntity tixianxinxi, 
                @RequestParam(required = false) Double jinestart,
                @RequestParam(required = false) Double jineend,
		HttpServletRequest request){
        EntityWrapper<TixianxinxiEntity> ew = new EntityWrapper<TixianxinxiEntity>();
                if(jinestart!=null) ew.ge("jine", jinestart);
                if(jineend!=null) ew.le("jine", jineend);
		PageUtils page = tixianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tixianxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TixianxinxiEntity tixianxinxi){
       	EntityWrapper<TixianxinxiEntity> ew = new EntityWrapper<TixianxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tixianxinxi, "tixianxinxi")); 
        return R.ok().put("data", tixianxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TixianxinxiEntity tixianxinxi){
        EntityWrapper< TixianxinxiEntity> ew = new EntityWrapper< TixianxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tixianxinxi, "tixianxinxi")); 
		TixianxinxiView tixianxinxiView =  tixianxinxiService.selectView(ew);
		return R.ok("查询提现信息成功").put("data", tixianxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TixianxinxiEntity tixianxinxi = tixianxinxiService.selectById(id);
        return R.ok().put("data", tixianxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TixianxinxiEntity tixianxinxi = tixianxinxiService.selectById(id);
        return R.ok().put("data", tixianxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TixianxinxiEntity tixianxinxi, HttpServletRequest request){
    	tixianxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tixianxinxi);
        tixianxinxiService.insert(tixianxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TixianxinxiEntity tixianxinxi, HttpServletRequest request){
    	tixianxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tixianxinxi);
        tixianxinxiService.insert(tixianxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody TixianxinxiEntity tixianxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tixianxinxi);
        tixianxinxiService.updateById(tixianxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tixianxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<TixianxinxiEntity> wrapper = new EntityWrapper<TixianxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("maijia")) {
			wrapper.eq("maijiazhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = tixianxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
