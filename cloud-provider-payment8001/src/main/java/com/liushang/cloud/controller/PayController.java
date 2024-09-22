package com.liushang.cloud.controller;

import com.liushang.cloud.entities.Pay;
import com.liushang.cloud.entities.PayDTO;
import com.liushang.cloud.resp.ResultData;
import com.liushang.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping(value = "/pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public ResultData<String> addPay(@RequestBody Pay pay){
        int add = payService.add(pay);
        return ResultData.success("成功插入记录，返回值：" + add);
    }

    @DeleteMapping(value = "/pay/del/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id){
        return ResultData.success(payService.delete(id));
    }

    @PutMapping(value = "/pay/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO,pay);
        int update = payService.update(pay);
        return ResultData.success("成功修改记录，返回值：" + update);
    }

    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public ResultData<Pay> getById(@PathVariable("id") Integer id){
        return ResultData.success(payService.getById(id));
    }

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/pay/get/info")
    private String getInfoByConsul(@Value("${liushang.info}") String liushangInfo)
    {
        return "liushangInfo: "+liushangInfo+"\t"+"port: "+port;
    }


}
