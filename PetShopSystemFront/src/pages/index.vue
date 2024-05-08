<template>
  <div class="main-containers">
    <div :style='{"minHeight":"100vh","padding":"80px 0 0","margin":"0","background":"url(http://codegen.caihongy.cn/20231212/7d61a2acf8be4ef6bfc300355bcd9825.png)","backgroundSize":"cover","position":"relative","backgroundPosition":"center center","backgroundRepeat":"no-repeat"}'
         class="body-containers">
      <div :style='{"boxShadow":"none","padding":"0 80px","alignItems":"flex-start","display":"flex","justifyContent":"flex-end","top":"0","left":"0","flexWrap":"wrap","background":"#ffffff","width":"100%","position":"absolute","height":"80px","zIndex":"1002"}'
           class="top-container">
        <!-- info -->
        <div :style='{"display":"block"}'>
          <span :style='{"padding":"0 0 0 12px","color":"#000","left":"20px","lineHeight":"80px","fontSize":"26px","position":"absolute","float":"left","fontWeight":"bold"}'
                @click="goMenu('/index/home')">安信宠物医疗美容系统</span>
        </div>

        <div v-if="false" :style='{"color":"#666","margin":"0 10px","fontSize":"14px"}'>0753-1234567</div>
        <el-button v-if="Token" class="btn-shop" @click.native="goMenu('/index/cart')">
          <span :style='{"color":"inherit","fontSize":"inherit"}' class="icon iconfont icon-wuliu8"></span>
          购物车
        </el-button>

        <img v-if="headportrait&&Token"
             :src="headportrait?baseUrl + headportrait:require('@/assets/avator.png')"
             :style='{"width":"50px","margin":"15px 12px","borderRadius":"10px","height":"50px"}'>
        <div v-if="Token"
             :style='{"padding":"0 12px","fontSize":"15px","lineHeight":"80px","color":"#000","fontWeight":"bold","height":"80px"}'>
          {{ username }}
        </div>
        <div v-if="Token && notAdmin"
             :style='{"cursor":"pointer","padding":"0 12px","color":"#000","fontSize":"15px","lineHeight":"80px","fontWeight":"bold","height":"80px"}'
             @click="goMenu('/index/center')">个人中心
        </div>
        <el-button v-if="!Token" :style='{"border":"none","padding":"0 12px","margin":"0 10px","color":"#000","borderRadius":"2px","background":"none","display":"inline-block","fontSize":"15px","lineHeight":"80px","right":"40px","fontWeight":"bold","height":"80px"}'
                   @click="toLogin()">
          登录/注册
        </el-button>
        <el-button v-if="Token" :style='{"border":"none","padding":"0 12px","margin":"0 10px","color":"#000","borderRadius":"0","background":"none","display":"inline-block","fontSize":"15px","lineHeight":"80px","right":"40px","fontWeight":"bold","height":"80px"}'
                   @click="logout">
          退出
        </el-button>
      </div>


      <div style="display: flex;justify-content: center">
      <div :style='{"borderColor":"#efefef","top":"510px","margin":"auto","background":"#ffffff","borderWidth":"0","position":"absolute","borderStyle":"solid","height":"auto","zIndex":"1003"}'
           class="menu-preview">
        <el-scrollbar wrap-class="scrollbar-wrapper-horizontal">
          <el-menu :default-active="activeMenu"
                   :router="true"
                   :style='{"border":0,"padding":"0px 0","listStyle":"none","margin":"0 0 0 auto","background":"#FFF","display":"flex","position":"relative","justifyContent":"center"}' :unique-opened="true" class="el-menu-horizontal-demo" mode="horizontal"
                   @select="handleSelect">
            <div :style='{"width":"84px","padding":"6px 10px 0","display":"none","height":"auto"}' class="userinfo">
              <el-image v-if="headportrait&&Token"
                        :src="headportrait?baseUrl + headportrait:require('@/assets/avator.png')"
                        :style='{"width":"100%","objectFit":"cover","borderRadius":"20px","display":"block","height":"32px"}'
                        fit="cover"></el-image>
              <div :style='{"fontSize":"12px","lineHeight":"1.5","color":"#333","textAlign":"center"}'>{{ username }}
              </div>
            </div>
            <el-menu-item class="home" index="/index/home" @click.native="goMenu('/index/home')">
              <span
                  :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"56px","fontSize":"inherit","height":"56px"}'
                  class="icon iconfont icon-shouye-zhihui"></span>
              <span
                  :style='{"padding":"0 10px","lineHeight":"56px","fontSize":"inherit","color":"inherit","height":"56px"}'>系统首页</span>
            </el-menu-item>
            <el-menu-item v-for="(menu, index) in menuList" :key="index" :index="menu.url" class="item"
                          @click.native="goMenu(menu.url)">
              <i :class="iconArr[index]"
                 :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"56px","fontSize":"inherit","height":"56px"}'></i>
              <span
                  :style='{"padding":"0 10px","lineHeight":"56px","fontSize":"inherit","color":"inherit","height":"56px"}'>{{ menu.name }}</span>
            </el-menu-item>
            <el-menu-item v-if="Token" class="shop" index="/index/cart" @click.native="goMenu('/index/cart')">
              <span
                  :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"56px","fontSize":"14px","height":"56px"}'
                  class="icon iconfont icon-wuliu8"></span>
              <span
                  :style='{"padding":"0 10px","lineHeight":"56px","fontSize":"14px","color":"inherit","height":"56px"}'>购物车</span>
            </el-menu-item>
            <el-menu-item v-if="Token && notAdmin" class="user" index="/index/center"
                          @click.native="goMenu('/index/center')">
              <span
                  :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"56px","fontSize":"14px","height":"56px"}'
                  class="icon iconfont icon-shouye-zhihui"></span>
              <span
                  :style='{"padding":"0 10px","lineHeight":"56px","fontSize":"16px","color":"inherit","height":"56px"}'>个人中心</span>
            </el-menu-item>
          </el-menu>
        </el-scrollbar>
      </div>
      </div>

      <div :style='{"width":"calc(100% - 70px)","margin":"0 auto","background":"#fff","height":"auto"}'>
        <div :style='{"width":"100%","height":"auto"}' class="swiper21">
          <div class="swiper-container mySwiper21">
            <div class="swiper-wrapper">
              <div v-for="item in carouselList" :key="item.id" class="swiper-slide">
                <div :style='{"width":"100%","height":"auto"}'>
                  <el-image v-if="preHttp(item.value)" :src="item.value"
                            :style='{"objectFit":"cover","width":"100%","height":"500px"}' fit="cover"
                            @click="carouselClick(item.url)"></el-image>
                  <el-image v-else :src="baseUrl + item.value"
                            :style='{"objectFit":"cover","width":"100%","height":"500px"}' fit="cover"
                            @click="carouselClick(item.url)"></el-image>
                </div>
              </div>
            </div>
            <div :style='{"width":"24px","margin":"-12px 0 0","top":"50%","height":"24px"}' class="swiper-button-prev">
              <span :style='{"width":"24px","fontSize":"24px","color":"#fff","height":"24px"}'
                    class="icon iconfont icon-jiantou39"></span>
            </div>
            <div :style='{"width":"24px","margin":"-12px 0 0","top":"50%","height":"24px"}' class="swiper-button-next">
              <span :style='{"width":"24px","fontSize":"24px","color":"#fff","height":"24px"}'
                    class="icon iconfont icon-jiantou18"></span>
            </div>
          </div>
        </div>
        <div :style='{"width":"100%","margin":"10px 0 0","height":"auto"}' class="swiper22">
          <div class="swiper-container mySwiper22">
            <div class="swiper-wrapper">
              <!--<div v-for="item in carouselList" :key="item.id" class="swiper-slide">-->
              <!--  <div>-->
              <!--    <el-image v-if="preHttp(item.value)" :src="item.value"-->
              <!--              :style='{"objectFit":"cover","width":"100%","height":"100px"}' fit="cover"></el-image>-->
              <!--    <el-image v-else :src="baseUrl + item.value"-->
              <!--              :style='{"objectFit":"cover","width":"100%","height":"100px"}' fit="cover"></el-image>-->
              <!--  </div>-->
              <!--</div>-->
            </div>
            <div :style='{"width":"14px","margin":"-7px 0 0","top":"50%","height":"14px"}' class="swiper-button-prev">
              <span :style='{"width":"14px","fontSize":"14px","color":"#fff","height":"14px"}'
                    class="icon iconfont icon-jiantou33"></span>
            </div>
            <div :style='{"width":"14px","margin":"-7px 0 0","top":"50%","height":"14px"}' class="swiper-button-next">
              <span :style='{"width":"14px","fontSize":"14px","color":"#fff","height":"14px"}'
                    class="icon iconfont icon-jiantou34"></span>
            </div>
          </div>
        </div>
      </div>

      <router-view id="scrollView"></router-view>

      <div :style='{"width":"100%","height":"auto"}' class="bottom-preview">
        <div
            :style='{"minHeight":"150px","padding":"20px","overflow":"hidden","color":"#fff","background":"#000","width":"100%","height":"auto"}'>
          <div v-html="bottomContent"></div>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import Vue from 'vue'
