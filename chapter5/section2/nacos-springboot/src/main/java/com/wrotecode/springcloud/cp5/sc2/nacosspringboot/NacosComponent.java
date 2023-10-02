package com.wrotecode.springcloud.cp5.sc2.nacosspringboot;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NacosComponent {
    @NacosInjected
    private NamingService namingService;

    public List<Instance> discovery(String name) throws NacosException {
        return namingService.getAllInstances(name);
    }

    public void register(String serviceName, String ip, int port) throws NacosException {
        namingService.registerInstance(serviceName, ip, port);
    }
}
