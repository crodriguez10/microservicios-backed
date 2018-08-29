/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mongotest.controller;

import com.example.mongotest.model.Jugador;
import com.example.mongotest.repository.JugadorRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dell
 */
@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    JugadorRepository jugadorRepository;

    public static final Log LOGGER = LogFactory.getLog(JugadorController.class);

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        try {
            LOGGER.info("******************findAll*************");
            return ResponseEntity.ok(jugadorRepository.findAll());
        } catch (Exception e) {
            LOGGER.info("error findAll");
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<?> createOrReplace(@RequestBody Jugador jugador) {
        try {
            return ResponseEntity.ok(jugadorRepository.save(jugador));
        } catch (Exception e) {
            LOGGER.info("error createOrReplace");
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
        try {
            LOGGER.info("id finding "+id);
            return ResponseEntity.ok(jugadorRepository.findById(id));
        } catch (Exception e) {
            LOGGER.info("error findByid");
            return ResponseEntity.badRequest().build();

        }
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
        try {
            jugadorRepository.delete(jugadorRepository.findById(id).orElse(null));
            return ResponseEntity.ok(id);
        } catch (Exception e) {
            LOGGER.info("error deleteById");
            return ResponseEntity.badRequest().build();

        }
    }
}