import Swiper from "swiper";

export default {
  data() {
    return {
      activeIndex: '0',
      roleMenus: [{
        "backMenu": [{
          "child": [{
            "allButtons": ["新增", "查看", "修改", "删除"],
            "appFrontIcon": "cuIcon-goodsnew",
            "buttons": ["新增", "查看", "修改", "删除"],
            "menu": "用户",
            "menuJump": "列表",
            "tableName": "yonghu"
          }], "menu": "用户管理"
        }, {
          "child": [{
            "allButtons": ["新增", "查看", "修改", "删除"],
            "appFrontIcon": "cuIcon-camera",
            "buttons": ["新增", "查看", "修改", "删除", "排班"],
            "menu": "商家",
            "menuJump": "列表",
            "tableName": "shangjia"
          }], "menu": "商家管理"
        }, {
          "child": [{
            "allButtons": ["新增", "查看", "修改", "删除", "查看评论", "问诊", "预约"],
            "appFrontIcon": "cuIcon-list",
            "buttons": ["查看", "修改", "删除", "查看评论", "新增"],
            "menu": "医师",
            "menuJump": "列表",
            "tableName": "yishi"
          }], "menu": "医师管理"
        }, {
          "child": [{
            "allButtons": ["新增", "查看", "修改", "删除", "审核"],
            "appFrontIcon": "cuIcon-vipcard",
            "buttons": ["查看", "修改", "删除"],
            "menu": "在线问诊",
            "menuJump": "列表",
            "tableName": "zaixianwenzhen"
          }], "menu": "在线问诊管理"
        }, {
          "child": [{
            "allButtons": ["新增", "查看", "修改", "删除", "审核"],
            "appFrontIcon": "cuIcon-clothes",
            "buttons": ["查看", "修改", "删除"],
            "menu": "在线预约",
            "menuJump": "列表",
            "tableName": "zaixianyuyue"
          }], "menu": "在线预约管理"
        }, {
          "child": [{
            "allButtons": ["新增", "查看", "修改", "删除"],
            "appFrontIcon": "cuIcon-full",
            "buttons": ["新增", "查看", "修改", "删除"],
            "menu": "商品分类",
            "menuJump": "列表",
            "tableName": "shangpinfenlei"
          }], "menu": "商品分类管理"
        }, {
          "child": [{
            "allButtons": ["新增", "查看", "修改", "删除", "查看评论"],
            "appFrontIcon": "cuIcon-circle",
            "buttons": ["查看", "修改", "删除", "查看评论"],
            "menu": "商品信息",
            "menuJump": "列表",
            "tableName": "shangpinxinxi"
          }], "menu": "商品信息管理"
        }, {
          "child": [{
            "allButtons": ["新增", "查看", "修改", "删除"],
            "appFrontIcon": "cuIcon-circle",
            "buttons": ["查看", "修改"],
            "menu": "轮播图管理",
            "tableName": "config"
          }, {
            "allButtons": ["新增", "查看", "修改", "删除"],
            "appFrontIcon": "cuIcon-vipcard",
            "buttons": ["新增", "查看", "修改", "删除"],
            "menu": "新闻资讯",
            "tableName": "news"
          }, {
            "allButtons": ["新增", "查看", "修改", "删除"],
            "appFrontIcon": "cuIcon-skin",
            "buttons": ["新增", "查看", "修改", "删除"],
            "menu": "资讯分类",
            "tableName": "newstype"
          }, {
            "allButtons": ["查看", "修改"],
            "appFrontIcon": "cuIcon-rank",
            "buttons": ["查看", "修改"],
            "menu": "系统简介",
            "tableName": "systemintro"
          }, {
            "allButtons": ["新增", "查看", "修改", "删除"],
            "appFrontIcon": "cuIcon-keyboard",
            "buttons": ["新增", "查看", "修改", "删除"],
            "menu": "友情链接",
            "tableName": "friendlink"
          }], "menu": "系统管理"
        }, {
          "child": [{
            "allButtons": ["新增", "查看", "修改", "删除", "导出", "日销量", "月销量", "年销量", "品销量", "类销量", "日销额", "月销额", "年销额", "品销额", "类销额", "物流", "退货审核"],
            "appFrontIcon": "cuIcon-explore",
            "buttons": ["查看", "修改", "删除"],
            "menu": "已完成订单",
            "tableName": "orders/已完成"
          }, {
            "allButtons": ["新增", "查看", "修改", "删除", "导出", "日销量", "月销量", "年销量", "品销量", "类销量", "日销额", "月销额", "年销额", "品销额", "类销额"],
            "appFrontIcon": "cuIcon-wenzi",
            "buttons": ["查看", "修改", "删除"],
            "menu": "已取消订单",
            "tableName": "orders/已取消"
          }, {
            "allButtons": ["新增", "查看", "修改", "删除", "导出", "日销量", "月销量", "年销量", "品销量", "类销量", "日销额", "月销额", "年销额", "品销额", "类销额", "物流"],
            "appFrontIcon": "cuIcon-keyboard",
            "buttons": ["查看", "修改", "删除"],
            "menu": "已退款订单",
            "tableName": "orders/已退款"
          }, {
            "allButtons": ["新增", "查看", "修改", "删除", "导出", "日销量", "月销量", "年销量", "品销量", "类销量", "日销额", "月销额", "年销额", "品销额", "类销额", "确认收货", "物流"],
            "appFrontIcon": "cuIcon-brand",
            "buttons": ["查看", "修改", "删除"],
            "menu": "已发货订单",
            "tableName": "orders/已发货"
          }, {
            "allButtons": ["新增", "查看", "修改", "删除", "导出", "日销量", "月销量", "年销量", "品销量", "类销量", "日销额", "月销额", "年销额", "品销额", "类销额"],
            "appFrontIcon": "cuIcon-camera",
            "buttons": ["查看", "删除", "修改"],
            "menu": "未支付订单",
            "tableName": "orders/未支付"
          }, {
            "allButtons": ["新增", "查看", "修改", "删除", "导出", "日销量", "月销量", "年销量", "品销量", "类销量", "日销额", "月销额", "年销额", "品销额", "类销额", "发货", "物流", "核销"],
            "appFrontIcon": "cuIcon-send",
            "buttons": ["查看", "修改", "删除"],
            "menu": "已支付订单",
            "tableName": "orders/已支付"
          }], "menu": "订单管理"
        }],
        "frontMenu": [{
          "child": [{
            "allButtons": ["新增", "查看", "修改", "删除", "查看评论", "问诊", "预约"],
            "appFrontIcon": "cuIcon-pic",
            "buttons": ["查看", "问诊", "预约"],
            "menu": "医师列表",
            "menuJump": "列表",
            "tableName": "yishi"
          }], "menu": "医师模块"
        }, {
          "child": [{
            "allButtons": ["新增", "查看", "修改", "删除", "查看评论"],
            "appFrontIcon": "cuIcon-flashlightopen",
            "buttons": ["查看"],
            "menu": "商品信息列表",
            "menuJump": "列表",
            "tableName": "shangpinxinxi"
          }], "menu": "商品信息模块"
        }],
        "hasBackLogin": "是",
        "hasBackRegister": "否",
        "hasFrontLogin": "否",
        "hasFrontRegister": "否",
        "roleName": "管理员",
        "tableName": "users"
      }, {
        "backMenu": [{
          "child": [{
            "allButtons": ["新增", "查看", "修改", "删除", "审核"],
            "appFrontIcon": "cuIcon-vipcard",
            "buttons": ["查看", "删除"],
            "menu": "在线问诊",
            "menuJump": "列表",
            "tableName": "zaixianwenzhen"
          }], "menu": "在线问诊管理"
        }, {
          "child": [{
            "allButtons": ["新增", "查看", "修改", "删除", "审核"],
            "appFrontIcon": "cuIcon-clothes",
            "buttons": ["查看", "删除"],
            "menu": "在线预约",
            "menuJump": "列表",
            "tableName": "zaixianyuyue"
          }], "menu": "在线预约管理"
        }],
        "frontMenu": [{
          "child": [{
            "allButtons": ["新增", "查看", "修改", "删除", "查看评论", "问诊", "预约"],
            "appFrontIcon": "cuIcon-pic",
            "buttons": ["查看", "问诊", "预约"],
            "menu": "医师列表",
            "menuJump": "列表",
            "tableName": "yishi"
          }], "menu": "医师模块"
        }, {
          "child": [{
            "allButtons": ["新增", "查看", "修改", "删除", "查看评论"],
            "appFrontIcon": "cuIcon-flashlightopen",
            "buttons": ["查看"],
            "menu": "商品信息列表",
            "menuJump": "列表",
            "tableName": "shangpinxinxi"
          }], "menu": "商品信息模块"
        }],
        "hasBackLogin": "否",
        "hasBackRegister": "否",
        "hasFrontLogin": "是",
        "hasFrontRegister": "是",
        "roleName": "用户",
        "tableName": "yonghu"
      }, {
        "backMenu": [{
          "child": [{
            "allButtons": ["新增", "查看", "修改", "删除", "查看评论", "问诊", "预约"],
            "appFrontIcon": "cuIcon-list",
            "buttons": ["新增", "查看", "修改", "删除", "查看评论"],
            "menu": "医师",
            "menuJump": "列表",
            "tableName": "yishi"
          }], "menu": "医师管理"
        }, {
          "child": [{
            "allButtons": ["新增", "查看", "修改", "删除", "查看评论"],
            "appFrontIcon": "cuIcon-circle",
            "buttons": ["新增", "查看", "修改", "删除", "查看评论"],
            "menu": "商品信息",
            "menuJump": "列表",
            "tableName": "shangpinxinxi"
          }], "menu": "商品信息管理"
        }, {
          "child": [{
            "allButtons": ["新增", "查看", "修改", "删除", "导出", "日销量", "月销量", "年销量", "品销量", "类销量", "日销额", "月销额", "年销额", "品销额", "类销额", "确认收货", "物流"],
            "appFrontIcon": "cuIcon-brand",
            "buttons": ["查看", "删除"],
            "menu": "已发货订单",
            "tableName": "orders/已发货"
          }, {
            "allButtons": ["新增", "查看", "修改", "删除", "导出", "日销量", "月销量", "年销量", "品销量", "类销量", "日销额", "月销额", "年销额", "品销额", "类销额"],
            "appFrontIcon": "cuIcon-camera",
            "buttons": ["查看", "删除"],
            "menu": "未支付订单",
            "tableName": "orders/未支付"
          }, {
            "allButtons": ["新增", "查看", "修改", "删除", "导出", "日销量", "月销量", "年销量", "品销量", "类销量", "日销额", "月销额", "年销额", "品销额", "类销额", "发货", "物流", "核销"],
            "appFrontIcon": "cuIcon-send",
            "buttons": ["查看", "删除", "发货"],
            "menu": "已支付订单",
            "tableName": "orders/已支付"
          }, {
            "allButtons": ["新增", "查看", "修改", "删除", "导出", "日销量", "月销量", "年销量", "品销量", "类销量", "日销额", "月销额", "年销额", "品销额", "类销额", "物流", "退货审核"],
            "appFrontIcon": "cuIcon-explore",
            "buttons": ["查看", "删除", "退货审核"],
            "menu": "已完成订单",
            "tableName": "orders/已完成"
          }, {
            "allButtons": ["新增", "查看", "修改", "删除", "导出", "日销量", "月销量", "年销量", "品销量", "类销量", "日销额", "月销额", "年销额", "品销额", "类销额"],
            "appFrontIcon": "cuIcon-wenzi",
            "buttons": ["查看", "删除"],
            "menu": "已取消订单",
            "tableName": "orders/已取消"
          }, {
            "allButtons": ["新增", "查看", "修改", "删除", "导出", "日销量", "月销量", "年销量", "品销量", "类销量", "日销额", "月销额", "年销额", "品销额", "类销额", "物流"],
            "appFrontIcon": "cuIcon-keyboard",
            "buttons": ["查看", "删除"],
            "menu": "已退款订单",
            "tableName": "orders/已退款"
          }], "menu": "订单管理"
        }],
        "frontMenu": [{
          "child": [{
            "allButtons": ["新增", "查看", "修改", "删除", "查看评论", "问诊", "预约"],
            "appFrontIcon": "cuIcon-pic",
            "buttons": ["查看", "问诊", "预约"],
            "menu": "医师列表",
            "menuJump": "列表",
            "tableName": "yishi"
          }], "menu": "医师模块"
        }, {
          "child": [{
            "allButtons": ["新增", "查看", "修改", "删除", "查看评论"],
            "appFrontIcon": "cuIcon-flashlightopen",
            "buttons": ["查看"],
            "menu": "商品信息列表",
            "menuJump": "列表",
            "tableName": "shangpinxinxi"
          }], "menu": "商品信息模块"
        }],
        "hasBackLogin": "是",
        "hasBackRegister": "是",
        "hasFrontLogin": "否",
        "hasFrontRegister": "否",
        "roleName": "商家",
        "tableName": "shangjia"
      }, {
        "backMenu": [{
          "child": [{
            "allButtons": ["新增", "查看", "修改", "删除", "审核"],
            "appFrontIcon": "cuIcon-vipcard",
            "buttons": ["查看", "删除", "审核"],
            "menu": "在线问诊",
            "menuJump": "列表",
            "tableName": "zaixianwenzhen"
          }], "menu": "在线问诊管理"
        }, {
          "child": [{
            "allButtons": ["新增", "查看", "修改", "删除", "审核"],
            "appFrontIcon": "cuIcon-clothes",
            "buttons": ["查看", "删除", "审核"],
            "menu": "在线预约",
            "menuJump": "列表",
            "tableName": "zaixianyuyue"
          }], "menu": "在线预约管理"
        }],
        "frontMenu": [{
          "child": [{
            "allButtons": ["新增", "查看", "修改", "删除", "查看评论", "问诊", "预约"],
            "appFrontIcon": "cuIcon-pic",
            "buttons": ["查看", "问诊", "预约"],
            "menu": "医师列表",
            "menuJump": "列表",
            "tableName": "yishi"
          }], "menu": "医师模块"
        }, {
          "child": [{
            "allButtons": ["新增", "查看", "修改", "删除", "查看评论"],
            "appFrontIcon": "cuIcon-flashlightopen",
            "buttons": ["查看"],
            "menu": "商品信息列表",
            "menuJump": "列表",
            "tableName": "shangpinxinxi"
          }], "menu": "商品信息模块"
        }],
        "hasBackLogin": "是",
        "hasBackRegister": "否",
        "hasFrontLogin": "否",
        "hasFrontRegister": "否",
        "roleName": "医师",
        "tableName": "yishi"
      }],
      baseUrl: '',
      carouselList: [],
      menuList: [],
      form: {
        ask: '',
        userid: localStorage.getItem('frontUserid')
      },
      headportrait: localStorage.getItem('frontHeadportrait') ? localStorage.getItem('frontHeadportrait') : '',
      Token: localStorage.getItem('frontToken'),
      username: localStorage.getItem('username'),
      notAdmin: localStorage.getItem('frontSessionTable') != '"users"',
      timer: '',
      iconArr: [
        'el-icon-star-off',
        'el-icon-goods',
        'el-icon-warning',
        'el-icon-question',
        'el-icon-info',
        'el-icon-help',
        'el-icon-picture-outline-round',
        'el-icon-camera-solid',
        'el-icon-video-camera-solid',
        'el-icon-video-camera',
        'el-icon-bell',
        'el-icon-s-cooperation',
        'el-icon-s-order',
        'el-icon-s-platform',
        'el-icon-s-operation',
        'el-icon-s-promotion',
        'el-icon-s-release',
        'el-icon-s-ticket',
        'el-icon-s-management',
        'el-icon-s-open',
        'el-icon-s-shop',
        'el-icon-s-marketing',
        'el-icon-s-flag',
        'el-icon-s-comment',
        'el-icon-s-finance',
        'el-icon-s-claim',
        'el-icon-s-opportunity',
        'el-icon-s-data',
        'el-icon-s-check'
      ],
      bottomContent: '',
    }
  },
  created() {
    this.baseUrl = this.$config.baseUrl;
    this.menuList = this.$config.indexNav;
    this.getCarousel();
    if (localStorage.getItem('frontToken') && localStorage.getItem('frontToken') != null) {
      this.getSession()
    }
  },
  mounted() {
    this.activeIndex = localStorage.getItem('keyPath') || '0';


    // banner
    setTimeout(() => {
      let mySwiper22 = new Swiper(".mySwiper22", {
        "navigation": {
          "nextEl": ".swiper-button-next",
          "prevEl": ".swiper-button-prev"
        },
        "freeMode": true,
        "watchSlidesVisibility": true,
        "watchSlidesProgress": true,
        "loopedSlides": 5,
        "slidesPerView": 3,
        "spaceBetween": 10
      })
      let option21 = {
        "navigation": {"nextEl": ".swiper-button-next", "prevEl": ".swiper-button-prev"},
        "loopedSlides": 5,
        "autoplay": {"delay": 2500, "disableOnInteraction": false},
        "spaceBetween": 10
      }
      option21.thumbs = {
        swiper: mySwiper22
      }
      new Swiper(".mySwiper21", option21)
    }, 500)

  },
  computed: {
    activeMenu() {
      const route = this.$route
      const {
        meta,
        path
      } = route
      // if st path, the sidebar will highlight the path you sete
      if (meta.activeMenu) {
        return meta.activeMenu
      }
      return path
    },
  },
  watch: {
    $route(newValue) {
      let that = this
      let url = window.location.href
      let arr = url.split('#')
      for (let x in this.menuList) {
        if (newValue.path == this.menuList[x].url) {
          this.activeIndex = x
        }
      }
      this.Token = localStorage.getItem('frontToken')
      if (arr[1] != '/index/home') {
        var element = document.getElementById('scrollView');
        var distance = element.offsetTop;
        window.scrollTo(0, distance)
      }
      else {
        window.scrollTo(0, 0)
      }
    },
    headportrait() {
      this.$forceUpdate()
    },
  },
  methods: {
    preHttp(str) {
      return str && str.substr(0, 4) == 'http';
    },

    async getSession() {
      await this.$http.get(`${localStorage.getItem('UserTableName')}/session`, {emulateJSON: true}).then(async res => {
        if (res.data.code == 0) {
          localStorage.setItem('sessionForm', JSON.stringify(res.data.data))
          localStorage.setItem('frontUserid', res.data.data.id);
          if (res.data.data.vip) {
            localStorage.setItem('vip', res.data.data.vip);
          }
          if (res.data.data.touxiang) {
            this.headportrait = res.data.data.touxiang
            localStorage.setItem('frontHeadportrait', res.data.data.touxiang);
          }
          else if (res.data.data.headportrait) {
            this.headportrait = res.data.data.headportrait
            localStorage.setItem('frontHeadportrait', res.data.data.headportrait);
          }
        }
      });
    },
    handleSelect(keyPath) {
      if (keyPath) {
        localStorage.setItem('keyPath', keyPath)
      }
    },
    toLogin() {
      this.$router.push('/login');
    },
    logout() {
      localStorage.clear();
      Vue.http.headers.common['Token'] = "";
      this.$router.push('/index/home');
      this.activeIndex = '0'
      localStorage.setItem('keyPath', this.activeIndex)
      this.Token = ''
      this.$forceUpdate()
      this.$message({
        message: '登出成功',
        type: 'success',
        duration: 1000,
      });
    },
    getCarousel() {
      this.$http.get('config/list', {params: {page: 1, limit: 3}}).then(res => {
        if (res.data.code == 0) {
          this.carouselList = res.data.data.list;
        }
      });
    },
    // 轮播图跳转
    carouselClick(url) {
      if (url) {
        if (url.indexOf('https') != -1) {
          window.open(url)
        }
        else {
          this.$router.push(url)
        }
      }
    },
    goBackend() {
      localStorage.setItem('Token', localStorage.getItem('frontToken'));
      localStorage.setItem('role', localStorage.getItem('frontRole'));
      localStorage.setItem('sessionTable', localStorage.getItem('frontSessionTable'));
      localStorage.setItem('headportrait', localStorage.getItem('frontHeadportrait'));
      localStorage.setItem('userid', localStorage.getItem('frontUserid'));
      window.location.href = `${this.$config.baseUrl}admin/dist/index.html`

    },
    goMenu(path) {
      this.$router.push(path);
    },
  }
}
</script>

