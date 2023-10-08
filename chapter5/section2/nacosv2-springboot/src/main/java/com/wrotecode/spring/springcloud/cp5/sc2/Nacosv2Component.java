package com.wrotecode.spring.springcloud.cp5.sc2;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.stereotype.Component;

@Component
public class Nacosv2Component {
    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    public boolean getUseLocalCache() {
        return useLocalCache;
    }
}
