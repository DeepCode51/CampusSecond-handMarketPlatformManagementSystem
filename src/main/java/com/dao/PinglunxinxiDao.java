package com.dao;

import com.entity.PinglunxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PinglunxinxiVO;
import com.entity.view.PinglunxinxiView;


/**
 * 评论信息
 * 
 * @author 
 * @email 
 * @date 2022-03-27 20:32:02
 */
public interface PinglunxinxiDao extends BaseMapper<PinglunxinxiEntity> {
	
	List<PinglunxinxiVO> selectListVO(@Param("ew") Wrapper<PinglunxinxiEntity> wrapper);
	
	PinglunxinxiVO selectVO(@Param("ew") Wrapper<PinglunxinxiEntity> wrapper);
	
	List<PinglunxinxiView> selectListView(@Param("ew") Wrapper<PinglunxinxiEntity> wrapper);

	List<PinglunxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<PinglunxinxiEntity> wrapper);
	
	PinglunxinxiView selectView(@Param("ew") Wrapper<PinglunxinxiEntity> wrapper);
	

}
