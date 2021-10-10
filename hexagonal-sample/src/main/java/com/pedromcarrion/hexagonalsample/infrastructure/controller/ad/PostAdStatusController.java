package com.pedromcarrion.hexagonalsample.infrastructure.controller.ad;

import com.pedromcarrion.hexagonalsample.application.ad.ChangeAdStatusCommand;
import com.pedromcarrion.hexagonalsample.application.ad.ChangeAdStatusUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostAdStatusController {

    private final ChangeAdStatusUseCase changeAdStatusUseCase;

    public PostAdStatusController(ChangeAdStatusUseCase changeAdStatusUseCase) {
        this.changeAdStatusUseCase = changeAdStatusUseCase;
    }

    @PostMapping("/v1/ads/{id}")
    public ResponseEntity PostAdStatus(@PathVariable String id, @RequestBody PostAdStatusRequest postAdStatusRequest) {

        try{
            ChangeAdStatusCommand changeAdStatusCommand = new ChangeAdStatusCommand(id, postAdStatusRequest.getStatus());
            changeAdStatusUseCase.execute(changeAdStatusCommand);
            return ResponseEntity.ok().build();
        } catch (Throwable anyException){
            //TODO Log with id and request
            return ResponseEntity.internalServerError().build();
        }
    }
}
