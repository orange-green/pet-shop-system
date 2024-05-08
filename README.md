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



```js
#npm换国内源
npm config set registry https://registry.npmmirror.com

使用npm install 安装前端所需要的依赖

使用npm run serve 启用前端项目
```



###### mysql 数据库和数据表

zaixianyuyue表 增加comment 字段
shangjia表 增加 lisenceimage 字段



#mysql 时区错误问题修正

select now();
show variables like "%time_zone%";
set global time_zone = '+8:00'; 
set time_zone = '+8:00'; 
flush privileges;
