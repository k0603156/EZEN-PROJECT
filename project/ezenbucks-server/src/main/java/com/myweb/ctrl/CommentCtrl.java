package com.myweb.ctrl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myweb.domain.CommentDTO;
import com.myweb.domain.CommentVO;
import com.myweb.domain.Criteria;
import com.myweb.service.CommentService;

@RestController
@RequestMapping("/comment/*")
public class CommentCtrl {
	private static final Logger log = LoggerFactory.getLogger(CommentCtrl.class);
	@Inject
	private CommentService csv;
	
	@DeleteMapping(value="/{cno}",produces="application/text; charset=utf-8")
	public ResponseEntity<String> remove(@PathVariable("cno")int cno){
		log.info(">>> 댓글 삭제 - DELETE : " + cno);
		return csv.remove(cno) > 0 ?
				new ResponseEntity<>(cno+"번 댓글을 삭제하였습니다.",HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(method={RequestMethod.PUT,RequestMethod.PATCH},
			value="/{cno}", consumes="application/json",
			produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@PathVariable("cno")int cno,
			@RequestBody CommentVO cvo){
		log.info(">>> 댓글 수정 - PUT/PATCH : " + cno);
		cvo.setCno(cno);
		return csv.modify(cvo) == 1 ?
				new ResponseEntity<String>("댓글이 수정되었습니다.", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value="/p/{pno}/{page}",
			produces={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<CommentDTO> list(@PathVariable("pno")int pno,
			@PathVariable("page")int page){
		log.info(">>> 댓글 리스트 페이징 - GET >>> "+pno+"번글의 "+page+"페이지 댓글 리스트");
		Criteria cri = new Criteria(page, 10);		
		return new ResponseEntity<CommentDTO>(csv.list(cri, pno),HttpStatus.OK);
	}
	
	@PostMapping(value="/new", consumes="application/json",
			produces="application/text; charset=utf-8")
	public ResponseEntity<String> write(@RequestBody CommentVO cvo){
		log.info(">>> 댓글 기록 - POST");
		boolean isOk = csv.write(cvo);	
		return isOk == true ? new ResponseEntity<>("댓글이 등록 되었습니다.",HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
