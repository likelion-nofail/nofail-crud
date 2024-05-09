package org.springboot.nofail_crud.service.impl;

import org.springboot.nofail_crud.data.dao.BordenDAO;
import org.springboot.nofail_crud.data.dto.request.ChangeNameRequestDto;
import org.springboot.nofail_crud.data.dto.request.RequestBordenDto;
import org.springboot.nofail_crud.data.dto.response.ResponseBordenDto;
import org.springboot.nofail_crud.data.entity.Borden;
import org.springboot.nofail_crud.service.BordenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BordenServiceImpl implements BordenService {

    private final BordenDAO bordenDAO;

    @Autowired
    public BordenServiceImpl(BordenDAO bordenDAO){
        this.bordenDAO = bordenDAO;
    }

    @Override
    public ResponseBordenDto getBorden(String name) throws Exception{
        Borden borden = bordenDAO.selectBorden(name);

        ResponseBordenDto responseBordenDto = new ResponseBordenDto();
        responseBordenDto.setId(borden.getId());
        responseBordenDto.setContents(borden.getContents());
        responseBordenDto.setName(borden.getName());
        responseBordenDto.setPassword(borden.getPassword());
        responseBordenDto.setTitle(borden.getTitle());

        return responseBordenDto;

    }

    @Override
    public ResponseBordenDto saveBorden(RequestBordenDto requestBordenDto){
        Borden borden = new Borden();
        borden.setContents(requestBordenDto.getContents());
        borden.setTitle(requestBordenDto.getTitle());
        borden.setPassword(requestBordenDto.getPassword());
        borden.setName(requestBordenDto.getName());

        borden.setCreateAt(LocalDateTime.now());
        borden.setUpdatedAt(LocalDateTime.now());

        Borden saveBorden = bordenDAO.insertBorden(borden);

        ResponseBordenDto responseBordenDto = new ResponseBordenDto();
        responseBordenDto.setId(saveBorden.getId());
        responseBordenDto.setContents(saveBorden.getContents());
        responseBordenDto.setTitle(saveBorden.getTitle());
        responseBordenDto.setPassword(saveBorden.getPassword());
        responseBordenDto.setName(saveBorden.getName());

        return responseBordenDto;

    }

    @Override
    public ResponseBordenDto changeBordenName(ChangeNameRequestDto changeNameRequestDto) throws Exception {
        Borden findBorden = bordenDAO.updateBordenName(changeNameRequestDto.getName());

        ResponseBordenDto responseBordenDto = new ResponseBordenDto();
        responseBordenDto.setId(findBorden.getId());
        responseBordenDto.setName(findBorden.getName());
        responseBordenDto.setPassword(findBorden.getPassword());
        responseBordenDto.setContents(findBorden.getContents());
        responseBordenDto.setTitle(findBorden.getTitle());

        return responseBordenDto;
    }

    @Override
    public void deleteBorden(String name) throws Exception {
        bordenDAO.deleteBorden(name);
    }



}
