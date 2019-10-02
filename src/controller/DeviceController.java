package controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Device;
import pojo.FixRecord;
import pojo.SearchData;
import service.DeviceService;

@Controller
public class DeviceController {
	@Resource
	private DeviceService deviceServiceImpl;

	@RequestMapping("fixRecord")
	@ResponseBody
	public SearchData fixRecord(SearchData data) {
		return deviceServiceImpl.selFixRecord(data);
	}

	@RequestMapping("addFixRecord")
	@ResponseBody
	public boolean addFixRecord(FixRecord record) {
		return deviceServiceImpl.insFixRecord(record);
	}

	@RequestMapping("addDevice")
	@ResponseBody
	public boolean addDevice(Device device) {
		return deviceServiceImpl.insDevice(device);
	}

	@RequestMapping("updateDevice")
	@ResponseBody
	public SearchData updateDevice(SearchData data) {
		return deviceServiceImpl.selDevice(data);
	}

	@RequestMapping("updateDeviceInfo")
	@ResponseBody
	public boolean updateDeviceInfo(Device device) {
		return deviceServiceImpl.updDevice(device);
	}

	@RequestMapping("deleteDevice")
	@ResponseBody
	public boolean deleteDevice(@RequestBody ArrayList<String> id) {
		return deviceServiceImpl.delDevice(id);
	}
}
