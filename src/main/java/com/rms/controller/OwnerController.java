package com.rms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rms.dao.MenuDAOImpl;
import com.rms.dto.Bill;
import com.rms.dto.Expenditure;
import com.rms.dto.MenuItem;
import com.rms.dto.OrderMenuItem;
import com.rms.dto.RecordDTO;
import com.rms.dto.User;
import com.rms.service.AnalysisService;
import com.rms.service.BillService;
import com.rms.service.ExcelSheetService;
import com.rms.service.ExcelSheetValidation;
import com.rms.service.ExpenditureService;
import com.rms.service.MenuItemService;


@Controller
@RequestMapping("/owner")
public class OwnerController {
	
	private String format = "owner-";
	
	/**
	 * This variable is used to set the path for <a href> links by making it easier
	 * to access the Context Path dynamically.
	 */

	@Value("#{servletContext.contextPath}")
	private String servletContextPath;
	
	@Autowired
	private ExcelSheetValidation excelSheetValidation;
	
	@Autowired
	private ExcelSheetService excelSheetService;
	
	@Autowired
	private MenuDAOImpl menuDAOImpl;
	
	@Autowired
	private MenuItemService menuItemService;
	
	@Autowired
	private BillService billService;
	
	@Autowired
	private ExpenditureService expenditureService;
	
	@Autowired
	private AnalysisService analysisService;
	
	private List<OrderMenuItem> listOfOrderMenuItem = new ArrayList<OrderMenuItem>();
	
	@RequestMapping("/temp")
	public String getTemp() {
		return "temp-page";
	}
	
	@RequestMapping("/addmenu")
	public String getAddMenuItems(Model model) {
		model.addAttribute("path", servletContextPath);
		return format + "add-menu";
	}
	
	@RequestMapping("/addmenu/excelsheet")
	public String getExcelSheet(Model model) {
		model.addAttribute("path", servletContextPath);
		return format + "add-menu-excel";
	}
	
