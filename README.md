# spring-cloud-sofa
简介

   1 spring-cloud-sofa 是分布式系统的完整解决方案，适合应用于开发平台，分布式系统的基础框架。开箱即用。满足快速开发的实际需要
 
 
 
   2 框架配备了详细的文档,框架的使用者无需深刻的去学习spring-cloud,通过框架的文档即可快速上手实现基于spring-cloud分布式系统的开发


总体模块说明
       
       spring-cloud-sofa-center        ---------            注册中心       
       
       spring-cloud-sofa-gate          ---------            网关 
       
       spring-cloud-sofa-tracer        ---------            分布式链路追踪 
       
       spring-cloud-sofa-tracer        ---------            分布式框架鉴权
       
       spring-cloud-sofa-drm           ------------         分布式DRM开关
       
       spring-cloud-sofa-file          ------------         分布式文件系统
       
       spring-cloud-sofa-message       ------------          scokcet服务器
       
       spring-cloud-sofa-tari          ------------          缓存服务
       
       spring-cloud-sofa-sidecar      ---------------        第三方接入系统
       
       spring-cloud-sofa-todo        ---------------         代办中心
       
       spring-cloud-sofa-common      ----------------        基础组件基础包
       

spring-cloud-sofa-center 

     1 分布式系统的注册中心，用于存储各个服务的基本信息   技术底层使用的是spring-cloud-eurka。

     2  注册中心部署上分为单节点部署，集群部署俩种方式。这两种方式不同之处，对于框架使用者来说只是编写配置文件

        2.1  单节点部署方式配置文件编写详解
            
            server:
            
              port: 8761 (指定注册中心的端口号，用于其他系统连接时使用)
            
            eureka:
            
              instance:
            
                hostname: localhost (配置当前服务器ip地址)
            
              client:
            
                    registerWithEureka: false  (是否将注册中心也进行注册)
            
                    fetchRegistry: false       （是否获取注册中心的注册信息）
            
                    service-url:                （注册中心的连接地址）
            
                        defaultZone :  http://${eureka.instance.hostname}:${server.port}/eureka/
          2.2 集群配置
          
             此处待补充
             
    3  启动注册中心               
    
         3.1 开发环境
    
             启动 CenterApplication main 方法即可启动注册中心
    
         3.2 正式环境
    
              打成jar包后，java -jar 即可启动
                  
             
   spring-cloud-sofa-gate
   
     分布式系统的网关，提供对外系统的服务能力，目前底层使用的框架为 spring-cloud-gateway.网关核心能力是提供外部系统调用能力，
  
     网关状态码已经进行明确的规定，如下图
       
      

      