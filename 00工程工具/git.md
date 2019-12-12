## git 版本控制

### 1.git初体验

步骤

```go
1.新建文件夹
2.打开git控制台。输入 git init 初始化  
3.在文件夹下写个文件test.txt，并书写内容保存
4.git add test.txt
5.git commit test.txt -m “第一次”
6.看日志 git log 查看版本号
7.再次更改文件保存。重新 git add test.txt 和 git commit test.txt -m “第二次” ，gitlog
8.回退到上一个版本 git reset --hard head^ 或 git reset --hard commitId1
9.再跳转到第二次修改的文件 git reflog 查看日志，获取第二次版本号 。git reset -- hard  commitId2

```

### 2git 学前知识

![https://github.com/Jackinline/GP/blob/master/00%E5%B7%A5%E7%A8%8B%E5%B7%A5%E5%85%B7/1.png](https://github.com/Jackinline/GP/blob/master/00%E5%B7%A5%E7%A8%8B%E5%B7%A5%E5%85%B7/1.png)

使用git步骤

> 1.下载安装
>
> 2.git config -global user.email/git config-global name
>
> 3.git init 对一个目录进行初始化。.git文件夹就是版本库

 

### 3.git log 和 版本切换

git log  查看日志信息

git log  --pretty = oneline  查看一行打印格式打印日志信息

git reset  -- hard 版本号  ||git reset  -- hard  HEAD^

git reflog 查看所有日志

git status  查看状态

HEAD 最新版本 



> 日志信息
>
> commitId
>
> DATE 日期
>
> Author  作者
>
> commit message

###  4.工作区，暂存区和提交区

在工作区进行修改，正常 git add 文件  git commit 

如果你要丢弃修改

1. 如果内容还在工作区，没有add进暂存区，输入命令 git checkout  test.txt 把test.txt在清空，内容不提交暂存区了，回退到你修改之前

2. 如果你 git  add   进暂存区了，命令 git checkout  test.txt 是不可行，你要先回到提交区的最新版本  git reset HEAD test.txt 再清空 git checkout  test.txt 

### 5.初始分支


![https://github.com/Jackinline/GP/blob/master/00%E5%B7%A5%E7%A8%8B%E5%B7%A5%E5%85%B7/2.png](https://github.com/Jackinline/GP/blob/master/00%E5%B7%A5%E7%A8%8B%E5%B7%A5%E5%85%B7/2.png)

### 6.详解分支



![https://github.com/Jackinline/GP/blob/master/00%E5%B7%A5%E7%A8%8B%E5%B7%A5%E5%85%B7/3.png](https://github.com/Jackinline/GP/blob/master/00%E5%B7%A5%E7%A8%8B%E5%B7%A5%E5%85%B7/3.png)

命令 git checkout -b dev_luo 创建一个分支

git branch 查看所有分支

git checkout master 切换到主分支

git branch -d dev_luo 删除分支  

git branch -D dev_luo 不合并，强制删除

注意：删除分支HEAD指针要不在该分支上，要合并才能删除分支。

### 7.分支合并和解决

> merge 
>
> 两种方式
>
> 在master分支上,合并
>
> git checkout master 切分支
>
> git merge dev_luo 合并分支
>
> git branch -d dev_luo 删除分支
>
> 

冲突：

master合并时发现冲突

冲突文件：

><<<<HEAD
>
>111111111
>
>=============
>
>2222222222222222
>
><<<<<<<<<dev_luo

手动解决

> 111111111
>
> 2222222222222222

手动解决冲突。重新 add,commit冲突文件

### 8 打标签和忽略文件

##### 打标签

git tag v1   v1是自定义标签名代表，v1=最新版本

git tag 查看所有标签

git tag  v1 commitId   v1=commitId 版本

git tag -d v1 删除标签

 ##### 忽略文件

仓库根目录下  .gitignore 文件 去github找到相应忽略.class文件的 .gitignore语法，拷贝过来。然后 git add  .gitignore

### 9.本地仓库 和 远程仓库

每个人在自己电脑开发

思路：把master放在远程仓库

![https://github.com/Jackinline/GP/blob/master/00%E5%B7%A5%E7%A8%8B%E5%B7%A5%E5%85%B7/4.png](https://github.com/Jackinline/GP/blob/master/00%E5%B7%A5%E7%A8%8B%E5%B7%A5%E5%85%B7/4.png)

### 10.GitHub和码云

1）在GItHub 创建一个repository 私有的要钱 删除仓库  仓库主页-->setting -->delete repository 

### 11 操作远程仓库和本地仓库

push pull clone

1.让两者联系

本地仓库中配置

git remote 查看已关联的远程仓库

origin 代表本地仓库 类似HEAD

git remote add origin  远程地址    PS：远程地址就是git的地址

无论是推送还是拉代码需要权限

1）本地生成SSH-Key 在用户名/.ssh下

没有 命令 ssh-keygen -t -rsa  -C "779886365@qq.com"

2）把公钥放到github上

3）

git push -u origin master 将本地仓库的内容推到远程分支 master分支名



新开发分支的做法：

（1）clone操作

git clone git地址

（2）当本地仓库和远程仓库内容不一致，是提交不了的，先git pull，手动解决错误



