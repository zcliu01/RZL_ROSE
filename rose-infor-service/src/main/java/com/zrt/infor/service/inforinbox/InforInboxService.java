package com.zrt.infor.service.inforinbox;

import com.zrt.mybatis.domain.PlatInforInbox;

/**
 * Created by msKui on 2017/3/21.
 */
public interface InforInboxService {
    /**
     * 新增讯息
     *
     * @param platInforInbox
     * @return
     */
    int saveInforInbox(PlatInforInbox platInforInbox);

    /**
     * 修改讯息
     * @param platInforInbox
     * @return
     */
    int updateByPrimaryKeySelective(PlatInforInbox platInforInbox);
}
