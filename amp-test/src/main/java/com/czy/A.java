package com.czy;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A
 *
 * @author caizy
 * @date 2020/5/7 13:42
 **/
@Component
@Setter
@Getter
public class A {

    @Autowired
    private B b;

    @PostConstruct
    public void init(){
        b.setA(this);
    }
}
