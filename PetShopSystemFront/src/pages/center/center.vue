<template>
  <div :style='{"width":"80%","margin":"10px auto","position":"relative","background":"#fff"}' class="center-preview">
    <div :style='{"boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3)","margin":"20px 0","color":"#000","textAlign":"center","background":"none","width":"100%","fontSize":"22px","lineHeight":"54px","fontWeight":"bold"}'
         class="title">
      {{ title }}
    </div>

    <div :style='{"padding":"20px 60px 0","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3)","margin":"0 auto 20px","borderRadius":"0","flexWrap":"wrap","background":"#ffffff","display":"flex","width":"100%","height":"auto"}'
         class="info">
      <div
          :style='{"borderColor":"#efefef","color":"#333","borderWidth":"0 0 1px 0","display":"none","width":"100%","lineHeight":"44px","fontSize":"15px","borderStyle":"solid","height":"44px"}'>
        个人信息
      </div>
      <div
          v-if="userTableName=='yonghu'"
          :style='{"width":"auto","borderColor":"#efefef","fontSize":0,"borderStyle":"solid","borderWidth":"0","height":"auto"}'>
        <el-image
            :src="sessionForm.touxiang?baseUrl + sessionForm.touxiang:require('@/assets/avator.png')"
            :style='{"margin":"10px auto","borderColor":"#efefef","objectFit":"cover","borderRadius":"100%","borderWidth":"0 0 1px 0","display":"block","width":"80px","borderStyle":"solid","height":"80px"}'
            fit="cover"></el-image>
      </div>
      <div
          v-if="userTableName=='shangjia'"
          :style='{"width":"auto","borderColor":"#efefef","fontSize":0,"borderStyle":"solid","borderWidth":"0","height":"auto"}'>
        <el-image
            :src="sessionForm.touxiang?baseUrl + sessionForm.touxiang:require('@/assets/avator.png')"
            :style='{"margin":"10px auto","borderColor":"#efefef","objectFit":"cover","borderRadius":"100%","borderWidth":"0 0 1px 0","display":"block","width":"80px","borderStyle":"solid","height":"80px"}'
            fit="cover"></el-image>
      </div>
      <div
          v-if="userTableName=='yishi'"
          :style='{"width":"auto","borderColor":"#efefef","fontSize":0,"borderStyle":"solid","borderWidth":"0","height":"auto"}'>
        <el-image
            :src="sessionForm.touxiang?baseUrl + sessionForm.touxiang:require('@/assets/avator.png')"
            :style='{"margin":"10px auto","borderColor":"#efefef","objectFit":"cover","borderRadius":"100%","borderWidth":"0 0 1px 0","display":"block","width":"80px","borderStyle":"solid","height":"80px"}'
            fit="cover"></el-image>
      </div>
      <div
          v-if="userTableName=='yonghu'"
          :style='{"padding":"0 20px","borderColor":"#efefef","margin":"10px 0 0","alignItems":"center","borderWidth":"0","display":"flex","width":"calc(100% - 300px)","lineHeight":"40px","borderStyle":"solid","height":"auto"}'>
        <span :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'
              class="icon iconfont icon-shouye-zhihui"></span>
        <div :style='{"color":"#333","fontSize":"14px","display":"none"}'>用户名</div>
        <div :style='{"fontSize":"18px","color":"#000","textAlign":"left","flex":1,"fontWeight":"bold"}'>
          {{ sessionForm.yonghuming }}
        </div>
      </div>
      <div
          v-if="userTableName=='yonghu'"
          :style='{"padding":"0 0","borderColor":"#efefef","margin":"0","alignItems":"center","borderWidth":"0","display":"flex","width":"200px","lineHeight":"40px","borderStyle":"solid","justifyContent":"center","height":"auto"}'>
        <span :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'
              class="icon iconfont icon-shouye-zhihui"></span>
        <div :style='{"color":"#9E9E9E","fontSize":"14px"}'>姓名</div>
        <div :style='{"color":"#9E9E9E","textAlign":"left","fontSize":"14px"}'>{{ sessionForm.xingming }}</div>
      </div>
      <div
          v-if="userTableName=='yonghu'"
          :style='{"padding":"50px 20px 20px","borderColor":"#efefef","margin":"20px 0 0","borderRadius":"30px 0 0 ","flexWrap":"wrap","borderWidth":"0","background":"#3B2E7E","display":"flex","width":"25%","lineHeight":"40px","borderStyle":"solid","height":"auto"}'>
        <span :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'
              class="icon iconfont icon-shouye-zhihui"></span>
        <div :style='{"width":"100%","fontSize":"15px","lineHeight":"1.5","color":"#fff","textAlign":"center"}'>性别</div>
        <div :style='{"width":"100%","fontSize":"14px","color":"#fff","textAlign":"center"}'>{{ sessionForm.xingbie }}
        </div>
      </div>
      <div
          v-if="userTableName=='yonghu'"
          :style='{"padding":"50px 20px 20px","borderColor":"#efefef","margin":"20px 0 0","flexWrap":"wrap","borderWidth":"0","background":"#3B2E7E","display":"flex","width":"25%","lineHeight":"40px","borderStyle":"solid","height":"auto"}'>
        <span :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'
              class="icon iconfont icon-shouye-zhihui"></span>
        <div :style='{"width":"100%","fontSize":"15px","lineHeight":"1.5","color":"#fff","textAlign":"center"}'>邮箱</div>
        <div :style='{"width":"100%","fontSize":"14px","color":"#fff","textAlign":"center"}'>
          {{ sessionForm.youxiang }}
        </div>
      </div>
      <div
          v-if="userTableName=='yonghu'"
          :style='{"padding":"50px 20px 20px","borderColor":"#efefef","margin":"20px 0 0","flexWrap":"wrap","borderWidth":"0","background":"#3B2E7E","display":"flex","width":"25%","lineHeight":"40px","borderStyle":"solid","height":"auto"}'>
        <span :style='{"padding":"0 5px","fontSize":"15px","lineHeight":"1.5","color":"#fff","display":"none"}'
              class="icon iconfont icon-shouye-zhihui"></span>
        <div :style='{"width":"100%","fontSize":"15px","lineHeight":"1.5","color":"#fff","textAlign":"center"}'>手机</div>
        <div :style='{"width":"100%","fontSize":"14px","color":"#fff","textAlign":"center"}'>{{ sessionForm.shouji }}
        </div>
      </div>
      <div
          v-if="userTableName=='yonghu'"
          :style='{"padding":"50px 20px 20px","borderColor":"#efefef","margin":"20px 0 0","borderRadius":"0 30px 0 0","flexWrap":"wrap","borderWidth":"0","background":"#3B2E7E","display":"flex","width":"25%","lineHeight":"40px","borderStyle":"solid","height":"auto"}'>
        <span :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'
              class="icon iconfont icon-shouye-zhihui"></span>
        <div :style='{"width":"100%","fontSize":"15px","lineHeight":"1.5","color":"#fff","textAlign":"center"}'>余额</div>
        <div :style='{"width":"100%","fontSize":"14px","color":"#fff","textAlign":"center"}'>{{ sessionForm.money }}
        </div>
      </div>
      <div
          v-if="userTableName=='shangjia'"
          :style='{"padding":"0 20px","borderColor":"#efefef","margin":"10px 0 0","alignItems":"center","borderWidth":"0","display":"flex","width":"calc(100% - 300px)","lineHeight":"40px","borderStyle":"solid","height":"auto"}'>
        <span :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'
              class="icon iconfont icon-shouye-zhihui"></span>
        <div :style='{"color":"#333","fontSize":"14px","display":"none"}'>账号</div>
        <div :style='{"fontSize":"18px","color":"#000","textAlign":"left","flex":1,"fontWeight":"bold"}'>
          {{ sessionForm.dianpumingcheng }}
        </div>
      </div>
      <div
          v-if="userTableName=='shangjia'"
          :style='{"padding":"0 0","borderColor":"#efefef","margin":"0","alignItems":"center","borderWidth":"0","display":"flex","width":"200px","lineHeight":"40px","borderStyle":"solid","justifyContent":"center","height":"auto"}'>
        <span :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'
              class="icon iconfont icon-shouye-zhihui"></span>
        <div :style='{"color":"#9E9E9E","fontSize":"14px"}'>负责人</div>
        <div :style='{"color":"#9E9E9E","textAlign":"left","fontSize":"14px"}'>{{ sessionForm.fuzeren }}</div>
      </div>
      <div
          v-if="userTableName=='shangjia'"
          :style='{"padding":"50px 20px 20px","borderColor":"#efefef","margin":"20px 0 0","borderRadius":"30px 0 0 ","flexWrap":"wrap","borderWidth":"0","background":"#3B2E7E","display":"flex","width":"25%","lineHeight":"40px","borderStyle":"solid","height":"auto"}'>
        <span :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'
              class="icon iconfont icon-shouye-zhihui"></span>
        <div :style='{"width":"100%","fontSize":"15px","lineHeight":"1.5","color":"#fff","textAlign":"center"}'>性别</div>
        <div :style='{"width":"100%","fontSize":"14px","color":"#fff","textAlign":"center"}'>{{ sessionForm.xingbie }}
        </div>
      </div>
      <div
          v-if="userTableName=='shangjia'"
          :style='{"padding":"50px 20px 20px","borderColor":"#efefef","margin":"20px 0 0","flexWrap":"wrap","borderWidth":"0","background":"#3B2E7E","display":"flex","width":"25%","lineHeight":"40px","borderStyle":"solid","height":"auto"}'>
        <span :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'
              class="icon iconfont icon-shouye-zhihui"></span>
        <div :style='{"width":"100%","fontSize":"15px","lineHeight":"1.5","color":"#fff","textAlign":"center"}'>年龄</div>
        <div :style='{"width":"100%","fontSize":"14px","color":"#fff","textAlign":"center"}'>
          {{ sessionForm.nianling }}
        </div>
      </div>
      <div
          v-if="userTableName=='shangjia'"
          :style='{"padding":"50px 20px 20px","borderColor":"#efefef","margin":"20px 0 0","flexWrap":"wrap","borderWidth":"0","background":"#3B2E7E","display":"flex","width":"25%","lineHeight":"40px","borderStyle":"solid","height":"auto"}'>
        <span :style='{"padding":"0 5px","fontSize":"15px","lineHeight":"1.5","color":"#fff","display":"none"}'
              class="icon iconfont icon-shouye-zhihui"></span>
        <div :style='{"width":"100%","fontSize":"15px","lineHeight":"1.5","color":"#fff","textAlign":"center"}'>联系电话
        </div>
        <div :style='{"width":"100%","fontSize":"14px","color":"#fff","textAlign":"center"}'>
          {{ sessionForm.lianxidianhua }}
        </div>
      </div>
      <div
          v-if="userTableName=='shangjia'"
          :style='{"padding":"50px 20px 20px","borderColor":"#efefef","margin":"20px 0 0","borderRadius":"0 30px 0 0","flexWrap":"wrap","borderWidth":"0","background":"#3B2E7E","display":"flex","width":"25%","lineHeight":"40px","borderStyle":"solid","height":"auto"}'>
        <span :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'
              class="icon iconfont icon-shouye-zhihui"></span>
        <div :style='{"width":"100%","fontSize":"15px","lineHeight":"1.5","color":"#fff","textAlign":"center"}'>余额</div>
        <div :style='{"width":"100%","fontSize":"14px","color":"#fff","textAlign":"center"}'>{{ sessionForm.money }}
        </div>
      </div>
      <div
          v-if="userTableName=='yishi'"
          :style='{"padding":"0 20px","borderColor":"#efefef","margin":"10px 0 0","alignItems":"center","borderWidth":"0","display":"flex","width":"calc(100% - 300px)","lineHeight":"40px","borderStyle":"solid","height":"auto"}'>
        <span :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'
              class="icon iconfont icon-shouye-zhihui"></span>
        <div :style='{"color":"#333","fontSize":"14px","display":"none"}'>店铺名称</div>
        <div :style='{"fontSize":"18px","color":"#000","textAlign":"left","flex":1,"fontWeight":"bold"}'>
          {{ sessionForm.dianpumingcheng }}
        </div>
      </div>
      <div
          v-if="userTableName=='yishi'"
          :style='{"padding":"0 0","borderColor":"#efefef","margin":"0","alignItems":"center","borderWidth":"0","display":"flex","width":"200px","lineHeight":"40px","borderStyle":"solid","justifyContent":"center","height":"auto"}'>
        <span :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'
              class="icon iconfont icon-shouye-zhihui"></span>
        <div :style='{"color":"#9E9E9E","fontSize":"14px"}'>账号</div>
        <div :style='{"color":"#9E9E9E","textAlign":"left","fontSize":"14px"}'>{{ sessionForm.zhanghao }}</div>
      </div>
      <div
          v-if="userTableName=='yishi'"
          :style='{"padding":"50px 20px 20px","borderColor":"#efefef","margin":"20px 0 0","borderRadius":"30px 0 0 ","flexWrap":"wrap","borderWidth":"0","background":"#3B2E7E","display":"flex","width":"25%","lineHeight":"40px","borderStyle":"solid","height":"auto"}'>
        <span :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'
              class="icon iconfont icon-shouye-zhihui"></span>
        <div :style='{"width":"100%","fontSize":"15px","lineHeight":"1.5","color":"#fff","textAlign":"center"}'>姓名</div>
        <div :style='{"width":"100%","fontSize":"14px","color":"#fff","textAlign":"center"}'>
          {{ sessionForm.yishixingming }}
        </div>
      </div>
      <div
          v-if="userTableName=='yishi'"
          :style='{"padding":"50px 20px 20px","borderColor":"#efefef","margin":"20px 0 0","flexWrap":"wrap","borderWidth":"0","background":"#3B2E7E","display":"flex","width":"25%","lineHeight":"40px","borderStyle":"solid","height":"auto"}'>
        <span :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'
              class="icon iconfont icon-shouye-zhihui"></span>
        <div :style='{"width":"100%","fontSize":"15px","lineHeight":"1.5","color":"#fff","textAlign":"center"}'>性别</div>
        <div :style='{"width":"100%","fontSize":"14px","color":"#fff","textAlign":"center"}'>{{ sessionForm.xingbie }}
        </div>
      </div>
      <div
          v-if="userTableName=='yishi'"
          :style='{"padding":"50px 20px 20px","borderColor":"#efefef","margin":"20px 0 0","flexWrap":"wrap","borderWidth":"0","background":"#3B2E7E","display":"flex","width":"25%","lineHeight":"40px","borderStyle":"solid","height":"auto"}'>
        <span :style='{"padding":"0 5px","fontSize":"15px","lineHeight":"1.5","color":"#fff","display":"none"}'
              class="icon iconfont icon-shouye-zhihui"></span>
        <div :style='{"width":"100%","fontSize":"15px","lineHeight":"1.5","color":"#fff","textAlign":"center"}'>年龄</div>
        <div :style='{"width":"100%","fontSize":"14px","color":"#fff","textAlign":"center"}'>
          {{ sessionForm.nianling }}
        </div>
      </div>
      <div
          v-if="userTableName=='yishi'"
          :style='{"padding":"50px 20px 20px","borderColor":"#efefef","margin":"20px 0 0","borderRadius":"0 30px 0 0","flexWrap":"wrap","borderWidth":"0","background":"#3B2E7E","display":"flex","width":"25%","lineHeight":"40px","borderStyle":"solid","height":"auto"}'>
        <span :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'
              class="icon iconfont icon-shouye-zhihui"></span>
        <div :style='{"width":"100%","fontSize":"15px","lineHeight":"1.5","color":"#fff","textAlign":"center"}'>职位</div>
        <div :style='{"width":"100%","fontSize":"14px","color":"#fff","textAlign":"center"}'>{{ sessionForm.zhiwei }}
        </div>
      </div>

    </div>

    <el-tabs :style='{"width":"100%","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3)","flexWrap":"wrap","background":"#fff","display":"flex"}'
             tab-position="left"
             @tab-click="handleClick">
      <el-tab-pane label="个人中心">
        <el-form ref="sessionForm" :model="sessionForm" :rules="rules" class="center-preview-pv" label-width="80px">
          <el-form-item v-if="userTableName=='yonghu'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="用户名" prop="yonghuming">
            <el-input v-model="sessionForm.yonghuming" placeholder="用户名" readonly></el-input>
          </el-form-item>
          <el-form-item v-if="userTableName=='yonghu'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="姓名" prop="xingming">
            <el-input v-model="sessionForm.xingming" placeholder="姓名"></el-input>
          </el-form-item>
          <el-form-item v-if="userTableName=='yonghu'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="性别" prop="xingbie">
            <el-select v-model="sessionForm.xingbie" placeholder="请选择性别">
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item"
                         :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item v-if="userTableName=='yonghu'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="头像" prop="touxiang">
            <file-upload
                :fileUrls="sessionForm.touxiang?sessionForm.touxiang:''"
                :limit="1"
                :multiple="true"
                action="file/upload"
                tip="点击上传头像"
                @change="yonghutouxiangHandleAvatarSuccess"
            ></file-upload>
          </el-form-item>
          <el-form-item v-if="userTableName=='yonghu'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="邮箱" prop="youxiang">
            <el-input v-model="sessionForm.youxiang" placeholder="邮箱"></el-input>
          </el-form-item>
          <el-form-item v-if="userTableName=='yonghu'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="手机" prop="shouji">
            <el-input v-model="sessionForm.shouji" placeholder="手机"></el-input>
          </el-form-item>
          <el-form-item v-if="userTableName=='yonghu'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}'
                        class="balance" label="余额">
            <div :style='{"flexWrap":"wrap","display":"flex"}'>
              <el-input v-model="sessionForm.money" placeholder="余额" readonly></el-input>
              <div :style='{"border":"0","cursor":"pointer","padding":"0 15px","margin":"0 0 0 10px","color":"rgba(255, 255, 255, 1)","display":"inline-block","outline":"none","borderRadius":"0","background":"#3B2E7E","width":"100px","lineHeight":"40px","fontSize":"14px","height":"40px"}'
                   @click="dialogFormVisibleMoney = true">
                点我充值
              </div>
            </div>
          </el-form-item>
          <el-form-item v-if="userTableName=='shangjia'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="账号" prop="dianpumingcheng">
            <el-input v-model="sessionForm.dianpumingcheng" placeholder="账号" readonly></el-input>
          </el-form-item>
          <el-form-item v-if="userTableName=='shangjia'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="负责人" prop="fuzeren">
            <el-input v-model="sessionForm.fuzeren" placeholder="负责人"></el-input>
          </el-form-item>
          <el-form-item v-if="userTableName=='shangjia'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="头像" prop="touxiang">
            <file-upload
                :fileUrls="sessionForm.touxiang?sessionForm.touxiang:''"
                :limit="1"
                :multiple="true"
                action="file/upload"
                tip="点击上传头像"
                @change="shangjiatouxiangHandleAvatarSuccess"
            ></file-upload>
          </el-form-item>
          <el-form-item v-if="userTableName=='shangjia'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="性别" prop="xingbie">
            <el-select v-model="sessionForm.xingbie" placeholder="请选择性别">
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item"
                         :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item v-if="userTableName=='shangjia'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="年龄" prop="nianling">
            <el-input v-model="sessionForm.nianling" placeholder="年龄"></el-input>
          </el-form-item>
          <el-form-item v-if="userTableName=='shangjia'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="联系电话" prop="lianxidianhua">
            <el-input v-model="sessionForm.lianxidianhua" placeholder="联系电话"></el-input>
          </el-form-item>
          <el-form-item v-if="userTableName=='shangjia'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}'
                        class="balance" label="余额">
            <div :style='{"flexWrap":"wrap","display":"flex"}'>
              <el-input v-model="sessionForm.money" placeholder="余额" readonly></el-input>
              <div :style='{"border":"0","cursor":"pointer","padding":"0 15px","margin":"0 0 0 10px","color":"rgba(255, 255, 255, 1)","display":"inline-block","outline":"none","borderRadius":"0","background":"#3B2E7E","width":"100px","lineHeight":"40px","fontSize":"14px","height":"40px"}'
                   @click="dialogFormVisibleMoney = true">
                点我充值
              </div>
            </div>
          </el-form-item>
          <el-form-item v-if="userTableName=='yishi'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="店铺名称" prop="dianpumingcheng">
            <el-input v-model="sessionForm.dianpumingcheng" placeholder="店铺名称"></el-input>
          </el-form-item>
          <el-form-item v-if="userTableName=='yishi'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="账号" prop="zhanghao">
            <el-input v-model="sessionForm.zhanghao" placeholder="账号" readonly></el-input>
          </el-form-item>
          <el-form-item v-if="userTableName=='yishi'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="姓名" prop="yishixingming">
            <el-input v-model="sessionForm.yishixingming" placeholder="姓名"></el-input>
          </el-form-item>
          <el-form-item v-if="userTableName=='yishi'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="性别" prop="xingbie">
            <el-select v-model="sessionForm.xingbie" placeholder="请选择性别">
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item"
                         :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item v-if="userTableName=='yishi'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="头像" prop="touxiang">
            <file-upload
                :fileUrls="sessionForm.touxiang?sessionForm.touxiang:''"
                :limit="1"
                :multiple="true"
                action="file/upload"
                tip="点击上传头像"
                @change="yishitouxiangHandleAvatarSuccess"
            ></file-upload>
          </el-form-item>
          <el-form-item v-if="userTableName=='yishi'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="年龄" prop="nianling">
            <el-input v-model="sessionForm.nianling" placeholder="年龄"></el-input>
          </el-form-item>
          <el-form-item v-if="userTableName=='yishi'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="职位" prop="zhiwei">
            <el-select v-model="sessionForm.zhiwei" placeholder="请选择职位">
              <el-option v-for="(item, index) in dynamicProp.zhiwei" :key="index" :label="item"
                         :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item v-if="userTableName=='yishi'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="电话" prop="dianhua">
            <el-input v-model="sessionForm.dianhua" placeholder="电话"></el-input>
          </el-form-item>
          <el-form-item v-if="userTableName=='yishi'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="邮箱" prop="youxiang">
            <el-input v-model="sessionForm.youxiang" placeholder="邮箱"></el-input>
          </el-form-item>
          <el-form-item v-if="userTableName=='yishi'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}'
                        class="balance" label="余额">
            <div :style='{"flexWrap":"wrap","display":"flex"}'>
              <el-input v-model="sessionForm.money" placeholder="余额" readonly></el-input>
              <div :style='{"border":"0","cursor":"pointer","padding":"0 15px","margin":"0 0 0 10px","color":"rgba(255, 255, 255, 1)","display":"inline-block","outline":"none","borderRadius":"0","background":"#3B2E7E","width":"100px","lineHeight":"40px","fontSize":"14px","height":"40px"}'
                   @click="dialogFormVisibleMoney = true">
                点我充值
              </div>
            </div>
          </el-form-item>
          <el-form-item v-if="userTableName=='yishi'"
                        :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="个人简介">
            <editor
                v-model="sessionForm.gerenjianjie"
                :style='{"border":"0","boxShadow":"none","outline":"none","color":"#333","borderRadius":"4px","width":"100%","lineHeight":"32px","fontSize":"14px"}'
                action="file/upload"
                class="editor">
            </editor>
          </el-form-item>
          <el-form-item :style='{"padding":"0","margin":"0"}'>
            <el-button
                :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#3B2E7E","width":"auto","lineHeight":"30px","fontSize":"14px","height":"30px"}'
                type="primary" @click="onSubmit('sessionForm')">更新信息
            </el-button>
            <el-button
                :style='{"border":"none","cursor":"pointer","padding":"0 10px","margin":"0","outline":"none","color":"#fff","borderRadius":"4px","background":"#9E9E9E","width":"auto","lineHeight":"30px","fontSize":"14px","height":"30px"}'
                type="danger" @click="logout">退出登录
            </el-button>
          </el-form-item>
        </el-form>
      </el-tab-pane>
      <el-tab-pane label="修改密码">
        <el-form ref="passwordForm" :model="passwordForm" :rules="passwordRules" class="center-preview-pv"
                 label-width="80px">
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="原密码"
                        prop="password">
            <el-input v-model="passwordForm.password" placeholder="原密码" type="password"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="新密码"
                        prop="newpassword">
            <el-input v-model="passwordForm.newpassword" placeholder="新密码" type="password"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none"}' label="确认密码"
                        prop="repassword">
            <el-input v-model="passwordForm.repassword" placeholder="确认密码" type="password"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"0","margin":"0"}'>
            <el-button
                :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#3B2E7E","width":"auto","lineHeight":"30px","fontSize":"14px","height":"30px"}'
                type="primary" @click="updatePassword">修改密码
            </el-button>
          </el-form-item>
        </el-form>
      </el-tab-pane>
      <el-tab-pane v-for="(item,index) in menuList" v-if="hasBack(item.menu)" :key="index" :label="item.child[0].menu"
                   :name="item.child[0].tableName"></el-tab-pane>
      <el-tab-pane label="我的订单"></el-tab-pane>
      <el-tab-pane label="我的地址" name="MyAddress">
        <router-view></router-view>
      </el-tab-pane>
      <el-tab-pane label="我的收藏"></el-tab-pane>
    </el-tabs>

    <el-dialog :visible.sync="dialogFormVisibleMoney" center title="用户充值" width="726px">
      <el-form :model="chongzhiForm">
        <el-form-item label="充值金额" label-width="120px">
          <el-input v-model="chongzhiForm.money" autocomplete="off" placeholder="充值金额" type="number"></el-input>
        </el-form-item>
        <el-form-item label-width="120px">
          <el-radio-group v-model="chongzhiForm.radio">
            <el-radio label="微信支付" style="margin-bottom: 30px">
              <el-image
                  :src="require('@/assets/weixin.png')"
                  fit="fill"
                  style="width: 60px; height: 60px;vertical-align: middle;"></el-image>
              <span style="display: inline-block;margin-left: 10px">微信支付</span>
            </el-radio>
            <el-radio label="支付宝支付">
              <el-image
                  :src="require('@/assets/zhifubao.png')"
                  fit="fill"
                  style="width: 60px; height: 60px;vertical-align: middle;"></el-image>
              <span style="display: inline-block;margin-left: 10px">支付宝支付</span>
            </el-radio>
            <el-radio label="中国建设银行支付">
              <el-image
                  :src="require('@/assets/jianshe.png')"
                  fit="fill"
                  style="width: 120px; height: 60px;vertical-align: middle;"></el-image>
            </el-radio>
            <el-radio label="中国农业银行支付">
              <el-image
                  :src="require('@/assets/nongye.png')"
                  fit="fill"
                  style="width: 126px; height: 60px;vertical-align: middle;"></el-image>
            </el-radio>
            <el-radio label="中国银行支付">
              <el-image
                  :src="require('@/assets/zhongguo.png')"
                  fit="fill"
                  style="width: 140px; height: 60px;vertical-align: middle;"></el-image>
            </el-radio>
            <el-radio label="交通银行支付">
              <el-image
                  :src="require('@/assets/jiaotong.png')"
                  fit="fill"
                  style="width: 120px; height: 60px;vertical-align: middle;"></el-image>
            </el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisibleMoney = false">取 消</el-button>
        <el-button type="primary" @click="chongzhi">确认充值</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import config from '@/config/config'
