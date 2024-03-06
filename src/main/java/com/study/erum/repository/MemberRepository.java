package com.study.erum.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.study.erum.dto.MemberDTO;

import lombok.RequiredArgsConstructor;

@Repository // Resository 는 DAO역할 
@RequiredArgsConstructor
public class MemberRepository {
  
  private final SqlSessionTemplate sql;
  
  //MemberService.java 클래스에서 save를 통해 자동생성함.
  public int save(MemberDTO memberDTO) {
    System.out.println("memberDTO=" + memberDTO);
    return sql.insert("Member.save", memberDTO);
  }

  public MemberDTO login(MemberDTO memberDTO) {
    return sql.selectOne("Member.login", memberDTO);
  }

  public List<MemberDTO> findAll() {
    return sql.selectList("Member.findAll");
  }

  public MemberDTO findById(Long id) {
    return sql.selectOne("Member.findById", id);
  }

  public void delete(Long id) {
    //sql문에 가서 찾는다.
    sql.delete("Member.delete", id);
    
  }

  public MemberDTO findByMemberEmail(String loginEmail) {
    return sql.selectOne("Member.findByMemberEmail",loginEmail);
  }

  public int update(MemberDTO memberDTO) {
    return sql.update("Member.update", memberDTO);
  }



}
