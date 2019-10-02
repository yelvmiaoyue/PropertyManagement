package service;

import java.util.List;

import pojo.Device;
import pojo.FixRecord;
import pojo.SearchData;

public interface DeviceService {
	SearchData selFixRecord(SearchData data);

	boolean insFixRecord(FixRecord record);

	boolean insDevice(Device device);

	SearchData selDevice(SearchData data);

	boolean updDevice(Device device);

	boolean delDevice(List<String> id);
}
