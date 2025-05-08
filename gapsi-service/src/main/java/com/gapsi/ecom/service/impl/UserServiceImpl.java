package com.gapsi.ecom.service.impl;

import com.gapsi.ecom.dto.User;
import com.gapsi.ecom.entity.UserEntity;
import com.gapsi.ecom.exception.ApplicationException;
import com.gapsi.ecom.exception.RecordNotFoundException;
import com.gapsi.ecom.repository.UserRepository;
import com.gapsi.ecom.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User map(UserEntity userEntity) {
        return User.builder()
                .userId(userEntity.getId())
                .fullName(userEntity.getFullName())
                .build();
    }

    @Override
    public User getUserById(Long id) throws ApplicationException {
        return map(userRepository.findById(id).orElseThrow(()-> new RecordNotFoundException()));
    }
}
