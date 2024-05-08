package com.example.service.Impl;

import com.example.data.dao.DlawhdDAO;
import com.example.data.dto.request.ChangeNameRequestDto;
import com.example.data.dto.request.RequestDlawhdDto;
import com.example.data.dto.response.ResponseDlawhdDto;
import com.example.data.entity.Dlawhd;
import com.example.service.DlawhdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DlawhdServiceImpl implements DlawhdService {

    private final DlawhdDAO dlawhdDAO;

    @Autowired
    public DlawhdServiceImpl(DlawhdDAO dlawhdDAO) {
        this.dlawhdDAO = dlawhdDAO;
    }

    @Override
    public ResponseDlawhdDto getDlawhd(String email) throws Exception {
        Dlawhd dlawhd = dlawhdDAO.selectDla(email);

        ResponseDlawhdDto responseBabyLionDto = new ResponseDlawhdDto();
        responseBabyLionDto.setPid(dlawhd.getPid());
        responseBabyLionDto.setName(dlawhd.getName());
        responseBabyLionDto.setEmail(dlawhd.getEmail());
        responseBabyLionDto.setNumber(dlawhd.getNumber());
        responseBabyLionDto.setProfile(dlawhd.getProfile());
        responseBabyLionDto.setPassword(dlawhd.getPassword());

        return responseBabyLionDto;
    }

    @Override
    public ResponseDlawhdDto saveDlawhd(RequestDlawhdDto requestDlawhdDto) {
        Dlawhd dlawhd = new Dlawhd();
        dlawhd.setName(requestDlawhdDto.getName());
        dlawhd.setEmail(requestDlawhdDto.getEmail());
        dlawhd.setNumber(requestDlawhdDto.getNumber());
        dlawhd.setPassword(requestDlawhdDto.getPassword());
        dlawhd.setCreateAt(LocalDateTime.now());
        dlawhd.setUpdatedAt(LocalDateTime.now());

        Dlawhd savedDla = dlawhdDAO.insertDla(dlawhd);

        ResponseDlawhdDto responseDlawhdDto = new ResponseDlawhdDto();
        responseDlawhdDto.setPid(savedDla.getPid());
        responseDlawhdDto.setEmail(savedDla.getEmail());
        responseDlawhdDto.setName(savedDla.getName());
        responseDlawhdDto.setNumber(savedDla.getNumber());
        responseDlawhdDto.setProfile(savedDla.getProfile());
        responseDlawhdDto.setPassword(savedDla.getPassword());

        return responseDlawhdDto;
    }

    @Override
    public ResponseDlawhdDto changeDlawhdName(ChangeNameRequestDto changeNameRequestDto) throws Exception {
        Dlawhd findDlawhd = dlawhdDAO.updateDla(changeNameRequestDto.getEmail(), changeNameRequestDto.getName());

        ResponseDlawhdDto responseDlawhdDto = new ResponseDlawhdDto();
        responseDlawhdDto.setPid(findDlawhd.getPid());
        responseDlawhdDto.setName(findDlawhd.getName());
        responseDlawhdDto.setEmail(findDlawhd.getEmail());
        responseDlawhdDto.setNumber(findDlawhd.getNumber());
        responseDlawhdDto.setPassword(findDlawhd.getPassword());
        responseDlawhdDto.setProfile(findDlawhd.getProfile());

        return responseDlawhdDto;
    }

    @Override
    public void deleteDla(String email) throws Exception {
        dlawhdDAO.deleteDla(email);
    }
}