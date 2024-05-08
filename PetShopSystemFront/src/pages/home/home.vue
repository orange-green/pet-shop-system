<template>
  <div :style='{"width":"100%","margin":"0 auto","flexDirection":"column","display":"flex"}' class="home-preview">


    <!-- 系统简介 -->
    <div id="system" :style='{"padding":"200px 10%","boxShadow":"none","margin":"0 0 0","alignItems":"center","display":"flex","justifyContent":"flex-start","background":"url(http://codegen.caihongy.cn/20231129/6d333914c39641f49f384877d02a5f06.png)","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","height":"auto","order":"2"}'
         class="animate__animated">
      <div :style='{"width":"30%","lineHeight":"1.5","fontSize":"32px","color":"#fff","textAlign":"left"}'>
        {{ systemIntroductionDetail.title }}
      </div>
      <div
          :style='{"margin":"0 0 10px","color":"#999","textAlign":"center","display":"none","width":"100%","lineHeight":"1.5","fontSize":"20px"}'>
        {{ systemIntroductionDetail.subtitle }}
      </div>
      <div :style='{"width":"100%","padding":"0 10px","flexWrap":"wrap","display":"none","height":"auto"}'>
        <img :src="baseUrl + systemIntroductionDetail.picture1"
             :style='{"margin":"0 10px","objectFit":"cover","flex":1,"display":"block","height":"120px"}'>
        <img :src="baseUrl + systemIntroductionDetail.picture2"
             :style='{"margin":"0 10px","objectFit":"cover","flex":1,"display":"block","height":"120px"}'>
        <img :src="baseUrl + systemIntroductionDetail.picture3"
             :style='{"margin":"0 10px","objectFit":"cover","flex":1,"display":"block","height":"120px"}'>
      </div>
      <div
          :style='{"minHeight":"200px","padding":"60px 40px 0","margin":"0 0 10px 0","overflow":"hidden","color":"#fff","maxHeight":"400px","display":"-webkit-box","width":"40%","lineHeight":"1.8","fontSize":"16px","-webkit-box-orient":"vertical","-webkit-line-clamp":"12"}'
          v-html="systemIntroductionDetail.content"></div>
      <div
          :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}'/>
      <div
          :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}'/>
      <div
          :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}'/>
      <div
          :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}'/>
      <div
          :style='{"border":"0","margin":"10px auto","textAlign":"center","background":"#409EFF","display":"none","width":"80px","lineHeight":"32px"}'
          @click="toDetail('systemintroDetail',systemIntroductionDetail)">
        <span :style='{"color":"#f5f5f5","fontSize":"12px"}'>更多</span>
        <span :style='{"color":"#f5f5f5","fontSize":"12px"}' class="icon iconfont icon-gengduo1"></span>
      </div>
    </div>
    <!-- 系统简介 -->

    <!-- 新闻资讯 -->
    <div id="animate_newsnews" :style='{"padding":"10px 10%","margin":"0 0 0","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20231129/be87fc1ca4514f208a8321beadd1ebfc.png)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","order":"1"}'
         class="news animate__animated" style="display: flex;justify-content: center">
      <div v-if="false" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'
           class="idea newsIdea">
        <div :style='{"width":"20%","background":"#fff","height":"80px"}' class="box1"></div>
        <div :style='{"width":"20%","background":"#fff","height":"80px"}' class="box2"></div>
        <div :style='{"width":"20%","background":"#fff","height":"80px"}' class="box3"></div>
        <div :style='{"width":"20%","background":"#fff","height":"80px"}' class="box4"></div>
        <div :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}' class="box5"></div>
        <div :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}' class="box6"></div>
        <div :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}' class="box7"></div>
        <div :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}' class="box8"></div>
        <div :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}' class="box9"></div>
        <div :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}' class="box10"></div>
      </div>

      <div :style='{"width":"100%","margin":"10px auto 0","textAlign":"center","lineHeight":"54px","background":"none","order":"1"}'
           class="title">
        <span :style='{"color":"#000000","fontSize":"32px"}'>新闻资讯</span>
      </div>

      <div v-if="newsList.length" :style='{"padding":"30px 0 0","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto","order":"3"}'
           class="list list18 index-pv1">
        <div
            :style='{"width":"55%","background":"none","justifyContent":"space-between","display":"flex","height":"auto"}'
            class="left">
          <div
              :style='{"margin":"0 30px 0 0","flexDirection":"column","background":"none","display":"flex","width":"calc(40% - 30px)","justifyContent":"space-between","height":"auto"}'
              class="list">
            <template v-for="(item,index) in newsList">
              <div v-if="index < 6" :class="index == newsIndex18 ? 'active' : ''" class="item"
                   @click="toDetail('newsDetail', item)" @mouseenter="newsMouseove18(index)">
                <div class="name">{{ item.title }}</div>
              </div>
            </template>
          </div>
          <div :style='{"width":"60%","height":"auto"}' class="imgs">
            <template v-for="(item,index) in newsList">
              <img v-if="index < 6" v-show="index == newsIndex18"
                   :src="baseUrl + item.picture"
                   :style='{"width":"100%","objectFit":"cover","display":"block","height":"520px"}' alt="">
            </template>
          </div>
        </div>
        <div :style='{"width":"calc(45% - 30px)","margin":"0 0 0 30px","background":"none","height":"auto"}'
             class="right">
          <div v-if="newsList.length > 6" :style='{"width":"100%","position":"relative","height":"auto"}'
               class="top list-item animation-box" @click="toDetail('newsDetail', newsList[6])">
            <img :src="baseUrl + newsList[6].picture"
                 :style='{"width":"100%","objectFit":"cover","display":"block","height":"220px"}'>
            <div :style='{"width":"100%","position":"absolute","left":"0","bottom":"0","background":"rgba(0,0,0,.3)"}'>
              <div
                  :style='{"padding":"0 10px","lineHeight":"44px","fontSize":"16px","color":"#fff","textAlign":"center"}'
                  class="title">{{ newsList[6].title }}
              </div>
            </div>
          </div>
          <div v-if="newsList.length > 7"
               :style='{"padding":"10px 0 0","background":"#fff","flexDirection":"column","display":"flex","width":"100%","justifyContent":"space-between","height":"300px"}'
               class="list">
            <template v-for="(item,index) in newsList">
              <div v-if="index > 6"
                   :style='{"cursor":"pointer","border":"1px solid #E0E0E0","padding":"0 20px","alignItems":"center","display":"flex","width":"100%","height":"auto"}'
                   class="item" @click="toDetail('newsDetail', item)">
                <div class="dian"></div>
                <div class="title">{{ item.title }}</div>
                <div :style='{"padding":"0 6px"}' class="time">
                  <span class="icon iconfont icon-shijian21"></span>
                  <span class="text">{{ item.addtime }}</span>
                </div>
              </div>
            </template>
          </div>
        </div>
      </div>

      <div :style='{"border":"0","margin":"0","textAlign":"center","background":"none","display":"block","width":"auto","lineHeight":"32px","order":"2"}'
           @click="moreBtn('news')">
        <span :style='{"color":"#8E8E8E","fontSize":"14px"}'>查看更多</span>
        <i :style='{"color":"#8E8E8E","fontSize":"14px"}' class="icon iconfont icon-gengduo1"></i>
      </div>

    </div>


    <!-- 商品推荐 -->
    <div id="animate_recommendyishi" :style='{"padding":"0 10%","margin":"0 0 0","background":"url(http://codegen.caihongy.cn/20231129/5a039ebb9e0649cda7b9abfefc729de8.png)","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","order":"4"}'
         class="recommend animate__animated">
      <div v-if="false" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'
           class="idea recommendIdea">
        <div :style='{"width":"20%","background":"#fff","height":"80px"}' class="box1"></div>
        <div :style='{"width":"20%","background":"#fff","height":"80px"}' class="box2"></div>
        <div :style='{"width":"20%","background":"#fff","height":"80px"}' class="box3"></div>
        <div :style='{"width":"20%","background":"#fff","height":"80px"}' class="box4"></div>
        <div :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}' class="box5"></div>
        <div :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}' class="box6"></div>
        <div :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}' class="box7"></div>
        <div :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}' class="box8"></div>
        <div :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}' class="box9"></div>
        <div :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}' class="box10"></div>
      </div>

      <div :style='{"width":"200px","margin":"50px auto","lineHeight":"54px","textAlign":"center","background":"none"}'
           class="title">
        <span :style='{"color":"#fff","fontSize":"32px"}'>医师推荐</span>
      </div>


      <!-- 样式一 -->
      <div :style='{"width":"100%","padding":"60px 0","flexWrap":"wrap","background":"none","display":"flex","height":"auto"}'
           class="list list1 index-pv1">
        <div
            v-for="(item,index) in yishiRecommend"
            :key="index" :style='{"border":"1px solid #E0E0E0","padding":"40px 20px","margin":"0","flexWrap":"wrap","background":"#fff","display":"flex","width":"25%","position":"relative","height":"auto"}' class="list-item animation-box"
            @click="toDetail('yishiDetail', item)">

          <img
              v-if="preHttp(item.touxiang)"
              :src="item.touxiang.split(',')[0]" :style='{"width":"100%","margin":"0 auto","objectFit":"cover","display":"block","height":"190px","order":"1"}' alt=""/>
          <img
              v-else
              :src="baseUrl + (item.touxiang?item.touxiang.split(',')[0]:'')" :style='{"width":"100%","margin":"0 auto","objectFit":"cover","display":"block","height":"190px","order":"1"}' alt=""/>
          <div :style='{"padding":"10px","color":"#000","textAlign":"center","width":"100%","lineHeight":"1.5","fontSize":"16px","fontWeight":"bold","order":"2"}'
               class="name line1">
            {{ item.dianpumingcheng }}
          </div>
          <div :style='{"padding":"10px","color":"#000","textAlign":"center","width":"100%","lineHeight":"1.5","fontSize":"16px","fontWeight":"bold","order":"2"}'
               class="name line1">
            {{ item.yishixingming }}
          </div>
          <div :style='{"padding":"10px","color":"#000","textAlign":"center","width":"100%","lineHeight":"1.5","fontSize":"16px","fontWeight":"bold","order":"2"}'
               class="name line1">
            {{ item.xingbie }}
          </div>
          <div :style='{"padding":"10px","color":"#000","textAlign":"center","width":"100%","lineHeight":"1.5","fontSize":"16px","fontWeight":"bold","order":"2"}'
               class="name line1">
            {{ item.zhiwei }}
          </div>
          <div :style='{"width":"50%","padding":"0 10px 10px","textAlign":"center","order":"7"}'>
            <span :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#666"}'
                  class="icon iconfont icon-shijian21"></span>
            <span :style='{"color":"#666","lineHeight":"1.5","fontSize":"12px"}' class="text">{{ item.addtime }}</span>
          </div>
          <div :style='{"width":"50%","padding":"0 10px 10px","textAlign":"center","order":"6"}'>
            <span :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#666"}'
                  class="icon iconfont icon-geren16"></span>
            <span :style='{"color":"#666","lineHeight":"1.5","fontSize":"12px"}'
                  class="text">{{ item.dianpumingcheng }}</span>
          </div>
          <div :style='{"width":"calc(100% / 3)","padding":"0 10px 10px","textAlign":"center","order":"4"}'>
            <span :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#909090"}'
                  class="icon iconfont icon-shoucang10"></span>
            <span :style='{"color":"#909090","lineHeight":"1.5","fontSize":"12px"}'
                  class="text">{{ item.storeupnum }}</span>
          </div>
          <div :style='{"width":"calc(100% / 3)","padding":"0 10px 10px","textAlign":"center","order":"5"}'>
            <span :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#909090"}'
                  class="icon iconfont icon-chakan9"></span>
            <span :style='{"color":"#909090","lineHeight":"1.5","fontSize":"12px"}'
                  class="text">{{ item.clicknum }}</span>
          </div>
        </div>
      </div>


      <div :style='{"border":"0","margin":"10px auto","textAlign":"center","background":"#409EFF","display":"none","width":"80px","lineHeight":"32px"}'
           @click="moreBtn('yishi')">
        <span :style='{"color":"#f5f5f5","fontSize":"12px"}'>更多</span>
        <i :style='{"color":"#f5f5f5","fontSize":"12px"}' class="icon iconfont icon-gengduo1"></i>
      </div>

    </div>
    <!-- 商品推荐 -->

    <!-- 商品推荐 -->
    <div id="animate_recommendshangpinxinxi" :style='{"padding":"0 10%","margin":"0 0 0","background":"url(http://codegen.caihongy.cn/20231129/5a039ebb9e0649cda7b9abfefc729de8.png)","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","order":"4"}'
         class="recommend animate__animated">
      <div v-if="false" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'
           class="idea recommendIdea">
        <div :style='{"width":"20%","background":"#fff","height":"80px"}' class="box1"></div>
        <div :style='{"width":"20%","background":"#fff","height":"80px"}' class="box2"></div>
        <div :style='{"width":"20%","background":"#fff","height":"80px"}' class="box3"></div>
        <div :style='{"width":"20%","background":"#fff","height":"80px"}' class="box4"></div>
        <div :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}' class="box5"></div>
        <div :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}' class="box6"></div>
        <div :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}' class="box7"></div>
        <div :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}' class="box8"></div>
        <div :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}' class="box9"></div>
        <div :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}' class="box10"></div>
      </div>

      <div :style='{"width":"200px","margin":"50px auto","lineHeight":"54px","textAlign":"center","background":"none"}'
           class="title">
        <span :style='{"color":"#fff","fontSize":"32px"}'>商品信息推荐</span>
      </div>


      <!-- 样式一 -->
      <div :style='{"width":"100%","padding":"60px 0","flexWrap":"wrap","background":"none","display":"flex","height":"auto"}'
           class="list list1 index-pv1">
        <div
            v-for="(item,index) in shangpinxinxiRecommend"
            :key="index" :style='{"border":"1px solid #E0E0E0","padding":"40px 20px","margin":"0","flexWrap":"wrap","background":"#fff","display":"flex","width":"25%","position":"relative","height":"auto"}' class="list-item animation-box"
            @click="toDetail('shangpinxinxiDetail', item)">

          <img
              v-if="preHttp(item.tupian)"
              :src="item.tupian.split(',')[0]" :style='{"width":"100%","margin":"0 auto","objectFit":"cover","display":"block","height":"190px","order":"1"}' alt=""/>
          <img
              v-else
              :src="baseUrl + (item.tupian?item.tupian.split(',')[0]:'')" :style='{"width":"100%","margin":"0 auto","objectFit":"cover","display":"block","height":"190px","order":"1"}' alt=""/>
          <div :style='{"padding":"10px","color":"#000","textAlign":"center","width":"100%","lineHeight":"1.5","fontSize":"16px","fontWeight":"bold","order":"2"}'
               class="name line1">
            {{ item.shangpinmingcheng }}
          </div>
          <div :style='{"padding":"10px","color":"#000","textAlign":"center","width":"100%","lineHeight":"1.5","fontSize":"16px","fontWeight":"bold","order":"2"}'
               class="name line1">
            {{ item.shangpinfenlei }}
          </div>
          <div :style='{"padding":"10px","color":"#000","textAlign":"center","width":"100%","lineHeight":"1.5","fontSize":"16px","fontWeight":"bold","order":"2"}'
               class="name line1">
            {{ item.pinpai }}
          </div>
          <div :style='{"width":"50%","padding":"0 10px 10px","textAlign":"center","order":"7"}'>
            <span :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#666"}'
                  class="icon iconfont icon-shijian21"></span>
            <span :style='{"color":"#666","lineHeight":"1.5","fontSize":"12px"}' class="text">{{ item.addtime }}</span>
          </div>
          <div :style='{"width":"50%","padding":"0 10px 10px","textAlign":"center","order":"6"}'>
            <span :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#666"}'
                  class="icon iconfont icon-geren16"></span>
            <span :style='{"color":"#666","lineHeight":"1.5","fontSize":"12px"}'
                  class="text">{{ item.dianpumingcheng }}</span>
          </div>
          <div :style='{"width":"calc(100% / 3)","padding":"0 10px 10px","textAlign":"center","order":"4"}'>
            <span :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#909090"}'
                  class="icon iconfont icon-shoucang10"></span>
            <span :style='{"color":"#909090","lineHeight":"1.5","fontSize":"12px"}'
                  class="text">{{ item.storeupnum }}</span>
          </div>
        </div>
      </div>


      <div :style='{"border":"0","margin":"10px auto","textAlign":"center","background":"#409EFF","display":"none","width":"80px","lineHeight":"32px"}'
           @click="moreBtn('shangpinxinxi')">
        <span :style='{"color":"#f5f5f5","fontSize":"12px"}'>更多</span>
        <i :style='{"color":"#f5f5f5","fontSize":"12px"}' class="icon iconfont icon-gengduo1"></i>
      </div>

    </div>
    <!-- 商品推荐 -->


    <!-- 友链 -->
    <div id="friendly" :style='{"padding":"30px 10%","margin":"0 auto 0","flexWrap":"wrap","background":"#efefef","display":"flex","width":"100%","height":"auto","order":"6"}'
         class="friendly animate__animated">
      <div
          :style='{"width":"auto","borderColor":"#aaa","borderStyle":"solid","textAlign":"center","borderWidth":"0","height":"auto"}'>
        <div
            :style='{"padding":"0 10px","borderColor":"rgba(64, 158, 255)","margin":"0 0 -1px 0","color":"#000","borderWidth":"0","display":"inline-block","lineHeight":"60px","fontSize":"32px","borderStyle":"solid"}'>
          友情链接
        </div>
      </div>
      <div
          :style='{"width":"100%","padding":"10px 0 0 200px","flexWrap":"wrap","justifyContent":"space-between","display":"flex","height":"auto"}'>
        <div
            v-for="item in friendLinkList"
            :key="item.id" :style='{"padding":"10px 0","margin":"0 0 20px","alignItems":"center","flexDirection":"column","background":"#fff","display":"flex","clipPath":"polygon(80px 0%, 100% 00% ,calc(100% - 80px) 100%, 0 100%)","width":"30%","justifyContent":"center","height":"auto"}' @click="friendlinkClick(item.url)">
          <img
              :src="item.picture?(baseUrl + item.picture.split(',')[0]): ''"
              :style='{"width":"50%","margin":"0 auto","objectFit":"contain","borderRadius":"0","display":"block","height":"60px"}' alt="">
          <div :style='{"lineHeight":"24px","fontSize":"14px","color":"#333","display":"none"}'>{{ item.name }}</div>
        </div>
      </div>
    </div>
    <!-- 友链 -->
  </div>
