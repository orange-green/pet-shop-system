<template>
<div :style='{"width":"80%","padding":"20px","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3)","margin":"10px auto","position":"relative","background":"#fff"}'>
    <el-form
	  :style='{"width":"100%","position":"relative","flexWrap":"wrap","display":"flex"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
          <el-form-item :style='{"width":"50%","padding":"10px","margin":"0 0 10px","background":"none"}' label="店铺名称" prop="dianpumingcheng">
            <el-input v-model="ruleForm.dianpumingcheng"
                placeholder="店铺名称" clearable :disabled=" false  ||ro.dianpumingcheng"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"50%","padding":"10px","margin":"0 0 10px","background":"none"}' label="账号" prop="zhanghao">
            <el-input v-model="ruleForm.zhanghao"
                placeholder="账号" clearable :disabled=" false  ||ro.zhanghao"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"50%","padding":"10px","margin":"0 0 10px","background":"none"}' label="姓名" prop="yishixingming">
            <el-input v-model="ruleForm.yishixingming"
                placeholder="姓名" clearable :disabled=" false  ||ro.yishixingming"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"50%","padding":"10px","margin":"0 0 10px","background":"none"}' label="密码" prop="mima">
            <el-input v-model="ruleForm.mima"
                placeholder="密码" clearable :disabled=" false  ||ro.mima"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"50%","padding":"10px","margin":"0 0 10px","background":"none"}'  label="性别" prop="xingbie">
            <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" :disabled=" false  ||ro.xingbie" >
              <el-option
                  v-for="(item,index) in xingbieOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"50%","padding":"10px","margin":"0 0 10px","background":"none"}' label="头像" v-if="type!='cross' || (type=='cross' && !ro.touxiang)" prop="touxiang">
            <file-upload
            tip="点击上传头像"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
            @change="touxiangUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"width":"50%","padding":"10px","margin":"0 0 10px","background":"none"}' class="upload" v-else label="头像" prop="touxiang">
                <img v-if="ruleForm.touxiang.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.touxiang.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.touxiang.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"width":"50%","padding":"10px","margin":"0 0 10px","background":"none"}' label="年龄" prop="nianling">
            <el-input v-model.number="ruleForm.nianling"
                placeholder="年龄" clearable :disabled=" false  ||ro.nianling"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"50%","padding":"10px","margin":"0 0 10px","background":"none"}'  label="职位" prop="zhiwei">
            <el-select v-model="ruleForm.zhiwei" placeholder="请选择职位" :disabled=" false  ||ro.zhiwei" >
              <el-option
                  v-for="(item,index) in zhiweiOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"50%","padding":"10px","margin":"0 0 10px","background":"none"}' label="电话" prop="dianhua">
            <el-input v-model="ruleForm.dianhua"
                placeholder="电话" clearable :disabled=" false  ||ro.dianhua"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"50%","padding":"10px","margin":"0 0 10px","background":"none"}' label="邮箱" prop="youxiang">
            <el-input v-model="ruleForm.youxiang"
                placeholder="邮箱" clearable :disabled=" false  ||ro.youxiang"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"50%","padding":"10px","margin":"0 0 10px","background":"none"}' label="个人简介" prop="gerenjianjie">
            <editor
                :style='{"padding":"0","boxShadow":"none","margin":"0","borderColor":"#ccc","backgroundColor":"#fff","borderRadius":"0","borderWidth":"0","width":"500px","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.gerenjianjie"
                class="editor"
                action="file/upload">
            </editor>
          </el-form-item>
          <el-form-item :style='{"width":"50%","padding":"10px","margin":"0 0 10px","background":"none"}' label="地址" prop="fulladdress">
            <el-input v-model="ruleForm.fulladdress"
                placeholder="请选择地址" readonly @click.native="openMapDiolag"></el-input>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#3B2E7E","width":"auto","lineHeight":"30px","fontSize":"14px","height":"30px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0","outline":"none","color":"#000","borderRadius":"4px","background":"#9E9E9E","width":"auto","lineHeight":"30px","fontSize":"14px","height":"30px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    <el-dialog width="50%" title="坐标查询" :visible.sync="mapVisiable" append-to-body>
    	<el-amap-search-box class="search-box" :on-search-result="onSearchResult"
    		:search-option="searchOption"></el-amap-search-box>
    	<div class="amap-wrapper">
    		<el-amap class="amap-box" :vid="'amap-vue'" :center="center" :zoom="zoom" :plugin="plugin"
    			:events="events">
    			<el-amap-marker v-bind:key="marker" v-for="marker in markers" :position="marker"></el-amap-marker>
    		</el-amap>
    	</div>
    	<div>坐标：[{{ ruleForm.longitude }}, {{ ruleForm.latitude }}],地址：{{ruleForm.fulladdress}}</div>
    </el-dialog>
