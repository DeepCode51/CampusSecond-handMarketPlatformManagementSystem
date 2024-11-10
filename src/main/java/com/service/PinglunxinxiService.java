package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PinglunxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PinglunxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PinglunxinxiView;


/**
 * 评论信息
 *
 * @author 
 * @email 
 * @date 2022-03-27 20:32:02
 */
public interface PinglunxinxiService extends IService<PinglunxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PinglunxinxiVO> selectListVO(Wrapper<PinglunxinxiEntity> wrapper);
   	
   	PinglunxinxiVO selectVO(@Param("ew") Wrapper<PinglunxinxiEntity> wrapper);
   	
   	List<PinglunxinxiView> selectListView(Wrapper<PinglunxinxiEntity> wrapper);
   	
   	PinglunxinxiView selectView(@Param("ew") Wrapper<PinglunxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PinglunxinxiEntity> wrapper);
   	

}

