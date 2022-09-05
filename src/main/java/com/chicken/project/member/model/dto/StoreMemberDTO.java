package com.chicken.project.member.model.dto;

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
public class StoreMemberDTO implements UserDetails {

    private String storeName;
    private String storeAccount;
    private String storeRep;
    private String storeAddress;
    private String storePhone;
    private String storeEmail;
    private String storeId;
    private String storePwd;
    private String storeNo;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return getStorePwd();
    }

    @Override
    public String getUsername() {
        return getStoreId();
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
