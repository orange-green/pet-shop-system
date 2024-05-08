<template>
	<div>

	<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20231129/5956bf04b79948d7ad097c4c25324aef.png)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"flex-end"}'>
		<el-form class='rgs-form' v-if="pageFlag=='register'" :style='{"padding":"20px 20px 20px 300px","boxShadow":"none","margin":"0","alignItems":"center","flexDirection":"column","display":"flex","clipPath":"polygon(25% 0%, 100% 0, 100% 100%, 0% 100%)","justifyContent":"center","borderRadius":"10px","background":"rgba(255,255,255,.92)","width":"55%","backgroundSize":"cover","backgroundPosition":"right bottom","backgroundRepeat":"no-repeat","height":"100vh"}' ref="registerForm" :model="registerForm" :rules="rules">
			<div v-if="false" :style='{"margin":"0 0 10px 0","color":"rgba(64, 158, 255, 1)","textAlign":"center","width":"100%","lineHeight":"44px","fontSize":"20px","textShadow":"4px 4px 2px rgba(64, 158, 255, .5)"}'>USER / REGISTER</div>
			<div v-if="true" :style='{"margin":"0 0 10px 0","color":"#3B2E7E","textAlign":"center","width":"80%","lineHeight":"44px","fontSize":"24px","textShadow":"none","fontWeight":"bold"}'>安信宠物医疗美容系统注册</p></div>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yonghu'" prop="yonghuming">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('yonghuming')?'required':''">用户名：</div>
				<el-input v-model="registerForm.yonghuming"  placeholder="请输入用户名" />
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yonghu'" prop="mima">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('mima')?'required':''">密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yonghu'" prop="mima2">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('mima')?'required':''">确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yonghu'" prop="xingming">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('xingming')?'required':''">姓名：</div>
				<el-input v-model="registerForm.xingming"  placeholder="请输入姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yonghu'" prop="xingbie">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('xingbie')?'required':''">性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in yonghuxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yonghu'" prop="touxiang">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('touxiang')?'required':''">头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="yonghutouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yonghu'" prop="youxiang">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('youxiang')?'required':''">邮箱：</div>
				<el-input v-model="registerForm.youxiang"  placeholder="请输入邮箱" />
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yonghu'" prop="shouji">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('shouji')?'required':''">手机：</div>
				<el-input v-model="registerForm.shouji"  placeholder="请输入手机" />
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='shangjia'" prop="dianpumingcheng">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('dianpumingcheng')?'required':''">账号：</div>
				<el-input v-model="registerForm.dianpumingcheng"  placeholder="请输入账号" />
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='shangjia'" prop="mima">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('mima')?'required':''">密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='shangjia'" prop="mima2">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('mima')?'required':''">确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='shangjia'" prop="fuzeren">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('fuzeren')?'required':''">负责人：</div>
				<el-input v-model="registerForm.fuzeren"  placeholder="请输入负责人" />
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='shangjia'" prop="touxiang">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('touxiang')?'required':''">头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="shangjiatouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='shangjia'" prop="xingbie">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('xingbie')?'required':''">性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in shangjiaxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='shangjia'" prop="nianling">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('nianling')?'required':''">年龄：</div>
				<el-input v-model="registerForm.nianling"  placeholder="请输入年龄" />
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='shangjia'" prop="lianxidianhua">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('lianxidianhua')?'required':''">联系电话：</div>
				<el-input v-model="registerForm.lianxidianhua"  placeholder="请输入联系电话" />
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yishi'" prop="dianpumingcheng">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('dianpumingcheng')?'required':''">店铺名称：</div>
				<el-input v-model="registerForm.dianpumingcheng"  placeholder="请输入店铺名称" />
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yishi'" prop="zhanghao">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('zhanghao')?'required':''">账号：</div>
				<el-input v-model="registerForm.zhanghao"  placeholder="请输入账号" />
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yishi'" prop="yishixingming">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('yishixingming')?'required':''">姓名：</div>
				<el-input v-model="registerForm.yishixingming"  placeholder="请输入姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yishi'" prop="mima">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('mima')?'required':''">密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yishi'" prop="mima2">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('mima')?'required':''">确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yishi'" prop="xingbie">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('xingbie')?'required':''">性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in yishixingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yishi'" prop="touxiang">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('touxiang')?'required':''">头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="yishitouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yishi'" prop="nianling">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('nianling')?'required':''">年龄：</div>
				<el-input v-model.number="registerForm.nianling"  placeholder="请输入年龄" />
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yishi'" prop="zhiwei">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('zhiwei')?'required':''">职位：</div>
                <el-select v-model="registerForm.zhiwei" placeholder="请选择职位" >
                  <el-option
                      v-for="(item,index) in yishizhiweiOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"550px","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yishi'" prop="gerenjianjie">
				<div v-if="true" :style='{"width":"100px","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#3B2E7E"}' :class="changeRules('gerenjianjie')?'required':''">个人简介：</div>
			    <editor
			        :style='{"width":"450px","height":"auto"}'
			        v-model="registerForm.gerenjianjie"
			        class="editor"
			        action="file/upload">
			    </editor>
			</el-form-item>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","boxShadow":"none","margin":"20px auto 5px","color":"#fff","display":"block","outline":"none","borderRadius":"30px","background":"#3B2E7E","width":"550px","fontSize":"36px","height":"60px"}' type="primary" @click="submitForm('registerForm')">注册</el-button>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","boxShadow":"0 0 6px rgba(64, 158, 255, .5)","margin":"20px auto 5px","color":"#fff","display":"none","outline":"none","borderRadius":"8px","background":"rgba(64, 158, 255, 1)","width":"80%","fontSize":"16px","height":"44px"}' @click="resetForm('registerForm')">重置</el-button>
			<router-link :style='{"cursor":"pointer","padding":"0 10%","color":"#9e9e9e","display":"inline-block","lineHeight":"3","fontSize":"12px","textDecoration":"none"}' to="/login">已有账户登录</router-link>
			<div class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"40px"}'></div>
			<div class="idea2" :style='{"width":"100%","background":"blue","display":"none","height":"40px"}'></div>
		</el-form>
    </div>
  </div>