</template>

<script>
import 'animate.css'

export default {
  //数据集合
  data() {
    return {
      baseUrl: '',
      systemIntroductionDetail: {},
      newsList: [],
      yishiRecommend: [],
      shangpinxinxiRecommend: [],


      newsIndex18: 0,


      friendLinkList: [],
    }
  },
  created() {
    this.baseUrl = this.$config.baseUrl;
    this.getNewsList();
    this.getSystemIntroduction();
    this.getList();
    this.getFriendLinkList()
  },
  mounted() {
    window.addEventListener('scroll', this.handleScroll)
    setTimeout(() => {
      this.handleScroll()
    }, 100)

    this.swiperChanges()
  },
  beforeDestroy() {
    window.removeEventListener('scroll', this.handleScroll)
  },
  //方法集合
  methods: {
    swiperChanges() {
      setTimeout(() => {
      }, 750)
    },
    // 获取友链列表
    getFriendLinkList() {
      this.$http.get('friendlink/list', {params: {page: 1, limit: 100}}).then(res => {
        if (res.data.code == 0) {
          this.friendLinkList = res.data.data.list
        }
      })
    },
    // 友链跳转
    friendlinkClick(url) {
      if (url) {
        window.open(url)
      }
    },
    newsMouseove18(index) {
      this.newsIndex18 = index
    },

    listIndexClick11(index, name) {
      this['listIndex11' + name] = index[this['listColumn11' + name]]
      this.getList()
    },

    handleScroll() {
      let arr = [
        {id: 'search', css: 'animate__pulse'},
        {id: 'about', css: 'animate__backInRight'},
        {id: 'system', css: 'animate__backInLeft'},
        {id: 'animate_recommendyishi', css: 'animate__fadeIn'},
        {id: 'animate_recommendshangpinxinxi', css: 'animate__fadeIn'},
        {id: 'animate_newsnews', css: 'animate__swing'},
        {id: 'msgs', css: 'animate__rubberBand'},
        {id: 'friendly', css: 'animate__bounce'}
      ]

      for (let i in arr) {
        let doc = document.getElementById(arr[i].id)
        if (doc) {
          let top = doc.offsetTop
          let win_top = window.innerHeight + window.pageYOffset
          // console.log(top,win_top)
          if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
            // console.log(doc)
            doc.classList.add(arr[i].css)
          }
        }
      }
    },
    preHttp(str) {
      return str && str.substr(0, 4) == 'http';
    },
    getSystemIntroduction() {
      this.$http.get('systemintro/detail/1', {}).then(res => {
        if (res.data.code == 0) {
          this.systemIntroductionDetail = res.data.data;
        }
      })
    },
    getNewsList() {
      let data = {
        page: 1,
        limit: 14,
        sort: 'addtime',
        order: 'desc'
      }
      this.$http.get('news/list', {params: data}).then(res => {
        if (res.data.code == 0) {
          this.newsList = res.data.data.list;


        }
      });
    },
    getList() {
      let autoSortUrl = "";
      let data = {}
      autoSortUrl = "yishi/autoSort";
      data = {
        page: 1,
        limit: 8,
      }
      this.$http.get(autoSortUrl, {params: data}).then(res => {
        if (res.data.code == 0) {
          this.yishiRecommend = res.data.data.list;


          // 商品列表样式五

        }
      });
      autoSortUrl = "shangpinxinxi/autoSort";
      if (localStorage.getItem('frontToken')) {
        autoSortUrl = "shangpinxinxi/autoSort2";
      }
      data = {
        page: 1,
        limit: 8,
      }
      this.$http.get(autoSortUrl, {params: data}).then(res => {
        if (res.data.code == 0) {
          this.shangpinxinxiRecommend = res.data.data.list;


          // 商品列表样式五

        }
      });

    },
    toDetail(path, item) {
      this.$router.push({path: '/index/' + path, query: {id: item.id}});
    },
    moreBtn(path) {
      this.$router.push({path: '/index/' + path});
    }
  }
}
</script>

