package br.com.arcelino.controller;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.arcelino.FindByNameRequest;
import br.com.arcelino.PersonRequest;
import br.com.arcelino.PersonResponse;
import br.com.arcelino.RequestById;
import br.com.arcelino.PersonServiceGrpc.PersonServiceImplBase;
import br.com.arcelino.dto.PersonValueFormDto;
import br.com.arcelino.service.PersonService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class PersonController extends PersonServiceImplBase {

    @Autowired
    private PersonService personService;

    @Override
    public void createPerson(PersonRequest request, StreamObserver<PersonResponse> responseObserver) {
        var valuesForm = new PersonValueFormDto(
                request.getName(),
                request.getEmail(),
                request.getAge());
        var person = personService.create(valuesForm);
        var response = PersonResponse.newBuilder()
                .setId(person.getId())
                .setName(person.getName())
                .setEmail(person.getEmail())
                .setAge(person.getAge())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void findById(RequestById request, StreamObserver<PersonResponse> responseObserver) {
        var person = personService.findById(request.getId());
        var response = PersonResponse.newBuilder()
                .setId(person.getId())
                .setName(person.getName())
                .setEmail(person.getEmail())
                .setAge(person.getAge())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void findByName(FindByNameRequest request, StreamObserver<PersonResponse> responseObserver) {
        var person = personService.findByName(request.getName());
        var response = PersonResponse.newBuilder()
                .setId(person.getId())
                .setName(person.getName())
                .setEmail(person.getEmail())
                .setAge(person.getAge())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(RequestById request, StreamObserver<PersonResponse> responseObserver) {
        personService.delete(request.getId());
        var response = PersonResponse.newBuilder()
                .setId(request.getId())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
