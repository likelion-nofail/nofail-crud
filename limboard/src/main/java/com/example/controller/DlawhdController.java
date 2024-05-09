package com.example.controller;

import com.example.data.dto.request.ChangeNameRequestDto;
import com.example.data.dto.request.RequestDlawhdDto;
import com.example.data.dto.response.ResponseDlawhdDto;
import com.example.service.DlawhdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dlawhd-gus")
public class DlawhdController {
    private final DlawhdService dlawhdService;


    @Autowired
    public DlawhdController(DlawhdService dlawhdService) {
        this.dlawhdService = dlawhdService;
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseDlawhdDto> getDlawhd(@RequestParam String email) throws Exception {
        ResponseDlawhdDto responseDlawhdDto = dlawhdService.getDlawhd(email);

        return ResponseEntity.status(HttpStatus.OK).body(responseDlawhdDto);
    }

    @PostMapping("/post")
    public ResponseEntity<ResponseDlawhdDto> createDlawhd(@RequestBody RequestDlawhdDto requestDlawhdDto){
        ResponseDlawhdDto responseDlawhdDto = dlawhdService.saveDlawhd(requestDlawhdDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseDlawhdDto);
    }
    @PutMapping("/put")
    public ResponseEntity<ResponseDlawhdDto> changeDlawhdName(@RequestBody ChangeNameRequestDto changeNameRequestDto) throws Exception {
        ResponseDlawhdDto responseDlawhdDto = dlawhdService.changeDlawhdName(changeNameRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseDlawhdDto);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteDla(String email) throws Exception {
        dlawhdService.deleteDla(email);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}