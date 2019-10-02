package service;

import pojo.RepairRecord;
import pojo.SearchCondition;
import pojo.SearchData;

public interface RepairService {
	SearchData selRepairRecord(SearchData data, int id);

	boolean insRepairRecord(RepairRecord record);

	SearchData selRepairManagement(SearchData data);

	boolean updRepairRecord(RepairRecord record);

	SearchData selRepairSearch(SearchCondition con);
}