	@RequestMapping(value = "/processExcel", method = RequestMethod.POST)
	public String processExcel(Model model, @RequestParam("excelfile") MultipartFile excelfile) {
		ArrayList<MenuItem> listOfMenuItemsFromExcel = new ArrayList<MenuItem>();
		String message;
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(excelfile.getInputStream());
			HSSFSheet worksheet = workbook.getSheetAt(0);
			message = excelSheetValidation.isSheetStructureValid(worksheet);
			if(message != null)
				model.addAttribute("errorMessage", excelSheetService.getErrorMessage(message));
			else {
				listOfMenuItemsFromExcel = excelSheetService.fetchRecordsFromExcelSheet(worksheet);
				workbook.close();
				if(excelSheetService.checkIfListOfMenuItemsExist(listOfMenuItemsFromExcel))
					excelSheetService.removeAllMenuItems();
				menuDAOImpl.insertListOfRecordsIntoDatabase(listOfMenuItemsFromExcel);
				model.addAttribute("lstUser", listOfMenuItemsFromExcel);
			}
		} catch (Exception e) {
			model.addAttribute("errorMessage", "There was a Server Issue. Sorry for the inconvenience.");
			e.printStackTrace();
		}
		return format + "add-menu-excel";
	}
	
	@RequestMapping("/addmenu/viewmenu")
	public String getViewMenu(Model model) {
		List<MenuItem> listOfMenuItems = menuItemService.fetchAllItems();
		model.addAttribute("listOfItems", listOfMenuItems);
		return format + "add-menu-view";
	}
	
	@RequestMapping("/ordermenu")
	public String getOrderMenu(Model model) {
		List<String> listOfAllMenuItemIds = menuItemService.getListOfAllMenuItemIds();
		MenuItem menuItem = new MenuItem();
		model.addAttribute("list", listOfAllMenuItemIds);
		model.addAttribute("path", servletContextPath);
		model.addAttribute("menuItem", menuItem);
		return format + "order-menu";
	}
	
	@RequestMapping("/ordermenu/search")
	public String getOrderSearch(@ModelAttribute("menuItem") MenuItem menuItem, Model model) {
		List<String> listOfAllMenuItemIds = menuItemService.getListOfAllMenuItemIds();
		MenuItem myMenuItem = new MenuItem();
		model.addAttribute("list", listOfAllMenuItemIds);
		model.addAttribute("menuItem", myMenuItem);
		model.addAttribute("path", servletContextPath);
		if(!(menuItem.id == ("null-null"))) {
			OrderMenuItem orderMenuItem = new OrderMenuItem(menuItemService.getMenuItemById(menuItem.id));
			model.addAttribute("orderMenuItem", orderMenuItem);
		}
		return format + "order-menu";
	}
	
	@RequestMapping("/ordermenu/add")
	public String getOrderAdd(@ModelAttribute("orderMenuItem") OrderMenuItem myOrderMenuItem, Model model) {
		listOfOrderMenuItem.add(myOrderMenuItem);
		model.addAttribute("path", servletContextPath);
		model.addAttribute("listOfOrderMenuItem", listOfOrderMenuItem);
		return format + "order-menu-add";
	}
	
	@RequestMapping("/ordermenu/confirm")
	public String getOrderConfirm(Model model) {
		model.addAttribute("path", servletContextPath);
		model.addAttribute("user", new User());		
		return format + "order-menu-confirm";
	}
	
	@RequestMapping("/ordermenu/done")
	public String getOrderDone(@ModelAttribute("user") User user, Model model) {
		billService.storeIntoTable(billService.updateNumberOfItem(listOfOrderMenuItem));
		Bill bill = billService.generateBill(listOfOrderMenuItem, user);
		model.addAttribute("content", bill.getContent().replace("\n", "<br /><br />"));
		billService.storeIntoTable(bill);
		listOfOrderMenuItem.clear();
		model.addAttribute("path", servletContextPath);
		return format + "bill-page";
	}
	
	@RequestMapping("/ordermenu/cancel")
	public String getOrderCancel(Model model) {
		listOfOrderMenuItem.clear();
		model.addAttribute("path", servletContextPath);
		return "redirect:/owner";
	}
	
	@RequestMapping("/viewbill")
	public String getViewBill(Model model) {
		List<String> listOfAllBills = billService.getListOfAllBillIdsAlongWithMonthAndDateAndAmount();
		Bill bill = new Bill();
		model.addAttribute("list", listOfAllBills);
		model.addAttribute("path", servletContextPath);
		model.addAttribute("bill", bill);
		return format + "view-bill";
	}
	
	@RequestMapping("/viewbill/display")
	public String getProcessBill(@ModelAttribute("bill") Bill bill, Model model) {
		String content = billService.getContentFromDatabase(bill.getDisplayId());
		model.addAttribute("content", content.replace("\n", "<br /><br />"));
		model.addAttribute("path", servletContextPath);
		return format + "view-bill-display";
	}
	
	@RequestMapping("/expenditure")
	public String getExpenditure(Model model) {
		Expenditure expenditure = new Expenditure();
		model.addAttribute("path", servletContextPath);
		model.addAttribute("expenditure", expenditure);
		return format + "expenditure-page";
	}
	
	@RequestMapping("/addexpenditure")
	public String getAddExpenditure(@ModelAttribute("expenditure") Expenditure expenditure, Model model) {
		Expenditure newExpenditure = new Expenditure(expenditure.getAllExpenditures(), expenditureService.calculateTotalAmount(expenditure.getAllExpenditures()));
		expenditureService.storeIntoDatabase(newExpenditure);
		model.addAttribute("path", servletContextPath);
		model.addAttribute("amount", newExpenditure.getTotal());
		return format + "expenditure-success-page";
	}
	
//	Textual Format: 
	@RequestMapping("/profitlosstextual")
	public String getProfitLossTextual(Model model) {
		String content = expenditureService.getProfitLossStatement();
		model.addAttribute("path", servletContextPath);
		model.addAttribute("content", content.replace("\n", "<br /><br />"));
		return format + "profit-loss-textual";
	}
	
//	Graphical Format:
	@RequestMapping("/profitlossgraphical")
	public String getProfitLossGraphical(ModelMap modelMap) {
		List<List<Map<Object, Object>>> jsDataList = analysisService.getCanvasjsChartData();
		modelMap.addAttribute("dataPointsList", jsDataList);
		modelMap.addAttribute("path", servletContextPath);
		return format + "profit-loss-graphical";
	}
	
	@RequestMapping("/bestsellertextual")
	public String getBestSellerTextual(Model model) {
		List<RecordDTO> listOfRecords = expenditureService.fetchAllRecordsFromTable("april_2022");
		model.addAttribute("listOfRecords", listOfRecords);
		model.addAttribute("path", servletContextPath);
		return format + "bestseller-textual";
	}
	
	@RequestMapping("/bestsellergraphical")
	public String getBestSellerGraphical(Model model) {
		model.addAttribute("path", servletContextPath);
		return format + "bestseller-graphical";
	}
	
	@RequestMapping("/expensis")
	public String getExpensis(Model model) {
		model.addAttribute("path", servletContextPath);
		return format + "expensis-graphical";
	}
}
