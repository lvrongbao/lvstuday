package com.imooc.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于展示商品评价数量的vo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentLevelCountsVO {

    public Integer totalCounts;
    public Integer goodCounts;
    public Integer normalCounts;
    public Integer badCounts;


}
