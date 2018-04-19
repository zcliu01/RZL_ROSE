package com.zrt.infor.service.inforoutbox;

import com.zrt.mybatis.domain.PlatInforOutbox;
import com.zrt.mybatis.mapper.PlatInforOutboxMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by msKui on 2017/3/23.
 */
public class InforOutboxServiceImpl implements InforOutboxService {
    @Autowired
    private PlatInforOutboxMapper platInforOutboxMapper;

    @Override
    public int saveInforOutbox(PlatInforOutbox platInforOutbox) {
        return platInforOutboxMapper.insertSelective(platInforOutbox);
    }

    @Override
    public int updateByPrimaryKeySelective(PlatInforOutbox platInforOutbox) {
        return platInforOutboxMapper.updateByPrimaryKeySelective(platInforOutbox);
    }
}
