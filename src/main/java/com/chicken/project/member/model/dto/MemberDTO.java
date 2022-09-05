package com.chicken.project.member.model.dto;

import com.chicken.project.empList.model.dto.EmployeeDTO;
import com.chicken.project.store.model.dto.StoreDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class MemberDTO implements UserDetails {

    private String memberId;
    private String memberPwd;
    private String memberType;

    private EmployeeDTO employeeDTO;
    private StoreDTO storeDTO;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return getMemberPwd();
    }

    @Override
    public String getUsername() {
        return getMemberId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
