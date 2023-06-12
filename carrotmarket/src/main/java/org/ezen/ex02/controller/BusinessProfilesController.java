package org.ezen.ex02.controller;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ezen.ex02.domain.MemberVO;
import org.ezen.ex02.domain.StoresImagesVO;
import org.ezen.ex02.domain.StoresVO;
import org.ezen.ex02.service.MemberService;
import org.ezen.ex02.service.StoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/biz")
@AllArgsConstructor
public class BusinessProfilesController {
	
	@Setter(onMethod_ = @Autowired)
	private StoresService storesService;
	
	
	//비즈프로필 보여주기
	@GetMapping("/business-profiles")
	public String showBizProfiles(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam("bno")  long bno) throws MalformedURLException {
		
		StoresVO storesVO = storesService.get(bno);
		
		//StoresImagesVO storesImagesVO = storesService.getAttachList(bno);
		
		
		//System.out.println("storesImagesVO 확인!!!! :"+storesImagesVO);
		
		
		
		model.addAttribute(storesVO);
		
		model.addAttribute("bno", bno);
		
		request.setAttribute("bno", bno);
		
		List<StoresImagesVO> storesImagesVO = storesService.getAttachList(bno);
		
		
		List<UrlResource> aa = new ArrayList<>();
		
		
		
		for (int i =0; i < storesImagesVO.size(); i++ ) {
			
			
			String uploadPath = storesImagesVO.get(i).getUploadPath();
			String uuid = storesImagesVO.get(i).getUuid();
			String fileName = storesImagesVO.get(i).getFileName();
			
			
			String imgPath = uploadPath + "/" + uuid + "_"  + fileName; 
			
			UrlResource imgs = new UrlResource ("file:///C:/upload/" + imgPath);
			
			System.out.println(imgs);
			
			
			aa.add(imgs);
			
		}
		//System.out.println("모델 model.addAttribute(aa) 확인 : "+model.addAttribute(aa));
		
        //System.out.println(model);
        
		return "stores/business-profiles";
	}
	
	/*
	@GetMapping("images/{bno}")
	public ResponseEntity<byte []> storesImg (@PathVariable("bno") long bno){
	
		
		List<StoresImagesVO> storesImages = storesService.getAttachList(bno);
		
		String uploadPath;
		String fileName;
		String uuid;
		
		uploadPath  = memberVO.getUploadPath();
		fileName  = memberVO.getFileName();
		uuid  = memberVO.getUuid();
		
		String imgPath = uploadPath + "/" + "s_" + uuid + "_"  + fileName; 
		
		File file = new File ("C:/uploads/" + imgPath);
		
		ResponseEntity<byte []> result = null;
		
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<> (FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	*/
	
	
	
	
	//게시물 수정하기
	@GetMapping("/storesModify")
	public String articleModify(Model model, StoresVO storesVO,HttpServletRequest request,@RequestParam("bno") long bno) {
		
		
		
		
		
		
		
		return "stores/storesModify";
	}
	
}
