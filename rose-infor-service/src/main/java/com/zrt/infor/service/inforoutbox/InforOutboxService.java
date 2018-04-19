package com.zrt.infor.service.inforoutbox;

import com.zrt.mybatis.domain.PlatInforOutbox;

/**
 * Created by msKui on 2017/3/21.
 */
public interface InforOutboxService {
    /**
     * 新增讯息
     *
     * @param platInforOutbox
     * @return
     */
    int saveInforOutbox(PlatInforOutbox platInforOutbox);

    /**
     * 修改讯息
     * @param platInforOutbox
     * @return
     */
    int updateByPrimaryKeySelective(PlatInforOutbox platInforOutbox);
}
