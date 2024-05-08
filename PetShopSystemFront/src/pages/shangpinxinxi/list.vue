<template>
  <div>
    <div
        :style='{"border":"1px solid #E0E0E0","padding":"20px 0 10px","margin":"10px auto","borderRadius":"0","background":"none","borderWidth":"0 0 2px","display":"flex","width":"80%","justifyContent":"center"}'
        class="breadcrumb-preview">
      <el-breadcrumb :separator="'>'" :style='{"fontSize":"14px","lineHeight":"1"}'>
        <el-breadcrumb-item class="item1" to="/"><a>首页</a></el-breadcrumb-item>
        <el-breadcrumb-item v-for="(item, index) in breadcrumbItem" :key="index" class="item2"><a>{{ item.name }}</a>
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div v-if="centerType"
         :style='{"border":"1px solid #E0E0E0","padding":"20px 0 10px","margin":"10px auto","borderRadius":"0","background":"none","borderWidth":"0 0 2px","display":"flex","width":"80%","justifyContent":"center"}'>
      <el-button size="mini" @click="backClick">返回</el-button>
    </div>

    <!-- left -->
    <div
        :style='{"top":"675px","float":"left","border":"1px solid #E0E0E0","padding":"0","marginLeft":"4%","background":"#fff","width":"11%"}'
        class="category-3">
      <div :class="swiperIndex == '-1' ? 'active' : ''" :plain="isPlain" class="item" @click="getList(1, '全部')">
        <div :style='{"color":"inherit","fontSize":"16px"}'>全部</div>
      </div>
      <div v-for="(item, index) in fenlei" :key="index" :ref="'btn' + index"
           :class="swiperIndex == index ? 'active' : ''"
           class="item" plain @click="getList(1, item[feileiColumn], 'btn' + index)">
        <img v-if="item.image"
             :src="baseUrl + (item.image?item.image.split(',')[0]:'')"
             :style='{"width":"50px","margin":"0 5px 0 0","objectFit":"cover","display":"block","height":"50px"}'>
        <div :style='{"color":"inherit","fontSize":"16px"}'>{{ item[feileiColumn] }}</div>
      </div>
    </div>

    <div class="goToTop" style="display:none;background-color: rgb(198, 28, 20);font-size: 32px;position: fixed;top: 80%;right: 4%">
      <a href="#">
        <i class="el-icon-arrow-up" style="color: white;padding: 10px"></i>
      </a>
    </div>

    <div
        :style='{"float":"right","width":"75%","margin":"10px 5% 0px 0px","right":"5%","position":"relative","flexWrap":"wrap","background":"#fff",}'
        class="list-preview">
      <el-form :inline="true" :model="formSearch"
               :style='{"border":"1px solid #E0E0E0","padding":"10px","margin":"0 auto","alignItems":"center","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 20px)","height":"auto"}'
               class="list-form-pv">
        <el-form-item :style='{"margin":"0 5px 10px"}'>
          <div v-if="true"
               :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","color":"#000","display":"inline-block"}'
               class="lable">
            店铺名称：
          </div>
          <el-input v-model="formSearch.dianpumingcheng" clearable
                    placeholder="店铺名称" @keydown.enter.native="getList(1, curFenlei)"></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 5px 10px"}'>
          <div v-if="true"
               :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","color":"#000","display":"inline-block"}'
               class="lable">
            商品名称：
          </div>
          <el-input v-model="formSearch.shangpinmingcheng" clearable
                    placeholder="商品名称" @keydown.enter.native="getList(1, curFenlei)"></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 5px 10px"}'>
          <div v-if="true"
               :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","color":"#000","display":"inline-block"}'
               class="lable">
            品牌：
          </div>
          <el-input v-model="formSearch.pinpai" clearable placeholder="品牌"
                    @keydown.enter.native="getList(1, curFenlei)"></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 5px 10px"}'>
          <div v-if="true"
               :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","color":"#000","display":"inline-block"}'
               class="lable">
            价格：
          </div>
          <el-input v-model="formSearch.pricestart" clearable placeholder="最小价格"></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 5px 10px"}'>
          <el-input v-model="formSearch.priceend" clearable placeholder="最大价格"></el-input>
        </el-form-item>
        <el-button v-if=" true "
                   :style='{"cursor":"pointer","border":"0","padding":"0px 15px","margin":"0 10px 10px 0","outline":"none","color":"#fff","borderRadius":"0","background":"#3B2E7E","width":"auto","fontSize":"14px","lineHeight":"42px","height":"42px"}'
                   type="primary" @click="getList(1, curFenlei)"><i v-if="true"
                                                                    :style='{"color":"#fff","margin":"0 10px 0 0","fontSize":"14px"}'
                                                                    class="el-icon-search"></i>查询
        </el-button>
        <el-button v-if="btnAuth('shangpinxinxi','新增')"
                   :style='{"cursor":"pointer","border":"0","padding":"0px 15px","margin":"0 10px 10px 0","outline":"none","color":"#fff","borderRadius":"0","background":"#3B2E7E","width":"auto","fontSize":"14px","lineHeight":"42px","height":"42px"}'
                   type="primary" @click="add('/index/shangpinxinxiAdd')"><i v-if="true"
                                                                             :style='{"color":"#fff","margin":"0 10px 0 0","fontSize":"14px"}'
                                                                             class="el-icon-circle-plus-outline"></i>添加
        </el-button>
      </el-form>
      <div
          :style='{"padding":"10px 20px","borderColor":"#ddd","margin":"0 auto","background":"#fff","borderWidth":"0 1px 1px","width":"calc(100% - 20px)","borderStyle":"solid","height":"auto"}'
          class="select2">
        <div
            v-for="(item,index) in selectOptionsList"
            :key="item"
            :style='{"width":"100%","padding":"0","margin":"4px 0","position":"relative","background":"none","height":"auto"}'
            class="list">
          <div
              :style='{"padding":"0 5px","lineHeight":"32px","fontSize":"14px","color":"#3B2E7E","display":"inline-block"}'
              class="label">{{ item.name }}：
          </div>
          <div :style='{"width":"auto","flexWrap":"wrap","display":"inline-block","height":"auto"}' class="item-body">
            <div :class="item.check ==-1 ? 'active' : ''" class="item" @click="selectClick2(item,-1)">全部</div>
            <div v-for="item1,index1 in item.list" :key="item1" :class="item.check == index1 ? 'active' : ''"
                 class="item" @click="selectClick2(item,index1)">{{ item1 }}
            </div>
          </div>
        </div>
      </div>
      <div
          :style='{"border":"1px solid #E0E0E0","width":"calc(100% - 20px)","margin":"0 auto","borderWidth":"0 1px 1px","justifyContent":"flex-end","display":"flex"}'
          class="sort_view">
        <el-button :style='{"border":"0","padding":"0 5px","margin":"0 5px","borderRadius":"8px"}'
                   @click="sortClick('price')">
          <span v-if="sortType!='price'"
                :style='{"margin":"0 6px 0 0","lineHeight":"40px","fontSize":"15px","color":"#000"}'
                class="icon iconfont icon-chujia16"></span>
          <span v-else-if="sortType=='price'&&sortOrder=='desc'"
                :style='{"margin":"0 6px 0 0","lineHeight":"40px","fontSize":"15px","color":"#000"}'
                class="icon iconfont icon-jiantou35"></span>
          <span v-else-if="sortType=='price'&&sortOrder=='asc'"
                :style='{"margin":"0 6px 0 0","lineHeight":"40px","fontSize":"15px","color":"#000"}'
                class="icon iconfont icon-jiantou36"></span>
          <span :style='{"color":"#000","lineHeight":"40px","fontSize":"15px"}'>价格</span>
        </el-button>
        <el-button :style='{"border":"0","padding":"0 5px","margin":"0 5px","borderRadius":"8px"}'
                   @click="sortClick('storeupnum')">
          <span v-if="sortType!='storeupnum'"
                :style='{"margin":"0 2px 0 0","lineHeight":"40px","fontSize":"14px","color":"#333"}'
                class="icon iconfont icon-xiaoliang13"></span>
          <span v-else-if="sortType=='storeupnum'&&sortOrder=='desc'"
                :style='{"margin":"0 2px 0 0","lineHeight":"40px","fontSize":"14px","color":"#333"}'
                class="icon iconfont icon-jiantou35"></span>
          <span v-else-if="sortType=='storeupnum'&&sortOrder=='asc'"
                :style='{"margin":"0 2px 0 0","lineHeight":"40px","fontSize":"14px","color":"#333"}'
                class="icon iconfont icon-jiantou36"></span>
          <span :style='{"color":"#333","lineHeight":"40px","fontSize":"14px"}'>收藏数</span>
        </el-button>
      </div>
      <div :style='{"width":"100%","padding":"20px 0","margin":"0 0 10px","background":"#fff"}' class="list">
        <!-- 样式一 -->
        <div
            :style='{"width":"100%","padding":"0 10px","flexWrap":"wrap","background":"#fff","display":"block","height":"auto"}'
            class="list1 index-pv1">
          <div
              v-for="(item, index) in dataList"
              :key="index"
              :style='{"border":"1px solid #E0E0E0","padding":"45px 30px 15px","margin":"0","flexWrap":"wrap","background":"none","display":"inline-block","width":"25%","position":"relative","height":"auto"}'
              class="list-item animation-box"
              @click.stop="toDetail(item)">
            <img v-if="item.tupian && item.tupian.substr(0,4)=='http'"
                 :src="item.tupian.split(',')[0]"
                 :style='{"width":"100%","objectFit":"cover","display":"block","height":"275px","order":"1"}'
                 class="image" @click.stop="imgPreView(item.tupian)"/>
            <img v-else
                 :src="baseUrl + (item.tupian?item.tupian.split(',')[0]:'')"
                 :style='{"width":"100%","objectFit":"cover","display":"block","height":"275px","order":"1"}'
                 class="image" @click.stop="imgPreView(baseUrl + (item.tupian?item.tupian.split(',')[0]:''))"/>
            <div v-if="item.price"
                 :style='{"padding":"0 10px","color":"#fff","textAlign":"center","background":"#C61C14","width":"100%","lineHeight":"60px","fontSize":"16px","order":"2"}'
                 class="price"><span :style='{"fontSize":"12px"}'>￥</span>{{ item.price }}
            </div>
            <div
                :style='{"padding":"10px 0","color":"#444","textAlign":"center","width":"100%","lineHeight":"1.5","fontSize":"20px","fontWeight":"bold","order":"3"}'
                class="name ">{{ item.shangpinmingcheng }}
            </div>
            <div
                :style='{"padding":"10px 0","color":"#444","textAlign":"center","width":"100%","lineHeight":"1.5","fontSize":"20px","fontWeight":"bold","order":"3"}'
                class="name ">{{ item.shangpinfenlei }}
            </div>
            <div
                :style='{"padding":"10px 0","color":"#444","textAlign":"center","width":"100%","lineHeight":"1.5","fontSize":"20px","fontWeight":"bold","order":"3"}'
                class="name ">{{ item.pinpai }}
            </div>
            <div :style='{"width":"auto","padding":"10px 10px 0","textAlign":"center","order":"8"}'>
              <span :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#909090"}'
                    class="icon iconfont icon-shijian21"></span>
              <span :style='{"color":"#909090","lineHeight":"1.5","fontSize":"14px"}'
                    class="text">{{ item.addtime }}</span>
            </div>
            <div
                :style='{"width":"40%","padding":"10px 10px 0 ","textAlign":"center","display":"inline-block","order":"7"}'>
              <span :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#909090"}'
                    class="icon iconfont icon-geren16"></span>
              <span :style='{"color":"#909090","lineHeight":"1.5","fontSize":"14px"}'
                    class="text">{{ item.dianpumingcheng }}</span>
            </div>
            <div
                :style='{"width":"calc(100% / 3)","padding":"0 10px","textAlign":"center","display":"inline-block","order":"5"}'>
              <span :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"14px","color":"#909090"}'
                    class="icon iconfont icon-shoucang10"></span>
              <span :style='{"color":"#909090","lineHeight":"1.5","fontSize":"14px"}'
                    class="text">{{ item.storeupnum }}</span>
            </div>
          </div>
        </div>

      </div>


      <el-pagination
          id="pagination"
          :hide-on-single-page="true"
          :layout='["prev","pager","next"].join()'
          :page-size="pageSize"
          :pager-count="7"
          :style='{"padding":"0","margin":"10px auto","whiteSpace":"nowrap","color":"#333","textAlign":"center","width":"1200px","fontWeight":"500"}'
          :total="total"
          background
          class="pagination"
          next-text="下一页"
          prev-text="上一页"
          @current-change="curChange"
          @size-change="sizeChange"
          @prev-click="prevClick"
          @next-click="nextClick"
      ></el-pagination>

    </div>
    <el-dialog :visible.sync="previewVisible" title="预览图" width="50%">
      <img :src="previewImg" alt="" style="width: 100%;">
    </el-dialog>
  </div>