import menu from '@/config/menu'
import Vue from 'vue'

export default {
  //数据集合
  data() {
    return {
      title: '个人中心',
      baseUrl: config.baseUrl,
      sessionForm: {},
      passwordForm: {},
      passwordRules: {
        password: [
          {
            required: true,
            message: "密码不能为空",
            trigger: "blur"
          }
        ],
        newpassword: [
          {
            required: true,
            message: "新密码不能为空",
            trigger: "blur"
          }
        ],
        repassword: [
          {
            required: true,
            message: "确认密码不能为空",
            trigger: "blur"
          }
        ]
      },
      rules: {},
      chongzhiForm: {
        money: '',
        radio: ''
      },
      menuList: [],
      disabled: false,
      dialogFormVisibleMoney: false,
      uploadUrl: config.baseUrl + 'file/upload',
      imageUrl: '',
      headers: {Token: localStorage.getItem('frontToken')},
      userTableName: localStorage.getItem('UserTableName'),
      dynamicProp: {},
    }
  },
  created() {
    let menus = menu.list()
    for (let x in menus) {
      if (menus[x].tableName == this.userTableName) {
        this.menuList = menus[x].backMenu
      }
    }
    if ('yonghu' == this.userTableName) {
      this.$set(this.sessionForm, 'yonghuming', null);
    }
    if ('yonghu' == this.userTableName) {
      this.$set(this.sessionForm, 'mima', null);
    }
    if ('yonghu' == this.userTableName) {
      this.$set(this.sessionForm, 'xingming', null);
    }
    if ('yonghu' == this.userTableName) {
      this.$set(this.sessionForm, 'xingbie', null);
    }
    if ('yonghu' == this.userTableName) {
      this.$set(this.sessionForm, 'touxiang', null);
    }
    if ('yonghu' == this.userTableName) {
      this.$set(this.sessionForm, 'youxiang', null);
    }
    if ('yonghu' == this.userTableName) {
      this.$set(this.sessionForm, 'shouji', null);
    }
    if ('yonghu' == this.userTableName) {
      this.$set(this.sessionForm, 'money', null);
    }
    if ('yonghu' == this.userTableName) {
      this.$set(this.sessionForm, 'status', null);
    }
    if ('shangjia' == this.userTableName) {
      this.$set(this.sessionForm, 'dianpumingcheng', null);
    }
    if ('shangjia' == this.userTableName) {
      this.$set(this.sessionForm, 'mima', null);
    }
    if ('shangjia' == this.userTableName) {
      this.$set(this.sessionForm, 'fuzeren', null);
    }
    if ('shangjia' == this.userTableName) {
      this.$set(this.sessionForm, 'touxiang', null);
    }
    if ('shangjia' == this.userTableName) {
      this.$set(this.sessionForm, 'xingbie', null);
    }
    if ('shangjia' == this.userTableName) {
      this.$set(this.sessionForm, 'nianling', null);
    }
    if ('shangjia' == this.userTableName) {
      this.$set(this.sessionForm, 'lianxidianhua', null);
    }
    if ('shangjia' == this.userTableName) {
      this.$set(this.sessionForm, 'money', null);
    }
    if ('shangjia' == this.userTableName) {
      this.$set(this.sessionForm, 'status', null);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.sessionForm, 'dianpumingcheng', null);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.sessionForm, 'zhanghao', null);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.sessionForm, 'yishixingming', null);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.sessionForm, 'mima', null);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.sessionForm, 'xingbie', null);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.sessionForm, 'touxiang', null);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.sessionForm, 'nianling', null);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.sessionForm, 'zhiwei', null);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.sessionForm, 'dianhua', null);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.sessionForm, 'youxiang', null);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.sessionForm, 'gerenjianjie', null);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.sessionForm, 'clicktime', null);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.sessionForm, 'clicknum', null);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.sessionForm, 'discussnum', null);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.sessionForm, 'userid', null);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.sessionForm, 'storeupnum', null);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.sessionForm, 'longitude', null);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.sessionForm, 'latitude', null);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.sessionForm, 'fulladdress', null);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.sessionForm, 'money', null);
    }

    if ('yonghu' == this.userTableName && this.rules['yonghuming']) {
      this.rules['yonghuming'].push({required: true, message: '请输入用户名', trigger: 'blur'})
    }
    else if ('yonghu' == this.userTableName && !this.rules['yonghuming']) {
      this.$set(this.rules, 'yonghuming', [{required: true, message: '请输入用户名', trigger: 'blur'}]);
    }
    if ('yonghu' == this.userTableName && this.rules['mima']) {
      this.rules['mima'].push({required: true, message: '请输入密码', trigger: 'blur'})
    }
    else if ('yonghu' == this.userTableName && !this.rules['mima']) {
      this.$set(this.rules, 'mima', [{required: true, message: '请输入密码', trigger: 'blur'}]);
    }
    if ('yonghu' == this.userTableName) {
      this.$set(this.rules, 'youxiang', [{required: false, validator: this.$validate.isEmail, trigger: 'blur'}]);
    }
    if ('yonghu' == this.userTableName) {
      this.$set(this.rules, 'shouji', [{required: false, validator: this.$validate.isMobile, trigger: 'blur'}]);
    }
    if ('yonghu' == this.userTableName) {
      this.$set(this.rules, 'money', [{required: false, validator: this.$validate.isNumber, trigger: 'blur'}]);
    }
    if ('yonghu' == this.userTableName) {
      this.$set(this.rules, 'status', [{required: false, validator: this.$validate.isIntNumer, trigger: 'blur'}]);
    }
    if ('shangjia' == this.userTableName && this.rules['dianpumingcheng']) {
      this.rules['dianpumingcheng'].push({required: true, message: '请输入账号', trigger: 'blur'})
    }
    else if ('shangjia' == this.userTableName && !this.rules['dianpumingcheng']) {
      this.$set(this.rules, 'dianpumingcheng', [{required: true, message: '请输入账号', trigger: 'blur'}]);
    }
    if ('shangjia' == this.userTableName && this.rules['mima']) {
      this.rules['mima'].push({required: true, message: '请输入密码', trigger: 'blur'})
    }
    else if ('shangjia' == this.userTableName && !this.rules['mima']) {
      this.$set(this.rules, 'mima', [{required: true, message: '请输入密码', trigger: 'blur'}]);
    }
    if ('shangjia' == this.userTableName && this.rules['fuzeren']) {
      this.rules['fuzeren'].push({required: true, message: '请输入负责人', trigger: 'blur'})
    }
    else if ('shangjia' == this.userTableName && !this.rules['fuzeren']) {
      this.$set(this.rules, 'fuzeren', [{required: true, message: '请输入负责人', trigger: 'blur'}]);
    }
    if ('shangjia' == this.userTableName) {
      this.$set(this.rules, 'lianxidianhua', [{required: false, validator: this.$validate.isMobile, trigger: 'blur'}]);
    }
    if ('shangjia' == this.userTableName) {
      this.$set(this.rules, 'money', [{required: false, validator: this.$validate.isNumber, trigger: 'blur'}]);
    }
    if ('shangjia' == this.userTableName) {
      this.$set(this.rules, 'status', [{required: false, validator: this.$validate.isIntNumer, trigger: 'blur'}]);
    }
    if ('yishi' == this.userTableName && this.rules['zhanghao']) {
      this.rules['zhanghao'].push({required: true, message: '请输入账号', trigger: 'blur'})
    }
    else if ('yishi' == this.userTableName && !this.rules['zhanghao']) {
      this.$set(this.rules, 'zhanghao', [{required: true, message: '请输入账号', trigger: 'blur'}]);
    }
    if ('yishi' == this.userTableName && this.rules['yishixingming']) {
      this.rules['yishixingming'].push({required: true, message: '请输入姓名', trigger: 'blur'})
    }
    else if ('yishi' == this.userTableName && !this.rules['yishixingming']) {
      this.$set(this.rules, 'yishixingming', [{required: true, message: '请输入姓名', trigger: 'blur'}]);
    }
    if ('yishi' == this.userTableName && this.rules['mima']) {
      this.rules['mima'].push({required: true, message: '请输入密码', trigger: 'blur'})
    }
    else if ('yishi' == this.userTableName && !this.rules['mima']) {
      this.$set(this.rules, 'mima', [{required: true, message: '请输入密码', trigger: 'blur'}]);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.rules, 'nianling', [{required: false, validator: this.$validate.isIntNumer, trigger: 'blur'}]);
    }
    if ('yishi' == this.userTableName && this.rules['zhiwei']) {
      this.rules['zhiwei'].push({required: true, message: '请输入职位', trigger: 'blur'})
    }
    else if ('yishi' == this.userTableName && !this.rules['zhiwei']) {
      this.$set(this.rules, 'zhiwei', [{required: true, message: '请输入职位', trigger: 'blur'}]);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.rules, 'dianhua', [{required: false, validator: this.$validate.isMobile, trigger: 'blur'}]);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.rules, 'youxiang', [{required: false, validator: this.$validate.isEmail, trigger: 'blur'}]);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.rules, 'clicknum', [{required: false, validator: this.$validate.isIntNumer, trigger: 'blur'}]);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.rules, 'discussnum', [{required: false, validator: this.$validate.isIntNumer, trigger: 'blur'}]);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.rules, 'storeupnum', [{required: false, validator: this.$validate.isIntNumer, trigger: 'blur'}]);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.rules, 'longitude', [{required: false, validator: this.$validate.isNumber, trigger: 'blur'}]);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.rules, 'latitude', [{required: false, validator: this.$validate.isNumber, trigger: 'blur'}]);
    }
    if ('yishi' == this.userTableName) {
      this.$set(this.rules, 'money', [{required: false, validator: this.$validate.isNumber, trigger: 'blur'}]);
    }

    this.init();
    this.sessionForm = JSON.parse(localStorage.getItem('sessionForm'))
  },
  //方法集合
  methods: {
    init() {
      if ('yonghu' == this.userTableName) {
        this.dynamicProp.xingbie = '男,女'.split(',');
      }
      if ('shangjia' == this.userTableName) {
        this.dynamicProp.xingbie = '男,女'.split(',');
      }
      if ('yishi' == this.userTableName) {
        this.dynamicProp.xingbie = '男,女'.split(',');
      }
      if ('yishi' == this.userTableName) {
        this.dynamicProp.zhiwei = '宠物医生,美容技师'.split(',');
      }
    },
    setSession() {
      localStorage.setItem('sessionForm', JSON.stringify(this.sessionForm))
    },
    onSubmit(formName) {
      if (`yonghu` == this.userTableName && this.sessionForm.touxiang != null) {
        this.sessionForm.touxiang = this.sessionForm.touxiang.replace(new RegExp(this.$config.baseUrl, "g"), "");
      }
      if (`shangjia` == this.userTableName && this.sessionForm.touxiang != null) {
        this.sessionForm.touxiang = this.sessionForm.touxiang.replace(new RegExp(this.$config.baseUrl, "g"), "");
      }
      if (`yishi` == this.userTableName && this.sessionForm.touxiang != null) {
        this.sessionForm.touxiang = this.sessionForm.touxiang.replace(new RegExp(this.$config.baseUrl, "g"), "");
      }
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
            if (res.data.code == 0) {
              this.setSession()
              this.$message({
                message: '更新成功',
                type: 'success',
                duration: 1500
              });
            }
          });
        }
        else {
          return false;
        }
      });
    },
    yonghutouxiangHandleAvatarSuccess(fileUrls) {
      this.sessionForm.touxiang = fileUrls;
    },
    shangjiatouxiangHandleAvatarSuccess(fileUrls) {
      this.sessionForm.touxiang = fileUrls;
    },
    yishitouxiangHandleAvatarSuccess(fileUrls) {
      this.sessionForm.touxiang = fileUrls;
    },
    chongzhi() {
      if (this.chongzhiForm.money == '') {
        this.$message({
          message: '请输入充值金额',
          type: 'error',
          duration: 1500
        });
        return;
      }
      if (this.chongzhiForm.money <= 0) {
        this.$message({
          message: '请输入正确的充值金额',
          type: 'error',
          duration: 1500
        });
        return;
      }
      if (this.chongzhiForm.radio == '') {
        this.$message({
          message: '请选择充值方式',
          type: 'error',
          duration: 1500
        });
        return;
      }
      if (!this.sessionForm.money) {
        this.sessionForm.money = parseFloat(this.chongzhiForm.money)
      }
      else {
        this.sessionForm.money = parseFloat(this.sessionForm.money) + parseFloat(this.chongzhiForm.money);
      }

      this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
        if (res.data.code == 0) {
          this.setSession()
          this.$message({
            message: '充值成功',
            type: 'success',
            duration: 1500,
          });
          this.dialogFormVisibleMoney = false;
        }
      });
    },
    handleClick(tab, event) {
      switch (event.target.outerText) {
        case '个人中心':
          tab.$router.push('/index/center');
          break;
        case '修改密码':
          this.passwordForm = {
            password: '',
            newpassword: '',
            repassword: '',
          }
          this.$forceUpdate()
          break;
        case '我的订单':
          tab.$router.push('/index/shop-order/order');
          break;
        case '我的地址':
          tab.$router.push('/index/shop-address/list');
          break;
        case '我的收藏':
          localStorage.setItem('storeupType', 1);
          tab.$router.push('/index/storeup');
          break;
        default:
          tab.$router.push(`/index/${tab.name}?centerType=1`);
      }

      this.title = event.target.outerText;
    },
    async updatePassword() {
      this.$refs["passwordForm"].validate(async valid => {
        if (valid) {
          var password = "";
          if (this.sessionForm.mima) {
            password = this.sessionForm.mima;
          }
          else if (this.sessionForm.password) {
            password = this.sessionForm.password;
          }
          if (this.passwordForm.password != password) {
            this.$message.error("原密码错误");
            return;
          }
          if (this.passwordForm.newpassword != this.passwordForm.repassword) {
            this.$message.error("两次密码输入不一致");
            return;
          }
          if (this.passwordForm.newpassword == this.passwordForm.password) {
            this.$message.error("新密码与原密码相同！");
            return;
          }
          if (this.userTableName == 'yonghu') {
          }
          this.sessionForm.password = this.passwordForm.newpassword;
          this.sessionForm.mima = this.passwordForm.newpassword;
          this.$http.post(`${this.userTableName}/update`, this.sessionForm).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: "修改密码成功,下次登录系统生效",
                type: "success",
                duration: 1500,
                onClose: () => {
                }
              });
              this.setSession()
            }
            else {
              this.$message.error(data.msg);
            }
          });
        }
      })
    },
    logout() {
      localStorage.clear();
      Vue.http.headers.common['Token'] = "";
      this.$router.push('/index/home');
      this.activeIndex = '0'
      localStorage.setItem('keyPath', this.activeIndex)
      this.$forceUpdate()
      this.$message({
        message: '登出成功',
        type: 'success',
        duration: 1500,
      });
    },
    hasBack(name) {
      switch (name) {
        case '订单管理':
          return false
          break;
        case '我的收藏管理':
          return false
          break;
        default:
          return true
      }
    }
  }
}
</script>

