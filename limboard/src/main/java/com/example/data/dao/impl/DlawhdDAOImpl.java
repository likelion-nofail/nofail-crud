package com.example.data.dao.impl;

import com.example.data.dao.DlawhdDAO;
import com.example.data.entity.Dlawhd;
import com.example.data.repository.DlawhdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class DlawhdDAOImpl implements DlawhdDAO {

    private final DlawhdRepository dlawhdRepository;

    @Autowired
    public DlawhdDAOImpl(DlawhdRepository dlawhdRepository) {
        this.dlawhdRepository = dlawhdRepository;
    }

    @Override
    public Dlawhd insertDla(Dlawhd dlawhd) {

        Dlawhd result = dlawhdRepository.save(dlawhd);

        return result;
    }

    @Override
    public Dlawhd selectDla(String email) throws Exception {
        Optional<Dlawhd> babyLion = dlawhdRepository.findByEmail(email);

        if(babyLion.isPresent()) {
            Dlawhd result = babyLion.get();
            return result;
        }else{
            throw new Exception("찾을 수 없음");
        }
    }

    @Override
    public Dlawhd updateDla(String email, String name) throws Exception {
        Optional<Dlawhd> findDlawhd = dlawhdRepository.findByEmail(email);

        Dlawhd result;

        if(findDlawhd != null){
            Dlawhd babyLion = findDlawhd.get();

            babyLion.setName(name);
            babyLion.setUpdatedAt(LocalDateTime.now());

            result = dlawhdRepository.save(babyLion);
        }else{
            throw new Exception("찾을 수 없음");
        }

        return result;
    }

    @Override
    public void deleteDla(String email) throws Exception {
        Optional<Dlawhd> findDlawhd = dlawhdRepository.findByEmail(email);

        if(findDlawhd != null){
            Dlawhd babyLion = findDlawhd.get();
            dlawhdRepository.delete(babyLion);
        }else{
            throw new Exception("찾을 수 없음");
        }
    }
}