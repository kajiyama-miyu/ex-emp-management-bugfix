package jp.co.sample.emp_management.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import jp.co.sample.emp_management.domain.Administrator;
import jp.co.sample.emp_management.repository.AdministratorRepository;
 
/**
 * ログイン認証の処理を行うクラス。
 * 
 * @author kajiyamamiyu
 *
 */
@Component
public class JpaUserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private AdministratorRepository administratorRepository;
    
    @Autowired
    private HttpSession session;
 
    @Override
    public UserDetails loadUserByUsername(String mailAddress)
            throws UsernameNotFoundException {
 
        Administrator administrator = administratorRepository.findByMailAddress(mailAddress);
        
        System.out.println(administrator);
        
        session.setAttribute("administratorName", administrator.getName());
        return administrator;
    }
}


