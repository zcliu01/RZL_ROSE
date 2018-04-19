package com.zrt.infor.service.inforinbox;

import com.zrt.mybatis.domain.PlatInforInbox;
import com.zrt.mybatis.mapper.PlatInforInboxMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by msKui on 2017/3/23.
 */
public class InforInboxServiceImpl implements InforInboxService {
    @Autowired
    private PlatInforInboxMapper platInforInboxMapper;

    @Override
    public int saveInforInbox(PlatInforInbox platInforInbox) {
        return platInforInboxMapper.insertSelective(platInforInbox);
    }

    @Override
    public int updateByPrimaryKeySelective(PlatInforInbox platInforInbox) {
        return platInforInboxMapper.updateByPrimaryKeySelective(platInforInbox);
    }
}
