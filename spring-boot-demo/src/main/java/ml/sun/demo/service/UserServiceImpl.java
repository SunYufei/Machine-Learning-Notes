package ml.sun.demo.service;

import ml.sun.demo.dao.UserDAO;
import ml.sun.demo.dao.UserEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Sun
 * @date 2022/1/27
 */
@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserDAO userDAO;

    @Override
    public List<UserEntity> getUserByName(String username) {
        return userDAO.findByUsername(username);
    }
}