</template>

<script>
export default {
  //数据集合
  data() {
    return {
      selectIndex2: 0,
      selectOptionsList: [],
      layouts: '',
      swiperIndex: -1,
      baseUrl: '',
      breadcrumbItem: [
        {
          name: '商品信息'
        }
      ],
      formSearch: {
        dianpumingcheng: '',
        shangpinmingcheng: '',
        pinpai: '',
        price: '',
      },
      fenlei: [],
      feileiColumn: '',
      dataList: [],
      total: 1,
      pageSize: 10,
      totalPage: 1,
      curFenlei: '全部',
      isPlain: false,
      indexQueryCondition: '',
      timeRange: [],
      centerType: false,
      previewImg: '',
      previewVisible: false,
      sortType: 'id',
      sortOrder: 'desc',
    }
  },
  created() {
    if (this.$route.query.centerType) {
      this.centerType = true
    }
    this.baseUrl = this.$config.baseUrl;
    this.getFenlei();
    this.getList(1, '全部');
  },
  mounted() {
    window.addEventListener('scroll', function () {
      let leftBar = document.querySelector('.category-3')
      let goToTop = document.querySelector('.goToTop')
      console.log(window.pageYOffset)
      if (window.pageYOffset >= 668) {
        leftBar.style.position = 'fixed'
        leftBar.style.top = '0px'
        goToTop.style.display = ''
      }
      else {
        leftBar.style.position = 'absolute'
        leftBar.style.top = 668 + 'px'
        goToTop.style.display = 'none'
      }

    })
  },
  //方法集合
  methods: {
    selectClick2(row, index) {
      row.check = index
      if (index == -1) {
        this.formSearch[row.tableName] = ''
      }
      else {
        this.formSearch[row.tableName] = row.list[index]
      }
      this.getList()
    },
    add(path) {
      let query = {}
      if (this.centerType) {
        query.centerType = 1
      }
      this.$router.push({path: path, query: query});
    },
    getFenlei() {
      this.$http.get('shangpinfenlei/list', {}).then(res => {
        if (res.data.code == 0) {
          this.fenlei = res.data.data.list
        }
      });
      this.feileiColumn = 'shangpinfenlei'
    },
    getList(page, fenlei, ref = '') {
      if (fenlei == '全部') this.swiperIndex = -1;
      for (let i = 0; i < this.fenlei.length; i++) {
        if (fenlei == this.fenlei[i][this.feileiColumn]) {
          this.swiperIndex = i;
          break;
        }
      }
      if (fenlei) {
        this.curFenlei = fenlei;
      }
      // if (this.curFenlei == '全部') {
      //   this.isPlain = false;
      // } else {
      //   this.isPlain = true;
      // }
      let params = {page, limit: this.pageSize};
      let searchWhere = {};
      if (this.formSearch.dianpumingcheng != '') searchWhere.dianpumingcheng = '%' + this.formSearch.dianpumingcheng + '%';
      if (this.formSearch.shangpinmingcheng != '') searchWhere.shangpinmingcheng = '%' + this.formSearch.shangpinmingcheng + '%';
      if (this.formSearch.pinpai != '') searchWhere.pinpai = '%' + this.formSearch.pinpai + '%';
      if (this.formSearch.pricestart != '' && this.formSearch.pricestart != undefined) {
        searchWhere.pricestart = this.formSearch.pricestart
      }
      if (this.formSearch.priceend != '' && this.formSearch.priceend != undefined) {
        searchWhere.priceend = this.formSearch.priceend
      }
      if (this.curFenlei != '全部') searchWhere.shangpinfenlei = this.curFenlei;
      let user = JSON.parse(localStorage.getItem('sessionForm'))
      if (this.sortType) searchWhere.sort = this.sortType
      if (this.sortOrder) searchWhere.order = this.sortOrder
      this.$http.get(`shangpinxinxi/${this.centerType ? 'page' : 'list'}`, {params: Object.assign(params, searchWhere)}).then(res => {
        if (res.data.code == 0) {
          this.dataList = res.data.data.list;
          this.total = Number(res.data.data.total);
          this.pageSize = Number(res.data.data.pageSize);
          this.totalPage = res.data.data.totalPage;
        }
      });
    },
    sortClick(type) {
      if (this.sortType == type) {
        if (this.sortOrder == 'desc') {
          this.sortOrder = 'asc'
        }
        else {
          this.sortOrder = 'desc'
        }
      }
      else {
        this.sortType = type
        this.sortOrder = 'desc'
      }
      this.getList(1, '全部')
    },
    curChange(page) {
      this.getList(page, this.curFenlei);
    },
    prevClick(page) {
      this.getList(page, this.curFenlei);
    },
    sizeChange(size) {
      this.pageSize = size
      this.getList(1, this.curFenlei);
    },
    nextClick(page) {
      this.getList(page, this.curFenlei);
    },
    imgPreView(url) {
      this.previewImg = url
      this.previewVisible = true
    },
    toDetail(item) {
      let params = {
        id: item.id
      }
      if (this.centerType) {
        params.centerType = 1
      }
      this.$router.push({path: '/index/shangpinxinxiDetail', query: params});
    },
    btnAuth(tableName, key) {
      if (this.centerType) {
        return this.isBackAuth(tableName, key)
      }
      else {
        return this.isAuth(tableName, key)
      }
    },
    backClick() {
      this.$router.push({path: '/index/center'});
    },
  }
}
</script>

