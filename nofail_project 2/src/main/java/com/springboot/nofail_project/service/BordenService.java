package com.springboot.nofail_project.service;

import com.springboot.nofail_project.data.dto.request.ChangeNameRequestDto;
import com.springboot.nofail_project.data.dto.request.RequestBordenDto;
import com.springboot.nofail_project.data.dto.response.ResponseBordenDto;

public interface BordenService {

    ResponseBordenDto getBorden(String name) throws Exception;
    ResponseBordenDto saveBorden(RequestBordenDto requestBordenDto);


    ResponseBordenDto changeBordenName(ChangeNameRequestDto changeNameRequestDto) throws Exception;

    void deleteBorden(String name) throws Exception;

}
