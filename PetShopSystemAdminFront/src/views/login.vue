<template>
  <div>
    <div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20231128/5a94f436dc0b45ac9c63ac27350c72e9.webp)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":" center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
      <el-form :style='{"padding":"40px 20px 20px","boxShadow":"0 1px 6px rgba(64, 158, 255, .8)","backdrop-filter":"blur(6px)","margin":"0 ","borderRadius":"10px","background":"rgba(255, 255, 255, 0.2)","width":"500px","height":"auto"}'>
        <div v-if="true" :style='{"margin":"0 0 10px 0","color":"#000","textAlign":"center","width":"100%","lineHeight":"44px","fontSize":"20px","fontWeight":"700"}' class="title-container">基于Spring Boot的安信宠物医疗美容系统登录</div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"80%","margin":"20px auto","alignItems":"center","display":"flex"}'>
          <div v-if="true" class="lable" :style='{"width":"80px","lineHeight":"44px","fontSize":"14px","color":"#000"}'>用户名：</div>
          <input :style='{"border":"1px solid ","padding":"0 10px","color":"rgba(44, 55, 66, 0.9)","borderRadius":"4px","background":" #fff","width":"100%","fontSize":"14px","height":"44px"}' placeholder="请输入用户名" name="username" type="text" v-model="rulesForm.username">
        </div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"80%","margin":"20px auto","alignItems":"center","display":"flex"}'>
          <div v-if="true" class="lable" :style='{"width":"80px","lineHeight":"44px","fontSize":"14px","color":"#000"}'>密码：</div>
          <input :style='{"border":"1px solid ","padding":"0 10px","color":"rgba(44, 55, 66, 0.9)","borderRadius":"4px","background":" #fff","width":"100%","fontSize":"14px","height":"44px"}' placeholder="请输入密码" name="password" type="password" v-model="rulesForm.password">
        </div>
        <div class="list-code" v-if="true && loginType==1" :style='{"width":"80%","margin":"20px auto","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <input :style='{"border":"1px solid rgba(44, 55, 66, 0.9)","padding":"0 10px","outline":"none","color":"rgba(44, 55, 66, 0.9)","borderRadius":"4px 0 0 4px","background":" #fff","width":"calc(100% - 80px)","fontSize":"14px","height":"44px"}' placeholder="请输入验证码" name="code" type="text" v-model="rulesForm.code">
          <div class="getCodeBt" :style='{"cursor":"pointer","borderColor":"rgba(44, 55, 66, 0.9)","alignItems":"center","borderRadius":"0 4px 4px 0","borderWidth":"1px 1px 1px 0","background":"#f5f5f5","display":"flex","width":"80px","borderStyle":"solid","justifyContent":"center","height":"44px"}' @click="getRandCode(4)">
            <span :style="{color:item.color,transform:item.rotate,fontSize:item.size,padding: '0 3px',display:'inline-block'}" v-for="(item, index) in codes" :key="index">{{ item.num }}</span>
          </div>
        </div>

        <div :style='{"width":"80%","textAlign":"center","margin":"20px auto"}' v-if="roles.length>1" prop="loginInRole" class="list-type">
          <el-radio v-if="loginType==1||(loginType==2&&item.roleName!='管理员')" v-for="item in roles" v-bind:key="item.roleName" v-model="rulesForm.role" :label="item.roleName">{{item.roleName}}</el-radio>
        </div>

		
        <div :style='{"row-gap":"10px","padding":"0 10%","margin":"20px auto","alignItems":"center","columnGap":"10px","flexWrap":"wrap","display":"flex","width":"100%","justifyContent":"center"}'>
          <el-button v-if="loginType==1" :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0","outline":"none","color":"#fff","borderRadius":"4px","background":"#385d86","width":"100%","fontSize":"14px","height":"44px"}' type="primary" @click="login()" class="loginInBt">登录</el-button>
          <el-button :style='{"border":"1px solid #385d86","cursor":"pointer","padding":"0 24px","margin":"0","outline":"none","color":"#385d86","borderRadius":"4px","background":"transparent","flex":"1","width":"auto","fontSize":"14px","height":"44px"}' type="primary" @click="register('shangjia')" class="register">注册商家</el-button>
        </div>
      </el-form>

    </div>
  </div>
