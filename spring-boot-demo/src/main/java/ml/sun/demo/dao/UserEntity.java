package ml.sun.demo.dao;

import lombok.Data;

/**
 * @author Sun
 * @date 2022/1/27
 */
@Data
public class UserEntity {
    private Long id;
    private String username;
    private String password;
}
