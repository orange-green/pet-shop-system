<template>
	<div>
		<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20231128/5a94f436dc0b45ac9c63ac27350c72e9.webp)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
			<el-form v-if="pageFlag=='register'" :style='{"padding":"20px","boxShadow":"0 1px 6px rgba(64, 158, 255, .8)","backdrop-filter":"blur(6px)","margin":"50px 0","borderRadius":"10px","background":"rgba(255, 255, 255, 0.3)","width":"600px","height":"auto"}' ref="rgsForm" class="rgs-form" :model="rgsForm" :rules="rules">
				<div v-if="true" :style='{"margin":"0 0 10px 0","color":"#000","textAlign":"center","width":"100%","lineHeight":"64px","fontSize":"20px","fontWeight":"600"}' class="title">基于Spring Boot的安信宠物医疗美容系统注册</div>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('yonghuming')?'required':''">用户名：</div>
					<el-input  v-model="ruleForm.yonghuming"  autocomplete="off" placeholder="用户名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('mima')?'required':''">密码：</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('xingming')?'required':''">姓名：</div>
					<el-input  v-model="ruleForm.xingming"  autocomplete="off" placeholder="姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in yonghuxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="yonghutouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('youxiang')?'required':''">邮箱：</div>
					<el-input  v-model="ruleForm.youxiang"  autocomplete="off" placeholder="邮箱"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('shouji')?'required':''">手机：</div>
					<el-input  v-model="ruleForm.shouji"  autocomplete="off" placeholder="手机"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='shangjia'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('dianpumingcheng')?'required':''">账号：</div>
					<el-input  v-model="ruleForm.dianpumingcheng"  autocomplete="off" placeholder="账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='shangjia'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('mima')?'required':''">密码：</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='shangjia'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='shangjia'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('fuzeren')?'required':''">负责人：</div>
					<el-input  v-model="ruleForm.fuzeren"  autocomplete="off" placeholder="负责人"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='shangjia'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="shangjiatouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='shangjia'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in shangjiaxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='shangjia'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('nianling')?'required':''">年龄：</div>
					<el-input  v-model="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='shangjia'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('lianxidianhua')?'required':''">联系电话：</div>
					<el-input  v-model="ruleForm.lianxidianhua"  autocomplete="off" placeholder="联系电话"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='yishi'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('dianpumingcheng')?'required':''">店铺名称：</div>
					<el-input  v-model="ruleForm.dianpumingcheng"  autocomplete="off" placeholder="店铺名称"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='yishi'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('zhanghao')?'required':''">账号：</div>
					<el-input  v-model="ruleForm.zhanghao"  autocomplete="off" placeholder="账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='yishi'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('yishixingming')?'required':''">姓名：</div>
					<el-input  v-model="ruleForm.yishixingming"  autocomplete="off" placeholder="姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='yishi'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('mima')?'required':''">密码：</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='yishi'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='yishi'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in yishixingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='yishi'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="yishitouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='yishi'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('nianling')?'required':''">年龄：</div>
					<el-input  v-model.number="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='yishi'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('zhiwei')?'required':''">职位：</div>
                    <el-select v-model="ruleForm.zhiwei" placeholder="请选择职位" >
                        <el-option
                            v-for="(item,index) in yishizhiweiOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='yishi'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('longitude')?'required':''">经度：</div>
					<el-input  v-model.number="ruleForm.longitude"  autocomplete="off" placeholder="经度"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='yishi'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('latitude')?'required':''">纬度：</div>
					<el-input  v-model.number="ruleForm.latitude"  autocomplete="off" placeholder="纬度"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='yishi'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('fulladdress')?'required':''">地址：</div>
					<el-input  v-model="ruleForm.fulladdress"  autocomplete="off" placeholder="地址"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 5px","height":"auto"}' class="list-item" v-if="tableName=='yishi'">
					<div v-if="true" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","position":"relative","color":"#222"}' class="lable" :class="changeRules('gerenjianjie')?'required':''">个人简介：</div>
					<editor
						style="min-width: 200px; max-width: 600px;"
						:style='{"width":"100%","background":"#fff","height":"auto"}'
						v-model="ruleForm.gerenjianjie" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"20px auto 5px","outline":"none","color":"#fff","borderRadius":"8px","background":"#385d86","display":"block","width":"80%","fontSize":"16px","height":"44px"}' type="button" class="r-btn" @click="login()">注册</button>
				<div :style='{"cursor":"pointer","padding":"0 10%","margin":"20px 0 0","color":"#385d86","textAlign":"center","display":"block","lineHeight":"2","fontSize":"16px","textDecoration":"underline"}' class="r-login" @click="close()">已有账号，直接登录</div>
			</el-form>
			
		</div>
	</div>
</template>

