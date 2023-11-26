package org.internetStore.service;

import org.internetStore.dal.DataAccessLayer;
import org.internetStore.dto.SignupRequest;
import org.internetStore.models.entities.User;
import org.internetStore.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private DataAccessLayer dataAccessLayer;

    public String newUser(SignupRequest signupRequest) {
//        if (dataAccessLayer.existsByUsername(signupRequest.getUserName())) {
//            return "Выберите другое имя";
//        }
//        if (dataAccessLayer.existsByEmail(signupRequest.getEmail())) {
//            return "Выберите другую почту";
//        }

        User user = new User();
        user.setUsername(signupRequest.getUserName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(signupRequest.getPassword());

        return dataAccessLayer.newUserToDatabase(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = dataAccessLayer.getUserFromDatabaseByUsername(username);
        return UserDetailsImpl.build(user);
    }
}
