import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import shangpinxinxi from '@/views/modules/shangpinxinxi/list'
    import zaixianwenzhen from '@/views/modules/zaixianwenzhen/list'
    import shangjia from '@/views/modules/shangjia/list'
    import friendlink from '@/views/modules/friendlink/list'
    import discussyishi from '@/views/modules/discussyishi/list'
    import systemintro from '@/views/modules/systemintro/list'
    import yonghu from '@/views/modules/yonghu/list'
    import shangpinfenlei from '@/views/modules/shangpinfenlei/list'
    import discussshangpinxinxi from '@/views/modules/discussshangpinxinxi/list'
    import orders from '@/views/modules/orders/list'
    import zaixianyuyue from '@/views/modules/zaixianyuyue/list'
    import config from '@/views/modules/config/list'
    import yishi from '@/views/modules/yishi/list'
    import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '新闻资讯',
        component: news
      }
      ,{
	path: '/shangpinxinxi',
        name: '商品信息',
        component: shangpinxinxi
      }
      ,{
	path: '/zaixianwenzhen',
        name: '在线问诊',
        component: zaixianwenzhen
      }
      ,{
	path: '/shangjia',
        name: '商家',
        component: shangjia
      }
      ,{
	path: '/friendlink',
        name: '友情链接',
        component: friendlink
      }
      ,{
	path: '/discussyishi',
        name: '医师评论',
        component: discussyishi
      }
      ,{
	path: '/systemintro',
        name: '系统简介',
        component: systemintro
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/shangpinfenlei',
        name: '商品分类',
        component: shangpinfenlei
      }
      ,{
	path: '/discussshangpinxinxi',
        name: '商品信息评论',
        component: discussshangpinxinxi
      }
      ,{
        path: '/orders/:status',
        name: '订单管理',
        component: orders
      }
      ,{
	path: '/zaixianyuyue',
        name: '在线预约',
        component: zaixianyuyue
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/yishi',
        name: '医师',
        component: yishi
      }
      ,{
	path: '/newstype',
        name: '资讯分类',
        component: newstype
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