</div>
</template>

<script>

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {},
			forgetForm: {},
			rules: {},
			requiredRules: {},
            yonghuxingbieOptions: [],
            shangjiaxingbieOptions: [],
            yishixingbieOptions: [],
            yishizhiweiOptions: [],
		}
    },
	mounted() {
		if(this.$route.query.pageFlag=='register'){
			this.tableName = this.$route.query.role;
			if(this.tableName=='yonghu'){
				this.registerForm = {
					yonghuming: '',
					mima: '',
					mima2: '',
					xingming: '',
					xingbie: '',
					touxiang: '',
					youxiang: '',
					shouji: '',
					money: '',
					status: '',
				}
			}
			if(this.tableName=='shangjia'){
				this.registerForm = {
					dianpumingcheng: '',
					mima: '',
					mima2: '',
					fuzeren: '',
					touxiang: '',
					xingbie: '',
					nianling: '',
					lianxidianhua: '',
					money: '',
					status: '',
				}
			}
			if(this.tableName=='yishi'){
				this.registerForm = {
					dianpumingcheng: '',
					zhanghao: '',
					yishixingming: '',
					mima: '',
					mima2: '',
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
				}
			}
			if ('yonghu' == this.tableName) {
				this.requiredRules.yonghuming = [{ required: true, message: '请输入用户名', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('shangjia' == this.tableName) {
				this.requiredRules.dianpumingcheng = [{ required: true, message: '请输入账号', trigger: 'blur' }]
			}
			if ('shangjia' == this.tableName) {
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('shangjia' == this.tableName) {
				this.requiredRules.fuzeren = [{ required: true, message: '请输入负责人', trigger: 'blur' }]
			}
			if ('yishi' == this.tableName) {
				this.requiredRules.zhanghao = [{ required: true, message: '请输入账号', trigger: 'blur' }]
			}
			if ('yishi' == this.tableName) {
				this.requiredRules.yishixingming = [{ required: true, message: '请输入姓名', trigger: 'blur' }]
			}
			if ('yishi' == this.tableName) {
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yishi' == this.tableName) {
				this.requiredRules.zhiwei = [{ required: true, message: '请输入职位', trigger: 'blur' }]
			}
		}
	},
    created() {
		this.pageFlag = this.$route.query.pageFlag;
		if(this.$route.query.pageFlag=='register'){
		  if ('yonghu' == this.tableName) {
			this.rules.yonghuming = [{ required: true, message: '请输入用户名', trigger: 'blur' }];
		  }
		  if ('yonghu' == this.tableName) {
			this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
		  }
			this.yonghuxingbieOptions = "男,女".split(',');
		  if ('yonghu' == this.tableName) {
			this.rules.youxiang = [{ required: true, validator: this.$validate.isEmail, trigger: 'blur' }];
		  }
		  if ('yonghu' == this.tableName) {
			this.rules.shouji = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
		  }
		  if ('yonghu' == this.tableName) {
			this.rules.money = [{ required: true, validator: this.$validate.isNumber, trigger: 'blur' }];
		  }
		  if ('yonghu' == this.tableName) {
			this.rules.status = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
		  }
		  if ('shangjia' == this.tableName) {
			this.rules.dianpumingcheng = [{ required: true, message: '请输入账号', trigger: 'blur' }];
		  }
		  if ('shangjia' == this.tableName) {
			this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
		  }
		  if ('shangjia' == this.tableName) {
			this.rules.fuzeren = [{ required: true, message: '请输入负责人', trigger: 'blur' }];
		  }
			this.shangjiaxingbieOptions = "男,女".split(',');
		  if ('shangjia' == this.tableName) {
			this.rules.lianxidianhua = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
		  }
		  if ('shangjia' == this.tableName) {
			this.rules.money = [{ required: true, validator: this.$validate.isNumber, trigger: 'blur' }];
		  }
		  if ('shangjia' == this.tableName) {
			this.rules.status = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
		  }
		  if ('yishi' == this.tableName) {
			this.rules.zhanghao = [{ required: true, message: '请输入账号', trigger: 'blur' }];
		  }
		  if ('yishi' == this.tableName) {
			this.rules.yishixingming = [{ required: true, message: '请输入姓名', trigger: 'blur' }];
		  }
		  if ('yishi' == this.tableName) {
			this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
		  }
			this.yishixingbieOptions = "男,女".split(',');
		  if ('yishi' == this.tableName) {
			this.rules.nianling = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
		  }
			this.yishizhiweiOptions = "宠物医生,美容技师".split(',');
		  if ('yishi' == this.tableName) {
			this.rules.zhiwei = [{ required: true, message: '请输入职位', trigger: 'blur' }];
		  }
		  if ('yishi' == this.tableName) {
			this.rules.clicknum = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
		  }
		  if ('yishi' == this.tableName) {
			this.rules.discussnum = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
		  }
		  if ('yishi' == this.tableName) {
			this.rules.storeupnum = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
		  }
		  if ('yishi' == this.tableName) {
			this.rules.longitude = [{ required: true, validator: this.$validate.isNumber, trigger: 'blur' }];
		  }
		  if ('yishi' == this.tableName) {
			this.rules.latitude = [{ required: true, validator: this.$validate.isNumber, trigger: 'blur' }];
		  }
		  if ('yishi' == this.tableName) {
			this.rules.money = [{ required: true, validator: this.$validate.isNumber, trigger: 'blur' }];
		  }
		}
    },
    //方法集合
    methods: {
		changeRules(name){
			if(this.requiredRules[name]){
				return true
			}
			return false
		},
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
        // 下二随
      yonghutouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
      shangjiatouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
      yishitouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },

        // 多级联动参数


      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            var url=this.tableName+"/register";
				if((!this.registerForm.yonghuming) && `yonghu` == this.tableName){
					this.$message.error(`用户名不能为空`);
					return
				}
               if(`yonghu` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
				if((!this.registerForm.mima) && `yonghu` == this.tableName){
					this.$message.error(`密码不能为空`);
					return
				}
					if(`yonghu` == this.tableName && this.registerForm.youxiang &&(!this.$validate.isEmail2(this.registerForm.youxiang))){
						this.$message.error(`邮箱应输入邮件格式`);
						return
					}
					if(`yonghu` == this.tableName && this.registerForm.shouji &&(!this.$validate.isMobile2(this.registerForm.shouji))){
						this.$message.error(`手机应输入手机格式`);
						return
					}
				if((!this.registerForm.dianpumingcheng) && `shangjia` == this.tableName){
					this.$message.error(`账号不能为空`);
					return
				}
               if(`shangjia` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
				if((!this.registerForm.mima) && `shangjia` == this.tableName){
					this.$message.error(`密码不能为空`);
					return
				}
				if((!this.registerForm.fuzeren) && `shangjia` == this.tableName){
					this.$message.error(`负责人不能为空`);
					return
				}
					if(`shangjia` == this.tableName && this.registerForm.lianxidianhua &&(!this.$validate.isMobile2(this.registerForm.lianxidianhua))){
						this.$message.error(`联系电话应输入手机格式`);
						return
					}
				if((!this.registerForm.zhanghao) && `yishi` == this.tableName){
					this.$message.error(`账号不能为空`);
					return
				}
				if((!this.registerForm.yishixingming) && `yishi` == this.tableName){
					this.$message.error(`姓名不能为空`);
					return
				}
               if(`yishi` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
				if((!this.registerForm.mima) && `yishi` == this.tableName){
					this.$message.error(`密码不能为空`);
					return
				}
				if(`yishi` == this.tableName && this.registerForm.nianling &&(!this.$validate.isIntNumer2(this.registerForm.nianling))){
					this.$message.error(`年龄应输入整数`);
					return
				}
				if((!this.registerForm.zhiwei) && `yishi` == this.tableName){
					this.$message.error(`职位不能为空`);
					return
				}
				if(`yishi` == this.tableName && this.registerForm.longitude &&(!this.$validate.isNumber2(this.registerForm.longitude))){
					this.$message.error(`经度应输入数字`);
					return
				}
				if(`yishi` == this.tableName && this.registerForm.latitude &&(!this.$validate.isNumber2(this.registerForm.latitude))){
					this.$message.error(`纬度应输入数字`);
					return
				}
            this.$http.post(url, this.registerForm).then(res => {
              if (res.data.code === 0) {
                this.$message({
                  message: '注册成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.$router.push('/login');
                  }
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background: url(http://codegen.caihongy.cn/20231129/5956bf04b79948d7ad097c4c25324aef.png);

		.el-input {
		  width: auto;
		}

		.el-date-editor.el-input {
			width: auto;
		}

		.el-form-item /deep/ .el-form-item__content {
						display: flex;
						justify-content: center;
					}

		.rgs-form .el-input /deep/ .el-input__inner {
						border: 1px solid #3B2E7E;
						border-radius: 30px;
						padding: 0 10px;
						box-shadow: none;
						outline: none;
						color: #000;
						background: none;
						width: 450px;
						font-size: 14px;
						height: 44px;
					}

		.rgs-form .el-select /deep/ .el-input__inner {
						border: 1px solid #3B2E7E;
						border-radius: 30px;
						padding: 0 10px;
						box-shadow: none;
						outline: none;
						color: #000;
						background: none;
						width: 450px;
						font-size: 14px;
						height: 44px;
					}

		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1px solid #3B2E7E;
						border-radius: 30px;
						padding: 0 10px 0 30px;
						box-shadow: none;
						outline: none;
						color: #000;
						background: none;
						width: 450px;
						font-size: 14px;
						height: 44px;
					}

		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1px solid #3B2E7E;
						border-radius: 30px;
						padding: 0 10px 0 30px;
						box-shadow: none;
						outline: none;
						color: #000;
						background: none;
						width: 450px;
						font-size: 14px;
						height: 44px;
					}

		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}

		.rgs-form /deep/ .upload .upload-img {
		  		  border: 1px solid #3B2E7E;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  margin: 0 300px 0 0;
		  		  color: #3B2E7E;
		  		  width: 150px;
		  		  font-size: 32px;
		  		  line-height: 60px;
		  		  text-align: center;
		  		  height: 60px;
		  		}

		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 1px solid #3B2E7E;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  margin: 0 300px 0 0;
		  		  color: #3B2E7E;
		  		  width: 150px;
		  		  font-size: 32px;
		  		  line-height: 60px;
		  		  text-align: center;
		  		  height: 60px;
		  		}

		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 1px solid #3B2E7E;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  margin: 0 300px 0 0;
		  		  color: #3B2E7E;
		  		  width: 150px;
		  		  font-size: 32px;
		  		  line-height: 60px;
		  		  text-align: center;
		  		  height: 60px;
		  		}
	}
	.required {
		position: relative;
	}
	.required::after{
				color: red;
				left: -12px;
				position: absolute;
				content: "*";
			}
</style>
