package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import reply.Reply;

@Controller
@RequestMapping( value = "/board/")
public class BoardController {
	private Service bService;
	private reply.Service rService;
	public BoardController(Service bService, reply.Service rService){
		this.bService = bService;
		this.rService = rService;
	}
	
	@RequestMapping(value = "writerForm.do")
	public String writerForm(){
		return "board/writerForm";
	}
	
	
	
	@RequestMapping(value = "insert.do")
	public String insert(Board b){
		bService.insertBoard(b);
		return "redirect:/board/list.do";
	}
	@RequestMapping(value = "list.do")
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView();
		Map map = new HashMap();
		ArrayList<Board> bList = bService.findAllBoard();
	//	ArrayList<Reply> rList = rservice.
		map.put("bList", bList);
		mav.addObject("mapList", map);
		mav.setViewName("board/list");
		System.out.println(map);
		return mav;
	}
	
	
	@RequestMapping(value = "editForm.do")
	public ModelAndView editForm(@RequestParam(value = "bNum") int bNum){
		Board b = bService.findBoard(bNum);
		ArrayList<Reply> list = rService.selectAllByBoardNum(bNum);
		ModelAndView mav = new ModelAndView();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("board", b);
		map.put("replyList", list);
		mav.addObject("data", map);
		mav.setViewName("board/editForm");
		System.out.println(map);
		return mav;
	}
	@RequestMapping(value = "update.do")
	public String update(Board b){
		bService.updateBoard(b);
		return "redirect:/list.do";
	}
	
	@RequestMapping(value = "del.do")
	public String del(@RequestParam(value="bNum") int bNum){
		bService.deleteBoard(bNum);
		return "redirect:/board/list.do";
	}
	
	

}
