//目前这种写法会报错
//module.exports = file => () => import('@/views/' + file + '.vue')

//先改成这种写法
module.exports = file => require('@/views/' + file + '.vue').default



