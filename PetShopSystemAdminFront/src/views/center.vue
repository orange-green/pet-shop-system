<template>
  <div :style='{"padding":"30px"}'>
    <el-form
	  :style='{"borderRadius":"6px","padding":"30px"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      label-width="100px"
    >  
     <el-row>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='yonghu'"  label="用户名" prop="yonghuming">
          <el-input v-model="ruleForm.yonghuming" readonly              placeholder="用户名" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='yonghu'"  label="姓名" prop="xingming">
          <el-input v-model="ruleForm.xingming"               placeholder="姓名" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}' v-if="flag=='yonghu'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in yonghuxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}' v-if="flag=='yonghu'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="yonghutouxiangUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='yonghu'"  label="邮箱" prop="youxiang">
          <el-input v-model="ruleForm.youxiang"               placeholder="邮箱" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='yonghu'"  label="手机" prop="shouji">
          <el-input v-model="ruleForm.shouji"               placeholder="手机" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='shangjia'"  label="账号" prop="dianpumingcheng">
          <el-input v-model="ruleForm.dianpumingcheng" readonly              placeholder="账号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='shangjia'"  label="负责人" prop="fuzeren">
          <el-input v-model="ruleForm.fuzeren"               placeholder="负责人" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}' v-if="flag=='shangjia'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="shangjiatouxiangUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}' v-if="flag=='shangjia'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in shangjiaxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='shangjia'"  label="年龄" prop="nianling">
          <el-input v-model="ruleForm.nianling"               placeholder="年龄" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='shangjia'"  label="联系电话" prop="lianxidianhua">
          <el-input v-model="ruleForm.lianxidianhua"               placeholder="联系电话" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='yishi'"  label="店铺名称" prop="dianpumingcheng">
          <el-input v-model="ruleForm.dianpumingcheng"               placeholder="店铺名称" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='yishi'"  label="账号" prop="zhanghao">
          <el-input v-model="ruleForm.zhanghao" readonly              placeholder="账号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='yishi'"  label="姓名" prop="yishixingming">
          <el-input v-model="ruleForm.yishixingming"               placeholder="姓名" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}' v-if="flag=='yishi'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in yishixingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}' v-if="flag=='yishi'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="yishitouxiangUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='yishi'"  label="年龄" prop="nianling">
          <el-input v-model="ruleForm.nianling"               placeholder="年龄" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}' v-if="flag=='yishi'"  label="职位" prop="zhiwei">
          <el-select v-model="ruleForm.zhiwei"  placeholder="请选择职位">
            <el-option
                v-for="(item,index) in yishizhiweiOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='yishi'"  label="电话" prop="dianhua">
          <el-input v-model="ruleForm.dianhua"               placeholder="电话" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='yishi'"  label="邮箱" prop="youxiang">
          <el-input v-model="ruleForm.youxiang"               placeholder="邮箱" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='yishi'"  label="经度" prop="longitude">
          <el-input v-model="ruleForm.longitude"               placeholder="经度" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='yishi'"  label="纬度" prop="latitude">
          <el-input v-model="ruleForm.latitude"               placeholder="纬度" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='yishi'"  label="地址" prop="fulladdress">
          <el-input v-model="ruleForm.fulladdress"               placeholder="地址" clearable></el-input>
        </el-form-item>
		<el-form-item :style='{"margin":"0 0 20px 0"}' v-if="flag=='yishi'" label="个人简介" prop="gerenjianjie">
		  <editor
		  	style="min-width: 200px; max-width: 600px;"
			 :style='{"width":"600px","height":"auto"}'
		  	v-model="ruleForm.gerenjianjie" 
		  	class="editor" 
		  	action="file/upload">
		  </editor>
		</el-form-item>
		<el-form-item :style='{"margin":"0 0 20px 0"}' v-if="flag=='users'" label="用户名" prop="username">
			<el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
		</el-form-item>
		<el-form-item :style='{"margin":"0 0 20px 0"}' v-if="flag=='users'" label="头像" prop="image">
		  <file-upload
		  tip="点击上传头像"
		  action="file/upload"
		  :limit="1"
		  :multiple="false"
		  :fileUrls="ruleForm.image?ruleForm.image:''"
		  @change="usersimageUploadChange"
		  ></file-upload>
		</el-form-item>
		<el-form-item :style='{"padding":"0","margin":"0"}'>
			<el-button class="btn3" :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"4px","outline":"none","color":"#fff","borderRadius":"4px","background":"#385d86","width":"auto","fontSize":"14px","height":"40px"}' type="primary" @click="onUpdateHandler">
				<span class="icon iconfont " :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
				提交
			</el-button>
		</el-form-item>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      yonghuxingbieOptions: [],
      shangjiaxingbieOptions: [],
      yishixingbieOptions: [],
      yishizhiweiOptions: [],
    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
    this.yonghuxingbieOptions = "男,女".split(',')
    this.shangjiaxingbieOptions = "男,女".split(',')
    this.yishixingbieOptions = "男,女".split(',')
    this.yishizhiweiOptions = "宠物医生,美容技师".split(',')
  },
  methods: {
    yonghutouxiangUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
    shangjiatouxiangUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
    yishitouxiangUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
	usersimageUploadChange(fileUrls) {
		this.ruleForm.image = fileUrls;
	},
    onUpdateHandler() {
      if((!this.ruleForm.yonghuming)&& 'yonghu'==this.flag){
        this.$message.error('用户名不能为空');
        return
      }


      if((!this.ruleForm.mima)&& 'yonghu'==this.flag){
        this.$message.error('密码不能为空');
        return
      }








        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }


      if( 'yonghu' ==this.flag && this.ruleForm.youxiang&&(!isEmail(this.ruleForm.youxiang))){
        this.$message.error(`邮箱应输入邮箱格式`);
        return
      }


      if( 'yonghu' ==this.flag && this.ruleForm.shouji&&(!isMobile(this.ruleForm.shouji))){
        this.$message.error(`手机应输入手机格式`);
        return
      }


      if( 'yonghu' ==this.flag && this.ruleForm.money&&(!isNumber(this.ruleForm.money))){
        this.$message.error(`余额应输入数字`);
        return
      }


      if( 'yonghu' ==this.flag && this.ruleForm.status&&(!isIntNumer(this.ruleForm.status))){
       this.$message.error(`状态应输入整数`);
        return
      }
      if((!this.ruleForm.dianpumingcheng)&& 'shangjia'==this.flag){
        this.$message.error('账号不能为空');
        return
      }


      if((!this.ruleForm.mima)&& 'shangjia'==this.flag){
        this.$message.error('密码不能为空');
        return
      }


      if((!this.ruleForm.fuzeren)&& 'shangjia'==this.flag){
        this.$message.error('负责人不能为空');
        return
      }




        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }






      if( 'shangjia' ==this.flag && this.ruleForm.lianxidianhua&&(!isMobile(this.ruleForm.lianxidianhua))){
        this.$message.error(`联系电话应输入手机格式`);
        return
      }


      if( 'shangjia' ==this.flag && this.ruleForm.money&&(!isNumber(this.ruleForm.money))){
        this.$message.error(`余额应输入数字`);
        return
      }


      if( 'shangjia' ==this.flag && this.ruleForm.status&&(!isIntNumer(this.ruleForm.status))){
       this.$message.error(`状态应输入整数`);
        return
      }


      if((!this.ruleForm.zhanghao)&& 'yishi'==this.flag){
        this.$message.error('账号不能为空');
        return
      }


      if((!this.ruleForm.yishixingming)&& 'yishi'==this.flag){
        this.$message.error('姓名不能为空');
        return
      }


      if((!this.ruleForm.mima)&& 'yishi'==this.flag){
        this.$message.error('密码不能为空');
        return
      }






        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }


      if( 'yishi' ==this.flag && this.ruleForm.nianling&&(!isIntNumer(this.ruleForm.nianling))){
       this.$message.error(`年龄应输入整数`);
        return
      }
      if((!this.ruleForm.zhiwei)&& 'yishi'==this.flag){
        this.$message.error('职位不能为空');
        return
      }




      if( 'yishi' ==this.flag && this.ruleForm.dianhua&&(!isMobile(this.ruleForm.dianhua))){
        this.$message.error(`电话应输入手机格式`);
        return
      }


      if( 'yishi' ==this.flag && this.ruleForm.youxiang&&(!isEmail(this.ruleForm.youxiang))){
        this.$message.error(`邮箱应输入邮箱格式`);
        return
      }






      if( 'yishi' ==this.flag && this.ruleForm.clicknum&&(!isIntNumer(this.ruleForm.clicknum))){
       this.$message.error(`点击次数应输入整数`);
        return
      }


      if( 'yishi' ==this.flag && this.ruleForm.discussnum&&(!isIntNumer(this.ruleForm.discussnum))){
       this.$message.error(`评论数应输入整数`);
        return
      }




      if( 'yishi' ==this.flag && this.ruleForm.storeupnum&&(!isIntNumer(this.ruleForm.storeupnum))){
       this.$message.error(`收藏数应输入整数`);
        return
      }


      if( 'yishi' ==this.flag && this.ruleForm.longitude&&(!isNumber(this.ruleForm.longitude))){
        this.$message.error(`经度应输入数字`);
        return
      }


      if( 'yishi' ==this.flag && this.ruleForm.latitude&&(!isNumber(this.ruleForm.latitude))){
        this.$message.error(`纬度应输入数字`);
        return
      }




      if( 'yishi' ==this.flag && this.ruleForm.money&&(!isNumber(this.ruleForm.money))){
        this.$message.error(`余额应输入数字`);
        return
      }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
	this.$message.error(`用户名不能为空`);
        return	
      }
	  if(this.flag=='users'){
	  	this.ruleForm.image = this.ruleForm.image.replace(new RegExp(this.$base.url,"g"),"")
	  }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
				if(this.flag=='users'){
					this.$storage.set('headportrait',this.ruleForm.image)
				}
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
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #666;
	  	  font-weight: 500;
	  	  width: 100px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 100px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 1;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 1;
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 1;
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 200px;
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
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 1px dashed #385d86;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #385d86;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 200px;
	  	  text-align: center;
	  	  height: 200px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 1px dashed #385d86;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #385d86;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 200px;
	  	  text-align: center;
	  	  height: 200px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 1;
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 120px;
	  	}
	
	.add-update-preview .btn3 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #385d86;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn3:hover {
				opacity: 0.8;
			}
	
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
