package service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mapper.CarMapper;
import pojo.Car;
import pojo.CarPosition;
import pojo.SearchCondition;
import pojo.SearchData;
import service.CarService;

@Service
public class CarServiceImpl implements CarService {
	@Resource
	private CarMapper carMapper;

	@Override
	public Car selCarById(int id) {
		return carMapper.selCarById(id);
	}

	@Override
	public boolean updCarInfo(Car car) {
		return carMapper.updCarInfo(car);
	}

	@Override
	public boolean insCarInfo(Car car) {
		return carMapper.insCarInfo(car);
	}

	@Override
	public SearchData selCarManagement(SearchData data) {
		data.setPageStart(data.getPageSize() * (data.getPageNum() - 1));
		Car car = new Car();
		car.setCarNumber("");
		List<Car> t = carMapper.selCarSearch(car, data);
		int total = carMapper.selTotalAll(car);
		for (int i = 0; i < t.size(); i++) {
			car = carMapper.selBuildingAndRoom(t.get(i).getResidentId());
			t.get(i).setBuilding(car.getBuilding());
			t.get(i).setRoom(car.getRoom());
		}
		data.setCar(t);
		int temp = total % data.getPageSize();
		if (temp == 0) {
			data.setTotal(total / data.getPageSize());
		} else {
			data.setTotal(total / data.getPageSize() + 1);
		}
		return data;
	}

	@Override
	public SearchData selCarSearch(SearchCondition con) {
		SearchData data = con.getData();
		Car car = con.getCar();
		data.setPageStart(data.getPageSize() * (data.getPageNum() - 1));
		List<Car> t = carMapper.selCarSearch(car, data);
		int total = carMapper.selTotalAll(car);
		for (int i = 0; i < t.size(); i++) {
			car = carMapper.selBuildingAndRoom(t.get(i).getResidentId());
			t.get(i).setBuilding(car.getBuilding());
			t.get(i).setRoom(car.getRoom());
		}
		data.setCar(t);
		int temp1 = total % data.getPageSize();
		if (temp1 == 0) {
			data.setTotal(total / data.getPageSize());
		} else {
			data.setTotal(total / data.getPageSize() + 1);
		}
		return data;
	}

	@Override
	public List<CarPosition> selCarPosition() {
		return carMapper.selCarPosition();
	}

	@Override
	public boolean givePosition(Car car) {
		Car old = carMapper.selOldPosition(car.getCarNumber());
		if (!(old.getPosition() == null || old.getPosition().equals("无"))) {
			carMapper.updPosition(old.getPosition(), 0);
		}
		boolean rs = carMapper.updCarPosition(car.getCarNumber(), car.getPosition());
		if (!rs) {
			throw new RuntimeException();
		} else {
			if (!car.getPosition().equals("无")) {
				carMapper.updPosition(car.getPosition(), 1);
			}
		}
		return true;
	}

}
