package com.zrt.sec.service.vpn;

import java.util.List;
import java.util.Map;

import javax.crypto.Cipher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zrt.commons.date.DateUtil;
import com.zrt.commons.sign.CipherUtil;
import com.zrt.mybatis.domain.EmpVpnSync;
import com.zrt.mybatis.domain.EmpVpnSyncExample;
import com.zrt.mybatis.mapper.EmpVpnSyncMapper;
import com.zrt.sec.mapper.vpn.VpnCustomMapper;
import com.zrt.sec.service.serial.SerialService;

@Service
public class VpnServiceImpl implements VpnService {
	@Autowired
	private EmpVpnSyncMapper vpnMapper;
	@Autowired
	private VpnCustomMapper vpnCustomMapper;
	@Autowired
	private SerialService serialService;

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void vpnSave(Map<String, Object> appMap) throws Exception {

		@SuppressWarnings("unchecked")
		List<Map<String, Object>> vpnList = (List<Map<String, Object>>) appMap.get("sync");
		if (vpnList != null && vpnList.size() > 0) {
			for (Map<String, Object> vpnMap : vpnList) {
				String empId = (String) vpnMap.get("emp_id");
				String deviceId = (String) vpnMap.get("deviceid");
				EmpVpnSyncExample example = new EmpVpnSyncExample();
				example.createCriteria().andEmpIdEqualTo(empId).andDeviceIdDecEqualTo(deviceId);
				List<EmpVpnSync> vpnLi = vpnMapper.selectByExample(example);
				if (vpnLi != null && vpnLi.size() > 0) {
					vpnMapper.deleteByExample(example);
				}
//				String deviceIdDec = CipherUtil.decryptMode(deviceId);//解密
				vpnMap.put("id", serialService.getUUID());
				vpnMap.put("device_id_nec", "");
				vpnMap.put("create_date_time", DateUtil.getCurrentDateTime());
			}
		}
		vpnCustomMapper.vpnAllInsert(vpnList);

		// EmpVpnSync vpn = new EmpVpnSync();
		// vpn.setId(serialService.getUUID());
		// vpn.setEmpId((String) appMap.get("emp_id"));
		// vpn.setDeviceMd5((String) appMap.get("emp_pwd "));
		// vpn.setDeviceId((String) appMap.get("deviceid"));
		// vpn.setCreateDateTime(DateUtil.getCurrentDateTime());
		// vpnMapper.insertSelective(vpn);

	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void vpnDelete(Map<String, Object> appMap) throws Exception {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> vpnList = (List<Map<String, Object>>) appMap.get("sync");
		if (vpnList != null && vpnList.size() > 0) {
			for (Map<String, Object> vpnMap : vpnList) {
				EmpVpnSyncExample example = new EmpVpnSyncExample();
				example.createCriteria().andEmpIdEqualTo((String) vpnMap.get("emp_id"))
						.andDeviceIdDecEqualTo((String) vpnMap.get("deviceid"));
				vpnMapper.deleteByExample(example);
			}
		}

	}

	@Override
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void vpnAllSync(Map<String, Object> appMap) throws Exception {

		@SuppressWarnings("unchecked")
		List<Map<String, Object>> vpnList = (List<Map<String, Object>>) appMap.get("param");
		if (vpnList != null && vpnList.size() > 0) {
			for (Map<String, Object> vpnMap : vpnList) {
				vpnMap.put("id", serialService.getUUID());
				vpnMap.put("create_date_time", DateUtil.getCurrentDateTime());
			}
		}
		vpnCustomMapper.vpnAllInsert(vpnList);
	}

}
