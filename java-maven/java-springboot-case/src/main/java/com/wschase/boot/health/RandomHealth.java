package com.wschase.boot.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

import java.util.Random;

/**
 * Author:WSChase
 * Created:2019/4/29
 */
public class RandomHealth implements HealthIndicator {

    @Override
    public Health health() {
        boolean flag=new Random().nextBoolean();
        if(flag){
            //会将这些信息放进map里面，链式访问
            return Health.up().withDetail("info","System OK").build();
        }else {
            return Health.down().withDetail("info","System error").build();
        }
    }
}
