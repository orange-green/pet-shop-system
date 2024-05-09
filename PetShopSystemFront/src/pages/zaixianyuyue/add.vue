<template>
  <div
    :style='{ "width": "80%", "padding": "20px", "boxShadow": "0px 4px 10px 0px rgba(0,0,0,0.3)", "margin": "10px auto", "position": "relative", "background": "#fff" }'>
    <el-form ref="ruleForm" :model="ruleForm" :rules="rules"
      :style='{ "width": "100%", "position": "relative", "flexWrap": "wrap", "display": "flex" }'
      class="add-update-preview" label-width="80px">
      <el-form-item :style='{ "width": "50%", "padding": "10px", "margin": "0 0 10px", "background": "none" }'
        label="订单编号" prop="dingdanbianhao">
        <el-input v-model="ruleForm.dingdanbianhao" disabled placeholder="订单编号"></el-input>
      </el-form-item>
      <el-form-item :style='{ "width": "50%", "padding": "10px", "margin": "0 0 10px", "background": "none" }'
        label="账号" prop="zhanghao">
        <el-input v-model="ruleForm.zhanghao" :disabled="true || ro.zhanghao" clearable placeholder="账号"></el-input>
      </el-form-item>
      <el-form-item :style='{ "width": "50%", "padding": "10px", "margin": "0 0 10px", "background": "none" }'
        label="医师姓名" prop="yishixingming">
        <el-input v-model="ruleForm.yishixingming" :disabled="false || ro.yishixingming" clearable
          placeholder="医师姓名"></el-input>
      </el-form-item>
      <el-form-item v-if="type != 'cross' || (type == 'cross' && !ro.touxiang)"
        :style='{ "width": "50%", "padding": "10px", "margin": "0 0 10px", "background": "none" }' label="头像"
        prop="touxiang">
        <file-upload :fileUrls="ruleForm.touxiang ? ruleForm.touxiang : ''" :limit="3" :multiple="true"
          action="file/upload" tip="点击上传头像" @change="touxiangUploadChange"></file-upload>
      </el-form-item>
      <el-form-item v-else :style='{ "width": "50%", "padding": "10px", "margin": "0 0 10px", "background": "none" }'
        class="upload" label="头像" prop="touxiang">
        <img v-if="ruleForm.touxiang.substring(0, 4) == 'http'" v-bind:key="index"
          :src="ruleForm.touxiang.split(',')[0]" class="upload-img" height="100" style="margin-right:20px;" width="100">
        <img v-for="(item, index) in ruleForm.touxiang.split(',')" v-else v-bind:key="index" :src="baseUrl + item"
          class="upload-img" height="100" style="margin-right:20px;" width="100">
      </el-form-item>
      <el-form-item :style='{ "width": "50%", "padding": "10px", "margin": "0 0 10px", "background": "none" }'
        label="宠物昵称" prop="chongwunicheng">
        <el-input v-model="ruleForm.chongwunicheng" :disabled="false || ro.chongwunicheng" clearable
          placeholder="宠物昵称"></el-input>
      </el-form-item>
      <!-- <el-form-item :style='{ "width": "50%", "padding": "10px", "margin": "0 0 10px", "background": "none" }'
        label="医师姓名" prop="yishixingming">
        <el-input v-model="ruleForm.yishixingming" :disabled="false || ro.yishixingming" clearable
          placeholder="医师姓名"></el-input>
      </el-form-item> -->
      <el-form-item :style='{ "width": "50%", "padding": "10px", "margin": "0 0 10px", "background": "none" }'
        label="预约时间" prop="yuyueshijian">
        <el-date-picker v-model="ruleForm.yuyueshijian" :disabled="false || ro.yuyueshijian"
          :picker-options="yuyueshijianPickerOptions" placeholder="预约时间" type="datetime"
          value-format="yyyy-MM-dd HH:mm:ss">
        </el-date-picker>
      </el-form-item>
      <el-form-item :style='{ "width": "50%", "padding": "10px", "margin": "0 0 10px", "background": "none" }'
        label="用户名" prop="yonghuming">
        <el-input v-model="ruleForm.yonghuming" :disabled="true || ro.yonghuming" clearable
          placeholder="用户名"></el-input>
      </el-form-item>
      <el-form-item :style='{ "width": "50%", "padding": "10px", "margin": "0 0 10px", "background": "none" }'
        label="姓名" prop="xingming">
        <el-input v-model="ruleForm.xingming" :disabled="true || ro.xingming" clearable placeholder="姓名"></el-input>
      </el-form-item>
      <el-form-item :style='{ "width": "50%", "padding": "10px", "margin": "0 0 10px", "background": "none" }'
        label="手机" prop="shouji">
        <el-input v-model="ruleForm.shouji" :disabled="true || ro.shouji" clearable placeholder="手机"></el-input>
      </el-form-item>
      <el-form-item :style='{ "width": "50%", "padding": "10px", "margin": "0 0 10px", "background": "none" }'
        label="预约说明" prop="yuyueshuoming">
        <el-input v-model="ruleForm.yuyueshuoming" :rows="8" placeholder="预约说明" type="textarea">
        </el-input>
      </el-form-item>

      <el-form-item :style='{ "padding": "0", "margin": "0" }'>
        <el-button
          :style='{ "border": "0", "cursor": "pointer", "padding": "0 10px", "margin": "0 20px 0 0", "outline": "none", "color": "rgba(255, 255, 255, 1)", "borderRadius": "4px", "background": "#3B2E7E", "width": "auto", "lineHeight": "30px", "fontSize": "14px", "height": "30px" }'
          type="primary" @click="onSubmit">提交
        </el-button>
        <el-button
          :style='{ "border": "0", "cursor": "pointer", "padding": "0 10px", "margin": "0", "outline": "none", "color": "#000", "borderRadius": "4px", "background": "#9E9E9E", "width": "auto", "lineHeight": "30px", "fontSize": "14px", "height": "30px" }'
          @click="back()">返回
        </el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    let self = this
    return {
      id: '',
      baseUrl: '',
      ro: {
        dingdanbianhao: false,
        zhanghao: false,
        yishixingming: false,
        touxiang: false,
        chongwunicheng: false,
        yuyueshuoming: false,
        yuyueshijian: false,
        yonghuming: false,
        xingming: false,
        shouji: false,
        sfsh: false,
        shhf: false,
      },
      type: '',
      userTableName: localStorage.getItem('UserTableName'),
      ruleForm: {
        dingdanbianhao: this.getUUID(),
        zhanghao: '',
        yishixingming: '',
        touxiang: '',
        chongwunicheng: '',
        yuyueshuoming: '',
        yuyueshijian: '',
        yonghuming: '',
        xingming: '',
        shouji: '',
      },

      // 只能选择今天之后日期
      yuyueshijianPickerOptions: {
        disabledDate(time) {
          return time.getTime() < Date.now();
        }
      },

      rules: {
        dingdanbianhao: [],
        zhanghao: [],
        yishixingming: [
          { required: true, message: '医师姓名不能为空', trigger: 'blur' },
        ],
        touxiang: [],
        chongwunicheng: [
          { required: true, message: '宠物昵称不能为空', trigger: 'blur' },
        ],
        yuyueshuoming: [
          { required: true, message: '预约说明不能为空', trigger: 'blur' },
        ],
        yuyueshijian: [
          { required: true, message: '预约时间不能为空', trigger: 'blur' },
        ],
        yonghuming: [],
        xingming: [],
        shouji: [
          { validator: this.$validate.isMobile, trigger: 'blur' },
        ],
        sfsh: [],
        shhf: [],
      },
      centerType: false,
    };
  },
  computed: {},
  components: {},
  created() {
    if (this.$route.query.centerType) {
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
    download(file) {
      window.open(`${file}`)
    },
    // 初始化
    init(type) {
      this.type = type;
      if (type == 'cross') {
        var obj = JSON.parse(localStorage.getItem('crossObj'));
        for (var o in obj) {
          if (o == 'dingdanbianhao') {
            this.ruleForm.dingdanbianhao = obj[o];
            this.ro.dingdanbianhao = true;
            continue;
          }
          if (o == 'zhanghao') {
            this.ruleForm.zhanghao = obj[o];
            this.ro.zhanghao = true;
            continue;
          }
          if (o == 'yishixingming') {
            this.ruleForm.yishixingming = obj[o];
            this.ro.yishixingming = true;
            continue;
          }
          if (o == 'touxiang') {
            this.ruleForm.touxiang = obj[o].split(",")[0];
            this.ro.touxiang = true;
            continue;
          }
          if (o == 'chongwunicheng') {
            this.ruleForm.chongwunicheng = obj[o];
            this.ro.chongwunicheng = true;
            continue;
          }
          if (o == 'yuyueshuoming') {
            this.ruleForm.yuyueshuoming = obj[o];
            this.ro.yuyueshuoming = true;
            continue;
          }
          if (o == 'yuyueshijian') {
            this.ruleForm.yuyueshijian = obj[o];
            this.ro.yuyueshijian = true;
            continue;
          }
          if (o == 'yonghuming') {
            this.ruleForm.yonghuming = obj[o];
            this.ro.yonghuming = true;
            continue;
          }
          if (o == 'xingming') {
            this.ruleForm.xingming = obj[o];
            this.ro.xingming = true;
            continue;
          }
          if (o == 'shouji') {
            this.ruleForm.shouji = obj[o];
            this.ro.shouji = true;

          }
        }
      }
      else if (type == 'edit') {
        this.info()
      }
      // 获取用户信息
      this.$http.get(this.userTableName + '/session', { emulateJSON: true }).then(res => {
        if (res.data.code == 0) {
          var json = res.data.data;
          if ((json.yonghuming != '' && json.yonghuming) || json.yonghuming == 0) {
            this.ruleForm.yonghuming = json.yonghuming;
            this.ro.yonghuming = true;
          }
          if ((json.xingming != '' && json.xingming) || json.xingming == 0) {
            this.ruleForm.xingming = json.xingming;
            this.ro.xingming = true;
          }
          if ((json.shouji != '' && json.shouji) || json.shouji == 0) {
            this.ruleForm.shouji = json.shouji;
            this.ro.shouji = true;
          }
        }
      });

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
      this.$http.get(`zaixianyuyue/detail/${this.$route.query.id}`, { emulateJSON: true }).then(res => {
        if (res.data.code == 0) {
          this.ruleForm = res.data.data;
        }
      });
    },
    // 提交
    onSubmit() {
      console.log("进入提交预约的方法");
      console.log(this.ruleForm)

      if (this.ruleForm.dingdanbianhao) {
        this.ruleForm.dingdanbianhao = String(this.ruleForm.dingdanbianhao)
      }

      //更新跨表属性
      var crossuserid;
      var crossrefid;
      var crossoptnum;
      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          const loading = this.$loading({});
          if (this.type == 'cross') {
            console.log("进入提交预约cross的方法");

            var statusColumnName = localStorage.getItem('statusColumnName');
            var statusColumnValue = localStorage.getItem('statusColumnValue');
            if (statusColumnName && statusColumnName != '') {
              var obj = JSON.parse(localStorage.getItem('crossObj'));
              if (!statusColumnName.startsWith("[")) {
                for (var o in obj) {
                  if (o == statusColumnName) {
                    obj[o] = statusColumnValue;
                  }
                }
                var table = localStorage.getItem('crossTable');
                this.$http.post(table + '/update', obj).then(res => {
                });
              }
              else {
                crossuserid = Number(localStorage.getItem('frontUserid'));
                crossrefid = obj['id'];
                crossoptnum = localStorage.getItem('statusColumnName');
                crossoptnum = crossoptnum.replace(/\[/, "").replace(/\]/, "");
              }
            }
          }
          if (crossrefid && crossuserid) {
            console.log("进入提交预约crossrefid && crossuserid的方法");
            this.ruleForm.crossuserid = crossuserid;
            this.ruleForm.crossrefid = crossrefid;
            var params = {
              page: 1,
              limit: 10,
              crossuserid: crossuserid,
              crossrefid: crossrefid,
            }
            this.$http.get('zaixianyuyue/list', {
              params: params
            }).then(res => {
              if (res.data.data.total >= crossoptnum) {
                this.$message({
                  message: localStorage.getItem('tips'),
                  type: 'error',
                  duration: 1500,
                });
                return false;
              }
              else {
                // 跨表计算
                this.$http.post(`zaixianyuyue/${this.ruleForm.id ? 'update' : this.centerType ? 'save' : 'add'}`, this.ruleForm).then(res => {
                  if (res.data.code == 0) {
                    this.$message({
                      message: '操作成功',
                      type: 'success',
                      duration: 1500,
                      onClose: () => {

                      }
                    }); this.$router.go(-1);
                  }
                  else {
                    this.$message({
                      message: res.data.msg,
                      type: 'error',
                      duration: 1500
                    });
                  }
                });
              }
            });
          }
          else {

            console.log("进入提交预约else的方法");
            console.log({ "yishixingming": this.ruleForm.yishixingming });

            // 检查该医生是否在这个时间段有预约了
            let flag = true;
            console.log("请求参数ruleForm===========");
            console.log(this.ruleForm);

            console.log("请求参数ro===========");
            console.log(this.ro);

            this.$http.post(`zaixianyuyue/${this.ruleForm.id ? 'update' : this.centerType ? 'save' : 'add'}`, this.ruleForm).then(res => {
              console.log("新增预约的返回结果");
              console.log(res);
              if (res.data.code == 0) {

                if (res.data.exist == '已存在预约') {
                  this.$message({
                    message: '该医师该时间已存在预约，请将预约时间延后一小时',
                    type: 'error',
                    duration: 3000,
                  });
                }
                else {
                  this.$message({
                    message: '操作成功',
                    type: 'success',
                    duration: 1500,
                    onClose: () => {

                    }
                  }); this.$router.go(-1);
                }

              }
              else {
                this.$message({
                  message: '请求异常，稍后重试',
                  type: 'error',
                  duration: 3000
                });
                this.$router.go(-1);
              }
            });


          }
          loading.close()
        }
      });
    },
    // 获取uuid
    getUUID() {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.$router.go(-1);
    },
    touxiangUploadChange(fileUrls) {
      this.ruleForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl, "g"), "");
    },
  }
};
</script>

<style lang="scss" rel="stylesheet/scss" scoped>
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
</style>