<style lang="scss" rel="stylesheet/scss" scoped>
.list-preview .list-form-pv .el-input {
  width: auto;
}

.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__separator {
  margin: 0 20px;
  color: #000;
  font-weight: bold;
}

.breadcrumb-preview .el-breadcrumb .item1 /deep/ .el-breadcrumb__inner a {
  color: #000;
  display: inline-block;
}

.breadcrumb-preview .el-breadcrumb .item2 /deep/ .el-breadcrumb__inner a {
  color: #000;
  display: inline-block;
}

.category-1 .item {
  cursor: pointer;
  border-radius: 4px;
  margin: 0 10px 0 0;
  color: #999;
  background: #efefef;
  width: 72px;
  font-size: 14px;
  line-height: 36px;
  text-align: center;
}

.category-1 .item:hover {
  cursor: pointer;
  border-radius: 4px;
  margin: 0 10px 0 0;
  color: #999;
  background: #000;
  width: 72px;
  font-size: 14px;
  line-height: 36px;
  text-align: center;
}

.category-1 .item.active {
  cursor: pointer;
  border-radius: 4px;
  margin: 0 10px 0 0;
  color: #999;
  background: #000;
  width: 72px;
  font-size: 14px;
  line-height: 36px;
  text-align: center;
}

.category-2 .item {
  cursor: pointer;
  border-radius: 4px;
  margin: 0 0 10px 0;
  color: #999;
  background: #efefef;
  width: 100%;
  font-size: 14px;
  line-height: 36px;
  text-align: center;
}

