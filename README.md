# bootframe
一个maven构建的多模块服务脚手架

| 模块     | 描述                                   |
|--------|--------------------------------------|
| biz    | 业务层模块                                |
| common | 通用组件模块                               |
| config | 配置模块，服务在不同环境部署会有不同的配置文件，方便维护所以抽出配置模块 |
| dao    | 持久层模块                                |
| web    | web层模块，包含各类api和启动类                   |
| cloud  | 集成spring-cloud或者spring-cloud alibaba |

**鉴权**：
无鉴权、鉴权组件、inrouter访问

**api文档生成**：
knife4j、swagger、apifox

**代码生成器**：
mybatis plus代码生成

**todo**：
.sh的shell脚本

**PS**：tims是目前正在喝的咖啡

**代码生成器**：使用MyBatisX，免费、功能完整，可视化界面配置、无代码侵入。生成mapper接口记得加@Mapper和@Repository注解