<style lang="scss" rel="stylesheet/scss" scoped>
.center-preview {

  .el-tabs {
    & /deep/ .el-tabs__header {
      .el-tabs__nav {
        overflow: auto;
      }

      ::-webkit-scrollbar {
        -webkit-appearance: none;
        width: 6px;
        height: 6px;
      }

      ::-webkit-scrollbar-track {
        background: rgba(0, 0, 0, 0.1);
        border-radius: 0;
      }

      ::-webkit-scrollbar-thumb {
        cursor: pointer;
        border-radius: 5px;
        background: rgba(0, 0, 0, 0.15);
        transition: color 0.2s ease;
      }

      ::-webkit-scrollbar-thumb:hover {
        background: rgba(0, 0, 0, 0.3);
      }

      .el-tabs__nav-wrap {
        margin: 0;

        &::after {
          content: none;
        }
      }

      .el-tabs__active-bar {
        display: none !important;
      }
    }

    .center-preview-pv {
      .el-date-editor.el-input {
        width: auto;
      }

      .balance {
        .el-input {
          width: auto;
        }
      }
    }
  }
}

.center-preview .el-tabs /deep/ .el-tabs__header {
  padding: 0 40px;
  margin: 0;
  background: none;
  width: 100%;
  border-color: #eee;
  border-width: 0 1px 0 0;
  position: relative;
  float: left;
  border-style: solid;
}

