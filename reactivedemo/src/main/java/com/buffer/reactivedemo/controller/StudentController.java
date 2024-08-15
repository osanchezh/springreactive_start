package com.buffer.reactivedemo.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.buffer.reactivedemo.model.Student;
import com.buffer.reactivedemo.model.StudentRequest;
import com.buffer.reactivedemo.service.StudentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

  @Autowired
  private StudentService service;

  @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Student> findAll() {
    return service.findAll().delayElements(Duration.ofSeconds(2));
  }

  @GetMapping("/{id}")
  public Mono<Student> findById(@PathVariable Long id) {
    return service.findById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Student> create(@RequestBody StudentRequest request) {
    return service.save(request);
  }

  @GetMapping("/filter")
  public Flux<Student> findByAuthor(@RequestParam String name) {
    return service.findByFirstname(name);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    service.deleteById(id);
  }
}