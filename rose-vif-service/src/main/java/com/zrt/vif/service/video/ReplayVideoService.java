package com.zrt.vif.service.video;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zrt.commons.AppException;
import com.zrt.portal.replay.RecordScopeFilter;
import com.zrt.portal.replay.RecordsSearchRequest;
import com.zrt.portal.replay.RecordsSearchResponse;
import com.zrt.portal.replay.SortBy;
import com.zrt.portal.replay.SortDirection;
import com.zrt.portal.replay.VidyoReplayContentManagementService;
import com.zrt.portal.replay.VidyoReplayContentManagementServicePortType;

@Service
public class ReplayVideoService {

	private static final Logger log = LoggerFactory.getLogger(ReplayVideoService.class);

	@Value("${vidyo.replayURL}")
	private String replayURL;
	@Value("${vidyo.replay_no}")
	private String replayNo;
	@Value("${vidyo.replay_password}")
	private String replaypassword;

	/**
	 * 连接服务
	 * 
	 * @return
	 * @throws AppException
	 */
	public VidyoReplayContentManagementServicePortType serverConnection() throws AppException {
		String replayAddress = replayURL + "/replay/services/VidyoReplayContentManagementService";

		final String WS_URL = replayURL + "/replay/services/VidyoReplayContentManagementService?wsdl";
		VidyoReplayContentManagementServicePortType servicePort = null;
		try {
			URL url = new URL(WS_URL);
			QName qname = new QName("http://replay.vidyo.com/apiservice", "VidyoReplayContentManagementService");

			VidyoReplayContentManagementService replayService = new VidyoReplayContentManagementService(url, qname);
			servicePort = replayService.getPort(VidyoReplayContentManagementServicePortType.class);

			BindingProvider bp = (BindingProvider) servicePort;// 用户认证
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, replayAddress);
			bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, replayNo);
			bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, replaypassword);

		} catch (MalformedURLException e) {
			e.printStackTrace();
			log.info("vidyo服务replay连接失败！");
			throw new AppException("vidyo服务replay连接失败！");
		}
		return servicePort;
	}

	/**
	 * 获取录制视频URL
	 * 
	 * @param ownerName（视频会议房间创建者）
	 * @return
	 * @throws AppException
	 */
	public Map<String, Object> recordsSearch(String ownerName, String roomName) throws AppException {

		Map<String, Object> resMap = new HashMap<String, Object>();

		VidyoReplayContentManagementServicePortType servicePort = serverConnection();
		try {
			RecordsSearchRequest createPublicRoomRequest = new RecordsSearchRequest();
			createPublicRoomRequest.setRoomFilter("");
			createPublicRoomRequest.setTenantName("");
			createPublicRoomRequest.setUsernameFilter(ownerName);
			createPublicRoomRequest.setQuery("");
			createPublicRoomRequest.setRecordScope(RecordScopeFilter.ALL);
			createPublicRoomRequest.setSortBy(SortBy.DATE);
			createPublicRoomRequest.setDir(SortDirection.DESC);
			createPublicRoomRequest.setLimit(20);
			createPublicRoomRequest.setStart(0);
			createPublicRoomRequest.setWebcast(false);

			RecordsSearchResponse recordsSearchResponse = servicePort.recordsSearch(createPublicRoomRequest);
			if (recordsSearchResponse.getRecords().size() > 0) {
				String guid = "";
				for (int i = 0; i < recordsSearchResponse.getRecords().size(); i++) {
					if (roomName.equals(recordsSearchResponse.getRecords().get(i).getRoomName())) {
						guid = recordsSearchResponse.getRecords().get(i).getGuid();
						resMap.put("guid", guid);
						log.info("vidyo获取录制URL成功!");
					}
				}
			} else {
				log.info("vidyo获取录制URL为空!");
			}

		} catch (Exception e) {
			log.info("vidyo获取录制URL失败!");
			throw new AppException("vidyo获取录制URL失败!");
		}
		return resMap;
	}

}
