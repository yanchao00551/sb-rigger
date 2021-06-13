package com.ebaycloud.rigger.persistence.mapper;


import com.ebaycloud.rigger.business.vo.TypeConditionVO;
import com.ebaycloud.rigger.persistence.beans.BizType;
import com.ebaycloud.rigger.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BizTypeMapper extends BaseMapper<BizType> {

    /**
     * 分页查询
     * @param vo
     *
     * @return
     */
    List<BizType> findPageBreakByCondition(TypeConditionVO vo);

    List<BizType> listParent();

    List<BizType> listTypeForMenu();
}
