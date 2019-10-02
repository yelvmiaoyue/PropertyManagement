package service.Impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mapper.RepairMapper;
import pojo.RepairRecord;
import pojo.SearchCondition;
import pojo.SearchData;
import service.RepairService;

@Service
public class RepairServiceImpl implements RepairService {
	@Resource
	private RepairMapper repairMapper;

	@Override
	public SearchData selRepairRecord(SearchData data, int id) {
		data.setPageStart(data.getPageSize() * (data.getPageNum() - 1));
		data.setRepairRecord(repairMapper.selRepairRecord(data, id));
		int total = repairMapper.selRepairRecordOne(id);
		int temp = total % data.getPageSize();
		if (temp == 0) {
			data.setTotal(total / data.getPageSize());
		} else {
			data.setTotal(total / data.getPageSize() + 1);
		}
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		List<RepairRecord> list = data.getRepairRecord();
		for (int i = 0; i < list.size(); i++) {
			RepairRecord a = list.get(i);
			a.setTimeString(fmt.format(a.getAddTime()));
		}
		return data;
	}

	@Override
	public boolean insRepairRecord(RepairRecord record) {
		record.setStatus(0);
		record.setAddTime(new Timestamp(new Date().getTime()));
		return repairMapper.insRepairRecord(record);
	}

	@Override
	public SearchData selRepairManagement(SearchData data) {
		data.setPageStart(data.getPageSize() * (data.getPageNum() - 1));
		RepairRecord record = new RepairRecord();
		record.setStatus(-1);
		data.setRepairRecord(repairMapper.selRepairSearch(record, data));
		int total = repairMapper.selRepairRecordAll(record);
		int temp = total % data.getPageSize();
		if (temp == 0) {
			data.setTotal(total / data.getPageSize());
		} else {
			data.setTotal(total / data.getPageSize() + 1);
		}
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		List<RepairRecord> list = data.getRepairRecord();
		for (int i = 0; i < list.size(); i++) {
			RepairRecord a = list.get(i);
			a.setTimeString(fmt.format(a.getAddTime()));
		}
		return data;
	}

	@Override
	public boolean updRepairRecord(RepairRecord record) {
		return repairMapper.updRepairRecord(record);
	}

	@Override
	public SearchData selRepairSearch(SearchCondition con) {
		SearchData data = con.getData();
		data.setPageStart(data.getPageSize() * (data.getPageNum() - 1));
		data.setRepairRecord(repairMapper.selRepairSearch(con.getRecord(), data));
		int total = repairMapper.selRepairRecordAll(con.getRecord());
		int temp = total % data.getPageSize();
		if (temp == 0) {
			data.setTotal(total / data.getPageSize());
		} else {
			data.setTotal(total / data.getPageSize() + 1);
		}
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		List<RepairRecord> list = data.getRepairRecord();
		for (int i = 0; i < list.size(); i++) {
			RepairRecord a = list.get(i);
			a.setTimeString(fmt.format(a.getAddTime()));
		}
		return data;
	}

}
