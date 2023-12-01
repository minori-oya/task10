package com.task10.crudapi_login.service;

import com.task10.crudapi_login.entity.Client;
import com.task10.crudapi_login.exception.ClientNotFoundException;
import com.task10.crudapi_login.mapper.ClientMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ClientServiceImplTest {

    @InjectMocks
    ClientServiceImpl clientServiceImpl;

    @Mock
    ClientMapper clientMapper;

    @Test
    public void メソッド呼び出しで顧客データを全件取得すること() {
        List<Client> client = List.of(
                new Client(1, "田中一郎", 20, "09011111111"),
                new Client(2, "鈴木二郎", 15, "08022222222"),
                new Client(3, "佐藤三郎", 30, "08033333333")
        );
        doReturn(client).when(clientMapper).findAll();
        List<Client> actual = clientServiceImpl.findAll();
        assertThat(actual).isEqualTo(client);
        verify(clientMapper, times(1)).findAll();
    }

    @Test
    public void 存在する顧客のIDを指定した時に特定の顧客情報を返すこと() throws ClientNotFoundException {
        doReturn(Optional.of(new Client(1, "田中一郎", 20, "09011111111"))).when(clientMapper).findById(1);

        Client actual = clientServiceImpl.findById(1);
        assertThat(actual).isEqualTo(new Client(1, "田中一郎", 20, "09011111111"));
        verify(clientMapper, times(1)).findById(1);
    }

    @Test
    public void 存在しないIDをリクエストした時にエラーを返す() throws ClientNotFoundException {
        doReturn(Optional.empty()).when(clientMapper).findById(99);

        assertThrows(ClientNotFoundException.class, () -> {
            clientServiceImpl.findById(99);
        });
    }

    @Test
    public void 顧客データを新規登録する() {
        Client client = new Client(4, "石田四郎", 45, "08044444444");
        doNothing().when(clientMapper).insert(client);

        Client actual = clientServiceImpl.create(client);
        assertThat(actual).isEqualTo(new Client(4, "石田四郎", 45, "08044444444"));
        verify(clientMapper, times(1)).insert(client);
    }

    @Test
    public void 顧客データの属性を全て更新すること() {
        Client client = new Client(2, "鈴木二郎", 15, "08022222222");
        doReturn(Optional.of(client)).when(clientMapper).findById(2);

        doNothing().when(clientMapper).update(new Client(2, "山本二郎", 16, "09022222222"));

        Client actual = clientServiceImpl.update(2, "山本二郎", 16, "09022222222");
        assertThat(actual).isEqualTo(new Client(2, "山本二郎", 16, "09022222222"));
        verify(clientMapper, times(2)).findById(2);
    }

    @Test
    public void 存在しないIDを更新しようとするとエラーを返す() throws ClientNotFoundException {
        doReturn(Optional.empty()).when(clientMapper).findById(99);

        assertThatThrownBy(() -> {
            clientServiceImpl.update(99, "山本二郎", 16, "09022222222");
        })
                .isInstanceOf(ClientNotFoundException.class)
                .hasMessage("resource not found");
        verify(clientMapper, times(2)).findById(99);
    }

    @Test
    public void 顧客データを削除する() {
        Client client = new Client(3, "佐藤三郎", 30, "08033333333");
        doReturn(Optional.of(client)).when(clientMapper).findById(3);
        clientServiceImpl.delete(3);
        verify(clientMapper).delete(3);
    }

    @Test
    public void 存在しないIDを削除しようとするとエラーを返す() throws ClientNotFoundException {
        doReturn(Optional.empty()).when(clientMapper).findById(99);

        assertThatThrownBy(() -> clientServiceImpl.delete(99))
                .isInstanceOf(ClientNotFoundException.class)
                .hasMessage("resource not found");
        verify(clientMapper, times(3)).findById(99);
        verify(clientMapper, times(0)).delete(99);
    }
}
