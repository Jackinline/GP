
# let命令

###### 本篇是 《ECMAScript 6 入门》阮一峰著的一节阅读笔记 书籍地址： http://es6.ruanyifeng.com/#docs/intro

ECMAScript 和 JavaScript 的关系是，前者是后者的规格，后者是前者的一种实现。日常中，没区别



### 基本用法

`let`命令，用来声明变量。它的用法类似于`var`，但是let命令声明的变量作用域的，var是全局的。所以在日常工作中用let代替var

PS: 写JS代码一定要弄清楚，引用变量所指向的地址

例子

```js
var a = [];
for (let i = 0; i < 10; i++) {
  a[i] = function () {
    console.log(i);
  };
}
a[6](); // 6
//=============================================
var a = [];
for (var i = 0; i < 10; i++) {
  a[i] = function () {
    console.log(i);
  };
}
a[6](); // 10
//前者输出6 后者输出10
前者：
for(let i=0;i<10;i++){}
===>
{
    //for 循环父作用域
    let i=0;
    //let i=1;
    //let i=2;
    //。。。
    {
    //for 循环子作用域 
    //内容
    }
}   
后者：
for(var i=0;i<10;i++){}
===>
var i;
{
   //for 循环父作用域
   // i=0;
   // i=1;
   // i=2;
    {
    //for 循环子作用域
    //内容
    }
} 
```



### 不存在变量提升

什么是变量提升

就是 变量在声明之前使用，值为 undefined.

eg

```javascript
//var
console.log(var1)//undefined
var  var1 =2

//let
console.log(let1)//报错
let let1=2
```



### 暂时性死区

let 命令声明变量绑定块级作用域，不受外在影响。不管父在作用域是否有声明，该块级作用域变量就“听该块变量话“

```javascript
//实例1
var a = 123;
//let 绑定了该作用域
if (true) {
  a = 'abc'; // 报错 ReferenceError
  let a;
}

//实例2
let tmp='213'
if (true) {
  // TDZ开始
  tmp = 'abc'; // 报错 ReferenceError 
  console.log(tmp); // 报错 ReferenceError

  let tmp; // TDZ结束
  console.log(tmp); // undefined

  tmp = 123;
  console.log(tmp); // 123
}
}
```

造成影响

在ES6之前typeof 是个百分之百安全的操作，但ES6之后未必

```javascript
typeof y; // 报错
let y;
typeof x;//"undefined"不报错
```

特例：

```javascript
function bar(x = y, y = 2) {
  return [x, y];
}

bar(); // 报错

==》
let x;
x=y;
let y;
y=2;

```

###  不循序重复声明

```javascript
function func(arg) {
  let arg;
}
func() // 报错

function func(arg) {
  {
    let arg;
  }
}
func() // 不报错
```





