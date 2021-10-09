package com.pedromcarrion.hexagonalsample.infrastructure.controller.ad;

import com.pedromcarrion.hexagonalsample.application.ad.AdDto;
import com.pedromcarrion.hexagonalsample.application.ad.GetAdQuery;
import com.pedromcarrion.hexagonalsample.application.ad.GetAdUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAdController {

    private final GetAdUseCase getAdUseCase;
    private final AdResponseMapper adResponseMapper;

    public GetAdController(GetAdUseCase getAdUseCase, AdResponseMapper adResponseMapper) {
        this.getAdUseCase = getAdUseCase;
        this.adResponseMapper = adResponseMapper;
    }

    @GetMapping("/v1/ads/{id}")
    public ResponseEntity<AdResponse> GetAd(@PathVariable String id) {
        try {
            GetAdQuery getAdQuery = new GetAdQuery(id);
            AdDto adDto = getAdUseCase.execute(getAdQuery);
            return ResponseEntity.ok(adResponseMapper.map(adDto));
        } catch (Exception anyException) {
            //TODO Log with id
            return ResponseEntity.internalServerError().build();
        }
    }
}
