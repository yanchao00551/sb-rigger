package com.ebaycloud.rigger.business.service;


import com.ebaycloud.rigger.business.entity.Type;
import com.ebaycloud.rigger.business.vo.TypeConditionVO;
import com.ebaycloud.rigger.framework.object.AbstractService;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 分类
 */
public interface BizTypeService extends AbstractService<Type, Long> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<Type> findPageBreakByCondition(TypeConditionVO vo);

    List<Type> listParent();

    List<Type> listTypeForMenu();
}