<script>
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            yonghuxingbieOptions: [],
            shangjiaxingbieOptions: [],
            yishixingbieOptions: [],
            yishizhiweiOptions: [],
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='yonghu'){
				this.ruleForm = {
					yonghuming: '',
					mima: '',
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
				this.ruleForm = {
					dianpumingcheng: '',
					mima: '',
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
				this.ruleForm = {
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
				}
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuming = [{ required: true, message: '请输入用户名', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('shangjia' == this.tableName) {
				this.rules.dianpumingcheng = [{ required: true, message: '请输入账号', trigger: 'blur' }]
			}
			if ('shangjia' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('shangjia' == this.tableName) {
				this.rules.fuzeren = [{ required: true, message: '请输入负责人', trigger: 'blur' }]
			}
			if ('yishi' == this.tableName) {
				this.rules.zhanghao = [{ required: true, message: '请输入账号', trigger: 'blur' }]
			}
			if ('yishi' == this.tableName) {
				this.rules.yishixingming = [{ required: true, message: '请输入姓名', trigger: 'blur' }]
			}
			if ('yishi' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yishi' == this.tableName) {
				this.rules.zhiwei = [{ required: true, message: '请输入职位', trigger: 'blur' }]
			}
			this.yonghuxingbieOptions = "男,女".split(',')
			this.shangjiaxingbieOptions = "男,女".split(',')
			this.yishixingbieOptions = "男,女".split(',')
			this.yishizhiweiOptions = "宠物医生,美容技师".split(',')
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        yonghutouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        shangjiatouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        yishitouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
					if((!this.ruleForm.yonghuming) && `yonghu` == this.tableName){
						this.$message.error(`用户名不能为空`);
						return
					}
					if((!this.ruleForm.mima) && `yonghu` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `yonghu` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					if(`yonghu` == this.tableName && this.ruleForm.youxiang &&(!this.$validate.isEmail(this.ruleForm.youxiang))){
						this.$message.error(`邮箱应输入邮件格式`);
						return
					}
					if(`yonghu` == this.tableName && this.ruleForm.shouji &&(!this.$validate.isMobile(this.ruleForm.shouji))){
						this.$message.error(`手机应输入手机格式`);
						return
					}
					if((!this.ruleForm.dianpumingcheng) && `shangjia` == this.tableName){
						this.$message.error(`账号不能为空`);
						return
					}
					if((!this.ruleForm.mima) && `shangjia` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `shangjia` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.fuzeren) && `shangjia` == this.tableName){
						this.$message.error(`负责人不能为空`);
						return
					}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					if(`shangjia` == this.tableName && this.ruleForm.lianxidianhua &&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
						this.$message.error(`联系电话应输入手机格式`);
						return
					}
					if((!this.ruleForm.zhanghao) && `yishi` == this.tableName){
						this.$message.error(`账号不能为空`);
						return
					}
					if((!this.ruleForm.yishixingming) && `yishi` == this.tableName){
						this.$message.error(`姓名不能为空`);
						return
					}
					if((!this.ruleForm.mima) && `yishi` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `yishi` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					if(`yishi` == this.tableName && this.ruleForm.nianling &&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
						this.$message.error(`年龄应输入整数`);
						return
					}
					if((!this.ruleForm.zhiwei) && `yishi` == this.tableName){
						this.$message.error(`职位不能为空`);
						return
					}
					if(`yishi` == this.tableName && this.ruleForm.longitude &&(!this.$validate.isNumber(this.ruleForm.longitude))){
						this.$message.error(`经度应输入数字`);
						return
					}
					if(`yishi` == this.tableName && this.ruleForm.latitude &&(!this.$validate.isNumber(this.ruleForm.latitude))){
						this.$message.error(`纬度应输入数字`);
						return
					}
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
	.container {
	  position: relative;
	  background: url(http://codegen.caihongy.cn/20231128/5a94f436dc0b45ac9c63ac27350c72e9.webp);

		.el-date-editor.el-input {
		  width: 100%;
		}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border: 1;
						border-radius: 8px;
						padding: 0 10px;
						outline: none;
						color: #000;
						background: #fff;
						width: 100%;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border: 1;
						border-radius: 8px;
						padding: 0 10px;
						outline: none;
						color: #000;
						background: #fff;
						width: 288px;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1;
						border-radius: 8px;
						padding: 0 10px 0 30px;
						outline: none;
						color: #000;
						background: #fff;
						width: 288px;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1;
						border-radius: 8px;
						padding: 0 10px 0 30px;
						outline: none;
						color: #000;
						background: #fff;
						width: 288px;
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
		  		  border: 0px dashed #385d86;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #385d86;
		  		  background: #fff;
		  		  width: 100px;
		  		  font-size: 32px;
		  		  line-height: 100px;
		  		  text-align: center;
		  		  height: 100px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 0px dashed #385d86;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #385d86;
		  		  background: #fff;
		  		  width: 100px;
		  		  font-size: 32px;
		  		  line-height: 100px;
		  		  text-align: center;
		  		  height: 100px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 0px dashed #385d86;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #385d86;
		  		  background: #fff;
		  		  width: 100px;
		  		  font-size: 32px;
		  		  line-height: 100px;
		  		  text-align: center;
		  		  height: 100px;
		  		}
	}
	.required {
		position: relative;
	}
	.required::after{
				color: red;
				left: -10px;
				position: absolute;
				content: "*";
			}
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