.category-2 .item:hover {
  cursor: pointer;
  border-radius: 4px;
  margin: 0 0 10px 0;
  color: #999;
  background: #efefef;
  width: 100%;
  font-size: 14px;
  line-height: 36px;
  text-align: center;
}

.category-2 .item.active {
  cursor: pointer;
  border-radius: 4px;
  margin: 0 0 10px 0;
  color: #999;
  background: #efefef;
  width: 100%;
  font-size: 14px;
  line-height: 36px;
  text-align: center;
}

.category-3 .item {
  cursor: pointer;
  border-radius: 0;
  padding: 5px 0;
  margin: 0 0 0;
  color: #000;
  background: none;
  display: flex;
  width: 100%;
  justify-content: center;
  align-items: center;
  height: 80px;
}

.category-3 .item:hover {
  border-radius: 0;
  margin: 0 0 0;
  color: #fff;
  background: rgb(198, 28, 20);
  width: 100%;
  height: 80px;
}

.category-3 .item.active {
  border-radius: 0;
  margin: 0;
  color: #fff;
  background: #3B2E7E;
  width: 100%;
  height: 80px;
}

.list-form-pv .el-input /deep/ .el-input__inner {
  border: 1px solid #C7C7C7;
  border-radius: 0;
  padding: 0 10px;
  margin: 0;
  outline: none;
  color: #000;
  width: 140px;
  font-size: 14px;
  line-height: 42px;
  height: 42px;
}

