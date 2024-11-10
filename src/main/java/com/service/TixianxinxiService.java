package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TixianxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TixianxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TixianxinxiView;


/**
 * 提现信息
 *
 * @author 
 * @email 
 * @date 2022-03-27 20:32:02
 */
public interface TixianxinxiService extends IService<TixianxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TixianxinxiVO> selectListVO(Wrapper<TixianxinxiEntity> wrapper);
   	
   	TixianxinxiVO selectVO(@Param("ew") Wrapper<TixianxinxiEntity> wrapper);
   	
   	List<TixianxinxiView> selectListView(Wrapper<TixianxinxiEntity> wrapper);
   	
   	TixianxinxiView selectView(@Param("ew") Wrapper<TixianxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TixianxinxiEntity> wrapper);
   	

}

