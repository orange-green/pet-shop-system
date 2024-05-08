import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import AddrList from '../pages/shop-address/list'
import AddrAdd from '../pages/shop-address/addOrUpdate'
import Order from '../pages/shop-order/list'
import OrderConfirm from '../pages/shop-order/confirm'
import Cart from '../pages/shop-cart/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import shangjiaList from '../pages/shangjia/list'
import shangjiaDetail from '../pages/shangjia/detail'
import shangjiaAdd from '../pages/shangjia/add'
import yishiList from '../pages/yishi/list'
import yishiDetail from '../pages/yishi/detail'
import yishiAdd from '../pages/yishi/add'
import zaixianwenzhenList from '../pages/zaixianwenzhen/list'
import zaixianwenzhenDetail from '../pages/zaixianwenzhen/detail'
import zaixianwenzhenAdd from '../pages/zaixianwenzhen/add'
import zaixianyuyueList from '../pages/zaixianyuyue/list'
import zaixianyuyueDetail from '../pages/zaixianyuyue/detail'
import zaixianyuyueAdd from '../pages/zaixianyuyue/add'
import shangpinfenleiList from '../pages/shangpinfenlei/list'
import shangpinfenleiDetail from '../pages/shangpinfenlei/detail'
import shangpinfenleiAdd from '../pages/shangpinfenlei/add'
import shangpinxinxiList from '../pages/shangpinxinxi/list'
import shangpinxinxiDetail from '../pages/shangpinxinxi/detail'
import shangpinxinxiAdd from '../pages/shangpinxinxi/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import systemintroList from '../pages/systemintro/list'
import systemintroDetail from '../pages/systemintro/detail'
import systemintroAdd from '../pages/systemintro/add'
import friendlinkList from '../pages/friendlink/list'
import friendlinkDetail from '../pages/friendlink/detail'
import friendlinkAdd from '../pages/friendlink/add'
import discussyishiList from '../pages/discussyishi/list'
import discussyishiDetail from '../pages/discussyishi/detail'
import discussyishiAdd from '../pages/discussyishi/add'
import discussshangpinxinxiList from '../pages/discussshangpinxinxi/list'
import discussshangpinxinxiDetail from '../pages/discussshangpinxinxi/detail'
import discussshangpinxinxiAdd from '../pages/discussshangpinxinxi/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'storeup',
					component: Storeup
				},
                {
                    path: 'shop-address/list',
                    component: AddrList
                },
                {
                    path: 'shop-address/addOrUpdate',
                    component: AddrAdd
                },
				{
					path: 'shop-order/order',
					component: Order
				},
				{
					path: 'cart',
					component: Cart
				},
				{
					path: 'shop-order/orderConfirm',
					component: OrderConfirm
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'shangjia',
					component: shangjiaList
				},
				{
					path: 'shangjiaDetail',
					component: shangjiaDetail
				},
				{
					path: 'shangjiaAdd',
					component: shangjiaAdd
				},
				{
					path: 'yishi',
					component: yishiList
				},
				{
					path: 'yishiDetail',
					component: yishiDetail
				},
				{
					path: 'yishiAdd',
					component: yishiAdd
				},
				{
					path: 'zaixianwenzhen',
					component: zaixianwenzhenList
				},
				{
					path: 'zaixianwenzhenDetail',
					component: zaixianwenzhenDetail
				},
				{
					path: 'zaixianwenzhenAdd',
					component: zaixianwenzhenAdd
				},
				{
					path: 'zaixianyuyue',
					component: zaixianyuyueList
				},
				{
					path: 'zaixianyuyueDetail',
					component: zaixianyuyueDetail
				},
				{
					path: 'zaixianyuyueAdd',
					component: zaixianyuyueAdd
				},
				{
					path: 'shangpinfenlei',
					component: shangpinfenleiList
				},
				{
					path: 'shangpinfenleiDetail',
					component: shangpinfenleiDetail
				},
				{
					path: 'shangpinfenleiAdd',
					component: shangpinfenleiAdd
				},
				{
					path: 'shangpinxinxi',
					component: shangpinxinxiList
				},
				{
					path: 'shangpinxinxiDetail',
					component: shangpinxinxiDetail
				},
				{
					path: 'shangpinxinxiAdd',
					component: shangpinxinxiAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'systemintro',
					component: systemintroList
				},
				{
					path: 'systemintroDetail',
					component: systemintroDetail
				},
				{
					path: 'systemintroAdd',
					component: systemintroAdd
				},
				{
					path: 'friendlink',
					component: friendlinkList
				},
				{
					path: 'friendlinkDetail',
					component: friendlinkDetail
				},
				{
					path: 'friendlinkAdd',
					component: friendlinkAdd
				},
				{
					path: 'discussyishi',
					component: discussyishiList
				},
				{
					path: 'discussyishiDetail',
					component: discussyishiDetail
				},
				{
					path: 'discussyishiAdd',
					component: discussyishiAdd
				},
				{
					path: 'discussshangpinxinxi',
					component: discussshangpinxinxiList
				},
				{
					path: 'discussshangpinxinxiDetail',
					component: discussshangpinxinxiDetail
				},
				{
					path: 'discussshangpinxinxiAdd',
					component: discussshangpinxinxiAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
