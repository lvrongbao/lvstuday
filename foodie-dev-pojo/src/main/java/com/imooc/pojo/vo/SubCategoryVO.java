package com.imooc.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: lvrb
 * @Date: 2020/11/18 19:38
 * @Description:三级分类vo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubCategoryVO {
    private Integer subId;
    private String subName;
    private String subType;
    private Integer subFatherId;

}
