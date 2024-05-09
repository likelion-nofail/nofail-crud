package com.example.data.dao;

import com.example.data.entity.Dlawhd;

public interface DlawhdDAO {
    Dlawhd insertDla(Dlawhd dlawhd);

    Dlawhd selectDla(String email) throws Exception;

    Dlawhd updateDla(String email, String name) throws Exception;

    void deleteDla(String email) throws Exception;
}
