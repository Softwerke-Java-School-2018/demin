package com.miros.testproject.service;

import com.miros.testproject.data.DAO.UserDAO;
import com.miros.testproject.data.entity.User;

import java.util.Optional;
import java.util.List;
import java.util.stream.Stream;

/**
 * Service layer for Users
 */
public class UserService {
    //Gets list with all app Users
    private List<User> userDAO = UserDAO.getInstance().getInstanceList();

    public Optional<User> save(User user) throws IndexOutOfBoundsException {
        Optional<User> optionalUser = Optional.ofNullable(user);
        boolean result = optionalUser.isPresent();
        if (result) {
            userDAO.add(optionalUser.get());
        }
        return optionalUser;
    }

    public User find(int id) throws IndexOutOfBoundsException {
        return userDAO.get(id);
    }

    public User delete(int id) throws IndexOutOfBoundsException {
        return userDAO.remove(id);
    }

    public Optional<User> delete(User user) throws NullPointerException {
        Optional<User> optionalUser = Optional.ofNullable(user);
        boolean result = optionalUser.isPresent();
        if (result) {
            userDAO.remove(user);
        }
        return optionalUser;
    }

    public void clear() throws UnsupportedOperationException{
        userDAO.clear();
    }

    public Stream<User> findAll() {
        return userDAO.stream();
    }

    /**
     * return true if entity exist
     *
     * @param id entity dd
     * @return
     */
    public boolean exist(int id) {
        Optional<User> user = userDAO.stream()
                .filter(s -> s.getId() == id)
                .findAny();
        return user.isPresent();
    }
}
