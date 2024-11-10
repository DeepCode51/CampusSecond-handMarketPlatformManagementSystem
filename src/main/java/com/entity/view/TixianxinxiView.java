package com.entity.view;

import com.entity.TixianxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 提现信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-03-27 20:32:02
 */
@TableName("tixianxinxi")
public class TixianxinxiView  extends TixianxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TixianxinxiView(){
	}
 
 	public TixianxinxiView(TixianxinxiEntity tixianxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, tixianxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