<style lang="scss" rel="stylesheet/scss" scoped>
.menu-preview {
  .el-scrollbar {
    height: 100%;

    & /deep/ .scrollbar-wrapper-vertical {
      //overflow-x: hidden;
    }

    & /deep/ .scrollbar-wrapper-horizontal {
      //overflow-y: hidden;

      .el-scrollbar__view {
        white-space: nowrap;
      }
    }
  }
}


.menu-preview .el-menu-horizontal-demo .el-menu-item.home {
  cursor: pointer;
  border: 0;
  padding: 0 20px;
  margin: 0 10px;
  color: #333;
  white-space: nowrap;
  display: flex;
  font-size: 16px;
  line-height: 60px;
  background: #fff;
  align-items: center;
  position: relative;
  list-style: none;
  height: 60px;
}

.menu-preview .el-menu-horizontal-demo .el-menu-item.home:hover {
  color: #3B2E7E;
  background: none;
  font-weight: bold;
  font-size: 16px;
}

.menu-preview .el-menu-horizontal-demo .el-menu-item.home.is-active {
  color: #3B2E7E;
  background: none;
  font-weight: bold;
  font-size: 16px;
}

.menu-preview .el-menu-horizontal-demo .el-menu-item.user {
  cursor: pointer;
  border: 0;
  padding: 0 20px;
  color: #333;
  white-space: nowrap;
  display: none;
  font-size: 16px;
  line-height: 56px;
  background: #fff;
  align-items: center;
  position: relative;
  list-style: none;
  height: 56px;
}

