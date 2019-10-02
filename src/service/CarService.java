package service;

import java.util.List;

import pojo.Car;
import pojo.CarPosition;
import pojo.SearchCondition;
import pojo.SearchData;

public interface CarService {
	Car selCarById(int id);

	boolean updCarInfo(Car car);

	boolean insCarInfo(Car car);

	SearchData selCarManagement(SearchData data);

	SearchData selCarSearch(SearchCondition con);

	List<CarPosition> selCarPosition();

	boolean givePosition(Car car);
}
