package com.ebaycloud.rigger.business.vo;


import com.ebaycloud.rigger.business.entity.Tags;
import com.ebaycloud.rigger.framework.object.BaseConditionVO;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class TagsConditionVO extends BaseConditionVO {
	private Tags tags;
}

