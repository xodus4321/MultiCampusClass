package com.multi.erp.common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.multi.erp.board.BoardFileDTO;
@Service
public class FileUploasLogicService {
	//파일 업로드를 수행하는 메소드 정의 - 업로드듼 파일의 정보를 BoardFileDTO로 변환해서 리턴
	//여러 개인 경우 BoardFileDTO를 List에 담아서 리턴
	//파일명이 중복되지 않도록 관리 => 원본파일 + 중복되지 않는 키값으로 파일명(서버에저장)을 생성하기
	public List<BoardFileDTO> uploadFiles(List<MultipartFile> multipartFiles,String path) throws IllegalStateException, IOException {	
		int count = 1;
		List<BoardFileDTO> filedotlist =new ArrayList<BoardFileDTO>();
		for(MultipartFile multipartFile : multipartFiles) {
			//업로드를 하는 경우 원본파일명과 서버에서 식별할 수 있는 실제 서버에 저장되는 파일명 두 개를 관리
			//클라이언트가 업로드한 원본파일명
			if(!multipartFile.isEmpty()) {
				
				String originalFilename = multipartFile.getOriginalFilename();
			//서버에서 식별할 수 있도록 파일명 변경
				String storeFilename=createStoreFilename(originalFilename);
				//xxx/WEB-INF/upload + / + 파일명
				multipartFile.transferTo(new File(path+File.separator+storeFilename));
				System.out.println("저장파일명============================"+storeFilename);
				System.out.println("원본파일명============================"+originalFilename);
				filedotlist.add(new BoardFileDTO(null, originalFilename, storeFilename, count+""));
				count++;
			}
		}
		return filedotlist;
	}
	//UUIT를 이용해서 파일명을 변경해서 리턴하는 메소드

	  private String createStoreFilename(String originalFilename) {
		  int pos = originalFilename.lastIndexOf(".");
		  String ext = originalFilename.substring(pos+1);//시작 index부터 끝까지 문자열을 추출
		  String uuid = UUID.randomUUID().toString();
		  return uuid+"."+ext;
	  }

}
