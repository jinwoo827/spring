package reply;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/reply/")
public class ReplyController {
	private Service replyService;
	
	public void setReplyService(Service service){
		this.replyService = service;
	}
		
	
	@RequestMapping(value = "insert.do")	
	public String insert(Reply r){			
			replyService.insertReply(r);
		/*}
		ModelAndView mav = new ModelAndView();
		ArrayList<Reply> list = replyService.selectAllByBoardNum(r.getrBoardnum());
		//System.out.println(list);
		mav.addObject("list", list);
		mav.setViewName("reply/read");*/
		return "redirect:/reply/list.do?rBoardnum="+r.getrBoardnum();
	}
	
	@RequestMapping(value = "list.do")
	public ModelAndView list(@RequestParam(value="rBoardnum") int rBoardnum){		
		ModelAndView mav = new ModelAndView();
		ArrayList<Reply> list = replyService.selectAllByBoardNum(rBoardnum);
		//System.out.println(list);
		mav.addObject("list", list);
		mav.setViewName("reply/read");
		return mav;
	}
	
	
	
	@RequestMapping(value = "del.do")
	public String del(@RequestParam(value = "rNum") int rNum){
		Reply r = replyService.select(rNum);
		replyService.deleteReply(rNum);
		return "redirect:/reply/list.do?rBoardnum="+r.getrBoardnum();
	}

}
