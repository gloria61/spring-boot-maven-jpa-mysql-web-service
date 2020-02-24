package com.webservice.datingapp.Service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservice.datingapp.Service.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

}