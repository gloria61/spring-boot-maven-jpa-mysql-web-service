package com.webservice.datingapp.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservice.datingapp.Service.MatchesModel;

@Repository
public interface MatchesRepository extends JpaRepository<MatchesModel, Long> {

}