package com.dao;

import com.entity.TixianxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TixianxinxiVO;
import com.entity.view.TixianxinxiView;


/**
 * 提现信息
 * 
 * @author 
 * @email 
 * @date 2022-03-27 20:32:02
 */
public interface TixianxinxiDao extends BaseMapper<TixianxinxiEntity> {
	
	List<TixianxinxiVO> selectListVO(@Param("ew") Wrapper<TixianxinxiEntity> wrapper);
	
	TixianxinxiVO selectVO(@Param("ew") Wrapper<TixianxinxiEntity> wrapper);
	
	List<TixianxinxiView> selectListView(@Param("ew") Wrapper<TixianxinxiEntity> wrapper);

	List<TixianxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<TixianxinxiEntity> wrapper);
	
	TixianxinxiView selectView(@Param("ew") Wrapper<TixianxinxiEntity> wrapper);
	

}