.list-form-pv .el-select /deep/ .el-input__inner {
}

.list-form-pv .el-date-editor /deep/ .el-input__inner {
  border: 1px solid #C7C7C7;
  border-radius: 0;
  padding: 0 30px;
  margin: 0;
  outline: none;
  color: #000;
  width: 160px;
  font-size: 14px;
  line-height: 42px;
  height: 42px;
}

.list .index-pv1 .animation-box {
  transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
  z-index: initial;
}

.list .index-pv1 .animation-box:hover {
  transform: rotate(0deg) scale(1) skew(0deg, 2deg) translate3d(0px, 0px, 0px);
  -webkit-perspective: 1000px;
  perspective: 1000px;
  transition: 0.3s;
  z-index: 1;
}

.list .index-pv1 .animation-box img {
  transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
}

.list .index-pv1 .animation-box img:hover {
  transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
  -webkit-perspective: 1000px;
  perspective: 1000px;
  transition: 0.3s;
}

#pagination.el-pagination /deep/ .el-pagination__total {
  margin: 0 10px 0 0;
  color: #666;
  font-weight: 400;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

#pagination.el-pagination /deep/ .btn-prev {
  border: none;
  padding: 0 20px;
  margin: 0 5px;
  color: #666;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  border-radius: 0;
  box-shadow: 0px 4px 10px 0px rgba(0, 0, 0, 0.3);
  background: #f4f4f5;
  min-width: 35px;
  height: 28px;
}

