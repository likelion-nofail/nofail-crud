package com.springboot.nofail_project.controller;


import com.springboot.nofail_project.data.dto.request.ChangeNameRequestDto;
import com.springboot.nofail_project.data.dto.request.RequestBordenDto;
import com.springboot.nofail_project.data.dto.response.ResponseBordenDto;
import com.springboot.nofail_project.service.BordenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/baby-lion")
public class BordenController {

    private final BordenService bordenService;

    @Autowired
    public BordenController(BordenService bordenService){
        this.bordenService = bordenService;
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseBordenDto> getBorden(@RequestParam String name) throws Exception{
        ResponseBordenDto responseBordenDto = bordenService.getBorden(name);
        return ResponseEntity.status(HttpStatus.OK).body(responseBordenDto);
    }

    @PostMapping("/post")
    public ResponseEntity<ResponseBordenDto> createBorden(@RequestBody RequestBordenDto requestBordenDto){
        ResponseBordenDto responseBordenDto = bordenService.saveBorden(requestBordenDto);
        return ResponseEntity.status(HttpStatus.OK).body(responseBordenDto);
    }

    @PutMapping("/put")
    public ResponseEntity<ResponseBordenDto> changeBordenName(@RequestBody ChangeNameRequestDto changeNameRequestDto) throws Exception{
        ResponseBordenDto responseBordenDto = bordenService.changeBordenName(changeNameRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(responseBordenDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBorden(String name) throws Exception{
        bordenService.deleteBorden(name);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }



}
