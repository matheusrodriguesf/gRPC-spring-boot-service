package br.com.arcelino.controller;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.arcelino.PersonRequest;
import br.com.arcelino.PersonResponse;
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
}
