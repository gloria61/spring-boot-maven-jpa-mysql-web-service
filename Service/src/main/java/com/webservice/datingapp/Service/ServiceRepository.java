package com.webservice.datingapp.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservice.datingapp.Service.UserModel;

@Repository
public interface ServiceRepository extends JpaRepository<UserModel, Long> {

}