package com.chicken.project.member.model.service;

import com.chicken.project.member.email.MailHandler;
import com.chicken.project.member.email.TempKey;
import com.chicken.project.member.model.dao.EmployeeMapper;
import com.chicken.project.member.model.dao.StoreMemberMapper;
import com.chicken.project.member.model.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final EmployeeMapper employeeMapper;

    private final StoreMemberMapper storeMapper;

    private final JavaMailSender mailSender;

    @Autowired
    public MemberServiceImpl(EmployeeMapper employeeMapper, StoreMemberMapper storeMapper, JavaMailSender mailSender) {

        this.employeeMapper = employeeMapper;
        this.storeMapper = storeMapper;
        this.mailSender = mailSender;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("[EmployeeService]================================= ");
        log.info("[EmployeeService] empId = " + username);

        EmployeeDTO empMember = employeeMapper.selectEmpInfo(username);
        StoreMemberDTO storeMember = storeMapper.selectStoreInfo(username);

        log.info("[EmployeeService] member = " + empMember);
        log.info("[EmployeeService] storeMember = " + storeMember);

        AdminImpl member = null;
        StoreImpl store = null;
        if(empMember != null){

            List<GrantedAuthority> authorities = new ArrayList<>();

            if(empMember.getEmpRoleList() != null) {
                log.info("[empMember] check = " + empMember);
                List<EmpRoleDTO> roleList = empMember.getEmpRoleList();

                for(int i = 0; i < roleList.size(); i++){

                    AuthDTO authority = roleList.get(i).getAuthority();
                    authorities.add(new SimpleGrantedAuthority(authority.getAuthName()));
                }
            }

            member = new AdminImpl(empMember.getEmpId(), empMember.getEmpPwd(), authorities);
            member.setDetails(empMember);

        } else if(storeMember != null){
            log.info("[storeMember] check = " + storeMember);
            List<GrantedAuthority> authorities = new ArrayList<>();

            if(storeMember.getStoreRoleList() != null){

                List<StoreRoleDTO> roleList = storeMember.getStoreRoleList();

                for(int i = 0; i < roleList.size(); i++){

                    AuthDTO authority = roleList.get(i).getAuthority();
                    authorities.add(new SimpleGrantedAuthority(authority.getAuthName()));
                }
            }

            store = new StoreImpl(storeMember.getStoreId(), storeMember.getStorePwd(), authorities);
            store.setDetails(storeMember);
            log.info("[storeMember] check = " + store);
        }



        return member != null? member: store;

    }

    @Override
    public int updateEmailCode(EmployeeDTO emp) throws MessagingException, UnsupportedEncodingException {

        String emailCode = new TempKey().getKey(30,false);
        emp.setEmailCode(emailCode);

        log.info("[MemberService] emp = " + emp);

        int result = employeeMapper.updateEmailCode(emp);

        if(result > 0){
            MailHandler sendMail = new MailHandler(mailSender);
            sendMail.setSubject("[치킨스톡 인증 이메일입니다.]");
            sendMail.setText(
                    "<h1>치킨스톡 이메일 인증</h1>" +
                            "<br>치킨스톡 비밀번호를 재설정하기 위한 인증 이메일입니다." +
                            "<br>아래 인증번호를 입력해주세요." +
                            "<br>[" + emailCode + "]"
//                            "<br>아래 [이메일 인증 확인]을 눌러주세요" +
//                            "<br><a href='http://localhost:8085/member/ckEmail?email="+ emp.getEmpEmail() + "&emailCode=" + emailCode +"' target='_blank'>이메일 인증 확인</a>"
            );
            sendMail.setFrom("ybusiness39@naver.com","치킨스톡");
            sendMail.setTo(emp.getEmpId());
            sendMail.send();
        }

        return result;
    }
}
