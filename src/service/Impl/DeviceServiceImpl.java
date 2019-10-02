package service.Impl;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mapper.DeviceMapper;
import pojo.Device;
import pojo.FixRecord;
import pojo.SearchData;
import service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService {
	@Resource
	private DeviceMapper deviceMapper;

	@Override
	public SearchData selFixRecord(SearchData data) {
		data.setPageStart(data.getPageSize() * (data.getPageNum() - 1));
		data.setFixRecord(deviceMapper.selFixRecord(data));
		int total = deviceMapper.selFixRecordTotal();
		int temp = total % data.getPageSize();
		if (temp == 0) {
			data.setTotal(total / data.getPageSize());
		} else {
			data.setTotal(total / data.getPageSize() + 1);
		}
		return data;
	}

	@Override
	public boolean insFixRecord(FixRecord record) {
		Device check = deviceMapper.selDeviceCheck(record.getDeviceId());
		if (check != null) {
			record.setType(check.getType());
			boolean rs = deviceMapper.insFixRecord(record);
			if (rs) {
				deviceMapper.updFixTime(record);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean insDevice(Device device) {
		Device check = deviceMapper.selDeviceCheck(device.getId());
		if (check == null) {
			Date addTime = new Date(new GregorianCalendar().getTimeInMillis());
			device.setAddTime(addTime);
			boolean rs = deviceMapper.insDevice(device);
			if (rs) {
				return true;
			}
		}
		return false;
	}

	@Override
	public SearchData selDevice(SearchData data) {
		data.setPageStart(data.getPageSize() * (data.getPageNum() - 1));
		data.setDevice(deviceMapper.selDevice(data));
		int total = deviceMapper.selDeviceTotal();
		int temp = total % data.getPageSize();
		if (temp == 0) {
			data.setTotal(total / data.getPageSize());
		} else {
			data.setTotal(total / data.getPageSize() + 1);
		}
		return data;
	}

	@Override
	public boolean updDevice(Device device) {
		return deviceMapper.updDevice(device);
	}

	@Override
	public boolean delDevice(List<String> id) {
		for (int i = 0; i < id.size(); i++) {
			boolean rs = deviceMapper.delDevice(id.get(i));
			if (!rs) {
				throw new RuntimeException();
			}
		}
		return true;
	}

}
