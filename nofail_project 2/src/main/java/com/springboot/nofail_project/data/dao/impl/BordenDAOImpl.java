package com.springboot.nofail_project.data.dao.impl;

import com.springboot.nofail_project.data.dao.BordenDAO;
import com.springboot.nofail_project.data.entity.Borden;
import com.springboot.nofail_project.data.repository.BordenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class BordenDAOImpl implements BordenDAO {

    private final BordenRepository bordenRepository;

    @Autowired
    public BordenDAOImpl(BordenRepository bordenRepository){
        this.bordenRepository = bordenRepository;
    }

    @Override
    public Borden insertBorden(Borden borden){
        Borden result = bordenRepository.save(borden);
        return result;
    }

    @Override
    public Borden selectBorden(String name) throws Exception{
        Optional<Borden> borden = bordenRepository.findByName(name);

        if(borden.isPresent()){
            Borden result = borden.get();
            return result;
        } else{
            throw new Exception("존재하지 않습니다.");
        }

    }


    @Override
    public Borden updateBordenName(String name) throws Exception {
        Optional<Borden> findBorden = bordenRepository.findByName(name);

        Borden result;

        if(findBorden.isPresent()){
            Borden borden = findBorden.get();

            borden.setName(name);
            borden.setUpdatedAt(LocalDateTime.now());

            result = bordenRepository.save(borden);
        }else{
            throw new Exception("찾을 수 없음");
        }

        return result;
    }

    @Override
    public void deleteBorden(String name) throws Exception {
        Optional<Borden> findBorden = bordenRepository.findByName(name);

        if(findBorden.isPresent()){
            Borden borden = findBorden.get();
            bordenRepository.delete(borden);
        }else{
            throw new Exception("찾을 수 없음");
        }
    }


}