</template>
<script>
import menu from "@/utils/menu";
export default {
  data() {
    return {
		verifyCheck2: false,
		flag: false,
      baseUrl:this.$base.url,
      loginType: 1,
      rulesForm: {
        username: "",
        password: "",
        role: "",
        code: '',
      },
      menus: [],
      roles: [],
      tableName: "",
      codes: [{
        num: 1,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      },{
        num: 2,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      },{
        num: 3,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      },{
        num: 4,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      }],
    };
  },
  mounted() {
    let menus = menu.list();
    this.menus = menus;

    for (let i = 0; i < this.menus.length; i++) {
      if (this.menus[i].hasBackLogin=='是') {
        this.roles.push(this.menus[i])
      }
    }

  },
  created() {

    this.getRandCode()
  },
  destroyed() {
	    },
  components: {
  },
  methods: {

    //注册
    register(tableName){
		this.$storage.set("loginTable", tableName);
		this.$router.push({path:'/register',query:{pageFlag:'register'}})
    },
    // 登陆
    login() {
		let code = ''
		for(let i in this.codes) {
			code += this.codes[i].num
		}
		if (true && !this.rulesForm.code) {
			this.$message.error("请输入验证码");
			return;
		}
		if (true && this.rulesForm.code.toLowerCase() != code.toLowerCase()) {
			this.$message.error("验证码输入有误");
			this.getRandCode()
			return;
		}

		if (!this.rulesForm.username) {
			this.$message.error("请输入用户名");
			return;
		}
		if (!this.rulesForm.password) {
			this.$message.error("请输入密码");
			return;
		}
		if(this.roles.length>1) {
			if (!this.rulesForm.role) {
				this.$message.error("请选择角色");
				return;
			}

			let menus = this.menus;
			for (let i = 0; i < menus.length; i++) {
				if (menus[i].roleName == this.rulesForm.role) {
					this.tableName = menus[i].tableName;
				}
			}
		} else {
			this.tableName = this.roles[0].tableName;
			this.rulesForm.role = this.roles[0].roleName;
		}
		
		this.loginPost()
    },
	loginPost() {
		this.$http({
			url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
			method: "post"
		}).then(({ data }) => {
			if (data && data.code === 0) {
				this.$storage.set("Token", data.token);
				this.$storage.set("role", this.rulesForm.role);
				this.$storage.set("sessionTable", this.tableName);
				this.$storage.set("adminName", this.rulesForm.username);
				this.$router.replace({ path: "/" });
			} else {
				this.$message.error(data.msg);
				this.getRandCode()
			}
		});
	},
    getRandCode(len = 4){
		this.randomString(len)
    },
    randomString(len = 4) {
      let chars = [
          "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
          "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
          "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G",
          "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
          "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2",
          "3", "4", "5", "6", "7", "8", "9"
      ]
      let colors = ["0", "1", "2","3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"]
      let sizes = ['14', '15', '16', '17', '18']

      let output = [];
      for (let i = 0; i < len; i++) {
        // 随机验证码
        let key = Math.floor(Math.random()*chars.length)
        this.codes[i].num = chars[key]
        // 随机验证码颜色
        let code = '#'
        for (let j = 0; j < 6; j++) {
          let key = Math.floor(Math.random()*colors.length)
          code += colors[key]
        }
        this.codes[i].color = code
        // 随机验证码方向
        let rotate = Math.floor(Math.random()*60)
        let plus = Math.floor(Math.random()*2)
        if(plus == 1) rotate = '-'+rotate
        this.codes[i].rotate = 'rotate('+rotate+'deg)'
        // 随机验证码字体大小
        let size = Math.floor(Math.random()*sizes.length)
        this.codes[i].size = sizes[size]+'px'
      }
    },
  }
}
</script>

<style lang="scss" scoped>
.container {
  min-height: 100vh;
  position: relative;
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
      background: url(http://codegen.caihongy.cn/20231128/5a94f436dc0b45ac9c63ac27350c72e9.webp);
        
  .list-item /deep/ .el-input .el-input__inner {
		border: 1px solid ;
		border-radius: 4px;
		padding: 0 10px;
		color: rgba(44, 55, 66, 0.9);
		background:  #fff;
		width: 100%;
		font-size: 14px;
		height: 44px;
	  }
  
  .list-item.select /deep/ .el-select .el-input__inner {
		border: 1px solid rgba(64, 158, 255, 1);
		padding: 0 10px;
		box-shadow: 0 0 6px rgba(64, 158, 255, .5);
		outline: 1px solid #efefef;
		color: rgba(64, 158, 255, 1);
		width: 288px;
		font-size: 14px;
		outline-offset: 4px;
		height: 44px;
	  }
  
  .list-code /deep/ .el-input .el-input__inner {
  	  	border: 1px solid rgba(44, 55, 66, 0.9);
  	  	border-radius: 4px 0 0 4px;
  	  	padding: 0 10px;
  	  	outline: none;
  	  	color: rgba(44, 55, 66, 0.9);
  	  	background:  #fff;
  	  	width: calc(100% - 80px);
  	  	font-size: 14px;
  	  	height: 44px;
  	  }

  .list-type /deep/ .el-radio__input .el-radio__inner {
		background: rgba(53, 53, 53, 0);
		border-color: rgba(44, 55, 66, 0.9);
	  }
  .list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
        background: #385d86;
        border-color: #385d86;
      }
  .list-type /deep/ .el-radio__label {
		color: rgba(44, 55, 66, 0.9);
		font-size: 14px;
	  }
  .list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
        color: #385d86;
        font-size: 14px;
      }
}

</style>
