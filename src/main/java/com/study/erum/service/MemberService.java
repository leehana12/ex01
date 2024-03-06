package com.study.erum.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mysql.cj.Session;
import com.study.erum.dto.MemberDTO;
import com.study.erum.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service //서비스 클래스는 서비스로
@RequiredArgsConstructor //생성자 주입  @오토와이어가 사라지고생성자 주입으로 변경됨
public class MemberService {

  //생성자 주입
  private final MemberRepository memberRepository;
  
  //멤버 컨트롤러 클래스에서 자동 생성함.
  public int save(MemberDTO memberDTO) {
    return memberRepository.save(memberDTO);
  }


  public boolean login(MemberDTO memberDTO) {
    MemberDTO loginMember = memberRepository.login(memberDTO);
    if(loginMember != null){
      return true;
    }else{
      return false;
    }
  }


  public List<MemberDTO> findAll() {
    return memberRepository.findAll();
  }


  public MemberDTO findById(Long id) {
    return memberRepository.findById(id);
  }


  public void delete(Long id) {
    memberRepository.delete(id);
    
  }


  public MemberDTO findByMemberEmail(String loginEmail) {
    return memberRepository.findByMemberEmail(loginEmail);
  }


  public boolean update(MemberDTO memberDTO) {
    int result = memberRepository.update(memberDTO);
    if(result>0) {
      return true; //참 - 성공
    }else {
      return false; //거짓 - 실패
    }
  }


  public String emailCheck(String memberEmail) {
    MemberDTO memberDTO = memberRepository.findByMemberEmail(memberEmail);
    if(memberDTO == null) {
      return "ok";
    }else {
      return "no";
    }
  }


}