#pagination.el-pagination /deep/ .btn-next {
  border: none;
  padding: 0 20px;
  margin: 0 5px;
  color: #666;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  border-radius: 0;
  box-shadow: 0px 4px 10px 0px rgba(0, 0, 0, 0.3);
  background: #f4f4f5;
  min-width: 35px;
  height: 28px;
}

#pagination.el-pagination /deep/ .btn-prev:disabled {
  border: none;
  cursor: not-allowed;
  padding: 0 20px;
  margin: 0 5px;
  color: #C0C4CC;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  border-radius: 0;
  box-shadow: 0px 4px 10px 0px rgba(0, 0, 0, 0.3);
  background: #f4f4f5;
  height: 28px;
}

#pagination.el-pagination /deep/ .btn-next:disabled {
  border: none;
  cursor: not-allowed;
  padding: 0 20px;
  margin: 0 5px;
  color: #C0C4CC;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  border-radius: 0;
  box-shadow: 0px 4px 10px 0px rgba(0, 0, 0, 0.3);
  background: #f4f4f5;
  height: 28px;
}

#pagination.el-pagination /deep/ .el-pager {
  padding: 0;
  margin: 0;
  display: inline-block;
  vertical-align: top;
}

#pagination.el-pagination /deep/ .el-pager .number {
  cursor: pointer;
  padding: 0 4px;
  margin: 0 5px;
  color: #666;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  border-radius: 0;
  box-shadow: 0px 4px 10px 0px rgba(0, 0, 0, 0.3);
  background: #f4f4f5;
  text-align: center;
  min-width: 30px;
  height: 28px;
}

