package org.internetStore.service;

import org.internetStore.dal.DataAccessLayer;
import org.internetStore.models.entities.User;
import org.internetStore.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
//    private DataAccessLayer dataAccessLayer;
//    @Autowired
//    public void setDataAccessLayer(DataAccessLayer dataAccessLayer) {
//        this.dataAccessLayer = dataAccessLayer;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = DataAccessLayer.getUserFromDatabaseByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("Пользователь '%s не найден", username)));
        return UserDetailsImpl.build(user);
    }
}