.center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item {
  border: 1px solid #fff;
  padding: 0 0;
  margin: 0 20px;
  color: #000;
  font-weight: 500;
  display: inline-block;
  font-size: 16px;
  line-height: 80px;
  background: none;
  border-width: 0 0 4px;
  position: relative;
  text-align: center;
  height: 80px;
}

.center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
  border: 1px solid #3B2E7E;
  padding: 0 0;
  margin: 0 20px;
  color: #3B2E7E;
  font-weight: 500;
  display: inline-block;
  font-size: 16px;
  line-height: 80px;
  background: none;
  border-width: 0 0 4px;
  position: relative;
  text-align: center;
  height: 80px;
}

.center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
  border: 1px solid #3B2E7E;
  padding: 0 0;
  margin: 0 20px;
  color: #3B2E7E;
  font-weight: 500;
  display: inline-block;
  font-size: 16px;
  line-height: 80px;
  background: none;
  border-width: 0 0 4px;
  position: relative;
  text-align: center;
  height: 80px;
}

.center-preview .el-tabs /deep/ .el-tabs__content {
  padding: 10px 20px;
  background: #fff;
  display: block;
  width: 100%;
  flex-wrap: wrap;
}

.center-preview .el-tabs /deep/ .el-tabs__content .el-tab-pane {
  width: 100%;
}

