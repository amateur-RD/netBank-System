# netBank-System
netBank(网上银行系统)，该系统包含普通用户和管理员两个角色，管理员：管理普通用户（添加、删除、冻结和启用）、查看交易记录、修改密码、注销；普通用户：存钱、取钱、转账、修改密码、注销。

## 开发工具
* Language
    * Java
* Software
    * tomcat8.5
    * jdk1.8
    * mysql5.5
    * eclipse 8.5
* Frame
    * SSH2(Struts2-Spring3-Hibernate4)
    
## 系统分析
* 需求分析
    * 普通用户
        * 普通用户可以执行存款、取款、转账、查看交易记录、查看个人信息、修改个人信息、修改密码和注销等功能。用例图如下图所示。<br>
        ![user](https://github.com/amateur-RD/netBank-System/raw/master/demo/user.png)

    * 管理员
        * 管理员可以查看所有账户信息、查看已冻结账户信息、查看已启用账户信息、开户、修改密码和注销等功能。用例图如下图所示。<br>
         ![admin](https://github.com/amateur-RD/netBank-System/raw/master/demo/admin.png)
* 系统功能
    * 用户能够方便的进行存款、取款、转账等操作。
    * 用户能够分页查看账户的所有交易记录、可以查看、修改个人信息。
    * 管理员可以方便的进行账户管理，包括开户、进行账户的启用冻结、查看和删除账户信息。
    * 可以进行模糊查询，管理员界面可以通过输入账户的开户名模糊查询匹配的账户。

## 系统演示
![演示](https://github.com/amateur-RD/netBank-System/raw/master/demo/演示.gif)
