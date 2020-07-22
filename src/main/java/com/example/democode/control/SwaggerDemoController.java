package com.example.democode.control;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
* 控制层 简单演示增删改查及分页
*
*/
@RestController
@RequestMapping("api")
@Api("swaggerDemoController相关的api")
public class SwaggerDemoController {

    @Autowired
    private static final Logger logger=  LoggerFactory.getLogger(SwaggerDemoController.class);
    //1.商品添加
    //@PutMapping("add") 添加方法--restful风格
    @PutMapping("add")
    @ApiOperation(value="商品新增")
    //正常业务时， 需要在category类里或者server层进行事务控制，控制层一般不进行业务控制的。
    //@Transactional(rollbackFor = Exception.class)
    //@RequestParam 接收页面中的请求的参数
    public Map<String,Object> addCategory(@RequestParam  String name){
      logger.info("开始新增某个商品信息");
        Map<String,Object> result = new  HashMap<String,Object>();
        result.put("respCode", "01");
        result.put("respMsg", "新增成功！");
        return result;
    }
    //2.商品修改
    //@PostMapping("update")  修改方法--restful风格
    @PostMapping("update")  
    @ApiOperation(value = "商品修改", notes = "修改数据库中某个的商品信息")
    //@RequestBody 接收页面中的请求的参数对象（适用于post请求）
    //当入参为实体对象时，需要在方法上加@Valid或@Validated或者在参数前加@Valid或@Validated，或者在类上加@Validated
    public Map<String,Object> updateCategory() {
      Map<String,Object> result = new  HashMap<String,Object>();
        logger.info("开始修改某个商品信息");
        result.put("respCode", "03");
         result.put("respMsg", "修改成功！");
        return result;
    }
    //3.商品删除
    //@DeleteMapping("/delete/{id}") 删除方法--restful风格
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据id删除商品", notes = "商品删除")
    @ApiImplicitParam(name = "id", value = "商品ID",  paramType = "path", required = true, dataType =  "Integer")
     public Map<String,Object>  deleteCategory(@PathVariable int id)throws Exception{   //@PathVariable 获取/delete/{id}中id
      Map<String,Object> result = new  HashMap<String,Object>();
      logger.info("开始删除某个商品信息");
      result.put("respCode", "01");
      result.put("respMsg", "删除成功！");
      return result;
     }
}