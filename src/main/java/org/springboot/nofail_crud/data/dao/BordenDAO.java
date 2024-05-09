package org.springboot.nofail_crud.data.dao;

import org.springboot.nofail_crud.data.entity.Borden;

public interface BordenDAO {

    Borden insertBorden(Borden borden);

    Borden selectBorden(String name) throws Exception;

    Borden updateBordenName(String name) throws Exception;

    void deleteBorden(String name) throws Exception;

}
