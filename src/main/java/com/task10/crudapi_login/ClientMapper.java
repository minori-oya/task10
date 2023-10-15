package com.task10.crudapi_login;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ClientMapper {
    @Select("SELECT * FROM clients ")
    List<Client> findAll();
}
