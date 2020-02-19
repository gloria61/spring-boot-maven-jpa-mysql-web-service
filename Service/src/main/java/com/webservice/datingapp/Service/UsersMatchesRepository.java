package com.webservice.datingapp.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservice.datingapp.Service.UsersMatchesModel;

@Repository
public interface UsersMatchesRepository extends JpaRepository<UsersMatchesModel, Long> {

}