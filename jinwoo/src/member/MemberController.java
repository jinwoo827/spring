package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/")
public class MemberController {
	private Log log = LogFactory.getLog(getClass());
	private Service service;
	public MemberController(Service service){
		this.service = service;
		log.info(service+"����");
	
	}
	
	@RequestMapping(value = "loginForm.do")
	public String loginForm(){
		return "member/loginForm";
	}
	@RequestMapping(value = "joinForm.do")
	public String joinForm(){
		return "member/joinForm";
	}
	@RequestMapping(value = "main.do")
	public String main(){
		return "member/login";
	}
	
	
	
	
	@RequestMapping(value = "editForm.do")
	public ModelAndView editForm(HttpSession session, HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		session = req.getSession(false);
		String userId = (String)session.getAttribute("id");	
		Member m = service.findMember(userId);		
		mav.setViewName("member/editForm");
		mav.addObject("m", m);
		return mav;
	}
	@RequestMapping(value = "edit.do")
	public String edit(Member m){
		service.updateMember(m);
		return "redirect:/member/main.do";
	}
	
	
	
	@RequestMapping(value = "join.do")
	public String join(Member m){
		boolean flag = service.insertMember(m);
	
		if(flag){
			log.info(m+"���ԿϷ�");
			return "redirect:/member/loginForm.do";
		} else {
			log.info("���Խ���");
			return "redirect:/member/joinForm.do";
		}
		
	}
	
	@RequestMapping( value = "checKId.do")
	public ModelAndView checkId(@RequestParam (value = "userId") String userId){
		
		ModelAndView mav = new ModelAndView();
		String str = service.checkId(userId);
		mav.addObject("str", str);
		mav.setViewName("member/checkId");
		return mav;
	}
	
	
	
	@RequestMapping(value = "login.do")
	public String login(Member m, HttpSession session, HttpServletRequest request){
		String result = "";
		boolean flag =  service.login(m.getUserId(), m.getUserPwd());
		if(flag){
			session = request.getSession();
			session.setAttribute("id", m.getUserId());
			result = "redirect:/member/main.do";
		} else {
			result = "redirect:/member/loginForm.do";
		}
		return result;
	}
	
	@RequestMapping(value = "logout.do")
	public String logout(HttpSession session, HttpServletRequest request){
		session = request.getSession(false);
		session.removeAttribute("id");
		session.invalidate();
		return "redirect:/member/loginForm.do";
	}
	
	@RequestMapping(value = "del.do")
	public String del(HttpSession session, HttpServletRequest req){
		session = req.getSession(false);
		String userId = (String)session.getAttribute("id");
		service.deleteMember(userId);
		session.removeAttribute("id");
		session.invalidate();
		return "redirect:/member/loginForm.do";
	}

}
