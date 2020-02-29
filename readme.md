# jwt授权需要的文件
## 请求和响应
1. 请求实体-规定的客户端传给jwt认证服务器的参数
2. 响应实体-规定了jwt服务端颁发给客户端的jwt token的结果
## jwtUtil类
主要提供了jwt的实现方法，如加密规则，生成token，获取token等
## SecurityConfigurer类
主要设置了加密方法，用户信息读取方法，配置路由的授权规则等
## 过滤器JwtRequestFilter
对指定的http请求进行拦截和用户认证等
## 测试类 
可以使用postman类似的工具进行jwt的测试
1. post http://localhost:8080/authenticate  {"username": "zzl","password": "zzl"} 返回jwt token
2. get http://localhost:8080/index Header ["Authorization":"Bearer 上一步拿到的token""]
                       
