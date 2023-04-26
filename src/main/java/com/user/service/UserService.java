package com.user.service;

import com.user.Exception.NoDataException;
import com.user.Exception.NoitemException;
import com.user.Exception.NotFoundException;
import com.user.model.User;

import java.util.List;

public interface UserService {


    User createUser(User user);

    List<User> createListUsers(List<User> user);

    User updateItem(User user) throws NoitemException, NoDataException;

    List<User> findAllUsers();

    User findByitem(int it) throws NotFoundException;

    void deleteAll();

    public void delete(int it) ;

    Object countUniqueUserId();
}
