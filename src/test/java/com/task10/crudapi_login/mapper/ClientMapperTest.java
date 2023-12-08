package com.task10.crudapi_login.mapper;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import com.task10.crudapi_login.entity.Client;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DBRider
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ClientMapperTest {
    @Autowired
    ClientMapper clientMapper;

    @Test
    @DataSet(value = "datasets/clients.yml")
    @Transactional
    void 顧客データを全件取得すること() {
        List<Client> clients = clientMapper.findAll();
        assertThat(clients)
                .hasSize(3)
                .contains(
                        new Client(1, "田中一郎", 20, "09011111111"),
                        new Client(2, "鈴木二郎", 15, "08022222222"),
                        new Client(3, "佐藤三郎", 30, "08033333333")
                );
    }

    @Test
    @DataSet(value = "datasets/clients.yml")
    @Transactional
    void 存在するIDを指定した時に特定の顧客データを取得すること() {
        Optional<Client> clients = clientMapper.findById(1);
        assertThat(clients)
                .contains(
                        new Client(1, "田中一郎", 20, "09011111111")
                );
    }

    @Test
    @DataSet(value = "datasets/clients.yml")
    @Transactional
    void 存在しないIDを指定する場合にListが空の情報を取得すること() {
        Optional<Client> clients = clientMapper.findById(99);
        assertThat(clients).isEmpty();
    }
}