<style lang="scss" rel="stylesheet/scss" scoped>
.home-preview {
  // -------- search --------
  .search .select /deep/ .el-input__inner {
    border: 0;
    border-radius: 30px 0 0 30px;
    padding: 0 30px 0 10px;
    box-shadow: none;
    outline: none;
    color: #fff;
    background: rgba(0, 0, 0, .3);
    width: 200px;
    font-size: 16px;
    text-align: center;
    height: 60px;
  }

  .search .input /deep/ .el-input__inner {
    border: 0;
    border-radius: 0 30px 30px 0;
    padding: 0 10px;
    box-shadow: none;
    outline: none;
    color: #fff;
    background: rgba(0, 0, 0, .3);
    width: 100%;
    font-size: 16px;
    height: 60px;
  }

  // -------- search --------
  .recommend {
    .list3 .swiper-button-prev {
      left: 10px;
      right: auto;
    }

    .list3 .swiper-button-prev::after {
      color: rgb(64, 158, 255);
    }

    .list3 .swiper-button-next {
      left: auto;
      right: 10px;
    }

    .list3 .swiper-button-next::after {
      color: rgb(64, 158, 255);
    }

    .list5 .swiper-button-prev {
      left: 10px;
      right: auto;
    }

    .list5 .swiper-button-prev::after {
      color: rgb(64, 158, 255);
    }

    .list5 .swiper-button-next {
      left: auto;
      right: 10px;
    }

    .list5 .swiper-button-next::after {
      color: rgb(64, 158, 255);
    }

    .list5 {
      .swiper-slide-prev {
        position: relative;
        z-index: 3;
      }

      .swiper-slide-next {
        position: relative;
        z-index: 3;
      }

      .swiper-slide-active {
        position: relative;
        z-index: 5;
      }
    }

    .index-pv1 .animation-box {
      transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
      z-index: initial;
    }

    .index-pv1 .animation-box:hover {
      transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, -6px, 0px);
      -webkit-perspective: 1000px;
      perspective: 1000px;
      transition: 0.3s;
      z-index: 1;
    }

    .index-pv1 .animation-box img {
      transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
    }

    .index-pv1 .animation-box img:hover {
      transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
      -webkit-perspective: 1000px;
      perspective: 1000px;
      transition: 0.3s;
    }
  }

  .news {
    .list3 .swiper-button-prev {
      left: 10px;
      right: auto;
    }

    .list3 .swiper-button-prev::after {
      color: rgb(64, 158, 255);
    }

    .list3 .swiper-button-next {
      left: auto;
      right: 10px;
    }

    .list3 .swiper-button-next::after {
      color: rgb(64, 158, 255);
    }

    .list6 .swiper-button-prev {
      left: 10px;
      right: auto;
    }

    .list6 .swiper-button-prev::after {
      color: rgb(64, 158, 255);
    }

    .list6 .swiper-button-next {
      left: auto;
      right: 10px;
    }

    .list6 .swiper-button-next::after {
      color: rgb(64, 158, 255);
    }

    .index-pv1 .animation-box {
      transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
      z-index: initial;
    }

    .index-pv1 .animation-box:hover {
      transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
      -webkit-perspective: 1000px;
      perspective: 1000px;
      transition: 0.3s;
      z-index: 1;
    }

    .index-pv1 .animation-box img {
      transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
    }

    .index-pv1 .animation-box img:hover {
      transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
      -webkit-perspective: 1000px;
      perspective: 1000px;
      transition: 0.3s;
    }
  }

  .lists {
    .list3 .swiper-button-prev {
      left: 10px;
      right: auto;
    }

    .list3 .swiper-button-prev::after {
      color: rgb(64, 158, 255);
    }

    .list3 .swiper-button-next {
      left: auto;
      right: 10px;
    }

    .list3 .swiper-button-next::after {
      color: rgb(64, 158, 255);
    }

    .list5 .swiper-button-prev {
      left: 10px;
      right: auto;
    }

    .list5 .swiper-button-prev::after {
      color: rgb(64, 158, 255);
    }

    .list5 .swiper-button-next {
      left: auto;
      right: 10px;
    }

    .list5 .swiper-button-next::after {
      color: rgb(64, 158, 255);
    }

    .list5 {
      .swiper-slide-prev {
        position: relative;
        z-index: 3;
      }

      .swiper-slide-next {
        position: relative;
        z-index: 3;
      }

      .swiper-slide-active {
        position: relative;
        z-index: 5;
      }
    }

    .index-pv1 .animation-box {
      transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
      z-index: initial;
    }

    .index-pv1 .animation-box:hover {
      transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, -6px, 0px);
      -webkit-perspective: 1000px;
      perspective: 1000px;
      transition: 0.3s;
      z-index: 1;
    }

    .index-pv1 .animation-box img {
      transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
    }

    .index-pv1 .animation-box img:hover {
      transform: rotate(0deg) scale(1) skew(0deg, -3deg) translate3d(0px, 0px, 0px);
      -webkit-perspective: 1000px;
      perspective: 1000px;
      transition: 0.3s;
    }
  }
}


