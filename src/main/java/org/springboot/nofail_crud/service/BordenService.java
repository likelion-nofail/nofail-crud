package org.springboot.nofail_crud.service;

import org.springboot.nofail_crud.data.dto.request.ChangeNameRequestDto;
import org.springboot.nofail_crud.data.dto.request.RequestBordenDto;
import org.springboot.nofail_crud.data.dto.response.ResponseBordenDto;

public interface BordenService {

    ResponseBordenDto getBorden(String name) throws Exception;
    ResponseBordenDto saveBorden(RequestBordenDto requestBordenDto);


    ResponseBordenDto changeBordenName(ChangeNameRequestDto changeNameRequestDto) throws Exception;

    void deleteBorden(String name) throws Exception;

}