.center-preview-pv .el-form-item /deep/ .el-form-item__label {
  padding: 0 10px 0 0;
  color: #000;
  font-weight: 500;
  width: 80px;
  font-size: 14px;
  line-height: 40px;
  text-align: right;
}

.center-preview-pv .el-form-item .el-form-item__content {
  margin-left: 80px;
}

.center-preview-pv .el-input /deep/ .el-input__inner {
  border: 1px solid #DADADA;
  border-radius: 0;
  padding: 0 12px;
  box-shadow: none;
  outline: none;
  color: #000;
  width: 500px;
  font-size: 14px;
  height: 40px;
}

.center-preview-pv .el-select /deep/ .el-input__inner {
  border: 1px solid #DADADA;
  border-radius: 0;
  padding: 0 12px;
  box-shadow: none;
  outline: none;
  color: #000;
  width: 500px;
  font-size: 14px;
  height: 40px;
}

.center-preview-pv .el-date-editor /deep/ .el-input__inner {
  border: 1px solid #DADADA;
  border-radius: 0;
  padding: 0 10px 0 30px;
  box-shadow: none;
  outline: none;
  color: #000;
  width: 500px;
  font-size: 14px;
  height: 40px;
}

.center-preview-pv /deep/ .avatar-uploader-icon {
  border: 1px solid #DADADA;
  cursor: pointer;
  border-radius: 6px;
  color: #DADADA;
  width: 200px;
  font-size: 32px;
  line-height: 60px;
  text-align: center;
  height: 60px;
}

.center-preview-pv .el-form-item.balance /deep/ .el-input__inner {
  border: 1px solid #DADADA;
  border-radius: 0;
  padding: 0 12px;
  box-shadow: none;
  outline: none;
  color: #000;
  display: inline-block;
  width: 390px;
  font-size: 14px;
  height: 40px;
}
</style>
