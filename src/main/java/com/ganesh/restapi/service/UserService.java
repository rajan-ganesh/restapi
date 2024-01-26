package com.ganesh.restapi.service;

import com.ganesh.restapi.model.UserModel;

public interface UserService {

    // As there is only one service in this application this interface is not necessary,
    // but will be beneficial as the number of services grows
    UserModel signUp(UserModel userModel);
    String login(String username, String password);
}
