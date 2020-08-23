# dev-tools
开发过程中使用的一些自定义工具

## CustomMsg

控制层返回的数据包装对象（code，msg，data）

API 列表：
- ok()
- ok(data)
- invalidRequest()
- invalidRequest(data)
- noAuthenticate()
- noAuthenticate(data)
- failure()
- failure(data)
- build(code, msg)
- build(code, msg, data)