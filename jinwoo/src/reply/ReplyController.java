package reply;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/reply/")
public class ReplyController {
	private Service replyService;
	
	public void setReplyService(Service service){
		this.replyService = service;
	}
		
	
	@RequestMapping(value = "insert.do")
	public ModelAndView insert(Reply r){
		ModelAndView mav = new ModelAndView();
		replyService.insertReply(r);
		ArrayList<Reply> list = replyService.selectAllByBoardNum(r.getrBoardnum());
		mav.addObject("list", list);
		mav.setViewName("reply/read");
		return mav;
	}

}
