package kh.com.petbreedding;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//testtest

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "/common/index";
	}
	
	//사업자 페이지로 이동
	@RequestMapping(value = "/bIndex", method = RequestMethod.GET)
	public String successPay(Locale locale, Model model) {
		return "/bPartner/bIndex";
	}
	
	//사업자 페이지로 이동
		@RequestMapping(value = "/introduction", method = RequestMethod.GET)
		public String introduce(Locale locale, Model model) {
			return "/common/introduce";
		}
	
	
}
