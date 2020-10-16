package com.czy;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * A
 *
 * @author caizy
 * @date 2020/5/7 13:42
 **/
@Component
@Setter
@Getter
public class B {


    private A a;
}
