package com.buffer.reactivedemo.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buffer.reactivedemo.model.Student;
import com.buffer.reactivedemo.model.StudentRepository;
import com.buffer.reactivedemo.model.StudentRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  public Flux<Student> findAll() {
    return studentRepository.findAll()
        .delayElements(Duration.ofSeconds(1));
  }

  public Mono<Student> findById(Long id) {
    return studentRepository.findById(id);
  }

  public Mono<Student> save(StudentRequest request) {
	  Student s= new Student();
      s.setFirstname(request.getFirstname());
      s.setLastname(request.getLastname());
      s.setAge(request.getAge());
    return studentRepository.save(s);
  }

  public Flux<Student> findByFirstname(String firstname) {
    return studentRepository.findAllByFirstnameContainingIgnoreCase(firstname);
  }

  public void deleteById(Long id) {
    studentRepository.deleteById(id).subscribe();
  }
}