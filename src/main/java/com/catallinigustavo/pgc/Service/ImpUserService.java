package com.catallinigustavo.pgc.Service;

import com.catallinigustavo.pgc.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.catallinigustavo.pgc.Interface.IUserService;
import com.catallinigustavo.pgc.Repository.IUserRepository;
import java.util.List;

@Service
public class ImpUserService implements IUserService{
    @Autowired IUserRepository iuserRepository;
    
    @Override
    public List<User> getUser() {
        List<User> user = iuserRepository.findAll();
        return user;
    }

    @Override
    public void saveUser(User user) {
        iuserRepository.save(user);
    }

    @Override
    public void deletUser(Long id) {
        iuserRepository.deleteById(id);
    }

    @Override
    public User findUser(Long id) {
        User user = iuserRepository.findById(id).orElse(null);
        return user;
    }


  
}
