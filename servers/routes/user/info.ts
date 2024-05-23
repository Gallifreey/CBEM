export default eventHandler((event) => {
  const token = getHeader(event, 'Authorization')
  const username = Buffer.from(token, 'base64').toString('utf-8')
  if (!token) {
    return {
      code: 401,
      msg: '登录失效',
    }
  }
  return {
    code: 200,
    msg: '获取成功',
    data: {
      id: 1,
      username,
      nickname: username,
      avatar: 'https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png',
      roles: ['VENDOR']//username === 'admin' ? ['ADMIN'] : ['USER'],
    },
  }
})
