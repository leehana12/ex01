package com.study.erum.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.cj.xdevapi.Result;
import com.study.erum.dto.MemberDTO;
import com.study.erum.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member") // 지금작업하는 것은 앞에 memver가 붙는다.
@RequiredArgsConstructor //생성자 주입
public class MemberController {

  private final MemberService memberService; // 기호상수 - 더이상 바꿀수 없는것 final
  
  @GetMapping("/save") // 보여주는것  포스트매핑은 저장하는것
  public String saveForm() { // 저장하는 입력폼
    return "save";
  }
  
  @PostMapping("/save")
  //@@ModelAttribute MemberDTO의 값을 memberDTO에 넘기기위해 필요한것
  public String save(@ModelAttribute MemberDTO memberDTO) {

    int saveResult = memberService.save(memberDTO); //The method save(MemberDTO) is undefined for the type MemberService
    if(saveResult > 0) {
      return "login";
    }else {
      return "save";
    }
  }
  
  @GetMapping("/login") // 보여주는것  포스트매핑은 저장하는것
  public String loginForm() { // 저장하는 입력폼
    return "login";
  }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session){
      boolean loginResult = memberService.login(memberDTO);
      System.out.println("실행확인");
      if(loginResult){
      //session에 값이 있으면 로그인상태 값이 없으면 로그인이 안된 상태 
        session.setAttribute("loginEmail", memberDTO.getMemberEmail());
        return "main";
      }else
        return "login";
    }   
    
    @GetMapping("/")
    public String findAll(Model model) {
      List<MemberDTO> memberDTOList = memberService.findAll();
      model.addAttribute("memberList",memberDTOList);
      return "list";
    }
    
 // /member?id=1
    @GetMapping
    public String findById(@RequestParam("id") Long id, Model model){
      MemberDTO memberDTO = memberService.findById(id);
      model.addAttribute("member", memberDTO);
      return "detail";
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id){
      memberService.delete(id);
      return "redirect:/member/";
    }
    
    //수정하려면 get과 post두가지가 필요하다 . 
    @GetMapping("/update")
    public String updateFrom(HttpSession session, Model model) {
      //세션에 저장된 나의 이메일 가져오기
      String loginEmail = (String) session.getAttribute("loginEmail");//강제형변환
      MemberDTO memberDTO = memberService.findByMemberEmail(loginEmail);
      model.addAttribute("member",memberDTO);
      return "update";
    }
    
    //수정 
    @PostMapping("/update") //PRG(Post-Redirect-Get) 패턴 -저장이 두번이상 되지 않도록 도망가는것 페이지이동이 되는것
    public String update(@ModelAttribute MemberDTO memberDTO) {
      boolean result = memberService.update(memberDTO);
      if(result) {
        return "redirect:/member?id=" + memberDTO.getId();
      }else {
        return "index";
      }
    }
    
    
    @PostMapping("/email-check")
    public @ResponseBody String emailCheck(@RequestParam("memberEmail") String memberEmail){
      System.out.println("memberEmail = " + memberEmail);
      String checkResult = memberService.emailCheck(memberEmail);
      return checkResult;
    }
    
    @GetMapping("/logout")
    public String logout(){
      return "logout";
    }

}






