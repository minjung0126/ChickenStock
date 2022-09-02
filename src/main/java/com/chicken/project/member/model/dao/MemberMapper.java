package com.chicken.project.member.model.dao;

import com.chicken.project.member.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    MemberDTO selectMember(String username);
}
