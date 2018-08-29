/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mongotest.repository;

import com.example.mongotest.model.Jugador;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Dell
 */
public interface JugadorRepository extends MongoRepository<Jugador, String>{
    
}