.menu-preview .el-menu-horizontal-demo .el-menu-item.user:hover {
  color: #fff;
  background: red;
}

.menu-preview .el-menu-horizontal-demo .el-menu-item.user.is-active {
  color: #fff;
  background: blue;
}

.menu-preview .el-menu-horizontal-demo .el-menu-item.service {
  cursor: pointer;
  border: 0;
  padding: 0 20px;
  color: #333;
  white-space: nowrap;
  display: none;
  font-size: 14px;
  line-height: 56px;
  background: #fff;
  align-items: center;
  position: relative;
  list-style: none;
  height: 56px;
}

.menu-preview .el-menu-horizontal-demo .el-menu-item.service:hover {
  color: #fff;
  background: red;
}

.menu-preview .el-menu-horizontal-demo .el-menu-item.service.is-active {
  color: #fff;
  background: blue;
}

.menu-preview .el-menu-horizontal-demo .el-menu-item.shop {
  cursor: pointer;
  border: 0;
  padding: 0 20px;
  color: #333;
  white-space: nowrap;
  display: none;
  font-size: 14px;
  line-height: 56px;
  background: #fff;
  align-items: center;
  position: relative;
  list-style: none;
  height: 56px;
}

.menu-preview .el-menu-horizontal-demo .el-menu-item.shop:hover {
  color: #fff;
  background: red;
}

