package com.ebaycloud.rigger.business.vo;

import com.ebaycloud.rigger.framework.object.BaseConditionVO;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class TypeConditionVO extends BaseConditionVO {
	private Long pid;
	private String name;
	private String description;
	private Integer sort;
	private Boolean available;
	private String icon;
}

