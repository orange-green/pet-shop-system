# pet-shop-system
宠物商店系统，爆改天坑毕业设计而来。将原本的前后端不分离的系统，拆分成了前后端分离的系统.





##### 环境需要

###### 后端

- jdk1.8
- maven3.x
- mysql5.7



###### 前端

- node 12.10.0
- vue2
- elementUI

安装node, 我使用的nvm进行node环境管理

nvm git 下载地址：[Releases · coreybutler/nvm-windows (github.com)](https://github.com/coreybutler/nvm-windows/releases)

node下载地址：[Index of /dist/v12.10.0/ (nodejs.org)](https://nodejs.org/dist/v12.10.0/)

安装好nvm后，下载node的压缩包解压到nvm的安装目录下

使用nvm list 查看本机存在的node环境

使用nvm use 具体node版本 来切换node环境

使用node -v 查看node版本

注意：请在cmd中运行node 、 npm命令，在powershell中运行会有问题。



```js
#npm换国内源
npm config set registry https://registry.npmmirror.com

使用npm install 安装前端所需要的依赖

使用npm run serve 启用前端项目
```

npm install 失败

npm cache clean --force

用管理员权限打开cmd执行 npm install

删除C:\Users\{账户}\下的.npmrc文件

###### mysql 数据库和数据表

zaixianyuyue表 增加comment字段
shangjia表 增加lisenceimage字段



#mysql 时区错误问题修正

select now();
show variables like "%time_zone%";
set global time_zone = '+8:00'; 
set time_zone = '+8:00'; 
flush privileges;





###### 8080端口被占用的

netstat -ano | findstr 8080

taskkill /pid  进程号 /f







##### 部署访问

###### 前后端分离部署

后端使用java, 可打成jar包运行

PetShopSystemBackend 后端

前端使用node运行

PetShopSystemAdminFront 管理前端

PetShopSystemFront 用户前端





###### 后端混合部署

需要将管理前端和用户前端的代码 通过npm run build 打包后 将dist目录复制到PetShopSystemBackend\src\main\resources目录下对应的admin目录和front目录下

管理端访问：http://localhost:8080/springbootpavyhdan/admin/dist/index.html

用户端访问：http://localhost:8080/springbootpavyhdan/front/dist/index.html