.menu-preview .el-menu-horizontal-demo .el-menu-item.shop.is-active {
  color: #fff;
  background: blue;
}

.menu-preview .el-menu-horizontal-demo .el-menu-item.back {
  cursor: pointer;
  border: 0;
  padding: 0 20px;
  color: #333;
  white-space: nowrap;
  display: none;
  font-size: 14px;
  line-height: 56px;
  background: #fff;
  align-items: center;
  position: relative;
  list-style: none;
  height: 56px;
}

.menu-preview .el-menu-horizontal-demo .el-menu-item.back:hover {
  color: #fff;
  background: red;
}

.menu-preview .el-menu-horizontal-demo .el-menu-item.back.is-active {
  color: #fff;
  background: blue;
}

.menu-preview .el-menu-horizontal-demo .el-menu-item.item {
  cursor: pointer;
  border: 0;
  padding: 0 20px;
  margin: 0 10px;
  color: #333;
  white-space: nowrap;
  display: flex;
  font-size: 16px;
  line-height: 60px;
  background: #fff;
  align-items: center;
  position: relative;
  list-style: none;
  height: 60px;
}

.menu-preview .el-menu-horizontal-demo .el-menu-item.item:hover {
  color: #3B2E7E;
  background: none;
  font-weight: bold;
  font-size: 16px;
}

