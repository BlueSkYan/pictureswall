package xyz.blueskyan.pictureswall.service;

import xyz.blueskyan.pictureswall.entity.User;

public interface AdminService {

    User login(String username, String password);

    boolean register(String username,String password);
}
