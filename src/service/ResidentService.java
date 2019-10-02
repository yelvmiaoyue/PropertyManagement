package service;

import java.util.List;

import pojo.Resident;
import pojo.ResidentAndMember;
import pojo.SearchCondition;
import pojo.SearchData;

public interface ResidentService {
	Resident selResidentInfo(int id);

	boolean delMember(int id);

	List<Integer> updResidentInfo(ResidentAndMember x);

	SearchData selResidentManagement(SearchData data);

	SearchData selResidentSearch(SearchCondition con);
}