.home-preview .news .list18 .left .list .item {
  cursor: pointer;
  border: 1px solid #E0E0E0;
  padding: 0 20px;
  background: #fff;
  display: flex;
  width: 100%;
  align-items: center;
  height: 15%;
}

.home-preview .news .list18 .left .list .item:hover {
  background: #3B2E7E;
}

.home-preview .news .list18 .left .list .item .name {
  overflow: hidden;
  color: #000;
  white-space: nowrap;
  font-size: 18px;
  line-height: 1.5;
  text-overflow: ellipsis;
}

.home-preview .news .list18 .left .list .item:hover .name {
  color: #fff;
}

.home-preview .news .list18 .right .list .item .dian {
  border-radius: 100%;
  margin: 0 6px;
  background: #333;
  display: none;
  width: 4px;
  height: 4px;
}

.home-preview .news .list18 .right .list .item:hover .dian {
  background: red;
}

.home-preview .news .list18 .right .list .item .title {
  color: #333;
  flex: 1;
  font-size: 14px;
  line-height: 24px;
  transition: 0.3s;
}

.home-preview .news .list18 .right .list .item:hover .title {
  color: #3B2E7E;
  font-weight: bold;
}

.home-preview .news .list18 .right .list .item .time .icon {
  color: #666;
  font-size: 12px;
  line-height: 24px;
}

.home-preview .news .list18 .right .list .item:hover .time .icon {
  color: red;
}

.home-preview .news .list18 .right .list .item .time .text {
  color: #666;
  font-size: 12px;
  line-height: 24px;
}

.home-preview .news .list18 .right .list .item:hover .time .text {
  color: red;
}


</style>
