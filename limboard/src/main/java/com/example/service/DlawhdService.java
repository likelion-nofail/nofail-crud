package com.example.service;

import com.example.data.dto.request.ChangeNameRequestDto;
import com.example.data.dto.request.RequestDlawhdDto;
import com.example.data.dto.response.ResponseDlawhdDto;

public interface DlawhdService {
    ResponseDlawhdDto getDlawhd(String email) throws Exception;

    ResponseDlawhdDto saveDlawhd(RequestDlawhdDto requestBabyLionDto);

    ResponseDlawhdDto changeDlawhdName(ChangeNameRequestDto changeNameRequestDto) throws Exception;

    void deleteDla(String email) throws Exception;
}
