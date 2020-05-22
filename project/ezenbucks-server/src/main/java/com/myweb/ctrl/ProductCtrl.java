package com.myweb.ctrl;

import java.io.IOException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.domain.Criteria;
import com.myweb.domain.PagingVO;
import com.myweb.service.ProductService;
import com.myweb.util.FileProcess;

@Controller
@RequestMapping("/product/*")
public class ProductCtrl {
	private static final Logger log = LoggerFactory.getLogger(ProductCtrl.class);
	@Inject
	private ProductService psv;
	@Inject
	private FileProcess fp;
	
	@PostMapping("/rmimg")	
	public String removeImg(@RequestParam("pno") int pno,
			@RequestParam("imgfile")String imgfile) {
		log.info(">>> 이미지 삭제");
		fp.fileRemove(imgfile);
		psv.removeImg(pno);
		return "redirect:/";	
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("pno") int pno, @RequestParam("imgfile")String imgfile,
			RedirectAttributes reAttr, Criteria cri) {
		log.info(">>> 상품 삭제 - POST");
		if(!imgfile.equals("NONE")) {
			fp.fileRemove(imgfile);			
		}
		psv.remove(pno);
		reAttr.addAttribute("pageNum", cri.getPageNum());
		reAttr.addAttribute("amount", cri.getAmount());
		reAttr.addAttribute("type", cri.getType());
		reAttr.addAttribute("keyword", cri.getKeyword());
		reAttr.addFlashAttribute("result", "remove_ok");
		return "redirect:/product/list";
	}
	
	@PostMapping("/modify")
	public String modify(MultipartHttpServletRequest req, RedirectAttributes reAttr,
			@ModelAttribute("cri")Criteria cri) throws IllegalStateException, IOException {
		log.info(">>> 상품 수정 요청 - POST");
		log.info(">>>>>>>>>>>>>>>>>>>>>>>"+req.getParameter("imgfile"));
		psv.modify(fp.fileModify(req));
		reAttr.addAttribute("pageNum", cri.getPageNum());
		reAttr.addAttribute("amount", cri.getAmount());
		reAttr.addAttribute("type", cri.getType());
		reAttr.addAttribute("keyword", cri.getKeyword());
		reAttr.addFlashAttribute("result", "modify_ok");
		return "redirect:/product/detail?pno="+req.getParameter("pno");
	}
	
	/*@GetMapping("/modify")
	public void modify(@RequestParam("pno")int pno, Model model) {
		log.info(">>> 상품 수정 페이지 출력 - GET");
		model.addAttribute("pvo", psv.detail(pno));
	}*/
	
	@GetMapping({"/detail", "/modify"})
	public void detail(@RequestParam("pno") int pno, Model model,@ModelAttribute("cri")Criteria cri) {
		log.info(">>> 상품 상세 페이지 출력 - GET" );
		model.addAttribute("pvo", psv.detail(pno));
	}
	
	//@RequestMapping(value="/write", method=RequestMethod.GET)
	@GetMapping("/write")
	public void write() {
		log.info(">>> 상품 등록 페이지 출력 - GET");
	}
	//@RequestMapping(value="/write", method=RequestMethod.POST)
	@PostMapping("/write")
	public String write(MultipartHttpServletRequest req, RedirectAttributes reAttr) throws IllegalStateException, IOException {
		log.info(">>> 상품 등록 페이지 출력 - GET");
		//ProductVO pvo = new ProductVO();
		//pvo = fp.fileSave(req);
		psv.write(fp.fileSave(req));
		reAttr.addFlashAttribute("result", "write_ok");
		return "redirect:/product/list";
	}
	
	//@RequestMapping(value = "/list", method=RequestMethod.GET)
	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		log.info(">>> 리스트 출력 - GET");
		/*List<ProductVO> list = new ArrayList<>();
		list = psv.list();*/		
		model.addAttribute("list", psv.list(cri));
		int totalCnt = psv.totalCount(cri);
		model.addAttribute("pgvo", new PagingVO(totalCnt,cri));
	}	
}