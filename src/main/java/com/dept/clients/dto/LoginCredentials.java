/*******************************************************************************
 * Copyright (c) 2018 macys.com. All rights reserved.
 *******************************************************************************/

package com.dept.clients.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "login_data",catalog="Clients")
public class LoginCredentials implements Serializable {

    private static final long serialVersionUID = 4L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long user_id;

    private String userName;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String toString() {
        return "LoginCredentials{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
