package com.liushang.cloud.controller;

import com.liushang.cloud.apis.PayFeignApi;
import com.liushang.cloud.entities.PayDTO;
import com.liushang.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author liushang
 * @date 2024-09-24 20:43:45
 */
@RestController
public class OrderController {

    @Resource
    private PayFeignApi payFeignApi;

    @PostMapping(value = "/feign/pay/add" )
    public ResultData addOrder(@RequestBody PayDTO payDTO){
        System.out.println("第一步：模拟本地addOrder新增订单成功（省略sql操作），第二步：再开启addPay支付微服务远程调用");
        ResultData resultData = payFeignApi.addPay(payDTO);
        return resultData;
    }

    @GetMapping(value = "/feign/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){
        return payFeignApi.getPayInfo(id);
    }

    @GetMapping(value = "/feign/pay/mylb")
    public String getMylb(){
        return payFeignApi.mylb();
    }
}
