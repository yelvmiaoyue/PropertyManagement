package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Bill;
import pojo.SearchCondition;
import pojo.SearchData;
import service.BillService;

@Controller
public class BillController {
	@Resource
	private BillService billServiceImpl;

	@RequestMapping("billSearch")
	@ResponseBody
	public SearchData billSearch(int building, int room, SearchData data) {
		return billServiceImpl.selBill(building, room, data);
	}

	@RequestMapping("validCode")
	@ResponseBody
	public void validCode(HttpServletResponse resp, HttpServletRequest req) {
		BufferedImage image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);

		Graphics2D gra = image.createGraphics();

		gra.setColor(Color.WHITE);
		gra.fillRect(0, 0, 200, 100);

		List<Integer> randList = new ArrayList<Integer>();
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			randList.add(random.nextInt(10));
		}
		gra.setFont(new Font("宋体", Font.ITALIC | Font.BOLD, 40));
		Color[] colors = new Color[] { Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN, Color.PINK, Color.GRAY };
		for (int i = 0; i < randList.size(); i++) {
			gra.setColor(colors[random.nextInt(colors.length)]);
			gra.drawString(randList.get(i) + "", i * 40, 70 + (random.nextInt(21) - 10));
		}

		for (int i = 0; i < 2; i++) {
			gra.setColor(colors[random.nextInt(colors.length)]);
			gra.drawLine(0, random.nextInt(101), 200, random.nextInt(101));
		}
		ServletOutputStream outputStream;
		try {
			outputStream = resp.getOutputStream();
			ImageIO.write(image, "jpg", outputStream);
		} catch (IOException e) {
		}
		HttpSession session = req.getSession();
		String codeString = "" + randList.get(0) + randList.get(1) + randList.get(2) + randList.get(3);
		session.setAttribute("validCode", codeString);
	}

	@RequestMapping("getMoney")
	@ResponseBody
	public BigDecimal selMoney(int id) {
		return billServiceImpl.selMoney(id);
	}

	@RequestMapping("payBill")
	@ResponseBody
	public boolean paybill(int id, int userId, BigDecimal cost) {
		return billServiceImpl.updBill(id, userId, cost);
	}

	@RequestMapping("getCode")
	@ResponseBody
	public String getCode(HttpServletRequest req) {
		HttpSession session = req.getSession();
		return (String) session.getAttribute("validCode");
	}

	@RequestMapping("billManagement")
	@ResponseBody
	public SearchData billManagement(SearchData data) {
		return billServiceImpl.selBillManagement(data);
	}

	@RequestMapping("billManagementSearch")
	@ResponseBody
	public SearchData billManagementSearch(@RequestBody SearchCondition con) {
		return billServiceImpl.selBillSearch(con);
	}

	@RequestMapping("addBill")
	@ResponseBody
	public boolean addBill(Bill bill) {
		return billServiceImpl.insBill(bill);
	}
}
