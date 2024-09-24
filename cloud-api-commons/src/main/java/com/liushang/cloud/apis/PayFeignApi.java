package com.liushang.cloud.apis;

import com.liushang.cloud.entities.PayDTO;
import com.liushang.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author liushang
 * @date 2024-09-24 21:10:34
 */
@FeignClient(value = "cloud-payment-service")
public interface PayFeignApi {

    @PostMapping(value = "/pay/add")
    public ResultData addPay(@RequestBody PayDTO payDTO);

    @GetMapping(value = "/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/get/info")
    public String mylb();
}