</div>
</template>

<script>
  export default {
    data() {
	  let self = this
      return {
        id: '',
        baseUrl: '',
        ro:{
				dianpumingcheng : false,
				zhanghao : false,
				yishixingming : false,
				mima : false,
				xingbie : false,
				touxiang : false,
				nianling : false,
				zhiwei : false,
				dianhua : false,
				youxiang : false,
				gerenjianjie : false,
				clicktime : false,
				clicknum : false,
				discussnum : false,
				userid : false,
				storeupnum : false,
				longitude : false,
				latitude : false,
				fulladdress : false,
				money : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          dianpumingcheng: '',
          zhanghao: '',
          yishixingming: '',
          mima: '',
          xingbie: '',
          touxiang: '',
          nianling: '',
          zhiwei: '',
          dianhua: '',
          youxiang: '',
          gerenjianjie: '',
          clicktime: '',
          clicknum: '',
          discussnum: '',
          userid: '',
          storeupnum: '',
          longitude: '',
          latitude: '',
          fulladdress: '',
          money: '',
        },
        xingbieOptions: [],
        zhiweiOptions: [],


        rules: {
          dianpumingcheng: [
          ],
          zhanghao: [
            { required: true, message: '账号不能为空', trigger: 'blur' },
          ],
          yishixingming: [
            { required: true, message: '姓名不能为空', trigger: 'blur' },
          ],
          mima: [
            { required: true, message: '密码不能为空', trigger: 'blur' },
          ],
          xingbie: [
          ],
          touxiang: [
          ],
          nianling: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          zhiwei: [
            { required: true, message: '职位不能为空', trigger: 'blur' },
          ],
          dianhua: [
            { validator: this.$validate.isMobile, trigger: 'blur' },
          ],
          youxiang: [
            { validator: this.$validate.isEmail, trigger: 'blur' },
          ],
          gerenjianjie: [
          ],
          clicktime: [
          ],
          clicknum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          discussnum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          userid: [
          ],
          storeupnum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          longitude: [
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          latitude: [
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          fulladdress: [
          ],
          money: [
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
        },
        // 地图
        mapVisiable: false,
        zoom: 12,
        center: [116.410426, 39.934946],
        markers: [],
        searchOption: {
        	citylimit: false
        },
        plugin: [{
        	// 定位城市
        	pName: "CitySearch",
        	events: {
        		init(o) {
        			// o是高德地图定位插件实例
        			o.getLocalCity(function(status, result) {
        				if (status === "complete" && result.info === "OK") {
        					console.log(result)
        					// 查询成功，result即为当前所在城市信息
        					self.center = [Number(result.rectangle.split(';')[0].split(',')[0]),
        						Number(result.rectangle.split(';')[0].split(',')[1])
        					];
        					console.log(self.center)
        				}
        			});
        		}
        	}
        }, ],
        events: {
        	click(e) {
        		console.log(e)
        		let {
        			lng,
        			lat
        		} = e.lnglat
        		self.ruleForm.longitude = lng
        		self.ruleForm.latitude = lat
        		// 这里通过高德 SDK 完成。
        		/* eslint-disable */
        		var geocoder = new AMap.Geocoder({
        			radius: 1000,
        			extensions: 'all'
        		})
        		geocoder.getAddress([lng, lat], function(status, result) {
        			if (status === 'complete' && result.info === 'OK') {
        				if (result && result.regeocode) {
        					self.mapVisiable = false
        					self.ruleForm.fulladdress = result.regeocode.formattedAddress
        				}
        			}
        		})
        	}
        },
		centerType: false,
      };
    },
    computed: {



    },
    components: {
    },
    created() {
		if(this.$route.query.centerType){
			this.centerType = true
		}
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='dianpumingcheng'){
              this.ruleForm.dianpumingcheng = obj[o];
              this.ro.dianpumingcheng = true;
              continue;
            }
            if(o=='zhanghao'){
              this.ruleForm.zhanghao = obj[o];
              this.ro.zhanghao = true;
              continue;
            }
            if(o=='yishixingming'){
              this.ruleForm.yishixingming = obj[o];
              this.ro.yishixingming = true;
              continue;
            }
            if(o=='mima'){
              this.ruleForm.mima = obj[o];
              this.ro.mima = true;
              continue;
            }
            if(o=='xingbie'){
              this.ruleForm.xingbie = obj[o];
              this.ro.xingbie = true;
              continue;
            }
            if(o=='touxiang'){
              this.ruleForm.touxiang = obj[o].split(",")[0];
              this.ro.touxiang = true;
              continue;
            }
            if(o=='nianling'){
              this.ruleForm.nianling = obj[o];
              this.ro.nianling = true;
              continue;
            }
            if(o=='zhiwei'){
              this.ruleForm.zhiwei = obj[o];
              this.ro.zhiwei = true;
              continue;
            }
            if(o=='dianhua'){
              this.ruleForm.dianhua = obj[o];
              this.ro.dianhua = true;
              continue;
            }
            if(o=='youxiang'){
              this.ruleForm.youxiang = obj[o];
              this.ro.youxiang = true;
              continue;
            }
            if(o=='gerenjianjie'){
              this.ruleForm.gerenjianjie = obj[o];
              this.ro.gerenjianjie = true;
              continue;
            }
            if(o=='clicktime'){
              this.ruleForm.clicktime = obj[o];
              this.ro.clicktime = true;
              continue;
            }
            if(o=='clicknum'){
              this.ruleForm.clicknum = obj[o];
              this.ro.clicknum = true;
              continue;
            }
            if(o=='discussnum'){
              this.ruleForm.discussnum = obj[o];
              this.ro.discussnum = true;
              continue;
            }
            if(o=='userid'){
              this.ruleForm.userid = obj[o];
              this.ro.userid = true;
              continue;
            }
            if(o=='storeupnum'){
              this.ruleForm.storeupnum = obj[o];
              this.ro.storeupnum = true;
              continue;
            }
            if(o=='longitude'){
              this.ruleForm.longitude = obj[o];
              this.ro.longitude = true;
              continue;
            }
            if(o=='latitude'){
              this.ruleForm.latitude = obj[o];
              this.ro.latitude = true;
              continue;
            }
            if(o=='fulladdress'){
              this.ruleForm.fulladdress = obj[o];
              this.ro.fulladdress = true;
              continue;
            }
            if(o=='money'){
              this.ruleForm.money = obj[o];
              this.ro.money = true;

            }
          }
        }else if(type=='edit'){
			this.info()
		}
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if((json.dianpumingcheng!=''&&json.dianpumingcheng) || json.dianpumingcheng==0){
                this.ruleForm.dianpumingcheng = json.dianpumingcheng;
				this.ro.dianpumingcheng = true;
            }
          }
        });
        this.xingbieOptions = "男,女".split(',')
        this.zhiweiOptions = "宠物医生,美容技师".split(',')

		if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
			localStorage.removeItem('raffleType')
			setTimeout(() => {
				this.onSubmit()
			}, 300)
		}
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`yishi/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {
			//更新跨表属性
			var crossuserid;
			var crossrefid;
			var crossoptnum;
			this.$refs["ruleForm"].validate(valid => {
				if(valid) {
					if(this.type=='cross'){
						var statusColumnName = localStorage.getItem('statusColumnName');
						var statusColumnValue = localStorage.getItem('statusColumnValue');
						if(statusColumnName && statusColumnName!='') {
							var obj = JSON.parse(localStorage.getItem('crossObj'));
							if(!statusColumnName.startsWith("[")) {
								for (var o in obj){
									if(o==statusColumnName){
										obj[o] = statusColumnValue;
									}
								}
								var table = localStorage.getItem('crossTable');
								this.$http.post(table+'/update', obj).then(res => {});
							} else {
								crossuserid=Number(localStorage.getItem('frontUserid'));
								crossrefid=obj['id'];
								crossoptnum=localStorage.getItem('statusColumnName');
								crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
							}
						}
					}
					if(crossrefid && crossuserid) {
						this.ruleForm.crossuserid=crossuserid;
						this.ruleForm.crossrefid=crossrefid;
						var params = {
							page: 1,
							limit: 10,
							crossuserid:crossuserid,
							crossrefid:crossrefid,
						}
						this.$http.get('yishi/list', {
							params: params
						}).then(res => {
							if(res.data.data.total>=crossoptnum) {
								this.$message({
									message: localStorage.getItem('tips'),
									type: 'error',
									duration: 1500,
								});
								return false;
							} else {
								// 跨表计算


								this.$http.post(`yishi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
									if (res.data.code == 0) {
										this.$message({
											message: '操作成功',
											type: 'success',
											duration: 1500,
											onClose: () => {

											}
										});this.$router.go(-1);
									} else {
										this.$message({
											message: res.data.msg,
											type: 'error',
											duration: 1500
										});
									}
								});
							}
						});
					} else {


						this.$http.post(`yishi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {

									}
								});this.$router.go(-1);
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
							}
						});
					}
				}
			});
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		// 返回
		back() {
			this.$router.go(-1);
		},
      touxiangUploadChange(fileUrls) {
          this.ruleForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
      // 打开坐标定位窗口
      openMapDiolag() {
      	this.mapVisiable = true
      },
      // 查询
      onSearchResult(pois) {
      	let latSum = 0;
      	let lngSum = 0;
      	if (pois.length > 0) {
      		pois.forEach(poi => {
      			let {
      				lng,
      				lat
      			} = poi;
      			lngSum += lng;
      			latSum += lat;
      			this.markers.push([poi.lng, poi.lat]);
      		});
      		let center = {
      			lng: lngSum / pois.length,
      			lat: latSum / pois.length
      		};
      		this.center = [center.lng, center.lat];
      	}
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}

	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: 80px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}

	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 80px;
	}

	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 1px solid #DADADA;
	  border-radius: 0;
	  padding: 0 12px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  width: 400px;
	  font-size: 14px;
	  height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
	  border: 1px solid #DADADA;
	  border-radius: 0;
	  padding: 0 12px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  width: 400px;
	  font-size: 14px;
	  height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}

	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 1px solid #DADADA;
	  border-radius: 0;
	  padding: 0 10px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  width: 400px;
	  font-size: 14px;
	  height: 40px;
	}

	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 1px solid #DADADA;
	  border-radius: 0;
	  padding: 0 10px 0 30px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  width: 400px;
	  font-size: 14px;
	  height: 40px;
	}

	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}

	.add-update-preview /deep/ .upload .upload-img {
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

	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
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

	.add-update-preview /deep/ .el-upload .el-icon-plus {
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

	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #DADADA;
	  border-radius: 0;
	  padding: 12px;
	  box-shadow: none;
	  outline: none;
	  color: #000;
	  width: 400px;
	  font-size: 14px;
	  height: 120px;
	}
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
</style>
