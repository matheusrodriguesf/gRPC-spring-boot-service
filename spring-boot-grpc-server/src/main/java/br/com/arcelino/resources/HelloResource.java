package br.com.arcelino.resources;

import br.com.arcelino.HelloRequest;
import br.com.arcelino.HelloResponse;
import br.com.arcelino.HelloServiceGrpc.HelloServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloResource extends HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        var response = HelloResponse.newBuilder()
                .setMessage("Olá " + request.getName())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