.menu-preview .el-menu-horizontal-demo .el-menu-item.item.is-active {
  color: #3B2E7E;
  background: none;
  font-weight: bold;
  font-size: 16px;
}

.banner-preview {
  .el-carousel /deep/ .el-carousel__indicator button {
    width: 0;
    height: 0;
    display: none;
  }
}

.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
  width: 36px;
  font-size: 12px;
  height: 36px;
}

.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
  background: red;
}

.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
  width: 36px;
  font-size: 12px;
  height: 36px;
}

.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
  background: red;
}

.banner-preview .el-carousel /deep/ .el-carousel__indicators {
  padding: 0;
  margin: 0;
  z-index: 2;
  position: absolute;
  list-style: none;
}

.banner-preview .el-carousel /deep/ .el-carousel__indicators li {
  padding: 0;
  margin: 0 4px;
  background: #fff;
  display: inline-block;
  width: 12px;
  opacity: 0.4;
  transition: 0.3s;
  height: 12px;
}

.banner-preview .el-carousel /deep/ .el-carousel__indicators li:hover {
  padding: 0;
  margin: 0 4px;
  background: #fff;
  display: inline-block;
  width: 24px;
  opacity: 0.7;
  height: 12px;
}

.banner-preview .el-carousel /deep/ .el-carousel__indicators li.is-active {
  padding: 0;
  margin: 0 4px;
  background: #fff;
  display: inline-block;
  width: 24px;
  opacity: 1;
  height: 12px;
}

