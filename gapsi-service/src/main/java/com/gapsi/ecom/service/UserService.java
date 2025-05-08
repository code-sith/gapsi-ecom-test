package com.gapsi.ecom.service;

import com.gapsi.ecom.dto.User;
import com.gapsi.ecom.entity.UserEntity;
import com.gapsi.ecom.exception.ApplicationException;

public interface UserService {

    /**
     * Converts a <see>UserEntity</see> object into a <see>User</see>
     * @param userEntity to transform
     * @return a User object
     * */
    User map(final UserEntity userEntity);
    /**
     * retrieves a user by a given id
     * @param id to search
     * @throws com.gapsi.ecom.exception.RecordNotFoundException if the user is not found
     * */
    User getUserById(final Long id) throws ApplicationException;
}
