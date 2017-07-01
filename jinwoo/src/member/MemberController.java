package member;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( value = "/member/")
public class MemberController {
	private Log log = LogFactory.getLog(getClass());
	private Service servcie;
	public MemberController(Service service){
		this.servcie = service;
		log.debug(service+"¡÷¿‘");
	}
	
	@RequestMapping(value = "loginForm.do")
	public String loginForm(){
		return "loginForm";
	}
	
	@RequestMapping(value = "join.do")
	public String join(Member m){
		
	}

}
