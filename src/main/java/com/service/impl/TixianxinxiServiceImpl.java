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


import com.dao.TixianxinxiDao;
import com.entity.TixianxinxiEntity;
import com.service.TixianxinxiService;
import com.entity.vo.TixianxinxiVO;
import com.entity.view.TixianxinxiView;

@Service("tixianxinxiService")
public class TixianxinxiServiceImpl extends ServiceImpl<TixianxinxiDao, TixianxinxiEntity> implements TixianxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TixianxinxiEntity> page = this.selectPage(
                new Query<TixianxinxiEntity>(params).getPage(),
                new EntityWrapper<TixianxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TixianxinxiEntity> wrapper) {
		  Page<TixianxinxiView> page =new Query<TixianxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TixianxinxiVO> selectListVO(Wrapper<TixianxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TixianxinxiVO selectVO(Wrapper<TixianxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TixianxinxiView> selectListView(Wrapper<TixianxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TixianxinxiView selectView(Wrapper<TixianxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
