package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 自己的规则
 * @Author xwz
 * @Date 2020/5/28 10:44
 * @Version 1.0
 */
@Component
public class MyLB implements LoadBalancer{
    private AtomicInteger nextServerCyclicCounter = new AtomicInteger(0);

    public final int incrementAndGetModulo(){
        //当前位
        int current;
        //下一位指标
        int index;

        do{
            current = nextServerCyclicCounter.get();
            index = current>=2147483647?0:current+1;

        }while (!nextServerCyclicCounter.compareAndSet(current,index));
        System.out.println("*****第几次访问，次数index: "+index);
        return index;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = incrementAndGetModulo()%serviceInstances.size();
        return serviceInstances.get(index);
    }
}
