package ml.sun.demo.service;

import ml.sun.demo.dao.UserEntity;

import java.util.List;

/**
 * @author Sun
 * @date 2022/1/27
 */
public interface IUserService {
    List<UserEntity> getUserByName(String username);
}
