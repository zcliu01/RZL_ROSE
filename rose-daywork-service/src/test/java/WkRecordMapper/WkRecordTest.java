package WkRecordMapper;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(WkRecordTest.class)
public class WkRecordTest {

	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:9013");
		this.template = new TestRestTemplate();
	}

	/**
	 * 
	 * 添加日程
	 * 
	 * @throws Exception
	 */
	@Test
	public void userSave() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		//map.put("wk_name", "2017年11月17日");
		map.put("wk_desc", "测试日程添加");
		map.put("begin_date_time", "2017-11-17 10:12");
		map.put("end_date_time", "2017-11-18 20:22");
		map.put("emp_id", "000021");
		String result = template.postForObject(base.toString() + "/v1.0/daywork/save", buildEntity(map), String.class);
		System.out.println("-----添加日程：" + result);

	}

	// 删除日程
	@Test
	public void delete() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "d7cd9aa4760d44ac89de09bf3fd966e4");
		String result = template.postForObject(base.toString() + "/v1.0/daywork/delete", buildEntity(map),
				String.class);
		System.out.println("-----删除日程：" + result);
	}

	// 查询日程
	@Test
	public void detail() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "c5319a713c9e4f66a270ad5a65c9dc90");
		String result = template.postForObject(base.toString() + "/v1.0/appdaywork/detail", buildEntity(map),
				String.class);
		System.out.println("-----查询日程：" + result);
	}
	// 查询日程
	@Test
	public void searchDate() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("emp_id", "009615");
		String result = template.postForObject(base.toString() + "/v1.0/appdaywork/searchDate", buildEntity(map),
				String.class);
		System.out.println("-----查询日程：" + result);
	}

	// 更新日程
	@Test
	public void update() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "871fb45970984671a7ffe01b5c2363b4");
		map.put("wk_name", "A");
		map.put("wk_desc", "a");
		map.put("begin_date_time", "2017-09-13 11:11");
		map.put("end_date_time", "2017-09-13 12:23");
		String result = template.postForObject(base.toString() + "/v1.0/daywork/update", buildEntity(map),
				String.class);
		System.out.println("-----更新日程：" + result);
	}

	// 查询整月日程列表
	@Test
	public void list() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin_date_time", "2017-10-01");
		map.put("end_date_time", "2017-11-30");
		map.put("emp_id", "009615");
		String result = template.postForObject(base.toString() + "/v1.0/daywork/list", buildEntity(map), String.class);
		System.out.println("-----查詢當月日程：" + result);
	}
	
	// 查询單日日程列表
		@Test
		public void dayList() throws Exception {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("emp_id", "000021");
			map.put("day_time", "20170913");
			String result = template.postForObject(base.toString() + "/v1.0/daywork/list", buildEntity(map), String.class);
			System.out.println("-----查詢單日日程：" + result);
		}
		
		
		// 根据日程名字查询
		@Test
		public void wkName() throws Exception {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("day_time", "20171025");
			map.put("emp_id", "000021");
			//map.put("wk_name", "2017年");
			String result = template.postForObject(base.toString() + "/v1.0/daywork/list", buildEntity(map), String.class);
			System.out.println("-----根据日程名字查询：" + result);
		}

		
		// 查询全部日程
		@Test
		public void checkAll() throws Exception {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("emp_id", "000021");
			String result = template.postForObject(base.toString() + "/v1.0/daywork/checkAll", buildEntity(map), String.class);
			System.out.println("-----查询全部日程：" + result);
		}
		
		
		
		
		
		
	private HttpEntity<String> buildEntity(Map<String, Object> params) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new HttpEntity<String>(JSON.toJSONString(params), headers);
	}

}
