package controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Car;
import pojo.CarPosition;
import pojo.SearchCondition;
import pojo.SearchData;
import service.CarService;

@Controller
public class CarController {
	@Resource
	private CarService carServiceImpl;

	@RequestMapping("carRegister")
	@ResponseBody
	public Car selCarById(int userId) {
		return carServiceImpl.selCarById(userId);
	}

	@RequestMapping("updCarInfo")
	@ResponseBody
	public boolean updCarInfo(Car car) {
		return carServiceImpl.updCarInfo(car);
	}

	@RequestMapping("insCarInfo")
	@ResponseBody
	public boolean insCarInfo(Car car) {
		return carServiceImpl.insCarInfo(car);
	}

	@RequestMapping("carManagement")
	@ResponseBody
	public SearchData carManagement(SearchData data) {
		return carServiceImpl.selCarManagement(data);
	}

	@RequestMapping("carSearch")
	@ResponseBody
	public SearchData carSearch(@RequestBody SearchCondition con) {
		return carServiceImpl.selCarSearch(con);
	}

	@RequestMapping("selCarPostion")
	@ResponseBody
	public List<CarPosition> selCarPostion() {
		return carServiceImpl.selCarPosition();
	}

	@RequestMapping("giveCarPostion")
	@ResponseBody
	public boolean giveCarPostion(Car car) {
		return carServiceImpl.givePosition(car);
	}
}
