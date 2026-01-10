package com.op.app.service.implementation;

import com.op.app.dto.UserDto;
import com.op.app.model.User;
import com.op.app.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl classUnderTest;

    UserDto userDto;
    User user;

    @BeforeEach
    void setUp() {
        classUnderTest = new UserServiceImpl(userRepository);
        setUser();
    }

    void setUser() {
        userDto = new UserDto();
        userDto.setBalance(1.0);
        userDto.setName("test");
        user = new User();
        user.setName(userDto.getName());
        user.setBalance(userDto.getBalance());
    }

    @Test
    void createUser() {
        //Given
        when(userRepository.save(any(User.class))).thenReturn(user);
        //When
        var resultTest = classUnderTest.createUser(userDto);
        //Then
        assertThat(userDto.getName()).isEqualTo(resultTest.getName());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void getBalance() {
        //Given
        when(userRepository.findById(any(Long.class))).thenReturn(Optional.of(user));
        //When
        var resultTest = classUnderTest.getBalance(1L);
        //Then
        assertThat(resultTest).isEqualTo(user.getBalance());
        verify(userRepository, times(1)).findById(any(Long.class));
    }
}