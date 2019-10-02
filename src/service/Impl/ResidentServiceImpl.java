package service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mapper.ResidentMapper;
import pojo.Resident;
import pojo.ResidentAndMember;
import pojo.SearchCondition;
import pojo.SearchData;
import service.ResidentService;

@Service
public class ResidentServiceImpl implements ResidentService {
	@Resource
	private ResidentMapper residentMapper;

	@Override
	public Resident selResidentInfo(int id) {
		Resident rs = residentMapper.selResidentInfo(id);
		rs.setResidentMember(residentMapper.selResidentMember(id));
		return rs;
	}

	@Override
	public boolean delMember(int id) {
		return residentMapper.delMember(id);
	}

	@Override
	public List<Integer> updResidentInfo(ResidentAndMember x) {
		List<Integer> idList=new ArrayList<>();
		residentMapper.updResidentInfo(x.getResident());
		for (int i = 0; i < x.getUpd().size(); i++) {
			residentMapper.updMember(x.getUpd().get(i));
		}
		for (int i = 0; i < x.getIns().size(); i++) {
			residentMapper.insMember(x.getIns().get(i));
			idList.add(residentMapper.selMember(x.getIns().get(i)));
			
		}
		return idList;
	}

	@Override
	public SearchData selResidentManagement(SearchData data) {
		data.setPageStart(data.getPageSize() * (data.getPageNum() - 1));
		Resident resident = new Resident();
		data.setResident(residentMapper.selResidentSearch(resident, data));
		int total = residentMapper.selTotalAll(resident);
		int temp = total % data.getPageSize();
		if (temp == 0) {
			data.setTotal(total / data.getPageSize());
		} else {
			data.setTotal(total / data.getPageSize() + 1);
		}
		return data;
	}

	@Override
	public SearchData selResidentSearch(SearchCondition con) {
		SearchData data = con.getData();
		data.setPageStart(data.getPageSize() * (data.getPageNum() - 1));
		data.setResident(residentMapper.selResidentSearch(con.getResident(), data));
		int total = residentMapper.selTotalAll(con.getResident());
		int temp = total % data.getPageSize();
		if (temp == 0) {
			data.setTotal(total / data.getPageSize());
		} else {
			data.setTotal(total / data.getPageSize() + 1);
		}
		return data;
	}

}