#pagination.el-pagination /deep/ .el-pager .number:hover {
  cursor: pointer;
  padding: 0 4px;
  margin: 0 5px;
  color: #ffff;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  border-radius: 0;
  box-shadow: 0px 4px 10px 0px rgba(0, 0, 0, 0.3);
  background: #3B2E7E;
  text-align: center;
  min-width: 30px;
  height: 28px;
}

#pagination.el-pagination /deep/ .el-pager .number.active {
  cursor: default;
  padding: 0 4px;
  margin: 0 5px;
  color: #FFF;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  border-radius: 0;
  box-shadow: 0px 4px 10px 0px rgba(0, 0, 0, 0.3);
  background: #3B2E7E;
  text-align: center;
  min-width: 30px;
  height: 28px;
}

#pagination.el-pagination /deep/ .el-pagination__sizes {
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

#pagination.el-pagination /deep/ .el-pagination__sizes .el-input {
  margin: 0 5px;
  width: 100px;
  position: relative;
}

#pagination.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
  border: 1px solid #DCDFE6;
  cursor: pointer;
  padding: 0 25px 0 8px;
  color: #606266;
  display: inline-block;
  font-size: 13px;
  line-height: 28px;
  border-radius: 3px;
  outline: 0;
  background: #FFF;
  width: 100%;
  text-align: center;
  height: 28px;
}

#pagination.el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
  top: 0;
  position: absolute;
  right: 0;
  height: 100%;
}

#pagination.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
  cursor: pointer;
  color: #C0C4CC;
  width: 25px;
  font-size: 14px;
  line-height: 28px;
  text-align: center;
}

#pagination.el-pagination /deep/ .el-pagination__jump {
  margin: 0 0 0 24px;
  color: #606266;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

#pagination.el-pagination /deep/ .el-pagination__jump .el-input {
  border-radius: 3px;
  padding: 0 2px;
  margin: 0 2px;
  display: inline-block;
  width: 50px;
  font-size: 14px;
  line-height: 18px;
  position: relative;
  text-align: center;
  height: 28px;
}

#pagination.el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
  border: 1px solid #DCDFE6;
  cursor: pointer;
  padding: 0 3px;
  color: #606266;
  display: inline-block;
  font-size: 14px;
  line-height: 28px;
  border-radius: 3px;
  outline: 0;
  background: #FFF;
  width: 100%;
  text-align: center;
  height: 28px;
}


.select2 .list .item-body .item {
  border-radius: 4px;
  padding: 0 10px;
  color: #333;
  background: none;
  display: inline-block;
  font-size: 14px;
  line-height: 32px;
}

.select2 .list .item-body .item:hover {
  color: #fff;
  background: #3B2E7E;
}

.select2 .list .item-body .item.active {
  color: #fff;
  background: #3B2E7E;
  display: inline-block;
}
</style>
