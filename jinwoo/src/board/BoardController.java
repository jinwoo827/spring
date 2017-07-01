package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( value = "/board/")
public class BoardController {
	private Service service;
	public BoardController(Service service){
		this.service = service;
	}
	
	@RequestMapping(value = "writerForm.do")
	public String writerForm(){
		return "writerForm";
	}
	
	
	
	@RequestMapping(value = "insert.do")
	public String insert(Board b){
		service.insertBoard(b);
		return "redirect:/board/list.do";
	}
	@RequestMapping(value = "list.do")
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView();
		Map map = new HashMap();
		ArrayList<Board> bList = service.findAllBoard();
	//	ArrayList<Reply> rList = rservice.
		map.put("bList", bList);
		mav.addObject("mapList", map);
		mav.setViewName("list");
		System.out.println(map);
		return mav;
	}
	
	
	@RequestMapping(value = "editForm.do")
	public ModelAndView editForm(@RequestParam(value = "bNum") int bNum){
		Board b = service.findBoard(bNum);
		ModelAndView mav = new ModelAndView();
		mav.addObject("b", b);
		mav.setViewName("editForm");
		return mav;
	}
	@RequestMapping(value = "update.do")
	public String update(Board b){
		service.updateBoard(b);
		return "redirect:/list.do";
	}
	
	@RequestMapping(value = "del.do")
	public String del(@RequestParam(value="bNum") int bNum){
		service.deleteBoard(bNum);
		return "redirect:/board/list.do";
	}
	
	

}
