package com.workintech.twitter.demo.service;

import com.workintech.twitter.demo.entity.Role;
import com.workintech.twitter.demo.entity.User;
import com.workintech.twitter.demo.repository.ProfileRepository;
import com.workintech.twitter.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ProfileServiceImpl implements ProfileService {
    private ProfileRepository profileRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository,  RoleRepository roleRepository, PasswordEncoder passwordEncoder){
        this.profileRepository = profileRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findByUserName(String userName) {

        return profileRepository.findByUserName(userName);

    }


    @Override
    public User register(User user) {

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        Role memberRole = roleRepository.findByAuthority("USER").get();
        Set<Role> roles = new HashSet<>();
        roles.add(memberRole);

        user.setPassword(encodedPassword);
        user.setAuthorities(roles);
        return profileRepository.save(user);
    }

    @Override
    public User logout(int id) {

        return null;
    }

    @Override
    public User login(String userName, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        Optional<User> user = profileRepository.findByUserName(userName);
        if(user.isPresent()){
            // şifreler eşleşiyor mu
            if(user.get().getPassword() == encodedPassword){
                return user.get();
            }else{
                // eşleşmezse nul kontrollerde hata fırlattım
                return null;
            }
        }
        else{
            return null;
        }
    }
}
