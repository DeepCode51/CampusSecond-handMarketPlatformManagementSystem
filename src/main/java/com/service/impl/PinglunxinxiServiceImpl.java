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


import com.dao.PinglunxinxiDao;
import com.entity.PinglunxinxiEntity;
import com.service.PinglunxinxiService;
import com.entity.vo.PinglunxinxiVO;
import com.entity.view.PinglunxinxiView;

@Service("pinglunxinxiService")
public class PinglunxinxiServiceImpl extends ServiceImpl<PinglunxinxiDao, PinglunxinxiEntity> implements PinglunxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PinglunxinxiEntity> page = this.selectPage(
                new Query<PinglunxinxiEntity>(params).getPage(),
                new EntityWrapper<PinglunxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PinglunxinxiEntity> wrapper) {
		  Page<PinglunxinxiView> page =new Query<PinglunxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<PinglunxinxiVO> selectListVO(Wrapper<PinglunxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PinglunxinxiVO selectVO(Wrapper<PinglunxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PinglunxinxiView> selectListView(Wrapper<PinglunxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PinglunxinxiView selectView(Wrapper<PinglunxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
