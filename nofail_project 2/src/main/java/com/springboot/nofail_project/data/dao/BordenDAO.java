package com.springboot.nofail_project.data.dao;

import com.springboot.nofail_project.data.entity.Borden;

public interface BordenDAO {

    Borden insertBorden(Borden borden);

    Borden selectBorden(String name) throws Exception;

    Borden updateBordenName(String name) throws Exception;

    void deleteBorden(String name) throws Exception;

}
