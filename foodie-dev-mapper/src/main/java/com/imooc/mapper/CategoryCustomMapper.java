package com.imooc.mapper;

import com.imooc.pojo.vo.CategoryVO;
import com.imooc.pojo.vo.NewItemsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CategoryCustomMapper  {

    List<CategoryVO>getSubCatList(Integer rootCatId);

    List<NewItemsVO>getSixNewItemsLazy(@Param("parmMap") Map<String,Object> map);
}