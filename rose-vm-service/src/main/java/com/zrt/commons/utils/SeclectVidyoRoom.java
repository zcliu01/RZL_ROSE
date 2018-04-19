package com.zrt.commons.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrt.mybatis.domain.VmBusVidyoRoom;
import com.zrt.mybatis.domain.VmBusVidyoRoomExample;
import com.zrt.mybatis.mapper.VmBusVidyoRoomMapper;

@Service
public class SeclectVidyoRoom {

	@Autowired
	private VmBusVidyoRoomMapper vmBusVidyoRoomMapper;

	public VmBusVidyoRoom seclectVidyoRoom() {
		synchronized (this) {
			VmBusVidyoRoom vmBusVidyoRoom = null;
			VmBusVidyoRoomExample example = new VmBusVidyoRoomExample();
			example.createCriteria().andRoomStatusEqualTo("0");
			List<VmBusVidyoRoom> vidyoRoomList = vmBusVidyoRoomMapper.selectByExample(example);
			if (vidyoRoomList != null && vidyoRoomList.size() > 0) {
				vmBusVidyoRoom = vidyoRoomList.get(0);
			}

			return vmBusVidyoRoom;
		}
	}

}
