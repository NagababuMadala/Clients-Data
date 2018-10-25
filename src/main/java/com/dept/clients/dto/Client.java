package com.dept.clients.dto;

import javax.persistence.*;
import java.io.Serializable;

/********************************************************************************
     *
     * Name: Client.java
     *
     * Created By: Nagababu
     *
     * Project Name: ClientsData
     *
     * Date Created: 30/08/2018
     *
     * Description:
     * This class represents client info.  The client info contains the clients contact details,
     *
     ********************************************************************************/
    @Entity
    @Table(name = "clients_data",catalog="Clients")
    public class Client implements Serializable {

    private static final long serialVersionUID = 2L;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String dateOfBirth;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "id",referencedColumnName = "addressId")
        private Profile profileAddress;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "id",referencedColumnName = "user_id")
        private LoginCredentials loginCredentials;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public Profile getProfileAddress() {
            return profileAddress;
        }

        public void setProfileAddress(Profile profileAddress) {
            this.profileAddress = profileAddress;
        }

        public LoginCredentials getLoginCredentials() {
            return loginCredentials;
        }

        public void setLoginCredentials(LoginCredentials loginCredentials) {
            this.loginCredentials = loginCredentials;
        }

        @Override
        public String toString() {
            return "Client{" +
                    "id=" + id +
                    ", dateOfBirth='" + dateOfBirth + '\'' +
                    ", profileAddress=" + profileAddress +
                   // ", loginCredentials=" + loginCredentials +
                    '}';
        }
    }