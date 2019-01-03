# gradle springboot 多模块项目构建RESTful API


<a name="overview"></a>
## 概览

### URI scheme
*域名* : 127.0.0.1:8888  
*基础路径* : /  
*方案* : HTTP


### 标签

* code-controller : 码表
* start-controller : 启动(登录，注册)
* user-controller : 用户




<a name="paths"></a>
## 资源

<a name="code-controller_resource"></a>
### Code-controller
码表


<a name="addusingpost"></a>
#### 新增
```
POST /v1/code/add
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|token|string|
|**Body**|**codeAddVo**  <br>*必填*|body内容|[CodeAddVo](#codeaddvo)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseVo](#responsevo)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `\*/*`


##### HTTP请求示例

###### 请求 path
```
/v1/code/add
```


###### 请求 header
```json
"string"
```


###### 请求 body
```json
{ }
```


##### HTTP响应示例

###### 响应 200
```json
{
  "msg" : "string",
  "msgObj" : [ { } ],
  "response" : "object",
  "status" : 0
}
```


<a name="delusingget"></a>
#### 删除
```
GET /v1/code/del
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|token|string|
|**Query**|**id**  <br>*必填*|id|integer (int64)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseVo](#responsevo)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `\*/*`


##### HTTP请求示例

###### 请求 path
```
/v1/code/del?id=0
```


###### 请求 header
```json
"string"
```


##### HTTP响应示例

###### 响应 200
```json
{
  "msg" : "string",
  "msgObj" : [ { } ],
  "response" : "object",
  "status" : 0
}
```


<a name="selectbyprimarykeyusingget"></a>
#### 详情
```
GET /v1/code/getById
```


##### 参数

|类型|名称|说明|类型|默认值|
|---|---|---|---|---|
|**Header**|**token**  <br>*可选*|token|string||
|**Query**|**id**  <br>*必填*|用户Id|integer (int64)|`121`|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseVo«Code»](#6f5f5101612faef3a7257e1f10b3001d)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `\*/*`


##### HTTP请求示例

###### 请求 path
```
/v1/code/getById?id=0
```


###### 请求 header
```json
"string"
```


##### HTTP响应示例

###### 响应 200
```json
{
  "msg" : "string",
  "msgObj" : [ { } ],
  "response" : {
    "id" : 0,
    "name" : "string",
    "type" : "string",
    "value" : 0
  },
  "status" : 0
}
```


<a name="updateusingpost"></a>
#### 更新
```
POST /v1/code/update
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|token|string|
|**Body**|**code**  <br>*必填*|CodeUpdateVo|[Code](#code)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseVo](#responsevo)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `\*/*`


##### HTTP请求示例

###### 请求 path
```
/v1/code/update
```


###### 请求 header
```json
"string"
```


###### 请求 body
```json
{
  "id" : 0,
  "name" : "string",
  "type" : "string",
  "value" : 0
}
```


##### HTTP响应示例

###### 响应 200
```json
{
  "msg" : "string",
  "msgObj" : [ { } ],
  "response" : "object",
  "status" : 0
}
```


<a name="getcodelistusingpost"></a>
#### 查询列表
```
POST /v1/public/code/list
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|token|string|
|**Query**|**pageNum**  <br>*必填*|当前页面|integer (int32)|
|**Query**|**pageSize**  <br>*必填*|每页显示条数|integer (int32)|
|**Body**|**codeListFind**  <br>*可选*|CodeSearchVo|[CodeSearchVo](#codesearchvo)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseVo«PageVo«List«Code»»»](#ec8bd93eab1fc621a673a21c5be9cd97)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `\*/*`


##### HTTP请求示例

###### 请求 path
```
/v1/public/code/list?pageNum=0&pageSize=0
```


###### 请求 header
```json
"string"
```


###### 请求 body
```json
{
  "name" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```json
{
  "msg" : "string",
  "msgObj" : [ { } ],
  "response" : {
    "data" : [ {
      "id" : 0,
      "name" : "string",
      "type" : "string",
      "value" : 0
    } ],
    "pageCount" : 0,
    "pageNum" : 0,
    "pageSize" : 0
  },
  "status" : 0
}
```


<a name="start-controller_resource"></a>
### Start-controller
启动(登录，注册)


<a name="loginusingpost"></a>
#### 登录
```
POST /v1/public/start/login
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|token|string|
|**Body**|**loginRequestVo**  <br>*必填*|body内容|[LoginRequestVo](#loginrequestvo)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseVo](#responsevo)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `\*/*`


##### HTTP请求示例

###### 请求 path
```
/v1/public/start/login
```


###### 请求 header
```json
"string"
```


###### 请求 body
```json
{
  "loginName" : "zw",
  "password" : "MTIzNDU2"
}
```


##### HTTP响应示例

###### 响应 200
```json
{
  "msg" : "string",
  "msgObj" : [ { } ],
  "response" : "object",
  "status" : 0
}
```


<a name="user-controller_resource"></a>
### User-controller
用户


<a name="addusingpost_1"></a>
#### 新增
```
POST /v1/user/add
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|token|string|
|**Body**|**userAddVo**  <br>*必填*|body内容|[UserAddVo](#useraddvo)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseVo](#responsevo)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `\*/*`


##### HTTP请求示例

###### 请求 path
```
/v1/user/add
```


###### 请求 header
```json
"string"
```


###### 请求 body
```json
{
  "ability" : "string",
  "address" : "string",
  "addressId" : "string",
  "avatar" : "string",
  "corporationId" : "string",
  "loginName" : "string",
  "name" : "string",
  "password" : "string",
  "phone" : "string",
  "roles" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```json
{
  "msg" : "string",
  "msgObj" : [ { } ],
  "response" : "object",
  "status" : 0
}
```


<a name="delusingget_1"></a>
#### 删除
```
GET /v1/user/del
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|token|string|
|**Query**|**id**  <br>*必填*|id|integer (int64)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseVo](#responsevo)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `\*/*`


##### HTTP请求示例

###### 请求 path
```
/v1/user/del?id=0
```


###### 请求 header
```json
"string"
```


##### HTTP响应示例

###### 响应 200
```json
{
  "msg" : "string",
  "msgObj" : [ { } ],
  "response" : "object",
  "status" : 0
}
```


<a name="selectbyprimarykeyusingget_1"></a>
#### 详情
```
GET /v1/user/getById
```


##### 参数

|类型|名称|说明|类型|默认值|
|---|---|---|---|---|
|**Header**|**token**  <br>*可选*|token|string||
|**Query**|**id**  <br>*必填*|用户Id|integer (int64)|`121`|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseVo«User»](#327bb6dccdc30e665d2934760538fd58)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `\*/*`


##### HTTP请求示例

###### 请求 path
```
/v1/user/getById?id=0
```


###### 请求 header
```json
"string"
```


##### HTTP响应示例

###### 响应 200
```json
{
  "msg" : "string",
  "msgObj" : [ { } ],
  "response" : {
    "ability" : "string",
    "address" : "string",
    "addressId" : "string",
    "avatar" : "string",
    "corporationId" : "string",
    "id" : 0,
    "loginName" : "string",
    "name" : "string",
    "password" : "string",
    "passwordKey" : "string",
    "phone" : "string",
    "roles" : "string",
    "state" : 0
  },
  "status" : 0
}
```


<a name="getuserlistusingpost"></a>
#### 查询列表
```
POST /v1/user/list
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|token|string|
|**Query**|**pageNum**  <br>*必填*|当前页面|integer (int32)|
|**Query**|**pageSize**  <br>*必填*|每页显示条数|integer (int32)|
|**Body**|**userListFind**  <br>*可选*|UserSearchVo|[UserSearchVo](#usersearchvo)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseVo«PageVo«List«User»»»](#dce92fad97f2ee749ba085c3aa545515)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `\*/*`


##### HTTP请求示例

###### 请求 path
```
/v1/user/list?pageNum=0&pageSize=0
```


###### 请求 header
```json
"string"
```


###### 请求 body
```json
{
  "corporationId" : "string",
  "loginName" : "string",
  "name" : "string",
  "roles" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```json
{
  "msg" : "string",
  "msgObj" : [ { } ],
  "response" : {
    "data" : [ {
      "ability" : "string",
      "address" : "string",
      "addressId" : "string",
      "avatar" : "string",
      "corporationId" : "string",
      "id" : 0,
      "loginName" : "string",
      "name" : "string",
      "password" : "string",
      "passwordKey" : "string",
      "phone" : "string",
      "roles" : "string",
      "state" : 0
    } ],
    "pageCount" : 0,
    "pageNum" : 0,
    "pageSize" : 0
  },
  "status" : 0
}
```


<a name="updateusingpost_1"></a>
#### 更新
```
POST /v1/user/update
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|token|string|
|**Body**|**user**  <br>*必填*|UserUpdateVo|[User](#user)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseVo](#responsevo)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `\*/*`


##### HTTP请求示例

###### 请求 path
```
/v1/user/update
```


###### 请求 header
```json
"string"
```


###### 请求 body
```json
{
  "ability" : "string",
  "address" : "string",
  "addressId" : "string",
  "avatar" : "string",
  "corporationId" : "string",
  "id" : 0,
  "loginName" : "string",
  "name" : "string",
  "password" : "string",
  "passwordKey" : "string",
  "phone" : "string",
  "roles" : "string",
  "state" : 0
}
```


##### HTTP响应示例

###### 响应 200
```json
{
  "msg" : "string",
  "msgObj" : [ { } ],
  "response" : "object",
  "status" : 0
}
```




<a name="definitions"></a>
## 定义

<a name="code"></a>
### Code

|名称|说明|类型|
|---|---|---|
|**id**  <br>*可选*|**样例** : `0`|integer (int64)|
|**name**  <br>*可选*|**样例** : `"string"`|string|
|**type**  <br>*可选*|**样例** : `"string"`|string|
|**value**  <br>*可选*|**样例** : `0`|integer (int32)|


<a name="codeaddvo"></a>
### CodeAddVo
*类型* : object


<a name="codesearchvo"></a>
### CodeSearchVo

|名称|说明|类型|
|---|---|---|
|**name**  <br>*可选*|**样例** : `"string"`|string|


<a name="loginrequestvo"></a>
### LoginRequestVo

|名称|说明|类型|
|---|---|---|
|**loginName**  <br>*可选*|登录名  <br>**样例** : `"zw"`|string|
|**password**  <br>*可选*|密码  <br>**样例** : `"MTIzNDU2"`|string|


<a name="ec171edd847026ed605d65393fdab658"></a>
### Map«string,string»
*类型* : < string, string > map


<a name="48fa090ddb892ef18e0a86e7700253af"></a>
### PageVo«List«Code»»

|名称|说明|类型|
|---|---|---|
|**data**  <br>*可选*|**样例** : `[ "[code](#code)" ]`|< [Code](#code) > array|
|**pageCount**  <br>*可选*|**样例** : `0`|integer (int64)|
|**pageNum**  <br>*可选*|**样例** : `0`|integer (int32)|
|**pageSize**  <br>*可选*|**样例** : `0`|integer (int32)|


<a name="68927e613d3816370bf8d183bedd0d8e"></a>
### PageVo«List«User»»

|名称|说明|类型|
|---|---|---|
|**data**  <br>*可选*|**样例** : `[ "[user](#user)" ]`|< [User](#user) > array|
|**pageCount**  <br>*可选*|**样例** : `0`|integer (int64)|
|**pageNum**  <br>*可选*|**样例** : `0`|integer (int32)|
|**pageSize**  <br>*可选*|**样例** : `0`|integer (int32)|


<a name="responsevo"></a>
### ResponseVo

|名称|说明|类型|
|---|---|---|
|**msg**  <br>*可选*|**样例** : `"string"`|string|
|**msgObj**  <br>*可选*|**样例** : `[ "[ec171edd847026ed605d65393fdab658](#ec171edd847026ed605d65393fdab658)" ]`|< [Map«string,string»](#ec171edd847026ed605d65393fdab658) > array|
|**response**  <br>*可选*|**样例** : `"object"`|object|
|**status**  <br>*可选*|**样例** : `0`|integer (int32)|


<a name="6f5f5101612faef3a7257e1f10b3001d"></a>
### ResponseVo«Code»

|名称|说明|类型|
|---|---|---|
|**msg**  <br>*可选*|**样例** : `"string"`|string|
|**msgObj**  <br>*可选*|**样例** : `[ "[ec171edd847026ed605d65393fdab658](#ec171edd847026ed605d65393fdab658)" ]`|< [Map«string,string»](#ec171edd847026ed605d65393fdab658) > array|
|**response**  <br>*可选*|**样例** : `"[code](#code)"`|[Code](#code)|
|**status**  <br>*可选*|**样例** : `0`|integer (int32)|


<a name="ec8bd93eab1fc621a673a21c5be9cd97"></a>
### ResponseVo«PageVo«List«Code»»»

|名称|说明|类型|
|---|---|---|
|**msg**  <br>*可选*|**样例** : `"string"`|string|
|**msgObj**  <br>*可选*|**样例** : `[ "[ec171edd847026ed605d65393fdab658](#ec171edd847026ed605d65393fdab658)" ]`|< [Map«string,string»](#ec171edd847026ed605d65393fdab658) > array|
|**response**  <br>*可选*|**样例** : `"[48fa090ddb892ef18e0a86e7700253af](#48fa090ddb892ef18e0a86e7700253af)"`|[PageVo«List«Code»»](#48fa090ddb892ef18e0a86e7700253af)|
|**status**  <br>*可选*|**样例** : `0`|integer (int32)|


<a name="dce92fad97f2ee749ba085c3aa545515"></a>
### ResponseVo«PageVo«List«User»»»

|名称|说明|类型|
|---|---|---|
|**msg**  <br>*可选*|**样例** : `"string"`|string|
|**msgObj**  <br>*可选*|**样例** : `[ "[ec171edd847026ed605d65393fdab658](#ec171edd847026ed605d65393fdab658)" ]`|< [Map«string,string»](#ec171edd847026ed605d65393fdab658) > array|
|**response**  <br>*可选*|**样例** : `"[68927e613d3816370bf8d183bedd0d8e](#68927e613d3816370bf8d183bedd0d8e)"`|[PageVo«List«User»»](#68927e613d3816370bf8d183bedd0d8e)|
|**status**  <br>*可选*|**样例** : `0`|integer (int32)|


<a name="327bb6dccdc30e665d2934760538fd58"></a>
### ResponseVo«User»

|名称|说明|类型|
|---|---|---|
|**msg**  <br>*可选*|**样例** : `"string"`|string|
|**msgObj**  <br>*可选*|**样例** : `[ "[ec171edd847026ed605d65393fdab658](#ec171edd847026ed605d65393fdab658)" ]`|< [Map«string,string»](#ec171edd847026ed605d65393fdab658) > array|
|**response**  <br>*可选*|**样例** : `"[user](#user)"`|[User](#user)|
|**status**  <br>*可选*|**样例** : `0`|integer (int32)|


<a name="user"></a>
### User

|名称|说明|类型|
|---|---|---|
|**ability**  <br>*可选*|**样例** : `"string"`|string|
|**address**  <br>*可选*|**样例** : `"string"`|string|
|**addressId**  <br>*可选*|**样例** : `"string"`|string|
|**avatar**  <br>*可选*|**样例** : `"string"`|string|
|**corporationId**  <br>*可选*|**样例** : `"string"`|string|
|**id**  <br>*可选*|**样例** : `0`|integer (int64)|
|**loginName**  <br>*可选*|**样例** : `"string"`|string|
|**name**  <br>*可选*|**样例** : `"string"`|string|
|**password**  <br>*可选*|**样例** : `"string"`|string|
|**passwordKey**  <br>*可选*|**样例** : `"string"`|string|
|**phone**  <br>*可选*|**样例** : `"string"`|string|
|**roles**  <br>*可选*|**样例** : `"string"`|string|
|**state**  <br>*可选*|**样例** : `0`|integer (int32)|


<a name="useraddvo"></a>
### UserAddVo

|名称|说明|类型|
|---|---|---|
|**ability**  <br>*可选*|能力，权限  <br>**样例** : `"string"`|string|
|**address**  <br>*可选*|地址  <br>**样例** : `"string"`|string|
|**addressId**  <br>*可选*|地址Id  <br>**样例** : `"string"`|string|
|**avatar**  <br>*可选*|头像  <br>**样例** : `"string"`|string|
|**corporationId**  <br>*可选*|公司名  <br>**样例** : `"string"`|string|
|**loginName**  <br>*可选*|登录名  <br>**样例** : `"string"`|string|
|**name**  <br>*可选*|用户名  <br>**样例** : `"string"`|string|
|**password**  <br>*可选*|密码  <br>**样例** : `"string"`|string|
|**phone**  <br>*可选*|手机号  <br>**样例** : `"string"`|string|
|**roles**  <br>*可选*|角色  <br>**样例** : `"string"`|string|


<a name="usersearchvo"></a>
### UserSearchVo

|名称|说明|类型|
|---|---|---|
|**corporationId**  <br>*可选*|**样例** : `"string"`|string|
|**loginName**  <br>*可选*|**样例** : `"string"`|string|
|**name**  <br>*可选*|**样例** : `"string"`|string|
|**roles**  <br>*可选*|**样例** : `"string"`|string|