.chat-content {
  padding-bottom: 20px;
  width: 100%;
  margin-bottom: 10px;
  max-height: 300px;
  height: 300px;
  overflow-y: scroll;
  border: 1px solid #eeeeee;
  background: #fff;

  .left-content {
    float: left;
    margin-bottom: 10px;
    padding: 10px;
    max-width: 80%;
  }

  .right-content {
    float: right;
    margin-bottom: 10px;
    padding: 10px;
    max-width: 80%;
  }
}

.clear-float {
  clear: both;
}

.swiper21 .swiper-button-prev:after {
  display: none;
}

.swiper21 .swiper-button-next:after {
  display: none;
}

.swiper22 .swiper-button-prev:after {
  display: none;
}

.swiper22 .swiper-button-next:after {
  display: none;
}

.swiper22 .swiper-slide div {
  width: 100%;
  opacity: 0.4;
  height: auto;
}

.swiper22 .swiper-slide.swiper-slide-thumb-active div {
  opacity: 1;
}


// -------- search --------
.main-containers .search .select /deep/ .el-input__inner {
  border: 0;
  border-radius: 4px;
  padding: 0 30px 0 10px;
  box-shadow: 0 0 6px rgba(64, 158, 255, .3);
  outline: none;
  color: rgba(64, 158, 255, 1);
  width: 180px;
  font-size: 14px;
  height: 44px;
}

.main-containers .search .input /deep/ .el-input__inner {
  border: 0;
  border-radius: 4px;
  padding: 0 10px;
  box-shadow: 0 0 6px rgba(64, 158, 255, .3);
  outline: none;
  color: rgba(64, 158, 255, 1);
  width: 180px;
  font-size: 14px;
  height: 44px;
}

// -------- search --------

.main-containers .btn-service {
  border: 0;
  padding: 0 8px;
  margin: 0 10px;
  color: #000;
  background: none;
  font-weight: bold;
  width: auto;
  font-size: 15px;
  line-height: 32px;
  height: 80px;
}

.main-containers .btn-service:hover {
  color: #555;
  background: none;
}

.main-containers .btn-shop {
  border: 0;
  padding: 0 8px;
  margin: 0 0;
  color: #000;
  background: none;
  font-weight: bold;
  width: auto;
  font-size: 15px;
  line-height: 32px;
  height: 80px;
}

.main-containers .btn-shop:hover {
  color: #555;
  background: none;
}
</style>
